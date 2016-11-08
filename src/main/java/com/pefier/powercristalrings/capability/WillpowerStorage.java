package com.pefier.powercristalrings.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Created by Pefier on 07.10.2016.
 */
public class WillpowerStorage implements Capability.IStorage<IWillpower> {

    @Override
    public NBTBase writeNBT(Capability<IWillpower> capability, IWillpower instance, EnumFacing side) {
        NBTTagCompound data = new NBTTagCompound();
        data.setBoolean("status",instance.isStatus());
        data.setInteger("willpower", instance.getWillpower());
        data.setInteger("rechargerate",instance.getRechargerate());
        data.setInteger("maxWillpower", instance.getMaxWillpower());
        data.setInteger("dmgReduction",instance.getDmgReduction());
        data.setInteger("dmgIncrease",instance.getDmgIncrease());
        data.setInteger("miningSpeed",instance.getMiningSpeed());
        data.setDouble("attackSpeed",instance.getAttackSpeed());
        return data;

    }

    @Override
    public void readNBT(Capability<IWillpower> capability, IWillpower instance, EnumFacing side, NBTBase nbt) {

        instance.setStatus(((NBTTagCompound)nbt).getBoolean("status"));
        instance.setWillpower(((NBTTagCompound) nbt).getInteger("willpower"));
        instance.setRechargerate(((NBTTagCompound) nbt ).getInteger("rechargerate"));
        instance.setMaxWillpower(((NBTTagCompound)nbt).getInteger("maxWillpower"));
        instance.setDmgReduction(((NBTTagCompound)nbt).getInteger("dmgReduction"));
        instance.setDmgIncrease(((NBTTagCompound)nbt).getInteger("dmgIncrease"));
        instance.setMiningSpeed(((NBTTagCompound)nbt).getInteger("miningSpeed"));
        instance.setAttackSpeed(((NBTTagCompound)nbt).getInteger("attackSpeed"));



    }
}
