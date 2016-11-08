package com.pefier.powercristalrings.capability;

/**
 * Created by Pefier on 07.10.2016.
 */
public interface IWillpower {

    public void consumeWillpower(int amount);

    public void fillWillpower(int amount);

    public void setWillpower(int amount);

    public int getWillpower();

    public int getMaxWillpower();

    public int getRechargerate();

    public void rechargeWillpower();

    public void setMaxWillpower(int maxWillpower);

    public void setRechargerate(int rechargerate);

    public void setDmgReduction(int dmgReduction);

    public int getDmgReduction();

    public void setDmgIncrease(int dmgIncrease);

    public int getDmgIncrease();

    public boolean isStatus();

    public void setStatus(boolean status);

    public int getMiningSpeed();

    public void setMiningSpeed(int miningSpeed);

    public double getAttackSpeed();

    public void setAttackSpeed(double attackSpeed);
}
