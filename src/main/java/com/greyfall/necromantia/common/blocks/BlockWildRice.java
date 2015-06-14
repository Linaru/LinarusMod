package com.greyfall.necromantia.common.blocks;

import codechicken.lib.math.MathHelper;
import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.items.ModItem;
import com.greyfall.necromantia.common.items.ModItems;
import com.greyfall.necromantia.common.libs.BlockNames;
import cpw.mods.fml.common.Optional;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import powercrystals.minefactoryreloaded.api.HarvestType;
import powercrystals.minefactoryreloaded.api.IFactoryHarvestable;
import scala.actors.threadpool.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Random;
@Optional.Interface(modid = "MineFactoryReloaded",iface = "powercrystals.minefactoryreloaded.api.IFactoryHarvestable")
public class BlockWildRice extends ModCrop implements IFactoryHarvestable {


    public BlockWildRice() {

        super();
        maxGrowthStage=7;
        this.setBlockName(BlockNames.WILD_RICE);
    }


    @Override
    public int quantityDropped(Random p_149745_1_) {
        return net.minecraft.util.MathHelper.getRandomIntegerInRange(p_149745_1_,2,3);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        if(p_149650_1_==maxGrowthStage)
            return ModItems.rice;
        else
            return ModItems.riceSeeds;
    }

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        iIcon=new IIcon[8];

        iIcon[0]=p_149651_1_.registerIcon(LibTextures.WILD_RICE+"0");
        iIcon[1]=p_149651_1_.registerIcon(LibTextures.WILD_RICE+"0");
        iIcon[2]=p_149651_1_.registerIcon(LibTextures.WILD_RICE+"1");
        iIcon[3]=p_149651_1_.registerIcon(LibTextures.WILD_RICE+"1");
        iIcon[4]=p_149651_1_.registerIcon(LibTextures.WILD_RICE+"2");
        iIcon[5]=p_149651_1_.registerIcon(LibTextures.WILD_RICE+"2");
        iIcon[6]=p_149651_1_.registerIcon(LibTextures.WILD_RICE+"3");
        iIcon[7]=p_149651_1_.registerIcon(LibTextures.WILD_RICE+"3");

    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public Block getPlant() {
        return this;
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public HarvestType getHarvestType() {
        return HarvestType.Normal;
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public boolean breakBlock() {
        return true;
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public boolean canBeHarvested(World world, Map<String, Boolean> harvesterSettings, int x, int y, int z) {
        return world.getBlockMetadata(x,y,z)>=8;
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public List<ItemStack> getDrops(World world, Random rand, Map<String, Boolean> harvesterSettings, int x, int y, int z) {
        return Arrays.asList(new ItemStack[]{new ItemStack(ModItems.rice, net.minecraft.util.MathHelper.getRandomIntegerInRange(rand,2,5))});
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public void preHarvest(World world, int x, int y, int z) {

    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public void postHarvest(World world, int x, int y, int z) {

    }
}
