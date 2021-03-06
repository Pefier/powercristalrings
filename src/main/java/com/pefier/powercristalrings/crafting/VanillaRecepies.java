package com.pefier.powercristalrings.crafting;

import com.pefier.powercristalrings.init.ModBlocks;
import com.pefier.powercristalrings.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by New Profile on 08.05.2016.
 */
public class VanillaRecepies {

    public static void init(){
        GameRegistry.addRecipe( new ItemStack(ModBlocks.cristallForge) ,"ggg","cfc","ooo",'o', Blocks.OBSIDIAN,'g',Blocks.GLASS,'c', new ItemStack(ModItems.powerCristall,1, OreDictionary.WILDCARD_VALUE), 'f',Blocks.FURNACE);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.charger),"o o","oco","ooo", 'o',Blocks.OBSIDIAN,'c',new ItemStack(ModItems.powerCristallUnlocked,1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.craftingSurface),"oco","ctc","oco",'o',Blocks.OBSIDIAN,'c',new ItemStack(ModItems.powerCristallUnlocked,1, OreDictionary.WILDCARD_VALUE),'t',Blocks.CRAFTING_TABLE);
        GameRegistry.addRecipe(new ItemStack(ModItems.cristallPearl),"cec","epe","cec",'c',new ItemStack(ModItems.powerCristallUnlocked,1, OreDictionary.WILDCARD_VALUE),'e', Items.ENDER_EYE,'p',Items.ENDER_PEARL);

    }
}
