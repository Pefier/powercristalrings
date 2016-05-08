package com.pefier.powercristalrings.container;


import com.pefier.powercristalrings.init.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by New Profile on 05.04.2016.
 */
public class SlotRedCristall extends Slot {
    public SlotRedCristall(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if(stack.getItem()== ModItems.powerCristallUnlocked && stack.getMetadata() == 0){
            return true;
        }else {
            return false;
        }
    }

}
