package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import snownee.kiwi.block.ModBlock;
import snownee.kiwi.util.VoxelUtil;

public class Direction2Block extends ModBlock
{
    public static final EnumProperty<Direction2> FACING = EnumProperty.create("facing", Direction2.class);
    private final VoxelShape[] shapes = new VoxelShape[2];

    public Direction2Block(Properties builder)
    {
        super(builder);
        shapes[0] = shapes[1] = VoxelShapes.fullCube();
    }

    public Direction2Block(Properties builder, VoxelShape shape)
    {
        super(builder);
        shapes[0] = shape;
        shapes[1] = VoxelUtil.rotate(shape, Direction.WEST);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_)
    {
        return state.get(FACING) == Direction2.SOUTH_NORTH ? shapes[0] : shapes[1];
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return getDefaultState().with(FACING, Direction2.fromEnumFacing(context.getPlacementHorizontalFacing()));
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot)
    {
        Direction2 direction = state.get(FACING).rotate(rot);
        return state.with(FACING, direction);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        Direction2 direction = state.get(FACING).mirror(mirrorIn);
        return state.with(FACING, direction);
    }
}
