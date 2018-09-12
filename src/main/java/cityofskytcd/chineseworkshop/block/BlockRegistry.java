/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber()
public class BlockRegistry
{

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(
                // 方块
                new BlockCW("black_brick_wall", Material.ROCK, 1.5F),
                new BlockCW("white_gray_wall", Material.ROCK, MapColor.QUARTZ, 1.5F),
                new BlockCW("rammed_earth", Material.ROCK, 1.5F),
                new BlockCW("rouge_brick", Material.ROCK, 1.5F),
                new BlockCWRotatedPillar("red_pillar", Material.WOOD, 1.0F),
                new BlockCWRotatedPillar("dark_green_pillar", Material.WOOD, 1.0F),
                new BlockCWBlackClay("black_clay_block", Material.CLAY, 1F),

                // 屋顶
                new BlockCWRoof("black_tile_roof", Material.ROCK, 1.5F),
                new BlockCWRoofTileRidge("black_roof_tile_ridge", Material.ROCK, 1.0F),
                new BlockCWRoofTileEdge("black_roof_tile_edge", Material.ROCK, 1.0F),
                new BlockCWRoofTileEdgeSlab("black_roof_tile_edge_slab", Material.ROCK, 1.0F),
                new BlockCWRoofTileRidge("black_tile_ridge_roof_top", Material.ROCK, 1.5F),
                new BlockCWTFace("black_tile_ridge_roof_edge", Material.ROCK, 1.5F),
                new BlockCWTFace("black_tile_ridge_roof_j", Material.ROCK, 1.5F),
                new BlockCWTFace("black_tile_roof_j", Material.ROCK, 1.5F),
                new BlockCWRoofSlab("black_tile_roof_slab", Material.ROCK, 1.5F),
                new BlockCWRoof("black_tile_roof_slab_top", Material.ROCK, 1.5F),
                new BlockCWTFace("black_tile_ridge_roof_edge_top", Material.ROCK, 1.5F),

                new BlockCWRoof("yellow_tile_roof", Material.ROCK, 1.5F),
                new BlockCWRoofTileRidge("yellow_roof_tile_ridge", Material.ROCK, 1.0F),
                new BlockCWRoofTileEdge("yellow_roof_tile_edge", Material.ROCK, 1.0F),
                new BlockCWRoofTileEdgeSlab("yellow_roof_tile_edge_slab", Material.ROCK, 1.0F),
                new BlockCWRoofTileRidge("yellow_tile_ridge_roof_top", Material.ROCK, 1.5F),
                new BlockCWTFace("yellow_tile_ridge_roof_edge", Material.ROCK, 1.5F),
                new BlockCWTFace("yellow_tile_ridge_roof_j", Material.ROCK, 1.5F),
                new BlockCWTFace("yellow_tile_roof_j", Material.ROCK, 1.5F),
                new BlockCWRoofSlab("yellow_tile_roof_slab", Material.ROCK, 1.5F),
                new BlockCWRoof("yellow_tile_roof_slab_top", Material.ROCK, 1.5F),
                new BlockCWTFace("yellow_tile_ridge_roof_edge_top", Material.ROCK, 1.5F),
                
                new BlockCWRoof("thatch_roof", Material.ROCK, 1.5F),
                new BlockCWRoofTileRidge("thatch_tile_ridge_roof", Material.ROCK, 1.0F),
                new BlockCWRoofTileRidge("thatch_tile_ridge_roof_top", Material.ROCK, 1.5F),
                new BlockCWRoofSlab("thatch_tile_roof_slab", Material.ROCK, 1.5F),
                new BlockCWRoof("thatch_tile_roof_slab_top", Material.ROCK, 1.5F),
                
                // 门
                new BlockCWDoor("door", Material.WOOD, 1.5F),
                new BlockCWDoor("wooden_window_door", Material.WOOD, 1.5F),
                new BlockCWDoor("high_door", Material.WOOD, 1.5F),
                new BlockCWUpperDoorFrame("upper_door_frame", Material.WOOD, MapColor.WOOD, 1.5F),
                new BlockCWDoor("window_door", Material.WOOD, 1.5F),

                // 墙
                new BlockCWSmallFence("small_black_brick_wall", Material.ROCK, MapColor.STONE, 1.5F),
                new BlockCWSmallFence("small_white_gray_wall", Material.ROCK, MapColor.STONE, 1.5F),
                new BlockCWSmallFence("oak_wall", Material.WOOD, MapColor.WOOD, 1.5F),
                new BlockCWSmallFence("rammed_earth_wall", Material.ROCK, MapColor.STONE, 1.5F),
                new BlockCWSmallFence("rouge_brick_wall", Material.ROCK, MapColor.STONE, 1.5F),

                // 灯
                new BlockCWLight("stone_tower_lamp", Material.ROCK, 1.0F, 1.0f),
                new BlockCWCandle("candle", Material.WOOD, 1.0F),
                new BlockCWLantern("red_lantern", Material.WOOD, 0.5F),
                new BlockCWLantern("white_lantern", Material.CLOTH, 0.5F),
                new BlockCWLantern("palace_lantern", Material.WOOD, 0.5F),

                // 装饰
                new BlockCWFace("andesite_pavement", Material.ROCK, 1.5F),
                new BlockCWThinWall("thin_white_gray_wall", Material.ROCK, 1.0F),
                new BlockCWDougong("bracket_set", Material.WOOD, 0.5F),
                new BlockCWMenDun("men_dun", Material.ROCK, 1.5F),
                new BlockCWThreshold("threshold", Material.ROCK, 1.0F),
                new BlockCWTFace("carving", Material.WOOD, 0.5F),
                new BlockCWTreeBed("tree_altar", Material.ROCK, 1.5F),
                new BlockCWBench("bench", Material.WOOD, 0.5F),
                new BlockCWTable("table", Material.WOOD, 1.0F),
                new BlockCWStairs("white_gray_wall_stairs", Blocks.STONE.getDefaultState(), 1.5F),
                new BlockCWPane("paper_window", Material.WOOD, true, 0.5F),
                new BlockCWFence("diorite_fence", Material.ROCK, MapColor.STONE, 1.5F),
                new BlockCWFence("oak_chinese_fence", Material.WOOD, MapColor.WOOD, 1.5F),
                new BlockCWWall("andesite_fence", Blocks.STONE, 1.5F),
                new BlockCWPane("lithel_deco", Material.WOOD, true, 1.0F),
                new BlockCWStairs("andesite_pavement_stairs", Blocks.STONE.getDefaultState(), 1.5F),
                new BlockCWThinWall("fu", Material.WOOD, 1.0F),
                new BlockCWStairs("rammed_earth_stairs", Blocks.STONE.getDefaultState(), 1.5F),
                new BlockCWPane("stone_window", Material.ROCK, true, 1.0F),
                new BlockCWStairs("rouge_brick_stairs", Blocks.STONE.getDefaultState(), 1.5F),
                new BlockCWStairs("black_brick_wall_stairs", Blocks.STONE.getDefaultState(), 1.5F));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(@SuppressWarnings("unused") ModelRegistryEvent event)
    {
        ModelLoader.setCustomStateMapper(CWBlocks.DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        ModelLoader.setCustomStateMapper(CWBlocks.HIGH_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.WOODEN_WINDOW_DOOR,
                new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.WINDOW_DOOR,
                new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.BLACK_ROOF_TILE_RIDGE,
                new StateMap.Builder().ignore(BlockCWTFace2D.FACING).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.BLACK_TILE_RIDGE_ROOF_TOP,
                new StateMap.Builder().ignore(BlockCWTFace2D.FACING).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.YELLOW_ROOF_TILE_RIDGE,
                new StateMap.Builder().ignore(BlockCWTFace2D.FACING).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.YELLOW_TILE_RIDGE_ROOF_TOP,
                new StateMap.Builder().ignore(BlockCWTFace2D.FACING).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.THATCH_TILE_RIDGE_ROOF,
                new StateMap.Builder().ignore(BlockCWTFace2D.FACING).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.THATCH_TILE_RIDGE_ROOF_TOP,
                new StateMap.Builder().ignore(BlockCWTFace2D.FACING).build());
    }

}
