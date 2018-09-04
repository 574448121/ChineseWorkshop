package cityofskytcd.chineseworkshop.network;

import com.google.common.collect.ImmutableList;

import cityofskytcd.chineseworkshop.library.ItemDefinition;
import cityofskytcd.chineseworkshop.library.Selections;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WheelMovePacket implements CWPacket
{
    private int index;

    public WheelMovePacket()
    {
    }

    public WheelMovePacket(int index)
    {
        this.index = index;
    }

    @Override
    public void writeDataTo(ByteBuf buffer)
    {
        buffer.writeInt(index);
    }

    @Override
    public void readDataFrom(ByteBuf buffer)
    {
        index = buffer.readInt();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleClient(EntityPlayerSP player)
    {
    }

    @Override
    public void handleServer(EntityPlayerMP player)
    {
        ItemStack held = player.getHeldItemMainhand();
        if (held.isEmpty() || index < 0)
        {
            return;
        }
        ImmutableList<ItemDefinition> selection = Selections.findSelection(held);
        if (selection == null)
        {
            return;
        }
        ItemDefinition definition = ItemDefinition.of(held);
        if (selection.contains(definition))
        {
            ItemStack stack = selection.get(index % selection.size()).getItemStack();
            stack.setCount(held.getCount());
            stack.setTagCompound(held.getTagCompound());
            player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, stack);
        }
    }

}
