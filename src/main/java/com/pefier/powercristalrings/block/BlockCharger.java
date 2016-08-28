package com.pefier.powercristalrings.block;

import com.pefier.powercristalrings.PowerCristalRings;
import com.pefier.powercristalrings.entity.tileentity.TileCharger;
import com.pefier.powercristalrings.reference.Name;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by New Profile on 21.03.2016.
 */
public class BlockCharger extends BlockContainerPCR {

    private static final String name="Charger";

    public BlockCharger() {
        super(Material.CIRCUITS);
        setUnlocalizedName(name);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(Reference.MOD_ID,name));

        GameRegistry.registerTileEntity(TileCharger.class,name);
        this.setHardness(1.5F);
        this.setResistance(2000F);

    }

    public String getName() {
        return name;
    }




    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.isSneaking()){
            if (!worldIn.isRemote) {

                TileEntity tileEntity = worldIn.getTileEntity(pos);
                if (tileEntity instanceof TileCharger) {
                    playerIn.openGui(PowerCristalRings.instance, Name.GuiIDs.GUI_CHARGER, worldIn, pos.getX(), pos.getY(), pos.getZ());
                }
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileCharger();
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




}
