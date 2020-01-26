package cityofskytcd.chineseworkshop.event;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD)
public class LootTableFixer {
    @SubscribeEvent
    public static void onLoad(LootTableLoadEvent event) {
        //System.out.println(event.getName());
    }
}
