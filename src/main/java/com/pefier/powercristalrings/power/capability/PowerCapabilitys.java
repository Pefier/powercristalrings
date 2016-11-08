package com.pefier.powercristalrings.power.capability;

import com.pefier.powercristalrings.power.IPowerProvider;
import com.pefier.powercristalrings.power.IPowerReceiver;
import com.pefier.powercristalrings.power.IPowerStorage;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 * Created by Pefier on 08.11.2016.
 */
public class PowerCapabilitys {
    //TODO READ AND WRITE TO NBT

    /**
     * Acces to PowerCapabilitys
     */
    @CapabilityInject(IPowerStorage.class)
    public static Capability<IPowerStorage> CAPABILITY_POWER_STORAGE=null;

    @CapabilityInject(IPowerProvider.class)
    public static Capability<IPowerProvider> CAPABILITY_POWER_PROVIDER=null;

    @CapabilityInject(IPowerReceiver.class)
    public static Capability<IPowerReceiver> CAPABILITY_POWER_RECEIVER=null;


    public static class CapabilityPowerStorage<T extends IPowerStorage> implements Capability.IStorage<IPowerStorage>{


        @Override
        public NBTBase writeNBT(Capability<IPowerStorage> capability, IPowerStorage instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IPowerStorage> capability, IPowerStorage instance, EnumFacing side, NBTBase nbt) {

        }
    }
    public static class CapabilityPowerProvider<T extends IPowerProvider> implements Capability.IStorage<IPowerProvider>{

        @Override
        public NBTBase writeNBT(Capability<IPowerProvider> capability, IPowerProvider instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IPowerProvider> capability, IPowerProvider instance, EnumFacing side, NBTBase nbt) {

        }
    }

    public static class CapabilityPowerReceiver<T extends IPowerReceiver> implements Capability.IStorage<IPowerReceiver>{

        @Override
        public NBTBase writeNBT(Capability<IPowerReceiver> capability, IPowerReceiver instance, EnumFacing side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IPowerReceiver> capability, IPowerReceiver instance, EnumFacing side, NBTBase nbt) {

        }
    }







}
