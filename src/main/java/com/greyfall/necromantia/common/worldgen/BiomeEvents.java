package com.greyfall.necromantia.common.worldgen;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

/**
 * Created by Katrina on 14/06/2015.
 */
public class BiomeEvents {



    /*@SubscribeEvent
    public void addIronWoodTrees(DecorateBiomeEvent event)
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        for (k = 0; k < 4; ++k)
        {
            for (l = 0; l < 4; ++l)
            {
                i1 = event.chunkX+ k * 4 + 1 + 8 + event.rand.nextInt(3);
                j1 = event.chunkZ+ l * 4 + 1 + 8 + event.rand.nextInt(3);
                k1 = event.world.getHeightValue(i1, j1);

                if (event.rand.nextInt(20) == 0)
                {
                    WorldGenBigMushroom worldgenbigmushroom = new WorldGenBigMushroom();
                    worldgenbigmushroom.generate(event.world, event.rand, i1, k1, j1);
                }
                else
                {
                    WorldGenAbstractTree worldgenabstracttree = new WorldGenIronwoodTree(false);
                    worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);

                    if (worldgenabstracttree.generate(event.world, event.rand, i1, k1, j1))
                    {
                        worldgenabstracttree.func_150524_b(event.world, event.rand, i1, k1, j1);
                    }
                }
            }
        }
    }*/

    @SubscribeEvent
    public void addIronWoodTrees(DecorateBiomeEvent.Post event) {

        int j;
        int k;
        int l;
        int i1;
        for (j = 0; j < 1; ++j)
        {
            k = event.chunkX + event.rand.nextInt(16) + 8;
            l = event.chunkZ+ event.rand.nextInt(16) + 8;
            i1 = event.rand.nextInt(event.world.getHeightValue(k, l) * 2);
            WorldGenerator worldgenerator = new WorldGenWildRice();
             worldgenerator.generate(event.world, event.rand, k, i1, l);
        }
    }
}
