package com.greyfall.necromantia.common.items;

import java.util.List;

import com.greyfall.necromantia.client.libs.LibItemTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import com.greyfall.necromantia.common.libs.ItemNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSlimeLatex extends ModItem {

	public ItemSlimeLatex() {
		super();
		this.setUnlocalizedName(ItemNames.SLIME_LATEX);
		this.setTextureName(LibItemTextures.SLIME_LATEX);

	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		list.add(Main.itemLang.translate("slimeLatex"));
	}


}
