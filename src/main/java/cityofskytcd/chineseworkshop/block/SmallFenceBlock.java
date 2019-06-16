/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FourWayBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import snownee.kiwi.block.ModBlock;

public class SmallFenceBlock extends FourWayBlock
{
    public SmallFenceBlock(Block.Properties builder)
    {
        super(4, 4, 16, 16, 16, builder);
        ModBlock.deduceSoundAndHardness(this);
    }

    public SmallFenceBlock(Block.Properties builder, float nodeWidth, float extensionWidth, float p_i48420_3_, float p_i48420_4_, float collisionY)
    {
        super(nodeWidth, extensionWidth, p_i48420_3_, p_i48420_4_, collisionY, builder);
        ModBlock.deduceSoundAndHardness(this);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type)
    {
        return false;
    }

    public boolean func_220111_a(BlockState thatState, boolean p_220111_2_, Direction p_220111_3_)
    {
        Block thatBlock = thatState.getBlock();
        return (!cannotAttach(thatBlock) && p_220111_2_) || (thatBlock.getClass() == this.getClass() && thatState.getMaterial() == material);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        IBlockReader iblockreader = context.getWorld();
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = iblockreader.getBlockState(blockpos1);
        BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
        BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
        BlockState blockstate3 = iblockreader.getBlockState(blockpos4);
        return super.getStateForPlacement(context).with(NORTH, Boolean.valueOf(this.func_220111_a(blockstate, Block.func_220056_d(blockstate, iblockreader, blockpos1, Direction.SOUTH), Direction.SOUTH))).with(EAST, Boolean.valueOf(this.func_220111_a(blockstate1, Block.func_220056_d(blockstate1, iblockreader, blockpos2, Direction.WEST), Direction.WEST))).with(SOUTH, Boolean.valueOf(this.func_220111_a(blockstate2, Block.func_220056_d(blockstate2, iblockreader, blockpos3, Direction.NORTH), Direction.NORTH))).with(WEST, Boolean.valueOf(this.func_220111_a(blockstate3, Block.func_220056_d(blockstate3, iblockreader, blockpos4, Direction.EAST), Direction.EAST))).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if (stateIn.get(WATERLOGGED))
        {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? stateIn.with(FACING_TO_PROPERTY_MAP.get(facing), Boolean.valueOf(this.func_220111_a(facingState, Block.func_220056_d(facingState, worldIn, facingPos, facing.getOpposite()), facing.getOpposite()))) : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
