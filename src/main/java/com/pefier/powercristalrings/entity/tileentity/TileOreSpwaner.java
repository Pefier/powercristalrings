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
public class TileOreSpwaner extends TileEntity implements ITickable {

    private OreDic oreDic;
    private Random rnd;
    private int types;
    private int i;



    public TileOreSpwaner() {
        super();
        oreDic = new OreDic();
        oreDic.initOres();
        rnd = new Random();
        types=oreDic.stacks.size();
        i=0;
    }

    @Override
    public void update() {
            if (i > 200) {
                if (worldObj.getBlockState(this.getPos().offset(EnumFacing.UP)).getBlock() == Blocks.AIR) {
                    ItemStack stack = oreDic.stacks.get(rnd.nextInt(types));

                    worldObj.setBlockState(this.getPos().offset(EnumFacing.UP), Block.getBlockFromItem(stack.getItem()).getDefaultState(), 3);

                }
                i = 0;
            }

            i++;
    }
}
