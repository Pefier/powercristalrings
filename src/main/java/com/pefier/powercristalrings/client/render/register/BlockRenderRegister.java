package com.pefier.powercristalrings.client.render.register;


import com.pefier.powercristalrings.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by New Profile on 21.03.2016.
 */
public class BlockRenderRegister {

    public static void registerBlockRenderer() {
        reg(ModBlocks.charger);
        reg(ModBlocks.powerCristallOre);
        reg(ModBlocks.craftingSurface);
        reg(ModBlocks.cristallForge);
    }

    public static void reg(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getUnlocalizedName().substring(5), "inventory"));

    }
}
