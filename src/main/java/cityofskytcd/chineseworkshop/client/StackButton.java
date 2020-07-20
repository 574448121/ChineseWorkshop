package cityofskytcd.chineseworkshop.client;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class StackButton extends Button {

    public final ItemStack stack;
    public boolean selected;
    private float hoverProgress;

    public StackButton(int x, int y, ItemStack stack, IPressable onPress) {
        super(x, y, 40, 40, stack.getDisplayName().getFormattedText(), onPress);
        this.stack = stack;
        alpha = 0;
    }

    @Override
    public void renderButton(int mouseX, int mouseY, float pTicks) {
        alpha = Math.min(alpha + pTicks * 0.2F, 1);
        int y = (int) (this.y + 15 - 15 * MathHelper.sin(alpha));
        AbstractGui.fill(x, y, x + width, y + height, 0xAA222222);
        hoverProgress += isHovered ? pTicks * .2f : -pTicks * .2f;
        hoverProgress = MathHelper.clamp(hoverProgress, .4f, 1);
        int linecolor = 0xFFFFFF | (int) (hoverProgress * 0xFF) << 24;
        AbstractGui.fill(x, y, x + 1, y + height, linecolor);
        AbstractGui.fill(x + width - 1, y, x + width, y + height, linecolor);
        AbstractGui.fill(x + 1, y, x + width - 1, y + 1, linecolor);
        AbstractGui.fill(x + 1, y + height - 1, x + width - 1, y + height, linecolor);
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        RenderSystem.pushMatrix();
        RenderSystem.translatef(x + 8, y + 8, 0);
        RenderSystem.scalef(1.5F, 1.5F, 1.5F);
        itemRenderer.renderItemIntoGUI(stack, 0, 0);
        RenderSystem.popMatrix();
    }
}
