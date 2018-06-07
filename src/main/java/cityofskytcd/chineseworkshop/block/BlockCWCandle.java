/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 蜡烛类
 */

public class BlockCWCandle extends BlockCWT
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>()
    {
        @Override
        public boolean apply(@Nullable EnumFacing p_apply_1_)
        {
            return p_apply_1_ != EnumFacing.DOWN;
        }
    });

    protected BlockCWCandle(String name, Material materialIn, float lightLevel)
    {
        super(name, materialIn, 0F);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
        setTickRandomly(true);
        setLightLevel(lightLevel);
    }

    protected static final AxisAlignedBB STANDING_AABB = new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 0.7D, 0.7D);
    protected static final AxisAlignedBB TORCH_NORTH_AABB = new AxisAlignedBB(0.2D, 0.20000000298023224D, 0.3D, 0.8D, 0.800000011920929D, 1.0D);
    protected static final AxisAlignedBB TORCH_SOUTH_AABB = new AxisAlignedBB(0.2D, 0.1D, 0.0D, 0.8D, 0.800000011920929D, 0.7D);
    protected static final AxisAlignedBB TORCH_WEST_AABB = new AxisAlignedBB(0.3D, 0.20000000298023224D, 0.2D, 1.0D, 0.800000011920929D, 0.8D);
    protected static final AxisAlignedBB TORCH_EAST_AABB = new AxisAlignedBB(0.0D, 0.20000000298023224D, 0.2D, 0.70000001192092896D, 0.800000011920929D, 0.8D);

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch (state.getValue(FACING))
        {
        case EAST:
            return TORCH_EAST_AABB;
        case WEST:
            return TORCH_WEST_AABB;
        case SOUTH:
            return TORCH_SOUTH_AABB;
        case NORTH:
            return TORCH_NORTH_AABB;
        default:
            return STANDING_AABB;
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    private boolean canPlaceOn(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos);
        if (state.isSideSolid(worldIn, pos, EnumFacing.UP))
        {
            return true;
        }
        return state.getBlock().canPlaceTorchOnTop(state, worldIn, pos);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : FACING.getAllowedValues())
        {
            if (this.canPlaceAt(worldIn, pos, enumfacing))
            {
                return true;
            }
        }

        return false;
    }

    private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing)
    {
        BlockPos blockpos = pos.offset(facing.getOpposite());
        boolean flag = facing.getAxis().isHorizontal();
        return flag && worldIn.isSideSolid(blockpos, facing, true)
                || facing.equals(EnumFacing.UP) && this.canPlaceOn(worldIn, blockpos);
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to
     * allow for adjustments to the IBlockstate
     */
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        if (this.canPlaceAt(worldIn, pos, facing))
        {
            return this.getDefaultState().withProperty(FACING, facing);
        }
        for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
        {
            if (worldIn.isSideSolid(pos.offset(enumfacing.getOpposite()), enumfacing, true))
            {
                return this.getDefaultState().withProperty(FACING, enumfacing);
            }
        }

        return this.getDefaultState();
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.checkForDrop(worldIn, pos, state);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        this.onNeighborChangeInternal(worldIn, pos, state);
    }

    protected boolean onNeighborChangeInternal(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.checkForDrop(worldIn, pos, state))
        {
            return true;
        }
        EnumFacing enumfacing = state.getValue(FACING);
        EnumFacing.Axis enumfacing$axis = enumfacing.getAxis();
        EnumFacing enumfacing1 = enumfacing.getOpposite();
        boolean flag = false;

        if (enumfacing$axis.isHorizontal() && !worldIn.isSideSolid(pos.offset(enumfacing1), enumfacing, true))
        {
            flag = true;
        }
        else if (enumfacing$axis.isVertical() && !this.canPlaceOn(worldIn, pos.offset(enumfacing1)))
        {
            flag = true;
        }

        if (flag)
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
            return true;
        }
        return false;
    }

    protected boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() == this && this.canPlaceAt(worldIn, pos, state.getValue(FACING)))
        {
            return true;
        }
        if (worldIn.getBlockState(pos).getBlock() == this)
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        EnumFacing enumfacing = stateIn.getValue(FACING);
        double d0 = pos.getX() + 0.5D;
        double d1 = pos.getY() + 0.5D;
        double d2 = pos.getZ() + 0.5D;
        if (enumfacing.getAxis().isHorizontal())
        {
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1 + 0.4D, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 0.4D, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1 + 0.1D, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + 0.1D, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta)
        {
        case 1:
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
            break;
        case 2:
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
            break;
        case 3:
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
            break;
        case 4:
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
            break;
        case 5:
        default:
            iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
        }

        return iblockstate;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        switch (state.getValue(FACING))
        {
        case EAST:
            i = i | 1;
            break;
        case WEST:
            i = i | 2;
            break;
        case SOUTH:
            i = i | 3;
            break;
        case NORTH:
            i = i | 4;
            break;
        case DOWN:
        case UP:
        default:
            i = i | 5;
        }

        return i;
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If
     * inapplicable, returns the passed blockstate.
     */
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If
     * inapplicable, returns the passed blockstate.
     */
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { FACING });
    }
}
