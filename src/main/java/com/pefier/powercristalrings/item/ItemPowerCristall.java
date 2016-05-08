package com.pefier.powercristalrings.item;


import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

/**
 * Created by New Profile on 28.03.2016.
 */
public class ItemPowerCristall extends ItemPCR {

    private static final String name ="PowerCristall";

    public ItemPowerCristall(){
        super();
        setUnlocalizedName(name);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setHasSubtypes(true);
        setMaxStackSize(64);

    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        subItems.add(new ItemStack(itemIn, 1, 0));
        subItems.add(new ItemStack(itemIn, 1, 1));
        subItems.add(new ItemStack(itemIn, 1, 2));
        subItems.add(new ItemStack(itemIn, 1, 3));
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        switch (stack.getItemDamage()){
            case 0: return super.getUnlocalizedName() + "." + ("Red");
            case 1: return super.getUnlocalizedName() + "." + ("Blue");
            case 2: return super.getUnlocalizedName() + "." + ("Green");
            case 3: return super.getUnlocalizedName() + "." + ("Yellow");
            default: return super.getUnlocalizedName() + "." + ("default");
        }


    }


}
