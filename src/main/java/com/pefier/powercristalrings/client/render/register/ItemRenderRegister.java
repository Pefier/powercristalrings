package com.pefier.powercristalrings.client.render.register;



import com.pefier.powercristalrings.init.ModItems;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by New Profile on 16.03.2016.
 */
public class ItemRenderRegister {


    public static void preInit() {
        ModelBakery.registerItemVariants(ModItems.ringGreenLantern,new ModelResourceLocation(Reference.MOD_ID +":RingLantern0","inventory"),new ModelResourceLocation(Reference.MOD_ID +":RingLantern1","inventory"));
        ModelBakery.registerItemVariants(ModItems.powerCristall,new ModelResourceLocation(Reference.MOD_ID +":PowerCristallRed","inventory"),new ModelResourceLocation(Reference.MOD_ID +":PowerCristallBlue","inventory"),new ModelResourceLocation(Reference.MOD_ID +":PowerCristallGreen","inventory"),new ModelResourceLocation(Reference.MOD_ID +":PowerCristallYellow","inventory"));
        ModelBakery.registerItemVariants(ModItems.powerCristallUnlocked,new ModelResourceLocation(Reference.MOD_ID +":PowerCristallUnlockedRed","inventory"),new ModelResourceLocation(Reference.MOD_ID +":PowerCristallUnlockedBlue","inventory"),new ModelResourceLocation(Reference.MOD_ID +":PowerCristallUnlockedGreen","inventory"),new ModelResourceLocation(Reference.MOD_ID +":PowerCristallUnlockedYellow","inventory"));

    }

    public static void registerItemRenderer() {

        //has MetaData

        reg(ModItems.ringGreenLantern,0,"RingLantern0");
        reg(ModItems.ringGreenLantern,1,"RingLantern1");
        reg(ModItems.powerCristall,0,"PowerCristallRed");
        reg(ModItems.powerCristall,1,"PowerCristallBlue");
        reg(ModItems.powerCristall,2,"PowerCristallGreen");
        reg(ModItems.powerCristall,3,"PowerCristallYellow");
        reg(ModItems.powerCristallUnlocked,0,"PowerCristallUnlockedRed");
        reg(ModItems.powerCristallUnlocked,1,"PowerCristallUnlockedBlue");
        reg(ModItems.powerCristallUnlocked,2,"PowerCristallUnlockedGreen");
        reg(ModItems.powerCristallUnlocked,3,"PowerCristallUnlockedYellow");
        // no metadata
        reg(ModItems.cristallPearl);



    }



    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getUnlocalizedName().substring(5), "inventory"));

    }

    public static void reg(Item item, int meta, String file) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
    }
}

