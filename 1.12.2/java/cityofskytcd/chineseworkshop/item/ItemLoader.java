package cityofskytcd.chineseworkshop.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//@EventBusSubscriber(modid = CW.MODID)
public class ItemLoader {
	/* ���� */
	public static Item logo = new ItemLogo();
	public static Item blackClay = new ItemCWMaterials("blackclay");
	public static Item blackBrick = new ItemCWMaterials("blackbrick");

	public ItemLoader(FMLPreInitializationEvent event) {
		register(logo, "logo");
		register(blackClay, "black_clay");
		register(blackBrick, "black_brick");
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void registerRenders() {
		registerRender(logo);
		registerRender(blackClay);
		registerRender(blackBrick);
	}

	// @SubscribeEvent
	// public static void registerBlocks(RegistryEvent.Register<Item> e) {
	// e.getRegistry().register(logo);
	// e.getRegistry().register(blackClay);
	// e.getRegistry().register(blackBrick);
	// }

	private static void register(Item item, String name) {
		item.setRegistryName(name);
		ForgeRegistries.ITEMS.register(item);
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Item item) {
		ModelResourceLocation mr = new ModelResourceLocation(item.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(item, 0, mr);
	}
}