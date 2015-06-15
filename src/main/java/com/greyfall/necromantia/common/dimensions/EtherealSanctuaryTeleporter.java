package com.greyfall.necromantia.common.dimensions;

import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.core.config.NecromantiaConfig;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Katrina on 14/06/2015.
 */
public class EtherealSanctuaryTeleporter extends Teleporter {



    public WorldServer world;
    public Random rand;
    public EtherealSanctuaryTeleporter(WorldServer p_i1963_1_) {
        super(p_i1963_1_);
        world=p_i1963_1_;
        rand=new Random(world.getSeed());
    }

    private final List destinationCoordinateKeys = new ArrayList();
    /** Stores successful portal placement locations for rapid lookup. */
    private final LongHashMap destinationCoordinateCache = new LongHashMap();


    @Override
    public void placeInPortal(Entity p_77185_1_, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_) {

            if (!this.placeInExistingPortal(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_))
            {
                this.makePortal(p_77185_1_);
                this.placeInExistingPortal(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_);
            }
    }

    @Override
    public boolean placeInExistingPortal(Entity p_77184_1_, double p_77184_2_, double p_77184_4_, double p_77184_6_, float p_77184_8_) {


        short short1 = 128;
        double d3 = -1.0D;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = MathHelper.floor_double(p_77184_1_.posX);
        int i1 = MathHelper.floor_double(p_77184_1_.posZ);
        long j1 = ChunkCoordIntPair.chunkXZ2Int(l, i1);
        boolean flag = true;
        double d7;
        int l3;

        if (this.destinationCoordinateCache.containsItem(j1))
        {
            Teleporter.PortalPosition portalposition = (Teleporter.PortalPosition)this.destinationCoordinateCache.getValueByKey(j1);
            d3 = 0.0D;
            i = portalposition.posX;
            j = portalposition.posY;
            k = portalposition.posZ;
            portalposition.lastUpdateTime = this.world.getTotalWorldTime();
            flag = false;
        }
        else
        {
            for (l3 = l - short1; l3 <= l + short1; ++l3)
            {
                double d4 = (double)l3 + 0.5D - p_77184_1_.posX;

                for (int l1 = i1 - short1; l1 <= i1 + short1; ++l1)
                {
                    double d5 = (double)l1 + 0.5D - p_77184_1_.posZ;

                    for (int i2 = this.world.getActualHeight() - 1; i2 >= 0; --i2)
                    {
                        if (this.world.getBlock(l3, i2, l1) == ModBlocks.etherealPortal)
                        {
                            boolean flag3=false;
                            for(int i9=-3;i9<3;i9++)
                            {
                                for(int j9=-3;j9<3;j9++)
                                    for(int k9=-3;k9<3;k9++)
                                    {
                                        if(!flag3 && world.getBlock(l3+i9,i2+j9,l1+k9)!=ModBlocks.etherealPortal && world.getBlock(l3+i9,i2+j9,l1+k9).isBlockSolid(world,l3+i9,i2+j9,l1+k9, ForgeDirection.UP.ordinal()))
                                        {
                                            l3=l3+i9;
                                            i2=i2+j9;
                                            l3=l3+k9;
                                            flag3=true;
                                        }
                                    }
                            }
                            if(!flag3)
                                break;
                            d7 = (double)i2 + 0.5D - p_77184_1_.posY;
                            double d8 = d4 * d4 + d7 * d7 + d5 * d5;

                            if (d3 < 0.0D || d8 < d3)
                            {
                                d3 = d8;
                                i = l3;
                                j = i2;
                                k = l1;
                            }
                        }
                    }
                }
            }
        }

        if (d3 >= 0.0D)
        {
            if (flag)
            {
                this.destinationCoordinateCache.add(j1, new Teleporter.PortalPosition(i, j, k, this.world.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(j1));
            }

            double d11 = (double)i + 0.5D;
            double d6 = (double)j + 0.5D;
            d7 = (double)k + 0.5D;
            int i4 = -1;

            if (this.world.getBlock(i - 1, j, k) == ModBlocks.etherealPortal)
            {
                i4 = 2;
            }

            if (this.world.getBlock(i + 1, j, k) == ModBlocks.etherealPortal)
            {
                i4 = 0;
            }

            if (this.world.getBlock(i, j, k - 1) == ModBlocks.etherealPortal)
            {
                i4 = 3;
            }

            if (this.world.getBlock(i, j, k + 1) == ModBlocks.etherealPortal)
            {
                i4 = 1;
            }

            int j2 = p_77184_1_.getTeleportDirection();

            if (i4 > -1)
            {
                int k2 = Direction.rotateLeft[i4];
                int l2 = Direction.offsetX[i4];
                int i3 = Direction.offsetZ[i4];
                int j3 = Direction.offsetX[k2];
                int k3 = Direction.offsetZ[k2];
                boolean flag1 = !this.world.isAirBlock(i + l2 + j3, j, k + i3 + k3) || !world.isAirBlock(i + l2 + j3, j + 1, k + i3 + k3);
                boolean flag2 = !this.world.isAirBlock(i + l2, j, k + i3) || !world.isAirBlock(i + l2, j + 1, k + i3);

                if (flag1 && flag2)
                {
                    i4 = Direction.rotateOpposite[i4];
                    k2 = Direction.rotateOpposite[k2];
                    l2 = Direction.offsetX[i4];
                    i3 = Direction.offsetZ[i4];
                    j3 = Direction.offsetX[k2];
                    k3 = Direction.offsetZ[k2];
                    l3 = i - j3;
                    d11 -= (double)j3;
                    int k1 = k - k3;
                    d7 -= (double)k3;
                    flag1 = !this.world.isAirBlock(l3 + l2 + j3, j, k1 + i3 + k3) || !this.world.isAirBlock(l3 + l2 + j3, j + 1, k1 + i3 + k3);
                    flag2 = !this.world.isAirBlock(l3 + l2, j, k1 + i3) || !this.world.isAirBlock(l3 + l2, j + 1, k1 + i3);
                }

                float f1 = 0.5F;
                float f2 = 0.5F;

                if (!flag1 && flag2)
                {
                    f1 = 1.0F;
                }
                else if (flag1 && !flag2)
                {
                    f1 = 0.0F;
                }
                else if (flag1 && flag2)
                {
                    f2 = 0.0F;
                }

                d11 += (double)((float)j3 * f1 + f2 * (float)l2);
                d7 += (double)((float)k3 * f1 + f2 * (float)i3);
                float f3 = 0.0F;
                float f4 = 0.0F;
                float f5 = 0.0F;
                float f6 = 0.0F;

                if (i4 == j2)
                {
                    f3 = 1.0F;
                    f4 = 1.0F;
                }
                else if (i4 == Direction.rotateOpposite[j2])
                {
                    f3 = -1.0F;
                    f4 = -1.0F;
                }
                else if (i4 == Direction.rotateRight[j2])
                {
                    f5 = 1.0F;
                    f6 = -1.0F;
                }
                else
                {
                    f5 = -1.0F;
                    f6 = 1.0F;
                }

                double d9 = p_77184_1_.motionX;
                double d10 = p_77184_1_.motionZ;
                p_77184_1_.motionX = d9 * (double)f3 + d10 * (double)f6;
                p_77184_1_.motionZ = d9 * (double)f5 + d10 * (double)f4;
                p_77184_1_.rotationYaw = p_77184_8_ - (float)(j2 * 90) + (float)(i4 * 90);
            }
            else
            {
                p_77184_1_.motionX = p_77184_1_.motionY = p_77184_1_.motionZ = 0.0D;
            }

            p_77184_1_.setLocationAndAngles(d11, d6, d7, p_77184_1_.rotationYaw, p_77184_1_.rotationPitch);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean makePortal(Entity p_85188_1_) {
        return super.makePortal(p_85188_1_);
    }

    @Override
    public void removeStalePortalLocations(long p_85189_1_) {
        super.removeStalePortalLocations(p_85189_1_);
    }
}
