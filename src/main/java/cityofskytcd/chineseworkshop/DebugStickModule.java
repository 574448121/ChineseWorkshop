package cityofskytcd.chineseworkshop;

import cityofskytcd.chineseworkshop.item.SafeDebugStickItem;
import snownee.kiwi.AbstractModule;
import snownee.kiwi.KiwiModule;

@KiwiModule(modid = CW.MODID, name = "debug_stick")
@KiwiModule.Group("tools")
@KiwiModule.Optional
public class DebugStickModule extends AbstractModule {
    public static final SafeDebugStickItem SAFE_DEBUG_STICK = new SafeDebugStickItem(itemProp());
}
