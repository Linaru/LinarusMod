package com.greyfall.necromantia.common.core;

import com.greyfall.necromantia.common.Main;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void init()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.modInstance,new GuiHandler());
	}
	public void registerRenderThings() {

	}

}
