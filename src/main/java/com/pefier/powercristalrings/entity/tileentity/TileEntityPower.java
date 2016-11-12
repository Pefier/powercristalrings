package com.pefier.powercristalrings.entity.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

/**
 * Created by Pefier on 12.11.2016. Test class cable
 */
public class TileEntityPower extends TileEntity {

    protected int powerInt = 0;

    public TileEntityPower()
    {
        super();
    }


    public void addPower(int addition, TileEntity issuer)
    {
        powerInt+=addition;

        for (EnumFacing side : EnumFacing.values()){
            if (worldObj.getTileEntity(pos.offset(side))  instanceof TileEntityPower && worldObj.getTileEntity(pos.offset(side)) != issuer && worldObj.getTileEntity(pos.offset(side)) != null) {
                ((TileEntityPower) worldObj.getTileEntity(pos.offset(side))).addPowerNetworked(powerInt, this);
            }

        }

    }

    public void addPowerNetworked(int addition, TileEntityPower issuer)
    {
        if(powerInt + addition == issuer.getPower())
        {
            powerInt+=addition;
            for (EnumFacing side: EnumFacing.values()){
                if (worldObj.getTileEntity(pos.offset(side))  instanceof TileEntityPower && worldObj.getTileEntity(pos.offset(side)) != issuer && worldObj.getTileEntity(pos.offset(side)) != null)
                {
                    ((TileEntityPower) worldObj.getTileEntity(pos.offset(side))).addPowerNetworked(powerInt, this);
                }
            }
        }
        else
        {
            int diff = issuer.getPower() - powerInt;
            if(diff > 0)
            {
                this.addPowerNetworked(diff, issuer);
            }
        }
    }

    public boolean subtractPower(int subtraction, TileEntity issuer)
    {
        if(powerInt >= subtraction)
        {
            powerInt-=subtraction;
            for (EnumFacing side : EnumFacing.values()){
                if(worldObj.getTileEntity(pos.offset(side)) instanceof TileEntityPower && worldObj.getTileEntity(pos.offset(side)) != issuer && worldObj.getTileEntity(pos.offset(side)) != null)
                {
                    ((TileEntityPower)worldObj.getTileEntity(pos.offset(side))).subtractPowerNetworked(powerInt, this);
                }

            }
            return true;
        }
        return false;
    }

    public void subtractPowerNetworked(int subtraction, TileEntityPower issuer)
    {
        if(powerInt >= subtraction)
        {

            if(powerInt - subtraction == issuer.getPower())
            {
                powerInt-=subtraction;
                for (EnumFacing side : EnumFacing.values()){
                    if(worldObj.getTileEntity(pos.offset(side)) instanceof TileEntityPower && worldObj.getTileEntity(pos.offset(side)) != issuer && worldObj.getTileEntity(pos.offset(side)) != null)
                    {
                        ((TileEntityPower)worldObj.getTileEntity(pos.offset(side))).subtractPowerNetworked(powerInt, this);
                    }

                }

            }
            else
            {
                int diff = powerInt - issuer.getPower();
                if(diff > 0)
                {
                    this.subtractPowerNetworked(diff, issuer);
                }
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger("power", this.powerInt);
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        powerInt = tag.getInteger("power");
    }

    public int getPower()
    {
        return powerInt;
    }
}

