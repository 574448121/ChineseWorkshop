package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * ���������
 */
public abstract class BlockCWPillarsCore extends BlockRotatedPillar {
	public static final PropertyEnum<BlockCWPillarsCore.EnumAxis> Column_AXIS = PropertyEnum.<BlockCWPillarsCore.EnumAxis>create(
			"axis", BlockCWPillarsCore.EnumAxis.class);

	public BlockCWPillarsCore() {
		super(Material.ROCK);
		this.setCreativeTab(CreativeTabsLoader.tabCWB);
		this.setHardness(2.0F);
		this.setSoundType(SoundType.STONE);
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		int i = 4;
		int j = 5;

		if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5))) {
			for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4))) {
				IBlockState iblockstate = worldIn.getBlockState(blockpos);
			}
		}
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(Column_AXIS,
				BlockCWPillarsCore.EnumAxis.fromFacingAxis(facing.getAxis()));
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:

			switch ((BlockCWPillarsCore.EnumAxis) state.getValue(Column_AXIS)) {
			case X:
				return state.withProperty(Column_AXIS, BlockCWPillarsCore.EnumAxis.Z);
			case Z:
				return state.withProperty(Column_AXIS, BlockCWPillarsCore.EnumAxis.X);
			default:
				return state;
			}

		default:
			return state;
		}
	}

	@Override
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(Column_AXIS,
				BlockCWPillarsCore.EnumAxis.fromFacingAxis(facing.getAxis()));
	}

	public static enum EnumAxis implements IStringSerializable {
		X("x"), Y("y"), Z("z");

		private final String name;

		private EnumAxis(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}

		public static BlockCWPillarsCore.EnumAxis fromFacingAxis(EnumFacing.Axis axis) {
			switch (axis) {
			case X:
				return X;
			case Y:
				return Y;
			case Z:
				return Z;
			default:
				return X;
			}
		}

		public String getName() {
			return this.name;
		}
	}
}
