package com.pefier.powercristalrings.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

/**
 * Created by Pefier on 07.10.2016.
 */
public class WillpowerProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IWillpower.class)
    public static final Capability<IWillpower> WILLPOWER_CAPABILITY = null;

    private IWillpower instance = WILLPOWER_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == WILLPOWER_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == WILLPOWER_CAPABILITY){
            return WILLPOWER_CAPABILITY.<T> cast(this.instance);
        }else
            return null;
    }

    @Override
    public NBTBase serializeNBT() {
        return WILLPOWER_CAPABILITY.getStorage().writeNBT(WILLPOWER_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        WILLPOWER_CAPABILITY.getStorage().readNBT(WILLPOWER_CAPABILITY,this.instance,null,nbt);
    }
}
