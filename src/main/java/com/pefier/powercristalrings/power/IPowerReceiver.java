package com.pefier.powercristalrings.power;

import net.minecraft.util.EnumFacing;

/**
 * Created by Pefier on 08.11.2016.
 */
public interface IPowerReceiver extends IPowerConnection {

    int receivePower(EnumFacing side, int maxExtract, boolean simulate);

    /**
     * Returns the amount of energy currently stored.
     */
    int getPowerStored(EnumFacing from);

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    int getCapacity(EnumFacing from);
}
