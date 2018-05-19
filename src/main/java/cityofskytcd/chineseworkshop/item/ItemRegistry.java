/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.block.CWBlocks;
import cityofskytcd.chineseworkshop.util.ModelUtil;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
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
                new ItemCW("black_clay"),
                new ItemCW("black_brick"),
                new ItemCWDoor("door", CWBlocks.DOOR),
                new ItemCWDoor("high_door", CWBlocks.HIGH_DOOR),
                new ItemCWBlock(CWBlocks.BLACK_BRICK_WALL),
                new ItemCWBlock(CWBlocks.ANDESITE_PAVEMENT),
                new ItemCWBlock(CWBlocks.RED_PILLAR),
                new ItemCWBlock(CWBlocks.DARK_GREEN_PILLAR),
                new ItemCWBlock(CWBlocks.WHITE_GRAY_WALL),
                new ItemCWBlock(CWBlocks.STONE_TOWER_LAMP),
                new ItemCWBlock(CWBlocks.RED_LANTERN),
                new ItemCWBlock(CWBlocks.CANDLE),
                new ItemCWBlock(CWBlocks.WHITE_LANTERN),
                new ItemCWBlock(CWBlocks.BRACKET_SET),
                new ItemCWBlock(CWBlocks.MEN_DUN),
                new ItemCWBlock(CWBlocks.THRESHOLD),
                new ItemCWBlock(CWBlocks.CARVING),
                new ItemCWBlock(CWBlocks.TREE_ALTAR),
                new ItemCWBlock(CWBlocks.BENCH),
                new ItemCWBlock(CWBlocks.TABLE),
                new ItemCWBlock(CWBlocks.WHITE_GRAY_WALL_STAIRS),
                new ItemCWBlock(CWBlocks.PAPER_WINDOW),
                new ItemCWBlock(CWBlocks.DIORITE_FENCE),
                new ItemCWBlock(CWBlocks.SMALL_BLACK_BRICK_WALL),
                new ItemCWBlock(CWBlocks.SMALL_WHITE_GRAY_WALL),
                new ItemCWBlock(CWBlocks.OAK_CHINESE_FENCE),
                new ItemCWBlock(CWBlocks.ANDESITE_FENCE),
                new ItemCWBlock(CWBlocks.IMPLICATE),
                new ItemCWBlock(CWBlocks.ANDESITE_PAVEMENT_STAIRS),
                new ItemCWBlock(CWBlocks.OAK_WALL),
                // new ItemCWBlock(CWBlocks.DOOR),
                // new ItemCWBlock(CWBlocks.HIGH_DOOR),
                new ItemCWBlock(CWBlocks.UPPER_DOOR_FRAME),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_TOP),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_L),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_EDGE),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_T),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_X),
                new ItemCWBlock(CWBlocks.BLACK_TILE_RIDGE_ROOF_J),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_J),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_SLAB),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_SLAB_TOP),
                new ItemCWBlock(CWBlocks.THIN_WHITE_GRAY_WALL),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_Y),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_Z),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_YJ),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_ZJ),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_Z),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_TOP_Z),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_Y),
                new ItemCWBlock(CWBlocks.BLACK_TILE_ROOF_EDGE_SLAB_TOP_Y));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(ModelRegistryEvent event)
    {
        ModelUtil.mapItemModel(CWItems.LOGO);
        ModelUtil.mapItemModel(CWItems.BLACK_CLAY);
        ModelUtil.mapItemModel(CWItems.BLACK_BRICK);
        ModelUtil.mapItemModel(CWItems.DOOR);
        ModelUtil.mapItemModel(CWItems.HIGH_DOOR);

        ModelUtil.mapItemModel(CWItems.BLACK_BRICK_WALL);
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
        ModelUtil.mapItemModel(CWItems.IMPLICATE);
        ModelUtil.mapItemModel(CWItems.ANDESITE_PAVEMENT_STAIRS);
        ModelUtil.mapItemModel(CWItems.OAK_WALL);
        // ModelUtil.mapItemModel(CWItems.DOOR);
        // ModelUtil.mapItemModel(CWItems.HIGH_DOOR);
        ModelUtil.mapItemModel(CWItems.UPPER_DOOR_FRAME);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_TOP);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_L);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_T);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_X);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_RIDGE_ROOF_J);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_J);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_SLAB);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_SLAB_TOP);
        ModelUtil.mapItemModel(CWItems.THIN_WHITE_GRAY_WALL);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_EDGE_Y);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_EDGE_Z);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_EDGE_YJ);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_EDGE_ZJ);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_EDGE_SLAB_Z);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_EDGE_SLAB_TOP_Z);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_EDGE_SLAB_Y);
        ModelUtil.mapItemModel(CWItems.BLACK_TILE_ROOF_EDGE_SLAB_TOP_Y);
    }
}
