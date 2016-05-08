package com.pefier.powercristalrings.client.gui;


import com.pefier.powercristalrings.handler.ConfigurationHandler;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

/**
 * Created by New Profile on 06.03.2016.
 */
public class ModGuiConfig extends GuiConfig {
    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MOD_ID, "1", false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
