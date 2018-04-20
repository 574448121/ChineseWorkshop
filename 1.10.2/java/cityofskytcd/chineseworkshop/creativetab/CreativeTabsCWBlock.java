package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabsCWBlock extends CreativeTabs
{
    public CreativeTabsCWBlock()
    {
        super("chineseworkshopblock");
    }

    @Override
    public Item getTabIconItem()
    {
    	return ItemLoader.logo;
    }
}