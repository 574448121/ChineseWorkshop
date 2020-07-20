package cityofskytcd.chineseworkshop.network;

import java.util.function.Supplier;

import cityofskytcd.chineseworkshop.library.Selection;
import cityofskytcd.chineseworkshop.library.Selections;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import snownee.kiwi.network.ClientPacket;

public class ConvertItemPacket extends ClientPacket {
    private int index;

    public ConvertItemPacket(int index) {
        this.index = index;
    }

    public static class Handler extends PacketHandler<ConvertItemPacket> {

        @Override
        public ConvertItemPacket decode(PacketBuffer buf) {
            return new ConvertItemPacket(buf.readInt());
        }

        @Override
        public void encode(ConvertItemPacket pkt, PacketBuffer buf) {
            buf.writeInt(pkt.index);
        }

        @Override
        public void handle(ConvertItemPacket pkt, Supplier<Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayerEntity player = ctx.get().getSender();
                ItemStack held = player.getHeldItemMainhand();
                if (held.isEmpty() || pkt.index < 0) {
                    return;
                }
                Item item = held.getItem();
                Selection selection = Selections.find(item);
                if (selection == null) {
                    return;
                }
                if (selection.matches(item)) {
                    ItemStack stack = new ItemStack(selection.get(pkt.index % selection.size()));
                    stack.setCount(held.getCount());
                    stack.setTag(held.getTag());
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, stack);
                }
            });
            ctx.get().setPacketHandled(true);
        }

    }

}