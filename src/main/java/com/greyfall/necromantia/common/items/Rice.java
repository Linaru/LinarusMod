package com.greyfall.necromantia.common.items;

import com.greyfall.necromantia.common.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class Rice extends Item {

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
    {
        list.add(Main.itemLang.translate("rice"));
    }

}
