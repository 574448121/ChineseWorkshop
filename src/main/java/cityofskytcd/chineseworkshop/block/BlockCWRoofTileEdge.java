package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCWRoofTileEdge extends BlockCWFaceThinWall
{
    private static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 1);
    private static final PropertyBool MIRRORED = PropertyBool.create("mirrored");
    private boolean noSubType = false;

    public BlockCWRoofTileEdge(String name, Material materialIn, float hardness)
    {
        super(name, materialIn, hardness);
    }

    public BlockCWRoofTileEdge(String name, Material materialIn, float hardness, boolean noSubType)
    {
        this(name, materialIn, hardness);
        this.noSubType = noSubType;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING, TYPE, MIRRORED);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing facing = EnumFacing.getHorizontal(meta % 4);
        return this.getDefaultState().withProperty(FACING, facing).withProperty(TYPE, meta / 8).withProperty(
                MIRRORED,
                (meta % 8) > 3);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FACING).getHorizontalIndex() + state.getValue(TYPE) * 8
                + (state.getValue(MIRRORED) ? 4 : 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this));
        if (!noSubType)
        {
            items.add(new ItemStack(this, 1, 1));
        }
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState origin = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        float edge[] = { 1 - hitX, 1 - hitZ, hitX, hitZ };

        EnumFacing facing2 = placer.getHorizontalFacing().getOpposite();
        return origin.withProperty(MIRRORED, edge[facing2.getHorizontalIndex()] < 0.5F).withProperty(TYPE, meta % 8);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(TYPE);
    }

}
