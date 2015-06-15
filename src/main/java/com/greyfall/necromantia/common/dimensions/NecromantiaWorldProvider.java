package com.greyfall.necromantia.common.dimensions;

import com.greyfall.necromantia.common.core.config.NecromantiaConfig;
import com.greyfall.necromantia.common.world.ModBiomes;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;

/**
 * Created by Katrina on 14/06/2015.
 */
public class NecromantiaWorldProvider extends WorldProvider {


    @Override
    protected void registerWorldChunkManager() {
        worldChunkMgr=new WorldChunkManagerHell(ModBiomes.biomeEtherealSanctuary,0.0f);
        this.dimensionId= NecromantiaConfig.etherealSanctuaryDimensionID;
    }


    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderVoid(worldObj,worldObj.getSeed(),true);
    }

    @Override
    public String getDimensionName() {
        return "etherealSanctuary";
    }
}
