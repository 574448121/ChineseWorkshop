package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FourWayBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class AndesiteFenceBlock extends FourWayBlock {
    public static final BooleanProperty UP = BlockStateProperties.UP;
    private final VoxelShape[] wallShapes;
    private final VoxelShape[] wallCollisionShapes;

    public AndesiteFenceBlock(Properties properties) {
        super(0, 1.5F, 16, 16, 24, properties);
        this.wallShapes = this.makeShapes(2F, 1.5F, 18.0F, 0.0F, 16.0F);
        this.wallCollisionShapes = this.makeShapes(2F, 1.5F, 24.0F, 0.0F, 24.0F);
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return p_220053_1_.get(UP) ? this.wallShapes[this.getIndex(p_220053_1_)] : super.getShape(p_220053_1_, p_220053_2_, p_220053_3_, p_220053_4_);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return p_220071_1_.get(UP) ? this.wallCollisionShapes[this.getIndex(p_220071_1_)] : super.getCollisionShape(p_220071_1_, p_220071_2_, p_220071_3_, p_220071_4_);
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    private boolean func_220113_a(BlockState p_220113_1_, boolean p_220113_2_, Direction p_220113_3_) {
        Block block = p_220113_1_.getBlock();
        return !cannotAttach(block) && p_220113_2_ || block == this;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IWorldReader iworldreader = context.getWorld();
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = iworldreader.getBlockState(blockpos1);
        BlockState blockstate1 = iworldreader.getBlockState(blockpos2);
        BlockState blockstate2 = iworldreader.getBlockState(blockpos3);
        BlockState blockstate3 = iworldreader.getBlockState(blockpos4);
        boolean flag = this.func_220113_a(blockstate, Block.hasSolidSide(blockstate, iworldreader, blockpos1, Direction.SOUTH), Direction.SOUTH);
        boolean flag1 = this.func_220113_a(blockstate1, Block.hasSolidSide(blockstate1, iworldreader, blockpos2, Direction.WEST), Direction.WEST);
        boolean flag2 = this.func_220113_a(blockstate2, Block.hasSolidSide(blockstate2, iworldreader, blockpos3, Direction.NORTH), Direction.NORTH);
        boolean flag3 = this.func_220113_a(blockstate3, Block.hasSolidSide(blockstate3, iworldreader, blockpos4, Direction.EAST), Direction.EAST);
        boolean flag4 = (!flag || flag1 || !flag2 || flag3) && (flag || !flag1 || flag2 || !flag3);
        return this.getDefaultState().with(UP, Boolean.valueOf(flag4 || !iworldreader.isAirBlock(blockpos.up()))).with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3)).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        if (facing == Direction.DOWN) {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            Direction direction = facing.getOpposite();
            boolean flag = facing == Direction.NORTH ? this.func_220113_a(facingState, Block.hasSolidSide(facingState, worldIn, facingPos, direction), direction) : stateIn.get(NORTH);
            boolean flag1 = facing == Direction.EAST ? this.func_220113_a(facingState, Block.hasSolidSide(facingState, worldIn, facingPos, direction), direction) : stateIn.get(EAST);
            boolean flag2 = facing == Direction.SOUTH ? this.func_220113_a(facingState, Block.hasSolidSide(facingState, worldIn, facingPos, direction), direction) : stateIn.get(SOUTH);
            boolean flag3 = facing == Direction.WEST ? this.func_220113_a(facingState, Block.hasSolidSide(facingState, worldIn, facingPos, direction), direction) : stateIn.get(WEST);
            boolean flag4 = (!flag || flag1 || !flag2 || flag3) && (flag || !flag1 || flag2 || !flag3);
            return stateIn.with(UP, Boolean.valueOf(flag4 || !worldIn.isAirBlock(currentPos.up()))).with(NORTH, Boolean.valueOf(flag)).with(EAST, Boolean.valueOf(flag1)).with(SOUTH, Boolean.valueOf(flag2)).with(WEST, Boolean.valueOf(flag3));
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
