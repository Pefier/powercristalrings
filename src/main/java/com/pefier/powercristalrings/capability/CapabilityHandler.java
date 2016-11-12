package com.pefier.powercristalrings.capability;

import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Pefier on 10.11.2016.
 */
public class CapabilityHandler {

    public static final ResourceLocation CREEPER_POWER_CAPABILITY = new ResourceLocation(Reference.MOD_ID, "willpower");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if(!(event.getObject() instanceof EntityCreeper)){return;}
        event.addCapability(CREEPER_POWER_CAPABILITY,new CreeperPowerProvider());


    }
}
