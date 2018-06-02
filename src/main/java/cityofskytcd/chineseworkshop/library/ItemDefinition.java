package cityofskytcd.chineseworkshop.library;

import java.util.Objects;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Comparable, NBT-insensitive item definition that may be used as key of Map.
 *
 * 可比较的物品定义信息，忽略 NBT 数据，可用作 Map 的键。
 *
 * @see java.lang.Comparable
 * @see java.util.Map
 * 
 * @author 3TUSK & Snownee
 */
public final class ItemDefinition implements Comparable<ItemDefinition>
{

    public static ItemDefinition of(Item item)
    {
        return of(item, 0);
    }

    public static ItemDefinition of(ItemStack stack)
    {
        return of(stack.getItem(), stack.getHasSubtypes() ? stack.getMetadata() : 0);
    }

    public static ItemDefinition of(Block block)
    {
        return of(Item.getItemFromBlock(block));
    }

    public static ItemDefinition of(Item item, int metadata)
    {
        return new ItemDefinition(item, metadata);
    }

    private final Item item;
    private final int metadata;

    public ItemDefinition(Item item, int metadata)
    {
        this.item = item;
        this.metadata = metadata;
    }

    public ItemStack withSize(int size)
    {
        return new ItemStack(item, size, metadata);
    }

    public Item getItem()
    {
        return item;
    }

    public int getMetadata()
    {
        return metadata;
    }

    public ItemStack getItemStack()
    {
        return new ItemStack(item, 1, metadata);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        ItemDefinition that = (ItemDefinition) o;
        return metadata == that.metadata && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode()
    {
        return item.hashCode() * 31 + metadata;
    }

    @Override
    public int compareTo(ItemDefinition o)
    {
        int result = this.item.getRegistryName().compareTo(o.item.getRegistryName());
        return result == 0 ? this.metadata - o.metadata : result;
    }

    @Override
    public String toString()
    {
        return item.getRegistryName() + ":" + metadata;
    }
}
