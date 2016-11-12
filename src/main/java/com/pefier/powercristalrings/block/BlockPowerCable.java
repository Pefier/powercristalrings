package com.pefier.powercristalrings.block;

import com.pefier.powercristalrings.entity.tileentity.TileEntityPower;
import com.pefier.powercristalrings.entity.tileentity.TileEntityPowerCable;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

/**
 * Created by Pefier on 12.11.2016.
 */
public class BlockPowerCable extends BlockPCR implements ITileEntityProvider{

    private static final String name ="power_cable_test";

    public BlockPowerCable() {
        super(Material.CIRCUITS);
        setRegistryName(Reference.MOD_ID,name);
        setUnlocalizedName(name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));
        GameRegistry.registerTileEntity(TileEntityPowerCable.class,name);
        GameRegistry.registerTileEntity(TileEntityPower.class,"power");

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote)
        {
            TileEntity tile = worldIn.getTileEntity(pos);
            if(tile instanceof TileEntityPowerCable)
            {
                System.out.println("Network is holding " + ((TileEntityPowerCable)tile).getPower());
                return true;
            }
            return false;
        }
        return false;



    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPowerCable();
    }
}
