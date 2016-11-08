package com.pefier.powercristalrings.handler;


import com.pefier.powercristalrings.capability.WillpowerProvider;
import com.pefier.powercristalrings.init.ModItems;
import com.pefier.powercristalrings.reference.Name;
import com.pefier.powercristalrings.utility.InventoryHelper;
import com.pefier.powercristalrings.utility.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by New Profile on 13.04.2016.
 */
public class RingHandler {

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event){
        if(!InventoryHelper.hasItem(event.getEntityPlayer(), ModItems.ringGreenLantern)){
            return;

        }

        if(InventoryHelper.getItemStackinInventory(event.getEntityPlayer(), ModItems.ringGreenLantern).getMetadata() !=1){
            return;
        }
        if (event.getEntityPlayer().inventory.getCurrentItem() == null){
            return;

        }
        if(!(event.getEntityPlayer().inventory.getCurrentItem().getItem() instanceof ItemPickaxe)){
            return;
        }

        if(InventoryHelper.getItemStackinInventory(event.getEntityPlayer(),ModItems.ringGreenLantern).getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getMiningSpeed()<=0){
            return;
        }
        if(event.getOriginalSpeed() >= InventoryHelper.getItemStackinInventory(event.getEntityPlayer(),ModItems.ringGreenLantern).getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getMiningSpeed()){
            return;
        }

        System.out.println("Old Seed: "+event.getOriginalSpeed());
        event.setNewSpeed((float) InventoryHelper.getItemStackinInventory(event.getEntityPlayer(),ModItems.ringGreenLantern).getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getMiningSpeed());
        System.out.println("New Speed"+event.getNewSpeed()+"Old Speed"+event.getOriginalSpeed());


    }

    @SubscribeEvent
    public void entityisAttack(LivingHurtEvent event){

        if(!(event.getEntityLiving() instanceof EntityPlayer)){
            return;
        }
        if(!InventoryHelper.hasItem((EntityPlayer) event.getEntityLiving(),ModItems.ringGreenLantern)){
            return;
        }
        if(InventoryHelper.getItemStackinInventory((EntityPlayer) event.getEntityLiving() , ModItems.ringGreenLantern).getMetadata() !=1){
            return;
        }

        if(!InventoryHelper.getItemStackinInventory((EntityPlayer) event.getEntityLiving() ,ModItems.ringGreenLantern).hasTagCompound()){
            return;
        }

        if(InventoryHelper.getItemStackinInventory((EntityPlayer)event.getEntityLiving() ,ModItems.ringGreenLantern).getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getDmgReduction()<=0){
            return;
        }

        float dmgReduction =(float)  InventoryHelper.getItemStackinInventory((EntityPlayer)event.getEntityLiving() ,ModItems.ringGreenLantern).getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getDmgReduction()/100f;

        System.out.println("damage bevor reduced " +event.getAmount());

        float x =(dmgReduction * event.getAmount());

        InventoryHelper.getItemStackinInventory((EntityPlayer)event.getEntityLiving(),ModItems.ringGreenLantern).getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).consumeWillpower((int)event.getAmount()*2);
        event.setAmount(event.getAmount()-x);
        System.out.println("damage taken "+ event.getAmount());
    }




}
