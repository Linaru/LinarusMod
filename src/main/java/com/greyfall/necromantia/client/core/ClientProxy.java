package com.greyfall.necromantia.client.core;

import com.greyfall.necromantia.client.render.items.ItemCauldronRegister;
import com.greyfall.necromantia.client.render.tiles.TileEntityCauldronRenderer;
import com.greyfall.necromantia.common.core.CommonProxy;
import com.greyfall.necromantia.common.tiles.TileEntityCandleEntity;
import com.greyfall.necromantia.client.render.items.ItemCandleRegister;
import com.greyfall.necromantia.client.render.tiles.TileEntityCandleRenderer;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.mobs.EntityPinkslimeMob;
import com.greyfall.necromantia.client.render.mobs.EntityRenderPinkslimeMob;

import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void init()
	{
		super.init();
		RenderingRegistry.registerEntityRenderingHandler(EntityPinkslimeMob.class, new EntityRenderPinkslimeMob());

		Main.candleRenderID=RenderingRegistry.getNextAvailableRenderId();
		Main.cauldronRenderID=RenderingRegistry.getNextAvailableRenderId();


	}

	@Override
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandleEntity.class, new TileEntityCandleRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.blockCandle), new ItemCandleRegister());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCauldron.class, new TileEntityCauldronRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.blockCauldron),new ItemCauldronRegister());
	}


}
