package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemDoor;

public class ItemCWDoor extends ItemDoor{

	public ItemCWDoor(String name, Block materialIn) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabsLoader.tabCWB);
}
}