package com.pefier.powercristalrings.capability;

/**
 * Created by Pefier on 10.11.2016.
 */
public class CreeperPower implements ICreeperPower{

    private int creeperPower = 3000;

    @Override
    public void setCreeperPower(int creeperPower) {
        this.creeperPower=creeperPower;
    }

    @Override
    public int getCreeperPower() {
        return this.creeperPower;
    }

    @Override
    public void consumeCreepwerPower(int creeperPower) {
        this.creeperPower-=creeperPower;
        if(this.creeperPower<=0){
            this.creeperPower=0;
        }
    }
}
