package cityofskytcd.chineseworkshop.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader
{
    public static CreativeTabs tabCWB;
    public static CreativeTabs tabCWL;
    public static CreativeTabs tabCWM;
    public static CreativeTabs tabCWD;
    public static CreativeTabs tabCWT;
    public static CreativeTabs tabCWF;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
    	tabCWB = new CreativeTabsCWBlock();
    	tabCWL = new CreativeTabsCWLight();
    	tabCWM = new CreativeTabsCWMaterials();
    	tabCWD = new CreativeTabsCWDecorative();
    	tabCWT = new CreativeTabsCWThinWall();
    	tabCWF = new CreativeTabsCWRoof();
    }
}