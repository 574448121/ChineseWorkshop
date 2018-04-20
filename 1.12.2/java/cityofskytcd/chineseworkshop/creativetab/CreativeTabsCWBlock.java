package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsCWBlock extends CreativeTabs {
	public CreativeTabsCWBlock() {
		super("chineseworkshopblock");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemLoader.logo);
	}
}