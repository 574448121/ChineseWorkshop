/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.proxy;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.block.CWBlocks;
import cityofskytcd.chineseworkshop.event.HudHandler;
import cityofskytcd.chineseworkshop.item.CWItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    public static final KeyBinding kbSelect = new KeyBinding(CW.MODID + ".keybind.select", Keyboard.KEY_LMENU, CW.MODID
            + ".gui.keygroup");

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        ClientRegistry.registerKeyBinding(kbSelect);
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        HudHandler.init();

        final BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
        blockColors.registerBlockColorHandler(new IBlockColor()
        {
            @Override
            public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex)
            {
                if (worldIn != null && pos != null)
                {
                    return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);
                }
                return ColorizerGrass.getGrassColor(0.5D, 1.0D);
            }
        }, CWBlocks.TREE_ALTAR);

        final ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        itemColors.registerItemColorHandler(new IItemColor()
        {
            @Override
            public int colorMultiplier(ItemStack stack, int tintIndex)
            {
                IBlockState iblockstate = ((ItemBlock) stack.getItem()).getBlock().getDefaultState();
                return blockColors.colorMultiplier(iblockstate, null, null, tintIndex);
            }
        }, CWItems.TREE_ALTAR);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
