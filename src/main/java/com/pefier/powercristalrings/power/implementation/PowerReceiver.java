package com.pefier.powercristalrings.power.implementation;

import com.pefier.powercristalrings.power.IPowerReceiver;
import net.minecraft.util.EnumFacing;

/**
 * Created by Pefier on 08.11.2016.
 */
public class PowerReceiver implements IPowerReceiver {




    private PowerStorage storage;

    public PowerReceiver(int maxExtract, int capacity) {
        storage = new PowerStorage(0,maxExtract,capacity);

    }

    @Override
    public int receivePower(EnumFacing side, int maxExtract, boolean simulate) {
        if(canConnectPower(side)) {
            return storage.receivePower(maxExtract,simulate);

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


}
