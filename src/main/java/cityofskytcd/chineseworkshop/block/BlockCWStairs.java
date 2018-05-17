package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockCWStairs extends BlockStairs {

	protected BlockCWStairs(String id, IBlockState state, float hardness) {
		super(state);
		BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.BUILDING_BLOCKS);
		setSoundType(BlockUtil.getDefaultSound(state.getMaterial()));
	}
}
