package cityofskytcd.chineseworkshop.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemCWBlockVariants extends ItemCWBlock
{
    private String[] subtypeNames;

    public ItemCWBlockVariants(Block block, String... subtypeNames)
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
    public String getTranslationKey(ItemStack stack)
    {
        if (subtypeNames == null)
        {
            return super.getTranslationKey(stack);
        }
        int i = stack.getMetadata();
        return i >= 0 && i < subtypeNames.length ? super.getTranslationKey(stack) + "." + this.subtypeNames[i]
                : super.getTranslationKey(stack);
    }

}
