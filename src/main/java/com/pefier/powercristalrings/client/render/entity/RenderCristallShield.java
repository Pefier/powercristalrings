package com.pefier.powercristalrings.client.render.entity;

import com.pefier.powercristalrings.client.render.model.ModelCristallShield;
import com.pefier.powercristalrings.entity.throwabel.EntityCristallShield;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * Created by Pefier on 31.08.2016.
 */
public class RenderCristallShield extends Render<EntityCristallShield> {

    private static final ResourceLocation shieldTextur= new ResourceLocation(Reference.MOD_ID,"textures/entity/cristall_shield.png");

    private ModelBase model= new ModelCristallShield();

    public static Factory FACTORY = new Factory();

    protected RenderCristallShield(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityCristallShield entity, double x, double y, double z, float entityYaw, float partialTicks) {


        this.bindEntityTexture(entity);

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x,(float)y,(float)z);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);

        float f8 = 0.08625F; /** Scale  */

        GlStateManager.enableRescaleNormal();
        //GlStateManager.translate(-4.0F, 0.0F, 0.0F);
        //GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);
        //GlStateManager.scale(f8, f8, f8);
        //GlStateManager.translate(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(f8, 0.0F, 0.0F);
        model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();







        super.doRender(entity, x, y, z, entityYaw, partialTicks);

    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCristallShield entity) {
        return shieldTextur;
    }
    public static class Factory implements IRenderFactory {


        @Override
        public Render createRenderFor(RenderManager manager) {
            return new RenderCristallShield(manager);
        }
    }
}
