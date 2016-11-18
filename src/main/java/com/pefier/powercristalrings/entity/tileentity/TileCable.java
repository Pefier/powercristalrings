package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.power.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;

import java.util.*;


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

    /**
     * Initializes the cable network.
     * when cables are placed next to another cable or in the World.
     * */
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
    /**
     * Updates the Power Grid in the Tile Entitys thata are on the powerGrid and makes it referenc one power grid;
     * */
    public void updateGrid(){
        if(worldObj!=null) {
            for (long temp : grid.cabelpos) {
                if (worldObj.getTileEntity(BlockPos.fromLong(temp)) instanceof TileCable)
                    ((TileCable) (worldObj.getTileEntity(BlockPos.fromLong(temp)))).grid = grid;
            }
        }

    }

    /***/
    public void removeFromGrid(){
        int connections=0;
        TileEntity tile;
        for (EnumFacing side : EnumFacing.values()){
             tile = worldObj.getTileEntity(this.getPos().offset(side));
            if(tile instanceof TileCable){
                connections++;
            }
        }
        if(connections>=2){
            for (EnumFacing side : EnumFacing.values()){
                tile = worldObj.getTileEntity(this.getPos().offset(side));
                if(tile instanceof TileCable){
                    LinkedHashSet<Long> set= new LinkedHashSet<Long>();
                    set.add(tile.getPos().toLong());
                    set = buildCableTree(set,grid.cabelpos);
                    System.out.println("Not "+set.toString());


                }
            }
        }



        grid.removeFromGrid(this);
    }

    private LinkedHashSet<Long> buildCableTree(LinkedHashSet<Long> setIn,List<Long> listIn){
        List<Long> list= new ArrayList<Long>(listIn);
        LinkedHashSet<Long> set = new LinkedHashSet<Long>(setIn);
        list.remove(this.getPos().toLong());
        boolean added=true;
        int i =0;
        System.out.println("enter while loop"+list.size());
        while (list.size()>=1){
            System.out.println("enter while loop");
            added=false;
            for(Long value : set){

                System.out.println("enter while loop Itérator");
                for (EnumFacing side : EnumFacing.values()){

                    TileEntity tile = worldObj.getTileEntity(BlockPos.fromLong(value).offset(side));
                    if(tile instanceof TileCable) {

                        if (list.contains(tile.getPos().toLong())){

                            set.add(tile.getPos().toLong());
                            list.remove(tile.getPos().toLong());
                            System.out.println(set.toString());
                            added=true;
                        }
                    }
                }
            }
            if(!added){
                break;
            }




        }

      return set ;
    }







    /**
     * Updates the connections for the TESR that pipes are rendered with the right Connection
     * */
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

        //Locks if Grid is not null and updates it net to do something that it not updates every tick;
        if(grid != null) {
            updateGrid();

            //System.out.println("energyStored" + grid.powerStorage.getPowerStored() + " Capacity" + grid.powerStorage.getCapacity());
        }

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        NBTTagList nbtTagList = new NBTTagList();
        int i =0;
        for (long temp: grid.cabelpos){
            NBTTagCompound tag = new NBTTagCompound();
            double d = (double)temp;
            tag.setDouble("cable" + i++, d);
            nbtTagList.appendTag(tag);
        }

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
