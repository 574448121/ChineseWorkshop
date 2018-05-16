package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

/**
 * 玻璃板类
 */

public class BlockCWGlassPane extends BlockPane {
	public BlockCWGlassPane(String name, Material materialIn, boolean canDrop, float hardness, SoundType type) {
		super(materialIn, canDrop);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setCreativeTab(CreativeTabsLoader.tabCWD);

	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

}