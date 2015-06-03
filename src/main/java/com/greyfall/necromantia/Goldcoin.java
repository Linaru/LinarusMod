package com.greyfall.necromantia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Goldcoin extends Item {

public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
{
list.add("a commonly used currency");
}
	
}
