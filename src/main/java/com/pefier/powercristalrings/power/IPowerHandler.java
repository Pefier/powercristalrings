package com.pefier.powercristalrings.power;

import net.minecraft.util.EnumFacing;

/**
 * Created by Pefier on 08.11.2016.
 */
public interface IPowerHandler extends IPowerProvider,IPowerReceiver{

    @Override
    int extractPower(EnumFacing side, int maxExtract, boolean simulate);

    @Override
    int receivePower(EnumFacing side, int maxReceive, boolean simulate);

    @Override
    int getPowerStored(EnumFacing from);

    @Override
    int getCapacity(EnumFacing from);

}
