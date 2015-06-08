package com.greyfall.necromantia.common.dimensions;

import net.minecraftforge.common.DimensionManager;


public class dimensionRegistry {

    public static void mainRegistry()
    {
        registerDimension();
    }

    public static final int dimensionID = 77;

    public static void registerDimension()
    {
        DimensionManager.registerProviderType(dimensionID, WorldProviderNecromantia.class, false);
        DimensionManager.registerDimension(dimensionID, dimensionID);
    }
}
