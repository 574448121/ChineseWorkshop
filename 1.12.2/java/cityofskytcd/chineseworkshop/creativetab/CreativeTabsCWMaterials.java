package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsCWMaterials extends CreativeTabs {
	public CreativeTabsCWMaterials() {
		super("chineseworkshopmaterials");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemLoader.blackBrick);
	}
}