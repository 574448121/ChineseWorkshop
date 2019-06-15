package cityofskytcd.chineseworkshop;

import cityofskytcd.chineseworkshop.block.BenchBlock;
import cityofskytcd.chineseworkshop.block.CandleBlock;
import cityofskytcd.chineseworkshop.block.Direction2Block;
import cityofskytcd.chineseworkshop.block.ModHorizontalBlock;
import cityofskytcd.chineseworkshop.block.SmallFenceBlock;
import cityofskytcd.chineseworkshop.block.WallCandleBlock;
import cityofskytcd.chineseworkshop.library.ISeat;
import net.minecraft.block.Block;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.util.math.shapes.VoxelShapes;
import snownee.kiwi.AbstractModule;
import snownee.kiwi.KiwiModule;
import snownee.kiwi.Name;
import snownee.kiwi.NoItem;
import snownee.kiwi.block.ModBlock;

@KiwiModule(modid = CW.MODID, name = "decorations")
@KiwiModule.Group
public class DecorationModule extends AbstractModule
{
    public static final ItemGroup GROUP = new ItemGroup(CW.MODID + ".decorations")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(DOUGONG);
        }
    };

    @NoItem
    public static final CandleBlock CANDLE = init(new CandleBlock(blockProp(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).lightValue(14).sound(SoundType.WOOD)));

    @NoItem
    public static final WallCandleBlock WALL_CANDLE = init(new WallCandleBlock(blockProp(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).lightValue(14).sound(SoundType.WOOD)));

    @Name("candle")
    public static final WallOrFloorItem CANDLE_ITEM = new WallOrFloorItem(CANDLE, WALL_CANDLE, itemProp());

    public static final ModBlock RED_LANTERN = new ModBlock(blockProp(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).lightValue(15).sound(SoundType.PLANT));

    public static final ModBlock WHITE_LANTERN = new ModBlock(blockProp(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0).lightValue(15).sound(SoundType.PLANT));

    public static final ModBlock STONE_TOWER_LAMP = new ModBlock(blockProp(Material.MISCELLANEOUS).lightValue(14).sound(SoundType.GLASS))
    {
        @Override
        public boolean isSolid(net.minecraft.block.BlockState state)
        {
            return false;
        };
    };

    public static final ModHorizontalBlock DOUGONG = new ModHorizontalBlock(blockProp(Material.WOOD), Block.makeCuboidShape(0, 11, 0, 16, 16, 13));

    public static final ModHorizontalBlock WOODEN_THRESHOLD = new ModHorizontalBlock(blockProp(Material.WOOD), VoxelShapes.or(Block.makeCuboidShape(0, 0, 3, 16, 5, 12), Block.makeCuboidShape(0, 5, 2, 16, 7.5, 13)));

    public static final ModHorizontalBlock STONE_THRESHOLD = new ModHorizontalBlock(blockProp(Material.WOOD), VoxelShapes.or(Block.makeCuboidShape(0, 0, 3, 16, 5, 12), Block.makeCuboidShape(0, 5, 2, 16, 7.5, 13)));

    public static final BenchBlock BENCH = new BenchBlock(blockProp(Material.WOOD));

    public static final Direction2Block CARVING = new Direction2Block(blockProp(Material.WOOD), Block.makeCuboidShape(0, 4, 5, 16, 16, 11));

    public static final EntityType<?> SEAT = EntityType.Builder.create(EntityClassification.MISC).setCustomClientFactory((
            spawnEntity, world
    ) -> new ISeat.Seat(world)).size(0.0001F, 0.0001F).setTrackingRange(16).setUpdateInterval(20).build(CW.MODID + ".seat");

    public static final SmallFenceBlock WHITE_ASH_WALL = new SmallFenceBlock(blockProp(Material.ROCK));

    public static final SmallFenceBlock RAMMED_EARTH_WALL = new SmallFenceBlock(blockProp(Material.GOURD));

    public static final SmallFenceBlock BLACK_BRICK_WALL = new SmallFenceBlock(blockProp(Material.ROCK));

    public static final SmallFenceBlock OAK_CHINESE_FENCE = new SmallFenceBlock(blockProp(Material.ROCK), 1.5F, 1F, 19, 14, 24);

    public static final PaneBlock PAPER_WINDOW = new StainedGlassPaneBlock(DyeColor.WHITE, blockProp(Material.WOOL));
}
