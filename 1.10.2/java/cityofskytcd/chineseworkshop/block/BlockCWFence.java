package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

/**
 * դ����
 */

public class BlockCWFence extends BlockFence{
	public BlockCWFence(String name, Material materialIn , MapColor blockMapColor ,float hardness,SoundType type) {
		super(materialIn, blockMapColor);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setCreativeTab(CreativeTabsLoader.tabCWD);
	}

}
