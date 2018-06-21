/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import java.util.List;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCWUpperDoorFrame extends BlockCWFence
{
    public BlockCWUpperDoorFrame(String name, Material materialIn, MapColor blockMapColor, float hardness)
    {
        super(name, materialIn, blockMapColor, hardness);
    }

    protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {
            new AxisAlignedBB(0.125D, 0.5D, 0.125D, 0.875D, 1.0D, 0.875D),
            new AxisAlignedBB(0.125D, 0.5D, 0.125D, 0.875D, 1.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.5D, 0.125D, 0.875D, 1.0D, 0.875D),
            new AxisAlignedBB(0.0D, 0.5D, 0.125D, 0.875D, 1.0D, 1.0D),
            new AxisAlignedBB(0.125D, 0.5D, 0.0D, 0.875D, 1.0D, 0.875D),
            new AxisAlignedBB(0.125D, 0.5D, 0.0D, 0.875D, 1.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.875D, 1.0D, 0.875D),
            new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.875D, 1.0D, 1.0D),
            new AxisAlignedBB(0.125D, 0.5D, 0.125D, 1.0D, 1.0D, 0.875D),
            new AxisAlignedBB(0.125D, 0.5D, 0.125D, 1.0D, 1.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.5D, 0.125D, 1.0D, 1.0D, 0.875D),
            new AxisAlignedBB(0.0D, 0.5D, 0.125D, 1.0D, 1.0D, 1.0D),
            new AxisAlignedBB(0.125D, 0.5D, 0.0D, 1.0D, 1.0D, 0.875D),
            new AxisAlignedBB(0.125D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.875D),
            new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D) };
    public static final AxisAlignedBB PILLAR_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
    public static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D);
    public static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
    public static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D);
    public static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 0.75D);

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
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return face == EnumFacing.UP ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
}
