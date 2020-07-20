package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.tile.CWTextureTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import snownee.kiwi.RenderLayer;
import snownee.kiwi.RenderLayer.Layer;
import snownee.kiwi.block.ModBlock;
import snownee.kiwi.util.VoxelUtil;

@RenderLayer(Layer.CUTOUT)
public class ModHorizontalBlock extends HorizontalBlock implements IWaterLoggable {
    private final boolean retexture;
    private VoxelShape[] shapes = new VoxelShape[4];
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public ModHorizontalBlock(Properties builder, VoxelShape shape, boolean retexture) {
        super(builder);
        this.retexture = retexture;
        for (int i = 0; i < shapes.length; i++) {
            Direction direction = Direction.byHorizontalIndex(i);
            if (direction == Direction.SOUTH) {
                shapes[i] = shape;
            } else {
                shapes[i] = VoxelUtil.rotate(shape, direction);
            }
        }
    }

    public boolean isTextureable() {
        return retexture;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return retexture;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return retexture ? new CWTextureTile() : null;
    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return ModBlock.pickBlock(state, target, world, pos, player);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return shapes[state.get(HORIZONTAL_FACING).getHorizontalIndex()];
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, WATERLOGGED);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return stateIn;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        FluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        BlockState blockstate = this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        return blockstate;
    }

    @Override
    public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, PlacementType type, EntityType<?> entityType) {
        return false;
    }
}
