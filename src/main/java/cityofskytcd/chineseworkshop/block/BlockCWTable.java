/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCWTable extends BlockCWT
{
    private static final AxisAlignedBB PLATE_AABB = new AxisAlignedBB(0, 0.875D, 0, 1, 1, 1);
    private static final AxisAlignedBB NW_AABB = new AxisAlignedBB(0.1875D, 0, 0.1875D, 0.3125D, 0.875D, 0.3125D);
    private static final AxisAlignedBB SW_AABB = new AxisAlignedBB(0.1875D, 0, 0.6875D, 0.3125D, 0.875D, 0.8125D);
    private static final AxisAlignedBB SE_AABB = new AxisAlignedBB(0.6875D, 0, 0.6875D, 0.8125D, 0.875D, 0.8125D);
    private static final AxisAlignedBB NE_AABB = new AxisAlignedBB(0.6875D, 0, 0.1875D, 0.8125D, 0.875D, 0.3125D);

    public static final PropertyBool NW = PropertyBool.create("nw");
    public static final PropertyBool NE = PropertyBool.create("ne");
    public static final PropertyBool SE = PropertyBool.create("se");
    public static final PropertyBool SW = PropertyBool.create("sw");

    @SuppressWarnings("deprecation")
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
    {
        if (!isActualState)
        {
            state = state.getActualState(worldIn, pos);
        }

        addCollisionBoxToList(pos, entityBox, collidingBoxes, PLATE_AABB);

        if (state.getValue(NW))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NW_AABB);
        }

        if (state.getValue(NE))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NE_AABB);
        }

        if (state.getValue(SE))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SE_AABB);
        }

        if (state.getValue(SW))
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SW_AABB);
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = getActualState(state, source, pos);
        return state.getValue(NW) || state.getValue(NE) || state.getValue(SE) || state.getValue(SW) ? FULL_BLOCK_AABB
                : PLATE_AABB;
    }

    public BlockCWTable(String name, Material materialIn, float hardness)
    {
        super(name, materialIn, hardness);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, NW, NE, SE, SW);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        EnumFacing facing;
        int n = 0;
        boolean nw = false, ne = false, se = false, sw = false;
        for (int i = 0; i < 4; i++)
        {
            facing = EnumFacing.byHorizontalIndex(i);
            if (worldIn.getBlockState(pos.offset(facing)).getBlock() == this)
            {
                n += Math.pow(2, i);
            }
        }
        switch (n)
        {
        case 0:
            nw = ne = se = sw = true;
            break;
        case 3: // SW
            ne = true;
            break;
        case 6: // WN
            se = true;
            break;
        case 12: // NE
            sw = true;
            break;
        case 9: // ES
            nw = true;
            break;
        case 1: // S
            nw = ne = true;
            break;
        case 2: // W
            ne = se = true;
            break;
        case 4: // N
            se = sw = true;
            break;
        case 8: // E
            nw = sw = true;
            break;
        }
        return getDefaultState().withProperty(NW, nw).withProperty(NE, ne).withProperty(SE, se).withProperty(SW, sw);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return face == EnumFacing.UP ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return side != EnumFacing.UP;
    }
}
