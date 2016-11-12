package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.init.ModBlocks;
import com.pefier.powercristalrings.power.IPowerHandler;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

/**
 * Created by Pefier on 12.11.2016.
 */
public class TileEntityPowerCable extends TileEntityPower implements ITickable {

    private boolean networked;

    public TileEntityPowerCable()
    {
        super();
        networked = false;
    }

    @Override
    public void update() {
        if(!networked)
            equalize();
    }

    //ONLY call when the block is added! not my comment
    public void equalize()
    {
        if(!worldObj.isRemote) {
            for (EnumFacing side :EnumFacing.values()){
                if (worldObj.getBlockState(pos.offset(side)).getBlock() != null && getPower() == 0) {
                    eqaulizeWith(pos.offset(side));
                }
            }

        }
    }

    private void eqaulizeWith(BlockPos pos)
    {   //Block Class erstellen
        if(worldObj.getBlockState(pos).getBlock() == ModBlocks.testCable)
        {
            TileEntityPowerCable tile = (TileEntityPowerCable)worldObj.getTileEntity(pos);
            powerInt = tile.getPower();
            if(getPower() > 0)
                networked = true;
        }
    }


}
