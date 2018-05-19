/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop;

import cityofskytcd.chineseworkshop.block.CWBlocks;
import cityofskytcd.chineseworkshop.item.CWItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CWCreativeTabs
{

    public static final CreativeTabs BUILDING_BLOCKS = new CreativeTabs(CW.MODID + ".building_blocks")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(CWItems.LOGO);
        }
    };

    public static final CreativeTabs DECORATIONS = new CreativeTabs(CW.MODID + ".decorations")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(CWBlocks.BRACKET_SET);
        }
    };

    public static final CreativeTabs ITEMS = new CreativeTabs(CW.MODID + ".items")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(CWItems.MATERIAL, 1, 1);
        }
    };
}
