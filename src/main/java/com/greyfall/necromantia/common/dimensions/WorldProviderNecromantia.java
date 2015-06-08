package com.greyfall.necromantia.common.dimensions;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderNecromantia extends WorldProvider
{
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeRegistry.biomeEtherealsanctuary, 1.2F);
        this.dimensionId = dimensionRegistry.dimensionID;
    }

    public IChunkProvider createChunkGeneration(){
        return null;
    }
    @Override
    public String getDimensionName()
    {
        return "Ethereal Sanctuary";

    }
}
