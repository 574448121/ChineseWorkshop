package cityofskytcd.chineseworkshop.block;

import java.util.Locale;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCWRoofTileRidge extends BlockCWTFace2D
{
    private static final AxisAlignedBB AABB = new AxisAlignedBB(0, 0, 0, 1, 0.6, 1);
    private static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);

    public BlockCWRoofTileRidge(String id, Material materialIn, float hardness)
    {
        super(id, materialIn, hardness);
        setDefaultState(
                this.blockState.getBaseState().withProperty(VARIANT, Variant.I).withProperty(
                        FACING,
                        EnumFacing2D.SOUTH_NORTH));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABB;
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        EnumFacing facing;
        int connection = 0;
        boolean connect[] = new boolean[4];
        for (int i = 0; i < 4; i++)
        {
            facing = EnumFacing.getHorizontal(i);
            if (worldIn.getBlockState(pos.offset(facing)).getBlock() == this)
            {
                connection++;
                connect[i] = true;
            }
        }
        if (connection == 4)
        {
            return state.withProperty(VARIANT, Variant.X);
        }
        else if (connection == 3)
        {
            for (int i = 0; i < 4; i++)
            {
                if (!connect[i])
                {
                    state = state.withProperty(VARIANT, Variant.values()[Variant.T.ordinal() + i]);
                    break;
                }
            }
            return state;
        }
        else if (connection == 2)
        {
            if (connect[0] && connect[2] || connect[1] && connect[3])
            {
                return state.withProperty(VARIANT, connect[0] ? Variant.I : Variant.I_90);
            }
            state = state.withProperty(VARIANT, Variant.L_270);
            for (int i = 0; i < 3; i++)
            {
                if (connect[i] && connect[i + 1])
                {
                    state = state.withProperty(VARIANT, Variant.values()[Variant.L.ordinal() + i]);
                    break;
                }
            }
            return state;
        }
        else if (connection == 1)
        {
            return state.withProperty(VARIANT, (connect[0] || connect[2]) ? Variant.I : Variant.I_90);
        }
        else
        {
            return state.withProperty(
                    VARIANT,
                    state.getValue(FACING) == EnumFacing2D.EAST_WEST ? Variant.I : Variant.I_90);
        }
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING, VARIANT);
    }

    private static enum Variant implements IStringSerializable
    {
        I, I_90, L, L_90, L_180, L_270, T, T_90, T_180, T_270, X;

        @Override
        public String getName()
        {
            return toString().toLowerCase(Locale.ENGLISH);
        }
    }
}
