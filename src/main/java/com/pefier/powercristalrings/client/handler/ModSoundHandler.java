package com.pefier.powercristalrings.client.handler;


import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 20.04.2016.
 */
public class ModSoundHandler {

    public static SoundEvent laser;

    public static void init(){



        laser = register("laser");


    }

    public static SoundEvent register(String name) {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID + ":" + name);
        SoundEvent event = GameRegistry.register(new SoundEvent(location).setRegistryName(name));
        return event;

    }
}
