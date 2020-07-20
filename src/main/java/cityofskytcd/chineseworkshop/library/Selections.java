package cityofskytcd.chineseworkshop.library;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import cityofskytcd.chineseworkshop.BlockModule;
import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.TextureModule;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.TagsUpdatedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import snownee.kiwi.Kiwi;

@EventBusSubscriber
public class Selections {
    private static final Set<Item> allItems = Sets.newHashSet();
    public static final List<Selection> SELECTIONS = Lists.newLinkedList();

    private Selections() {}

    @SubscribeEvent
    public static void init(TagsUpdatedEvent event) {
        allItems.clear();
        SELECTIONS.clear();
        boolean retexture = Kiwi.isLoaded(new ResourceLocation(CW.MODID, "retexture"));

        addSelection(BlockModule.BLACK_TILE_ROOF, BlockModule.BLACK_TILE_ROOF_J, BlockModule.BLACK_TILE_ROOF_SLAB, BlockModule.BLACK_TILE_ROOF_SLAB_TOP, BlockModule.BLACK_TILE_ROOF_RIDGE, BlockModule.BLACK_TILE_ROOF_RIDGE_J, BlockModule.BLACK_TILE_ROOF_RIDGE_TOP);

        if (retexture) {
            addSelection(true, TextureModule.BLACK_TILE_ROOF_DYN, TextureModule.BLACK_TILE_ROOF_J_DYN, TextureModule.BLACK_TILE_ROOF_SLAB_DYN, TextureModule.BLACK_TILE_ROOF_SLAB_TOP_DYN, TextureModule.BLACK_TILE_ROOF_RIDGE_DYN, TextureModule.BLACK_TILE_ROOF_RIDGE_J_DYN, TextureModule.BLACK_TILE_ROOF_RIDGE_TOP_DYN);
        }
        //        addSelection(BlockModule.BLACK_ROOF_TILE_EDGE), BlockModule.BLACK_ROOF_TILE_EDGE, 1), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB, 1)));
        //        addSelection(BlockModule.YELLOW_TILE_ROOF), BlockModule.YELLOW_TILE_ROOF_J), BlockModule.YELLOW_TILE_ROOF_SLAB), BlockModule.YELLOW_TILE_ROOF_SLAB_TOP)));
        //
        //        addSelection(BlockModule.YELLOW_ROOF_TILE_RIDGE), BlockModule.YELLOW_TILE_RIDGE_ROOF_EDGE), BlockModule.YELLOW_TILE_RIDGE_ROOF_J), BlockModule.YELLOW_TILE_RIDGE_ROOF_TOP), BlockModule.YELLOW_TILE_RIDGE_ROOF_EDGE_TOP)));
        //
        //        addSelection(BlockModule.YELLOW_ROOF_TILE_EDGE), BlockModule.YELLOW_ROOF_TILE_EDGE, 1), BlockModule.YELLOW_ROOF_TILE_EDGE_SLAB), BlockModule.YELLOW_ROOF_TILE_EDGE_SLAB, 1)));

        addSelection(BlockModule.THATCH_ROOF, BlockModule.THATCH_ROOF_SLAB, BlockModule.THATCH_ROOF_SLAB_TOP, BlockModule.THATCH_ROOF_RIDGE, BlockModule.THATCH_ROOF_RIDGE_TOP);

        //        addSelection(BlockModule.THATCH_ROOF_TILE_EDGE), BlockModule.THATCH_ROOF_TILE_EDGE, 1), BlockModule.THATCH_ROOF_TILE_EDGE_SLAB), BlockModule.THATCH_ROOF_TILE_EDGE_SLAB, 1)));
        //        addSelection(BlockModule.BLACK_ROOF_TILE_EDGE_WB), BlockModule.BLACK_ROOF_TILE_EDGE_WB, 1), BlockModule.BLACK_ROOF_TILE_EDGE_RR), BlockModule.BLACK_ROOF_TILE_EDGE_RR, 1), BlockModule.BLACK_ROOF_TILE_EDGE_CW), BlockModule.BLACK_ROOF_TILE_EDGE_CW, 1)));
        //
        //        addSelection(BlockModule.THIN_WALL_W), BlockModule.THIN_WALL_BB), BlockModule.THIN_WALL_C), BlockModule.THIN_WALL_RB), BlockModule.THIN_WALL_RE), BlockModule.THIN_WALL_WG)));
        //
        //        addSelection(BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_W), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_BB), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_C), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_RB), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_RE), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_WG)));
        //
        //        addSelection(BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_T_W), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_T_BB), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_T_C), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_T_RB), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_T_RE), BlockModule.BLACK_TILE_RIDGE_ROOF_EDGE_T_WG)));
        //
        //        addSelection(BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_WB), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_WB, 1), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_RR), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_RR, 1), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_CW), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_CW, 1)));
        //
        //        addSelection(BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_T_WB), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_T_WB, 1), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_T_RR), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_T_RR, 1), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_T_CW), BlockModule.BLACK_ROOF_TILE_EDGE_SLAB_T_CW, 1)));
        //
        //        addSelection(BlockModule.BLACK_ROOF_TILE_EDGE_J_WB), BlockModule.BLACK_ROOF_TILE_EDGE_J_WB, 1), BlockModule.BLACK_ROOF_TILE_EDGE_J_RR), BlockModule.BLACK_ROOF_TILE_EDGE_J_RR, 1), BlockModule.BLACK_ROOF_TILE_EDGE_J_CW), BlockModule.BLACK_ROOF_TILE_EDGE_J_CW, 1)));

        //addSelection(Blocks.DIAMOND_BLOCK, ItemTags.WOOL.getAllElements().toArray(new IItemProvider[0]));
    }

    public static void addSelection(IItemProvider mainItem, IItemProvider... subItems) {
        addSelection(false, mainItem, subItems);
    }

    public static void addSelection(boolean hide, IItemProvider mainItem, IItemProvider... subItems) {
        Item main = mainItem.asItem();
        List<Item> items = ImmutableList.copyOf(subItems).stream().map(IItemProvider::asItem).collect(Collectors.toList());
        if (allItems.contains(main) || items.stream().anyMatch(allItems::contains)) {
            CW.logger.error("Try to add an existent IItemProvider to selections, skipped");
        } else {
            SELECTIONS.add(new Selection(main, items, hide));
            allItems.add(main);
            allItems.addAll(items);
        }
    }

    @Nullable
    public static Selection find(ItemStack stack) {
        return find(stack.getItem());
    }

    @Nullable
    public static Selection find(IItemProvider provider) {
        Item item = provider.asItem();
        if (allItems.contains(item)) {
            Optional<Selection> result = SELECTIONS.stream().filter(s -> s.matches(item)).findFirst();
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    public static boolean contains(Item item) {
        return allItems.contains(item);
    }
}
