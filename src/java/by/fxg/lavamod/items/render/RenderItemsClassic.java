package by.fxg.lavamod.items.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;

public class RenderItemsClassic extends TileEntityItemStackRenderer {
	public IModelClassic model;
	public RenderItemsClassic(IModelClassic model) {
		this.model = model;
	}
}
