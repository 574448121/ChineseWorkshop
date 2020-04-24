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
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import snownee.kiwi.block.ModBlock;

public class TableBlock extends ModBlock implements IWaterLoggable {
    private static final VoxelShape PLATE_VS = makeCuboidShape(0, 14, 0, 16, 16, 16);
    private static final VoxelShape NW_VS = makeCuboidShape(3, 0, 3, 5, 14, 5);
    private static final VoxelShape SW_VS = makeCuboidShape(3, 0, 11, 5, 14, 13);
    private static final VoxelShape SE_VS = makeCuboidShape(11, 0, 11, 13, 14, 13);
    private static final VoxelShape NE_VS = makeCuboidShape(11, 0, 3, 13, 14, 5);

    public static final BooleanProperty NW = BooleanProperty.create("nw");
    public static final BooleanProperty NE = BooleanProperty.create("ne");
    public static final BooleanProperty SE = BooleanProperty.create("se");
    public static final BooleanProperty SW = BooleanProperty.create("sw");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private final VoxelShape[] shapes;

    private static VoxelShape[] makeShapes() {
        VoxelShape[] shapes = new VoxelShape[16];
        for (int i = 0; i < 16; i++) {
            shapes[i] = PLATE_VS;
            if (i % 2 == 1) {
                shapes[i] = VoxelShapes.or(shapes[i], NW_VS);
            }
            if ((i >> 1) % 2 == 1) {
                shapes[i] = VoxelShapes.or(shapes[i], NE_VS);
            }
            if ((i >> 2) % 2 == 1) {
                shapes[i] = VoxelShapes.or(shapes[i], SW_VS);
            }
            if ((i >> 3) % 2 == 1) {
                shapes[i] = VoxelShapes.or(shapes[i], SE_VS);
            }
        }
        return shapes;
    }

    public TableBlock(Block.Properties builder) {
        super(builder);
        shapes = makeShapes();
        setDefaultState(stateContainer.getBaseState().with(NW, false).with(NE, false).with(SW, false).with(SE, false).with(WATERLOGGED, false));
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(NW, NE, SE, SW, WATERLOGGED);
    }

    @Override
    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        int i = (state.get(NW) ? 1 : 0) + (state.get(NE) ? 2 : 0) + (state.get(SW) ? 4 : 0) + (state.get(SE) ? 8 : 0);
        return shapes[i];
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IBlockReader iblockreader = context.getWorld();
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        return getState(getDefaultState(), iblockreader, blockpos).with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    public BlockState getState(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Direction facing;
        int n = 0;
        boolean nw = false, ne = false, se = false, sw = false;
        for (int i = 0; i < 4; i++) {
            facing = Direction.byHorizontalIndex(i);
            if (worldIn.getBlockState(pos.offset(facing)).getBlock() == this) {
                n += Math.pow(2, i);
            }
        }
        switch (n) {
        case 0:
            nw = ne = se = sw = true;
            break;
        case 3: // SW
            ne = true;
            break;
        case 6: // WN
            se = true;
            break;
        case 12: // NE
            sw = true;
            break;
        case 9: // ES
            nw = true;
            break;
        case 1: // S
            nw = ne = true;
            break;
        case 2: // W
            ne = se = true;
            break;
        case 4: // N
            se = sw = true;
            break;
        case 8: // E
            nw = sw = true;
            break;
        }
        return state.with(NW, nw).with(NE, ne).with(SE, se).with(SW, sw);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return getState(stateIn, worldIn, currentPos);
    }
}
