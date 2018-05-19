/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 斗栱类
 */

public class BlockCWBracketSet extends BlockCWT
{

    public BlockCWBracketSet(String name, Material materialIn, float hardness)
    {
        super(name, materialIn, hardness, CWCreativeTabs.DECORATIONS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    private static final AxisAlignedBB BS_NORTH_AABB = new AxisAlignedBB(1.0D, 1.0D, 1.0D, 0.0D, 0.0D, 0.7D);
    private static final AxisAlignedBB BS_SOUTH_AABB = new AxisAlignedBB(1.0D, 1.0D, 0.3D, 0.0D, 0.0D, 0.0D);
    private static final AxisAlignedBB BS_WEST_AABB = new AxisAlignedBB(1.0D, 1.0D, 1.0D, 0.7D, 0.0D, 0.0D);
    private static final AxisAlignedBB BS_EAST_AABB = new AxisAlignedBB(0.3D, 1.0D, 1.0D, 0.0D, 0.0D, 0.0D);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch (state.getValue(FACING))
        {
        case EAST:
            return BS_EAST_AABB;
        case WEST:
            return BS_WEST_AABB;
        case SOUTH:
            return BS_SOUTH_AABB;
        case NORTH:
            return BS_NORTH_AABB;
        default:
            return null;
        }
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int facing = state.getValue(FACING).getHorizontalIndex();
        return facing;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this));
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState origin = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        return origin.withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
}
