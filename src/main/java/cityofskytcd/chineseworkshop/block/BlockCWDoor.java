/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

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
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCWDoor extends BlockDoor
{
    protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.125D);
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.875D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.875D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.125D, 1.0D, 1.0D);

    protected BlockCWDoor(String id, Material materialIn, float hardness)
    {
        super(materialIn);
        BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.DECORATIONS);
        setSoundType(BlockUtil.getDefaultSound(materialIn));
    }

    private Item getItem()
    {
        if (this == CWBlocks.DOOR)
        {
            return CWItems.DOOR;
        }
        else if (this == CWBlocks.HIGH_DOOR)
        {
            return CWItems.HIGH_DOOR;
        }
        else if (this == CWBlocks.WINDOW_DOOR)
        {
            return CWItems.WINDOW_DOOR;
        }
        else if (this == CWBlocks.WOODEN_WINDOW_DOOR)
        {
            return CWItems.WOODEN_WINDOW_DOOR;
        }
        else if (this == CWBlocks.CHINESE_OAK_DOOR)
        {
            return CWItems.CHINESE_OAK_DOOR;
        }
        return null;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return pos.getY() >= worldIn.getHeight() - 1 ? false
                : Blocks.STONE.canPlaceBlockAt(worldIn, pos) && Blocks.STONE.canPlaceBlockAt(worldIn, pos.up());
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER)
        {
            super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
        }
        else
        {
            boolean flag1 = false;
            BlockPos blockpos1 = pos.up();
            IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

            if (iblockstate1.getBlock() != this)
            {
                worldIn.setBlockToAir(pos);
                flag1 = true;
            }

            if (flag1)
            {
                if (!worldIn.isRemote)
                {
                    this.dropBlockAsItem(worldIn, pos, state, 0);
                }
            }
            else
            {
                boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos1);

                if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower())
                        && flag != iblockstate1.getValue(POWERED).booleanValue())
                {
                    worldIn.setBlockState(blockpos1, iblockstate1.withProperty(POWERED, Boolean.valueOf(flag)), 2);

                    if (flag != state.getValue(OPEN).booleanValue())
                    {
                        worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
                        worldIn.markBlockRangeForRenderUpdate(pos, pos);
                        worldIn.playEvent((EntityPlayer) null, flag ? 1006 : 1023, pos, 0);
                    }
                }
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : this.getItem();
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        Item item = getItem();
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = state.getActualState(source, pos);
        EnumFacing enumfacing = state.getValue(FACING);
        boolean flag = !state.getValue(OPEN).booleanValue();
        boolean flag1 = state.getValue(HINGE) == BlockDoor.EnumHingePosition.RIGHT;

        AxisAlignedBB box;
        switch (enumfacing)
        {
        case EAST:
        default:
            box = flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
            break;
        case SOUTH:
            box = flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
            break;
        case WEST:
            box = flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
            break;
        case NORTH:
            box = flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
            break;
        }

        Vec3i facing = enumfacing.getDirectionVec();
        float offset = 3 / 16F;
        return box.offset(facing.getX() * offset, facing.getY(), facing.getZ() * offset);
    }

    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
}
