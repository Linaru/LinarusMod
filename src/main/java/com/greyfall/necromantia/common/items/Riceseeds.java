package com.greyfall.necromantia.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class Riceseeds extends Item{

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
    {
        list.add("Seeds that grow Rice");
    }

}
