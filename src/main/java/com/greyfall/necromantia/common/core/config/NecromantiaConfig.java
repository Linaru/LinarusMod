package com.greyfall.necromantia.common.core.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Katrina on 14/06/2015.
 */
public class NecromantiaConfig {

    public static int ironwoodForestBiomeID=60;

    public static Configuration config;



    public static void parseConfig(File file)
    {
        config=new Configuration(file);

        ironwoodForestBiomeID=config.getInt("Ironwood Forest Biome ID","Biomes",ironwoodForestBiomeID,0,1024,"Biome id for the ironwood forest");


        config.save();
    }
}
