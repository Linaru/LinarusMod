package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Katrina on 14/06/2015.
 */
public class ModCrop extends BlockBush implements IGrowable {


    protected int maxGrowthStage = 7;

    @SideOnly(Side.CLIENT)
    protected IIcon[] iIcon;
    public ModCrop() {
        super();
        this.setCreativeTab(getCreativeTab().getTab());
        setTickRandomly(true);
        float f = 0.5F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        disableStats();
        setStepSound(Block.soundTypeGrass);
        setHardness(0.0f);
    }


    @Override
    protected boolean canPlaceBlockOn(Block p_149854_1_) {
        return p_149854_1_== Blocks.farmland;
    }

    @Override
    public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
        return super.canBlockStay(p_149718_1_, p_149718_2_, p_149718_3_, p_149718_4_);
    }

    public void incrementGrowthStage(World world,Random rand,int x,int y,int z)
    {
        int growthStage=world.getBlockMetadata(x,y,z)+ MathHelper.getRandomIntegerInRange(rand,2,5);
        if(growthStage>maxGrowthStage)
            growthStage=maxGrowthStage;
        world.setBlockMetadataWithNotify(x,y,z,growthStage,2);

    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int getRenderType() {
        return 1;
    }


    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return iIcon[p_149691_2_];
    }



    public EnumCreativeTab getCreativeTab()
    {
        return EnumCreativeTab.MAIN;
    }


    @Override
    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
        return p_149851_1_.getBlockMetadata(p_149851_2_,p_149851_3_,p_149851_4_)!=maxGrowthStage;
    }

    @Override
    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
        return true;
    }

    @Override
    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
        incrementGrowthStage(p_149853_1_,p_149853_2_,p_149853_3_,p_149853_4_,p_149853_5_);
    }


    @Override
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

        int growthStage=p_149674_1_.getBlockMetadata(p_149674_2_,p_149674_3_,p_149674_4_)+1;
        if(growthStage>maxGrowthStage)
            growthStage=maxGrowthStage;
        p_149674_1_.setBlockMetadataWithNotify(p_149674_2_,p_149674_3_,p_149674_4_,growthStage,2);
    }
}
