package cityofskytcd.chineseworkshop.crafting;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader {
	public CraftingLoader() {
		registerRecipe();
		registerSmelting();
		registerFuel();
	}

	private static void registerRecipe() {
		/* 方块 */
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackBrickWall),
				new Object[] { "##", "##", '#', ItemLoader.blackBrick });
		GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.redPillars, 2),
				new Object[] { Items.CLAY_BALL, Blocks.LOG, new ItemStack(Items.DYE, 1, 1), Items.CLAY_BALL });
		GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.darkGreenPillars, 2),
				new Object[] { Items.CLAY_BALL, Blocks.LOG, new ItemStack(Items.DYE, 1, 2), Items.CLAY_BALL });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteGrayWalls, 4),
				new Object[] { "**", "*#", '#', Blocks.SAND, '*', Items.QUARTZ });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteGrayWalls, 2),
				new Object[] { "**", "*#", '#', Blocks.SAND, '*', new ItemStack(Items.DYE, 1, 15) });
		/* 灯 */
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.stoneTowerLamp, 3), new Object[] { " * ", "*@*", "#!#",
				'#', Blocks.STONE, '*', Blocks.STONEBRICK, '@', Blocks.REDSTONE_LAMP, '!', Blocks.REDSTONE_TORCH });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.theLantern, 6), new Object[] { "#*#", "#!#", "#*#", '#',
				new ItemStack(Blocks.WOOL, 1, 14), '*', new ItemStack(Blocks.WOOL, 1, 4), '!', Blocks.TORCH });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.candle, 6),
				new Object[] { "  #", " **", "*  ", '#', Blocks.TORCH, '*', Items.IRON_INGOT });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteLanterns, 2),
				new Object[] { "***", "#!#", "***", '#', Items.STICK, '*', Items.PAPER, '!', Blocks.TORCH });
		/* 材料 */
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.blackClay, 8),
				new Object[] { "###", "#*#", "###", '#', Items.CLAY_BALL, '*', Items.DYE });
		/* 装饰 */

		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.bracketSet),
				new Object[] { "###", "###", " # ", '#', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoof, 16),
				new Object[] { "  #", " ##", "###", '#', ItemLoader.blackBrick });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoof, 16),
				new Object[] { "#  ", "## ", "###", '#', ItemLoader.blackBrick });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.carving, 3),
				new Object[] { "###", "###", '#', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.menDun, 4), new Object[] { " **", " **", "###", '#',
				new ItemStack(Blocks.STONE_SLAB, 1, 0), '*', Blocks.STONEBRICK });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.doorThreshold, 3),
				new Object[] { "###", '#', new ItemStack(Blocks.STONE_SLAB, 1, 0) });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoof, 16),
				new Object[] { "###", "###", '#', ItemLoader.blackBrick });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofL, 5),
				new Object[] { "#  ", "#  ", "###", '#', BlockLoader.blackTileRidgeRoof });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofEdge, 3),
				new Object[] { "#", "#", "#", '#', BlockLoader.blackTileRidgeRoof });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofT, 4),
				new Object[] { "###", " # ", '#', BlockLoader.blackTileRidgeRoof });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofX, 5),
				new Object[] { "# #", " # ", "# #", '#', BlockLoader.blackTileRidgeRoof });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofJ, 3),
				new Object[] { "#  ", " # ", "  #", '#', BlockLoader.blackTileRidgeRoof });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofj, 3),
				new Object[] { "#  ", " # ", "  #", '#', BlockLoader.blackTileRoof });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.thinWhiteGrayWalls, 18),
				new Object[] { "#", "#", "#", '#', BlockLoader.whiteGrayWalls });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeZ, 6),
				new Object[] { " #", "#*", '#', BlockLoader.whiteGrayWalls, '*', BlockLoader.blackTileRoof });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeY, 6),
				new Object[] { "# ", "*#", '*', BlockLoader.whiteGrayWalls, '#', BlockLoader.blackTileRoof });
		GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeYJ, 1),
				new Object[] { ItemLoader.blackBrick, BlockLoader.blackTileRoofEdgeY });
		GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeZJ, 1),
				new Object[] { ItemLoader.blackBrick, BlockLoader.blackTileRoofEdgeZ });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.treeAltar, 2),
				new Object[] { "*#*", '#', Blocks.LOG, '*', BlockLoader.blackBrickWall });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.bench, 1),
				new Object[] { "###", "***", "* *", '#', Blocks.WOODEN_SLAB, '*', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.table, 4),
				new Object[] { "###", "* *", "* *", '#', Blocks.WOODEN_SLAB, '*', Blocks.PLANKS });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.andesitePavement, 2),
				new Object[] { "#*", "*#", '#', new ItemStack(Blocks.STONE, 1, 6), '*', ItemLoader.blackBrick });
		// 白灰墙阶梯
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteGrayWallsStairs, 6),
				new Object[] { "#  ", "## ", "###", '#', BlockLoader.whiteGrayWalls });
		// 纸窗
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.paperWindow, 4),
				new Object[] { "#*#", "#*#", '#', Items.STICK, '*', Items.PAPER });
		// 闪长岩栅栏
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.dioriteFence, 6),
				new Object[] { "###", "###", '#', new ItemStack(Blocks.STONE, 1, 3) });
		// 小黑砖墙
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.smallBlackBrickWall, 6),
				new Object[] { "###", "###", '#', BlockLoader.blackBrickWall });
		// 小白灰墙
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.smallWhiteGrayWalls, 6),
				new Object[] { "###", "###", '#', BlockLoader.whiteGrayWalls });
		// 橡木中式栅栏
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.oakChineseFence, 10), new Object[] { "#*#", "#*#", '#',
				new ItemStack(Blocks.LOG, 1, 0), '*', new ItemStack(Blocks.PLANKS, 1, 0) });
		// 安山岩栅栏
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.andesiteFence, 6),
				new Object[] { "###", "###", '#', new ItemStack(Blocks.STONE, 1, 5) });
		// 挂落
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.implicate, 10),
				new Object[] { "#*#", "#*#", '*', new ItemStack(Blocks.LOG, 1, 0), '#', Items.STICK });
		// 安山岩路面楼梯
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.andesitePavementStairs, 6),
				new Object[] { "#  ", "## ", "###", '#', BlockLoader.andesitePavement });
		// 橡木墙
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.oakWall, 9),
				new Object[] { "###", "###", "###", '#', new ItemStack(Blocks.PLANKS, 1, 0) });
		// 中式木门
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.cwDoor, 1),
				new Object[] {Items.SPRUCE_DOOR,Blocks.PLANKS});

		/* 屋顶 */
		// 黑瓦屋顶半砖
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofSlab, 6),
				new Object[] { "###", '#', BlockLoader.blackTileRoof });
		// 黑瓦屋顶半砖top
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofSlabTop, 12),
				new Object[] { "###", "###", '#', BlockLoader.blackTileRoof });
		// 黑瓦屋脊top
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofTop, 3),
				new Object[] { "###", '#', BlockLoader.blackTileRidgeRoof });
		/* 薄墙 */
		// 黑瓦屋顶半砖边缘左
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeSlabZ, 4),
				new Object[] { "##", '#', BlockLoader.blackTileRoofEdgeZ });
		// 黑瓦屋顶半砖边缘左TOP
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeSlabTopZ, 6),
				new Object[] { "###", '#', BlockLoader.blackTileRoofEdgeZ });
		// 黑瓦屋顶半砖边缘右
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeSlabY, 4),
				new Object[] { "##", '#', BlockLoader.blackTileRoofEdgeY });
		// 黑瓦屋顶半砖边缘右TOP
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeSlabTopY, 6),
				new Object[] { "###", '#', BlockLoader.blackTileRoofEdgeY });
	}

	private static void registerSmelting() {
		/* 装饰 */
		GameRegistry.addSmelting(ItemLoader.blackClay, new ItemStack(ItemLoader.blackBrick), 0.5F);
	}

	private static void registerFuel() {

	}
}