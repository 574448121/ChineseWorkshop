package cityofskytcd.chineseworkshop.event;

import com.mojang.blaze3d.platform.GlStateManager;

import cityofskytcd.chineseworkshop.library.Selection;
import cityofskytcd.chineseworkshop.library.Selections;
import cityofskytcd.chineseworkshop.network.WheelMovePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;

public class SelectScreen extends Screen
{
    private static float animationTick = 0;
    private static float[] badgeProcess = new float[0];

    protected SelectScreen()
    {
        super(new StringTextComponent("select"));
        System.out.println("hi");
    }

    @Override
    protected void init()
    {
        if (!Minecraft.IS_RUNNING_ON_MAC)
        {
            KeyBinding.updateKeyBindState();
        }

        Minecraft mc = Minecraft.getInstance();
        InputMappings.func_216504_a(this.minecraft.mainWindow.getHandle(), 212995, mc.mainWindow.getWidth() / 2, mc.mainWindow.getHeight() / 2);
    }

    @Override
    public boolean isPauseScreen()
    {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc()
    {
        return false;
    }

    @Override
    public void onClose()
    {
        HudHandler.showGui = false;
        super.onClose();
    }

    @Override
    public void render(int x, int y, float pTicks)
    {
        System.out.println(animationTick);
        System.out.println(HudHandler.kbSelect.isKeyDown());
        if (HudHandler.showGui && !HudHandler.kbSelect.isKeyDown())
        {
            HudHandler.showGui = false;
            HudHandler.animating = true;
        }
        if (HudHandler.showGui || HudHandler.animating)
        {
            Minecraft mc = Minecraft.getInstance();
            ItemStack held = mc.player.getHeldItemMainhand();
            if (held.isEmpty())
            {
                return;
            }
            Selection selection = Selections.find(held);
            if (selection == null)
            {
                return;
            }

            float xStart = mc.mainWindow.getScaledWidth() / 2;
            float yStart = mc.mainWindow.getScaledHeight() / 2;

            GlStateManager.pushMatrix();
            GlStateManager.translatef(xStart, yStart, 0);
            if (HudHandler.animating)
            {
                animationTick += pTicks * (HudHandler.showGui ? 1 : -2);
                animationTick = MathHelper.clamp(animationTick, 0, 9);
                if (animationTick == 9)
                {
                    HudHandler.animating = false;
                }
                else if (!HudHandler.showGui && animationTick < 0.01)
                {
                    HudHandler.animating = false;
                    GlStateManager.popMatrix();
                    return;
                }
                else
                {
                    double scale = Math.sqrt(animationTick) / 3;
                    GlStateManager.scaled(scale, scale, scale);
                }
            }

            HudHandler.drawBadge(mc, held, 0, true);

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
                Item item = selection.get(i);
                GlStateManager.pushMatrix();
                float rad = (float) (((i + (selection.size() % 2 == 0 ? 0.5F : 0)) * degPer + 180) / 180F * Math.PI);
                GlStateManager.translated(Math.sin(rad) * 60, Math.cos(rad) * 60, 0);
                GlStateManager.scaled(0.618, 0.618, 0.618);

                boolean match = !matched && item == held.getItem();
                matched = matched || match;
                badgeProcess[i] += match ? mc.getRenderPartialTicks() : -mc.getRenderPartialTicks();
                badgeProcess[i] = MathHelper.clamp(badgeProcess[i], 0, 10);
                HudHandler.drawBadge(mc, new ItemStack(item), badgeProcess[i], false);
                GlStateManager.popMatrix();
            }
            if (!matched)
            {
                CrashReport crash = CrashReport.makeCrashReport(new Exception(), "Options do not contain item itself");
                mc.crashed(crash);
            }

            GlStateManager.popMatrix();
        }
        else
        {
            onClose();
        }
    }

    @Override
    public boolean mouseScrolled(double x, double y, double delta)
    {
        if (delta == 0)
        {
            return true;
        }
        PlayerEntity player = Minecraft.getInstance().player;
        ItemStack held = player.getHeldItemMainhand();
        if (held.isEmpty())
        {
            onClose();
            return true;
        }
        Selection selection = Selections.find(held);
        if (selection != null)
        {
            Item item = held.getItem();
            for (int i = 0; i < selection.size(); i++)
            {
                if (item.equals(selection.get(i)))
                {
                    i = (i + selection.size() + ((delta < 0) ? -1 : 1)) % selection.size();
                    new WheelMovePacket(i).send();
                    ItemStack stack = new ItemStack(selection.get(i));
                    stack.setCount(held.getCount());
                    stack.setTag(held.getTag());
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, stack);
                    break;
                }
            }
        }
        return true;
    }
}
