package cityofskytcd.chineseworkshop.client;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import cityofskytcd.chineseworkshop.library.Selection;
import cityofskytcd.chineseworkshop.library.Selections;
import cityofskytcd.chineseworkshop.network.ConvertItemPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiScreenEvent.BackgroundDrawnEvent;
import net.minecraftforge.common.MinecraftForge;

@OnlyIn(Dist.CLIENT)
public class ConvertScreen extends Screen {

    private static final ITextComponent TITLE = new TranslationTextComponent("chineseworkshop.gui.convert");

    private final ItemStack stack;
    private StackButton selectedButton;
    private float alpha;
    private boolean closing;

    protected ConvertScreen(ItemStack stack) {
        super(TITLE);
        this.stack = stack;
    }

    @Override
    protected void init() {
        if (stack.isEmpty()) {
            return;
        }
        Selection selection = Selections.find(stack);
        if (selection == null) {
            return;
        }

        int xStart = minecraft.getMainWindow().getScaledWidth() / 2 - 30;
        int yStart = minecraft.getMainWindow().getScaledHeight() / 2 - 90;
        int size = selection.size();
        for (int i = 0; i < size; i++) {
            int j = i;
            ItemStack substack = new ItemStack(selection.get(i));
            substack.setTag(stack.getTag());
            StackButton button = new StackButton(xStart + i % 5 * 45, yStart + i / 5 * 45, substack, btn -> {
                new ConvertItemPacket(j).send();
                onClose();
            });
            if (selectedButton == null) {
                button.selected = substack.getItem() == stack.getItem();
                if (button.selected) {
                    selectedButton = button;
                }
            }
            addButton(button);
        }
        if (alpha == 0 && selectedButton != null) {
            double d0 = (selectedButton.x + 35) * (double) minecraft.getMainWindow().getWidth() / minecraft.getMainWindow().getScaledWidth();
            double d1 = (selectedButton.y + 30) * (double) minecraft.getMainWindow().getHeight() / minecraft.getMainWindow().getScaledHeight();
            GLFW.glfwSetCursorPos(minecraft.getMainWindow().getHandle(), d0, d1);
        }
    }

    @Override
    public void tick() {
        ItemStack held = minecraft.player.getHeldItemMainhand();
        if (stack.isEmpty() || held.isEmpty() || !ItemStack.areItemStacksEqual(stack, held)) {
            onClose();
        }
    }

    @Override
    public void render(MatrixStack matrix, int mouseX, int mouseY, float pTicks) {
        alpha += closing ? -pTicks * .4f : pTicks * .2f;
        if (closing && alpha <= 0) {
            Minecraft.getInstance().displayGuiScreen(null);
            return;
        }
        alpha = MathHelper.clamp(alpha, 0, 1);

        this.renderBackground(matrix);
        if (alpha < 0.5f) {
            return;
        }
        for (int i = 0; i < this.buttons.size(); ++i) {
            Widget widget = this.buttons.get(i);
            widget.render(matrix, mouseX, mouseY, pTicks);
            if (widget.isHovered() && widget.getClass() == StackButton.class) {
                selectedButton = (StackButton) widget;
            }
        }
        int x = minecraft.getMainWindow().getScaledWidth() / 2 - 150;
        int y = minecraft.getMainWindow().getScaledHeight() / 2 - 75;
        ItemStack stackMain = selectedButton == null ? stack : selectedButton.stack;
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        RenderSystem.pushMatrix();
        RenderSystem.translatef(x, y, 0);
        RenderSystem.scalef(5F, 5F, 5F);
        RenderSystem.enableBlend();
        RenderSystem.color4f(1, 1, 1, 0.1f);
        itemRenderer.renderItemIntoGUI(stackMain, 0, 0);
        RenderSystem.popMatrix();
        x += 42;
        y += 42 + 50;
        drawCenteredString(matrix, font, stackMain.getDisplayName().getString(), x, y, 0xFFFFFFFF);
    }

    @Override
    public void renderBackground(MatrixStack matrix, int p_renderBackground_1_) {
        int textColor1 = (int) (alpha * 0xA0) << 24;
        int textColor2 = (int) (alpha * 0x70) << 24;
        this.fillGradient(matrix, 0, 0, width, (int) (height * 0.125), textColor1, textColor2);
        this.fillGradient(matrix, 0, (int) (height * 0.125), width, (int) (height * 0.875), textColor2, textColor2);
        this.fillGradient(matrix, 0, (int) (height * 0.875), width, height, textColor2, textColor1);
        MinecraftForge.EVENT_BUS.post(new BackgroundDrawnEvent(this, matrix));
    }

    @Override
    public void onClose() {
        closing = true;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
