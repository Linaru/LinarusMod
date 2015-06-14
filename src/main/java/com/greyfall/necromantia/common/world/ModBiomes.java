package com.greyfall.necromantia.common.world;

import com.greyfall.necromantia.common.biomes.BiomeIronwoodForest;
import com.greyfall.necromantia.common.core.config.NecromantiaConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

/**
 * Created by Katrina on 14/06/2015.
 */
public class ModBiomes {


    public static BiomeIronwoodForest biomeIronwoodForest;

    static
    {
        biomeIronwoodForest=new BiomeIronwoodForest(NecromantiaConfig.ironwoodForestBiomeID,true);
    }

    public static void registerBiomes()
    {
        BiomeDictionary.registerBiomeType(biomeIronwoodForest, BiomeDictionary.Type.FOREST);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(biomeIronwoodForest,10));
        BiomeManager.addSpawnBiome(biomeIronwoodForest);
    }
}
