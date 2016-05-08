package com.pefier.powercristalrings.proxy;

import com.pefier.powercristalrings.client.handler.ModSoundHandler;
import com.pefier.powercristalrings.client.render.register.BlockRenderRegister;
import com.pefier.powercristalrings.client.render.register.EntityRenderRegister;
import com.pefier.powercristalrings.client.render.register.ItemRenderRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by New Profile on 08.05.2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ItemRenderRegister.preInit();
        EntityRenderRegister.preinit();
        ModSoundHandler.init();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ItemRenderRegister.registerItemRenderer();
        BlockRenderRegister.registerBlockRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
