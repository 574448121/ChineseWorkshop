package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsCWLight extends CreativeTabs {
	public CreativeTabsCWLight() {
		super("chineseworkshoplight");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockLoader.stoneTowerLamp);
	}
}