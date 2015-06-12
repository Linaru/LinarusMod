package com.greyfall.necromantia.common.items;

import java.util.List;

import com.greyfall.necromantia.common.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Silicondioxide extends Item {

public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
{
    list.add(Main.ItemLang.translate("siliconDioxide"));
}
		
}
