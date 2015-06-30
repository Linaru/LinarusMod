package com.greyfall.necromantia.common.dimensions;

import com.greyfall.necromantia.common.core.config.NecromantiaConfig;
import com.greyfall.necromantia.common.world.ModBiomes;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;



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

    @Override
/** get sky color **/
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
    {
        return this.worldObj.getWorldVec3Pool().getVecFromPool(201, 77, 140);
    }

    @Override
/** Is sky clolured ? **/
    public boolean isSkyColored()
    {
        return true;
    }

    @Override
/** Lighting ? **/

    protected void generateLightBrightnessTable()
    {
        float f = 0.7F;

        for (int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
    }

}
