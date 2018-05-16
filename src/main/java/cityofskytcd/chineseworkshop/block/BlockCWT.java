package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCWT extends BlockCW {

	public BlockCWT(String id, Material materialIn, float hardness) {
		super(id, materialIn, hardness, CWCreativeTabs.DECORATIONS);
	}

	public BlockCWT(String id, Material materialIn, float hardness, CreativeTabs tabs) {
		super(id, materialIn, hardness, tabs);
	}

	public BlockCWT(String id, Material materialIn, float hardness, SoundType soundType) {
		super(id, materialIn, hardness, soundType);
	}

	public BlockCWT(String id, Material materialIn, float hardness, SoundType soundType, CreativeTabs tabs) {
		super(id, materialIn, hardness, soundType, tabs);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
