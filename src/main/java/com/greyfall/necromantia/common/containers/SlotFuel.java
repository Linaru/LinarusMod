package com.greyfall.necromantia.common.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Created by Katrina on 06/06/2015.
 */
public class SlotFuel extends Slot {
    public SlotFuel(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }


    @Override
    public boolean isItemValid(ItemStack p_75214_1_) {
        return TileEntityFurnace.isItemFuel(p_75214_1_) && ! (p_75214_1_.getItem() instanceof ItemBucket);
    }
}
