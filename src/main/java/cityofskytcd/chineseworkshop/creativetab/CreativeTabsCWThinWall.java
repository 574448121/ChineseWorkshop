package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsCWThinWall extends CreativeTabs {
	public CreativeTabsCWThinWall() {
		super("chineseworkshopthinwall");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockLoader.thinWhiteGrayWalls);
	}
}