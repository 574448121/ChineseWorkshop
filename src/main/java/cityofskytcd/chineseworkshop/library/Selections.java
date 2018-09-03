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
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_J),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_TOP),
                        ItemDefinition.of(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_TOP)));

        
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
