/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.proxy;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import cityofskytcd.chineseworkshop.crafting.CraftingLoader;
import cityofskytcd.chineseworkshop.event.EventHandler;
import cityofskytcd.chineseworkshop.event.RegistryRemapper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
        CraftingLoader.register();
    }

    @OverridingMethodsMustInvokeSuper
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
