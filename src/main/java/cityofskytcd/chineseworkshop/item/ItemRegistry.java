package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.block.CWBlocks;
import cityofskytcd.chineseworkshop.util.ModelUtil;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber()
public class ItemRegistry {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				new ItemCWLogo("logo"),
				new ItemCW("black_clay"),
				new ItemCW("black_brick"),
				new ItemCWDoor("door", CWBlocks.DOOR),
				new ItemCWDoor("high_door", CWBlocks.HIGH_DOOR)//,
//				
//				new ItemBlock(CWBlocks.BLACK_BRICK_WALL).setRegistryName(CW.MODID, "black_brick_wall"),
//				new ItemBlock(CWBlocks.ANDESITE_PAVEMENT).setRegistryName(CW.MODID, "andesite_pavement"),
//				new ItemBlock(CWBlocks.RED_PILLARS).setRegistryName(CW.MODID, "red_pillars"),
//				new ItemBlock(CWBlocks.DARK_GREEN_PILLARS).setRegistryName(CW.MODID, "dark_green_pillars"),
//				new ItemBlock(CWBlocks.WHITE_GRAY_WALLS).setRegistryName(CW.MODID, "white_gray_walls"),
//				new ItemBlock(CWBlocks.STONE_TOWER_LAMP).setRegistryName(CW.MODID, "stone_tower_lamp"),
//				new ItemBlock(CWBlocks.RED_LANTERN).setRegistryName(CW.MODID, "red_lantern"),
//				new ItemBlock(CWBlocks.CANDLE).setRegistryName(CW.MODID, "candle"),
//				new ItemBlock(CWBlocks.WHITE_LANTERN).setRegistryName(CW.MODID, "white_lantern"),
//				new ItemBlock(CWBlocks.BRACKET_SET).setRegistryName(CW.MODID, "bracket_set"),
//				new ItemBlock(CWBlocks.MEN_DUN).setRegistryName(CW.MODID, "men_dun"),
//				new ItemBlock(CWBlocks.DOOR_THREHOLD).setRegistryName(CW.MODID, "door_threhold"),
//				new ItemBlock(CWBlocks.CARVING).setRegistryName(CW.MODID, "carving"),
//				new ItemBlock(CWBlocks.TREE_ALTAR).setRegistryName(CW.MODID, "tree_altar"),
//				new ItemBlock(CWBlocks.BENCH).setRegistryName(CW.MODID, "bench"),
//				new ItemBlock(CWBlocks.TABLE).setRegistryName(CW.MODID, "table"),
//				new ItemBlock(CWBlocks.WHITE_GARY_WALLS_STAIRS).setRegistryName(CW.MODID, "white_gary_walls_stairs"),
//				new ItemBlock(CWBlocks.PAPER_WINDOW).setRegistryName(CW.MODID, "paper_window"),
//				new ItemBlock(CWBlocks.DIORITE_FENCE).setRegistryName(CW.MODID, "diorite_fence"),
//				new ItemBlock(CWBlocks.SMALL_BLACK_BRICK_WALL).setRegistryName(CW.MODID, "small_black_brick_wall"),
//				new ItemBlock(CWBlocks.SMALL_WHITE_GRAY_WALLS).setRegistryName(CW.MODID, "small_white_gray_walls"),
//				new ItemBlock(CWBlocks.WOODEN_CHINESE_FENCE).setRegistryName(CW.MODID, "wooden_chinese_fence"),
//				new ItemBlock(CWBlocks.ANDESITE_FENCE).setRegistryName(CW.MODID, "andesite_fence"),
//				new ItemBlock(CWBlocks.IMPLICATE).setRegistryName(CW.MODID, "implicate"),
//				new ItemBlock(CWBlocks.ANDESITE_PAVEMENT_STAIRS).setRegistryName(CW.MODID, "andesite_pavement_stairs"),
//				new ItemBlock(CWBlocks.WOODEN_WALL).setRegistryName(CW.MODID, "wooden_wall"),
//				new ItemBlock(CWBlocks.DOOR).setRegistryName(CW.MODID, "door"),
//				new ItemBlock(CWBlocks.HIGH_DOOR).setRegistryName(CW.MODID, "high_door"),
//				new ItemBlock(CWBlocks.UPPER_DOOR_FRAME).setRegistryName(CW.MODID, "upper_door_frame"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF).setRegistryName(CW.MODID, "black_tile_roof"),
//				new ItemBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF).setRegistryName(CW.MODID, "black_tile_ridge_roof"),
//				new ItemBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_Top).setRegistryName(CW.MODID, "black_tile_ridge_roof_top"),
//				new ItemBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_L).setRegistryName(CW.MODID, "black_tile_ridge_roof_l"),
//				new ItemBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_EDGE).setRegistryName(CW.MODID, "black_tile_ridge_roof_edge"),
//				new ItemBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_T).setRegistryName(CW.MODID, "black_tile_ridge_roof_t"),
//				new ItemBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_X).setRegistryName(CW.MODID, "black_tile_ridge_roof_x"),
//				new ItemBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_J).setRegistryName(CW.MODID, "black_tile_ridge_roof_j"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_J).setRegistryName(CW.MODID, "black_tile_roof_j"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_SLAB).setRegistryName(CW.MODID, "black_tile_roof_slab"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_SLAB_TOP).setRegistryName(CW.MODID, "black_tile_roof_slab_top"),
//				new ItemBlock(CWBlocks.THIN_WHITE_GRAY_WALLS).setRegistryName(CW.MODID, "thin_white_gray_walls"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_Y).setRegistryName(CW.MODID, "black_tile_roof_edge_y"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_Z).setRegistryName(CW.MODID, "black_tile_roof_edge_z"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_YJ).setRegistryName(CW.MODID, "black_tile_roof_edge_yj"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_ZJ).setRegistryName(CW.MODID, "black_tile_roof_edge_zj"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_Z).setRegistryName(CW.MODID, "black_tile_roof_edge_slab_z"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_TOP_Z).setRegistryName(CW.MODID, "black_tile_roof_edge_slab_top_z"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_Y).setRegistryName(CW.MODID, "black_tile_roof_edge_slab_y"),
//				new ItemBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_TOP_Y).setRegistryName(CW.MODID, "black_tile_roof_edge_slab_top_y")
		);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onModelRegister(ModelRegistryEvent event) {
		ModelUtil.mapItemModel(CWItems.LOGO);
		ModelUtil.mapItemModel(CWItems.BLACK_CLAY);
		ModelUtil.mapItemModel(CWItems.BLACK_BRICK);
		ModelUtil.mapItemModel(CWItems.DOOR);
		ModelUtil.mapItemModel(CWItems.HIGH_DOOR);
		
//		mapModels
	}
}