package com.pefier.powercristalrings.container;

import com.pefier.powercristalrings.init.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by New Profile on 19.04.2016.
 */
public class SlotYellowCristall extends Slot {
    public SlotYellowCristall(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }
    @Override
    public boolean isItemValid(ItemStack stack) {
        if(stack.getItem()== ModItems.powerCristallUnlocked && stack.getMetadata() == 3){
            return true;
        }else {
            return false;
        }
    }
}
