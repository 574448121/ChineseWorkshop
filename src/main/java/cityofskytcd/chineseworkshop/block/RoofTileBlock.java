/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import java.util.List;
import java.util.stream.IntStream;

import cityofskytcd.chineseworkshop.TextureModule;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import snownee.kiwi.block.ModBlock;

/**
 * 屋顶类
 */

public class RoofTileBlock extends ModHorizontalBlock
{
    public static final EnumProperty<StairsShape> SHAPE = StairsBlock.SHAPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape AABB_SLAB_BOTTOM = Block.makeCuboidShape(0.0D, 0.1D, 0.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape NWU_CORNER = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 8.0D);
    protected static final VoxelShape SWU_CORNER = Block.makeCuboidShape(0.0D, 8.0D, 8.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape NEU_CORNER = Block.makeCuboidShape(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape SEU_CORNER = Block.makeCuboidShape(8.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape[] SLAB_BOTTOM_SHAPES = makeShapes(AABB_SLAB_BOTTOM, NWU_CORNER, NEU_CORNER, SWU_CORNER, SEU_CORNER);
    private static final int[] field_196522_K = new int[] { 12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8 };

    private static VoxelShape[] makeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner)
    {
        return IntStream.range(0, 16).mapToObj((p_199780_5_) -> {
            return combineShapes(p_199780_5_, slabShape, nwCorner, neCorner, swCorner, seCorner);
        }).toArray((p_199778_0_) -> {
            return new VoxelShape[p_199778_0_];
        });
    }

    private static VoxelShape combineShapes(int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner)
    {
        VoxelShape voxelshape = slabShape;
        if ((bitfield & 1) != 0)
        {
            voxelshape = VoxelShapes.or(slabShape, nwCorner);
        }

        if ((bitfield & 2) != 0)
        {
            voxelshape = VoxelShapes.or(voxelshape, neCorner);
        }

        if ((bitfield & 4) != 0)
        {
            voxelshape = VoxelShapes.or(voxelshape, swCorner);
        }

        if ((bitfield & 8) != 0)
        {
            voxelshape = VoxelShapes.or(voxelshape, seCorner);
        }

        return voxelshape;
    }

    public RoofTileBlock(Block.Properties builder, boolean retexture)
    {
        super(builder, VoxelShapes.fullCube(), retexture);
        ModBlock.deduceSoundAndHardness(this);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if (isTextureable())
        {
            TextureModule.addTooltip(stack, tooltip, "frame");
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        Direction direction = context.getFace();
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        BlockState blockstate = this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        return blockstate.with(SHAPE, getShapeProperty(blockstate, context.getWorld(), blockpos));
    }

    private static StairsShape getShapeProperty(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        Direction direction = state.get(HORIZONTAL_FACING);
        BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
        if (blockstate.getBlock() == state.getBlock())
        {
            Direction direction1 = blockstate.get(HORIZONTAL_FACING);
            if (direction1.getAxis() != state.get(HORIZONTAL_FACING).getAxis())
            {
                if (direction1 == direction.rotateYCCW())
                {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState blockstate1 = worldIn.getBlockState(pos.offset(direction.getOpposite()));
        if (blockstate1.getBlock() == state.getBlock())
        {
            Direction direction2 = blockstate1.get(HORIZONTAL_FACING);
            if (direction2.getAxis() != state.get(HORIZONTAL_FACING).getAxis())
            {
                if (direction2 == direction.rotateYCCW())
                {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }

        return StairsShape.STRAIGHT;
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
    {
        if (stateIn.get(WATERLOGGED))
        {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return facing.getAxis().isHorizontal() ? stateIn.with(SHAPE, getShapeProperty(stateIn, worldIn, currentPos)) : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(HORIZONTAL_FACING, SHAPE, WATERLOGGED);
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type)
    {
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_)
    {
        return SLAB_BOTTOM_SHAPES[field_196522_K[this.func_196511_x(p_220053_1_)]];
    }

    private int func_196511_x(BlockState state)
    {
        return state.get(SHAPE).ordinal() * 4 + state.get(HORIZONTAL_FACING).getHorizontalIndex();
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        Direction direction = state.get(HORIZONTAL_FACING);
        StairsShape stairsshape = state.get(SHAPE);
        switch (mirrorIn)
        {
        case LEFT_RIGHT:
            if (direction.getAxis() == Direction.Axis.Z)
            {
                switch (stairsshape)
                {
                case INNER_LEFT:
                    return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_RIGHT);
                case INNER_RIGHT:
                    return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_LEFT);
                case OUTER_LEFT:
                    return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_RIGHT);
                case OUTER_RIGHT:
                    return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_LEFT);
                default:
                    return state.rotate(Rotation.CLOCKWISE_180);
                }
            }
            break;
        case FRONT_BACK:
            if (direction.getAxis() == Direction.Axis.X)
            {
                switch (stairsshape)
                {
                case INNER_LEFT:
                    return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_LEFT);
                case INNER_RIGHT:
                    return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_RIGHT);
                case OUTER_LEFT:
                    return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_RIGHT);
                case OUTER_RIGHT:
                    return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_LEFT);
                case STRAIGHT:
                    return state.rotate(Rotation.CLOCKWISE_180);
                }
            }
        }

        return super.mirror(state, mirrorIn);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
    }
}
