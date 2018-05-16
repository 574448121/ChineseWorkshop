package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.material.Material;

/**
 * 灯类
 */
public class BlockCWLight extends BlockCWT {
	public BlockCWLight(String name, Material materialIn, float hardness, float lightLevel) {
		super(name, materialIn, hardness);
		setLightLevel(lightLevel);
	}
}
