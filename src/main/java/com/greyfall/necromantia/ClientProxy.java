package com.greyfall.necromantia;

import com.greyfall.necromantia.mob.EntityPinkslimeMob;
import com.greyfall.necromantia.mob.EntityRenderPinkslimeMob;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void init()
	{
	RenderingRegistry.registerEntityRenderingHandler(EntityPinkslimeMob.class, new EntityRenderPinkslimeMob());
	}

	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandleEntity.class, new TileEntityCandleRenderer());
	}


}
