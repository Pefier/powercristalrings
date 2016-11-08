package com.pefier.powercristalrings.power;

import net.minecraft.util.EnumFacing;

/**
 * Created by Pefier on 08.11.2016.
 */
public interface IPowerProvider extends IPowerConnection{
    /**
     * Remove energy from an IEnergyProvider, internal distribution is left entirely to the IEnergyProvider.
     *
     * @param side
     *            Orientation the power is extracted from.
     * @param maxExtract
     *            Maximum amount of power to extract.
     * @param simulate
     *            If TRUE, the extraction will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted.
     */

    int extractPower(EnumFacing side, int maxExtract, boolean simulate);
    /**
     * Returns the amount of power currently stored.
     */
    int getPowerStored(EnumFacing from);

    /**
     * Returns the maximum amount of power that can be stored.
     */
    int getCapacity(EnumFacing from);

}
