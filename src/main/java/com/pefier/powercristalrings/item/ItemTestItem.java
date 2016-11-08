package com.pefier.powercristalrings.item;

import com.pefier.powercristalrings.entity.throwabel.EntityCristallShield;
import com.pefier.powercristalrings.reference.Reference;
import com.pefier.powercristalrings.utility.CustomTeleporter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 31.08.2016.
 */

public class ItemTestItem extends ItemPCR{

    private static final String name = "testItem";
    private double x=0,y=100,z=0;
    private int d=0;


    public ItemTestItem(){
        super();
        setUnlocalizedName(name);
        setMaxStackSize(1);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);


    }



    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {


        if (!worldIn.isRemote) {
            //Old code with teleport and shield testing

            //EntityCristallShield projektile = new EntityCristallShield(worldIn, playerIn);
            //projektile.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.3F, 0.0F);
            //worldIn.spawnEntityInWorld(projektile);


            /*
            if(playerIn.isSneaking()) {

                CustomTeleporter.teleportToDimension( playerIn, d, x, y, z);


            }else{
                x = playerIn.getPosition().getX();
                y = playerIn.getPosition().getY()+1;
                z = playerIn.getPosition().getZ();
                d=playerIn.worldObj.provider.getDimension();
                System.out.println("Dimension: "+d+" X: "+x+" Y: "+y+" Z: "+z);
            }
            */


        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS,itemStackIn);
    }

}
