package by.fxg.lavamod.managers;

import by.fxg.lavamod.armors.items.EnumArmor;
import by.fxg.lavamod.armors.items.ItemArmorBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.GameData;

public class ItemManager {
	public static Item itemHelmetTest;
	public static Item itemHelmetTest1;
	public static Item itemHelmetTest2;
	public static Item itemHelmetTest3;
	public ItemManager init() {
		itemHelmetTest = new ItemArmorBase(EnumArmor.HEAD, 5000, "ultima", "testhelmet");
		ForgeRegistries.ITEMS.register(this.itemHelmetTest);
		itemHelmetTest1 = new ItemArmorBase(EnumArmor.CHEST, 5000, "ultima", "testhelmet1");
		ForgeRegistries.ITEMS.register(this.itemHelmetTest1);
		itemHelmetTest2 = new ItemArmorBase(EnumArmor.LEGS, 5000, "ultima", "testhelmet2");
		ForgeRegistries.ITEMS.register(this.itemHelmetTest2);
		itemHelmetTest3 = new ItemArmorBase(EnumArmor.BOOTS, 5000, "ultima", "testhelmet3");
		ForgeRegistries.ITEMS.register(this.itemHelmetTest3);
		return this;
	}
}
