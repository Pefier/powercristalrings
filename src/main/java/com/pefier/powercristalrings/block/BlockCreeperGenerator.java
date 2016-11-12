package com.pefier.powercristalrings.block;

import com.pefier.powercristalrings.entity.tileentity.TileCreeperGenerator;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 10.11.2016.
 */
public class BlockCreeperGenerator extends BlockPCR implements ITileEntityProvider {

    private static final String name="creeper_generator";

    public BlockCreeperGenerator() {
        super();
        this.setRegistryName(Reference.MOD_ID,name);
        this.setUnlocalizedName(name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));
        GameRegistry.registerTileEntity(TileCreeperGenerator.class,name);

    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {

        return new TileCreeperGenerator(500);
    }
}
