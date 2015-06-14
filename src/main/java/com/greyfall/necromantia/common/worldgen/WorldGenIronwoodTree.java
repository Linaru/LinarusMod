package com.greyfall.necromantia.common.worldgen;

import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.blocks.wood.BlockIronwoodSapling;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

/**
 * Created by Katrina on 14/06/2015.
 */
public class WorldGenIronwoodTree extends WorldGenAbstractTree {


    public WorldGenIronwoodTree(boolean doBlockNotify) {
        super(doBlockNotify);
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {

        int height = rand.nextInt(3) + rand.nextInt(2) + 6;
        boolean flag = true;

        if(y>=1 && y+height+1 <= world.getHeight())
        {
            int j1;
            int k1;
            for (int i1 = y; i1 <= y + 1 + height; ++i1)
            {
                byte b0 = 1;

                if (i1 == y)
                {
                    b0 = 0;
                }

                if (i1 >= y+ 1 + height - 2)
                {
                    b0 = 2;
                }

                for (j1 = x - b0; j1 <= x+ b0 && flag; ++j1)
                {
                    for (k1 = z- b0; k1 <= z+ b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < world.getHeight())
                        {
                            Block block = world.getBlock(j1, i1, k1);

                            if (!this.isReplaceable(world, j1, i1, k1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block2 = world.getBlock(x, y- 1, z);

                boolean isSoil = block2.canSustainPlant(world, x, y- 1, z, ForgeDirection.UP, (BlockIronwoodSapling)ModBlocks.sapling);
                if (isSoil && y< world.getHeight() - height - 1)
                {
                    onPlantGrow(world, x,     y- 1, z,     x, y, z);
                    onPlantGrow(world, x + 1, y - 1, z,     x, y, z);
                    onPlantGrow(world, x + 1, y - 1, z + 1, x, y, z);
                    onPlantGrow(world, x,     y - 1, z + 1, x, y, z);
                    int j3 = rand.nextInt(4);
                    j1 = height - rand.nextInt(4);
                    k1 = 2 - rand.nextInt(3);
                    int k3 = x;
                    int l1 = z;
                    int i2 = 0;
                    int j2;
                    int k2;

                    for (j2 = 0; j2 < height; ++j2)
                    {
                        k2 = y + j2;

                        if (j2 >= j1 && k1 > 0)
                        {
                            k3 += Direction.offsetX[j3];
                            l1 += Direction.offsetZ[j3];
                            --k1;
                        }

                        Block block1 = world.getBlock(k3, k2, l1);

                        if (block1.isAir(world, k3, k2, l1) || block1.isLeaves(world, k3, k2, l1))
                        {
                            this.setBlockAndNotifyAdequately(world, k3, k2, l1, ModBlocks.logIronwood, 1);
                            this.setBlockAndNotifyAdequately(world, k3 + 1, k2, l1, ModBlocks.logIronwood, 1);
                            this.setBlockAndNotifyAdequately(world, k3, k2, l1 + 1, ModBlocks.logIronwood, 1);
                            this.setBlockAndNotifyAdequately(world, k3 + 1, k2, l1 + 1, ModBlocks.logIronwood, 1);
                            i2 = k2;
                        }
                    }

                    for (j2 = -2; j2 <= 0; ++j2)
                    {
                        for (k2 = -2; k2 <= 0; ++k2)
                        {
                            byte b1 = -1;
                            this.doLeaves(world, k3 + j2, i2 + b1, l1 + k2);
                            this.doLeaves(world, 1 + k3 - j2, i2 + b1, l1 + k2);
                            this.doLeaves(world, k3 + j2, i2 + b1, 1 + l1 - k2);
                            this.doLeaves(world, 1 + k3 - j2, i2 + b1, 1 + l1 - k2);

                            if ((j2 > -2 || k2 > -1) && (j2 != -1 || k2 != -2))
                            {
                                byte b2 = 1;
                                this.doLeaves(world, k3 + j2, i2 + b2, l1 + k2);
                                this.doLeaves(world, 1 + k3 - j2, i2 + b2, l1 + k2);
                                this.doLeaves(world, k3 + j2, i2 + b2, 1 + l1 - k2);
                                this.doLeaves(world, 1 + k3 - j2, i2 + b2, 1 + l1 - k2);
                            }
                        }
                    }

                    if (rand.nextBoolean())
                    {
                        this.doLeaves(world, k3, i2 + 2, l1);
                        this.doLeaves(world, k3 + 1, i2 + 2, l1);
                        this.doLeaves(world, k3 + 1, i2 + 2, l1 + 1);
                        this.doLeaves(world, k3, i2 + 2, l1 + 1);
                    }

                    for (j2 = -3; j2 <= 4; ++j2)
                    {
                        for (k2 = -3; k2 <= 4; ++k2)
                        {
                            if ((j2 != -3 || k2 != -3) && (j2 != -3 || k2 != 4) && (j2 != 4 || k2 != -3) && (j2 != 4 || k2 != 4) && (Math.abs(j2) < 3 || Math.abs(k2) < 3))
                            {
                                this.doLeaves(world, k3 + j2, i2, l1 + k2);
                            }
                        }
                    }

                    for (j2 = -1; j2 <= 2; ++j2)
                    {
                        for (k2 = -1; k2 <= 2; ++k2)
                        {
                            if ((j2 < 0 || j2 > 1 || k2 < 0 || k2 > 1) && rand.nextInt(3) <= 0)
                            {
                                int l3 = rand.nextInt(3) + 2;
                                int l2;

                                for (l2 = 0; l2 < l3; ++l2)
                                {
                                    this.setBlockAndNotifyAdequately(world, x + j2, i2 - l2 - 1, z + k2, ModBlocks.logIronwood, 1);
                                }

                                int i3;

                                for (l2 = -1; l2 <= 1; ++l2)
                                {
                                    for (i3 = -1; i3 <= 1; ++i3)
                                    {
                                        this.doLeaves(world, k3 + j2 + l2, i2 - 0, l1 + k2 + i3);
                                    }
                                }

                                for (l2 = -2; l2 <= 2; ++l2)
                                {
                                    for (i3 = -2; i3 <= 2; ++i3)
                                    {
                                        if (Math.abs(l2) != 2 || Math.abs(i3) != 2)
                                        {
                                            this.doLeaves(world, k3 + j2 + l2, i2 - 1, l1 + k2 + i3);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }


    private void doLeaves(World world, int x, int y, int z)
    {
        Block block = world.getBlock(x, y, z);

        if (block.isAir(world, x, y, z))
        {
            this.setBlockAndNotifyAdequately(world, x, y, z, ModBlocks.leavesIronwood, 1);
        }
    }

    //Just a helper macro
    private void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ)
    {
        world.getBlock(x, y, z).onPlantGrow(world, x, y, z, sourceX, sourceY, sourceZ);
    }
}
