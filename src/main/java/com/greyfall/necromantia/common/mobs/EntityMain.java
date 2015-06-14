package com.greyfall.necromantia.common.mobs;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.world.ModBiomes;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;



public class EntityMain {
	
	public static void mainRegistry()
	{
		registerEntity();
	}

	public static void registerEntity()
	{
		createEntity(EntityPinkslimeMob.class, "PinkSlime", 0xb47ec1, 0xc799d7, ModBiomes.biomeIronwoodForest);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor,BiomeGenBase... biomes)
	{
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, Main.modInstance, 64, 1, true);
		for(BiomeGenBase base:biomes)
			EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.creature, base);
		
		createEgg(randomId, solidColor, spotColor);
	}
	
	private static void createEgg(int randomId, int solidColor, int spotColor)
	{
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	}
	
}
