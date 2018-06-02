/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.proxy;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import cityofskytcd.chineseworkshop.event.EventHandler;
import cityofskytcd.chineseworkshop.event.RegistryRemapper;
import cityofskytcd.chineseworkshop.item.CWItems;
import cityofskytcd.chineseworkshop.library.Selections;
import cityofskytcd.chineseworkshop.network.CWNetworkChannel;
import cityofskytcd.chineseworkshop.network.WheelMovePacket;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    @OverridingMethodsMustInvokeSuper
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @OverridingMethodsMustInvokeSuper
    public void init(FMLInitializationEvent event)
    {
        EventHandler.init();
        RegistryRemapper.init();
        Selections.init();
        CWNetworkChannel.INSTANCE.register(WheelMovePacket.class);
        GameRegistry.addSmelting(new ItemStack(CWItems.MATERIAL, 1, 0), new ItemStack(CWItems.MATERIAL, 1, 1), 0.1F);
        GameRegistry.addSmelting(CWItems.BLACK_CLAY_BLOCK, new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, 15), 0.1F);
    }

    @OverridingMethodsMustInvokeSuper
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
