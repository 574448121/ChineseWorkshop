package cityofskytcd.chineseworkshop;

import java.util.List;

import cityofskytcd.chineseworkshop.block.BenchBlock;
import cityofskytcd.chineseworkshop.block.ChairBlock;
import cityofskytcd.chineseworkshop.block.Direction2;
import cityofskytcd.chineseworkshop.block.Direction2Block;
import cityofskytcd.chineseworkshop.block.RoofTileBlock;
import cityofskytcd.chineseworkshop.block.RoofTileJBlock;
import cityofskytcd.chineseworkshop.block.RoofTileRidgeBlock;
import cityofskytcd.chineseworkshop.block.SlabRoofTileBlock;
import cityofskytcd.chineseworkshop.event.RetextureIngredientEvent;
import cityofskytcd.chineseworkshop.tile.CWTextureTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import snownee.kiwi.AbstractModule;
import snownee.kiwi.KiwiModule;
import snownee.kiwi.KiwiModule.Subscriber.Bus;
import snownee.kiwi.client.model.TextureModel;
import snownee.kiwi.item.ModBlockItem;
import snownee.kiwi.util.NBTHelper;
import snownee.kiwi.util.Util;

@KiwiModule("retexture")
@KiwiModule.Optional
@KiwiModule.Subscriber(Bus.FORGE)
public class TextureModule extends AbstractModule {
	public static final RoofTileBlock BLACK_TILE_ROOF_DYN = new RoofTileBlock(blockProp(BlockModule.BLACK_TILE_ROOF), true);

	public static final RoofTileJBlock BLACK_TILE_ROOF_J_DYN = new RoofTileJBlock(blockProp(BlockModule.BLACK_TILE_ROOF_J), true);

