package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsCWLight extends CreativeTabs {
	public CreativeTabsCWLight() {
		super("chineseworkshoplight");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockLoader.stoneTowerLamp);
	}
}