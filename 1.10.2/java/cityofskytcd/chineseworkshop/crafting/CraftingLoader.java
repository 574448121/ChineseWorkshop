package cityofskytcd.chineseworkshop.crafting;

import cityofskytcd.chineseworkshop.block.BlockLoader;
import cityofskytcd.chineseworkshop.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader
{
    public CraftingLoader()
    {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe()
    {
    	/*����*/
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackBrickWall), new Object[]
    	        {
    	                "##", "##", '#', ItemLoader.blackBrick
    	                });
    	GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.redPillars,2), new Object[]
    	        {
    	                Items.CLAY_BALL,Blocks.LOG,new ItemStack(Items.DYE,1,1),Items.CLAY_BALL
    	                });
    	GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.darkGreenPillars,2), new Object[]
    	        {
    	        		Items.CLAY_BALL,Blocks.LOG,new ItemStack(Items.DYE,1,2),Items.CLAY_BALL
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteGrayWalls,4), new Object[]
    	        {
    	                "**", "*#",'#', Blocks.SAND,'*',Items.QUARTZ
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteGrayWalls,2), new Object[]
    	        {
    	                "**", "*#",'#', Blocks.SAND,'*',new ItemStack(Items.DYE,1,15)
    	                });
    	/*��*/
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.stoneTowerLamp,3), new Object[]
    	        {
    	                " * ", "*@*","#!#",'#', Blocks.STONE,'*',Blocks.STONEBRICK,'@',Blocks.REDSTONE_LAMP,'!',Blocks.REDSTONE_TORCH
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.theLantern,6), new Object[]
    	        {
    	                "#*#", "#!#","#*#",'#', new ItemStack(Blocks.WOOL,1,14),'*',new ItemStack(Blocks.WOOL,1,4),'!',Blocks.TORCH
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.candle,6), new Object[]
    	        {
    	                "  #", " **","*  ",'#', Blocks.TORCH,'*',Items.IRON_INGOT
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteLanterns,2), new Object[]
    	        {
    	                "***", "#!#","***",'#', Items.STICK,'*',Items.PAPER,'!',Blocks.TORCH
    	                });
    	/*����*/
    	GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.blackClay,8), new Object[]
    	        {
    	        	"###", "#*#","###",'#',Items.CLAY_BALL,'*',Items.DYE
    	        		});
    	/*װ��*/

    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.bracketSet), new Object[]
    	        {
    	                "###", "###"," # ",'#', Items.STICK
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoof,16), new Object[]
    	        {
    	                "  #", " ##","###",'#', ItemLoader.blackBrick
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoof,16), new Object[]
    	        {
    	                "#  ", "## ","###",'#', ItemLoader.blackBrick
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.carving,3), new Object[]
    	        {
    	                "###", "###",'#', Items.STICK
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.menDun,4), new Object[]
    	        {
    	                " **", " **","###",'#', new ItemStack(Blocks.STONE_SLAB,1,0),'*',Blocks.STONEBRICK
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.doorThreshold,3), new Object[]
    	        {
    	                "###",'#',new ItemStack(Blocks.STONE_SLAB,1,0)
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoof,16), new Object[]
    	        {
    	                "###","###",'#',ItemLoader.blackBrick
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofL,5), new Object[]
    	        {
    	                "#  ","#  ","###",'#',BlockLoader.blackTileRidgeRoof
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofEdge,3), new Object[]
    	        {
    	                "#","#","#",'#',BlockLoader.blackTileRidgeRoof
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofT,4), new Object[]
    	        {
    	                "###"," # ",'#',BlockLoader.blackTileRidgeRoof
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofX,5), new Object[]
    	        {
    	                "# #"," # ","# #",'#',BlockLoader.blackTileRidgeRoof
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofJ,3), new Object[]
    	        {
    	                "#  "," # ","  #",'#',BlockLoader.blackTileRidgeRoof
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofj,3), new Object[]
    	        {
    	                "#  "," # ","  #",'#',BlockLoader.blackTileRoof
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.thinWhiteGrayWalls,18), new Object[]
    	        {
    	                "#","#","#",'#',BlockLoader.whiteGrayWalls
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeZ,6), new Object[]
    	        {
    	                " #","#*",'#',BlockLoader.whiteGrayWalls,'*',BlockLoader.blackTileRoof
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeY,6), new Object[]
    	        {
    	                "# ","*#",'*',BlockLoader.whiteGrayWalls,'#',BlockLoader.blackTileRoof
    	                });
    	GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeYJ,1), new Object[]
    	        {
    	                ItemLoader.blackBrick,BlockLoader.blackTileRoofEdgeY
    	                });
    	GameRegistry.addShapelessRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeZJ,1), new Object[]
    	        {
    	                ItemLoader.blackBrick,BlockLoader.blackTileRoofEdgeZ
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.treeAltar,2), new Object[]
    	        {
    	                "*#*",'#',Blocks.LOG,'*',BlockLoader.blackBrickWall
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.bench,1), new Object[]
    	        {
    	                "###","***","* *",'#',Blocks.WOODEN_SLAB,'*',Items.STICK
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.table,4), new Object[]
    	        {
    	                "###","* *","* *",'#',Blocks.WOODEN_SLAB,'*',Blocks.PLANKS
    	                });
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.andesitePavement,2), new Object[]
    	        {
    	                "#*", "*#",'#', new ItemStack(Blocks.STONE,1,6),'*',ItemLoader.blackBrick
    	                });
    	//�׻�ǽ����
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.whiteGrayWallsStairs,6), new Object[]
    	        {
    	                "#  ","## ","###",'#',BlockLoader.whiteGrayWalls
    	                });
    	//ֽ��
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.paperWindow,4), new Object[]
    	        {
    	                "#*#","#*#",'#',Items.STICK,'*',Items.PAPER
    	                });
    	//������դ��
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.dioriteFence,6), new Object[]
    	        {
    	                "###","###",'#',new ItemStack(Blocks.STONE,1,3)
    	                });
    	//С��שǽ
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.smallBlackBrickWall,6), new Object[]
    	        {
    	                "###","###",'#',BlockLoader.blackBrickWall
    	                });
    	//С�׻�ǽ
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.smallWhiteGrayWalls,6), new Object[]
    	        {
    	                "###","###",'#',BlockLoader.whiteGrayWalls
    	                });
    	//��ľ��ʽդ��
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.oakChineseFence,10), new Object[]
    	        {
    	                "#*#","#*#",'#',new ItemStack(Blocks.LOG,1,0),'*',new ItemStack(Blocks.PLANKS,1,0)
    	                });
    	//��ɽ��դ��
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.andesiteFence,6), new Object[]
    	        {
    	                "###","###",'#',new ItemStack(Blocks.STONE,1,5)
    	                });
    	//����
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.implicate,10), new Object[]
    	        {
    	                "#*#","#*#",'*',new ItemStack(Blocks.LOG,1,0),'#',Items.STICK
    	                });
    	//��ɽ��·��¥��
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.andesitePavementStairs,6), new Object[]
    	        {
    	                "#  ","## ","###",'#',BlockLoader.andesitePavement
    	                });
    	//��ľǽ
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.oakWall,9), new Object[]
    	        {
    	                "###","###","###",'#',new ItemStack(Blocks.PLANKS,1,0)
    	                });
    	
    	/*�ݶ�*/
    	//�����ݶ���ש
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofSlab,6), new Object[]
    	        {
    	                "###",'#',BlockLoader.blackTileRoof
    	                });
    	//�����ݶ���שtop
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofSlabTop,12), new Object[]
    	        {
    	                "###","###",'#',BlockLoader.blackTileRoof
    	                });
    	//�����ݼ�top
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRidgeRoofTop,3), new Object[]
    	        {
    	                "###",'#',BlockLoader.blackTileRidgeRoof
    	                });
    	/*��ǽ*/
    	//�����ݶ���ש��Ե��
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeSlabZ,4), new Object[]
    	        {
    	                "##",'#',BlockLoader.blackTileRoofEdgeZ
    	                });
    	//�����ݶ���ש��Ե��TOP
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeSlabTopZ,6), new Object[]
    	        {
    	        		"###",'#',BlockLoader.blackTileRoofEdgeZ
    	                });
    	//�����ݶ���ש��Ե��
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeSlabY,4), new Object[]
    	        {
    	                "##",'#',BlockLoader.blackTileRoofEdgeY
    	                });
    	//�����ݶ���ש��Ե��TOP
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blackTileRoofEdgeSlabTopY,6), new Object[]
    	        {
    	        		"###",'#',BlockLoader.blackTileRoofEdgeY
    	                });
    }	

    private static void registerSmelting()
    {
    	/*װ��*/
    	GameRegistry.addSmelting(ItemLoader.blackClay, new ItemStack(ItemLoader.blackBrick), 0.5F);
    }

    private static void registerFuel()
    {

    }
}