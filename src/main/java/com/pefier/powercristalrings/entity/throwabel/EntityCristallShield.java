package com.pefier.powercristalrings.entity.throwabel;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by Pefier on 31.08.2016.
 */
public class EntityCristallShield extends EntityThrowable {

    public EntityCristallShield(World worldIn){
        super(worldIn);
    }

    public EntityCristallShield(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityCristallShield(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Override
    protected float getGravityVelocity() {
        return 0.0f;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(result.entityHit != null){
            
        }
        this.setDead();

    }
}
