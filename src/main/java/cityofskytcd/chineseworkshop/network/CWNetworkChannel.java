package cityofskytcd.chineseworkshop.network;

import cityofskytcd.chineseworkshop.CW;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class CWNetworkChannel
{
    public static final CWNetworkChannel INSTANCE = new CWNetworkChannel();

    private final Object2IntMap<Class<? extends CWPacket>> mapping = new Object2IntArrayMap<>();
    private final Int2ObjectMap<Class<? extends CWPacket>> mappingReverse = new Int2ObjectArrayMap<>();
    private int nextIndex = 0;
    private final FMLEventChannel channel;

    private CWNetworkChannel()
    {
        (channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(CW.MODID)).register(this);
    }

    @SubscribeEvent
    public void onServerPacketIncoming(FMLNetworkEvent.ServerCustomPacketEvent event)
    {
        decodeData(event.getPacket().payload(), ((NetHandlerPlayServer) event.getHandler()).player);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onClientPacketIncoming(FMLNetworkEvent.ClientCustomPacketEvent event)
    {
        decodeData(event.getPacket().payload(), Minecraft.getMinecraft().player);
    }

    public void sendToAll(CWPacket packet)
    {
        channel.sendToAll(new FMLProxyPacket(new PacketBuffer(unpack(packet)), CW.MODID));
    }

    public void sendToAllAround(CWPacket packet, int dim, double x, double y, double z, double range)
    {
        channel.sendToAllAround(
                new FMLProxyPacket(new PacketBuffer(unpack(packet)), CW.MODID),
                new NetworkRegistry.TargetPoint(dim, x, y, z, range));
    }

    public void sendToDimension(CWPacket packet, int dim)
    {
        channel.sendToDimension(new FMLProxyPacket(new PacketBuffer(unpack(packet)), CW.MODID), dim);
    }

    public void sendToPlayer(CWPacket packet, EntityPlayerMP player)
    {
        channel.sendTo(new FMLProxyPacket(new PacketBuffer(unpack(packet)), CW.MODID), player);
    }

    public void sendToServer(CWPacket packet)
    {
        channel.sendToServer(new FMLProxyPacket(new PacketBuffer(unpack(packet)), CW.MODID));
    }

    public void register(Class<? extends CWPacket> klass)
    {
        mapping.put(klass, nextIndex);
        mappingReverse.put(nextIndex, klass);
        nextIndex++;
    }

    private int getPacketIndex(Class<? extends CWPacket> klass)
    {
        return mapping.getInt(klass);
    }

    private CWPacket getByIndex(int index)
    {
        try
        {
            return mappingReverse.get(index).newInstance();
        }
        catch (Exception e)
        {
            CW.logger.catching(e);
            return null;
        }
    }

    private void decodeData(ByteBuf buffer, EntityPlayer player)
    {
        final int index = buffer.readInt();
        CWPacket packet = this.getByIndex(index);
        if (packet == null)
        {
            CW.logger.error("Receiving malformed packet");
            return;
        }
        FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(() ->
        {
            try
            {
                packet.readDataFrom(buffer, player);
            }
            catch (Exception e)
            {
                CW.logger.catching(e);
            }
        });
    }

    private ByteBuf unpack(CWPacket packet)
    {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeInt(this.getPacketIndex(packet.getClass()));
        try
        {
            packet.writeDataTo(buffer);
        }
        catch (Exception e)
        {
            CW.logger.catching(e);
        }
        return buffer;
    }
}
