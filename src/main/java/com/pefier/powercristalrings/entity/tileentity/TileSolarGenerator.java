package com.pefier.powercristalrings.entity.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

/**
 * Created by Pefier on 02.11.2016.
 */
public class TileSolarGenerator extends TileGenericGenerator implements ITickable {




    public TileSolarGenerator(){
        super(3200);


    }


    @Override
    public void update() {
        //TODO WHEN GIVE HOW MUCH POWER
        /**0-12000 ticks == Daytime
         * 12000-23999 ticks == nighttime
         * Worldtime 0-23999 int ticks
         *
         * Colors Used to detmiter power generation
         *  Yellow,Blue,Yellow,red,Green,red=>
         *  0-4000,4000-10.000,10.000-12.000,12.000-15.000,15.000-21.000,21.000-24.000
         *
         *
         * */
        if(worldObj.canSeeSky(this.getPos().offset(EnumFacing.UP,2))){
            if(worldObj.getBlockState(this.getPos().offset(EnumFacing.UP)).getBlock()== Blocks.STAINED_GLASS){
                outputPower(200);
                switch(worldObj.getBlockState(this.getPos().offset(EnumFacing.UP)).getBlock().getMetaFromState(worldObj.getBlockState(this.getPos().offset(EnumFacing.UP)))){
                    //BlueCase
                    case  11: {
                        if(worldObj.getWorldTime()<10000 && worldObj.getWorldTime() > 4000){

                            System.out.println("I see Blue Glass");
                        }


                        return;
                    }
                    //GreenCase
                    case  13:{
                        if(worldObj.getWorldTime()<21000 && worldObj.getWorldTime() > 15000){
                            System.out.println("I see Green Glass");

                        }

                        return;
                    }
                    //RedCase
                    case  14:{
                        if((worldObj.getWorldTime()<15000 && worldObj.getWorldTime() >12000) || (worldObj.getWorldTime()<24000&& worldObj.getWorldTime() > 21000)){
                            System.out.println("I see Red Glass");

                        }

                        return;
                    }
                    //YellowCase
                    case 4: {
                        if((worldObj.getWorldTime()<4000 && worldObj.getWorldTime() >0) || (worldObj.getWorldTime()<12000&& worldObj.getWorldTime() > 10000)){
                            System.out.println("I see Yellow Glass");

                        }

                        return;
                    }

                    default: //System.out.println("NOP");
                         return;
                }
            }
        }

    }

}
