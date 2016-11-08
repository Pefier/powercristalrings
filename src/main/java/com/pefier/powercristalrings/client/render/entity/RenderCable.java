package com.pefier.powercristalrings.client.render.entity;

import com.pefier.powercristalrings.entity.tileentity.TileCable;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


/**
 * Created by Pefier on 07.11.2016.
 */
public class RenderCable extends TileEntitySpecialRenderer<TileCable>{

    ResourceLocation resourceLocation = new ResourceLocation(Reference.MOD_ID,"textures/entity/cable.png" );
    float pixel= 1f/16f;
    float texturePixel = 1f/32f;

    @Override
    public void renderTileEntityAt(TileCable te, double x, double y, double z, float partialTicks, int destroyStage) {

        GL11.glTranslated(x,y,z);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.bindTexture(resourceLocation);

        drawCore(te);
        TileCable cable = (TileCable) te;
        for(int i=0;i<cable.connections.length;i++){
            if(cable.connections[i] != null){
                drawConection(cable.connections[i]);
            }

        }






        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glTranslated(-x,-y,-z);


    }

    public void drawConection(EnumFacing facing){







        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        {

            GL11.glTranslatef(0.5f,0.5f,0.5f);

            if(facing == EnumFacing.UP){

            }else if(facing == EnumFacing.DOWN){
                GL11.glRotatef(180f,1,0,0);
            }else if(facing == EnumFacing.NORTH){
                GL11.glRotatef(270f,1,0,0);
            }else if(facing == EnumFacing.SOUTH){
                GL11.glRotatef(90f,1,0,0);
            }else if (facing==EnumFacing.WEST){
                GL11.glRotatef(90f,0,0,1);
            }else if(facing==EnumFacing.EAST){
                GL11.glRotatef(270f,0,0,1);
            }
            GL11.glTranslatef(-0.5f,-0.5f,-0.5f);

            vertexbuffer.pos(1 - 11 * pixel / 2,1 - 11 * pixel / 2, 1-11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2, 1, 1-11 * pixel / 2).tex(10 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2, 1, 1 - 11 * pixel / 2).tex(10 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2, 1- 11 * pixel / 2, 1 - 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();

            vertexbuffer.pos(11 * pixel / 2, 1- 11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2, 1, 11 * pixel / 2).tex(10 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2, 1, 11 * pixel / 2).tex(10 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2,1 - 11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();

            vertexbuffer.pos(1-11 * pixel / 2, 1- 11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1-11 * pixel / 2, 1, 11 * pixel / 2).tex(10 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2, 1, 1-11 * pixel / 2).tex(10 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2,1 - 11 * pixel / 2, 1- 11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();

            vertexbuffer.pos(11 * pixel / 2,1 - 11 * pixel / 2, 1- 11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2, 1, 1-11 * pixel / 2).tex(10 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2, 1, 11 * pixel / 2).tex(10 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2, 1- 11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
        }
        tessellator.draw();
        GL11.glTranslatef(0.5f,0.5f,0.5f);

        if(facing == EnumFacing.UP){

        }else if(facing == EnumFacing.DOWN){
            GL11.glRotatef(-180f,1,0,0);
        }else if(facing == EnumFacing.NORTH){
            GL11.glRotatef(-270f,1,0,0);
        }else if(facing == EnumFacing.SOUTH){
            GL11.glRotatef(-90f,1,0,0);
        }else if (facing==EnumFacing.WEST){
            GL11.glRotatef(-90f,0,0,1);
        }else if(facing==EnumFacing.EAST) {
            GL11.glRotatef(-270f, 0, 0, 1);
        }
            GL11.glTranslatef(-0.5f,-0.5f,-0.5f);
    }


    public void drawCore(TileEntity tileEntity){

        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        {
            vertexbuffer.pos(1 - 11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2,1-11 * pixel / 2, 1-11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2,1-11 * pixel / 2, 1 - 11 * pixel / 2).tex(0 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2).tex(0 * texturePixel, 5 * texturePixel).endVertex();

            vertexbuffer.pos(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2,1-11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1-11 * pixel / 2,1-11 * pixel / 2, 1 - 11 * pixel / 2).tex(0 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1-11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2).tex(0 * texturePixel, 5 * texturePixel).endVertex();

            vertexbuffer.pos(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2,1-11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2,1-11 * pixel / 2, 11 * pixel / 2).tex(0 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2).tex(0 * texturePixel, 5 * texturePixel).endVertex();

            vertexbuffer.pos(11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2,1-11 * pixel / 2, 1 - 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2,1-11 * pixel / 2, 11 * pixel / 2).tex(0 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2).tex(0 * texturePixel, 5 * texturePixel).endVertex();

            vertexbuffer.pos(1 - 11 * pixel / 2,1 - 11 * pixel / 2, 1 - 11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2,1 - 11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2,1 - 11 * pixel / 2, 11 * pixel / 2).tex(0 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2,1 - 11 * pixel / 2,1 - 11 * pixel / 2).tex(0 * texturePixel, 5 * texturePixel).endVertex();

            vertexbuffer.pos(11 * pixel / 2,11 * pixel / 2,1 - 11 * pixel / 2).tex(5 * texturePixel, 5 * texturePixel).endVertex();
            vertexbuffer.pos(11 * pixel / 2,11 * pixel / 2, 11 * pixel / 2).tex(5 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2,11 * pixel / 2, 11 * pixel / 2).tex(0 * texturePixel, 0 * texturePixel).endVertex();
            vertexbuffer.pos(1 - 11 * pixel / 2,11 * pixel / 2, 1 - 11 * pixel / 2).tex(0 * texturePixel, 5 * texturePixel).endVertex();




        }
        tessellator.draw();

    }
}
