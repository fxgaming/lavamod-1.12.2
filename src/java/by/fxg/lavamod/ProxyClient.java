package by.fxg.lavamod;

import by.fxg.lavamod.items.render.TessellatorOld;

public class ProxyClient extends ProxyServer {
	public TessellatorOld tessellator;
	public void init(LavaMod par1LavaMod) {
		this.tessellator = new TessellatorOld();
		par1LavaMod.modelManager.init(par1LavaMod);
	}
}
