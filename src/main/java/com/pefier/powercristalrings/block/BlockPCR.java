package com.pefier.powercristalrings.block;


import com.pefier.powercristalrings.creativtab.CreativeTabPCR;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by New Profile on 21.03.2016.
 */
public class BlockPCR extends Block{


    public BlockPCR(Material materialIn) {
        super(materialIn);
        this.setCreativeTab(CreativeTabPCR.MY_TAB);
    }

    public BlockPCR() {
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}



