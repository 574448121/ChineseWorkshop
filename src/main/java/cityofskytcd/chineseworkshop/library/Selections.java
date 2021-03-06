package cityofskytcd.chineseworkshop.library;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.item.CWItems;
import net.minecraft.item.ItemStack;

public class Selections
{
    private static Set<ImmutableList<ItemDefinition>> selections = new HashSet<>();

    public static void init()
    {
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_TILE_ROOF),
                        ItemDefinition.of(CWItems.BLACK_TILE_ROOF_J),
                        ItemDefinition.of(CWItems.BLACK_TILE_ROOF_SLAB),
                        ItemDefinition.of(CWItems.BLACK_TILE_ROOF_SLAB_TOP)));

        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_RIDGE),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_J),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_TOP)));

        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB, 1)));
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.YELLOW_TILE_ROOF),
                        ItemDefinition.of(CWItems.YELLOW_TILE_ROOF_J),
                        ItemDefinition.of(CWItems.YELLOW_TILE_ROOF_SLAB),
                        ItemDefinition.of(CWItems.YELLOW_TILE_ROOF_SLAB_TOP)));

        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.YELLOW_ROOF_TILE_RIDGE),
                        ItemDefinition.of(CWItems.YELLOW_TILE_RIDGE_ROOF_EDGE),
                        ItemDefinition.of(CWItems.YELLOW_TILE_RIDGE_ROOF_J),
                        ItemDefinition.of(CWItems.YELLOW_TILE_RIDGE_ROOF_TOP),
                        ItemDefinition.of(CWItems.YELLOW_TILE_RIDGE_ROOF_EDGE_TOP)));

        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.YELLOW_ROOF_TILE_EDGE),
                        ItemDefinition.of(CWItems.YELLOW_ROOF_TILE_EDGE, 1),
                        ItemDefinition.of(CWItems.YELLOW_ROOF_TILE_EDGE_SLAB),
                        ItemDefinition.of(CWItems.YELLOW_ROOF_TILE_EDGE_SLAB, 1)));

        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.THATCH_ROOF),
                        ItemDefinition.of(CWItems.THATCH_TILE_ROOF_SLAB),
                        ItemDefinition.of(CWItems.THATCH_TILE_ROOF_SLAB_TOP)));

        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.THATCH_TILE_RIDGE_ROOF),
                        ItemDefinition.of(CWItems.THATCH_TILE_RIDGE_ROOF_TOP),
                        ItemDefinition.of(CWItems.THATCH_TILE_RIDGE_ROOF_EDGE),
                        ItemDefinition.of(CWItems.THATCH_TILE_RIDGE_ROOF_EDGE_TOP)));

        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.THATCH_ROOF_TILE_EDGE),
                        ItemDefinition.of(CWItems.THATCH_ROOF_TILE_EDGE, 1),
                        ItemDefinition.of(CWItems.THATCH_ROOF_TILE_EDGE_SLAB),
                        ItemDefinition.of(CWItems.THATCH_ROOF_TILE_EDGE_SLAB, 1)));
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_WB),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_WB, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_RR),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_RR, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_CW),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_CW, 1)));
        
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.THIN_WALL_W),
                        ItemDefinition.of(CWItems.THIN_WALL_BB),
                        ItemDefinition.of(CWItems.THIN_WALL_C),
                        ItemDefinition.of(CWItems.THIN_WALL_RB),
                        ItemDefinition.of(CWItems.THIN_WALL_RE),
                        ItemDefinition.of(CWItems.THIN_WALL_WG)));
        
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_W),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_BB),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_C),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_RB),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_RE),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_WG)));
        
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_W),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_BB),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_C),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_RB),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_RE),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_WG)));
        
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_WB),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_WB, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_RR),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_RR, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_CW),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_CW, 1)));
        
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_WB),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_WB, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_RR),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_RR, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_CW),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_CW, 1)));
        
        addSelection(
                ImmutableList.of(
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_J_WB),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_J_WB, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_J_RR),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_J_RR, 1),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_J_CW),
                        ItemDefinition.of(CWItems.BLACK_ROOF_TILE_EDGE_J_CW, 1)));
    }

    public static void addSelection(ImmutableList<ItemDefinition> selection)
    {
        if (containElement(selection))
        {
            CW.logger.error("Try to add an existent ItemDefinition, skipped");
        }
        else
        {
            selections.add(selection);
        }
    }

    @Nullable
    public static ImmutableList<ItemDefinition> findSelection(ItemStack stack)
    {
        return findSelection(ItemDefinition.of(stack));
    }

    @Nullable
    public static ImmutableList<ItemDefinition> findSelection(ItemDefinition definition)
    {
        for (ImmutableList<ItemDefinition> selection : selections)
        {
            if (selection.contains(definition))
            {
                return selection;
            }
        }

        return null;
    }

    private static boolean containElement(ImmutableList<ItemDefinition> list)
    {
        for (ImmutableList<ItemDefinition> selection : selections)
        {
            for (ItemDefinition definition : selection)
            {
                for (ItemDefinition e : list)
                {
                    if (e.equals(definition))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
