package com.pefier.powercristalrings.block;

import com.pefier.powercristalrings.entity.tileentity.TileOreSpwaner;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 03.11.2016.
 */
public class BlockOreSpwaner extends BlockPCR implements ITileEntityProvider {

    private static final String name = "ore_spwaner";


    public BlockOreSpwaner() {
        super(Material.CIRCUITS);
        this.setRegistryName(Reference.MOD_ID,name);
        this.setUnlocalizedName(name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));
        GameRegistry.registerTileEntity(TileOreSpwaner.class,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);

    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileOreSpwaner();
    }


}
