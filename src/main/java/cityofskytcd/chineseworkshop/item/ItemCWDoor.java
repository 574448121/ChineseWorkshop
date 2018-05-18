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
import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;

public class ItemCWDoor extends ItemDoor
{

    public ItemCWDoor(String id, Block blockIn)
    {
        super(blockIn);
        setRegistryName(CW.MODID, id);
        setUnlocalizedName(CW.MODID + "." + id);
        setCreativeTab(CWCreativeTabs.DECORATIONS);
    }
}
