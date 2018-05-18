/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.block;

import net.minecraft.block.material.Material;

/**
 * 灯类
 */
public class BlockCWLight extends BlockCWT
{
    public BlockCWLight(String name, Material materialIn, float hardness, float lightLevel)
    {
        super(name, materialIn, hardness);
        setLightLevel(lightLevel);
    }
}
