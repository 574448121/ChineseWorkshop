package cityofskytcd.chineseworkshop.block;

import java.util.Locale;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public enum EnumFacing2D implements IStringSerializable
{
    EAST_WEST, SOUTH_NORTH;

    @Override
    public String getName()
    {
        return toString().toLowerCase(Locale.ENGLISH);
    }

    public static EnumFacing2D fromEnumFacing(EnumFacing facing)
    {
        if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH)
        {
            return EnumFacing2D.SOUTH_NORTH;
        }
        return EnumFacing2D.EAST_WEST;
    }

    public EnumFacing2D rotate(Rotation rot)
    {
        return rot.ordinal() % 2 == 0 ? this : this == EAST_WEST ? SOUTH_NORTH : EAST_WEST;
    }

    public EnumFacing2D mirror(Mirror mirror)
    {
        return mirror == Mirror.NONE ? this : this == EAST_WEST ? SOUTH_NORTH : EAST_WEST;
    }
}
