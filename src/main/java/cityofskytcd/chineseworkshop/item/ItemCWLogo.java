/**
 * This file is part of Chinese Workshop
 * (https://github.com/574448121/ChineseWorkshop)
 * 
 * Chinese Workshop is an Open-Source project under MIT License
 * (https://opensource.org/licenses/MIT)
 */

package cityofskytcd.chineseworkshop.item;

import cityofskytcd.chineseworkshop.CW;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = CW.MODID)
public class ItemCWLogo extends ItemCW
{
    public ItemCWLogo(String id)
    {
        super(id, null);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return super.getItemStackDisplayName(stack) + ": " + ItemCWLogo.getMode(stack);
    }

    public static void setMode(ItemStack stack, String mode)
    {
        NBTTagCompound nbt = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
        nbt.setString("mode", mode);
        stack.setTagCompound(nbt);
    }

    public static String getMode(ItemStack stack)
    {
        if (stack.hasTagCompound())
        {
            String mode = stack.getTagCompound().getString("mode");
            if (mode != null)
            {
                return mode;
            }
        }
        return "Rotate";
    }

    @SubscribeEvent
    public static void onRightClickItem(RightClickItem event)
    {
        ItemStack stack = event.getItemStack();
        if (stack.getItem() == CWItems.LOGO)
        {
            if (event.getSide() == Side.SERVER)
            {
                World worldIn = event.getWorld();
                EntityPlayer playerIn = event.getEntityPlayer();
                RayTraceResult raytraceresult = rayTrace2(worldIn, playerIn);

                if (raytraceresult == null)
                {
                    if (playerIn.isSneaking())
                    {
                        switch (getMode(stack))
                        {
                        case "Mirror":
                            ItemCWLogo.setMode(stack, "Rotate");
                            break;

                        default:
                            ItemCWLogo.setMode(stack, "Mirror");
                            break;
                        }
                    }
                    else
                    {
                        event.setCanceled(true);
                        event.setCancellationResult(EnumActionResult.FAIL);
                        return;
                    }
                }
                else
                {
                    BlockPos pos = raytraceresult.getBlockPos();
                    IBlockState state = worldIn.getBlockState(pos);
                    switch (getMode(stack))
                    {
                    case "Mirror":
                        worldIn.setBlockState(
                                pos,
                                state.withMirror(playerIn.isSneaking() ? Mirror.LEFT_RIGHT : Mirror.FRONT_BACK));
                        break;

                    default:
                        CW.log(state.getBlock());
                        worldIn.setBlockState(
                                pos,
                                state.withRotation(
                                        playerIn.isSneaking() ? Rotation.COUNTERCLOCKWISE_90 : Rotation.CLOCKWISE_90));
                        break;
                    }
                }
            }

            event.setCanceled(true);
            event.setCancellationResult(EnumActionResult.SUCCESS);
        }
    }

    @SubscribeEvent
    public static void onRightClickBlock(RightClickBlock event)
    {
        if (event.getItemStack().getItem() == CWItems.LOGO)
        {
            event.setCanceled(true);
        }
    }

    public static RayTraceResult rayTrace2(World worldIn, EntityPlayer playerIn)
    {
        float f = playerIn.rotationPitch;
        float f1 = playerIn.rotationYaw;
        double d0 = playerIn.posX;
        double d1 = playerIn.posY + playerIn.getEyeHeight();
        double d2 = playerIn.posZ;
        Vec3d vec3d = new Vec3d(d0, d1, d2);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - (float) Math.PI);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - (float) Math.PI);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d3 = playerIn.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue();
        Vec3d vec3d1 = vec3d.addVector(f6 * d3, f5 * d3, f7 * d3);
        return worldIn.rayTraceBlocks(vec3d, vec3d1, false, false, false);
    }
}
