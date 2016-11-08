package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.power.IPowerProvider;
import com.pefier.powercristalrings.power.IPowerReceiver;
import com.pefier.powercristalrings.power.implementation.PowerStorage;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

/**
 * Created by Pefier on 02.11.2016.
 */
public class TileSolarGenerator extends TileEntity implements IPowerProvider ,ITickable {

    PowerStorage storage = new PowerStorage(32000);


    public TileSolarGenerator(){



    }


    @Override
    public void update() {
        /**
         * Worldtime 0-23999 int ticks*/
        if(worldObj.canSeeSky(this.getPos().offset(EnumFacing.UP,2))){
                System.out.println("I see sky");

            if(worldObj.getBlockState(this.getPos().offset(EnumFacing.UP)).getBlock()== Blocks.STAINED_GLASS){
                if(worldObj.getBlockState(this.getPos().offset(EnumFacing.UP)).getBlock().getMetaFromState(worldObj.getBlockState(this.getPos().offset(EnumFacing.UP))) == 12)

                System.out.println("I see Green Glass");

            }

        }


        storage.receivePower(32000,false);
        for(EnumFacing direction: EnumFacing.values()){
            TileEntity tileEntity = worldObj.getTileEntity(this.getPos().offset(direction));
            if(tileEntity instanceof IPowerReceiver){
                int value = ((IPowerReceiver)tileEntity).receivePower(direction.getOpposite(),extractPower(direction,100,true),true);
                if(value > 0)
                    ((IPowerReceiver)tileEntity).receivePower(direction.getOpposite(),extractPower(direction,100,false),false);

            }

        }


    }


    @Override
    public int extractPower(EnumFacing side, int maxExtract, boolean simulate) {
        return storage.extractPower(maxExtract,simulate);
    }

    @Override
    public int getPowerStored(EnumFacing from) {
        return storage.getPowerStored();
    }

    @Override
    public int getCapacity(EnumFacing from) {
        return storage.getCapacity();
    }

    @Override
    public boolean canConnectPower(EnumFacing from) {
        return true;
    }
}
