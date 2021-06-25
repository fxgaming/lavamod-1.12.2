package by.fxg.lavamod.util;

import net.minecraft.client.model.ModelBiped.ArmPose;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Utils {
	public static NBTTagCompound getTag(ItemStack par1ItemStack) {
		if (!par1ItemStack.hasTagCompound()) {
			NBTTagCompound nbtTagCompound = new NBTTagCompound();
			par1ItemStack.setTagCompound(nbtTagCompound);
		}
		return par1ItemStack.getTagCompound();
	}
	
	public static int getArmorSlot(EntityEquipmentSlot par1EntityEquipmentSlot) {
		switch (par1EntityEquipmentSlot) {
			case HEAD: return 0;
			case CHEST: return 1;
			case LEGS: return 2;
			case FEET: return 3;
			default: return -1;
		}
	}
	
	public static ArmPose getArmPose(int par1) {
		switch(par1) {
			case 0: return ArmPose.EMPTY;
			case 1: return ArmPose.ITEM;
			case 2: return ArmPose.BLOCK;
			case 3: return ArmPose.BOW_AND_ARROW;
			default: return ArmPose.EMPTY;
		}
	}
}
