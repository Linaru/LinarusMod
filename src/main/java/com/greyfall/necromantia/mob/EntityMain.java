package com.greyfall.necromantia.mob;

import com.greyfall.necromantia.Main;
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
		createEntity(EntityPinkslimeMob.class, "PinkSlime", 0xb47ec1, 0xc799d7);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor)
	{
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, Main.modInstance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.forest);
		
		createEgg(randomId, solidColor, spotColor);
	}
	
	private static void createEgg(int randomId, int solidColor, int spotColor)
	{
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	}
	
}
