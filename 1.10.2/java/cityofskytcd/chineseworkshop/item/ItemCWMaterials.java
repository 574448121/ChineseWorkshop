package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;

public class ItemCWMaterials extends Item {
	public ItemCWMaterials(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabsLoader.tabCWM);
	}
}
