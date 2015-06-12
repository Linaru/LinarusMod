package com.greyfall.necromantia.common.core;

import com.greyfall.necromantia.common.Main;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.world.World;

public class CommonProxy {
	
	public void init()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.modInstance,new GuiHandler());
	}
	public void registerRenderThings() {

	}


	public void spawnPinkSlimeParticle(World world,double x,double y,double z,double velX,double velY,double velZ)
	{

	}
}
