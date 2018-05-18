/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCWTable extends BlockCWT
{

    public static final PropertyBool NW = PropertyBool.create("nw");
    public static final PropertyBool NE = PropertyBool.create("ne");
    public static final PropertyBool SE = PropertyBool.create("se");
    public static final PropertyBool SW = PropertyBool.create("sw");

    public BlockCWTable(String name, Material materialIn, float hardness)
    {
        super(name, materialIn, hardness);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, NW, NE, SE, SW);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        IBlockState newState = getDefaultState();
        EnumFacing facing;
        int n = 0;
        boolean nw = false, ne = false, se = false, sw = false;
        for (int i = 0; i < 4; i++)
        {
            facing = EnumFacing.getHorizontal(i);
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
}
