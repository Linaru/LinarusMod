package com.greyfall.necromantia.common.dimensions;

import com.greyfall.necromantia.common.core.config.NecromantiaConfig;
import net.minecraftforge.common.DimensionManager;


public class DimensionRegistry {

    public static void mainRegistry()
    {
        registerDimension();
    }


    public static void registerDimension()
    {
        DimensionManager.registerProviderType(NecromantiaConfig.etherealSanctuaryDimensionID, NecromantiaWorldProvider.class, false);
        DimensionManager.registerDimension(NecromantiaConfig.etherealSanctuaryDimensionID, NecromantiaConfig.etherealSanctuaryDimensionID);
    }
}
