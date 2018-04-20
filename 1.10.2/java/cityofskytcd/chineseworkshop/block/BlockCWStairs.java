package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockStairs.EnumHalf;
import net.minecraft.block.BlockStairs.EnumShape;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockCWStairs extends BlockStairs{

	protected BlockCWStairs(String name, IBlockState modelState, float hardness,SoundType type) {
		super(modelState);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setCreativeTab(CreativeTabsLoader.tabCWD);
	}
}
