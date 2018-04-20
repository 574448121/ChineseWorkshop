package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsCWThinWall extends CreativeTabs {
	public CreativeTabsCWThinWall() {
		super("chineseworkshopthinwall");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockLoader.thinWhiteGrayWalls);
	}
}