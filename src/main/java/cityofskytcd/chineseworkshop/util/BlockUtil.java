package cityofskytcd.chineseworkshop.util;

import cityofskytcd.chineseworkshop.CW;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockUtil {
	public static SoundType getDefaultSound(Material material) {
		if (material == Material.WOOD) {
			return SoundType.WOOD;
		}
		if (material == Material.IRON) {
			return SoundType.METAL;
		}
		if (material == Material.ANVIL) {
			return SoundType.ANVIL;
		}
		if (material == Material.GLASS) {
			return SoundType.GLASS;
		}
		if (material == Material.CLOTH) {
			return SoundType.CLOTH;
		}
		if (material == Material.GOURD) {
			return SoundType.GROUND;
		}
		if (material == Material.GRASS || material == Material.PLANTS || material == Material.LEAVES) {
			return SoundType.PLANT;
		}
		return SoundType.STONE;
	}

	public static void setAttributes(Block block, String id, float hardness, CreativeTabs tabs) {
		block.setRegistryName(CW.MODID, id);
		block.setUnlocalizedName(CW.MODID + "." + id);
		block.setCreativeTab(tabs);
		block.setHardness(hardness);
	}
}
