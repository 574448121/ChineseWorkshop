/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemCWBlock extends ItemBlock
{

    public ItemCWBlock(Block block)
    {
        super(block);
        setRegistryName(block.getRegistryName());
    }

}
