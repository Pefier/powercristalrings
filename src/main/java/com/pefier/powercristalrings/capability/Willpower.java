package com.pefier.powercristalrings.capability;

/**
 * Created by Pefier on 07.10.2016.
 */
public class Willpower implements IWillpower {

    private boolean status=true;

    private int willpower=50;
    private int maxWillpower=12000;
    private int rechargerate=100;
    private int dmgReduction=0;
    private int dmgIncrease=0;
    private int miningSpeed=0;
    private double attackSpeed=0.0D;

    @Override
    public void consumeWillpower(int amount) {
        willpower-=amount;

        if(willpower <= 0) {
            willpower = 0;
        }
    }



    @Override
    public void fillWillpower(int amount) {
        willpower += amount;
        if(willpower >= maxWillpower){
            willpower=maxWillpower;
        }
    }

    @Override
    public void setWillpower(int amount) {
        willpower = amount;

    }

    @Override
    public int getWillpower() {
        return willpower;
    }

    @Override
    public int getMaxWillpower() {
        return maxWillpower;
    }

    @Override
    public int getRechargerate() {
        return rechargerate;
    }

    @Override
    public void rechargeWillpower() {
        willpower = willpower + rechargerate;

        if(willpower >= maxWillpower){
            willpower = maxWillpower;
        }
    }

    @Override
    public int getDmgReduction() {
        return dmgReduction;
    }

    @Override
    public void setMaxWillpower(int maxWillpower) {
        this.maxWillpower = maxWillpower;
    }

    @Override
    public void setRechargerate(int rechargerate) {
        this.rechargerate = rechargerate;
    }

    @Override
    public void setDmgReduction(int dmgReduction) {
        this.dmgReduction = dmgReduction;
    }

    @Override
    public void setDmgIncrease(int dmgIncrease) {
        this.dmgIncrease = dmgIncrease;
    }

    @Override
    public int getDmgIncrease() {
        return dmgIncrease;
    }

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int getMiningSpeed() {
        return miningSpeed;
    }

    @Override
    public void setMiningSpeed(int miningSpeed) {
        this.miningSpeed = miningSpeed;
    }

    @Override
    public double getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
