package cityofskytcd.chineseworkshop.common;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import cityofskytcd.chineseworkshop.crafting.CraftingLoader;
import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new CreativeTabsLoader(event);
		new ItemLoader(event);
		new BlockLoader(event);
		new CraftingLoader();
	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}