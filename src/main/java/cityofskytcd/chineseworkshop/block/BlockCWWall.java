///**
// * This file is part of Chinese Workshop
// * (https://github.com/574448121/ChineseWorkshop)
// * 
// * Chinese Workshop is an Open-Source project under MIT License
// * (https://opensource.org/licenses/MIT)
// */
//
//package cityofskytcd.chineseworkshop.block;
//
//import cityofskytcd.chineseworkshop.CWCreativeTabs;
//import cityofskytcd.chineseworkshop.util.BlockUtil;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockWall;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.IBlockAccess;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
///**
// * 墙类
// */
//
//public class BlockCWWall extends BlockWall
//{
//
//    @SuppressWarnings("deprecation")
//    public BlockCWWall(String id, Block modelBlock, float hardness)
//    {
//        super(modelBlock);
//        BlockUtil.setAttributes(this, id, hardness, CWCreativeTabs.DECORATIONS);
//        setSoundType(BlockUtil.getDefaultSound(modelBlock.getMaterial(modelBlock.getDefaultState())));
//    }
//
//    @Override
//    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos)
//    {
//        return true;
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
//    {
//        items.add(new ItemStack(this));
//    }
//}
