package cityofskytcd.chineseworkshop.block;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class RoofTileRidgeBlock extends Direction2Block implements IWaterLoggable
{
    public static final VoxelShape AABB = Block.makeCuboidShape(0, 0, 0, 16, 9, 16);
    public static final EnumProperty<Variant> VARIANT = EnumProperty.create("variant", Variant.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public RoofTileRidgeBlock(Block.Properties builder)
    {
        super(builder);
        setDefaultState(this.stateContainer.getBaseState().with(VARIANT, Variant.I).with(FACING, Direction2.SOUTH_NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_)
    {
        return AABB;
    }

    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        BlockState state = super.getStateForPlacement(context).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        return state.with(VARIANT, getVariantProperty(state, context.getWorld(), blockpos));
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        return state.with(VARIANT, getVariantProperty(state, worldIn, currentPos));
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type)
    {
        return false;
    }

    private Variant getVariantProperty(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        Direction facing;
        int connection = 0;
        boolean connect[] = new boolean[4];
        for (int i = 0; i < 4; i++)
        {
            facing = Direction.byHorizontalIndex(i);
            if (worldIn.getBlockState(pos.offset(facing)).getBlock() == this)
            {
                connection++;
                connect[i] = true;
            }
        }
        if (connection == 4)
        {
            return Variant.X;
        }
        else if (connection == 3)
        {
            for (int i = 0; i < 4; i++)
            {
                if (!connect[i])
                {
                    return Variant.values()[Variant.T.ordinal() + i];
                }
            }
        }
        else if (connection == 2)
        {
            if (connect[0] && connect[2] || connect[1] && connect[3])
            {
                return connect[0] ? Variant.I : Variant.I_90;
            }
            Variant variant = Variant.L_270;
            for (int i = 0; i < 3; i++)
            {
                if (connect[i] && connect[i + 1])
                {
                    variant = Variant.values()[Variant.L.ordinal() + i];
                    break;
                }
            }
            return variant;
        }
        else if (connection == 1)
        {
            return (connect[0] || connect[2]) ? Variant.I : Variant.I_90;
        }
        return state.get(FACING) == Direction2.EAST_WEST ? Variant.I : Variant.I_90;
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder)
    {
        builder.add(FACING, VARIANT, WATERLOGGED);
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
