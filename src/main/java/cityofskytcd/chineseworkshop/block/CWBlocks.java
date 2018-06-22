/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CW;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(CW.MODID)
public class CWBlocks
{
    /* 方块 */
    // 黑砖墙
    @GameRegistry.ObjectHolder("black_brick_wall")
    public static final Block BLACK_BRICK_WALL = Blocks.AIR;
    // 黑粘土块
    @GameRegistry.ObjectHolder("black_clay_block")
    public static final Block BLACK_CLAY_BLOCK = Blocks.AIR;
    // 安山岩路面
    @GameRegistry.ObjectHolder("andesite_pavement")
    public static final Block ANDESITE_PAVEMENT = Blocks.AIR;
    // 红柱
    @GameRegistry.ObjectHolder("red_pillar")
    public static final Block RED_PILLAR = Blocks.AIR;
    // 绿柱
    @GameRegistry.ObjectHolder("dark_green_pillar")
    public static final Block DARK_GREEN_PILLAR = Blocks.AIR;
    // 白灰墙
    @GameRegistry.ObjectHolder("white_gray_wall")
    public static final Block WHITE_GRAY_WALL = Blocks.AIR;

    /* 灯 */
    // 石灯塔
    @GameRegistry.ObjectHolder("stone_tower_lamp")
    public static final Block STONE_TOWER_LAMP = Blocks.AIR;
    // 灯笼
    @GameRegistry.ObjectHolder("red_lantern")
    public static final Block RED_LANTERN = Blocks.AIR;
    // 蜡烛
    @GameRegistry.ObjectHolder("candle")
    public static final Block CANDLE = Blocks.AIR;
    // 白灯笼
    @GameRegistry.ObjectHolder("white_lantern")
    public static final Block WHITE_LANTERN = Blocks.AIR;

    /* 装饰 */
    // 斗栱
    @GameRegistry.ObjectHolder("bracket_set")
    public static final Block BRACKET_SET = Blocks.AIR;
    // 门墩
    @GameRegistry.ObjectHolder("men_dun")
    public static final Block MEN_DUN = Blocks.AIR;
    // 门槛
    @GameRegistry.ObjectHolder("threshold")
    public static final Block THRESHOLD = Blocks.AIR;
    // 雕饰
    @GameRegistry.ObjectHolder("carving")
    public static final Block CARVING = Blocks.AIR;
    // 树坛
    @GameRegistry.ObjectHolder("tree_altar")
    public static final Block TREE_ALTAR = Blocks.AIR;
    // 板凳
    @GameRegistry.ObjectHolder("bench")
    public static final Block BENCH = Blocks.AIR;
    // 桌子
    @GameRegistry.ObjectHolder("table")
    public static final Block TABLE = Blocks.AIR;
    // 白灰墙阶梯
    @GameRegistry.ObjectHolder("white_gray_wall_stairs")
    public static final Block WHITE_GRAY_WALL_STAIRS = Blocks.AIR;
    // 纸窗
    @GameRegistry.ObjectHolder("paper_window")
    public static final Block PAPER_WINDOW = Blocks.AIR;
    // 闪长岩栅栏
    @GameRegistry.ObjectHolder("diorite_fence")
    public static final Block DIORITE_FENCE = Blocks.AIR;
    // 小黑砖墙
    @GameRegistry.ObjectHolder("small_black_brick_wall")
    public static final Block SMALL_BLACK_BRICK_WALL = Blocks.AIR;
    // 小白灰墙
    @GameRegistry.ObjectHolder("small_white_gray_wall")
    public static final Block SMALL_WHITE_GRAY_WALL = Blocks.AIR;
    // 橡木中式栅栏
    @GameRegistry.ObjectHolder("oak_chinese_fence")
    public static final Block OAK_CHINESE_FENCE = Blocks.AIR;
    // 安山岩栅栏
    @GameRegistry.ObjectHolder("andesite_fence")
    public static final Block ANDESITE_FENCE = Blocks.AIR;
    // 挂落
    @GameRegistry.ObjectHolder("lithel_deco")
    public static final Block LITHEL_DECO = Blocks.AIR;
    // 安山岩路面阶梯
    @GameRegistry.ObjectHolder("andesite_pavement_stairs")
    public static final Block ANDESITE_PAVEMENT_STAIRS = Blocks.AIR;
    // 橡木墙
    @GameRegistry.ObjectHolder("oak_wall")
    public static final Block OAK_WALL = Blocks.AIR;
    // 中式木门
    @GameRegistry.ObjectHolder("door")
    public static final Block DOOR = Blocks.AIR;

    @GameRegistry.ObjectHolder("high_door")
    public static final Block HIGH_DOOR = Blocks.AIR;

    @GameRegistry.ObjectHolder("upper_door_frame")
    public static final Block UPPER_DOOR_FRAME = Blocks.AIR;

    /* 屋顶 */
    // 黑瓦屋顶
    @GameRegistry.ObjectHolder("black_tile_roof")
    public static final Block BLACK_TILE_ROOF = Blocks.AIR;
    // 黑瓦屋脊top
    @GameRegistry.ObjectHolder("black_tile_ridge_roof_top")
    public static final Block BLACK_TILE_RIDGE_ROOF_TOP = Blocks.AIR;
    // 黑瓦屋脊边缘
    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge")
    public static final Block BLACK_TILE_RIDGE_ROOF_EDGE = Blocks.AIR;
    // 黑瓦屋脊飞檐
    @GameRegistry.ObjectHolder("black_tile_ridge_roof_j")
    public static final Block BLACK_TILE_RIDGE_ROOF_J = Blocks.AIR;
    // 黑瓦屋顶飞檐
    @GameRegistry.ObjectHolder("black_tile_roof_j")
    public static final Block BLACK_TILE_ROOF_J = Blocks.AIR;
    // 黑瓦屋顶半砖
    @GameRegistry.ObjectHolder("black_tile_roof_slab")
    public static final Block BLACK_TILE_ROOF_SLAB = Blocks.AIR;
    // 黑瓦屋顶半砖top
    @GameRegistry.ObjectHolder("black_tile_roof_slab_top")
    public static final Block BLACK_TILE_ROOF_SLAB_TOP = Blocks.AIR;
    // 黑瓦屋脊边缘top
    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_top")
    public static final Block BLACK_TILE_RIDGE_ROOF_EDGE_TOP = Blocks.AIR;

    /* 薄墙 */
    // 薄白灰墙
    @GameRegistry.ObjectHolder("thin_white_gray_wall")
    public static final Block THIN_WHITE_GRAY_WALL = Blocks.AIR;
    // 黑瓦屋脊
    @GameRegistry.ObjectHolder("black_roof_tile_ridge")
    public static final Block BLACK_ROOF_TILE_RIDGE = Blocks.AIR;
    // 黑瓦屋顶边缘
    @GameRegistry.ObjectHolder("black_roof_tile_edge")
    public static final Block BLACK_ROOF_TILE_EDGE = Blocks.AIR;
    // 黑瓦屋顶边缘台阶
    @GameRegistry.ObjectHolder("black_roof_tile_edge_slab")
    public static final Block BLACK_ROOF_TILE_EDGE_SLAB = Blocks.AIR;
}
