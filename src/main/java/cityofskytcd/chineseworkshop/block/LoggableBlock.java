package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import snownee.kiwi.block.ModBlock;

public class LoggableBlock extends ModBlock implements IWaterLoggable {
    public static final VoxelShape DEFAULT_SHAPE = Block.makeCuboidShape(1, 1, 1, 15, 15, 15);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public LoggableBlock(Properties builder) {
        super(builder);
        setDefaultState(stateContainer.getBaseState().with(WATERLOGGED, false));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return stateIn;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        FluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        return getDefaultState().with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return DEFAULT_SHAPE;
    }
}
