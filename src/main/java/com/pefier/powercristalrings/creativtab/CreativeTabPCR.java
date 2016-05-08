package com.pefier.powercristalrings.creativtab;

import com.pefier.powercristalrings.init.ModItems;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by New Profile on 11.03.2016.
 */
public class CreativeTabPCR {

    public static final CreativeTabs MY_TAB = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return ModItems.powerCristallUnlocked;
        }
        @Override
        public String getTranslatedTabLabel(){
            return Reference.MOD_NAME ;
        }
    };
}
