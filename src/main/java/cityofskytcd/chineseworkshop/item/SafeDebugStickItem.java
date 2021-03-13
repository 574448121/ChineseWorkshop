package cityofskytcd.chineseworkshop.item;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import cityofskytcd.chineseworkshop.CWConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.DebugStickItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import snownee.kiwi.item.ModItem;

public class SafeDebugStickItem extends DebugStickItem {
    public SafeDebugStickItem(Properties builder) {
        super(builder);
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return false;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        if (!world.isRemote && playerentity != null) {
            BlockPos blockpos = context.getPos();
            this.handleClick(playerentity, world.getBlockState(blockpos), world, blockpos, true, context.getItem());
        }

        return ActionResultType.SUCCESS;
    }

    public void handleClick(PlayerEntity player, BlockState state, IWorld worldIn, BlockPos pos, boolean rightClick, ItemStack stack) {
        if (canApplyOn(state)) {
            Block block = state.getBlock();
            StateContainer<Block, BlockState> statecontainer = block.getStateContainer();
            Collection<Property<?>> collection = Lists.newArrayList(statecontainer.getProperties());
            collection.remove(BlockStateProperties.WATERLOGGED);
            @SuppressWarnings("deprecation")
            String s = Registry.BLOCK.getKey(block).toString();
            if (collection.isEmpty()) {
                sendMessage(player, new TranslationTextComponent(Items.DEBUG_STICK.getTranslationKey() + ".empty", s));
            } else {
                CompoundNBT compoundnbt = stack.getOrCreateChildTag("DebugProperty");
                String s1 = compoundnbt.getString(s);
                Property<?> iproperty = statecontainer.getProperty(s1);
                if (rightClick) {
                    if (iproperty == null) {
                        iproperty = collection.iterator().next();
                    }

                    BlockState blockstate = cycleProperty(state, iproperty, player.isSecondaryUseActive());
                    worldIn.setBlockState(pos, blockstate, 18);
                    sendMessage(player, new TranslationTextComponent(Items.DEBUG_STICK.getTranslationKey() + ".update", iproperty.getName(), func_195957_a(blockstate, iproperty)));
                } else {
                    iproperty = getAdjacentValue(collection, iproperty, player.isSecondaryUseActive());
                    String s2 = iproperty.getName();
                    compoundnbt.putString(s, s2);
                    sendMessage(player, new TranslationTextComponent(Items.DEBUG_STICK.getTranslationKey() + ".select", s2, func_195957_a(state, iproperty)));
                }
            }
        } else {
            sendMessage(player, new TranslationTextComponent(this.getTranslationKey() + ".unsupported"));
        }
    }

    public static boolean canApplyOn(BlockState state) {
        Block block = state.getBlock();
        if (CWConfig.allowedMods.contains(block.getRegistryName().getNamespace())) {
            return true;
        }
        String className = block.getClass().getName();
        if (CWConfig.allowedClasses.contains(className)) {
            return true;
        }
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        ModItem.addTip(stack, tooltip, flagIn);
    }

    private static <T extends Comparable<T>> BlockState cycleProperty(BlockState state, Property<T> propertyIn, boolean backwards) {
        return state.with(propertyIn, (getAdjacentValue(propertyIn.getAllowedValues(), state.get(propertyIn), backwards)));
    }

    private static <T> T getAdjacentValue(Iterable<T> p_195959_0_, @Nullable T p_195959_1_, boolean p_195959_2_) {
        return p_195959_2_ ? Util.getElementBefore(p_195959_0_, p_195959_1_) : Util.getElementAfter(p_195959_0_, p_195959_1_);
    }

    private static void sendMessage(PlayerEntity player, ITextComponent text) {
        ((ServerPlayerEntity) player)./*sendMessage*/func_241151_a_(text, ChatType.GAME_INFO, Util.DUMMY_UUID);
    }

    private static <T extends Comparable<T>> String func_195957_a(BlockState state, Property<T> propertyIn) {
        return propertyIn.getName(state.get(propertyIn));
    }
}
