package by.fxg.lavamod;

import by.fxg.lavamod.capability.ExtendedHandler.ExtendedPlayer;
import by.fxg.lavamod.capability.ExtendedHandler.ExtendedStorage;
import by.fxg.lavamod.capability.IExtendedPlayer;
import by.fxg.lavamod.db.QFBDatabase;
import by.fxg.lavamod.managers.ItemManager;
import by.fxg.lavamod.managers.ModelManager;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "lavamod", name = "LavaMod-1122", version = "0.0.0.0")
public class LavaMod {
	@Instance("lavamod")
	public static LavaMod instance;
	@SidedProxy(clientSide = "by.fxg.lavamod.ProxyClient", serverSide = "by.fxg.lavamod.ProxyServer")
	public static ProxyServer proxy;
	public static QFBDatabase database;
	public static ItemManager itemManager;
	public static ModelManager modelManager;
	public ExtendedStorage extendedStorage;
	
	public LavaMod() {
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		this.database = new QFBDatabase();
		this.itemManager = new ItemManager().init();
		this.modelManager = new ModelManager();
		CapabilityManager.INSTANCE.register(IExtendedPlayer.class, this.extendedStorage = new ExtendedStorage(), ExtendedPlayer.class);
		proxy.init(this);
	}
}
