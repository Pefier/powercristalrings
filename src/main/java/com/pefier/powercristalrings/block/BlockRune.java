package com.pefier.powercristalrings.block;

import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 22.08.2016.
 */
public class BlockRune extends BlockPCR {

    private static final String name = "Rune";

    public BlockRune(){
        super(Material.CIRCUITS);
        setUnlocalizedName(name);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));

    }




}
