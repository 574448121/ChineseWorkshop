package cityofskytcd.chineseworkshop.block;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCWSlab extends BlockSlab
{
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.<EnumType>create("variant", EnumType.class);

    public BlockCWSlab(Material materialIn)
    {
        super(materialIn);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(Blocks.STONE_SLAB);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(Blocks.STONE_SLAB, 1, state.getValue(VARIANT).getMetadata());
    }

    @Override
    public String getTranslationKey(int meta)
    {
        return super.getTranslationKey() + "." + EnumType.byMetadata(meta).getUnlocalizedName();
    }

    @Override
    public boolean isDouble()
    {
        return false;
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return VARIANT;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return EnumType.byMetadata(stack.getMetadata() & 2);
    }

    public static enum EnumType implements IStringSerializable
    {
        ANDESITE(0, MapColor.STONE, "andesite_pavement"), WHITE_GRAY(1, MapColor.QUARTZ, "white_gray_wall");

        private static final EnumType[] META_LOOKUP = new EnumType[values().length];
        private final int meta;
        private final MapColor mapColor;
        private final String name;
        private final String unlocalizedName;

        private EnumType(int meta, MapColor mapColor, String name)
        {
            this(meta, mapColor, name, name);
        }

        private EnumType(int meta, MapColor mapColor, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.mapColor = mapColor;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public MapColor getMapColor()
        {
            return this.mapColor;
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        public static EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            for (EnumType type : values())
            {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }
}
