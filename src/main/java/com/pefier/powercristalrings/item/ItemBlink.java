package com.pefier.powercristalrings.item;

import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 29.10.2016.
 */
public class ItemBlink extends ItemPCR{

    private final String name = "blink";

    public ItemBlink() {
        super();
        this.setRegistryName(Reference.MOD_ID,name);
        setUnlocalizedName(name);
        GameRegistry.register(this);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {


        playerIn.getCooldownTracker().setCooldown(this,60);
        if (!worldIn.isRemote) {
            if (playerIn instanceof EntityPlayerMP) {
                EntityPlayerMP playerMP = (EntityPlayerMP) playerIn;
                if (playerMP.connection.getNetworkManager().isChannelOpen() && playerMP.worldObj == worldIn) {
                    double distance = 64.0d;



                    BlockPos pos = playerMP.rayTrace(distance, 1f).getBlockPos();


                    System.out.println("X " + pos.getX() + " Y " + pos.getY() + " Z " + pos.getY());
                    net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(playerMP, pos.getX(), pos.getY()+1, pos.getZ(), 0.0f);
                    if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) {
                        playerMP.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        playerMP.fallDistance = 0.0F;


                    }

                }


            }

        }

        return new ActionResult<ItemStack>(EnumActionResult.PASS,itemStackIn);

    }
}
