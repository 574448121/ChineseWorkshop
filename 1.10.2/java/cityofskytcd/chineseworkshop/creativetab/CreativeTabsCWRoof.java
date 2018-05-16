package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsCWRoof extends CreativeTabs {
	public CreativeTabsCWRoof() {
		super("chineseworkshoproof");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockLoader.blackTileRoof);
	}
}