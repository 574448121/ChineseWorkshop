package cityofskytcd.chineseworkshop.event;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.library.Selections;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class HudHandler
{
    public static KeyBinding kbSelect = new KeyBinding(CW.MODID + ".keybind.select", 342, CW.MODID + ".gui.keygroup");
    protected static boolean showGui = false;
    protected static boolean animating = false;
    //protected static float animationTick = 0;
    //private static float[] badgeProcess = new float[0];
    private static boolean[] keyMap = new boolean[8];

    @SubscribeEvent
    public static void onKeyInput(KeyInputEvent event)
    {
        Minecraft mc = Minecraft.getInstance();
        if (event.getKey() >= 340 && event.getKey() <= 347 && event.getAction() < 2)
        {
            keyMap[event.getKey() - 340] = event.getAction() == 1;
        }
        if (mc.currentScreen == null && mc.player != null && mc.isGameFocused() && kbSelect.isKeyDown())
        {
            int code = kbSelect.getKey().getKeyCode();
            boolean f = code < 340 || code > 347;
            for (boolean pressed : keyMap)
            {
                if (pressed)
                {
                    if (f)
                    {
                        return;
                    }
                    else
                    {
                        f = true;
                    }
                }
            }
            ItemStack stack = mc.player.getHeldItemMainhand();
            if (!stack.isEmpty() && Selections.contains(stack.getItem()))
            {
                showGui = true;
                animating = true;
                mc.displayGuiScreen(new SelectScreen());
            }
        }
        //        else if (showGui && !kbSelect.isKeyDown())
        //        {
        //            showGui = false;
        //            animating = true;
        //        }
    }

    //    @SubscribeEvent
    //    public static void onMouseInput(GuiScreenEvent.MouseScrollEvent.Pre event)
    //    {
    //        if (showGui && event.getScrollDelta() != 0)
    //        {
    //            if (!Minecraft.getInstance().isGameFocused())
    //            {
    //                showGui = false;
    //                animating = false;
    //                animationTick = 0;
    //                return;
    //            }
    //            PlayerEntity player = Minecraft.getInstance().player;
    //            ItemStack held = player.getHeldItemMainhand();
    //            if (held.isEmpty())
    //            {
    //                showGui = false;
    //                animating = false;
    //                animationTick = 0;
    //                return;
    //            }
    //            Selection selection = Selections.find(held);
    //            if (selection != null)
    //            {
    //                Item item = held.getItem();
    //                for (int i = 0; i < selection.size(); i++)
    //                {
    //                    if (item.equals(selection.get(i)))
    //                    {
    //                        i = (i + selection.size() + ((event.getScrollDelta() < 0) ? 1 : -1)) % selection.size();
    //                        new WheelMovePacket(i).send();
    //                        ItemStack stack = new ItemStack(selection.get(i));
    //                        stack.setCount(held.getCount());
    //                        stack.setTag(held.getTag());
    //                        player.setItemStackToSlot(EquipmentSlotType.MAINHAND, stack);
    //                        break;
    //                    }
    //                }
    //                event.setCanceled(true);
    //            }
    //        }
    //    }
    //
    //    @SubscribeEvent
    //    public static void drawHudPost(RenderGameOverlayEvent.Post event)
    //    {
    //        if ((showGui || animating) && event.getType() == ElementType.HOTBAR)
    //        {
    //            Minecraft mc = Minecraft.getInstance();
    //            ItemStack held = mc.player.getHeldItemMainhand();
    //            if (held.isEmpty())
    //            {
    //                return;
    //            }
    //            Selection selection = Selections.find(held);
    //            if (selection == null)
    //            {
    //                return;
    //            }
    //
    //            float xStart = mc.mainWindow.getScaledWidth() / 2;
    //            float yStart = mc.mainWindow.getScaledHeight() / 2;
    //
    //            GlStateManager.pushMatrix();
    //            GlStateManager.translatef(xStart, yStart, 0);
    //            if (animating)
    //            {
    //                animationTick += mc.getRenderPartialTicks() * (showGui ? 1 : -1);
    //                animationTick = MathHelper.clamp(animationTick, 0, 9);
    //                if (animationTick == 9)
    //                {
    //                    animating = false;
    //                }
    //                else if (!showGui && animationTick < 0.01)
    //                {
    //                    animating = false;
    //                    GlStateManager.popMatrix();
    //                    return;
    //                }
    //                else
    //                {
    //                    double scale = Math.sqrt(animationTick) / 3;
    //                    GlStateManager.scaled(scale, scale, scale);
    //                }
    //            }
    //
    //            drawBadge(mc, held, 0, true);
    //
    //            if (selection.size() < 2)
    //            {
    //                CrashReport crash = CrashReport.makeCrashReport(new Exception(), "Number of options smaller than 2");
    //                mc.crashed(crash);
    //            }
    //
    //            float degPer = 360F / selection.size();
    //            boolean matched = false;
    //            if (selection.size() != badgeProcess.length)
    //            {
    //                badgeProcess = new float[selection.size()];
    //            }
    //            for (int i = 0; i < selection.size(); i++)
    //            {
    //                Item item = selection.get(i);
    //                GlStateManager.pushMatrix();
    //                float rad = (float) (((i + (selection.size() % 2 == 0 ? 0.5F : 0)) * degPer + 180) / 180F * Math.PI);
    //                GlStateManager.translated(Math.sin(rad) * 60, Math.cos(rad) * 60, 0);
    //                GlStateManager.scaled(0.618, 0.618, 0.618);
    //
    //                boolean match = !matched && item == held.getItem();
    //                matched = matched || match;
    //                badgeProcess[i] += match ? mc.getRenderPartialTicks() : -mc.getRenderPartialTicks();
    //                badgeProcess[i] = MathHelper.clamp(badgeProcess[i], 0, 10);
    //                drawBadge(mc, new ItemStack(item), badgeProcess[i], false);
    //                GlStateManager.popMatrix();
    //            }
    //            if (!matched)
    //            {
    //                CrashReport crash = CrashReport.makeCrashReport(new Exception(), "Options do not contain item itself");
    //                mc.crashed(crash);
    //            }
    //
    //            GlStateManager.popMatrix();
    //        }
    //    }

    private static void drawCenteredString(FontRenderer fontRendererIn, String text, float x, float y)
    {
        fontRendererIn.drawStringWithShadow(text, x - fontRendererIn.getStringWidth(text) / 2, y, 0xFFFFFF);
    }

    protected static void drawBadge(Minecraft mc, ItemStack stack, float color, boolean rotation)
    {
        GlStateManager.enableBlend();
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        GlStateManager.disableTexture();
        color = (float) (Math.sin((color - 5) / 5F) + 0.5F);
        GlStateManager.color4f(color * 0.1F, color * 0.5F, color * 0.9F, 0.3F);
        GL11.glBegin(GL11.GL_TRIANGLE_FAN);
        GL11.glVertex2f(0, -30);
        GL11.glVertex2f(-26, -15);
        GL11.glVertex2f(-26, 15);
        GL11.glVertex2f(0, 30);
        GL11.glVertex2f(26, 15);
        GL11.glVertex2f(26, -15);
        GL11.glEnd();
        GlStateManager.enableTexture();
        GlStateManager.disableBlend();
        GlStateManager.shadeModel(GL11.GL_FLAT);

        drawCenteredString(mc.fontRenderer, stack.getDisplayName().getFormattedText(), 0, 8);

        GlStateManager.pushMatrix();
        GlStateManager.scaled(1.5, 1.5, 1.5);

        // TODO: Directly render
        IBakedModel bakedModel = mc.getItemRenderer().getModelWithOverrides(stack, null, null);
        if (rotation && bakedModel.isGui3d())
        {
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.translatef(0, -5, 150);
            GlStateManager.scalef(10, -10, 10);
            GlStateManager.alphaFunc(516, 0.1F);
            GlStateManager.pushMatrix();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableAlphaTest();
            GlStateManager.rotatef(30F, 1F, 0, 0F);
            GlStateManager.rotatef(Util.milliTime() % 3600 / 10, 0, 1, 0F);
            RenderHelper.enableStandardItemLighting();
            mc.getItemRenderer().renderItem(stack, TransformType.NONE);
            GlStateManager.disableAlphaTest();
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
        }
        else
        {
            RenderHelper.enableGUIStandardItemLighting();
            mc.getItemRenderer().renderItemAndEffectIntoGUI(null, stack, -8, -12);
        }

        RenderHelper.disableStandardItemLighting();
        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public static void drawHudPre(RenderGameOverlayEvent.Pre event)
    {
        if ((showGui || animating) && event.getType() == ElementType.CROSSHAIRS)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event)
    {
        if (event.getItemStack().isEmpty())
        {
            return;
        }
        Item item = event.getItemStack().getItem();
        if (Selections.contains(item))
        {
            event.getToolTip().add(new StringTextComponent(TextFormatting.GRAY + I18n.format(CW.MODID + ".tip.selectable", kbSelect.getLocalizedName())));
        }
    }
}
