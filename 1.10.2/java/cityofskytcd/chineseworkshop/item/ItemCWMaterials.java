package cityofskytcd.chineseworkshop.item;

import net.minecraft.item.Item;
import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;

public class ItemCWMaterials extends Item{
	public ItemCWMaterials(String name)
    {
 	    super();
        this.setUnlocalizedName(name);
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabsLoader.tabCWM);
    }
}
