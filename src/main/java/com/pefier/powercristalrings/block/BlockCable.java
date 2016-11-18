package com.pefier.powercristalrings.block;

import com.pefier.powercristalrings.entity.tileentity.TileCable;
import com.pefier.powercristalrings.power.PowerGrid;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        TileEntity tileEntity =worldIn.getTileEntity(pos);
        if(tileEntity instanceof TileCable){
            ((TileCable)tileEntity).init();
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {

        TileCable cable = new TileCable();
        return cable;
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

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if(!worldIn.isRemote) {
            if (worldIn.getTileEntity(pos) instanceof TileCable) {
                ((TileCable) worldIn.getTileEntity(pos)).removeFromGrid();
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            if (worldIn.getTileEntity(pos) instanceof TileCable) {
                System.out.println(pos.toLong());
            }
        }




        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }
}
