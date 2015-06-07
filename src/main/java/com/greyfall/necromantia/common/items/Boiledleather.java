package com.greyfall.necromantia.common.items;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Boiledleather extends Item {

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
    {
        list.add("Boiled leather is much tougher");
        list.add("but also far more brittle.");
    }

}
