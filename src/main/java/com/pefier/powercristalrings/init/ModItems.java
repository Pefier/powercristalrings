package com.pefier.powercristalrings.init;

import com.pefier.powercristalrings.item.*;
import net.minecraft.item.Item;

/**
 * Created by New Profile on 07.03.2016.
 */
public class ModItems {


    public static Item ringGreenLantern;
    public static Item powerCristall;
    public static Item powerCristallUnlocked;


    public static void preinit(){

        //Normal Items


        ringGreenLantern = new ItemRingGreenLanter();
        powerCristall = new ItemPowerCristall();
        powerCristallUnlocked = new ItemPowerCristallUnlocked();







    }
}
