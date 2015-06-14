package com.greyfall.necromantia.common.items;

import com.greyfall.necromantia.client.libs.LibItemTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.libs.ItemNames;
import cpw.mods.fml.common.Optional;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import powercrystals.minefactoryreloaded.api.IFactoryPlantable;
import powercrystals.minefactoryreloaded.api.ReplacementBlock;

import java.util.List;
@Optional.Interface(modid = "MineFactoryReloaded",iface = "powercrystals.minefactoryreloaded.api.IFactoryPlantable")
public class ItemRiceSeeds extends ModItem implements IPlantable,IFactoryPlantable{


    public ItemRiceSeeds() {
        super();
        this.setUnlocalizedName(ItemNames.RICE_SEEDS);
        this.setTextureName(LibItemTextures.RICE_SEEDS);

    }


    @Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if(p_77648_7_!=1)
            return false;
        if(p_77648_2_.canPlayerEdit(p_77648_4_,p_77648_5_+1,p_77648_6_,p_77648_7_,p_77648_1_))
        {
            if(p_77648_3_.getBlock(p_77648_4_,p_77648_5_,p_77648_6_).canSustainPlant(p_77648_3_,p_77648_4_,p_77648_5_,p_77648_6_, ForgeDirection.UP,this) && p_77648_3_.isAirBlock(p_77648_4_,p_77648_5_+1,p_77648_6_))
            {
                p_77648_3_.setBlock(p_77648_4_,p_77648_5_+1,p_77648_6_,ModBlocks.wildRice);
                --p_77648_1_.stackSize;
                return true;
            }
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
    {
        list.add(Main.itemLang.translate("riceSeeds"));
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) {
        return ModBlocks.wildRice;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
        return 0;
    }


    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public Item getSeed() {
        return this;
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public boolean canBePlanted(ItemStack stack, boolean forFermenting) {
        return true;
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public ReplacementBlock getPlantedBlock(World world, int x, int y, int z, ItemStack stack) {
        return new ReplacementBlock(ModBlocks.wildRice);
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public boolean canBePlantedHere(World world, int x, int y, int z, ItemStack stack) {
        return ModBlocks.wildRice.canPlaceBlockAt(world,x,y,z);
    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public void prePlant(World world, int x, int y, int z, ItemStack stack) {

    }

    @Override
    @Optional.Method(modid = "MineFactoryReloaded")
    public void postPlant(World world, int x, int y, int z, ItemStack stack) {

    }
}
