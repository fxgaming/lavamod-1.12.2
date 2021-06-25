package by.fxg.lavamod.items.render;

import com.evilnotch.iitemrender.handlers.IItemRendererHandler;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class ItemLavaBase extends Item {
	public String itemTexture;
	public ItemLavaBase(String par1String, String par2String) {
		this.itemTexture = "textures/items/" + par1String + ".png";
		this.setUnlocalizedName(par2String);
		this.setRegistryName(par2String);
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			IItemRendererHandler.register(this, new RenderItemClassic());
		}
	}
}
