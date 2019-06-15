///**
// * This file is part of Chinese Workshop
// * (https://github.com/574448121/ChineseWorkshop)
// * 
// * Chinese Workshop is an Open-Source project under MIT License
// * (https://opensource.org/licenses/MIT)
// */
//
//package cityofskytcd.chineseworkshop.item;
//
//import cityofskytcd.chineseworkshop.CW;
//import net.minecraft.item.Item;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//
//@GameRegistry.ObjectHolder(CW.MODID)
//public class CWItems
//{
//    /* 图标 */
//    @GameRegistry.ObjectHolder("logo")
//    public static final Item LOGO = null;
//
//    /* 材料 */
//    @GameRegistry.ObjectHolder("material")
//    public static final Item MATERIAL = null;
//
//    /* 门 */
//    // 中式木门
//    @GameRegistry.ObjectHolder("door")
//    public static final Item DOOR = null;
//    // 中式大木门
//    @GameRegistry.ObjectHolder("high_door")
//    public static final Item HIGH_DOOR = null;
//    // 木窗门
//    @GameRegistry.ObjectHolder("wooden_window_door")
//    public static final Item WOODEN_WINDOW_DOOR = null;
//    // 窗门
//    @GameRegistry.ObjectHolder("window_door")
//    public static final Item WINDOW_DOOR = null;
//    // 中式木门
//    @GameRegistry.ObjectHolder("chinese_oak_door")
//    public static final Item CHINESE_OAK_DOOR = null;
//    // 染色红木板窗门
//    @GameRegistry.ObjectHolder("red_stained_wooden_planks_wooden_window_door")
//    public static final Item RED_STAINED_WOODEN_PLANKS_WOODEN_WINDOW_DOOR = null;
//
//    /* 方块 */
//    // 黑砖墙
//    @GameRegistry.ObjectHolder("black_brick_wall")
//    public static final Item BLACK_BRICK_WALL = null;
//    // 黑粘土块
//    @GameRegistry.ObjectHolder("black_clay_block")
//    public static final Item BLACK_CLAY_BLOCK = null;
//    // 安山岩路面
//    @GameRegistry.ObjectHolder("andesite_pavement")
//    public static final Item ANDESITE_PAVEMENT = null;
//    // 红柱
//    @GameRegistry.ObjectHolder("red_pillar")
//    public static final Item RED_PILLAR = null;
//    // 绿柱
//    @GameRegistry.ObjectHolder("dark_green_pillar")
//    public static final Item DARK_GREEN_PILLAR = null;
//    // 白灰墙
//    @GameRegistry.ObjectHolder("white_gray_wall")
//    public static final Item WHITE_GRAY_WALL = null;
//    // 福
//    @GameRegistry.ObjectHolder("fu")
//    public static final Item FU = null;
//    // 夯土
//    @GameRegistry.ObjectHolder("rammed_earth")
//    public static final Item RAMMED_EARTH = null;
//    // 胭脂砖
//    @GameRegistry.ObjectHolder("rouge_brick")
//    public static final Item ROUGE_BRICK = null;
//    // 染色红木板
//    @GameRegistry.ObjectHolder("red_stained_wooden_planks")
//    public static final Item RED_STAINED_WOODEN_PLANKS = null;
//    // 建筑彩绘
//    @GameRegistry.ObjectHolder("architectural_painting")
//    public static final Item ARCHITECTURAL_PAINTING = null;
//    
//    /* 灯 */
//    // 石灯塔
//    @GameRegistry.ObjectHolder("stone_tower_lamp")
//    public static final Item STONE_TOWER_LAMP = null;
//    // 灯笼
//    @GameRegistry.ObjectHolder("red_lantern")
//    public static final Item RED_LANTERN = null;
//    // 蜡烛
//    @GameRegistry.ObjectHolder("candle")
//    public static final Item CANDLE = null;
//    // 白灯笼
//    @GameRegistry.ObjectHolder("white_lantern")
//    public static final Item WHITE_LANTERN = null;
//    // 宫灯
//    @GameRegistry.ObjectHolder("palace_lantern")
//    public static final Item PALACE_LANTERN = null;
//
//    /* 装饰 */
//    // 斗栱
//    @GameRegistry.ObjectHolder("bracket_set")
//    public static final Item BRACKET_SET = null;
//    // 门墩
//    @GameRegistry.ObjectHolder("men_dun")
//    public static final Item MEN_DUN = null;
//    // 门槛
//    @GameRegistry.ObjectHolder("threshold")
//    public static final Item THRESHOLD = null;
//    // 雕饰
//    @GameRegistry.ObjectHolder("carving")
//    public static final Item CARVING = null;
//    // 树坛
//    @GameRegistry.ObjectHolder("tree_altar")
//    public static final Item TREE_ALTAR = null;
//    // 板凳
//    @GameRegistry.ObjectHolder("bench")
//    public static final Item BENCH = null;
//    // 桌子
//    @GameRegistry.ObjectHolder("table")
//    public static final Item TABLE = null;
//    // 白灰墙阶梯
//    @GameRegistry.ObjectHolder("white_gray_wall_stairs")
//    public static final Item WHITE_GRAY_WALL_STAIRS = null;
//    // 纸窗
//    @GameRegistry.ObjectHolder("paper_window")
//    public static final Item PAPER_WINDOW = null;
//    // 闪长岩栅栏
//    @GameRegistry.ObjectHolder("diorite_fence")
//    public static final Item DIORITE_FENCE = null;
//    // 小黑砖墙
//    @GameRegistry.ObjectHolder("small_black_brick_wall")
//    public static final Item SMALL_BLACK_BRICK_WALL = null;
//    // 小白灰墙
//    @GameRegistry.ObjectHolder("small_white_gray_wall")
//    public static final Item SMALL_WHITE_GRAY_WALL = null;
//    // 橡木中式栅栏
//    @GameRegistry.ObjectHolder("oak_chinese_fence")
//    public static final Item OAK_CHINESE_FENCE = null;
//    // 安山岩栅栏
//    @GameRegistry.ObjectHolder("andesite_fence")
//    public static final Item ANDESITE_FENCE = null;
//    // 挂落
//    @GameRegistry.ObjectHolder("lithel_deco")
//    public static final Item LITHEL_DECO = null;
//    // 安山岩路面阶梯
//    @GameRegistry.ObjectHolder("andesite_pavement_stairs")
//    public static final Item ANDESITE_PAVEMENT_STAIRS = null;
//    // 橡木墙
//    @GameRegistry.ObjectHolder("oak_wall")
//    public static final Item OAK_WALL = null;
//    // 中式木门
//    // @GameRegistry.ObjectHolder("door")
//    // public static final Item DOOR = null;
//    //
//    // @GameRegistry.ObjectHolder("high_door")
//    // public static final Item HIGH_DOOR = null;
//    // 门顶框
//    @GameRegistry.ObjectHolder("upper_door_frame")
//    public static final Item UPPER_DOOR_FRAME = null;
//    // 夯土墙
//    @GameRegistry.ObjectHolder("rammed_earth_wall")
//    public static final Item RAMMED_EARTH_WALL = null;
//    // 安山岩路面阶梯
//    @GameRegistry.ObjectHolder("rammed_earth_stairs")
//    public static final Item RAMMED_EARTH_STAIRS = null;
//    // 石窗
//    @GameRegistry.ObjectHolder("stone_window")
//    public static final Item STONE_WINDOW = null;
//    // 夯土墙
//    @GameRegistry.ObjectHolder("rouge_brick_wall")
//    public static final Item ROUGE_BRICK_WALL = null;
//    // 安山岩路面阶梯
//    @GameRegistry.ObjectHolder("rouge_brick_stairs")
//    public static final Item ROUGE_BRICK_STAIRS = null;
//    // 安山岩路面阶梯
//    @GameRegistry.ObjectHolder("black_brick_wall_stairs")
//    public static final Item BLACK_BRICK_WALL_STAIRS = null;
//    // 石窗
//    @GameRegistry.ObjectHolder("wooden_window")
//    public static final Item WOODEN_WINDOW = null;
//    // 木门槛
//    @GameRegistry.ObjectHolder("wooden_threshold")
//    public static final Item WOODEN_THRESHOLD = null;
//    // 田埂
//    @GameRegistry.ObjectHolder("field_ridge")
//    public static final Item FIELD_RIDGE = null;
//    // 染色红木板墙
//    @GameRegistry.ObjectHolder("red_stained_wooden_planks_wall")
//    public static final Item RED_STAINED_WOODEN_PLANKS_WALL = null;
//    // 染色红木板纸窗
//    @GameRegistry.ObjectHolder("red_stained_wooden_planks_paper_window")
//    public static final Item RED_STAINED_WOODEN_PLANKS_PAPER_WINDOW = null;
//    // 染色红木板门顶框
//    @GameRegistry.ObjectHolder("red_stained_wooden_planks_upper_door_frame")
//    public static final Item RED_STAINED_WOODEN_PLANKS_UPPER_DOOR_FRAME = null;
//    // 建筑彩绘
//    @GameRegistry.ObjectHolder("architectural_painting_wall")
//    public static final Item ARCHITECTURAL_PAINTING_WALL = null;
//    // 美人靠
//    @GameRegistry.ObjectHolder("mei_ren_kao")
//    public static final Item MEI_REN_KAO = null;
//    // 盆栽
//    @GameRegistry.ObjectHolder("potted")
//    public static final Item POTTED = null;
//
//    /* 屋顶 */
//    // 黑瓦屋顶
//    @GameRegistry.ObjectHolder("black_tile_roof")
//    public static final Item BLACK_TILE_ROOF = null;
//    // 黑瓦屋脊top
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_top")
//    public static final Item BLACK_TILE_RIDGE_ROOF_TOP = null;
//    //黑瓦屋脊边缘
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE = null;
//    // 黑瓦屋脊边缘top
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_top")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_TOP = null;
//    // 黑瓦屋脊飞檐
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_j")
//    public static final Item BLACK_TILE_RIDGE_ROOF_J = null;
//    // 黑瓦屋顶飞檐
//    @GameRegistry.ObjectHolder("black_tile_roof_j")
//    public static final Item BLACK_TILE_ROOF_J = null;
//    // 黑瓦屋顶半砖
//    @GameRegistry.ObjectHolder("black_tile_roof_slab")
//    public static final Item BLACK_TILE_ROOF_SLAB = null;
//    // 黑瓦屋顶半砖top
//    @GameRegistry.ObjectHolder("black_tile_roof_slab_top")
//    public static final Item BLACK_TILE_ROOF_SLAB_TOP = null;
//
//    
//	// 黑瓦屋顶边缘-木和黑砖、夯土和胭脂、圆石和白灰
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_wb")
//    public static final Item BLACK_ROOF_TILE_EDGE_WB = null;
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_rr")
//    public static final Item BLACK_ROOF_TILE_EDGE_RR = null;
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_cw")
//    public static final Item BLACK_ROOF_TILE_EDGE_CW = null;
//    //	黑瓦屋顶边缘半砖-木和黑砖、夯土和胭脂、圆石和白灰
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_slab_wb")
//    public static final Item BLACK_ROOF_TILE_EDGE_SLAB_WB = null;
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_slab_rr")
//    public static final Item BLACK_ROOF_TILE_EDGE_SLAB_RR = null;
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_slab_cw")
//    public static final Item BLACK_ROOF_TILE_EDGE_SLAB_CW = null;
//    //	黑瓦屋顶边缘上半砖-木和黑砖、夯土和胭脂、圆石和白灰
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_slab_t_wb")
//    public static final Item BLACK_ROOF_TILE_EDGE_SLAB_T_WB = null;
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_slab_t_rr")
//    public static final Item BLACK_ROOF_TILE_EDGE_SLAB_T_RR = null;
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_slab_t_cw")
//    public static final Item BLACK_ROOF_TILE_EDGE_SLAB_T_CW = null;
//    //	黑瓦屋顶边缘飞檐-木和黑砖、夯土和胭脂、圆石和白灰
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_j_wb")
//    public static final Item BLACK_ROOF_TILE_EDGE_J_WB = null;
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_j_rr")
//    public static final Item BLACK_ROOF_TILE_EDGE_J_RR = null;
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_j_cw")
//    public static final Item BLACK_ROOF_TILE_EDGE_J_CW = null;
//    
//    // 黄瓦屋顶
//    @GameRegistry.ObjectHolder("yellow_tile_roof")
//    public static final Item YELLOW_TILE_ROOF = null;
//    // 黄瓦屋脊
//    @GameRegistry.ObjectHolder("yellow_roof_tile_ridge")
//    public static final Item YELLOW_ROOF_TILE_RIDGE = null;
//    // 黄瓦屋脊top
//    @GameRegistry.ObjectHolder("yellow_tile_ridge_roof_top")
//    public static final Item YELLOW_TILE_RIDGE_ROOF_TOP = null;
//    // 黄瓦屋脊边缘
//    @GameRegistry.ObjectHolder("yellow_tile_ridge_roof_edge")
//    public static final Item YELLOW_TILE_RIDGE_ROOF_EDGE = null;
//    // 黄瓦屋脊飞檐
//    @GameRegistry.ObjectHolder("yellow_tile_ridge_roof_j")
//    public static final Item YELLOW_TILE_RIDGE_ROOF_J = null;
//    // 黄瓦屋顶飞檐
//    @GameRegistry.ObjectHolder("yellow_tile_roof_j")
//    public static final Item YELLOW_TILE_ROOF_J = null;
//    // 黄瓦屋顶半砖
//    @GameRegistry.ObjectHolder("yellow_tile_roof_slab")
//    public static final Item YELLOW_TILE_ROOF_SLAB = null;
//    // 黄瓦屋顶半砖top
//    @GameRegistry.ObjectHolder("yellow_tile_roof_slab_top")
//    public static final Item YELLOW_TILE_ROOF_SLAB_TOP = null;
//    // 黄瓦屋脊边缘top
//    @GameRegistry.ObjectHolder("yellow_tile_ridge_roof_edge_top")
//    public static final Item YELLOW_TILE_RIDGE_ROOF_EDGE_TOP = null;
//
//    // 茅草屋顶
//    @GameRegistry.ObjectHolder("thatch_roof")
//    public static final Item THATCH_ROOF = null;
//    // 茅草屋脊
//    @GameRegistry.ObjectHolder("thatch_tile_ridge_roof")
//    public static final Item THATCH_TILE_RIDGE_ROOF = null;
//    // 茅草屋脊top
//    @GameRegistry.ObjectHolder("thatch_tile_ridge_roof_top")
//    public static final Item THATCH_TILE_RIDGE_ROOF_TOP = null;
//    // 茅草屋顶半砖
//    @GameRegistry.ObjectHolder("thatch_tile_roof_slab")
//    public static final Item THATCH_TILE_ROOF_SLAB = null;
//    // 茅草屋顶半砖top
//    @GameRegistry.ObjectHolder("thatch_tile_roof_slab_top")
//    public static final Item THATCH_TILE_ROOF_SLAB_TOP = null;
//    // 茅草屋顶边缘
//    @GameRegistry.ObjectHolder("thatch_roof_tile_edge")
//    public static final Item THATCH_ROOF_TILE_EDGE = null;
//    // 茅草屋顶半砖边缘
//    @GameRegistry.ObjectHolder("thatch_roof_tile_edge_slab")
//    public static final Item THATCH_ROOF_TILE_EDGE_SLAB = null;
//    // 茅草屋脊边缘
//    @GameRegistry.ObjectHolder("thatch_tile_ridge_roof_edge")
//    public static final Item THATCH_TILE_RIDGE_ROOF_EDGE = null;
//    // 茅草屋脊边缘
//    @GameRegistry.ObjectHolder("thatch_tile_ridge_roof_edge_top")
//    public static final Item THATCH_TILE_RIDGE_ROOF_EDGE_TOP = null;
//
//    /* 薄墙 */
//    // 薄白灰墙
//    @GameRegistry.ObjectHolder("thin_white_gray_wall")
//    public static final Item THIN_WHITE_GRAY_WALL = null;
//    // 黑瓦屋脊
//    @GameRegistry.ObjectHolder("black_roof_tile_ridge")
//    public static final Item BLACK_ROOF_TILE_RIDGE = null;
//    // 黑瓦屋顶边缘
//    @GameRegistry.ObjectHolder("black_roof_tile_edge")
//    public static final Item BLACK_ROOF_TILE_EDGE = null;
//    // 黑瓦屋顶边缘台阶
//    @GameRegistry.ObjectHolder("black_roof_tile_edge_slab")
//    public static final Item BLACK_ROOF_TILE_EDGE_SLAB = null;
//
//    // 黄瓦屋顶边缘
//    @GameRegistry.ObjectHolder("yellow_roof_tile_edge")
//    public static final Item YELLOW_ROOF_TILE_EDGE = null;
//    // 黄瓦屋顶边缘台阶
//    @GameRegistry.ObjectHolder("yellow_roof_tile_edge_slab")
//    public static final Item YELLOW_ROOF_TILE_EDGE_SLAB = null;
//    
//    // 薄墙-木、黑砖、圆石、胭脂砖、夯土、白灰
//    @GameRegistry.ObjectHolder("thin_wall_w")
//    public static final Item THIN_WALL_W = null;
//    @GameRegistry.ObjectHolder("thin_wall_bb")
//    public static final Item THIN_WALL_BB = null;
//    @GameRegistry.ObjectHolder("thin_wall_c")
//    public static final Item THIN_WALL_C = null;
//    @GameRegistry.ObjectHolder("thin_wall_rb")
//    public static final Item THIN_WALL_RB = null;
//    @GameRegistry.ObjectHolder("thin_wall_re")
//    public static final Item THIN_WALL_RE = null;
//    @GameRegistry.ObjectHolder("thin_wall_wg")
//    public static final Item THIN_WALL_WG = null;
//    
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_w")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_W = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_bb")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_BB = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_c")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_C = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_rb")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_RB = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_re")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_RE = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_wg")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_WG = null;
//    
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_t_w")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_T_W = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_t_bb")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_T_BB = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_t_c")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_T_C = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_t_rb")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_T_RB = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_t_re")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_T_RE = null;
//    @GameRegistry.ObjectHolder("black_tile_ridge_roof_edge_t_wg")
//    public static final Item BLACK_TILE_RIDGE_ROOF_EDGE_T_WG = null;
//}
