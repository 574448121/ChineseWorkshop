package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.library.ISeat;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;

public class ChairBlock extends RoofTileBlock implements ISeat {
	public ChairBlock(Properties builder, boolean retexture) {
		super(builder, retexture);
	}

	@Override
	public Vector3d getSeat(BlockState state, IWorldReader world, BlockPos pos) {
		return new Vector3d(0.5, 0.4, 0.5);
	}
}
