package by.fxg.lavamod.armors.items;

import java.util.List;

import javax.annotation.Nullable;

import by.fxg.lavamod.armors.models.ModelBaseArmor;
import by.fxg.lavamod.capability.ExtendedHandler;
import by.fxg.lavamod.capability.IExtendedPlayer;
import by.fxg.lavamod.managers.ModelManager;
import by.fxg.lavamod.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorBase extends ItemArmor {
	public int tick = 0;
	public int maxCharge;
	public String modelTexture;
	public float scale = 1.0F;
	
	public ItemArmorBase(EnumArmor par1EnumArmor, int par2MaxCharge, String par3String, String par4String) {
		super(ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.valueOf(par1EnumArmor.toString()));
		this.maxCharge = par2MaxCharge;
		this.modelTexture = par3String;
		this.maxStackSize = 1;
		this.setUnlocalizedName(par4String);
		this.setRegistryName(par4String);
		this.setNoRepair();
	}

	public void addInformation(ItemStack par1ItemStack, @Nullable World par2World, List<String> par3List, ITooltipFlag par4TooltipFlag) {
		par3List.add("" + this.getCharge(par1ItemStack) + "/" + this.maxCharge + " L");
	}
	
	public void onArmorTick(World par1World, EntityPlayer par2EntityPlayer, ItemStack par3ItemStack) {
		this.tick++;
		if (this.tick % 40 == 0) {
			this.tick = 0;
			if (!par1World.isRemote) {
				this.charge(par3ItemStack, 10);
			}
		}
	}
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4Slot, boolean par5Selected) {
    }
	
	public int getMaxCharge(ItemStack par1ItemStack) {
		return this.maxCharge;
	}
	
	public static int getCharge(ItemStack par1ItemStack) {
		return Utils.getTag(par1ItemStack).getInteger("charge");
	}
	
	public ItemArmorBase charge(ItemStack par1ItemStack, int par2) {
		NBTTagCompound var1NBTTagCompound = Utils.getTag(par1ItemStack);
		int var2 = var1NBTTagCompound.getInteger("charge");
		int var3 = this.getMaxCharge(par1ItemStack);
		if (var2 + par2 <= var3) var1NBTTagCompound.setInteger("charge", var2 + par2);
		else var1NBTTagCompound.setInteger("charge", var3);
		return this;
	}
	
	public ItemArmorBase discharge(ItemStack par1ItemStack, int par2) {
		NBTTagCompound var1NBTTagCompound = Utils.getTag(par1ItemStack);
		int var2 = var1NBTTagCompound.getInteger("charge");	
		if (var2 - par2 >= 0) var1NBTTagCompound.setInteger("charge", var2 - par2);
		else var1NBTTagCompound.setInteger("charge", 0);
		return this;
	}
	
	public ItemArmorBase setScale(float par1Scale) {
		this.scale = par1Scale;
		return this;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean onEntityItemUpdate(EntityItem par1EntityItem) {
		ParticleFlame.Factory factory = new ParticleFlame.Factory();
		Minecraft.getMinecraft().effectRenderer.addEffect(factory.createParticle(0, par1EntityItem.world, par1EntityItem.posX, par1EntityItem.posY, par1EntityItem.posZ, 0.0D, 0.0D, 0.0D));
		return super.onEntityItemUpdate(par1EntityItem);
	}

	@Nullable
	public String getArmorTexture(ItemStack par1ItemStack, Entity par2Entity, EntityEquipmentSlot par3EntityEquipmentSlot, String par4Type) {
		return "lavamod:textures/armors/" + this.modelTexture + ".png";
	}
	
	@SideOnly(Side.CLIENT)
    @Nullable
    public ModelBiped getArmorModel(EntityLivingBase par1Entity, ItemStack par2ItemStack, EntityEquipmentSlot par3EntityEquipmentSlot, ModelBiped par4ModelBiped) {
		ModelBaseArmor armorModel = (ModelBaseArmor)ModelManager.armorModels.get(this);
		IExtendedPlayer extendedPlayer = ExtendedHandler.getHandler(par1Entity);
		if (armorModel != null) {
			armorModel.bipedHeadwear.showModel = false;
			armorModel.bipedHead.showModel = Utils.getArmorSlot(par3EntityEquipmentSlot) == 0;
			armorModel.bipedBody.showModel = Utils.getArmorSlot(par3EntityEquipmentSlot) == 1 || Utils.getArmorSlot(par3EntityEquipmentSlot) == 2;
			armorModel.bipedRightArm.showModel = Utils.getArmorSlot(par3EntityEquipmentSlot) == 1;
			armorModel.bipedLeftArm.showModel = Utils.getArmorSlot(par3EntityEquipmentSlot) == 1;
			armorModel.bipedRightLeg.showModel = Utils.getArmorSlot(par3EntityEquipmentSlot) == 2 || Utils.getArmorSlot(par3EntityEquipmentSlot) == 3;
			armorModel.bipedLeftLeg.showModel = Utils.getArmorSlot(par3EntityEquipmentSlot) == 2 || Utils.getArmorSlot(par3EntityEquipmentSlot) == 3;
			armorModel.isSneak = par1Entity.isSneaking();
			armorModel.isRiding = par1Entity.isRiding();
			armorModel.isChild = par1Entity.isChild();
			armorModel.rightArmPose = Utils.getArmPose(0);
			EntityPlayer entityPlayer = (EntityPlayer)par1Entity;
			ItemStack heldItem = entityPlayer.getHeldItem(EnumHand.MAIN_HAND);
			if (heldItem != null) {
				switch (heldItem.getItemUseAction()) {
					case BLOCK: armorModel.rightArmPose = Utils.getArmPose(2); break;
					case BOW: armorModel.rightArmPose = Utils.getArmPose(3); break;
					default: armorModel.rightArmPose = Utils.getArmPose(1);
				}
			}
			heldItem = entityPlayer.getHeldItem(EnumHand.OFF_HAND);
			if (heldItem != null) {
				switch (heldItem.getItemUseAction()) {
					case BLOCK: armorModel.leftArmPose = Utils.getArmPose(2); break;
					case BOW: armorModel.leftArmPose = Utils.getArmPose(3); break;
					default: armorModel.leftArmPose = Utils.getArmPose(1);
				}
			}
		}
		armorModel.scale = this.scale;
		return armorModel;
    }
}
