package cityofskytcd.chineseworkshop.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public interface CWPacket
{
    void writeDataTo(ByteBuf buffer);

    void readDataFrom(ByteBuf buffer, EntityPlayer player);
}
