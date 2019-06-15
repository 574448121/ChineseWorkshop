package cityofskytcd.chineseworkshop;

import cityofskytcd.chineseworkshop.block.ModStairsBlock;
import cityofskytcd.chineseworkshop.block.RoofTileBlock;
import cityofskytcd.chineseworkshop.block.RoofTileJBlock;
import cityofskytcd.chineseworkshop.block.RoofTileRidgeBlock;
import cityofskytcd.chineseworkshop.block.SlabRoofTileBlock;
import cityofskytcd.chineseworkshop.event.HudHandler;
import cityofskytcd.chineseworkshop.library.Selections;
import cityofskytcd.chineseworkshop.network.WheelMovePacket;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import snownee.kiwi.AbstractModule;
import snownee.kiwi.KiwiModule;
import snownee.kiwi.NoGroup;
import snownee.kiwi.block.ModBlock;
import snownee.kiwi.item.ModItem;
import snownee.kiwi.network.NetworkChannel;

@KiwiModule(modid = CW.MODID, name = "blocks")
@KiwiModule.Group
public class BlockModule extends AbstractModule
{
    public static final ItemGroup GROUP = new ItemGroup(CW.MODID + ".blocks")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(LOGO);
        }
    };

    // TODO: map color

    @NoGroup
    public static final ModItem LOGO = new ModItem(itemProp());

    public static final ModBlock RED_STAINED_WOODEN_PLANKS = new ModBlock(blockProp(Material.WOOD));

    public static final ModBlock BLACK_BRICK_BLOCK = new ModBlock(blockProp(Material.ROCK));

    public static final ModStairsBlock BLACK_BRICK_STAIRS = new ModStairsBlock(BLACK_BRICK_BLOCK.getDefaultState());

    public static final SlabBlock BLACK_BRICK_SLAB = init(new SlabBlock(Block.Properties.from(BLACK_BRICK_BLOCK)));

    public static final ModBlock WHITE_ASH_BLOCK = new ModBlock(blockProp(Material.ROCK));

    public static final ModStairsBlock WHITE_ASH_STAIRS = new ModStairsBlock(WHITE_ASH_BLOCK.getDefaultState());

    public static final SlabBlock WHITE_ASH_SLAB = init(new SlabBlock(Block.Properties.from(WHITE_ASH_BLOCK)));

    public static final ModBlock RAMMED_EARTH = new ModBlock(blockProp(Material.GOURD));

    public static final ModStairsBlock RAMMED_EARTH_STAIRS = new ModStairsBlock(RAMMED_EARTH.getDefaultState());

    public static final SlabBlock RAMMED_EARTH_SLAB = init(new SlabBlock(Block.Properties.from(RAMMED_EARTH)));

    public static final ModBlock ANDESITE_PAVEMENT = new ModBlock(blockProp(Material.ROCK));

    public static final ModStairsBlock ANDESITE_PAVEMENT_STAIRS = new ModStairsBlock(ANDESITE_PAVEMENT.getDefaultState());

    public static final SlabBlock ANDESITE_PAVEMENT_SLAB = init(new SlabBlock(Block.Properties.from(ANDESITE_PAVEMENT)));

    public static final RotatedPillarBlock RED_PILLAR = new RotatedPillarBlock(blockProp(Material.WOOD));

    public static final RotatedPillarBlock DARK_GREEN_PILLAR = new RotatedPillarBlock(blockProp(Material.WOOD));

    public static final RoofTileBlock BLACK_TILE_ROOF = init(new RoofTileBlock(blockProp(Material.ROCK)));

    public static final RoofTileJBlock BLACK_TILE_ROOF_J = init(new RoofTileJBlock(blockProp(Material.ROCK)));

    public static final RoofTileRidgeBlock BLACK_TILE_ROOF_RIDGE = new RoofTileRidgeBlock(blockProp(Material.ROCK));

    public static final SlabRoofTileBlock BLACK_TILE_ROOF_SLAB = new SlabRoofTileBlock(blockProp(Material.ROCK), Block.makeCuboidShape(0, 0, 0, 16, 8, 16));

    public static final SlabRoofTileBlock BLACK_TILE_ROOF_SLAB_TOP = new SlabRoofTileBlock(blockProp(Material.ROCK), VoxelShapes.fullCube());

    public static final ModBlock BLACK_CLAY_BLOCK = new ModBlock(blockProp(Material.CLAY));

    @Override
    protected void init(FMLCommonSetupEvent event)
    {
        NetworkChannel.register(WheelMovePacket.class, new WheelMovePacket.Handler());
        Selections.init();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    protected void clientInit(FMLClientSetupEvent event)
    {
        ClientRegistry.registerKeyBinding(HudHandler.kbSelect);
    }
}
