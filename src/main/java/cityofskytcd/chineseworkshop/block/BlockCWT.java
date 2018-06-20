/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCWT extends BlockCW
{

    public BlockCWT(String id, Material materialIn, float hardness)
    {
        super(id, materialIn, hardness, CWCreativeTabs.DECORATIONS);
    }

    public BlockCWT(String id, Material materialIn, float hardness, CreativeTabs tabs)
    {
        super(id, materialIn, hardness, tabs);
    }

    public BlockCWT(String id, Material materialIn, float hardness, SoundType soundType)
    {
        super(id, materialIn, hardness, soundType);
    }

    public BlockCWT(String id, Material materialIn, float hardness, SoundType soundType, CreativeTabs tabs)
    {
        super(id, materialIn, hardness, soundType, tabs);
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
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }
}
