package cityofskytcd.chineseworkshop.client;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.library.Selections;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
public class ClientHandler {
	public static KeyBinding kbSelect = new KeyBinding(CW.MODID + ".keybind.select", 342, CW.MODID + ".gui.keygroup");

	@SubscribeEvent
	public static void onKeyInput(KeyInputEvent event) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.currentScreen == null && mc.player != null && mc.isGameFocused() && event.getAction() == 1 && kbSelect.isKeyDown()) {
			ItemStack stack = mc.player.getHeldItemMainhand();
			if (!stack.isEmpty() && Selections.contains(stack.getItem())) {
				ConvertScreen screen = new ConvertScreen(stack);
				mc.displayGuiScreen(screen);
			}
		}
	}

	@SubscribeEvent
	public static void drawHudPre(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == ElementType.CROSSHAIRS && Minecraft.getInstance().currentScreen instanceof ConvertScreen) {
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public static void onTooltip(ItemTooltipEvent event) {
		if (event.getItemStack().isEmpty()) {
			return;
		}
		Item item = event.getItemStack().getItem();
		if (Selections.contains(item)) {
			event.getToolTip().add(new StringTextComponent(TextFormatting.GRAY + I18n.format(CW.MODID + ".tip.selectable", I18n.format(kbSelect.getTranslationKey()))));
		}
	}
}
