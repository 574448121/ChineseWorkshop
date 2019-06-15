package cityofskytcd.chineseworkshop.library;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import cityofskytcd.chineseworkshop.BlockModule;
import cityofskytcd.chineseworkshop.CW;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

public class Selections
{
    private static Set<Item> allItems = Sets.newHashSet();
    private static Set<List<Item>> selections = Sets.newHashSet();

    public static void init()
    {
        //        addSelection(BlockModule.BLACK_TILE_ROOF, BlockModule.BLACK_TILE_ROOF_J, CWItems.BLACK_TILE_ROOF_SLAB, CWItems.BLACK_TILE_ROOF_SLAB_TOP);

        addSelection(BlockModule.BLACK_TILE_ROOF, BlockModule.BLACK_TILE_ROOF_J, BlockModule.BLACK_TILE_ROOF_RIDGE);

        //        addSelection(CWItems.BLACK_ROOF_TILE_RIDGE), CWItems.BLACK_TILE_RIDGE_ROOF_J), CWItems.BLACK_TILE_RIDGE_ROOF_TOP)));
        //
        //        addSelection(CWItems.BLACK_ROOF_TILE_EDGE), CWItems.BLACK_ROOF_TILE_EDGE, 1), CWItems.BLACK_ROOF_TILE_EDGE_SLAB), CWItems.BLACK_ROOF_TILE_EDGE_SLAB, 1)));
        //        addSelection(CWItems.YELLOW_TILE_ROOF), CWItems.YELLOW_TILE_ROOF_J), CWItems.YELLOW_TILE_ROOF_SLAB), CWItems.YELLOW_TILE_ROOF_SLAB_TOP)));
        //
        //        addSelection(CWItems.YELLOW_ROOF_TILE_RIDGE), CWItems.YELLOW_TILE_RIDGE_ROOF_EDGE), CWItems.YELLOW_TILE_RIDGE_ROOF_J), CWItems.YELLOW_TILE_RIDGE_ROOF_TOP), CWItems.YELLOW_TILE_RIDGE_ROOF_EDGE_TOP)));
        //
        //        addSelection(CWItems.YELLOW_ROOF_TILE_EDGE), CWItems.YELLOW_ROOF_TILE_EDGE, 1), CWItems.YELLOW_ROOF_TILE_EDGE_SLAB), CWItems.YELLOW_ROOF_TILE_EDGE_SLAB, 1)));
        //
        //        addSelection(CWItems.THATCH_ROOF), CWItems.THATCH_TILE_ROOF_SLAB), CWItems.THATCH_TILE_ROOF_SLAB_TOP)));
        //
        //        addSelection(CWItems.THATCH_TILE_RIDGE_ROOF), CWItems.THATCH_TILE_RIDGE_ROOF_TOP), CWItems.THATCH_TILE_RIDGE_ROOF_EDGE), CWItems.THATCH_TILE_RIDGE_ROOF_EDGE_TOP)));
        //
        //        addSelection(CWItems.THATCH_ROOF_TILE_EDGE), CWItems.THATCH_ROOF_TILE_EDGE, 1), CWItems.THATCH_ROOF_TILE_EDGE_SLAB), CWItems.THATCH_ROOF_TILE_EDGE_SLAB, 1)));
        //        addSelection(CWItems.BLACK_ROOF_TILE_EDGE_WB), CWItems.BLACK_ROOF_TILE_EDGE_WB, 1), CWItems.BLACK_ROOF_TILE_EDGE_RR), CWItems.BLACK_ROOF_TILE_EDGE_RR, 1), CWItems.BLACK_ROOF_TILE_EDGE_CW), CWItems.BLACK_ROOF_TILE_EDGE_CW, 1)));
        //
        //        addSelection(CWItems.THIN_WALL_W), CWItems.THIN_WALL_BB), CWItems.THIN_WALL_C), CWItems.THIN_WALL_RB), CWItems.THIN_WALL_RE), CWItems.THIN_WALL_WG)));
        //
        //        addSelection(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_W), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_BB), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_C), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_RB), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_RE), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_WG)));
        //
        //        addSelection(CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_W), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_BB), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_C), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_RB), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_RE), CWItems.BLACK_TILE_RIDGE_ROOF_EDGE_T_WG)));
        //
        //        addSelection(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_WB), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_WB, 1), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_RR), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_RR, 1), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_CW), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_CW, 1)));
        //
        //        addSelection(CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_WB), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_WB, 1), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_RR), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_RR, 1), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_CW), CWItems.BLACK_ROOF_TILE_EDGE_SLAB_T_CW, 1)));
        //
        //        addSelection(CWItems.BLACK_ROOF_TILE_EDGE_J_WB), CWItems.BLACK_ROOF_TILE_EDGE_J_WB, 1), CWItems.BLACK_ROOF_TILE_EDGE_J_RR), CWItems.BLACK_ROOF_TILE_EDGE_J_RR, 1), CWItems.BLACK_ROOF_TILE_EDGE_J_CW), CWItems.BLACK_ROOF_TILE_EDGE_J_CW, 1)));
    }

    public static void addSelection(IItemProvider... providers)
    {
        List<Item> items = ImmutableList.copyOf(providers).stream().map(IItemProvider::asItem).collect(Collectors.toList());
        if (items.stream().anyMatch(allItems::contains))
        {
            CW.logger.error("Try to add an existent IItemProvider to selections, skipped");
        }
        else
        {
            selections.add(items);
            allItems.addAll(items);
        }
    }

    @Nullable
    public static List<Item> find(ItemStack stack)
    {
        return find(stack.getItem());
    }

    @Nullable
    public static List<Item> find(IItemProvider provider)
    {
        Item item = provider.asItem();
        if (allItems.contains(item))
        {
            Optional<List<Item>> result = selections.stream().filter(s -> s.contains(item)).findFirst();
            if (result.isPresent())
            {
                return result.get();
            }
        }
        return null;
    }

    public static boolean contains(Item item)
    {
        return allItems.contains(item);
    }
}
