package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * 栅栏类
 */

public class BlockCWFence extends BlockFence {
	public BlockCWFence(String id, Material materialIn, MapColor blockMapColor, float hardness) {
		super(materialIn, blockMapColor);
		BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.DECORATIONS);
		setSoundType(BlockUtil.getDefaultSound(materialIn));
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos).getBlock();
		return block == this || block instanceof BlockFenceGate;
	}

}
