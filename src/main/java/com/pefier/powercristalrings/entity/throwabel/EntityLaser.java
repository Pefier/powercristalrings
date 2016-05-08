package com.pefier.powercristalrings.entity.throwabel;


import com.pefier.powercristalrings.entity.damagesource.EntityDamageSourceLaser;
import com.pefier.powercristalrings.init.ModItems;
import com.pefier.powercristalrings.reference.Name;
import com.pefier.powercristalrings.utility.InventoryHelper;
import com.pefier.powercristalrings.utility.NBTHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by New Profile on 13.04.2016.
 */
public class EntityLaser extends EntityThrowable {
    private int dmg;

    public EntityLaser(World worldIn) {
        super(worldIn);
    }

    public EntityLaser(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
        this.dmg = NBTHelper.getNBTTagInt(InventoryHelper.getItemStackinInventory((EntityPlayer)throwerIn, ModItems.ringGreenLantern), Name.NBTKey.TAG_DMGINCREASE,Name.NBTKey.TAG_RINGDATA);
    }

    public EntityLaser(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }




    @Override
    protected float getGravityVelocity()
    {
        return 0.01F;
    }

    @Override
    protected void onImpact(RayTraceResult position) {

        if(position.entityHit != null){
            if(position.entityHit instanceof EntityLivingBase) {
                position.entityHit.attackEntityFrom(EntityDamageSourceLaser.causeLaserDamage(this, this.getThrower()), 1 + dmg);
            }
            this.setDead();
        }
    }
}
