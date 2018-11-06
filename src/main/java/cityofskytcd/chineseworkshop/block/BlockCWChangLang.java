package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.event.ISeat;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.Vec3d;

public class BlockCWChangLang extends BlockCWRoof implements ISeat{

	public BlockCWChangLang(String name, Material materialIn, float hardness) {
		super(name, materialIn, hardness);
        setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, BlockCWRoof.EnumShape.STRAIGHT));
	}
    @Override
    public Vec3d getSeat(IBlockState state)
    {
        return new Vec3d(0.4, 0.4, 0.4);
    }
}
