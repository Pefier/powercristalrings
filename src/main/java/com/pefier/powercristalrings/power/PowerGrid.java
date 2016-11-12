package com.pefier.powercristalrings.power;

import com.pefier.powercristalrings.entity.tileentity.TileCable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Pefier on 11.11.2016.
 */
public class PowerGrid {


    public PowerStorage powerStorage;
    public List<Long> cabelpos=new ArrayList<Long>();
    private static final int NODE_STORAGE = 1200;
    private static final int NODE_TRANSFER = 200;



    public PowerGrid(){
        powerStorage = new PowerStorage(NODE_STORAGE,NODE_TRANSFER);


    }

    public PowerGrid(List<Long> cabelpos) {
        powerStorage = new PowerStorage(NODE_STORAGE,NODE_TRANSFER);
        this.cabelpos = cabelpos;
        balanceGrid();
    }

    public void balanceGrid(){
        powerStorage.setCapacity(cabelpos.size()*1200);

    }


    public void addtoGrid(TileCable cable){

        cabelpos.add(cable.getPos().toLong());
        balanceGrid();

    }

    public void removeFromGrid(TileCable cable){

        cabelpos.remove(cable.getPos().toLong());
        balanceGrid();

    }

    public static PowerGrid mergeGrids(PowerGrid grid1,PowerGrid grid2){
        PowerGrid grid =new PowerGrid();
        grid.cabelpos.addAll(grid1.cabelpos);
        grid.cabelpos.addAll(grid2.cabelpos);
        grid.balanceGrid();
        return grid;
    }


    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagList nbtTagList = new NBTTagList();
        for (int i=0;i<cabelpos.size();i++){
            NBTTagCompound tag = new NBTTagCompound();
            double d = (double)cabelpos.get(i);
            tag.setDouble("cable" + i, d);
            nbtTagList.appendTag(tag);
        }
        System.out.println(nbtTagList.toString());

        compound.setTag("cableList",nbtTagList);
        return compound;
    }



    public void readFromNBT(NBTTagCompound compound){
        NBTTagList nbttaglist = compound.getTagList("cableList", Constants.NBT.TAG_COMPOUND);
        List<Long> list =new ArrayList<Long>();

        for (int i=0;i<nbttaglist.tagCount();i++) {
            NBTTagCompound tag = nbttaglist.getCompoundTagAt(i);
            double x = tag.getDouble("cable"+i);
            list.add(new Double(x).longValue());
        }

        cabelpos =list;
        this.balanceGrid();

    }
    protected PowerGrid getGrid(){
        return this;
    }


}








