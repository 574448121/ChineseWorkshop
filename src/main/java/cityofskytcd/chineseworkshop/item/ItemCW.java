/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.CWCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCW extends Item
{
    public ItemCW(String id, CreativeTabs tabs)
    {
        super();
        setRegistryName(CW.MODID, id);
        setTranslationKey(CW.MODID + "." + id);
        setCreativeTab(tabs);
    }

    public ItemCW(String id)
    {
        this(id, CWCreativeTabs.ITEMS);
    }
}
