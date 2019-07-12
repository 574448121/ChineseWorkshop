package cityofskytcd.chineseworkshop.library;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Selection
{
    private final Item mainItem;
    private final List<Item> subItems;

    public Selection(Item mainItem, List<Item> subItems)
    {
        this.mainItem = mainItem;
        this.subItems = subItems;
    }

    public boolean matches(Item item)
    {
        return mainItem == item || subItems.contains(item);
    }

    public Item getMainItem()
    {
        return mainItem;
    }

    public List<Item> getSubItems()
    {
        return subItems;
    }

    public int size()
    {
        return subItems.size() + 1;
    }

    public Item get(int i)
    {
        if (i == 0)
        {
            return mainItem;
        }
        if (i < size())
        {
            return subItems.get(i - 1);
        }
        return Items.AIR;
    }
}
