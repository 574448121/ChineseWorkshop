package cityofskytcd.chineseworkshop.jei;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import cityofskytcd.chineseworkshop.BlockModule;
import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.library.Selection;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SelectionCategory implements IRecipeCategory<Selection>
{
    public static final ResourceLocation UID = new ResourceLocation(CW.MODID, "selection");
    public static final int recipeWidth = 160;
    public static final int recipeHeight = 125;
    private final IDrawable icon;
    private final IDrawable background;
    private final IDrawable slotBackground;
    private final String localizedName;

    public SelectionCategory(IGuiHelper guiHelper)
    {
        icon = guiHelper.createDrawableIngredient(new ItemStack(BlockModule.LOGO));
        background = guiHelper.createBlankDrawable(recipeWidth, recipeHeight);
        slotBackground = guiHelper.getSlotDrawable();
        localizedName = I18n.format(CW.MODID + ".gui.jei.selection");
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public IDrawable getIcon()
    {
        return icon;
    }

    @Override
    public Class getRecipeClass()
    {
        return Selection.class;
    }

    @Override
    public String getTitle()
    {
        return localizedName;
    }

    @Override
    public ResourceLocation getUid()
    {
        return UID;
    }

    @Override
    public void setIngredients(Selection selection, IIngredients ingredients)
    {
        ingredients.setInput(VanillaTypes.ITEM, new ItemStack(selection.getMainItem()));
        List<Item> items = Lists.newLinkedList(selection.getSubItems());
        items.add(selection.getMainItem());
        List<ItemStack> outputs = items.stream().map(ItemStack::new).collect(Collectors.toList());
        ingredients.setOutputs(VanillaTypes.ITEM, outputs);
    }

    @Override
    public void setRecipe(IRecipeLayout layout, Selection selection, IIngredients ingredients)
    {
        IGuiItemStackGroup guiItemStacks = layout.getItemStacks();

        int count = ingredients.getOutputs(VanillaTypes.ITEM).size();
        int h = 36 + 18 * (count / 6 + 1);

        int x = (recipeWidth - 18) / 2;
        int y = (recipeHeight - h) / 2;
        guiItemStacks.init(0, true, x, y);
        guiItemStacks.setBackground(0, slotBackground);

        int j = 0;
        y += 36;
        while (count > 0)
        {
            x = (recipeWidth - 6 * 18) / 2;
            for (int i = 0; i < 6; i++)
            {
                ++j;
                guiItemStacks.init(j, false, x, y);
                guiItemStacks.setBackground(j, slotBackground);
                x += 18;
                --count;
            }
            y += 18;
        }

        guiItemStacks.set(ingredients);
    }

}
