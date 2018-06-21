package cityofskytcd.chineseworkshop.event;

import cityofskytcd.chineseworkshop.CW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class NoteblockHandler
{
    private static final SoundEvent SOUND_TEST = new SoundEvent(new ResourceLocation(CW.MODID, "block.note.test"));

    @SubscribeEvent
    public static void onNoteBlockPlay(NoteBlockEvent.Play event)
    {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        if (world.getBlockState(pos.down()).getBlock().getRegistryName().getResourceDomain().equals(CW.MODID))
        {
            int note = event.getVanillaNoteId();
            float f = (float) Math.pow(2.0D, (note - 12) / 12.0D);
            world.playSound(
                    (EntityPlayer) null,
                    pos,
                    SoundEvents.ENTITY_ENDERMEN_TELEPORT,
                    SoundCategory.RECORDS,
                    3.0F,
                    f);
            world.spawnParticle(
                    EnumParticleTypes.NOTE,
                    pos.getX() + 0.5D,
                    pos.getY() + 1.2D,
                    pos.getZ() + 0.5D,
                    note / 24.0D,
                    0.0D,
                    0.0D);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onSoundEventRegister(RegistryEvent.Register<SoundEvent> event)
    {
        event.getRegistry().register(SOUND_TEST.setRegistryName(SOUND_TEST.getSoundName()));
    }
}
