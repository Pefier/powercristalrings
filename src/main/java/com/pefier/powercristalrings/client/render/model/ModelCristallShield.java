package com.pefier.powercristalrings.client.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by Pefier on 02.10.2016.
 */
public class ModelCristallShield extends ModelBase {
    public ModelRenderer Middel;
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape1_4;
    public ModelRenderer shape1_5;

    public ModelCristallShield() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1_4 = new ModelRenderer(this, 0, 9);
        this.shape1_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_4.addBox(-6.0F, 0.0F, -5.0F, 12, 1, 1, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 36, 2);
        this.shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_1.addBox(-5.0F, 0.0F, 5.0F, 10, 1, 1, 0.0F);
        this.shape1 = new ModelRenderer(this, 36, 0);
        this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1.addBox(-4.0F, 0.0F, 6.0F, 8, 1, 1, 0.0F);
        this.shape1_3 = new ModelRenderer(this, 36, 6);
        this.shape1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_3.addBox(-5.0F, 0.0F, -6.0F, 10, 1, 1, 0.0F);
        this.Middel = new ModelRenderer(this, 0, 0);
        this.Middel.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Middel.addBox(-7.0F, 0.0F, -4.0F, 14, 1, 8, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 36, 4);
        this.shape1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_2.addBox(-4.0F, 0.0F, -7.0F, 8, 1, 1, 0.0F);
        this.shape1_5 = new ModelRenderer(this, 26, 9);
        this.shape1_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_5.addBox(-6.0F, 0.0F, 4.0F, 12, 1, 1, 0.0F);
        this.Middel.addChild(this.shape1_4);
        this.Middel.addChild(this.shape1_1);
        this.Middel.addChild(this.shape1);
        this.Middel.addChild(this.shape1_3);
        this.Middel.addChild(this.shape1_2);
        this.Middel.addChild(this.shape1_5);
    }



    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Middel.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }



}
