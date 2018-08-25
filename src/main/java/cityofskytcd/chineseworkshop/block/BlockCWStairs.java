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
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockCWStairs extends BlockStairs
{

    protected BlockCWStairs(String id, IBlockState state, float hardness)
    {
        super(state);
        BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.BUILDING_BLOCKS);
        setSoundType(BlockUtil.getDefaultSound(state.getMaterial()));
        useNeighborBrightness = true;
    }
}
