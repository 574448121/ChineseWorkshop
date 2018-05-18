package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * 墙类
 */

public class BlockCWWall extends BlockWall {

	public BlockCWWall(String id, Block modelBlock, float hardness) {
		super(modelBlock);
		BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.DECORATIONS);
		setSoundType(BlockUtil.getDefaultSound(modelBlock.getMaterial(modelBlock.getDefaultState())));
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		boolean flag = this.canConnectTo(worldIn, pos.north());
		boolean flag1 = this.canConnectTo(worldIn, pos.east());
		boolean flag2 = this.canConnectTo(worldIn, pos.south());
		boolean flag3 = this.canConnectTo(worldIn, pos.west());
		boolean flag4 = flag && !flag1 && flag2 && !flag3 || !flag && flag1 && !flag2 && flag3;
		return state.withProperty(UP, Boolean.valueOf(!flag4 || !worldIn.isAirBlock(pos.up())))
				.withProperty(NORTH, Boolean.valueOf(flag)).withProperty(EAST, Boolean.valueOf(flag1))
				.withProperty(SOUTH, Boolean.valueOf(flag2)).withProperty(WEST, Boolean.valueOf(flag3));
	}

	private boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos).getBlock();
		return block == this || block instanceof BlockFenceGate;
	}

	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
}
