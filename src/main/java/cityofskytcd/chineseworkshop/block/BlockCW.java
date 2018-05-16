package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * 普通方块类
 */
public class BlockCW extends Block {
	public BlockCW(String name, Material materialIn, float hardness, SoundType type) {
		super(materialIn);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setCreativeTab(CreativeTabsLoader.tabCWB);
	}
}