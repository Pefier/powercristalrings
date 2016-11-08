package com.pefier.powercristalrings.client.render.entity;

import com.pefier.powercristalrings.entity.throwabel.EntityLaser;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by New Profile on 13.04.2016.
 */
public class RenderLaser extends Render<EntityLaser> {

    private static final ResourceLocation laserTextures = new ResourceLocation(Reference.MOD_ID, "textures/entity/laser.png");

    public static Factory FACTORY = new Factory();

    protected RenderLaser(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityLaser entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.bindEntityTexture(entity);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();

        int i = 0;

        float f = 0.0F;
        float f1 = 0.5F;
        float f2 = (float)(0 + i * 10) / 32.0F;
        float f3 = (float)(5 + i * 10) / 32.0F;
        float f4 = 0.0F;
        float f5 = 0.15625F;
        float f6 = (float)(5 + i * 10) / 32.0F;
        float f7 = (float)(10 + i * 10) / 32.0F;
        float f8 = 0.05625F;

        GlStateManager.enableRescaleNormal();

        GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(f8, f8, f8);
        GlStateManager.translate(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(f8, 0.0F, 0.0F);
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        vertexbuffer.pos(-7.0D, -2.0D, -2.0D).tex((double)f4, (double)f6).endVertex();
        vertexbuffer.pos(-7.0D, -2.0D, 2.0D).tex((double)f5, (double)f6).endVertex();
        vertexbuffer.pos(-7.0D, 2.0D, 2.0D).tex((double)f5, (double)f7).endVertex();
        vertexbuffer.pos(-7.0D, 2.0D, -2.0D).tex((double)f4, (double)f7).endVertex();
        tessellator.draw();
        GL11.glNormal3f(-f8, 0.0F, 0.0F);
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        vertexbuffer.pos(-7.0D, 2.0D, -2.0D).tex((double)f4, (double)f6).endVertex();
        vertexbuffer.pos(-7.0D, 2.0D, 2.0D).tex((double)f5, (double)f6).endVertex();
        vertexbuffer.pos(-7.0D, -2.0D, 2.0D).tex((double)f5, (double)f7).endVertex();
        vertexbuffer.pos(-7.0D, -2.0D, -2.0D).tex((double)f4, (double)f7).endVertex();
        tessellator.draw();

        for (int j = 0; j < 4; ++j)
        {
            GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f8);
            vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
            vertexbuffer.pos(-8.0D, -2.0D, 0.0D).tex((double)f, (double)f2).endVertex();
            vertexbuffer.pos(8.0D, -2.0D, 0.0D).tex((double)f1, (double)f2).endVertex();
            vertexbuffer.pos(8.0D, 2.0D, 0.0D).tex((double)f1, (double)f3).endVertex();
            vertexbuffer.pos(-8.0D, 2.0D, 0.0D).tex((double)f, (double)f3).endVertex();
            tessellator.draw();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLaser entity) {
        return laserTextures;
    }



    public static class Factory implements IRenderFactory{


        @Override
        public Render createRenderFor(RenderManager manager) {
            return new RenderLaser(manager);
        }
    }
}