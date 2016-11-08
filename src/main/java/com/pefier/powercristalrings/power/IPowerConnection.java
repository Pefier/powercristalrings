package com.pefier.powercristalrings.power;

import net.minecraft.util.EnumFacing;

/**
 * Created by Pefier on 08.11.2016.
 */
public interface IPowerConnection {
    /**
     * Returns TRUE if the TileEntity can connect on a given side.
     */
    boolean canConnectPower(EnumFacing from);
}
