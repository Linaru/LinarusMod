package com.greyfall.necromantia.common.biomes;

import com.greyfall.necromantia.common.mobs.EntityPinkslimeMob;
import com.greyfall.necromantia.common.worldgen.WorldGenIronwoodTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;

import java.util.Random;

/**
 * Created by Katrina on 14/06/2015.
 */
public class BiomeIronwoodForest extends BiomeGenBase{


    public static final WorldGenIronwoodTree tree=new WorldGenIronwoodTree(false);

        public BiomeIronwoodForest(int p_i1971_1_,boolean register) {
        super(p_i1971_1_, register);

            this.theBiomeDecorator.treesPerChunk = 10;
            this.theBiomeDecorator.grassPerChunk = 2;
            this.func_76733_a(5159473);
            this.setTemperatureRainfall(0.7F, 0.8F);
            this.setBiomeName("IronwoodForest");
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 5, 4, 4));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPinkslimeMob.class, 5, 2, 2));
    }


    @Override
    public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
        return tree;
    }


    @Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {

        int k;
        int l;
        int i1;
        int j1;
        int k1;

        for (k = 0; k < 4; ++k)
        {
            for (l = 0; l < 4; ++l)
            {
                i1 = p_76728_3_ + k * 4 + 1 + 8 + p_76728_2_.nextInt(3);
                j1 = p_76728_4_ + l * 4 + 1 + 8 + p_76728_2_.nextInt(3);
                k1 = p_76728_1_.getHeightValue(i1, j1);

                if (p_76728_2_.nextInt(20) == 0)
                {
                    WorldGenBigMushroom worldgenbigmushroom = new WorldGenBigMushroom();
                    worldgenbigmushroom.generate(p_76728_1_, p_76728_2_, i1, k1, j1);
                }
                else
                {
                    WorldGenAbstractTree worldgenabstracttree = this.func_150567_a(p_76728_2_);
                    worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);

                    if (worldgenabstracttree.generate(p_76728_1_, p_76728_2_, i1, k1, j1))
                    {
                        worldgenabstracttree.func_150524_b(p_76728_1_, p_76728_2_, i1, k1, j1);
                    }
                }
            }
        }

        k = p_76728_2_.nextInt(5) - 3;
        l = 0;

        while (l < k)
        {
            i1 = p_76728_2_.nextInt(3);

            if (i1 == 0)
            {
                genTallFlowers.func_150548_a(1);
            }
            else if (i1 == 1)
            {
                genTallFlowers.func_150548_a(4);
            }
            else if (i1 == 2)
            {
                genTallFlowers.func_150548_a(5);
            }

            j1 = 0;

            while (true)
            {
                if (j1 < 5)
                {
                    k1 = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
                    int i2 = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
                    int l1 = p_76728_2_.nextInt(p_76728_1_.getHeightValue(k1, i2) + 32);

                    if (!genTallFlowers.generate(p_76728_1_, p_76728_2_, k1, l1, i2))
                    {
                        ++j1;
                        continue;
                    }
                }

                ++l;
                break;
            }
        }

        super.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }

    /**
            * Provides the basic grass color based on the biome temperature and rainfall
    */
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        int l = super.getBiomeGrassColor(p_150558_1_, p_150558_2_, p_150558_3_);
        return (l & 16711422) + 2634762 >> 1 ;
    }


}
