package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.event.ISeat;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.Vec3d;

public class BlockCWBench extends BlockCWFaceDecorative implements ISeat {

	public BlockCWBench(String name, Material materialIn, float hardness) {
		super(name, materialIn, hardness);
	}

	@Override
	public Vec3d getSeat(IBlockState state) {
		return new Vec3d(0.5, 0.4, 0.5);
	}

}
