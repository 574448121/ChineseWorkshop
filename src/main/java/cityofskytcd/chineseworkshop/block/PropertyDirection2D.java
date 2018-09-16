package cityofskytcd.chineseworkshop.block;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import net.minecraft.block.properties.PropertyEnum;

public class PropertyDirection2D extends PropertyEnum<EnumFacing2D>
{

    protected PropertyDirection2D(String name, Collection<EnumFacing2D> values)
    {
        super(name, EnumFacing2D.class, values);
    }

    /**
     * Create a new PropertyDirection with the given name
     */
    public static PropertyDirection2D create(String name)
    {
        return create(name, Predicates.alwaysTrue());
    }

    /**
     * Create a new PropertyDirection with all directions that match the given Predicate
     */
    public static PropertyDirection2D create(String name, Predicate<EnumFacing2D> filter)
    {
        return create(name, Collections2.filter(Lists.newArrayList(EnumFacing2D.values()), filter));
    }

    /**
     * Create a new PropertyDirection for the given direction values
     */
    public static PropertyDirection2D create(String name, Collection<EnumFacing2D> values)
    {
        return new PropertyDirection2D(name, values);
    }

}
