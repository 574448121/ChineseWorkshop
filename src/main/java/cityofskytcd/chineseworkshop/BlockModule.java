package cityofskytcd.chineseworkshop;

import cityofskytcd.chineseworkshop.block.ModStairsBlock;
import cityofskytcd.chineseworkshop.block.RoofTileBlock;
import cityofskytcd.chineseworkshop.block.RoofTileJBlock;
import cityofskytcd.chineseworkshop.block.RoofTileRidgeBlock;
import cityofskytcd.chineseworkshop.block.SlabRoofTileBlock;
import cityofskytcd.chineseworkshop.client.ClientHandler;
import cityofskytcd.chineseworkshop.network.ConvertItemPacket;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import snownee.kiwi.AbstractModule;
import snownee.kiwi.KiwiModule;
import snownee.kiwi.NoGroup;
import snownee.kiwi.block.ModBlock;
import snownee.kiwi.item.ModItem;
import snownee.kiwi.network.NetworkChannel;

@KiwiModule("blocks")
@KiwiModule.Group
public class BlockModule extends AbstractModule {
	public static final ItemGroup GROUP = new ItemGroup(CW.MODID + ".blocks") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(LOGO);
		}
	};

	// TODO: map color

	@NoGroup
	public static final ModItem LOGO = new ModItem(itemProp());

	public static final ModBlock RED_STAINED_WOODEN_PLANKS = new ModBlock(blockProp(Material.WOOD));

	public static final ModBlock BLACK_BRICK_BLOCK = new ModBlock(blockProp(Material.ROCK));

	public static final ModStairsBlock BLACK_BRICK_STAIRS = new ModStairsBlock(BLACK_BRICK_BLOCK.getDefaultState());

	public static final SlabBlock BLACK_BRICK_SLAB = new SlabBlock(blockProp(BLACK_BRICK_BLOCK));

	public static final ModBlock WHITE_ASH_BLOCK = new ModBlock(blockProp(Material.ROCK));

	public static final ModStairsBlock WHITE_ASH_STAIRS = new ModStairsBlock(WHITE_ASH_BLOCK.getDefaultState());

	public static final SlabBlock WHITE_ASH_SLAB = new SlabBlock(blockProp(WHITE_ASH_BLOCK));

	public static final ModBlock RAMMED_EARTH = new ModBlock(blockProp(Material.GOURD));

	public static final ModStairsBlock RAMMED_EARTH_STAIRS = new ModStairsBlock(RAMMED_EARTH.getDefaultState());

	public static final SlabBlock RAMMED_EARTH_SLAB = new SlabBlock(blockProp(RAMMED_EARTH));

	public static final ModBlock ANDESITE_PAVEMENT = new ModBlock(blockProp(Material.ROCK));

	public static final ModStairsBlock ANDESITE_PAVEMENT_STAIRS = new ModStairsBlock(ANDESITE_PAVEMENT.getDefaultState());

	public static final SlabBlock ANDESITE_PAVEMENT_SLAB = new SlabBlock(blockProp(ANDESITE_PAVEMENT));

	public static final RotatedPillarBlock RED_PILLAR = new RotatedPillarBlock(blockProp(Material.WOOD));

	public static final RotatedPillarBlock DARK_GREEN_PILLAR = new RotatedPillarBlock(blockProp(Material.WOOD));

	public static final RoofTileBlock BLACK_TILE_ROOF = new RoofTileBlock(blockProp(Material.ROCK).notSolid(), false);

	public static final RoofTileJBlock BLACK_TILE_ROOF_J = new RoofTileJBlock(blockProp(BLACK_TILE_ROOF), false);

	public static final RoofTileJBlock BLACK_TILE_ROOF_RIDGE_J = new RoofTileJBlock(blockProp(BLACK_TILE_ROOF), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), false);

	public static final RoofTileRidgeBlock BLACK_TILE_ROOF_RIDGE = new RoofTileRidgeBlock(blockProp(BLACK_TILE_ROOF), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), false);

	public static final RoofTileRidgeBlock BLACK_TILE_ROOF_RIDGE_TOP = new RoofTileRidgeBlock(blockProp(BLACK_TILE_ROOF), VoxelShapes.fullCube(), false);

	public static final SlabRoofTileBlock BLACK_TILE_ROOF_SLAB = new SlabRoofTileBlock(blockProp(BLACK_TILE_ROOF), Block.makeCuboidShape(0, 0, 0, 16, 8, 16), false);

	public static final SlabRoofTileBlock BLACK_TILE_ROOF_SLAB_TOP = new SlabRoofTileBlock(blockProp(BLACK_TILE_ROOF), VoxelShapes.fullCube(), false);

	public static final RoofTileBlock THATCH_ROOF = new RoofTileBlock(blockProp(Material.WOOD).notSolid(), false);

	public static final RoofTileRidgeBlock THATCH_ROOF_RIDGE = new RoofTileRidgeBlock(blockProp(THATCH_ROOF), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), false);

	public static final RoofTileRidgeBlock THATCH_ROOF_RIDGE_TOP = new RoofTileRidgeBlock(blockProp(THATCH_ROOF), VoxelShapes.fullCube(), false);

	public static final SlabRoofTileBlock THATCH_ROOF_SLAB = new SlabRoofTileBlock(blockProp(THATCH_ROOF), Block.makeCuboidShape(0, 0, 0, 16, 8, 16), false);

	public static final SlabRoofTileBlock THATCH_ROOF_SLAB_TOP = new SlabRoofTileBlock(blockProp(THATCH_ROOF), VoxelShapes.fullCube(), false);

	public static final ModBlock BLACK_CLAY_BLOCK = new ModBlock(blockProp(Blocks.CLAY));

	public static final ModBlock YELLOW_CLAY_BLOCK = new ModBlock(blockProp(Blocks.CLAY));

	public static final ModBlock PAINTED_BLOCK = new ModBlock(blockProp(Material.ROCK));

	@Override
	protected void preInit() {
		NetworkChannel.register(ConvertItemPacket.class, new ConvertItemPacket.Handler());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	protected void clientInit(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(ClientHandler.kbSelect);
	}

}
