package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * 玻璃板类
 */

public class BlockCWPane extends BlockPane {
	public BlockCWPane(String id, Material materialIn, boolean canDrop, float hardness) {
		super(materialIn, canDrop);
		BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.DECORATIONS);
		setSoundType(BlockUtil.getDefaultSound(materialIn));
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
}