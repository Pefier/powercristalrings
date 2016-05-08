package com.pefier.powercristalrings.item;

import com.pefier.powercristalrings.creativtab.CreativeTabPCR;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by New Profile on 13.03.2016.
 */
public class ItemPCR extends Item {


    public ItemPCR()
    {
        super();
        this.setCreativeTab(CreativeTabPCR.MY_TAB);
    }

    @Override
        public String getUnlocalizedName()
        {
            return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }



}
