package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsCWDecorative extends CreativeTabs {
	public CreativeTabsCWDecorative() {
		super("chineseworkshopdecorative");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockLoader.bracketSet);
	}
}