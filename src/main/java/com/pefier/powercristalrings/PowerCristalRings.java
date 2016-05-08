package com.pefier.powercristalrings;

import com.pefier.powercristalrings.client.gui.GuiHandler;
import com.pefier.powercristalrings.handler.ConfigurationHandler;
import com.pefier.powercristalrings.proxy.CommonProxy;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Mod  Main Class
 *
 *
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME,version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PowerCristalRings {

    @Mod.Instance(Reference.MOD_ID)
    public static PowerCristalRings instance;


    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS , serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        proxy.preInit(e);
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        NetworkRegistry.INSTANCE.registerGuiHandler(instance,new GuiHandler());








    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init(e);

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){
        proxy.postInit(e);

    }


}
