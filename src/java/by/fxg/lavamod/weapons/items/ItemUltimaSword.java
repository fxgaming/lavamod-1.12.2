package by.fxg.lavamod.weapons.items;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Nullable;

import by.fxg.lavamod.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUltimaSword extends ItemLavaWeapon {
	public ItemUltimaSword(String par1String, String par2String) {
		super(par1String, par2String);
		this.setMaxDamage(1000);
	}

	public void addInformation(ItemStack par1ItemStack, @Nullable World par2World, List<String> par3List, ITooltipFlag par4TooltipFlag) {
		if (Utils.getTag(par1ItemStack).hasKey("sword")) this.addOwnedText(par3List, par1ItemStack, "sword");
		else this.addNonOwnedText(par3List);
		par3List.add("§cУрон от меча: 800");
		par3List.add("§cУровень: " + Utils.getTag(par1ItemStack).getInteger("up"));
	}
	
	public boolean onLeftClickEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, Entity par3Entity) {
		if (!par2EntityPlayer.world.isRemote) {
			if (Utils.getTag(par1ItemStack).hasKey("sword") && Utils.getTag(par1ItemStack).getString("sword").equals(par2EntityPlayer.getName())) {
				if (par3Entity.attackEntityFrom(DamageSource.causePlayerDamage(par2EntityPlayer), 800)) {
				}
				return true;
			}
		}
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean onEntityItemUpdate(EntityItem par1EntityItem) {
		ParticleFlame.Factory factory = new ParticleFlame.Factory();
		Minecraft.getMinecraft().effectRenderer.addEffect(factory.createParticle(0, par1EntityItem.world, par1EntityItem.posX, par1EntityItem.posY, par1EntityItem.posZ, 0.0D, 0.0D, 0.0D));
		return super.onEntityItemUpdate(par1EntityItem);
	}
	
	public void onUpdate(ItemStack i, World w, Entity e, int par4, boolean par5) {
		super.onUpdate(i, w, e, par4, par5);
		setItemSword(i, e);
	}
}
