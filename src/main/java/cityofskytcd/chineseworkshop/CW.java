/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop;

import org.apache.logging.log4j.Logger;

import cityofskytcd.chineseworkshop.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CW.MODID, name = CW.NAME, version = CW.VERSION, acceptedMinecraftVersions = "1.12.2")
public class CW
{
    public static final String MODID = "chineseworkshop";
    public static final String NAME = "ChineseWorkshop";
    public static final String VERSION = "@VERSION_INJECT@";

    private static final CW INSTANCE = new CW();

    @Mod.InstanceFactory
    public static CW getInstance()
    {
        return INSTANCE;
    }

    public static Logger logger;

    public static void log(Object o)
    {
        logger.info(o);
    }

    @SidedProxy(clientSide = "cityofskytcd.chineseworkshop.proxy.ClientProxy", serverSide = "cityofskytcd.chineseworkshop.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
