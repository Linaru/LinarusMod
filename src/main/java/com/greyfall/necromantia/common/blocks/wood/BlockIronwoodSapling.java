package com.greyfall.necromantia.common.blocks.wood;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import com.greyfall.necromantia.common.worldgen.WorldGenIronwoodTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.List;
import java.util.Random;

/**
 * Created by Katrina on 14/06/2015.
 */
public class BlockIronwoodSapling extends BlockBush implements IGrowable {

    public static final String[] treeTypes = new String[] {"Ironwood"};
    private static final IIcon[] treeIcons = new IIcon[treeTypes.length];

    public BlockIronwoodSapling() {
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(Main.tabnecromantia);
        this.setBlockName(BlockNames.SAPLINGS);
    }


    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if(!world.isRemote)
        {
            super.updateTick(world, x, y, z, rand);
            if(world.getBlockLightValue(x,y,z)>=9 && rand.nextInt(7)==0)
            {
                tryGrow(world, x, y, z, rand);
            }
        }
    }


    public void tryGrow(World world, int x, int y, int z, Random rand)
    {
        int i=world.getBlockMetadata(x,y,z);
        if((i&8)==0)
            world.setBlockMetadataWithNotify(x,y,z,i|8,4);
        else
            this.growTree(world,x,y,z,rand);
    }



    private void growTree(World world,int x, int y, int z, Random rand) {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, x, y, z)) return;
        int l = world.getBlockMetadata(x, y, z) & 7;
        Object object = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;
        
        switch (l)
        {
            case 0:
                label78:
                for (i1 = 0; i1 >= -1; --i1)
                {
                    for (j1 = 0; j1 >= -1; --j1)
                    {
                        if (this.checkSapling(world, x + i1, y, z + j1, 0) && this.checkSapling(world, x + i1 + 1, y, z + j1, 0) && this.checkSapling(world, x + i1, y, z + j1 + 1, 0) && this.checkSapling(world, x + i1 + 1, y, z + j1 + 1, 0))
                        {
                            object = new WorldGenIronwoodTree(true);
                            flag = true;
                            break label78;
                        }
                    }
                }

                if (!flag)
                {
                    return;
                }
        }


        Block block = Blocks.air;

        if (flag)
        {
            world.setBlock(x+ i1, y, z + j1, block, 0, 4);
            world.setBlock(x+ i1 + 1, y, z + j1, block, 0, 4);
            world.setBlock(x+ i1, y, z + j1 + 1, block, 0, 4);
            world.setBlock(x+ i1 + 1, y, z + j1 + 1, block, 0, 4);
        }
        else
        {
            world.setBlock(x, y, z, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(world, rand, x+ i1, y, z + j1))
        {
            if (flag)
            {
                world.setBlock(x+ i1, y, z + j1, this, 0, 4);
                world.setBlock(x+ i1 + 1, y, z + j1, this, 0, 4);
                world.setBlock(x+ i1, y, z + j1 + 1, this, 0, 4);
                world.setBlock(x+ i1 + 1, y, z + j1 + 1, this, 0, 4);
            }
            else
            {
                world.setBlock(x, y, z, this, l, 4);
            }
        }
    }


    public boolean checkSapling(World world,int x,int y,int z,int metadata)
    {
        return world.getBlock(x,y,z)==this && (world.getBlockMetadata(x,y,z) & 7)==metadata;
    }


    @Override
    public int damageDropped(int damage) {
        return MathHelper.clamp_int(damage,0,treeTypes.length-1);
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for(int i=0;i<treeTypes.length;i++)
        {
            list.add(new ItemStack(item,1,i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        for(int i=0;i<treeTypes.length;i++)
        {
            treeIcons[i]=register.registerIcon(LibTextures.SAPLINGS+treeTypes[i]);
        }
    }


    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        p_149691_2_ &= 7;
        return treeIcons[MathHelper.clamp_int(p_149691_2_, 0, treeTypes.length-1)];
    }

    @Override
    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
        return true;
    }

    @Override
    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
        return (double)p_149852_1_.rand.nextFloat() < 0.45D;
    }

    @Override
    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {

        tryGrow(p_149853_1_,p_149853_3_,p_149853_4_,p_149853_5_,p_149853_2_);
    }
}
