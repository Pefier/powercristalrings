package com.pefier.powercristalrings.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

/**
 * Created by Pefier on 10.11.2016.
 */
public class CapabilityCreeperPower {

    @CapabilityInject(ICreeperPower.class)
    public static Capability<ICreeperPower> CPAPBILITY_CREEPER_POWER = null;

    public static void register(){

        CapabilityManager.INSTANCE.register(ICreeperPower.class, new Capability.IStorage<ICreeperPower>() {
            @Override
            public NBTBase writeNBT(Capability<ICreeperPower> capability, ICreeperPower instance, EnumFacing side) {
                NBTTagCompound data = new NBTTagCompound();
                data.setInteger("CreeperPower",instance.getCreeperPower());

                return data;
            }

            @Override
            public void readNBT(Capability<ICreeperPower> capability, ICreeperPower instance, EnumFacing side, NBTBase nbt) {
                instance.setCreeperPower(((NBTTagCompound)nbt).getInteger("CreeperPower"));


            }
        }, CreeperPower.class);

    }





}
