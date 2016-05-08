package com.pefier.powercristalrings.client.gui;


import com.pefier.powercristalrings.container.ContainerCharger;
import com.pefier.powercristalrings.container.ContainerCirstallForge;
import com.pefier.powercristalrings.container.ContainerCraftingSurface;
import com.pefier.powercristalrings.entity.tileentity.TileCharger;
import com.pefier.powercristalrings.entity.tileentity.TileCristallForge;
import com.pefier.powercristalrings.reference.Name;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by New Profile on 24.03.2016.
 */
public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID){
            case Name.GuiIDs.GUI_CHARGER: return new ContainerCharger(player.inventory, (TileCharger) world.getTileEntity(new BlockPos(x,y,z)));
            case Name.GuiIDs.GUI_CRAFTING_SURFACE: return new ContainerCraftingSurface(player.inventory,world, x,y,z);
            case Name.GuiIDs.GUI_CRISTALLFORGE: return  new ContainerCirstallForge(player.inventory,(TileCristallForge)world.getTileEntity(new BlockPos(x,y,z)));
            default: return null;
        }




    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case Name.GuiIDs.GUI_CHARGER: return new GuiCharger(new ContainerCharger(player.inventory, (TileCharger) world.getTileEntity(new BlockPos(x,y,z))));
            case Name.GuiIDs.GUI_CRAFTING_SURFACE:return new GuiCraftingSurface(new ContainerCraftingSurface(player.inventory,world, x,y,z));
            case Name.GuiIDs.GUI_CRISTALLFORGE: return  new GuiCristallForge(player.inventory, (TileCristallForge)world.getTileEntity(new BlockPos(x,y,z)));
            default: return null;
        }
    }
}
