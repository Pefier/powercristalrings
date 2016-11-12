package com.pefier.powercristalrings.entity.tileentity;


import com.pefier.powercristalrings.utility.OreDic;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;


import java.util.Random;

/**
 * Created by Pefier on 03.11.2016.
 */
public class TileOreSpwaner extends TileGenericConsumer implements ITickable {

    private OreDic oreDic;
    private Random rnd;
    private int types;




    public TileOreSpwaner() {
        super(5000);
        oreDic = new OreDic();
        oreDic.initOres();
        rnd = new Random();
        types=oreDic.stacks.size();
        storage =storage.setMaxReceive(200);

    }

    @Override
    public void update() {
        if(storage.getPowerStored()>=500){

            consumePower(100);
            spwanOres();
        }







    }

    private void spwanOres(){
        if (worldObj.getBlockState(this.getPos().offset(EnumFacing.UP)).getBlock() == Blocks.AIR) {
            ItemStack stack = oreDic.stacks.get(rnd.nextInt(types));

            worldObj.setBlockState(this.getPos().offset(EnumFacing.UP), Block.getBlockFromItem(stack.getItem()).getDefaultState(), 3);

        }
    }
}
