package cityofskytcd.chineseworkshop.block;

import java.util.Random;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCWDoor extends BlockDoor{
	
	protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1875D);
	protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.8125D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.1875D, 1.0D, 1.0D);
	protected BlockCWDoor(String name, Material materialIn, float hardness,SoundType type) {
		super(materialIn);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
	}
	 public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        state = state.getActualState(source, pos);
	        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
	        boolean flag = !((Boolean)state.getValue(OPEN)).booleanValue();
	        boolean flag1 = state.getValue(HINGE) == BlockDoor.EnumHingePosition.RIGHT;

	        switch (enumfacing)
	        {
	            case EAST:
	            default:
	                return flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
	            case SOUTH:
	                return flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
	            case WEST:
	                return flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
	            case NORTH:
	                return flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
	        }
	    }
	private Item getItem(){
		return ItemLoader.cwDoor;
	}

	@Override
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : this.getItem();
    }
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(this.getItem());
    }
}