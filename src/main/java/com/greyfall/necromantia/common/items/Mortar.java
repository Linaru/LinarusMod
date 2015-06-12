package com.greyfall.necromantia.common.items;

import java.util.List;

import com.greyfall.necromantia.common.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Mortar extends Item { 
	
	@Override
	public boolean hasContainerItem() {
	return true;
	}
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
	return itemStack;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack) {
	return false;
	}
	
public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
{
	list.add(Main.ItemLang.translate("mortar.info1"));
	list.add(Main.ItemLang.translate("mortar.info2"));
}

}
