/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * 斗栱类
 */

public class BlockCWDougong extends BlockCWTFace
{

    public BlockCWDougong(String name, Material materialIn, float hardness)
    {
        super(name, materialIn, hardness);
    }

    // private static final AxisAlignedBB BS_NORTH_AABB = new AxisAlignedBB(1.0D,
    // 1.0D, 1.0D, 0.0D, 0.0D, 0.7D);
    // private static final AxisAlignedBB BS_SOUTH_AABB = new AxisAlignedBB(1.0D,
    // 1.0D, 0.3D, 0.0D, 0.0D, 0.0D);
    // private static final AxisAlignedBB BS_WEST_AABB = new AxisAlignedBB(1.0D,
    // 1.0D, 1.0D, 0.7D, 0.0D, 0.0D);
    // private static final AxisAlignedBB BS_EAST_AABB = new AxisAlignedBB(0.3D,
    // 1.0D, 1.0D, 0.0D, 0.0D, 0.0D);

    @SuppressWarnings("deprecation")
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return super.getBoundingBox(state, source, pos);
        // switch (state.getValue(FACING))
        // {
        // case EAST:
        // return BS_EAST_AABB;
        // case WEST:
        // return BS_WEST_AABB;
        // case SOUTH:
        // return BS_SOUTH_AABB;
        // case NORTH:
        // return BS_NORTH_AABB;
        // default:
        // return null;
        // }
    }
}
