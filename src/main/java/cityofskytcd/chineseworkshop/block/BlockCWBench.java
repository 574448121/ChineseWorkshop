/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.event.ISeat;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;

public class BlockCWBench extends BlockCWTFace2D implements ISeat
{

    public BlockCWBench(String name, Material materialIn, float hardness)
    {
        super(name, materialIn, hardness);
    }

    private static final AxisAlignedBB BS_SOUTH_AABB = new AxisAlignedBB(1.0D, 0.0D, 0.1875D, 0.0D, 0.625D, 0.8125D);
    private static final AxisAlignedBB BS_EAST_AABB = new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 0.625D, 1.0D);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch (state.getValue(FACING))
        {
        case EAST_WEST:
            return BS_EAST_AABB;
        case SOUTH_NORTH:
            return BS_SOUTH_AABB;
        default:
            return null;
        }
    }

    @Override
    public Vec3d getSeat(IBlockState state)
    {
        return new Vec3d(0.5, 0.4, 0.5);
    }

}
