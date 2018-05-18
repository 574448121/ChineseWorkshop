/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.crafting;

import cityofskytcd.chineseworkshop.block.CWBlocks;
import cityofskytcd.chineseworkshop.item.CWItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader
{
    public static void register()
    {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe()
    {
//        // TODO: Data-driven recipes
//        /* 方块 */
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_BRICK_WALL), new Object[] { "##", "##", '#',
//                CWItems.BLACK_BRICK });
//        GameRegistry.addShapelessRecipe(new ItemStack(CWBlocks.RED_PILLARS, 2), new Object[] { Items.CLAY_BALL,
//                Blocks.LOG, new ItemStack(Items.DYE, 1, 1), Items.CLAY_BALL });
//        GameRegistry.addShapelessRecipe(new ItemStack(CWBlocks.DARK_GREEN_PILLARS, 2), new Object[] { Items.CLAY_BALL,
//                Blocks.LOG, new ItemStack(Items.DYE, 1, 2), Items.CLAY_BALL });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.WHITE_GRAY_WALLS, 4), new Object[] { "**", "*#", '#',
//                Blocks.SAND, '*', Items.QUARTZ });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.WHITE_GRAY_WALLS, 2), new Object[] { "**", "*#", '#',
//                Blocks.SAND, '*', new ItemStack(Items.DYE, 1, 15) });
//        /* 灯 */
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.STONE_TOWER_LAMP, 3), new Object[] { " * ", "*@*", "#!#",
//                '#', Blocks.STONE, '*', Blocks.STONEBRICK, '@', Blocks.REDSTONE_LAMP, '!', Blocks.REDSTONE_TORCH });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.RED_LANTERN, 6), new Object[] { "#*#", "#!#", "#*#", '#',
//                new ItemStack(Blocks.WOOL, 1, 14), '*', new ItemStack(Blocks.WOOL, 1, 4), '!', Blocks.TORCH });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.CANDLE, 6), new Object[] { " #", " **", "* ", '#',
//                Blocks.TORCH, '*', Items.IRON_INGOT });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.WHITE_LANTERN, 2), new Object[] { "***", "#!#", "***", '#',
//                Items.STICK, '*', Items.PAPER, '!', Blocks.TORCH });
//        /* 材料 */
//        GameRegistry.addShapedRecipe(new ItemStack(CWItems.BLACK_CLAY, 8), new Object[] { "###", "#*#", "###", '#',
//                Items.CLAY_BALL, '*', Items.DYE });
//        /* 装饰 */
//
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BRACKET_SET), new Object[] { "###", "###", " # ", '#',
//                Items.STICK });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF, 16), new Object[] { "  #", " ##", "###",
//                '#', CWItems.BLACK_BRICK });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF, 16), new Object[] { "#  ", "## ", "###",
//                '#', CWItems.BLACK_BRICK });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.CARVING, 3), new Object[] { "###", "###", '#',
//                Items.STICK });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.MEN_DUN, 4), new Object[] { " **", " **", "###", '#',
//                new ItemStack(Blocks.STONE_SLAB, 1, 0), '*', Blocks.STONEBRICK });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.THRESHOLD, 3), new Object[] { "###", '#',
//                new ItemStack(Blocks.STONE_SLAB, 1, 0) });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_RIDGE_ROOF, 16), new Object[] { "###", "###",
//                '#', CWItems.BLACK_BRICK });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_RIDGE_ROOF_L, 5), new Object[] { "#  ", "#  ",
//                "###", '#', CWBlocks.BLACK_TILE_RIDGE_ROOF });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_RIDGE_ROOF_EDGE, 3), new Object[] { "#", "#",
//                "#", '#', CWBlocks.BLACK_TILE_RIDGE_ROOF });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_RIDGE_ROOF_T, 4), new Object[] { "###", " # ",
//                '#', CWBlocks.BLACK_TILE_RIDGE_ROOF });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_RIDGE_ROOF_X, 5), new Object[] { "# #", " # ",
//                "# #", '#', CWBlocks.BLACK_TILE_RIDGE_ROOF });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_RIDGE_ROOF_J, 3), new Object[] { "#  ", " # ",
//                "  #", '#', CWBlocks.BLACK_TILE_RIDGE_ROOF });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_J, 3), new Object[] { "#  ", " # ", "  #",
//                '#', CWBlocks.BLACK_TILE_ROOF });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.THIN_WHITE_GRAY_WALLS, 18), new Object[] { "#", "#", "#",
//                '#', CWBlocks.WHITE_GRAY_WALLS });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_EDGE_Z, 6), new Object[] { " #", "#*", '#',
//                CWBlocks.WHITE_GRAY_WALLS, '*', CWBlocks.BLACK_TILE_ROOF });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_EDGE_Y, 6), new Object[] { "# ", "*#", '*',
//                CWBlocks.WHITE_GRAY_WALLS, '#', CWBlocks.BLACK_TILE_ROOF });
//        GameRegistry.addShapelessRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_EDGE_YJ, 1), new Object[] {
//                CWItems.BLACK_BRICK, CWBlocks.BLACK_TILE_ROOF_EDGE_Y });
//        GameRegistry.addShapelessRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_EDGE_ZJ, 1), new Object[] {
//                CWItems.BLACK_BRICK, CWBlocks.BLACK_TILE_ROOF_EDGE_Z });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.TREE_ALTAR, 2), new Object[] { "*#*", '#', Blocks.LOG, '*',
//                CWBlocks.BLACK_BRICK_WALL });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BENCH, 1), new Object[] { "###", "***", "* *", '#',
//                Blocks.WOODEN_SLAB, '*', Items.STICK });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.TABLE, 4), new Object[] { "###", "* *", "* *", '#',
//                Blocks.WOODEN_SLAB, '*', Blocks.PLANKS });
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.ANDESITE_PAVEMENT, 2), new Object[] { "#*", "*#", '#',
//                new ItemStack(Blocks.STONE, 1, 6), '*', CWItems.BLACK_BRICK });
//        // 白灰墙阶梯
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.WHITE_GRAY_WALLS_STAIRS, 6), new Object[] { "#  ", "## ",
//                "###", '#', CWBlocks.WHITE_GRAY_WALLS });
//        // 纸窗
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.PAPER_WINDOW, 4), new Object[] { "#*#", "#*#", '#',
//                Items.STICK, '*', Items.PAPER });
//        // 闪长岩栅栏
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.DIORITE_FENCE, 6), new Object[] { "###", "###", '#',
//                new ItemStack(Blocks.STONE, 1, 3) });
//        // 小黑砖墙
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.SMALL_BLACK_BRICK_WALL, 6), new Object[] { "###", "###",
//                '#', CWBlocks.BLACK_BRICK_WALL });
//        // 小白灰墙
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.SMALL_WHITE_GRAY_WALLS, 6), new Object[] { "###", "###",
//                '#', CWBlocks.WHITE_GRAY_WALLS });
//        // 橡木中式栅栏
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.OAK_CHINESE_FENCE, 10), new Object[] { "#*#", "#*#", '#',
//                new ItemStack(Blocks.LOG, 1, 0), '*', new ItemStack(Blocks.PLANKS, 1, 0) });
//        // 安山岩栅栏
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.ANDESITE_FENCE, 6), new Object[] { "###", "###", '#',
//                new ItemStack(Blocks.STONE, 1, 5) });
//        // 挂落
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.IMPLICATE, 10), new Object[] { "#*#", "#*#", '*',
//                new ItemStack(Blocks.LOG, 1, 0), '#', Items.STICK });
//        // 安山岩路面楼梯
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.ANDESITE_PAVEMENT_STAIRS, 6), new Object[] { "#  ", "## ",
//                "###", '#', CWBlocks.ANDESITE_PAVEMENT });
//        // 橡木墙
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.OAK_WALL, 9), new Object[] { "###", "###", "###", '#',
//                new ItemStack(Blocks.PLANKS, 1, 0) });
//        // 中式木门
//        GameRegistry.addShapedRecipe(new ItemStack(CWItems.DOOR, 1), new Object[] { "#*", '#', Items.SPRUCE_DOOR, '*',
//                Blocks.PLANKS });
//
//        /* 屋顶 */
//        // 黑瓦屋顶半砖
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_SLAB, 6), new Object[] { "###", '#',
//                CWBlocks.BLACK_TILE_ROOF });
//        // 黑瓦屋顶半砖top
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_SLAB_TOP, 12), new Object[] { "###", "###",
//                '#', CWBlocks.BLACK_TILE_ROOF });
//        // 黑瓦屋脊top
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_RIDGE_ROOF_TOP, 3), new Object[] { "###", '#',
//                CWBlocks.BLACK_TILE_RIDGE_ROOF });
//        /* 薄墙 */
//        // 黑瓦屋顶半砖边缘左
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_Z, 4), new Object[] { "##", '#',
//                CWBlocks.BLACK_TILE_ROOF_EDGE_Z });
//        // 黑瓦屋顶半砖边缘左TOP
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_TOP_Z, 6), new Object[] { "###",
//                '#', CWBlocks.BLACK_TILE_ROOF_EDGE_Z });
//        // 黑瓦屋顶半砖边缘右
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_Y, 4), new Object[] { "##", '#',
//                CWBlocks.BLACK_TILE_ROOF_EDGE_Y });
//        // 黑瓦屋顶半砖边缘右TOP
//        GameRegistry.addShapedRecipe(new ItemStack(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_TOP_Y, 6), new Object[] { "###",
//                '#', CWBlocks.BLACK_TILE_ROOF_EDGE_Y });
    }

    private static void registerSmelting()
    {
        /* 装饰 */
        GameRegistry.addSmelting(CWItems.BLACK_CLAY, new ItemStack(CWItems.BLACK_BRICK), 0.5F);
    }

    private static void registerFuel()
    {

    }
}
