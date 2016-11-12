package com.pefier.powercristalrings.init;


import com.pefier.powercristalrings.block.*;
import net.minecraft.block.Block;

/**
 * All Mod Blocks that my mod adds
 */
public class ModBlocks {

    public static Block charger;
    public static Block powerCristallOre;
    public static Block craftingSurface;
    public static Block cristallForge;
    public static Block oreSpawner;
    public static Block cable;
    public static Block solarGenerator;
    public static Block creeperGenerator;
    public static Block testCable;

    public static void preinit(){

        charger = new BlockCharger();
        powerCristallOre = new BlockPowerCristallOre();
        craftingSurface = new BlockCraftingSurface();
        cristallForge = new BlockCristallForge();
        oreSpawner = new BlockOreSpwaner();
        cable = new BlockCable();
        solarGenerator = new BlockSolarGenerator();
        creeperGenerator = new BlockCreeperGenerator();
        testCable = new BlockPowerCable();
    }
}
