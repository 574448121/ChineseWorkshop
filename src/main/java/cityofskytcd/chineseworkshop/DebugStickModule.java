package cityofskytcd.chineseworkshop;

import cityofskytcd.chineseworkshop.item.SafeDebugStickItem;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import snownee.kiwi.AbstractModule;
import snownee.kiwi.KiwiModule;

@KiwiModule("debug_stick")
@KiwiModule.Group("tools")
@KiwiModule.Subscriber
@KiwiModule.Optional
public class DebugStickModule extends AbstractModule {
	public static final SafeDebugStickItem SAFE_DEBUG_STICK = new SafeDebugStickItem(itemProp());

	@SubscribeEvent
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		if (event.getItemStack().getItem() == SAFE_DEBUG_STICK) {
			event.setCanceled(true);
			if (event.getPlayer().getCooldownTracker().getCooldown(SAFE_DEBUG_STICK, 1) > 0) {
				return;
			}
			if (!event.getWorld().isRemote) {
				World worldIn = event.getWorld();
				BlockPos pos = event.getPos();
				BlockState state = event.getWorld().getBlockState(pos);
				SAFE_DEBUG_STICK.handleClick(event.getPlayer(), state, worldIn, pos, false, event.getItemStack());
			}
			event.getPlayer().getCooldownTracker().setCooldown(SAFE_DEBUG_STICK, 5);
		}
	}
}
