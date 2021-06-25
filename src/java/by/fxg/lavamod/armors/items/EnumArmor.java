package by.fxg.lavamod.armors.items;

public enum EnumArmor {
	HEAD,
	CHEST,
	LEGS,
	BOOTS;
	
	public String toString() {
		switch (this) {
			case HEAD: return "HEAD";
			case CHEST: return "CHEST";
			case LEGS: return "LEGS";
			case BOOTS: return "FEET";
		}
		return "HEAD";
	}
}
