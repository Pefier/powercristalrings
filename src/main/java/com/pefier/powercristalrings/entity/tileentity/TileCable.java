package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.power.IPowerConnection;
import com.pefier.powercristalrings.power.IPowerHandler;
import com.pefier.powercristalrings.power.implementation.PowerStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;


/**
 * Created by Pefier on 07.11.2016.
 */
public class TileCable extends TileEntity implements IPowerHandler,ITickable{

    /**
     *  UP, DOWN NORTH, EAST SOUTH, WEST
     * */
    public EnumFacing[] connections = new EnumFacing[6];
    protected PowerStorage storage;
    public int output;


    public TileCable(int output){
        this.output = output;
        this.storage = new PowerStorage(200);
        this.storage.setMaxExtract(output);
        this.storage.setMaxReceive(output);
        this.storage.setMaxTransferRate(output);

    }



    public void updateConnections(){
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.UP)) instanceof IPowerConnection){
            connections[0] = EnumFacing.UP;
        }else{
            connections[0] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.DOWN)) instanceof IPowerConnection){
            connections[1] = EnumFacing.DOWN;
        }else{
            connections[1] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.NORTH)) instanceof IPowerConnection){
            connections[2] = EnumFacing.NORTH;
        }else{
            connections[2] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.EAST)) instanceof IPowerConnection){
            connections[3] = EnumFacing.EAST;
        }else{
            connections[3] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.SOUTH)) instanceof IPowerConnection){
            connections[4] = EnumFacing.SOUTH;
        }else{
            connections[4] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.WEST)) instanceof IPowerConnection){
            connections[5] = EnumFacing.WEST;
        }else{
            connections[5] = null;
        }

    }


    @Override
    public void update() {
        this.updateConnections();
        if(storage.getPowerStored() > 0){
            for (EnumFacing direction : EnumFacing.values()){
                TileEntity tileEntity = worldObj.getTileEntity(this.getPos().offset(direction));
                if(tileEntity instanceof IPowerHandler){
                    System.out.println("isIn Power ");
                    int maxExtract = storage.getMaxExtract();
                    int maxPowerAvilebale = storage.extractPower(maxExtract,true);
                    int powerTransferd = ((IPowerHandler) tileEntity).receivePower(direction,maxPowerAvilebale,false);

                    storage.extractPower(powerTransferd,false);
                }
            }


        }


    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

    }


    @Override
    public boolean canConnectPower(EnumFacing from) {
        return true;
    }


    @Override
    public int extractPower(EnumFacing side, int maxExtract, boolean simulate) {
        return storage.extractPower(maxExtract, simulate);
    }

    @Override
    public int receivePower(EnumFacing side, int maxExtract, boolean simulate) {
        return storage.receivePower(maxExtract,simulate);
    }

    @Override
    public int getPowerStored(EnumFacing from) {
        return storage.getPowerStored();
    }

    @Override
    public int getCapacity(EnumFacing from) {
        return storage.getCapacity();
    }
}
