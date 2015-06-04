package com.greyfall.necromantia;

import com.greyfall.necromantia.client.ItemCandleRegister;
import com.greyfall.necromantia.mob.EntityPinkslimeMob;
import com.greyfall.necromantia.mob.EntityRenderPinkslimeMob;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void init()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPinkslimeMob.class, new EntityRenderPinkslimeMob());
		Main.candleRenderID=RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandleEntity.class, new TileEntityCandleRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.blockCandle),new ItemCandleRegister());
	}


}
