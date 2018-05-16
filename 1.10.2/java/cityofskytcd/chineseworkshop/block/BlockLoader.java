package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader
{
	/*����*/
	//��שǽ
	public static Block blackBrickWall = new BlockCW("blackbrickwall",Material.ROCK, 1.5F,SoundType.STONE);
	//��ɽ��·��
	public static Block andesitePavement = new BlockCWFace("andesitepavement",Material.ROCK, 1.5F,SoundType.STONE);
	//����
	public static Block redPillars = new BlockCWPillars("redpillars",1.0F,SoundType.WOOD);
	//����
	public static Block darkGreenPillars = new BlockCWPillars("darkgreenpillars",1.0F,SoundType.WOOD);
	//�׻�ǽ
	public static Block whiteGrayWalls = new BlockCW("whitegraywalls",Material.ROCK, 1.5F,SoundType.STONE);

	
	/*��*/
	//ʯ����
	public static Block stoneTowerLamp = new BlockCWLight("stonetowerlamp",Material.ROCK, 1.0F,SoundType.STONE,1.0f);
	//����
	public static Block theLantern = new BlockCWTheLantern("thelantern",Material.WOOD, 0.5F,SoundType.WOOD,1.0f);
	//����
	public static Block candle = new BlockCWCandle("candle",Material.WOOD,1.0F);
	//�׵���
	public static Block whiteLanterns = new BlockCWTheLantern("whitelanterns",Material.WOOD, 0.5F,SoundType.WOOD,1.0f);
	
	
	/*װ��*/
	//����
	public static Block bracketSet = new BlockCWBracketSet("bracketset",Material.WOOD, 0.5F, SoundType.WOOD);
	//�Ŷ�
    public static Block menDun = new  BlockCWMenDun("mendun",Material.ROCK, 1.5F, SoundType.STONE);
    //�ż�
    public static Block doorThreshold = new BlockCWDoorThreshold("doorthreshold",Material.ROCK, 1.0F, SoundType.STONE);
    //����
    public static Block carving = new BlockCWFaceDecorative("carving",Material.WOOD, 0.5F, SoundType.WOOD);    
    //��̳
    public static Block treeAltar = new BlockCWFaceDecorative("treealtar",Material.ROCK, 1.5F,SoundType.STONE);
    //���
    public static Block bench = new BlockCWFaceDecorative("bench",Material.WOOD, 0.5F, SoundType.WOOD);
    //����
    public static Block table = new BlockCWFaceDecorative("table",Material.WOOD, 0.5F, SoundType.WOOD);
    //�׻�ǽ����
  	public static Block whiteGrayWallsStairs = new BlockCWStairs("whitegraywallsstairs",blackBrickWall.getDefaultState(), 1.5F,SoundType.STONE);
	//ֽ��
	public static Block paperWindow = new BlockCWGlassPane("paperwindow",Material.WOOD,true, 0.5F,SoundType.WOOD);
	//������դ��
	public static Block dioriteFence = new BlockCWFence("dioritefence",Material.ROCK, MapColor.STONE, 1.5F,SoundType.STONE);
	//С��שǽ
	public static Block smallBlackBrickWall = new BlockCWSmallWall("smallblackbrickwall",Material.ROCK, MapColor.STONE, 1.5F,SoundType.STONE);
	//С�׻�ǽ
	public static Block smallWhiteGrayWalls = new BlockCWSmallWall("smallwhitegraywalls",Material.ROCK, MapColor.STONE, 1.5F,SoundType.STONE);
	//��ľ��ʽդ��
	public static Block oakChineseFence = new BlockCWFence("oakchinesefence",Material.ROCK, MapColor.WOOD, 1.5F,SoundType.WOOD);
	//��ɽ��դ��
	public static Block andesiteFence = new BlockCWWall("andesitefence",blackBrickWall, 1.5F,SoundType.STONE);
	//����
  	public static Block implicate = new BlockCWGlassPane("implicate",Material.WOOD,true, 1.0F,SoundType.WOOD);
  	//��ɽ��·�����
  	public static Block andesitePavementStairs = new BlockCWStairs("andesitepavementstairs",blackBrickWall.getDefaultState(), 1.5F,SoundType.STONE); 	
    //��ľǽ
  	public static Block oakWall = new BlockCWSmallWall("oakwall",Material.WOOD, MapColor.WOOD, 1.5F,SoundType.WOOD);
  	
  	public static Block cwDoor = new BlockCWDoor("cwdoor",Material.WOOD, 1.5F,SoundType.WOOD);
    /*�ݶ�*/
    //�����ݶ�
  	public static Block blackTileRoof = new BlockCWRoof("blacktileroof",Material.ROCK, 1.5F,SoundType.STONE);  
  	//�����ݼ�
    public static Block blackTileRidgeRoof = new BlockCWFaceRoof("blacktileridgeroof",Material.ROCK, 1.5F, SoundType.STONE);
    //�����ݼ�top
    public static Block blackTileRidgeRoofTop = new BlockCWFaceRoof("blacktileridgerooftop",Material.ROCK, 1.5F, SoundType.STONE);
    //�����ݼ�ת��
    public static Block blackTileRidgeRoofL = new BlockCWFaceRoof("blacktileridgeroofl",Material.ROCK, 1.5F, SoundType.STONE);
    //�����ݼ���Ե
    public static Block blackTileRidgeRoofEdge = new BlockCWFaceRoof("blacktileridgeroofedge",Material.ROCK, 1.5F, SoundType.STONE);
    //�����ݼ�T
    public static Block blackTileRidgeRoofT = new BlockCWFaceRoof("blacktileridgerooft",Material.ROCK, 1.5F, SoundType.STONE);
    //�����ݼ�X
    public static Block blackTileRidgeRoofX = new BlockCWFaceRoof("blacktileridgeroofx",Material.ROCK, 1.5F, SoundType.STONE);
    //�����ݼ�����
    public static Block blackTileRidgeRoofJ = new BlockCWFaceRoof("blacktileridgeroofj",Material.ROCK, 1.5F, SoundType.STONE);
    //�����ݶ�����
    public static Block blackTileRoofj = new BlockCWFaceRoof("blacktileroofj",Material.ROCK, 1.5F, SoundType.STONE);
    //�����ݶ���ש
  	public static Block blackTileRoofSlab = new BlockCWRoofSlab("blacktileroofslab",Material.ROCK, 1.5F,SoundType.STONE);
  	//�����ݶ���שtop
  	public static Block blackTileRoofSlabTop = new BlockCWRoof("blacktileroofslabtop",Material.ROCK, 1.5F,SoundType.STONE);
  	
  	
    /*��ǽ*/
  	//���׻�ǽ
    public static Block thinWhiteGrayWalls = new BlockCWFaceThinWalls("thinwhitegraywalls",Material.ROCK, 1.0F, SoundType.STONE);
    //�����ݶ���Ե��
    public static Block blackTileRoofEdgeY = new BlockCWFaceThinWalls("blacktileroofedgey",Material.ROCK, 1.0F, SoundType.STONE);
    //�����ݶ���Ե��
    public static Block blackTileRoofEdgeZ = new BlockCWFaceThinWalls("blacktileroofedgez",Material.ROCK, 1.0F, SoundType.STONE);
    //�����ݶ���Ե�ҷ���
    public static Block blackTileRoofEdgeYJ = new BlockCWFaceThinWalls("blacktileroofedgeyj",Material.ROCK, 1.0F, SoundType.STONE);
    //�����ݶ���Ե�����
    public static Block blackTileRoofEdgeZJ = new BlockCWFaceThinWalls("blacktileroofedgezj",Material.ROCK, 1.0F, SoundType.STONE);
    //�����ݶ���ש��Ե��
  	public static Block blackTileRoofEdgeSlabZ = new BlockCWFaceThinWallsSlab("blacktileroofedgeslabz",Material.ROCK, 1.0F,SoundType.STONE);
  	//�����ݶ���ש��Ե��top
  	public static Block blackTileRoofEdgeSlabTopZ = new BlockCWFaceThinWalls("blacktileroofedgeslabtopz",Material.ROCK, 1.0F,SoundType.STONE);
  	//�����ݶ���ש��Ե��
  	public static Block blackTileRoofEdgeSlabY = new BlockCWFaceThinWallsSlab("blacktileroofedgeslaby",Material.ROCK, 1.0F,SoundType.STONE);
  	//�����ݶ���ש��Ե��top
  	public static Block blackTileRoofEdgeSlabTopY = new BlockCWFaceThinWalls("blacktileroofedgeslabtopy",Material.ROCK, 1.0F,SoundType.STONE);
  	
  	
    public BlockLoader(FMLPreInitializationEvent event)
    {
        register(stoneTowerLamp, "stone_tower_lamp");
        register(blackBrickWall, "black_brick_wall");
        register(bracketSet,"bracket_set");
        register(redPillars,"red_pillars");
        register(darkGreenPillars,"dark_green_pillars");
        register(blackTileRoof,"black_tile_roof");
        register(whiteGrayWalls,"white_gray_walls");
        register(theLantern,"the_lantern");
        register(candle,"candle");
        register(menDun,"men_dun");
        register(doorThreshold,"door_threshold");
        register(carving,"carving");
        register(blackTileRidgeRoof,"black_tile_ridge_roof");
        register(blackTileRidgeRoofL,"black_tile_ridge_roof_l");
        register(blackTileRidgeRoofEdge,"black_tile_ridge_roof_edge");
        register(blackTileRidgeRoofT,"black_tile_ridge_roof_t");
        register(blackTileRidgeRoofX,"black_tile_ridge_roof_x");
        register(blackTileRidgeRoofJ,"black_tile_ridge_roof_j");
        register(blackTileRoofj,"black_tile_roof_j");
        register(thinWhiteGrayWalls,"thin_white_gray_walls");
        register(blackTileRoofEdgeY,"black_tile_roof_edge_y");
        register(blackTileRoofEdgeZ,"black_tile_roof_edge_z");
        register(blackTileRoofEdgeYJ,"black_tile_roof_edge_yj");
        register(blackTileRoofEdgeZJ,"black_tile_roof_edge_zj");
        register(whiteLanterns,"white_lanterns");
        register(treeAltar,"tree_altar");
        register(bench,"bench");
        register(table,"table");
        register(andesitePavement, "andesite_pavement");
        register(whiteGrayWallsStairs, "white_gray_walls_stairs");
        register(blackTileRoofSlab, "black_tile_roof_slab");
        register(blackTileRoofSlabTop, "black_tile_roof_slab_top");
        register(blackTileRoofEdgeSlabZ, "black_tile_roof_edge_slab_z");
        register(blackTileRoofEdgeSlabTopZ, "black_tile_roof_edge_slab_top_z");
        register(blackTileRoofEdgeSlabY, "black_tile_roof_edge_slab_y");
        register(blackTileRoofEdgeSlabTopY, "black_tile_roof_edge_slab_top_y");       
        register(paperWindow, "paper_window");
        register(dioriteFence, "diorite_fence");
        register(smallBlackBrickWall, "small_black_brick_wall");     
        register(smallWhiteGrayWalls, "small_white_gray_walls");
        register(oakChineseFence, "oak_chinese_fence");
        register(andesiteFence, "andesite_fence");
        register(implicate, "implicate");
        register(andesitePavementStairs, "andesite_pavement_stairs");
        register(blackTileRidgeRoofTop, "black_tile_ridge_roof_top");
        register(oakWall, "oak_wall");
        register(cwDoor, "cw_doors");

    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(stoneTowerLamp);
        registerRender(blackBrickWall);
        registerRender(bracketSet);
        registerRender(redPillars);
        registerRender(darkGreenPillars);
        registerRender(blackTileRoof);
        registerRender(whiteGrayWalls);
        registerRender(theLantern);
        registerRender(candle);
        registerRender(menDun);
        registerRender(doorThreshold);
        registerRender(carving); 
        registerRender(blackTileRidgeRoof); 
        registerRender(blackTileRidgeRoofL); 
        registerRender(blackTileRidgeRoofEdge); 
        registerRender(blackTileRidgeRoofT); 
        registerRender(blackTileRidgeRoofX); 
        registerRender(blackTileRidgeRoofJ); 
        registerRender(blackTileRoofj); 
        registerRender(thinWhiteGrayWalls); 
        registerRender(blackTileRoofEdgeY); 
        registerRender(blackTileRoofEdgeZ); 
        registerRender(blackTileRoofEdgeYJ); 
        registerRender(blackTileRoofEdgeZJ); 
        registerRender(whiteLanterns); 
        registerRender(treeAltar); 
        registerRender(bench); 
        registerRender(table); 
        registerRender(andesitePavement); 
        registerRender(whiteGrayWallsStairs); 
        registerRender(blackTileRoofSlab); 
        registerRender(blackTileRoofSlabTop); 
        registerRender(blackTileRoofEdgeSlabZ); 
        registerRender(blackTileRoofEdgeSlabTopZ); 
        registerRender(blackTileRoofEdgeSlabY); 
        registerRender(blackTileRoofEdgeSlabTopY);
        registerRender(paperWindow);
        registerRender(dioriteFence);
        registerRender(smallBlackBrickWall);
        registerRender(smallWhiteGrayWalls); 
        registerRender(oakChineseFence); 
        registerRender(andesiteFence); 
        registerRender(implicate);
        registerRender(andesitePavementStairs);
        registerRender(blackTileRidgeRoofTop);
        registerRender(oakWall);
        registerRender(cwDoor);
        
    }
    
    private static void register(Block block, String name)
    {
        GameRegistry.registerBlock(block, name);
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        String name = GameData.getBlockRegistry().getNameForObject(block).toString();
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
        ModelLoader.setCustomStateMapper(cwDoor, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
    }
}