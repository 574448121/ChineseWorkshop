package cityofskytcd.chineseworkshop.crafting;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.block.BlockLoader;
import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingLoader {
	public static int recipeID = 0;

	public CraftingLoader() {
		registerRecipe();
		registerSmelting();
		registerFuel();
	}

	private static void registerHelper(ItemStack itemStack, Object... recipe) {
		ResourceLocation r = new ResourceLocation(CW.MODID + ":" + recipeID++);
		if (recipe[0] instanceof String) {
			GameRegistry.addShapedRecipe(r, null, itemStack, recipe);
		} else {
			ShapelessOreRecipe s = new ShapelessOreRecipe(null, itemStack, recipe);
			s.setRegistryName(r);
			ForgeRegistries.RECIPES.register(s);
		}
	}

	private static void registerRecipe() {
		
		//����ϳ�
		registerHelper(new ItemStack(BlockLoader.redPillars, 2),
				new Object[] { Items.CLAY_BALL, Blocks.LOG, new ItemStack(Items.DYE, 1, 1), Items.CLAY_BALL });
		registerHelper(new ItemStack(BlockLoader.darkGreenPillars, 2),
				new Object[] { Items.CLAY_BALL, Blocks.LOG, new ItemStack(Items.DYE, 1, 2), Items.CLAY_BALL });
		registerHelper(new ItemStack(BlockLoader.blackTileRoofEdgeYJ, 1),
				new Object[] { ItemLoader.blackBrick, BlockLoader.blackTileRoofEdgeY });
		registerHelper(new ItemStack(BlockLoader.blackTileRoofEdgeZJ, 1),
				new Object[] { ItemLoader.blackBrick, BlockLoader.blackTileRoofEdgeZ });
		/*���� */
		//����ϳ�
		registerHelper(new ItemStack(BlockLoader.blackBrickWall),
				new Object[] { "##", "##", '#', ItemLoader.blackBrick });
		registerHelper(new ItemStack(BlockLoader.blackBrickWall),
				new Object[] { "##", "##", '#', ItemLoader.blackBrick });
		registerHelper(new ItemStack(BlockLoader.whiteGrayWalls, 4),
				new Object[] { "**", "*#", '#', Blocks.SAND, '*', Items.QUARTZ });
		registerHelper(new ItemStack(BlockLoader.whiteGrayWalls, 2),
				new Object[] { "**", "*#", '#', Blocks.SAND, '*', new ItemStack(Items.DYE, 1, 15) });
		/*�� */
		registerHelper(new ItemStack(BlockLoader.stoneTowerLamp, 3), new Object[] { " * ", "*@*", "#!#", '#',
				Blocks.STONE, '*', Blocks.STONEBRICK, '@', Blocks.REDSTONE_LAMP, '!', Blocks.REDSTONE_TORCH });
		registerHelper(new ItemStack(BlockLoader.theLantern, 6), new Object[] { "#*#", "#!#", "#*#", '#',
				new ItemStack(Blocks.WOOL, 1, 14), '*', new ItemStack(Blocks.WOOL, 1, 4), '!', Blocks.TORCH });
		registerHelper(new ItemStack(BlockLoader.candle, 6),
				new Object[] { "  #", " **", "*  ", '#', Blocks.TORCH, '*', Blocks.STONE });
		registerHelper(new ItemStack(BlockLoader.whiteLanterns, 2),
				new Object[] { "***", "#!#", "***", '#', Items.STICK, '*', Items.PAPER, '!', Blocks.TORCH });
		/*����*/
		registerHelper(new ItemStack(ItemLoader.blackClay, 8),
				new Object[] { "###", "#*#", "###", '#', Items.CLAY_BALL, '*', Items.DYE });
		/*װ��*/

		registerHelper(new ItemStack(BlockLoader.bracketSet), new Object[] { "###", "###", " # ", '#', Items.STICK });
		registerHelper(new ItemStack(BlockLoader.blackTileRoof, 16),
				new Object[] { "  #", " ##", "###", '#', ItemLoader.blackBrick });
		registerHelper(new ItemStack(BlockLoader.blackTileRoof, 16),
				new Object[] { "#  ", "## ", "###", '#', ItemLoader.blackBrick });
		registerHelper(new ItemStack(BlockLoader.carving, 3), new Object[] { "###", "###", '#', Items.STICK });
		registerHelper(new ItemStack(BlockLoader.menDun, 4), new Object[] { " **", " **", "###", '#',
				new ItemStack(Blocks.STONE_SLAB, 1, 0), '*', Blocks.STONEBRICK });
		registerHelper(new ItemStack(BlockLoader.doorThreshold, 3),
				new Object[] { "###", '#', new ItemStack(Blocks.STONE_SLAB, 1, 0) });
		registerHelper(new ItemStack(BlockLoader.blackTileRidgeRoof, 16),
				new Object[] { "###", "###", '#', ItemLoader.blackBrick });
		registerHelper(new ItemStack(BlockLoader.blackTileRidgeRoofL, 5),
				new Object[] { "#  ", "#  ", "###", '#', BlockLoader.blackTileRidgeRoof });
		registerHelper(new ItemStack(BlockLoader.blackTileRidgeRoofEdge, 3),
				new Object[] { "#", "#", "#", '#', BlockLoader.blackTileRidgeRoof });
		registerHelper(new ItemStack(BlockLoader.blackTileRidgeRoofT, 4),
				new Object[] { "###", " # ", '#', BlockLoader.blackTileRidgeRoof });
		registerHelper(new ItemStack(BlockLoader.blackTileRidgeRoofX, 5),
				new Object[] { "# #", " # ", "# #", '#', BlockLoader.blackTileRidgeRoof });
		registerHelper(new ItemStack(BlockLoader.blackTileRidgeRoofJ, 3),
				new Object[] { "#  ", " # ", "  #", '#', BlockLoader.blackTileRidgeRoof });
		registerHelper(new ItemStack(BlockLoader.blackTileRoofj, 3),
				new Object[] { "#  ", " # ", "  #", '#', BlockLoader.blackTileRoof });
		registerHelper(new ItemStack(BlockLoader.thinWhiteGrayWalls, 18),
				new Object[] { "#", "#", "#", '#', BlockLoader.whiteGrayWalls });
		registerHelper(new ItemStack(BlockLoader.blackTileRoofEdgeZ, 6),
				new Object[] { " #", "#*", '#', BlockLoader.whiteGrayWalls, '*', BlockLoader.blackTileRoof });
		registerHelper(new ItemStack(BlockLoader.blackTileRoofEdgeY, 6),
				new Object[] { "# ", "*#", '*', BlockLoader.whiteGrayWalls, '#', BlockLoader.blackTileRoof });
		registerHelper(new ItemStack(BlockLoader.treeAltar, 2),
				new Object[] { "*#*", '#', Blocks.LOG, '*', BlockLoader.blackBrickWall });
		registerHelper(new ItemStack(BlockLoader.bench, 1),
				new Object[] { "###", "***", "* *", '#', Blocks.WOODEN_SLAB, '*', Items.STICK });
		registerHelper(new ItemStack(BlockLoader.table, 4),
				new Object[] { "###", "* *", "* *", '#', Blocks.WOODEN_SLAB, '*', Blocks.PLANKS });
		registerHelper(new ItemStack(BlockLoader.andesitePavement, 2),
				new Object[] { "#*", "*#", '#', new ItemStack(Blocks.STONE, 1, 6), '*', ItemLoader.blackBrick });
		//�׻�ǽ����
		registerHelper(new ItemStack(BlockLoader.whiteGrayWallsStairs, 6),
				new Object[] { "#  ", "## ", "###", '#', BlockLoader.whiteGrayWalls });
		//ֽ��
		registerHelper(new ItemStack(BlockLoader.paperWindow, 4),
				new Object[] { "#*#", "#*#", '#', Items.STICK, '*', Items.PAPER });
		//������դ��
		registerHelper(new ItemStack(BlockLoader.dioriteFence, 6),
				new Object[] { "###", "###", '#', new ItemStack(Blocks.STONE, 1, 3) });
		//С��שǽ
		registerHelper(new ItemStack(BlockLoader.smallBlackBrickWall, 6),
				new Object[] { "###", "###", '#', BlockLoader.blackBrickWall });
		//С�׻�ǽ
		registerHelper(new ItemStack(BlockLoader.smallWhiteGrayWalls, 6),
				new Object[] { "###", "###", '#', BlockLoader.whiteGrayWalls });
		//��ľ��ʽդ��
		registerHelper(new ItemStack(BlockLoader.oakChineseFence, 10), new Object[] { "#*#", "#*#", '#',
				new ItemStack(Blocks.LOG, 1, 0), '*', new ItemStack(Blocks.PLANKS, 1, 0) });
		//��ɽ��դ��
		registerHelper(new ItemStack(BlockLoader.andesiteFence, 6),
				new Object[] { "###", "###", '#', new ItemStack(Blocks.STONE, 1, 5) });
		//����
		registerHelper(new ItemStack(BlockLoader.implicate, 10),
				new Object[] { "#*#", "#*#", '*', new ItemStack(Blocks.LOG, 1, 0), '#', Items.STICK });
		//��ɽ��·��¥��
		registerHelper(new ItemStack(BlockLoader.andesitePavementStairs, 6),
				new Object[] { "#  ", "## ", "###", '#', BlockLoader.andesitePavement });
		
		/*�ݶ� */
		//�����ݶ���ש
		registerHelper(new ItemStack(BlockLoader.blackTileRoofSlab, 6),
				new Object[] { "###", '#', BlockLoader.blackTileRoof });
		//�����ݶ���שtop
		registerHelper(new ItemStack(BlockLoader.blackTileRoofSlabTop, 12),
				new Object[] { "###", "###", '#', BlockLoader.blackTileRoof });
		//�����ݼ�top
		registerHelper(new ItemStack(BlockLoader.blackTileRidgeRoofTop, 3),
				new Object[] { "###", '#', BlockLoader.blackTileRidgeRoof });
				
		/*��ǽ */
		//�����ݶ���ש��Ե��
		registerHelper(new ItemStack(BlockLoader.blackTileRoofEdgeSlabZ, 4),
				new Object[] { "##", '#', BlockLoader.blackTileRoofEdgeZ });
		//�����ݶ���ש��Ե��TOP
		registerHelper(new ItemStack(BlockLoader.blackTileRoofEdgeSlabTopZ, 6),
				new Object[] { "###", '#', BlockLoader.blackTileRoofEdgeZ });
		//�����ݶ���ש��Ե��
		registerHelper(new ItemStack(BlockLoader.blackTileRoofEdgeSlabY, 4),
				new Object[] { "##", '#', BlockLoader.blackTileRoofEdgeY });
		//�����ݶ���ש��Ե��TOP
		registerHelper(new ItemStack(BlockLoader.blackTileRoofEdgeSlabTopY, 6),
				new Object[] { "###", '#', BlockLoader.blackTileRoofEdgeY });
	}

	private static void registerSmelting() {
		/*װ�� */
		GameRegistry.addSmelting(ItemLoader.blackClay, new ItemStack(ItemLoader.blackBrick), 0.5F);
	}

	private static void registerFuel() {

	}
}