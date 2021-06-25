package by.fxg.lavamod.armors.models;

import org.lwjgl.opengl.GL11;

import by.fxg.lavamod.capability.ExtendedHandler;
import by.fxg.lavamod.capability.IExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelBaseArmor extends ModelBiped {
	public float scale = 1.0F;
	public int color;
	
	public void render(Entity par1Entity, float par2LimbSwing, float par3LSAmount, float par4Age, float par5NetHeadYaw, float par6HeadPitch, float par7Scale) {
		IExtendedPlayer epl = ExtendedHandler.getHandler(par1Entity);
		if (this.color > 0) {
			int s = (this.getRGBvalues(this.color)[0] * 65536) + (this.getRGBvalues(this.color)[1] * 256) + this.getRGBvalues(this.color)[2];
			GL11.glColor4f((s >> 16) / 255.0F, (s >> 8 & 0xFF) / 255.0F, (s & 0xFF) / 255.0F, 1.0F);
			GL11.glEnable(36281);
			GL11.glScalef(this.scale, this.scale, this.scale);
			super.render(par1Entity, par2LimbSwing, par3LSAmount, par4Age, par5NetHeadYaw, par6HeadPitch, par7Scale);
			GL11.glDisable(36281);
		} else {
			GL11.glScalef(this.scale, this.scale, this.scale);
			super.render(par1Entity, par2LimbSwing, par3LSAmount, par4Age, par5NetHeadYaw, par6HeadPitch, par7Scale);
		}
    }

	public String getTexture() {
		return null;
	}

	private int[] getRGBvalues(int i) {
		switch (i) {
			case 1:
				return new int[] {255, 255, 255};
			case 2:
				return new int[] {255, 50, 0};
			case 3:
				return new int[] {255, 10, 40};
			case 4:
				return new int[] {20, 255, 255};
			case 5:
				return new int[] {98, 221, 0};
			case 6:
				return new int[] {255, 255, 0};
			case 7:
				return new int[] {255, 0, 127};
			case 8:
				return new int[] {20, 20, 20};
			case 9:
				return new int[] {100, 100, 100};
			case 10:
				return new int[] { 40, 127, 90 };
			case 11:
				return new int[] { 200, 0, 170 };
			case 12:
				return new int[] { 0, 0, 255 };
			case 13:
				return new int[] { 20, 1, 1 };
			case 14:
				return new int[] { 0, 200, 0 };
			case 15:
				return new int[] { 255, 0, 0 };
			case 16:
				return new int[] { 1, 1, 1 };
			default:
				return new int[] { 0, 0, 0 };
		}
	}
}
