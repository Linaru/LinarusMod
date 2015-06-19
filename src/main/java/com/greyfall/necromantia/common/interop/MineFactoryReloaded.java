package com.greyfall.necromantia.common.interop;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.blocks.ModBlock;
import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.items.ModItem;
import com.greyfall.necromantia.common.items.ModItems;
import powercrystals.minefactoryreloaded.api.FactoryRegistry;

/**
 * Created by Katrina on 19/06/2015.
 */
public class MineFactoryReloaded {


    public static void registerCrops()
    {
        FactoryRegistry.sendMessage("registerHarvestable", ModBlocks.wildRice);
        FactoryRegistry.sendMessage("registerPlantable", ModItems.riceSeeds);
    }
}
