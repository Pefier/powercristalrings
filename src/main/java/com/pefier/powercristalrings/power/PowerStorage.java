package com.pefier.powercristalrings.power;

/**
 * Created by Pefier on 08.11.2016.
 */
public class PowerStorage implements IPowerStorage {

    protected int power;
    protected int maxReceive;
    protected int maxExtract;
    protected int capacity;

    public PowerStorage(int capacity) {
        this(capacity,capacity,capacity);
    }

    public PowerStorage(int capacity, int maxTransferRate) {
        this(maxTransferRate,maxTransferRate,capacity);
    }

    public PowerStorage(int maxReceive, int maxExtract, int capacity) {
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.capacity = capacity;
    }

    public PowerStorage setCapacity(int capacity) {

        this.capacity = capacity;

        if (power > capacity) {
            power = capacity;
        }
        return this;
    }

    public PowerStorage setMaxTransferRate(int maxTransferRate) {

        setMaxReceive(maxTransferRate);
        setMaxExtract(maxTransferRate);
        return this;
    }

    public PowerStorage setMaxReceive(int maxReceive) {

        this.maxReceive = maxReceive;
        return this;
    }

    public PowerStorage setMaxExtract(int maxExtract) {

        this.maxExtract = maxExtract;
        return this;
    }



    public int getMaxReceive() {

        return maxReceive;
    }

    public int getMaxExtract() {

        return maxExtract;
    }



    @Override
    public int receivePower(int maxReceive, boolean simulate) {
        int powerReceived = Math.min(this.capacity-this.power,Math.min(this.maxReceive,maxReceive));
        if(!simulate){
            power+=powerReceived;
        }

        return powerReceived;
    }

    @Override
    public int extractPower(int maxExtract, boolean simulate) {
        int powerExtracted = Math.min(power,Math.min(this.maxExtract,maxExtract));
        if(!simulate){
            power-=powerExtracted;
        }

        return powerExtracted;
    }

    @Override
    public int getPowerStored() {
        return this.power;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
}
