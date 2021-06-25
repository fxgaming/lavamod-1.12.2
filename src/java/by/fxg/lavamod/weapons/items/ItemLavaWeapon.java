package by.fxg.lavamod.weapons.items;

import java.util.List;
import java.util.Random;

import by.fxg.lavamod.util.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.config.ConfigManager;

public class ItemLavaWeapon extends Item {
	public static Random rand = new Random();
	public static String icon;
	
	public ItemLavaWeapon(String par1String, String par2String) {
		this.icon = "textures/items/" + par1String + ".png";
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(par2String);
		this.setRegistryName(par2String);
	}
	
	public static void setItemSpecial(ItemStack i, Entity e) {
		NBTTagCompound n = Utils.getTag(i);
		if (!n.hasKey("special") && e != null) {
			n.setString("special", e.getName());
		}
	}
	
	public static void setItemSpecialTimed(ItemStack i, Entity e) {
		NBTTagCompound n = Utils.getTag(i);
		if (!n.hasKey("special") && e != null) {
			n.setString("special", e.getName());
		}
	}
	
	public static void setItemStaff(ItemStack i, Entity e) {
		NBTTagCompound n = Utils.getTag(i);
		if (!n.hasKey("staff") && e != null) {
			n.setString("staff", e.getName());
		}
	}
	
	public static void setItemSword(ItemStack i, Entity e) {
		NBTTagCompound n = Utils.getTag(i);
		if (!n.hasKey("sword") && e != null) {
			n.setString("sword", e.getName());
		}
	} 
	
	
	public static void setItemSpear(ItemStack i, Entity e) {
		NBTTagCompound n = Utils.getTag(i);
		if (!n.hasKey("spear") && e != null) {
			n.setString("spear", e.getName());
		}
	}
	
	public static void setItemHammer(ItemStack i, Entity e) {
		NBTTagCompound n = Utils.getTag(i);
		if (!n.hasKey("hammer") && e != null) {
			n.setString("hammer", e.getName());
		}
	}
//	
//	public static void setHero(ItemStack i, Entity e, World w) {
//		NBTTagCompound n = Utils.getTag(i);
//		if (!w.isRemote && !n.hasKey("life")) {
//			n.setLong("life", System.currentTimeMillis() + (Long.valueOf(86400 * ConfigManager.serverHeroItemDays) * 1000L));
//			n.setString("special", e.getName());
//		}
//	}
//	
//	public static void setHeroSpear(ItemStack i, Entity e, World w) {
//		//R>NEXT
//		NBTTagCompound n = Utils.getOrCreateNbtData(i);
//		if (!w.isRemote && !n.hasKey("life")) {
//			n.setLong("life", System.currentTimeMillis() + (Long.valueOf(86400 * ConfigManager.serverHeroItemDays) * 1000L));
//			n.setString("spear", e.getEntityName());
//		}
//		//R>STOP
//	}
	
	public static void setItemNoob(ItemStack i, Entity e, World w) {
		NBTTagCompound n = Utils.getTag(i);
		if (!w.isRemote) {
			if (!n.hasKey("special") && !n.hasKey("life")) {
				n.setString("special", e.getName());
				n.setLong("life", System.currentTimeMillis() + 259200000L);
				n.setInteger("specialid", rand.nextInt());
			} else if (n.getLong("life") < System.currentTimeMillis()) {
				if (e instanceof EntityPlayer) {
					for (int j = 0; j != ((EntityPlayer) e).inventory.getSizeInventory(); ++j) {
						//if (((EntityPlayer)e).inventory.getStackInSlot(j) != null && (((EntityPlayer)e).inventory.getStackInSlot(j).getItem() instanceof ItemNoobSword || ((EntityPlayer)e).inventory.getStackInSlot(j).getItem() instanceof ItemNoobRusher) && Utils.getOrCreateNbtData(((EntityPlayer) e).inventory.getStackInSlot(j)).getInteger("specialid") == n.getInteger("specialid")) {
						//	((EntityPlayer)e).inventory.setInventorySlotContents(j, (ItemStack) null);
						//}
					}
				}
			}
		}
	}
	   
	public static void setItemBow(ItemStack i, Entity e) {
		NBTTagCompound n = Utils.getTag(i);
		if (!n.hasKey("bow") && e != null) {
			n.setString("bow", e.getName());
		}
	}
	
	public void addOwner(List l, ItemStack i, String key) {
		l.add("§aИтем принадлежит: " + Utils.getTag(i).getString(key));
	}
	
	public void addOwnedText(List l, ItemStack i, String key) {
		l.add("§aИтем принадлежит: " + Utils.getTag(i).getString(key));
		l.add("§2Внимание!!!");
		l.add("§4Не покупайте с рук если видите это сообщение!!!");
	}
	
	public void addNonOwnedText(List l) {
		l.add("§aИтем принадлежит: Никому.");
		l.add("§2Внимание!!!");
		l.add("§4Итем привязывается автоматически");
		l.add("§4Не покупайте с рук если видите это сообщение!!!");
	}
	
	public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
		return false;
	}
	
	public boolean hasEffect(ItemStack par1ItemStack) {
		return false;
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return false;
	}

	public boolean isRepairable() {
		return false;
	}
	
	public int getItemEnchantability() {
		return 0;
	}
}
