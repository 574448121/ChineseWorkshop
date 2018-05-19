package cityofskytcd.chineseworkshop.event;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.block.CWBlocks;
import cityofskytcd.chineseworkshop.item.CWItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryRemapper
{
    private static Map<String, Block> blockMappings = new HashMap<>();
    private static Map<String, Item> itemMappings = new HashMap<>();

    public static void init()
    {
        blockMappings.put("red_pillars", CWBlocks.RED_PILLAR);
        blockMappings.put("dark_green_pillars", CWBlocks.DARK_GREEN_PILLAR);
        blockMappings.put("white_gray_walls", CWBlocks.WHITE_GRAY_WALL);
        blockMappings.put("the_lantern", CWBlocks.RED_LANTERN);
        blockMappings.put("white_lanterns", CWBlocks.WHITE_LANTERN);
        blockMappings.put("door_threshold", CWBlocks.THRESHOLD);
        blockMappings.put("white_gray_walls_stairs", CWBlocks.WHITE_GRAY_WALL_STAIRS);
        blockMappings.put("small_white_gray_walls", CWBlocks.SMALL_WHITE_GRAY_WALL);
        blockMappings.put("thin_white_gray_walls", CWBlocks.THIN_WHITE_GRAY_WALL);

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
    }

    @SubscribeEvent
    public static void MissingMappingsBlock(RegistryEvent.MissingMappings<Block> event)
    {
        ImmutableList<Mapping<Block>> mappings = event.getAllMappings();
        for (RegistryEvent.MissingMappings.Mapping mapping : mappings)
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
        ImmutableList<Mapping<Item>> mappings = event.getAllMappings();
        for (RegistryEvent.MissingMappings.Mapping mapping : mappings)
        {
            if (mapping.key.getResourceDomain().equals(CW.MODID)
                    && itemMappings.containsKey(mapping.key.getResourcePath()))
            {
                mapping.remap(itemMappings.get(mapping.key.getResourcePath()));
            }
        }
    }
}
