package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.power.IPowerProvider;
import com.pefier.powercristalrings.power.IPowerReceiver;
import com.pefier.powercristalrings.power.PowerStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;


/**
 * Created by Pefier on 09.11.2016.
 */
public abstract class TileGenericConsumer extends TileEntity implements IPowerReceiver {

    protected PowerStorage storage;
    private int capacity;

    public TileGenericConsumer(int capacity) {
        this.storage = new PowerStorage(capacity);
        this.capacity = capacity;

    }

    protected void inputPower(int amount){
        for(EnumFacing direction: EnumFacing.values()){
            TileEntity tileEntity = worldObj.getTileEntity(this.getPos().offset(direction));
                if(tileEntity instanceof IPowerProvider){

                    int PowerICouldget = ((IPowerProvider)tileEntity).extractPower(direction.getOpposite(),amount,true);
                    if (PowerICouldget < storage.getMaxReceive()){
                        receivePower(direction,((IPowerProvider)tileEntity).extractPower(direction.getOpposite(),amount,false),false);



                    }


                }


        }


    }

    protected boolean canConsumePower(int amount){
        if(amount < storage.getPowerStored()){
            return false;
        }else{
            return true;
        }


    }

    protected void consumePower(int amount){
        if(canConsumePower(amount)){
            storage.extractPower(amount,false);
        }


    }




    @Override
    public int receivePower(EnumFacing side, int maxReceive, boolean simulate) {
        return storage.receivePower(maxReceive,simulate);
    }

    @Override
    public int getPowerStored(EnumFacing from) {
        return storage.getPowerStored();
    }

    @Override
    public int getCapacity(EnumFacing from) {
        return storage.getCapacity();
    }

    @Override
    public boolean canConnectPower(EnumFacing from) {
        return true;
    }
}
