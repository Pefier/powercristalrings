package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.power.IPowerProvider;
import com.pefier.powercristalrings.power.IPowerReceiver;
import com.pefier.powercristalrings.power.PowerStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

/**
 * Created by Pefier on 09.11.2016.
 */
public abstract class TileGenericGenerator extends TileEntity implements IPowerProvider{

    /**
     * a Generic power generator extend it
     * */

    public PowerStorage storage;
    private int capacity;

    public TileGenericGenerator(int capacity) {

        this.storage = new PowerStorage(capacity);
        this.capacity=capacity;
    }




    protected void outputPower(int amount){

        storage.receivePower(capacity,false);

        for(EnumFacing direction: EnumFacing.values()){
            TileEntity tileEntity = worldObj.getTileEntity(this.getPos().offset(direction));
            if(tileEntity instanceof IPowerReceiver){
                int value = ((IPowerReceiver)tileEntity).receivePower(direction.getOpposite(),extractPower(direction,amount,true),true);
                if(value > 0)
                    ((IPowerReceiver)tileEntity).receivePower(direction.getOpposite(),extractPower(direction,amount,false),false);
            }
        }
    }

    protected void outputPowerToSide(int amount, EnumFacing side){
        //adds power to the generator
        storage.receivePower(capacity,false);
        TileEntity tileEntity = worldObj.getTileEntity(this.getPos().offset(side));
        if(tileEntity instanceof IPowerReceiver){
            int value = ((IPowerReceiver)tileEntity).receivePower(side.getOpposite(),extractPower(side,amount,true),true);
            if(value > 0){
                ((IPowerReceiver)tileEntity).receivePower(side.getOpposite(),extractPower(side,amount,false),false);
            }

        }



    }



    @Override
    public int extractPower(EnumFacing side, int maxExtract, boolean simulate) {
        return storage.extractPower(maxExtract,simulate);
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
