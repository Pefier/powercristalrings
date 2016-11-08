package com.pefier.powercristalrings.init;


import com.pefier.powercristalrings.PowerCristalRings;
import com.pefier.powercristalrings.entity.throwabel.EntityCristallShield;
import com.pefier.powercristalrings.entity.throwabel.EntityLaser;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Initializing entitys
 */
public class ModEntitys {

    public static void init(){

        EntityRegistry.registerModEntity(EntityLaser.class,"laser",2, PowerCristalRings.instance,32,1,true);
        EntityRegistry.registerModEntity(EntityCristallShield.class,"cristall_shild",3,PowerCristalRings.instance,32,1,true);

    }
}
