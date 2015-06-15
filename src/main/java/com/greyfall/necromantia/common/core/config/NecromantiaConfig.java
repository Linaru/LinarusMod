package com.greyfall.necromantia.common.core.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Katrina on 14/06/2015.
 */
public class NecromantiaConfig {

    public static int ironwoodForestBiomeID=60;




    public static int etherealSanctuaryDimensionID=77;
    public static int etherealSanctuaryBiomeID =61;
    public static Configuration config;




    public static void parseConfig(File file)
    {
        config=new Configuration(file);

        ironwoodForestBiomeID=config.getInt("Ironwood Forest Biome ID","Biomes",ironwoodForestBiomeID,0,1024,"Biome id for the ironwood forest");
        etherealSanctuaryBiomeID =config.getInt("Ethereal Sanctuary Biome ID","Biomes",etherealSanctuaryBiomeID,0,1024,"Biome id for the Ethereal Sanctuary");
        etherealSanctuaryDimensionID=config.getInt("Ethereal Sanctuary Dimension ID","Dimensions",etherealSanctuaryDimensionID,2,100,"Dimension id for the Ethereal sanctuary");


        config.save();
    }
}
