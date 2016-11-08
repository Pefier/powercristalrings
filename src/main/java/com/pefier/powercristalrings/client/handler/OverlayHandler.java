package com.pefier.powercristalrings.client.handler;


import com.pefier.powercristalrings.capability.WillpowerProvider;
import com.pefier.powercristalrings.init.ModItems;
import com.pefier.powercristalrings.reference.Name;
import com.pefier.powercristalrings.reference.Reference;
import com.pefier.powercristalrings.utility.InventoryHelper;
import com.pefier.powercristalrings.utility.NBTHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Created by New Profile on 24.03.2016.
 */
public class OverlayHandler {

    @SubscribeEvent
    public void onRenderGameoverlay(RenderGameOverlayEvent event){

        if(!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE){
            Minecraft mc = Minecraft.getMinecraft();

            if(!mc.thePlayer.capabilities.isCreativeMode){

                if(InventoryHelper.hasItem(mc.thePlayer,ModItems.ringGreenLantern)){

                    ItemStack itemstackin = InventoryHelper.getItemStackinInventory(mc.thePlayer,ModItems.ringGreenLantern);
                    if(itemstackin.getMetadata()==1){

                        int amount = itemstackin.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getWillpower();
                        int max = itemstackin.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getMaxWillpower();
                        int y = max/35;
                        int x=0;
                        x=35 - amount/y;
                        //x=0 full bar x=35 empty bar



                        int posX = (event.getResolution().getScaledWidth()/2 +95);
                        int posY = (event.getResolution().getScaledHeight()-38);
                        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID+":textures/gui/bar.png"));
                        mc.ingameGUI.drawTexturedModalRect(posX,posY,0,0,49,37);

                        //0,38.49.36
                        mc.ingameGUI.drawTexturedModalRect(posX+2,posY+1+x,0,37+x,49,35);
                    }
                }
            }
        }
    }



}
