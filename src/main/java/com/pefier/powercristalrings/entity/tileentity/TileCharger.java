package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.capability.WillpowerProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import javax.annotation.Nullable;


/**
 * Created by New Profile on 22.03.2016.
 */
public class TileCharger extends TileEntity implements ITickable,IInventory{

    private ItemStack[] itemStackArray = new ItemStack[1];


    public TileCharger(){
        super();


    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < itemStackArray.length; ++i)
        {
            if (itemStackArray[i] != null)
            {
                NBTTagCompound nbtTagCompound = new NBTTagCompound();
                nbtTagCompound.setByte("Slot", (byte)i);
                itemStackArray[i].writeToNBT(nbtTagCompound);
                nbttaglist.appendTag(nbtTagCompound);
            }
        }

        compound.setTag("Items", nbttaglist);
        return compound;

    }
    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items",10);
        itemStackArray = new ItemStack[this.getSizeInventory()];

        for (int i = 0 ; i< nbttaglist.tagCount(); ++i){
            NBTTagCompound nbtTagCompound = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbtTagCompound.getByte("Slot");
            if (b0 >= 0 && b0 < itemStackArray.length) {
                itemStackArray[b0] = ItemStack.loadItemStackFromNBT(nbtTagCompound);
            }

        }



    }

    @Override
    public void update() {

        if(this.getStackInSlot(0)!=null){
            if (this.getStackInSlot(0).hasCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null)){

                ItemStack itemStack=this.getStackInSlot(0);
                itemStack.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).rechargeWillpower();

            }

        }



    }

    @Override
    public int getSizeInventory() {
        return itemStackArray.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return itemStackArray[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack stack = getStackInSlot(index);

        if (stack != null) {
            if (stack.stackSize <= count) {
                setInventorySlotContents(index, null);
            } else {
                stack = stack.splitStack(count);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(index, null);
                }

            }
        }
        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        if(itemStackArray[index] != null){
            ItemStack itemStack = itemStackArray[index];
            itemStackArray[index]= null;
            return itemStack;
        }else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        itemStackArray[index] = stack;
        if(stack != null && stack.stackSize > getInventoryStackLimit()){
            stack.stackSize = getInventoryStackLimit();
        }

    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        if(worldObj.getTileEntity(pos) != this){
            return false;
        }else{
            return player.getDistance((double) pos.getX()+0.5D, pos.getY()+0.5D, pos.getZ()+0.5D) <= 64.0D;
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {}

    @Override
    public void closeInventory(EntityPlayer player) {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {

        if(stack.hasCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null)) {
            return true;
        }
        return false;
    }

    @Override
    public int getField(int id) {return 0;}

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for (int i=0; i< itemStackArray.length; i++){
            itemStackArray[i]= null;
        }


    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return new SPacketUpdateTileEntity(this.getPos(),1, nbt);
    }


    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.getNbtCompound());
    }


}
