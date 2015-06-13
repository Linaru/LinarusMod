package com.greyfall.necromantia.client.core;

import com.greyfall.necromantia.client.render.items.ItemCauldronRegister;
import com.greyfall.necromantia.client.render.particles.EntityFXPinkSlime;
import com.greyfall.necromantia.client.render.tiles.TileEntityCauldronRenderer;
import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.core.CommonProxy;
import com.greyfall.necromantia.common.tiles.TileEntityCandle;
import com.greyfall.necromantia.client.render.items.ItemCandleRegister;
import com.greyfall.necromantia.client.render.tiles.TileEntityCandleRenderer;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.mobs.EntityPinkslimeMob;
import com.greyfall.necromantia.client.render.mobs.EntityRenderPinkslimeMob;

import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.world.World;
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
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandle.class, new TileEntityCandleRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.candle), new ItemCandleRegister());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCauldron.class, new TileEntityCauldronRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cauldron),new ItemCauldronRegister());
	}


	@Override
	public void spawnPinkSlimeParticle(World world, double x, double y, double z, double velX, double velY, double velZ) {
		EntityFXPinkSlime slimeFX=new EntityFXPinkSlime(world,x,y,z,velX,velY,velZ);

		Minecraft.getMinecraft().effectRenderer.addEffect(slimeFX);
	}
}
