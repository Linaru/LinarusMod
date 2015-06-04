package com.greyfall.necromantia;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Wax extends Item {

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
    {
        list.add("a byproduct of the Honey Bee");
    }

}
