package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * 栅栏类
 */

public class BlockCWFence extends BlockFence {
	public BlockCWFence(String id, Material materialIn, MapColor blockMapColor, float hardness) {
		super(materialIn, blockMapColor);
		BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.DECORATIONS);
		setSoundType(BlockUtil.getDefaultSound(materialIn));
	}

}
