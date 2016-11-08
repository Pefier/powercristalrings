package com.pefier.powercristalrings.power.implementation;

import com.pefier.powercristalrings.power.IPowerProvider;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * Created by Pefier on 08.11.2016.
 */
public class PowerProvider implements IPowerProvider,INBTSerializable<NBTTagCompound>{

    protected int power;
    protected int capacity;
    protected int maxExtract;

    public PowerProvider(int capacity, int maxExtract) {
        this.capacity = capacity;
        this.maxExtract = maxExtract;
    }

    @Override
    public int extractPower(EnumFacing side, int maxExtract, boolean simulate) {

        if(canConnectPower(side)) {
            if (power <= 0) {
                return 0;
            }
            int energyExtracted = Math.min(power, Math.min(this.maxExtract, maxExtract));

            if (!simulate) {
                power -= energyExtracted;
            }
            return energyExtracted;
        }
        return 0;
    }

    @Override
    public int getPowerStored(EnumFacing from) {
        return 0;
    }

    @Override
    public int getCapacity(EnumFacing from) {
        return 0;
    }

    @Override
    public boolean canConnectPower(EnumFacing from) {
        return true;
    }


    @Override
    public NBTTagCompound serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {

    }
}
