package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

/**
 * 柱子类
 */
public class BlockCWPillars extends BlockCWPillarsCore {

	public BlockCWPillars(String name, float hardness, SoundType type) {
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setCreativeTab(CreativeTabsLoader.tabCWB);
		this.setDefaultState(this.blockState.getBaseState().withProperty(Column_AXIS, BlockCWPillars.EnumAxis.Y));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState();

		switch (meta & 12) {
		case 4:
			iblockstate = iblockstate.withProperty(Column_AXIS, BlockCWPillars.EnumAxis.X);
			break;
		case 8:
			iblockstate = iblockstate.withProperty(Column_AXIS, BlockCWPillars.EnumAxis.Z);
			break;
		default:
			iblockstate = iblockstate.withProperty(Column_AXIS, BlockCWPillars.EnumAxis.Y);
		}

		return iblockstate;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	@SuppressWarnings("incomplete-switch")
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		switch (state.getValue(Column_AXIS)) {
		case X:
			i |= 4;
			break;
		case Z:
			i |= 8;
		}

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { Column_AXIS });
	}

	/**
	 * Gets the metadata of the item this Block can drop. This method is called when
	 * the block gets destroyed. It returns the metadata of the dropped item based
	 * on the old metadata of the block.
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}
}
