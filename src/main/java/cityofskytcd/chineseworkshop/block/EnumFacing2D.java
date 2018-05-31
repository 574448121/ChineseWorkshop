package cityofskytcd.chineseworkshop.block;

import java.util.Locale;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

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
        else
        {
            return EnumFacing2D.EAST_WEST;
        }
    }
}
