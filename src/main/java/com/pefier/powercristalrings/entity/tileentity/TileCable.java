package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.power.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Pefier on 07.11.2016.
 */
public class TileCable extends TileEntity implements IPowerHandler,ITickable{

    /**
     *  UP, DOWN NORTH, EAST SOUTH, WEST
     * */
    public EnumFacing[] connections = new EnumFacing[6];
    public PowerGrid grid;


    public TileCable(){




    }


    public void init() {
        boolean initialized =true;
        boolean flag = true;
        boolean update =false;

        for (EnumFacing direction : EnumFacing.values()){
            TileEntity tileEntity = worldObj.getTileEntity(this.getPos().offset(direction));
            if(tileEntity instanceof TileCable){

                if(flag){
                    grid=((TileCable)tileEntity).grid;
                    grid.addtoGrid(this);
                    ((TileCable)tileEntity).grid=grid;
                    flag=false;

                }else{
                    grid=grid.mergeGrids(((TileCable)tileEntity).grid,grid);
                    update=true;
                }
                if(update){
                    updateGrid();

                }
                initialized = false;
            }
        }
        if(initialized){
            grid=new PowerGrid();
            grid.addtoGrid(this);
        }
    }

    public void updateGrid(){
        if(worldObj!=null) {
            for (long temp : grid.cabelpos) {
                if (worldObj.getTileEntity(BlockPos.fromLong(temp)) instanceof TileCable)
                    ((TileCable) (worldObj.getTileEntity(BlockPos.fromLong(temp)))).grid = grid;
            }
        }

    }



    public void updateConnections(){
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.UP)) instanceof IPowerConnection){
            connections[0] = EnumFacing.UP;
        }else{
            connections[0] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.DOWN)) instanceof IPowerConnection){
            connections[1] = EnumFacing.DOWN;
        }else{
            connections[1] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.NORTH)) instanceof IPowerConnection){
            connections[2] = EnumFacing.NORTH;
        }else{
            connections[2] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.EAST)) instanceof IPowerConnection){
            connections[3] = EnumFacing.EAST;
        }else{
            connections[3] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.SOUTH)) instanceof IPowerConnection){
            connections[4] = EnumFacing.SOUTH;
        }else{
            connections[4] = null;
        }
        if(this.worldObj.getTileEntity(this.getPos().offset(EnumFacing.WEST)) instanceof IPowerConnection){
            connections[5] = EnumFacing.WEST;
        }else{
            connections[5] = null;
        }

    }


    @Override
    public void update() {
        this.updateConnections();


        if(grid !=null) {
            updateGrid();

            System.out.println("energyStored" + grid.powerStorage.getPowerStored() + " Capacity" + grid.powerStorage.getCapacity());
        }

    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        NBTTagList nbtTagList = new NBTTagList();
        for (int i=0;i<grid.cabelpos.size();i++){
            NBTTagCompound tag = new NBTTagCompound();
            double d = (double)grid.cabelpos.get(i);
            tag.setDouble("cable" + i, d);
            nbtTagList.appendTag(tag);
        }
        System.out.println(nbtTagList.toString());

        compound.setTag("cableList",nbtTagList);
        return compound;


    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("cableList", Constants.NBT.TAG_COMPOUND);
        List<Long> list =new ArrayList<Long>();

        for (int i=0;i<nbttaglist.tagCount();i++) {
            NBTTagCompound tag = nbttaglist.getCompoundTagAt(i);
            double x = tag.getDouble("cable"+i);
            list.add(new Double(x).longValue());
        }

        grid=new PowerGrid(list);
        updateGrid();

    }


    @Override
    public boolean canConnectPower(EnumFacing from) {
        return true;
    }


    @Override
    public int extractPower(EnumFacing side, int maxExtract, boolean simulate) {
        return grid.powerStorage.extractPower(maxExtract, simulate);
    }

    @Override
    public int receivePower(EnumFacing side, int maxExtract, boolean simulate) {
        return grid.powerStorage.receivePower(maxExtract,simulate);
    }

    @Override
    public int getPowerStored(EnumFacing from) {
        return grid.powerStorage.getPowerStored();
    }

    @Override
    public int getCapacity(EnumFacing from) {
        return grid.powerStorage.getCapacity();
    }
}
