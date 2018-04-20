package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

/**
 * µ∆¿‡
 */
public class BlockCWLight extends Block {
	public BlockCWLight(String name, Material materialIn, float hardness, SoundType type, float lightLevel) {
		super(materialIn);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setLightLevel(lightLevel);
		this.setCreativeTab(CreativeTabsLoader.tabCWL);
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
