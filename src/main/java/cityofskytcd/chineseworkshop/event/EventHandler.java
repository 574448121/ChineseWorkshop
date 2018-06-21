/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.event;

import java.util.List;
import java.util.Locale;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.google.common.collect.ImmutableList;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.event.ISeat.Seat;
import cityofskytcd.chineseworkshop.library.ItemDefinition;
import cityofskytcd.chineseworkshop.library.Selections;
import cityofskytcd.chineseworkshop.network.CWNetworkChannel;
import cityofskytcd.chineseworkshop.network.WheelMovePacket;
import cityofskytcd.chineseworkshop.proxy.ClientProxy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.resources.I18n;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class EventHandler
{
    private static boolean showGui = false;
    private static boolean animating = false;
    private static float animationTick = 0;
    private static float[] badgeProcess = new float[0];

    public static void init()
    {
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event)
    {
        EntityPlayer player = event.getEntityPlayer();
        if (player.getRidingEntity() != null)
            return;

        World world = event.getWorld();
        BlockPos pos = event.getPos();

        Vec3d vec = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);

        double maxDist = 2;
        if ((vec.x - player.posX) * (vec.x - player.posX) + (vec.y - player.posY) * (vec.y - player.posY)
                + (vec.z - player.posZ) * (vec.z - player.posZ) > maxDist * maxDist)
            return;

        IBlockState state = world.getBlockState(pos);

        ItemStack stack1 = player.getHeldItemMainhand();
        ItemStack stack2 = player.getHeldItemOffhand();
        if (!stack1.isEmpty() || !stack2.isEmpty())
            return;

        if (state.getBlock() instanceof ISeat)
        {
            List<Seat> seats = world.getEntitiesWithinAABB(Seat.class, new AxisAlignedBB(pos, pos.add(1, 1, 1)));

            if (seats.isEmpty())
            {
                Vec3d v = ((ISeat) state.getBlock()).getSeat(state);
                Seat seat = new Seat(world, v.addVector(pos.getX(), pos.getY(), pos.getZ()));
                world.spawnEntity(seat);
                event.getEntityPlayer().startRiding(seat);
            }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onKeyInput(@SuppressWarnings("unused") KeyInputEvent event)
    {
        Minecraft mc = Minecraft.getMinecraft();

        if (!showGui && mc.inGameHasFocus)
        {
            if (ClientProxy.kbSelect.isKeyDown() && Selections.findSelection(mc.player.getHeldItemMainhand()) != null)
            {
                showGui = true;
                animating = true;
            }

        }
        else if (showGui && !ClientProxy.kbSelect.isKeyDown())
        {
            showGui = false;
            animating = true;
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onMouseInput(MouseEvent event)
    {
        if (event.isCanceled())
            return;

        if (showGui && event.getDwheel() != 0)
        {
            if (!Minecraft.getMinecraft().inGameHasFocus)
            {
                showGui = false;
                animating = false;
                animationTick = 0;
                return;
            }
            EntityPlayer player = Minecraft.getMinecraft().player;
            ItemStack held = player.getHeldItemMainhand();
            if (held.isEmpty())
            {
                showGui = false;
                animating = false;
                animationTick = 0;
                return;
            }
            ImmutableList<ItemDefinition> selection = Selections.findSelection(held);
            if (selection != null)
            {
                ItemDefinition definition = ItemDefinition.of(held);
                for (int i = 0; i < selection.size(); i++)
                {
                    if (definition.equals(selection.get(i)))
                    {
                        i = (i + selection.size() + ((event.getDwheel() < 0) ? 1 : -1)) % selection.size();
                        CWNetworkChannel.INSTANCE.sendToServer(new WheelMovePacket(i));
                        ItemStack stack = selection.get(i).getItemStack();
                        stack.setCount(held.getCount());
                        stack.setTagCompound(held.getTagCompound());
                        player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, stack);
                        break;
                    }
                }
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void drawHudPost(RenderGameOverlayEvent.Post event)
    {
        if ((showGui || animating) && event.getType() == ElementType.HOTBAR)
        {
            Minecraft mc = Minecraft.getMinecraft();
            ItemStack held = mc.player.getHeldItemMainhand();
            if (held.isEmpty())
            {
                return;
            }
            ImmutableList<ItemDefinition> selection = Selections.findSelection(held);
            if (selection == null)
            {
                return;
            }

            ScaledResolution res = event.getResolution();
            float xStart = res.getScaledWidth() / 2;
            float yStart = res.getScaledHeight() / 2;

            GlStateManager.pushMatrix();
            GlStateManager.translate(xStart, yStart, 0);
            if (animating)
            {
                animationTick += mc.getRenderPartialTicks() * (showGui ? 1 : -1);
                animationTick = MathHelper.clamp(animationTick, 0, 9);
                if (animationTick == 9)
                {
                    animating = false;
                }
                else if (!showGui && animationTick < 0.01)
                {
                    animating = false;
                    GlStateManager.popMatrix();
                    return;
                }
                else
                {
                    double scale = Math.sqrt(animationTick) / 3;
                    GlStateManager.scale(scale, scale, scale);
                }
            }

            drawBadge(mc, held, 0, true);

            if (selection.size() < 2)
            {
                CrashReport crash = CrashReport.makeCrashReport(new Exception(), "Number of options smaller than 2");
                mc.crashed(crash);
            }

            float degPer = 360F / selection.size();
            boolean matched = false;
            if (selection.size() != badgeProcess.length)
            {
                badgeProcess = new float[selection.size()];
            }
            for (int i = 0; i < selection.size(); i++)
            {
                ItemDefinition definition = selection.get(i);
                GlStateManager.pushMatrix();
                float rad = (float) (((i + 0.5F) * degPer) / 180F * Math.PI);
                GlStateManager.translate(Math.cos(rad) * 60, Math.sin(rad) * 60, 0);
                GlStateManager.scale(0.618, 0.618, 0.618);

                boolean match = !matched && definition.equals(ItemDefinition.of(held));
                matched = matched || match;
                badgeProcess[i] += match ? mc.getRenderPartialTicks() : -mc.getRenderPartialTicks();
                badgeProcess[i] = MathHelper.clamp(badgeProcess[i], 0, 10);
                drawBadge(mc, definition.getItemStack(), badgeProcess[i], false);
                GlStateManager.popMatrix();
            }
            if (!matched)
            {
                CrashReport crash = CrashReport.makeCrashReport(new Exception(), "Options do not contain item itself");
                mc.crashed(crash);
            }

            GlStateManager.popMatrix();
        }
    }

    public static void drawCenteredString(FontRenderer fontRendererIn, String text, float x, float y)
    {
        fontRendererIn.drawStringWithShadow(text, x - fontRendererIn.getStringWidth(text) / 2, y, 0xFFFFFF);
    }

    public static void drawBadge(Minecraft mc, ItemStack stack, float color, boolean rotation)
    {
        GlStateManager.enableBlend();
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        GlStateManager.disableTexture2D();
        color = (float) (Math.sin((color - 5) / 5F) + 0.5F);
        GlStateManager.color(color * 0.1F, color * 0.5F, color * 0.9F, 0.3F);
        GL11.glBegin(GL11.GL_TRIANGLE_FAN);
        GL11.glVertex2f(0, -30);
        GL11.glVertex2f(-26, -15);
        GL11.glVertex2f(-26, 15);
        GL11.glVertex2f(0, 30);
        GL11.glVertex2f(26, 15);
        GL11.glVertex2f(26, -15);
        GL11.glEnd();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.shadeModel(GL11.GL_FLAT);

        drawCenteredString(mc.fontRenderer, stack.getDisplayName(), 0, 8);

        GlStateManager.pushMatrix();
        GlStateManager.scale(1.5, 1.5, 1.5);

        // TODO: Directly render
        IBakedModel bakedModel = mc.getRenderItem().getItemModelWithOverrides(
                stack,
                (World) null,
                (EntityLivingBase) null);
        if (rotation && bakedModel.isGui3d())
        {
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.translate(0, -5, 150);
            GlStateManager.scale(1.0F, -1.0F, 1.0F);
            GlStateManager.scale(10, 10, 10);
            GlStateManager.alphaFunc(516, 0.1F);
            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableAlpha();
            GlStateManager.rotate(30F, 1F, 0, 0F);
            GlStateManager.rotate(Minecraft.getSystemTime() / 15F, 0, 1, 0F);
            RenderHelper.enableStandardItemLighting();
            mc.getRenderItem().renderItem(stack, TransformType.NONE);
            GlStateManager.disableAlpha();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
        }
        else
        {
            RenderHelper.enableGUIStandardItemLighting();
            mc.getRenderItem().renderItemAndEffectIntoGUI(stack, -8, -12);
        }

        RenderHelper.disableStandardItemLighting();
        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void drawHudPre(RenderGameOverlayEvent.Pre event)
    {
        if ((showGui || animating) && event.getType() == ElementType.CROSSHAIRS)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onTooltip(ItemTooltipEvent event)
    {
        if (Selections.findSelection(ItemDefinition.of(event.getItemStack())) != null)
        {
            String key;
            if (ClientProxy.kbSelect.getKeyCode() == Keyboard.KEY_LMENU)
            {
                String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
                if (os.startsWith("win"))
                {
                    key = "LAlt";
                }
                else if (os.startsWith("mac"))
                {
                    key = "Option";
                }
                else
                {
                    key = ClientProxy.kbSelect.getDisplayName();
                }
            }
            else
            {
                key = ClientProxy.kbSelect.getDisplayName();
            }
            event.getToolTip().add(I18n.format(CW.MODID + ".tip.selectable", key));
        }
    }
}
