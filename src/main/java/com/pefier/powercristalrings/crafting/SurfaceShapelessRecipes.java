package com.pefier.powercristalrings.crafting;

import com.google.common.collect.Lists;
import com.pefier.powercristalrings.init.ModItems;
import com.pefier.powercristalrings.reference.Name;
import com.pefier.powercristalrings.utility.NBTHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
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
    private int jumphight=0;
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
                        if (itemStack.getMetadata() == 0) {
                            maxcharge -= 300;
                            dmgIncrease += 2;

                        } else if (itemStack.getMetadata() == 1) {
                            maxcharge += 600;

                        } else if (itemStack.getMetadata() == 2) {
                            maxcharge -=300;
                            dmgreduction += 15;
                            attackspeed += 0.75D;
                            rechargerate -= 20;
                        } else if (itemStack.getMetadata() == 3) {
                            maxcharge -= 450;
                            rechargerate += 20;
                            minigSpeed += 9;
                        }
                    }
                }
            }
        }
        ItemStack output =initNBTonRing(recipeOutput);
        maxcharge=12000;
        rechargerate=10;
        dmgreduction=0;
        dmgIncrease=0;
        minigSpeed=0;
        jumphight=0;
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

    private ItemStack initNBTonRing(ItemStack stack){
        ItemStack stack1 = stack;
        if(!stack1.hasTagCompound()){
            NBTTagCompound data = new NBTTagCompound();
            data.setBoolean(Name.NBTKey.TAG_STATUS,true);
            data.setInteger(Name.NBTKey.TAG_CHARGE,0);
            data.setInteger(Name.NBTKey.TAG_MAX_CHARGE,maxcharge);
            data.setInteger(Name.NBTKey.TAG_RECHARGERATE,rechargerate);
            data.setInteger(Name.NBTKey.TAG_DMGINCREASE,dmgIncrease);
            data.setInteger(Name.NBTKey.TAG_DMGREDUKTION,dmgreduction);
            data.setInteger(Name.NBTKey.TAG_MININGSPEED,minigSpeed);
            data.setInteger(Name.NBTKey.TAG_JUMPHIGHT,jumphight);
            data.setDouble(Name.NBTKey.TAG_ATTACKSPEED,attackspeed);
            stack1.setTagInfo(Name.NBTKey.TAG_RINGDATA,data);
        }else{
            NBTHelper.setNBTTagBoolean(stack1,Name.NBTKey.TAG_STATUS,Name.NBTKey.TAG_RINGDATA,true);
            NBTHelper.setNBTTagInt(stack1,Name.NBTKey.TAG_CHARGE,Name.NBTKey.TAG_RINGDATA,100);
            NBTHelper.setNBTTagInt(stack1,Name.NBTKey.TAG_MAX_CHARGE,Name.NBTKey.TAG_RINGDATA,maxcharge);
            NBTHelper.setNBTTagInt(stack1,Name.NBTKey.TAG_RECHARGERATE,Name.NBTKey.TAG_RINGDATA,rechargerate);
            NBTHelper.setNBTTagInt(stack1,Name.NBTKey.TAG_DMGINCREASE,Name.NBTKey.TAG_RINGDATA,dmgIncrease);
            NBTHelper.setNBTTagInt(stack1,Name.NBTKey.TAG_DMGREDUKTION,Name.NBTKey.TAG_RINGDATA,dmgreduction);
            NBTHelper.setNBTTagInt(stack1,Name.NBTKey.TAG_MININGSPEED,Name.NBTKey.TAG_RINGDATA,minigSpeed);
            NBTHelper.setNBTTagInt(stack1,Name.NBTKey.TAG_JUMPHIGHT,Name.NBTKey.TAG_RINGDATA,jumphight);
            NBTHelper.setNBTTagDouble(stack1,Name.NBTKey.TAG_ATTACKSPEED,Name.NBTKey.TAG_RINGDATA,attackspeed);
        }
        return stack1;
    }
}
