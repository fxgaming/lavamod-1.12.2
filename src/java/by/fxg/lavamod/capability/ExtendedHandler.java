package by.fxg.lavamod.capability;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ExtendedHandler implements ICapabilitySerializable<NBTTagCompound> {
	  @CapabilityInject(IExtendedPlayer.class)
	  public static final Capability<IExtendedPlayer> CAP_EXTENDEDPLAYER = null;
	  public IExtendedPlayer iExtendedPlayer = CAP_EXTENDEDPLAYER.getDefaultInstance();
	  
	  public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
          return capability == CAP_EXTENDEDPLAYER;
      }

      public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
          return hasCapability(capability, facing) ? CAP_EXTENDEDPLAYER.<T>cast(this.iExtendedPlayer) : null;
      }

      public NBTTagCompound serializeNBT() {
          return (NBTTagCompound)CAP_EXTENDEDPLAYER.getStorage().writeNBT(CAP_EXTENDEDPLAYER, this.iExtendedPlayer, null);
      }

      public void deserializeNBT(NBTTagCompound nbt) {
    	  CAP_EXTENDEDPLAYER.getStorage().readNBT(CAP_EXTENDEDPLAYER, this.iExtendedPlayer, null, nbt);
      }
	  
	  public static class ExtendedStorage implements Capability.IStorage<IExtendedPlayer> {
		  public NBTBase writeNBT(Capability<IExtendedPlayer> par1Capability, IExtendedPlayer par2IExtendedPlayer, EnumFacing par3EnumFacing) {
			  NBTTagCompound nbtTagCompound = new NBTTagCompound();
			  nbtTagCompound.setInteger("coins", par2IExtendedPlayer.getCoins());
			  nbtTagCompound.setInteger("kills", par2IExtendedPlayer.getKills());
			  nbtTagCompound.setInteger("deaths", par2IExtendedPlayer.getDeaths());
			  nbtTagCompound.setBoolean("predatorInvise", par2IExtendedPlayer.getPredatorInvise());
			  return nbtTagCompound;
		  }

		  public void readNBT(Capability<IExtendedPlayer> par1Capability, IExtendedPlayer par2IExtendedPlayer, EnumFacing par3EnumFacing, NBTBase par4NBTBase) {
			  NBTTagCompound nbtTagCompound = (NBTTagCompound)par4NBTBase;
			  par2IExtendedPlayer.setCoins(nbtTagCompound.getInteger("coins"));
			  par2IExtendedPlayer.setKills(nbtTagCompound.getInteger("kills"));
			  par2IExtendedPlayer.setDeaths(nbtTagCompound.getInteger("deaths"));
			  par2IExtendedPlayer.setPredatorInvise(nbtTagCompound.getBoolean("predatorInvise"));
		  }
	  }
	  
	  public static IExtendedPlayer getHandler(Entity entity) {
		  if (entity.hasCapability(ExtendedHandler.CAP_EXTENDEDPLAYER, EnumFacing.DOWN)) return entity.getCapability(ExtendedHandler.CAP_EXTENDEDPLAYER, EnumFacing.DOWN);
		  return null;
	  }
	  
	  public class ExtendedPlayer implements IExtendedPlayer {
		  public int coins;
		  public int kills;
		  public int deaths;
		  public boolean predatorInvise;
		  
		  public int getCoins() { return this.coins; }
		  public int getKills() { return this.kills; }
		  public int getDeaths() { return this.deaths; }
		  public boolean getPredatorInvise() { return this.predatorInvise; }
		  public void setCoins(int par1) { this.coins = par1; }
		  public void setKills(int par1) { this.kills = par1; }
		  public void setDeaths(int par1) { this.deaths = par1; }
		  public void setPredatorInvise(boolean par2) { this.predatorInvise = par2; }
	  }
}
