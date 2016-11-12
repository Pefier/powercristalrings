package com.pefier.powercristalrings.entity.tileentity;

import com.pefier.powercristalrings.capability.CapabilityCreeperPower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pefier on 10.11.2016.
 */
public class TileCreeperGenerator extends TileGenericGenerator implements ITickable{

    private AxisAlignedBB box;
    private List<Entity> entityList;
    public TileCreeperGenerator(int capacity) {
        super(capacity);


        entityList = new ArrayList<Entity>();
    }

    @Override
    public void update() {
        entityList = worldObj.getEntitiesInAABBexcluding(null,new AxisAlignedBB(this.getPos(), this.getPos().add(1,2,1)),null);
        for(int i=0; i<entityList.size(); i++) {
            if (entityList.get(i) instanceof EntityCreeper) {
                EntityCreeper creeper = (EntityCreeper) entityList.get(i);
                if(creeper.hasCapability(CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER,null)){
                    creeper.getCapability(CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER,null).consumeCreepwerPower(2);
                    System.out.println(creeper.getCapability(CapabilityCreeperPower.CPAPBILITY_CREEPER_POWER,null).getCreeperPower());


                }

                if(creeper.getPowered()){

                }


            }



        }

    }
}
