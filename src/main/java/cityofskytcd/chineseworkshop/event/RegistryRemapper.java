package cityofskytcd.chineseworkshop.event;

import java.util.HashMap;
import java.util.Map;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.block.CWBlocks;
import cityofskytcd.chineseworkshop.item.CWItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryRemapper
{
    public static void init()
    {
    }

    @SubscribeEvent
    public static void MissingMappingsBlock(RegistryEvent.MissingMappings<Block> event)
    {
        Map<String, Block> blockMappings = new HashMap<>();

        blockMappings.put("red_pillars", CWBlocks.RED_PILLAR);
        blockMappings.put("dark_green_pillars", CWBlocks.DARK_GREEN_PILLAR);
        blockMappings.put("white_gray_walls", CWBlocks.WHITE_GRAY_WALL);
        blockMappings.put("the_lantern", CWBlocks.RED_LANTERN);
        blockMappings.put("white_lanterns", CWBlocks.WHITE_LANTERN);
        blockMappings.put("door_threshold", CWBlocks.THRESHOLD);
        blockMappings.put("white_gray_walls_stairs", CWBlocks.WHITE_GRAY_WALL_STAIRS);
        blockMappings.put("small_white_gray_walls", CWBlocks.SMALL_WHITE_GRAY_WALL);
        blockMappings.put("thin_white_gray_walls", CWBlocks.THIN_WHITE_GRAY_WALL);
        blockMappings.put("implicate", CWBlocks.LITHEL_DECO);
        blockMappings.put("black_tile_ridge_roof", CWBlocks.BLACK_ROOF_TILE_RIDGE);
        blockMappings.put("black_tile_ridge_roof_l", CWBlocks.BLACK_ROOF_TILE_RIDGE);
        blockMappings.put("black_tile_ridge_roof_t", CWBlocks.BLACK_ROOF_TILE_RIDGE);
        blockMappings.put("black_tile_ridge_roof_x", CWBlocks.BLACK_ROOF_TILE_RIDGE);
        blockMappings.put("black_tile_roof_edge_y", CWBlocks.BLACK_ROOF_TILE_EDGE);
        blockMappings.put("black_tile_roof_edge_z", CWBlocks.BLACK_ROOF_TILE_EDGE);
        blockMappings.put("black_tile_roof_edge_yj", CWBlocks.BLACK_ROOF_TILE_EDGE);
        blockMappings.put("black_tile_roof_edge_zj", CWBlocks.BLACK_ROOF_TILE_EDGE);
        blockMappings.put("black_tile_roof_edge_slab_z", CWBlocks.BLACK_ROOF_TILE_EDGE_SLAB);
        blockMappings.put("black_tile_roof_edge_slab_y", CWBlocks.BLACK_ROOF_TILE_EDGE_SLAB);
        blockMappings.put("black_tile_roof_edge_slab_top_z", CWBlocks.BLACK_ROOF_TILE_EDGE_SLAB);
        blockMappings.put("black_tile_roof_edge_slab_top_y", CWBlocks.BLACK_ROOF_TILE_EDGE_SLAB);

        for (Mapping<Block> mapping : event.getAllMappings())
        {
            if (mapping.key.getResourceDomain().equals(CW.MODID)
                    && blockMappings.containsKey(mapping.key.getResourcePath()))
            {
                mapping.remap(blockMappings.get(mapping.key.getResourcePath()));
            }
        }
    }

    @SubscribeEvent
    public static void MissingMappingsItem(RegistryEvent.MissingMappings<Item> event)
    {
        Map<String, Item> itemMappings = new HashMap<>();

        itemMappings.put("black_clay", CWItems.MATERIAL);
        itemMappings.put("black_brick", CWItems.MATERIAL);
        itemMappings.put("red_pillars", CWItems.RED_PILLAR);
        itemMappings.put("dark_green_pillars", CWItems.DARK_GREEN_PILLAR);
        itemMappings.put("white_gray_walls", CWItems.WHITE_GRAY_WALL);
        itemMappings.put("the_lantern", CWItems.RED_LANTERN);
        itemMappings.put("white_lanterns", CWItems.WHITE_LANTERN);
        itemMappings.put("door_threshold", CWItems.THRESHOLD);
        itemMappings.put("white_gray_walls_stairs", CWItems.WHITE_GRAY_WALL_STAIRS);
        itemMappings.put("small_white_gray_walls", CWItems.SMALL_WHITE_GRAY_WALL);
        itemMappings.put("thin_white_gray_walls", CWItems.THIN_WHITE_GRAY_WALL);
        itemMappings.put("implicate", CWItems.LITHEL_DECO);
        itemMappings.put("black_tile_ridge_roof", CWItems.BLACK_ROOF_TILE_RIDGE);
        itemMappings.put("black_tile_ridge_roof_l", CWItems.BLACK_ROOF_TILE_RIDGE);
        itemMappings.put("black_tile_ridge_roof_t", CWItems.BLACK_ROOF_TILE_RIDGE);
        itemMappings.put("black_tile_ridge_roof_x", CWItems.BLACK_ROOF_TILE_RIDGE);
        itemMappings.put("black_tile_roof_edge_y", CWItems.BLACK_ROOF_TILE_EDGE);
        itemMappings.put("black_tile_roof_edge_z", CWItems.BLACK_ROOF_TILE_EDGE);
        itemMappings.put("black_tile_roof_edge_yj", CWItems.BLACK_ROOF_TILE_EDGE);
        itemMappings.put("black_tile_roof_edge_zj", CWItems.BLACK_ROOF_TILE_EDGE);
        itemMappings.put("black_tile_roof_edge_slab_z", CWItems.BLACK_ROOF_TILE_EDGE_SLAB);
        itemMappings.put("black_tile_roof_edge_slab_y", CWItems.BLACK_ROOF_TILE_EDGE_SLAB);
        itemMappings.put("black_tile_roof_edge_slab_top_z", CWItems.BLACK_ROOF_TILE_EDGE_SLAB);
        itemMappings.put("black_tile_roof_edge_slab_top_y", CWItems.BLACK_ROOF_TILE_EDGE_SLAB);

        for (Mapping<Item> mapping : event.getAllMappings())
        {
            if (mapping.key.getResourceDomain().equals(CW.MODID)
                    && itemMappings.containsKey(mapping.key.getResourcePath()))
            {
                mapping.remap(itemMappings.get(mapping.key.getResourcePath()));
            }
        }
    }
}
