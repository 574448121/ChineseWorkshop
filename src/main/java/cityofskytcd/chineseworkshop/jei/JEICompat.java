package cityofskytcd.chineseworkshop.jei;

import cityofskytcd.chineseworkshop.CW;
import cityofskytcd.chineseworkshop.library.Selections;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEICompat implements IModPlugin
{
    public static final ResourceLocation UID = new ResourceLocation(CW.MODID, CW.MODID);

    @Override
    public ResourceLocation getPluginUid()
    {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        registration.addRecipeCategories(new SelectionCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        registration.addRecipes(Selections.SELECTIONS, SelectionCategory.UID);
    }

}
