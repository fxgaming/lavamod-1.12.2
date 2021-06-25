package by.fxg.lavamod.items.render;

import com.evilnotch.iitemrender.handlers.IItemRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderItemClassic implements IItemRenderer {
	public void render(ItemStack stack, IBakedModel model, TransformType type, float partialTicks) {
		if (stack != null && stack.getItem() instanceof ItemLavaBase) {
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("", ((ItemLavaBase)stack.getItem()).itemTexture));
			if (type == type.FIRST_PERSON_RIGHT_HAND) {
				//this.renderItemIn2D(TessellatorOld.instance, par1, par2, par3, par4, par5, par6, par7);
			}
		}
	}

	public TransformPreset getTransformPreset() {
		return TransformPreset.FIXED;
	}
	
	public static void renderItemIn2D(TessellatorOld par0Tessellator, float par1, float par2, float par3, float par4, int par5, int par6, float par7) {
        par0Tessellator.startDrawingQuads();
        par0Tessellator.setNormal(0.0F, 0.0F, 1.0F);
        par0Tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, (double)par1, (double)par4);
        par0Tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, (double)par3, (double)par4);
        par0Tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, (double)par3, (double)par2);
        par0Tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, (double)par1, (double)par2);
        par0Tessellator.draw();
        par0Tessellator.startDrawingQuads();
        par0Tessellator.setNormal(0.0F, 0.0F, -1.0F);
        par0Tessellator.addVertexWithUV(0.0D, 1.0D, (double)(0.0F - par7), (double)par1, (double)par2);
        par0Tessellator.addVertexWithUV(1.0D, 1.0D, (double)(0.0F - par7), (double)par3, (double)par2);
        par0Tessellator.addVertexWithUV(1.0D, 0.0D, (double)(0.0F - par7), (double)par3, (double)par4);
        par0Tessellator.addVertexWithUV(0.0D, 0.0D, (double)(0.0F - par7), (double)par1, (double)par4);
        par0Tessellator.draw();
        float f5 = (float)par5 * (par1 - par3);
        float f6 = (float)par6 * (par4 - par2);
        par0Tessellator.startDrawingQuads();
        par0Tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        int k;
        float f7;
        float f8;
        for (k = 0; (float)k < f5; ++k) {
            f7 = (float)k / f5;
            f8 = par1 + (par3 - par1) * f7 - 0.5F / (float)par5;
            par0Tessellator.addVertexWithUV((double)f7, 0.0D, (double)(0.0F - par7), (double)f8, (double)par4);
            par0Tessellator.addVertexWithUV((double)f7, 0.0D, 0.0D, (double)f8, (double)par4);
            par0Tessellator.addVertexWithUV((double)f7, 1.0D, 0.0D, (double)f8, (double)par2);
            par0Tessellator.addVertexWithUV((double)f7, 1.0D, (double)(0.0F - par7), (double)f8, (double)par2);
        }
        par0Tessellator.draw();
        par0Tessellator.startDrawingQuads();
        par0Tessellator.setNormal(1.0F, 0.0F, 0.0F);
        float f9;
        for (k = 0; (float)k < f5; ++k) {
            f7 = (float)k / f5;
            f8 = par1 + (par3 - par1) * f7 - 0.5F / (float)par5;
            f9 = f7 + 1.0F / f5;
            par0Tessellator.addVertexWithUV((double)f9, 1.0D, (double)(0.0F - par7), (double)f8, (double)par2);
            par0Tessellator.addVertexWithUV((double)f9, 1.0D, 0.0D, (double)f8, (double)par2);
            par0Tessellator.addVertexWithUV((double)f9, 0.0D, 0.0D, (double)f8, (double)par4);
            par0Tessellator.addVertexWithUV((double)f9, 0.0D, (double)(0.0F - par7), (double)f8, (double)par4);
        }
        par0Tessellator.draw();
        par0Tessellator.startDrawingQuads();
        par0Tessellator.setNormal(0.0F, 1.0F, 0.0F);
        for (k = 0; (float)k < f6; ++k) {
            f7 = (float)k / f6;
            f8 = par4 + (par2 - par4) * f7 - 0.5F / (float)par6;
            f9 = f7 + 1.0F / f6;
            par0Tessellator.addVertexWithUV(0.0D, (double)f9, 0.0D, (double)par1, (double)f8);
            par0Tessellator.addVertexWithUV(1.0D, (double)f9, 0.0D, (double)par3, (double)f8);
            par0Tessellator.addVertexWithUV(1.0D, (double)f9, (double)(0.0F - par7), (double)par3, (double)f8);
            par0Tessellator.addVertexWithUV(0.0D, (double)f9, (double)(0.0F - par7), (double)par1, (double)f8);
        }
        par0Tessellator.draw();
        par0Tessellator.startDrawingQuads();
        par0Tessellator.setNormal(0.0F, -1.0F, 0.0F);
        for (k = 0; (float)k < f6; ++k) {
            f7 = (float)k / f6;
            f8 = par4 + (par2 - par4) * f7 - 0.5F / (float)par6;
            par0Tessellator.addVertexWithUV(1.0D, (double)f7, 0.0D, (double)par3, (double)f8);
            par0Tessellator.addVertexWithUV(0.0D, (double)f7, 0.0D, (double)par1, (double)f8);
            par0Tessellator.addVertexWithUV(0.0D, (double)f7, (double)(0.0F - par7), (double)par1, (double)f8);
            par0Tessellator.addVertexWithUV(1.0D, (double)f7, (double)(0.0F - par7), (double)par3, (double)f8);
        }
        par0Tessellator.draw();
    }
}
