package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.power.IPowerReceiver;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

/**
 * Created by Pefier on 08.11.2016.
 */
public class TileConsumer extends TileEntity implements ITickable,IPowerReceiver{






    @Override
    public int receivePower(EnumFacing side, int maxExtract, boolean simulate) {
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
        return false;
    }

    @Override
    public void update() {

    }
}
