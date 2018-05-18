/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * 普通方块类
 */
public class BlockCW extends Block
{
    public BlockCW(String id, Material materialIn, float hardness, SoundType soundType, CreativeTabs tabs)
    {
        super(materialIn);
        BlockUtil.setAttributes(this, id, hardness, tabs);
        setSoundType(soundType);
    }

    public BlockCW(String id, Material materialIn, float hardness, CreativeTabs tabs)
    {
        this(id, materialIn, hardness, BlockUtil.getDefaultSound(materialIn), tabs);
    }

    public BlockCW(String id, Material materialIn, float hardness, SoundType soundType)
    {
        this(id, materialIn, hardness, soundType, CWCreativeTabs.BUILDING_BLOCKS);
    }

    public BlockCW(String id, Material materialIn, float hardness)
    {
        this(id, materialIn, hardness, CWCreativeTabs.BUILDING_BLOCKS);
    }
}
