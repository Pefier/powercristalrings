package com.pefier.powercristalrings.power;

/**
 * Created by Pefier on 08.11.2016.
 */
public interface IPowerStorage {


    /**
     * @param maxReceive maximum amount of Power pushed
     *
     * @param simulate If true insertion will bi simulated
     *
     * @return Amount of energy that was or would be accepted by the storage
     *
     * */
    int receivePower(int maxReceive, boolean simulate);
    /**
     * @param maxExtract maximum amount of Power pulled
     *
     * @param simulate If true ectraction will bi simulated
     *
     * @return Amount of energy that was or would be extracted by the storage
     *
     * */
    int extractPower(int maxExtract, boolean simulate);
    /**
     * return actual amount of power Stored
     * */
    int getPowerStored();
    /**
     * returns Maxium ammount of power stored
     * */
    int getCapacity();
}
