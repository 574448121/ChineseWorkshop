package cityofskytcd.chineseworkshop.creativetab;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabsCWLight extends CreativeTabs
{
    public CreativeTabsCWLight()
    {
        super("chineseworkshoplight");
    }

    @Override
    public Item getTabIconItem()
    {
    	return Item.getItemFromBlock(BlockLoader.stoneTowerLamp);
    }
}