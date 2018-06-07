package cityofskytcd.chineseworkshop.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemCWBlockVariants extends ItemCWBlock
{
    private String[] subtypeNames;

    public ItemCWBlockVariants(Block block, String[] subtypeNames)
    {
        super(block);
        setHasSubtypes(true);
        this.subtypeNames = subtypeNames;
    }

    public String[] getSubtypeNames()
    {
        return subtypeNames;
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        if (subtypeNames == null)
        {
            return super.getUnlocalizedName(stack);
        }
        int i = stack.getMetadata();
        return i >= 0 && i < subtypeNames.length ? super.getUnlocalizedName(stack) + "." + this.subtypeNames[i]
                : super.getUnlocalizedName(stack);
    }

}
