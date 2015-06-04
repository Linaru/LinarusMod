package com.greyfall.necromantia;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class Rice extends Item {

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
    {
        list.add("Grains of Rice");
    }

}
