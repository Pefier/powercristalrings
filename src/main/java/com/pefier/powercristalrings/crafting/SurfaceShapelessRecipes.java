package com.pefier.powercristalrings.crafting;

import com.google.common.collect.Lists;
import com.pefier.powercristalrings.capability.WillpowerProvider;
import com.pefier.powercristalrings.init.ModItems;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by New Profile on 11.04.2016.
 */


public class SurfaceShapelessRecipes implements IRecipe {
    private int maxcharge=12000;
    private int rechargerate=100;
    private int dmgreduction=0;
    private int dmgIncrease=0;
    private int minigSpeed=0;
    private double attackspeed=0;

    private final ItemStack recipeOutput;
    private final List<ItemStack> recipeItems;

    public SurfaceShapelessRecipes(ItemStack recipeOutput, List<ItemStack> recipeItems) {
        this.recipeOutput = recipeOutput;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        List<ItemStack> list = Lists.newArrayList(this.recipeItems);

        for(int i = 0;i<inv.getHeight();i++){

            for (int j = 0;j< inv.getWidth();j++){

                ItemStack itemStack = inv.getStackInRowAndColumn(j,i);

                if(itemStack != null){

                    boolean flag = false;

                    for(ItemStack itemStack1 : list){
                        if(itemStack.getItem() == itemStack1.getItem()){
                            flag =true;
                            list.remove(itemStack1);
                            break;
                        }
                    }
                    if(!flag){
                        return false;
                    }

                }
            }

        }

        return  list.isEmpty();
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        for(int i = 0;i<inv.getHeight();i++){
            for (int j = 0;j< inv.getWidth();j++){
                ItemStack itemStack = inv.getStackInRowAndColumn(j,i);
                if(itemStack!= null) {
                    if(itemStack.getItem() == ModItems.powerCristallUnlocked) {
                            /** Cristal Color Red*/
                        if (itemStack.getMetadata() == 0) {
                            maxcharge -= 300;
                            dmgIncrease += 2;
                            /** Cristal Color Blue*/
                        } else if (itemStack.getMetadata() == 1) {
                            maxcharge += 600;
                            /** Cristal Color Green*/
                        } else if (itemStack.getMetadata() == 2) {
                            maxcharge -=300;
                            dmgreduction += 15;
                            attackspeed += 0.75D;
                            rechargerate -= 20;
                            /** Cristal Color Yellow*/
                        } else if (itemStack.getMetadata() == 3) {
                            maxcharge -= 450;
                            rechargerate += 20;
                            minigSpeed += 9;

                        }
                    }
                }
            }
        }
        ItemStack output =initRingStatts(recipeOutput);
        maxcharge=12000;
        rechargerate=100;
        dmgreduction=0;
        dmgIncrease=0;
        minigSpeed=0;
        attackspeed=0;
        return output.copy();
    }

    @Override
    public int getRecipeSize() {
        return this.recipeItems.size();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];

        for (int i = 0; i < aitemstack.length; ++i)
        {
            ItemStack itemstack = inv.getStackInSlot(i);
            aitemstack[i] = net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack);
        }

        return aitemstack;

    }

    private ItemStack initRingStatts(ItemStack stack){
        ItemStack stack1 = stack;

        stack1.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setStatus(true);
        stack1.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setMaxWillpower(maxcharge);
        stack1.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setRechargerate(rechargerate);
        stack1.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setDmgIncrease(dmgIncrease);
        stack1.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setDmgReduction(dmgreduction);
        stack1.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setMiningSpeed(minigSpeed);
        stack1.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setAttackSpeed(attackspeed);

        return stack1;
    }
}
