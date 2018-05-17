package cityofskytcd.chineseworkshop.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemCWBlock extends ItemBlock {

	public ItemCWBlock(Block block) {
		super(block);
		setRegistryName(block.getRegistryName());
	}

}
