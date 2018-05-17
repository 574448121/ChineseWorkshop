package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.CWCreativeTabs;
import cityofskytcd.chineseworkshop.util.BlockUtil;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * 柱子类核心
 */
public class BlockCWRotatedPillar extends BlockRotatedPillar {

	public BlockCWRotatedPillar(String id, Material materialIn, float hardness, SoundType soundType,
			CreativeTabs tabs) {
		super(materialIn);
		BlockUtil.setAttributes(this, id, hardness, tabs);
		setSoundType(soundType);
	}

	public BlockCWRotatedPillar(String id, Material materialIn, float hardness, CreativeTabs tabs) {
		this(id, materialIn, hardness, BlockUtil.getDefaultSound(materialIn), tabs);
	}

	public BlockCWRotatedPillar(String id, Material materialIn, float hardness, SoundType soundType) {
		this(id, materialIn, hardness, soundType, CWCreativeTabs.BUILDING_BLOCKS);
	}

	public BlockCWRotatedPillar(String id, Material materialIn, float hardness) {
		this(id, materialIn, hardness, CWCreativeTabs.BUILDING_BLOCKS);
	}
}
