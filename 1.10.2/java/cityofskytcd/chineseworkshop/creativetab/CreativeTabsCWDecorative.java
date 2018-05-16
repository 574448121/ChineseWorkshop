package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsCWDecorative extends CreativeTabs {
	public CreativeTabsCWDecorative() {
		super("chineseworkshopdecorative");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockLoader.bracketSet);
	}
}