package cityofskytcd.chineseworkshop.library;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EmptyEntityRenderer<T extends Entity> extends EntityRenderer<T> {

    public EmptyEntityRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(T entity) {
        return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
    }

}