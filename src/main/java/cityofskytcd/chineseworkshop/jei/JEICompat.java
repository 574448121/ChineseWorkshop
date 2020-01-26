package cityofskytcd.chineseworkshop.jei;

import java.util.List;
import java.util.stream.Collectors;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.event.RetextureIngredientEvent;
import cityofskytcd.chineseworkshop.library.Selection;
import cityofskytcd.chineseworkshop.library.Selections;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import snownee.kiwi.Kiwi;

@JeiPlugin
public class JEICompat implements IModPlugin {
    public static final ResourceLocation UID = new ResourceLocation(CW.MODID, CW.MODID);

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SelectionCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        List<Selection> recipes = Selections.SELECTIONS.stream().filter(Selection::show).collect(Collectors.toList());
        registration.addRecipes(recipes, SelectionCategory.UID);

        if (Kiwi.isLoaded(new ResourceLocation(CW.MODID, "retexture"))) {
            NonNullList<ItemStack> ingredients = NonNullList.create();
            MinecraftForge.EVENT_BUS.post(new RetextureIngredientEvent(ingredients));
            if (!ingredients.isEmpty()) {
                registration.addIngredientInfo(ingredients, VanillaTypes.ITEM, "chineseworkshop.gui.jei.ingredient");
            }
        }
    }

}
