package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.DecorationModule;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

@SuppressWarnings("hiding")
public class HighDoorBlock extends DoorBlock {
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 24.0D, 2.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 16.0D, 24.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 24.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 2.0D, 24.0D, 16.0D);

    public HighDoorBlock(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction direction = state.get(FACING);
        boolean flag = !state.get(OPEN);
        boolean flag1 = state.get(HINGE) == DoorHingeSide.RIGHT;
        boolean down = state.get(HALF) == DoubleBlockHalf.LOWER;
        VoxelShape shape = null;
        switch (direction) {
        case EAST:
        default:
            shape = flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
            break;
        case SOUTH:
            shape = flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
            break;
        case WEST:
            shape = flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
            break;
        case NORTH:
            shape = flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
            break;
        }
        return shape.withOffset(direction.getXOffset() * 3D / 16, down ? -.5 : 0, direction.getZOffset() * 3D / 16);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            return DecorationModule.THRESHOLD.contains(blockstate.getBlock()) || blockstate.isSolidSide(worldIn, blockpos, Direction.UP);
        } else {
            return blockstate.getBlock() == this;
        }
    }

}
