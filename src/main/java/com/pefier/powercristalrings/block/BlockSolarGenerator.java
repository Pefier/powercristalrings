package com.pefier.powercristalrings.block;

import com.pefier.powercristalrings.entity.tileentity.TileSolarGenerator;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pefier on 08.11.2016.
 */
public class BlockSolarGenerator extends BlockPCR implements ITileEntityProvider{

    private static final String name= "solar_generator";

    public BlockSolarGenerator() {
        this.setRegistryName(Reference.MOD_ID, name);
        this.setUnlocalizedName(name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));
        GameRegistry.registerTileEntity(TileSolarGenerator.class,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileSolarGenerator();


    }


    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

}
