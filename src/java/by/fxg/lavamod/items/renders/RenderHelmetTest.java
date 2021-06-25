package by.fxg.lavamod.items.renders;

import com.evilnotch.iitemrender.handlers.IItemRenderer;

import by.fxg.lavamod.armors.models.ModelUltimaHelmet;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;

public class RenderHelmetTest implements IItemRenderer {
	public ModelUltimaHelmet model = new ModelUltimaHelmet();
	public void render(ItemStack stack, IBakedModel model, TransformType type, float partialTicks) {
		if (type == type.FIRST_PERSON_RIGHT_HAND) {
			
		}
	}

	public TransformPreset getTransformPreset() {
		return TransformPreset.FIXED;
	}
}
