package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.tile.CWTextureTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import snownee.kiwi.RenderLayer;
import snownee.kiwi.RenderLayer.Layer;
import snownee.kiwi.block.ModBlock;
import snownee.kiwi.util.VoxelUtil;

@RenderLayer(Layer.CUTOUT)
public class Direction2Block extends ModBlock implements IWaterLoggable {
    private final boolean retexture;
    public static final EnumProperty<Direction2> FACING = EnumProperty.create("facing", Direction2.class);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final VoxelShape[] shapes = new VoxelShape[2];

    public Direction2Block(Properties builder, boolean retexture) {
        super(builder);
        this.retexture = retexture;
        shapes[0] = shapes[1] = VoxelShapes.fullCube();
    }

    public Direction2Block(Properties builder, VoxelShape shape, boolean retexture) {
        super(builder);
        this.retexture = retexture;
        shapes[0] = shape;
        shapes[1] = VoxelUtil.rotate(shape, Direction.WEST);
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
        return state.get(FACING) == Direction2.SOUTH_NORTH ? shapes[0] : shapes[1];
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        FluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        return getDefaultState().with(FACING, Direction2.fromEnumFacing(context.getPlacementHorizontalFacing())).with(WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        Direction2 direction = state.get(FACING).rotate(rot);
        return state.with(FACING, direction);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        Direction2 direction = state.get(FACING).mirror(mirrorIn);
        return state.with(FACING, direction);
    }

    @Override
    public boolean canCreatureSpawn(BlockState state, IBlockReader world, BlockPos pos, PlacementType type, EntityType<?> entityType) {
        return false;
    }

}
