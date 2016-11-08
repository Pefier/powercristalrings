package com.pefier.powercristalrings.utility;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

/**
 * Created by Pefier on 18.10.2016.
 */
public class CustomTeleporter extends Teleporter {


    private final WorldServer worldServer;
    private double x;
    private double y;
    private double z;


    public CustomTeleporter(WorldServer worldIn,double x,double y,double z) {
        super(worldIn);
        this.worldServer=worldIn;
        this.x=x;
        this.y=y;
        this.z=z;
    }

    /**
     *  Stops nether Portal from appering
     * @param entityIn
     * @param rotationYaw
     */
    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        this.worldServer.getBlockState(new BlockPos((int)this.x,(int)this.y,(int)this.z));

        entityIn.setPosition(this.x,this.y,this.z);
        entityIn.motionX=0.0f;
        entityIn.motionY=0.0f;
        entityIn.motionZ=0.0f;

    }

    /**
     * Teleport player to Custom Location
     * @param playerIn EntityPlayer that gets teleporter
     * @param dimension target dimension
     * target Cordinates
     * @param x
     * @param y
     * @param z
     */
    public static void teleportToDimension(EntityPlayer playerIn,int dimension, double x,double y,double z){

        int oldDimension = playerIn.worldObj.provider.getDimension();
        EntityPlayerMP entityPlayerMP=(EntityPlayerMP)playerIn;
        MinecraftServer server= ((EntityPlayerMP) playerIn).worldObj.getMinecraftServer();
        WorldServer worldServer = server.worldServerForDimension(dimension);
        playerIn.addExperienceLevel(0);

        if (worldServer == null || worldServer.getMinecraftServer() == null){
            throw new IllegalArgumentException("Dimension: "+dimension+" doesn't exist!");
        }
        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new CustomTeleporter(worldServer, x, y, z));
        playerIn.setPositionAndUpdate(x, y, z);

        if (oldDimension == 1) {
            // For some reason teleporting out of the end does weird things. Compensate for that
            playerIn.setPositionAndUpdate(x, y, z);
            worldServer.spawnEntityInWorld(playerIn);
            worldServer.updateEntityWithOptionalForce(playerIn, false);
        }



    }




}
