package com.pefier.powercristalrings.proxy;

import com.pefier.powercristalrings.capability.IWillpower;
import com.pefier.powercristalrings.capability.Willpower;
import com.pefier.powercristalrings.capability.WillpowerStorage;
import com.pefier.powercristalrings.client.handler.OverlayHandler;
import com.pefier.powercristalrings.crafting.VanillaRecepies;
import com.pefier.powercristalrings.handler.ConfigurationHandler;
import com.pefier.powercristalrings.handler.RingHandler;
import com.pefier.powercristalrings.handler.WorldGenerator;
import com.pefier.powercristalrings.init.ModBlocks;
import com.pefier.powercristalrings.init.ModEntitys;
import com.pefier.powercristalrings.init.ModItems;
import com.pefier.powercristalrings.utility.OreDic;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 08.05.2016.
 */
public abstract class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {

        CapabilityManager.INSTANCE.register(IWillpower.class,new WillpowerStorage(), Willpower.class);
        ModItems.preinit();
        ModBlocks.preinit();
        ModEntitys.init();

        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(new OverlayHandler());
        MinecraftForge.EVENT_BUS.register(new RingHandler());

    }

    public void init(FMLInitializationEvent e) {

        GameRegistry.registerWorldGenerator(new WorldGenerator(),0);
        VanillaRecepies.init();


    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
