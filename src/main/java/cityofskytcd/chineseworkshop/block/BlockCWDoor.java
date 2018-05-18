package cityofskytcd.chineseworkshop.block;

import java.util.Random;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.item.CWItems;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCWDoor extends BlockDoor {
	protected BlockCWDoor(String id, Material materialIn, float hardness) {
		super(materialIn);
		BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.DECORATIONS);
		setSoundType(BlockUtil.getDefaultSound(materialIn));
	}

	private Item getItem() {
		if (this == CWBlocks.DOOR) {
			return CWItems.DOOR;
		} else if (this == CWBlocks.HIGH_DOOR) {
			return CWItems.HIGH_DOOR;
		}
		return null;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return pos.getY() >= worldIn.getHeight() - 1 ? false
				: Blocks.STONE.canPlaceBlockAt(worldIn, pos) && Blocks.STONE.canPlaceBlockAt(worldIn, pos.up());
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER) {
			super.neighborChanged(state, worldIn, pos, blockIn);
		} else {
			boolean flag1 = false;
			BlockPos blockpos1 = pos.up();
			IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

			if (iblockstate1.getBlock() != this) {
				worldIn.setBlockToAir(pos);
				flag1 = true;
			}

			if (flag1) {
				if (!worldIn.isRemote) {
					this.dropBlockAsItem(worldIn, pos, state, 0);
				}
			} else {
				boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos1);

				if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower())
						&& flag != iblockstate1.getValue(POWERED).booleanValue()) {
					worldIn.setBlockState(blockpos1, iblockstate1.withProperty(POWERED, Boolean.valueOf(flag)), 2);

					if (flag != state.getValue(OPEN).booleanValue()) {
						worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
						worldIn.markBlockRangeForRenderUpdate(pos, pos);
						worldIn.playEvent((EntityPlayer) null, flag ? 1006 : 1023, pos, 0);
					}
				}
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : this.getItem();
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this.getItem());
	}
}