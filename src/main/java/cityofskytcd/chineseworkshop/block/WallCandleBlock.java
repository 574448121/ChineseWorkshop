/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WallCandleBlock extends CandleBlock
{
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    protected static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(3.2, 3.2, 4.8, 12.8, 0.8, 16);
    protected static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(3.2, 1.6, 0, 12.8, 12.8, 11.2);
    protected static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(4.8, 3.2, 3.2, 16, 12.8, 12.8);
    protected static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(0, 3.2, 3.2, 11.2, 12.8, 12.8);

    public WallCandleBlock(Block.Properties builder)
    {
        super(builder);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        return Blocks.WALL_TORCH.isValidPosition(state, worldIn, pos);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        return Blocks.WALL_TORCH.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockState blockstate = Blocks.WALL_TORCH.getStateForPlacement(context);
        return blockstate == null ? null : this.getDefaultState().with(FACING, blockstate.get(FACING));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return Blocks.WALL_TORCH.rotate(state, rot);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        return Blocks.WALL_TORCH.mirror(state, mirrorIn);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        double d0 = pos.getX() + 0.5D;
        double d1 = pos.getY() + 0.85D;
        double d2 = pos.getZ() + 0.5D;
        worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public VoxelShape getShape(net.minecraft.block.BlockState state, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_)
    {
        switch (state.get(FACING))
        {
        default:
            return EAST_SHAPE;
        case WEST:
            return WEST_SHAPE;
        case SOUTH:
            return SOUTH_SHAPE;
        case NORTH:
            return NORTH_SHAPE;
        }
    }

}
