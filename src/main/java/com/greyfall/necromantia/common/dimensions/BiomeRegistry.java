package com.greyfall.necromantia.common.dimensions;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {

    public static void mainRegistry(){
        initializeBiome();
        registerBiome();
    }

    public static BiomeGenBase biomeEtherealsanctuary;

    public static void initializeBiome(){

        biomeEtherealsanctuary = new BiomegenEtherealsanctuary(777).setBiomeName("Ethereal Sanctuary").setTemperatureRainfall(1.2F, 0.9F);

    }

    public static void registerBiome(){
        BiomeDictionary.registerBiomeType(biomeEtherealsanctuary, BiomeDictionary.Type.END);
        BiomeManager.addSpawnBiome(biomeEtherealsanctuary);
    }

}
