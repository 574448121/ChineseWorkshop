///*
// * This class was from SpringFestival, licensed under MPL 2.0. Authored by
// * <3TUSK>.
// */
//
//package cityofskytcd.chineseworkshop.util;
//
//import javax.annotation.Nonnull;
//
//import cityofskytcd.chineseworkshop.CW;
//import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.item.Item;
//import net.minecraft.util.IStringSerializable;
//import net.minecraftforge.client.model.ModelLoader;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@SideOnly(Side.CLIENT)
//public final class ModelUtil
//{
//    private ModelUtil()
//    {
//    }
//
//    public static void mapItemModel(Item item)
//    {
//        ModelLoader.setCustomModelResourceLocation(
//                item,
//                0,
//                new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
//    }
//
//    public static void mapItemModel(Item item, @Nonnull String customPath)
//    {
//        ModelLoader.setCustomModelResourceLocation(
//                item,
//                0,
//                new ModelResourceLocation(CW.MODID + ":" + customPath, "inventory"));
//    }
//
//    public static void mapItemVariantsModel(Item item, String suffix, IStringSerializable[] types)
//    {
//        for (int i = 0; i < types.length; i++)
//        {
//            ModelLoader.setCustomModelResourceLocation(
//                    item,
//                    i,
//                    new ModelResourceLocation(CW.MODID + ":" + types[i].getName() + suffix, "inventory"));
//        }
//    }
//}
