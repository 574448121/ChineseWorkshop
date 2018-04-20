package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;

public class BlockCWs extends Block{
	public BlockCWs(String name, Material materialIn, float hardness,SoundType type) {
		super(materialIn);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setCreativeTab(CreativeTabsLoader.tabCWB);
	}
	public boolean isOpaqueCube(IBlockState state)
	{
	    return false;
	}

	public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }
}
