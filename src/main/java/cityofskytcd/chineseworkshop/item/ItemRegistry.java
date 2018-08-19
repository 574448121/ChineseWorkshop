/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.block.CWBlocks;
import cityofskytcd.chineseworkshop.util.ModelUtil;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber()
public class ItemRegistry
{

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                new ItemCWLogo("logo"),
                new ItemCWMaterial(),
                new ItemCWBlock(CWBlocks.BLACK_BRICK_WALL),
                new ItemCWBlock(CWBlocks.BLACK_CLAY_BLOCK),
                new ItemCWBlock(CWBlocks.RED_PILLAR),
                new ItemCWBlock(CWBlocks.DARK_GREEN_PILLAR),
                new ItemCWBlock(CWBlocks.ANDESITE_PAVEMENT),
                new ItemCWBlock(CWBlocks.ANDESITE_PAVEMENT_STAIRS),
                new ItemCWBlock(CWBlocks.WHITE_GRAY_WALL),
                new ItemCWBlock(CWBlocks.WHITE_GRAY_WALL_STAIRS),
                new ItemCWBlock(CWBlocks.STONE_TOWER_LAMP),
                new ItemCWBlock(CWBlocks.CANDLE),
                new ItemCWBlock(CWBlocks.RED_LANTERN),
                new ItemCWBlock(CWBlocks.WHITE_LANTERN),
                new ItemCWBlock(CWBlocks.TREE_ALTAR),
                new ItemCWBlock(CWBlocks.TABLE),
                new ItemCWBlock(CWBlocks.BENCH),
                new ItemCWBlock(CWBlocks.PAPER_WINDOW),
                new ItemCWBlock(CWBlocks.BRACKET_SET),
                new ItemCWBlock(CWBlocks.CARVING),
                new ItemCWBlock(CWBlocks.SMALL_BLACK_BRICK_WALL),
                new ItemCWBlock(CWBlocks.SMALL_WHITE_GRAY_WALL),
                new ItemCWBlock(CWBlocks.THIN_WHITE_GRAY_WALL),
                new ItemCWBlock(CWBlocks.DIORITE_FENCE),
                new ItemCWBlock(CWBlocks.ANDESITE_FENCE),
                new ItemCWBlock(CWBlocks.OAK_CHINESE_FENCE),
                new ItemCWBlock(CWBlocks.LITHEL_DECO),
                new ItemCWBlock(CWBlocks.OAK_WALL),
                new ItemCWDoor("door", CWBlocks.DOOR),
                new ItemCWDoor("high_door", CWBlocks.HIGH_DOOR),
                new ItemCWDoor("wooden_window_door", CWBlocks.WOODEN_WINDOW_DOOR),
                new ItemCWDoor("window_door", CWBlocks.WINDOW_DOOR),
                new ItemCWBlock(CWBlocks.UPPER_DOOR_FRAME),
                new ItemCWBlock(CWBlocks.THRESHOLD),
                new ItemCWBlock(CWBlocks.MEN_DUN),
                // new ItemCWBlock(CWBlocks.DOOR),
                // new ItemCWBlock(CWBlocks.HIGH_DOOR),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_J),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_SLAB),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_SLAB_TOP),
                new ItemCWBlock(CWBlocks.BLACK_ROOF_TILE_RIDGE),
                new ItemCWBlockVariants(CWBlocks.BLACK_ROOF_TILE_EDGE, new String[] { "n", "j" }),
                new ItemCWBlockVariants(CWBlocks.BLACK_ROOF_TILE_EDGE_SLAB, new String[] { "n", "t" }),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_TOP),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_EDGE),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_J),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_EDGE_TOP),
                new ItemCWBlock(CWBlocks.FU),
                new ItemCWBlock(CWBlocks.RAMMED_EARTH),
                new ItemCWBlock(CWBlocks.RAMMED_EARTH_WALL),
                new ItemCWBlock(CWBlocks.RAMMED_EARTH_STAIRS),
                new ItemCWBlock(CWBlocks.STONE_WINDOW),
                new ItemCWBlock(CWBlocks.ROUGE_BRICK),
                new ItemCWBlock(CWBlocks.ROUGE_BRICK_WALL));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(@SuppressWarnings("unused") ModelRegistryEvent event)
    {
        ModelUtil.mapItemModel(CWItems.LOGO);
        ModelLoader.setCustomModelResourceLocation(
                CWItems.MATERIAL,
                0,
                new ModelResourceLocation(CW.MODID + ":black_clay", "inventory"));
        ModelLoader.setCustomModelResourceLocation(
                CWItems.MATERIAL,
                1,
                new ModelResourceLocation(CW.MODID + ":black_brick", "inventory"));
        ModelUtil.mapItemModel(CWItems.DOOR);
        ModelUtil.mapItemModel(CWItems.HIGH_DOOR);
        ModelUtil.mapItemModel(CWItems.WOODEN_WINDOW_DOOR);
        ModelUtil.mapItemModel(CWItems.WINDOW_DOOR);

        ModelUtil.mapItemModel(CWItems.BLACK_BRICK_WALL);
        ModelUtil.mapItemModel(CWItems.BLACK_CLAY_BLOCK);
        ModelUtil.mapItemModel(CWItems.ANDESITE_PAVEMENT);
        ModelUtil.mapItemModel(CWItems.RED_PILLAR);
        ModelUtil.mapItemModel(CWItems.DARK_GREEN_PILLAR);
        ModelUtil.mapItemModel(CWItems.WHITE_GRAY_WALL);
        ModelUtil.mapItemModel(CWItems.STONE_TOWER_LAMP);
        ModelUtil.mapItemModel(CWItems.RED_LANTERN);
        ModelUtil.mapItemModel(CWItems.CANDLE);
        ModelUtil.mapItemModel(CWItems.WHITE_LANTERN);
        ModelUtil.mapItemModel(CWItems.BRACKET_SET);
        ModelUtil.mapItemModel(CWItems.MEN_DUN);
        ModelUtil.mapItemModel(CWItems.THRESHOLD);
        ModelUtil.mapItemModel(CWItems.CARVING);
        ModelUtil.mapItemModel(CWItems.TREE_ALTAR);
        ModelUtil.mapItemModel(CWItems.BENCH);
        ModelUtil.mapItemModel(CWItems.TABLE);
        ModelUtil.mapItemModel(CWItems.WHITE_GRAY_WALL_STAIRS);
        ModelUtil.mapItemModel(CWItems.PAPER_WINDOW);
        ModelUtil.mapItemModel(CWItems.DIORITE_FENCE);
        ModelUtil.mapItemModel(CWItems.SMALL_BLACK_BRICK_WALL);
        ModelUtil.mapItemModel(CWItems.SMALL_WHITE_GRAY_WALL);
        ModelUtil.mapItemModel(CWItems.OAK_CHINESE_FENCE);
        ModelUtil.mapItemModel(CWItems.ANDESITE_FENCE);
        ModelUtil.mapItemModel(CWItems.LITHEL_DECO);
        ModelUtil.mapItemModel(CWItems.ANDESITE_PAVEMENT_STAIRS);
        ModelUtil.mapItemModel(CWItems.OAK_WALL);
        // ModelUtil.mapItemModel(CWItems.DOOR);
        // ModelUtil.mapItemModel(CWItems.HIGH_DOOR);
        ModelUtil.mapItemModel(CWItems.UPPER_DOOR_FRAME);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF);
        ModelUtil.mapItemModel(CWItems.BLACK_ROOF_TILE_RIDGE);
        ModelUtil.mapItemModel(CWItems.BLACK_ROOF_TILE_EDGE);
        ModelLoader.setCustomModelResourceLocation(
                CWItems.BLACK_ROOF_TILE_EDGE,
                1,
                new ModelResourceLocation(CW.MODID + ":black_roof_tile_edge_j", "inventory"));
        ModelUtil.mapItemModel(CWItems.BLACK_ROOF_TILE_EDGE_SLAB);
        ModelLoader.setCustomModelResourceLocation(
                CWItems.BLACK_ROOF_TILE_EDGE_SLAB,
                1,
                new ModelResourceLocation(CW.MODID + ":black_roof_tile_edge_slab_t", "inventory"));
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_TOP);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_J);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_J);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_SLAB);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_SLAB_TOP);
        ModelUtil.mapItemModel(CWItems.THIN_WHITE_GRAY_WALL);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_TOP);
        ModelUtil.mapItemModel(CWItems.FU);
        ModelUtil.mapItemModel(CWItems.RAMMED_EARTH);
        ModelUtil.mapItemModel(CWItems.RAMMED_EARTH_WALL);
        ModelUtil.mapItemModel(CWItems.RAMMED_EARTH_STAIRS);
        ModelUtil.mapItemModel(CWItems.STONE_WINDOW);
        ModelUtil.mapItemModel(CWItems.ROUGE_BRICK);
        ModelUtil.mapItemModel(CWItems.ROUGE_BRICK_WALL);

    }
}
