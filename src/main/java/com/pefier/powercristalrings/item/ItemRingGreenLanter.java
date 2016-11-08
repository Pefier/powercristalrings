package com.pefier.powercristalrings.item;

import com.pefier.powercristalrings.capability.WillpowerProvider;
import com.pefier.powercristalrings.client.handler.ModSoundHandler;
import com.pefier.powercristalrings.entity.throwabel.EntityLaser;
import com.pefier.powercristalrings.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.UUID;

/**
 * Created by New Profile on 21.03.2016.
 */
public class ItemRingGreenLanter extends ItemPCR {

    private static final String name = "RingGreenLantern";

    private static UUID id = Reference.SPEED_MOD;


    public ItemRingGreenLanter(){
        super();
        setUnlocalizedName(name);
        setMaxStackSize(1);
        this.setRegistryName(Reference.MOD_ID,name);
        GameRegistry.register(this);
        setHasSubtypes(true);


    }

    public static String getName() {
        return name;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

        if(playerIn.isSneaking()) {

            if (itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).isStatus() && itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getWillpower() > 0) {
                activate(playerIn,itemStackIn);
                itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setStatus(false);

            } else {
                deActivate(playerIn,itemStackIn);
                itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setStatus(true);

            }

        }else{
            if(!itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).isStatus()&&  itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getWillpower() > 0){


                worldIn.playSound(playerIn,playerIn.posX,playerIn.posY,playerIn.posZ, ModSoundHandler.laser, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                if (!worldIn.isRemote) {

                    EntityLaser entityLaser = new EntityLaser(worldIn, playerIn);
                    entityLaser.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.3F, 0.0F);
                    worldIn.spawnEntityInWorld(entityLaser);
                    itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).consumeWillpower(15);

                }
            }

        }
            return new ActionResult<ItemStack>(EnumActionResult.PASS,itemStackIn);
    }

    @Override
    public void onUpdate(ItemStack itemStackIn, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(itemStackIn, worldIn, entityIn, itemSlot, isSelected);

        if ( itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getWillpower() > 0 && !itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).isStatus()) {
            itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).consumeWillpower(1);

        }
        if (itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getWillpower() <= 0) {
            if (entityIn instanceof EntityPlayer) {

                deActivate((EntityPlayer) entityIn, itemStackIn);
                itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).setStatus(true);
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + (stack.getItemDamage() == 0 ? "aktive" : "normal");
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        subItems.add(new ItemStack(itemIn, 1, 0));
        subItems.add(new ItemStack(itemIn, 1, 1));
    }

    /**Method gets called wenn Item gets Activated */
    private void activate(EntityPlayer playerIn, ItemStack itemStackIn){

        playerIn.capabilities.allowFlying = true;
        playerIn.capabilities.isFlying = true;
        if(playerIn.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getModifier(id) == null) {
            playerIn.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).applyModifier(new AttributeModifier(id,"Speedmod",itemStackIn.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getAttackSpeed(),0));
        }
        System.out.println("aktive");
        itemStackIn.setItemDamage(1);

    }

    /** */
    private void deActivate(EntityPlayer playerIn, ItemStack itemStackIn){

        playerIn.capabilities.allowFlying = false;
        playerIn.capabilities.isFlying = false;
        if(playerIn.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getModifier(id) != null) {
            playerIn.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).removeModifier(id);
        }

        System.out.println("inaktiv");
        itemStackIn.setItemDamage(0);

    }

    /**adds tolltip to item */
    @Override //is ClientSide only
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        tooltip.add("Press Shift for information");

        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)||Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            tooltip.add("Damage Reduction: " + stack.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY, null).getDmgReduction());
            tooltip.add("Attack Speed: "+stack.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getAttackSpeed());
            tooltip.add("Laser Damage: "+ stack.getCapability(WillpowerProvider.WILLPOWER_CAPABILITY,null).getDmgIncrease());
        }


    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new WillpowerProvider();
    }
}