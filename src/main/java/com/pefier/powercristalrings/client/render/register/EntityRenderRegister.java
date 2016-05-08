package com.pefier.powercristalrings.client.render.register;

import com.pefier.powercristalrings.client.render.entity.RenderCharger;
import com.pefier.powercristalrings.client.render.entity.RenderCristallForge;
import com.pefier.powercristalrings.client.render.entity.RenderLaser;
import com.pefier.powercristalrings.entity.throwabel.EntityLaser;
import com.pefier.powercristalrings.entity.tileentity.TileCharger;
import com.pefier.powercristalrings.entity.tileentity.TileCristallForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by New Profile on 17.03.2016.
 */
public class EntityRenderRegister {
    public static void preinit(){


        RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, RenderLaser.FACTORY);

        ClientRegistry.bindTileEntitySpecialRenderer(TileCharger.class,new RenderCharger());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCristallForge.class,new RenderCristallForge());
    }
}
