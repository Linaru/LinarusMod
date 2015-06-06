package com.greyfall.necromantia.common.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.IFluidContainerItem;

/**
 * Created by Katrina on 05/06/2015.
 */
public class SlotLiquid extends Slot {
    public SlotLiquid(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }



    @Override
    public boolean isItemValid(ItemStack p_75214_1_) {
        if(p_75214_1_.getItem() instanceof IFluidContainerItem || p_75214_1_.getItem() instanceof ItemBucket || p_75214_1_.getItem() instanceof ItemGlassBottle || p_75214_1_.getItem() instanceof ItemBucketMilk)
            return true;
        else
            return false;
    }
}
