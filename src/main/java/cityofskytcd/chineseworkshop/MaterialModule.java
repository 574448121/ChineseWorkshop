package cityofskytcd.chineseworkshop;

import snownee.kiwi.AbstractModule;
import snownee.kiwi.KiwiModule;
import snownee.kiwi.item.ModItem;

@KiwiModule(modid = CW.MODID, name = "materials")
@KiwiModule.Group("misc")
public class MaterialModule extends AbstractModule {
    public static final ModItem BLACK_CLAY = new ModItem(itemProp());

    public static final ModItem BLACK_BRICK = new ModItem(itemProp());

    public static final ModItem YELLOW_CLAY = new ModItem(itemProp());

    public static final ModItem YELLOW_BRICK = new ModItem(itemProp());
}
