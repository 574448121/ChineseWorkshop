/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.event;

import java.util.List;

import cityofskytcd.chineseworkshop.library.ISeat;
import cityofskytcd.chineseworkshop.library.ISeat.Seat;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import snownee.kiwi.schedule.Scheduler;
import snownee.kiwi.schedule.impl.SimpleGlobalTask;

@Mod.EventBusSubscriber
public class SittingHandler {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getWorld().isRemote) {
            return;
        }

        PlayerEntity player = event.getPlayer();
        if (player instanceof FakePlayer || player.getRidingEntity() != null)
            return;

        ItemStack stack1 = player.getHeldItemMainhand();
        ItemStack stack2 = player.getHeldItemOffhand();
        if (!stack1.isEmpty() || !stack2.isEmpty())
            return;

        World world = event.getWorld();
        BlockPos pos = event.getPos();

        Vector3d vec = new Vector3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);

        double maxDist = 2;
        if ((vec.x - player.getPosX()) * (vec.x - player.getPosX()) + (vec.y - player.getPosY()) * (vec.y - player.getPosY()) + (vec.z - player.getPosZ()) * (vec.z - player.getPosZ()) > maxDist * maxDist)
            return;

        BlockState state = world.getBlockState(pos);

        if (state.getBlock() instanceof ISeat) {
            ISeat iseat = (ISeat) state.getBlock();
            if (!iseat.hasSeat(state, world, pos)) {
                return;
            }
            List<Seat> seats = world.getEntitiesWithinAABB(Seat.class, new AxisAlignedBB(pos, pos.add(1, 1, 1)));

            if (seats.isEmpty()) {
                Vector3d v = iseat.getSeat(state, world, pos);
                Seat seat = new Seat(world, v.add(pos.getX(), pos.getY(), pos.getZ()));
                world.addEntity(seat);
                Scheduler.add(new SimpleGlobalTask(LogicalSide.SERVER, Phase.END, i -> {
                    if (player.isPassenger()) {
                        return true;
                    }
                    if (i > 3) {
                        player.startRiding(seat);
                        return true;
                    }
                    return false;
                }));
                event.setCanceled(true);
                event.setCancellationResult(ActionResultType.SUCCESS);
            }
        }
    }
}
