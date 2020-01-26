package cityofskytcd.chineseworkshop.block;

import java.util.Locale;

import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public enum Direction2 implements IStringSerializable {
    EAST_WEST,
    SOUTH_NORTH;

    @Override
    public String getName() {
        return toString().toLowerCase(Locale.ENGLISH);
    }

    public static Direction2 fromEnumFacing(Direction facing) {
        if (facing == Direction.NORTH || facing == Direction.SOUTH) {
            return Direction2.SOUTH_NORTH;
        }
        return Direction2.EAST_WEST;
    }

    public Direction2 rotate(Rotation rot) {
        return rot.ordinal() % 2 == 0 ? this : this == EAST_WEST ? SOUTH_NORTH : EAST_WEST;
    }

    public Direction2 mirror(Mirror mirror) {
        return this;
    }
}
