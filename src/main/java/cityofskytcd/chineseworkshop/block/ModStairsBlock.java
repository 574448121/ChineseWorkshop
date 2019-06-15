package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class ModStairsBlock extends StairsBlock
{

    public ModStairsBlock(BlockState state)
    {
        super(state, Block.Properties.from(state.getBlock()));
    }

}
