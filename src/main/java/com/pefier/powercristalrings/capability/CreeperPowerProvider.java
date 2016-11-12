package com.pefier.powercristalrings.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

/**
 * Created by Pefier on 10.11.2016.
 */
public class CreeperPowerProvider implements ICapabilitySerializable<NBTBase>{


    private ICreeperPower instance = CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER.getDefaultInstance();


    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER){
            return CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER.<T> cast(this.instance);
        }else{
            return null;
        }

    }

    @Override
    public NBTBase serializeNBT() {
        return CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER.getStorage().writeNBT(CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER.getStorage().readNBT(CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER,this.instance,null,nbt);}
}
