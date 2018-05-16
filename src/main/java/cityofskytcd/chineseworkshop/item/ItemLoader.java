package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
	/* 材料 */
	public static Item logo = new ItemLogo();
	public static Item cwDoor = new ItemCWDoor("cwdoor", BlockLoader.cwDoor);
	public static Item largeDoor = new ItemCWDoor("largedoor", BlockLoader.cwDoor);
	public static Item blackClay = new ItemCWMaterials("blackclay");
	public static Item blackBrick = new ItemCWMaterials("blackbrick");

	public ItemLoader(FMLPreInitializationEvent event) {
		register(logo, "logo");
		register(blackClay, "black_clay");
		register(blackBrick, "black_brick");
		register(cwDoor, "doors");
//		register(largeDoor, "doors");
	}

	public static void registerRenders() {
		registerRender(logo);
		registerRender(blackClay);
		registerRender(blackBrick);
		registerRender(cwDoor);
//		registerRender(largeDoor);
	}

	private static void register(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Item item) {
		String name = GameData.getItemRegistry().getNameForObject(item).toString();
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
	}
}