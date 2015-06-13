package com.greyfall.necromantia.common.items;

import java.util.List;

import com.greyfall.necromantia.client.libs.LibItemTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.ItemNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMortar extends ModItem {

	public ItemMortar() {
		super();
		this.setUnlocalizedName(ItemNames.MORTAR);
		this.setTextureName(LibItemTextures.MORTAR);

	}

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

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		list.add(Main.itemLang.translate("mortar.info1"));
		list.add(Main.itemLang.translate("mortar.info2"));
	}

}
