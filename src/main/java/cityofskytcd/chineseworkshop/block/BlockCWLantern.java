package cityofskytcd.chineseworkshop.block;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 灯笼类
 */
public class BlockCWLantern extends BlockCWLight {
	public BlockCWLantern(String name, Material materialIn, float hardness, float lightLevel) {
		super(name, materialIn, hardness, 1F);
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return NULL_AABB;
	}
}
