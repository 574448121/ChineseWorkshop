/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * 小墙类
 */

public class BlockCWSmallFence extends BlockCWFence
{
    public BlockCWSmallFence(String name, Material materialIn, MapColor blockMapColor, float hardness)
    {
        super(name, materialIn, blockMapColor, hardness);

    }

    private static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {
            new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D),
            new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D),
            new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D),
            new AxisAlignedBB(0.25D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D),
            new AxisAlignedBB(0.25D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D),
            new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 0.75D),
            new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 0.75D),
            new AxisAlignedBB(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D),
            new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D),
            new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D) };
    private static final AxisAlignedBB PILLAR_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
    private static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D);
    private static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
    private static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D);
    private static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 0.75D);

    @SuppressWarnings("deprecation")
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean isActualState)
    {
        state = state.getActualState(worldIn, pos);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, PILLAR_AABB);

        if (state.getValue(NORTH).booleanValue())
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTH_AABB);
        }

        if (state.getValue(EAST).booleanValue())
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, EAST_AABB);
        }

        if (state.getValue(SOUTH).booleanValue())
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTH_AABB);
        }

        if (state.getValue(WEST).booleanValue())
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, WEST_AABB);
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = this.getActualState(state, source, pos);
        return BOUNDING_BOXES[getBoundingBoxIdx(state)];
    }

    private static int getBoundingBoxIdx(IBlockState state)
    {
        int i = 0;

        if (state.getValue(NORTH).booleanValue())
        {
            i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }

        if (state.getValue(EAST).booleanValue())
        {
            i |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }

        if (state.getValue(SOUTH).booleanValue())
        {
            i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }

        if (state.getValue(WEST).booleanValue())
        {
            i |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }

        return i;
    }

    @Override
    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        return block == Blocks.BARRIER ? false
                : (!(block == this || block instanceof BlockPane || block instanceof BlockFenceGate)
                        ? (iblockstate.getMaterial().isOpaque() && iblockstate.isFullCube()
                                ? iblockstate.getMaterial() != Material.GOURD
                                : false)
                        : true);
    }
}
