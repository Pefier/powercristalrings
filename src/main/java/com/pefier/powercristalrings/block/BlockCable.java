package com.pefier.powercristalrings.block;

import com.pefier.powercristalrings.entity.tileentity.TileCable;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;


/**
 * Created by Pefier on 07.11.2016.
 */
public class BlockCable extends BlockPCR implements ITileEntityProvider {

    private static final String name = "power_cable";

    private float pixel = 1f/16f;

    public BlockCable() {
        super(Material.CIRCUITS);
        this.setRegistryName(Reference.MOD_ID, name);
        this.setUnlocalizedName(name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));
        GameRegistry.registerTileEntity(TileCable.class,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);
        this.useNeighborBrightness=true;



    }



    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(11*pixel/2,11*pixel/2,11*pixel/2,1-11*pixel/2,1-11*pixel/2,1-11*pixel/2);
    }



    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {


        return new TileCable(200);
    }

    @Override
    public boolean isFullyOpaque(IBlockState state) {
        return super.isFullyOpaque(state);
    }


    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }



}
