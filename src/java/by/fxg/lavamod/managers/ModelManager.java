package by.fxg.lavamod.managers;

import java.util.HashMap;

import by.fxg.lavamod.LavaMod;
import by.fxg.lavamod.armors.models.ModelBaseArmor;
import by.fxg.lavamod.armors.models.ModelUltimaBoots;
import by.fxg.lavamod.armors.models.ModelUltimaChest;
import by.fxg.lavamod.armors.models.ModelUltimaHelmet;
import by.fxg.lavamod.armors.models.ModelUltimaLeggins;
import net.minecraft.item.Item;

public class ModelManager {
	public static HashMap<Item, ModelBaseArmor> armorModels = new HashMap<>();
	
	public ModelManager init(LavaMod par1LavaMod) {
		//IItemRendererHandler.register(par1LavaMod.itemManager.itemHelmetTest, null);
		armorModels.put(par1LavaMod.itemManager.itemHelmetTest, new ModelUltimaHelmet());
		armorModels.put(par1LavaMod.itemManager.itemHelmetTest1, new ModelUltimaChest());
		armorModels.put(par1LavaMod.itemManager.itemHelmetTest2, new ModelUltimaLeggins());
		armorModels.put(par1LavaMod.itemManager.itemHelmetTest3, new ModelUltimaBoots());
		return this;
	}
}
