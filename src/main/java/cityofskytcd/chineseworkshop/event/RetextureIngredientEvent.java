package cityofskytcd.chineseworkshop.event;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraftforge.eventbus.api.Event;

public class RetextureIngredientEvent extends Event {
	public NonNullList<ItemStack> stacks;

	public RetextureIngredientEvent(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	public NonNullList<ItemStack> getStacks() {
		return stacks;
	}

	public void add(IItemProvider item) {
		stacks.add(new ItemStack(item));
	}
}
