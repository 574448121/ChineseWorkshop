package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.library.ISeat;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorldReader;

public class BenchBlock extends Direction2Block implements ISeat
{

    public BenchBlock(Properties builder, boolean retexture)
    {
        super(builder, makeCuboidShape(1, 0, 3, 15, 10, 13), retexture);
    }

    @Override
    public Vec3d getSeat(BlockState state, IWorldReader world, BlockPos pos)
    {
        return new Vec3d(0.5, 0.4, 0.5);
    }

}
