package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.library.ISeat;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorldReader;

public class ChairBlock extends RoofTileBlock implements ISeat
{
    public ChairBlock(Properties builder)
    {
        super(builder, false);
    }

    @Override
    public Vec3d getSeat(BlockState state, IWorldReader world, BlockPos pos)
    {
        return new Vec3d(0.5, 0.4, 0.5);
    }
}
