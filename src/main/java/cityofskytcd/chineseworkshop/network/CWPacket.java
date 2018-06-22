package cityofskytcd.chineseworkshop.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface CWPacket
{
    void writeDataTo(ByteBuf buffer);

    @SideOnly(Side.CLIENT)
    void readDataFrom(ByteBuf buffer, EntityPlayer player);
}
