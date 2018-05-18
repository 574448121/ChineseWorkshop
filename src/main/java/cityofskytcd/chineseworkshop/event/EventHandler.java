/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.event;

import java.util.List;

import cityofskytcd.chineseworkshop.event.ISeat.Seat;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber()
public class EventHandler
{
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
        if ((vec.xCoord - player.posX) * (vec.xCoord - player.posX)
                + (vec.yCoord - player.posY) * (vec.yCoord - player.posY)
                + (vec.zCoord - player.posZ) * (vec.zCoord - player.posZ) > maxDist * maxDist)
            return;

        IBlockState state = world.getBlockState(pos);

        ItemStack stack1 = player.getHeldItemMainhand();
        ItemStack stack2 = player.getHeldItemOffhand();
        if (stack1 != null || stack2 != null)
            return;

        if (state.getBlock() instanceof ISeat)
        {
            List<Seat> seats = world.getEntitiesWithinAABB(Seat.class, new AxisAlignedBB(pos, pos.add(1, 1, 1)));

            if (seats.isEmpty())
            {
                Vec3d v = ((ISeat) state.getBlock()).getSeat(state);
                Seat seat = new Seat(world, v.addVector(pos.getX(), pos.getY(), pos.getZ()));
                world.spawnEntityInWorld(seat);
                event.getEntityPlayer().startRiding(seat);
            }
        }
    }
}
