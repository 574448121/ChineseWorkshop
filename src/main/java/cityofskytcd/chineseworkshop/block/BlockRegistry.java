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
                new BlockCW("black_brick_wall", Material.ROCK, 1.5F),
                new BlockCWBlackClay("black_clay_block", Material.CLAY, 1F),
                new BlockCWFace("andesite_pavement", Material.ROCK, 1.5F),
                new BlockCWRotatedPillar("red_pillar", Material.WOOD, 1.0F),
                new BlockCWRotatedPillar("dark_green_pillar", Material.WOOD, 1.0F),
                new BlockCW("white_gray_wall", Material.ROCK, 1.5F),
                new BlockCWLight("stone_tower_lamp", Material.ROCK, 1.0F, 1.0f),
                new BlockCWLantern("red_lantern", Material.WOOD, 0.5F, 1.0f),
                new BlockCWCandle("candle", Material.WOOD, 1.0F),
                new BlockCWLantern("white_lantern", Material.CLOTH, 0.5F, 1.0f),
                new BlockCWDougong("bracket_set", Material.WOOD, 0.5F),
                new BlockCWMenDun("men_dun", Material.ROCK, 1.5F),
                new BlockCWThreshold("threshold", Material.ROCK, 1.0F),
                new BlockCWTFace("carving", Material.WOOD, 0.5F),
                new BlockCWTreeAltar("tree_altar", Material.ROCK, 1.5F),
                new BlockCWBench("bench", Material.WOOD, 0.5F),
                new BlockCWTable("table", Material.WOOD, 1.0F),
                new BlockCWStairs("white_gray_wall_stairs", Blocks.STONE.getDefaultState(), 1.5F),
                new BlockCWPane("paper_window", Material.WOOD, true, 0.5F),
                new BlockCWFence("diorite_fence", Material.ROCK, MapColor.STONE, 1.5F),
                new BlockCWSmallFence("small_black_brick_wall", Material.ROCK, MapColor.STONE, 1.5F),
                new BlockCWSmallFence("small_white_gray_wall", Material.ROCK, MapColor.STONE, 1.5F),
                new BlockCWFence("oak_chinese_fence", Material.WOOD, MapColor.WOOD, 1.5F),
                new BlockCWWall("andesite_fence", Blocks.STONE, 1.5F),
                new BlockCWPane("lithel_deco", Material.WOOD, true, 1.0F),
                new BlockCWStairs("andesite_pavement_stairs", Blocks.STONE.getDefaultState(), 1.5F),
                new BlockCWSmallFence("oak_wall", Material.WOOD, MapColor.WOOD, 1.5F),
                new BlockCWDoor("door", Material.WOOD, 1.5F),
                new BlockCWDoor("high_door", Material.WOOD, 1.5F),
                new BlockCWUpperDoorFrame("upper_door_frame", Material.WOOD, MapColor.WOOD, 1.5F),
                new BlockCWRoof("black_tile_roof", Material.ROCK, 1.5F),
                new BlockCWRoofTileRidge("black_roof_tile_ridge", Material.ROCK, 1.0F),
                new BlockCWFaceRoof("black_tile_ridge_roof_top", Material.ROCK, 1.5F),
                new BlockCWFaceRoof("black_tile_ridge_roof_edge", Material.ROCK, 1.5F),
                new BlockCWFaceRoof("black_tile_ridge_roof_j", Material.ROCK, 1.5F),
                new BlockCWFaceRoof("black_tile_roof_j", Material.ROCK, 1.5F),
                new BlockCWRoofSlab("black_tile_roof_slab", Material.ROCK, 1.5F),
                new BlockCWRoof("black_tile_roof_slab_top", Material.ROCK, 1.5F),
                new BlockCWFaceThinWall("thin_white_gray_wall", Material.ROCK, 1.0F),
                new BlockCWFaceThinWall("black_tile_roof_edge_y", Material.ROCK, 1.0F),
                new BlockCWFaceThinWall("black_tile_roof_edge_z", Material.ROCK, 1.0F),
                new BlockCWFaceThinWall("black_tile_roof_edge_yj", Material.ROCK, 1.0F),
                new BlockCWFaceThinWall("black_tile_roof_edge_zj", Material.ROCK, 1.0F),
                new BlockCWFaceThinWallSlab("black_tile_roof_edge_slab_z", Material.ROCK, 1.0F),
                new BlockCWFaceThinWall("black_tile_roof_edge_slab_top_z", Material.ROCK, 1.0F),
                new BlockCWFaceThinWallSlab("black_tile_roof_edge_slab_y", Material.ROCK, 1.0F),
                new BlockCWFaceThinWall("black_tile_roof_edge_slab_top_y", Material.ROCK, 1.0F));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(ModelRegistryEvent event)
    {
        ModelLoader.setCustomStateMapper(CWBlocks.DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        ModelLoader.setCustomStateMapper(CWBlocks.HIGH_DOOR, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
        ModelLoader.setCustomStateMapper(
                CWBlocks.BLACK_ROOF_TILE_RIDGE,
                new StateMap.Builder().ignore(BlockCWTFace2D.FACING).build());
    }
}
