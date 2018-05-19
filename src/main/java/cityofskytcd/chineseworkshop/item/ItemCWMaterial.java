package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.CWCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemCWMaterial extends ItemCW
{

    public ItemCWMaterial()
    {
        super("material");
        setCreativeTab(CWCreativeTabs.ITEMS);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        switch (stack.getMetadata())
        {
        case 0:
            return "item." + CW.MODID + ".black_clay";
        case 1:
            return "item." + CW.MODID + ".black_brick";
        }
        return "item." + CW.MODID + ".unknown_material";
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            for (int i = 0; i < 2; ++i)
            {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }
}
