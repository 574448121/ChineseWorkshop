package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;

/**
 * ∆’Õ®∑ΩøÈ¿‡
 */
public class BlockCW extends Block{
	public BlockCW(String name, Material materialIn, float hardness,SoundType type) {
		super(materialIn);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setCreativeTab(CreativeTabsLoader.tabCWB);
	}
}