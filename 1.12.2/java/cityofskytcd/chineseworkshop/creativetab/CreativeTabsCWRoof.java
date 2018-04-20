package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsCWRoof extends CreativeTabs {
	public CreativeTabsCWRoof() {
		super("chineseworkshoproof");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockLoader.blackTileRoof);
	}
}