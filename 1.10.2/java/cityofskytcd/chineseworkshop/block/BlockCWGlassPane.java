package cityofskytcd.chineseworkshop.block;

import cityofskytcd.chineseworkshop.creativetab.CreativeTabsLoader;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

/**
 * ≤£¡ß∞Â¿‡
 */

public class BlockCWGlassPane extends BlockPane{
	public BlockCWGlassPane(String name,Material materialIn ,boolean canDrop,float hardness,SoundType type) {
		super(materialIn, canDrop);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setSoundType(type);
		this.setCreativeTab(CreativeTabsLoader.tabCWD);
		
	}
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

}