	public static final RoofTileJBlock BLACK_TILE_ROOF_RIDGE_J_DYN = new RoofTileJBlock(blockProp(BlockModule.BLACK_TILE_ROOF_RIDGE_J), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), true);

	public static final RoofTileRidgeBlock BLACK_TILE_ROOF_RIDGE_DYN = new RoofTileRidgeBlock(blockProp(BlockModule.BLACK_TILE_ROOF_RIDGE), Block.makeCuboidShape(0, 0, 0, 16, 9, 16), true);

	public static final RoofTileRidgeBlock BLACK_TILE_ROOF_RIDGE_TOP_DYN = new RoofTileRidgeBlock(blockProp(BlockModule.BLACK_TILE_ROOF_RIDGE_TOP), VoxelShapes.fullCube(), true);

	public static final SlabRoofTileBlock BLACK_TILE_ROOF_SLAB_DYN = new SlabRoofTileBlock(blockProp(BlockModule.BLACK_TILE_ROOF_SLAB), Block.makeCuboidShape(0, 0, 0, 16, 8, 16), true);

	public static final SlabRoofTileBlock BLACK_TILE_ROOF_SLAB_TOP_DYN = new SlabRoofTileBlock(blockProp(BlockModule.BLACK_TILE_ROOF_SLAB_TOP), VoxelShapes.fullCube(), true);

	public static final BenchBlock BENCH_DYN = new BenchBlock(blockProp(DecorationModule.BENCH), true);

	public static final ChairBlock CHAIR_DYN = new ChairBlock(blockProp(DecorationModule.CHAIR), true);

	/* off */
    public static final TileEntityType<?> RETEXTURE = TileEntityType.Builder.create(CWTextureTile::new,
            BLACK_TILE_ROOF_DYN,
            BLACK_TILE_ROOF_J_DYN,
            BLACK_TILE_ROOF_RIDGE_J_DYN,
            BLACK_TILE_ROOF_RIDGE_DYN,
            BLACK_TILE_ROOF_RIDGE_TOP_DYN,
            BLACK_TILE_ROOF_SLAB_DYN,
            BLACK_TILE_ROOF_SLAB_TOP_DYN,
            BENCH_DYN,
            CHAIR_DYN
    ).build(null);
    /* on */

	@Override
	protected void init(FMLCommonSetupEvent event) {
		BLACK_TILE_ROOF_DYN.translationKey = BlockModule.BLACK_TILE_ROOF.getTranslationKey();
		BLACK_TILE_ROOF_J_DYN.translationKey = BlockModule.BLACK_TILE_ROOF_J.getTranslationKey();
		BLACK_TILE_ROOF_RIDGE_J_DYN.translationKey = BlockModule.BLACK_TILE_ROOF_RIDGE_J.getTranslationKey();
		BLACK_TILE_ROOF_RIDGE_DYN.translationKey = BlockModule.BLACK_TILE_ROOF_RIDGE.getTranslationKey();
		BLACK_TILE_ROOF_RIDGE_TOP_DYN.translationKey = BlockModule.BLACK_TILE_ROOF_RIDGE_TOP.getTranslationKey();
		BLACK_TILE_ROOF_SLAB_DYN.translationKey = BlockModule.BLACK_TILE_ROOF_SLAB.getTranslationKey();
		BLACK_TILE_ROOF_SLAB_TOP_DYN.translationKey = BlockModule.BLACK_TILE_ROOF_SLAB_TOP.getTranslationKey();
		BENCH_DYN.translationKey = DecorationModule.BENCH.getTranslationKey();
		CHAIR_DYN.translationKey = DecorationModule.CHAIR.getTranslationKey();

		MinecraftForge.EVENT_BUS.addListener(this::onRetextureIngredient);
	}

	public void onRetextureIngredient(RetextureIngredientEvent event) {
		event.add(BlockModule.BLACK_TILE_ROOF);
		event.add(BlockModule.BLACK_TILE_ROOF_J);
		event.add(BlockModule.BLACK_TILE_ROOF_RIDGE_J);
		event.add(BlockModule.BLACK_TILE_ROOF_RIDGE);
		event.add(BlockModule.BLACK_TILE_ROOF_RIDGE_TOP);
		event.add(BlockModule.BLACK_TILE_ROOF_SLAB);
		event.add(BlockModule.BLACK_TILE_ROOF_SLAB_TOP);
		event.add(DecorationModule.BENCH);
		event.add(DecorationModule.CHAIR);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event) {
		ModBlockItem.INSTANT_UPDATE_TILES.add(RETEXTURE);

		Block block;
		BlockState state;

		block = BLACK_TILE_ROOF_DYN;
		state = block.getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.SOUTH);
		TextureModel.register(event, block, state);

		block = BLACK_TILE_ROOF_J_DYN;
		state = block.getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.NORTH);
		TextureModel.register(event, block, state);

		block = BLACK_TILE_ROOF_RIDGE_J_DYN;
		state = block.getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.NORTH);
		TextureModel.register(event, block, state);

		block = BLACK_TILE_ROOF_RIDGE_DYN;
		state = block.getDefaultState().with(RoofTileRidgeBlock.VARIANT, RoofTileRidgeBlock.Variant.I_90);
		TextureModel.register(event, block, state);

		block = BLACK_TILE_ROOF_RIDGE_TOP_DYN;
		state = block.getDefaultState().with(RoofTileRidgeBlock.VARIANT, RoofTileRidgeBlock.Variant.I_90);
		TextureModel.register(event, block, state);

		block = BLACK_TILE_ROOF_SLAB_DYN;
		state = block.getDefaultState();
		TextureModel.register(event, block, state);

		block = BLACK_TILE_ROOF_SLAB_TOP_DYN;
		state = block.getDefaultState();
		TextureModel.register(event, block, state);

		block = BENCH_DYN;
		state = block.getDefaultState().with(Direction2Block.FACING, Direction2.SOUTH_NORTH);
		TextureModel.register(event, block, state);

		block = CHAIR_DYN;
		state = block.getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, Direction.SOUTH);
		TextureModel.register(event, block, state);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addTooltip(ItemStack stack, List<ITextComponent> tooltip, String langKey) {
		NBTHelper data = NBTHelper.of(stack);
		ResourceLocation rl = Util.RL(data.getString("BlockEntityTag.Items.main"));
		if (rl != null) {
			Item item = ForgeRegistries.ITEMS.getValue(rl);
			if (item != null) {
				String name = I18n.format(item.getTranslationKey());
				tooltip.add(new TranslationTextComponent("chineseworkshop.tip." + langKey, name).mergeStyle(TextFormatting.GRAY));
			}
		}
	}
}
