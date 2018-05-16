package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsCWMaterials extends CreativeTabs {
	public CreativeTabsCWMaterials() {
		super("chineseworkshopmaterials");
	}

	@Override
	public Item getTabIconItem() {
		return ItemLoader.blackBrick;
	}
}