package cityofskytcd.chineseworkshop.block;

import java.util.Random;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.item.CWItems;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
		if (this == CWBlocks.DOOR)
        {
            return CWItems.DOOR;
        }
        else if (this == CWBlocks.HIGH_DOOR)
        {
            return CWItems.HIGH_DOOR;
        }
        return null;
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