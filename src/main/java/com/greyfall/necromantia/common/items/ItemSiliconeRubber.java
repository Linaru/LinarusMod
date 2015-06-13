package com.greyfall.necromantia.common.items;

import java.util.List;

import com.greyfall.necromantia.client.libs.LibItemTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.ItemNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSiliconeRubber extends ModItem {

	public ItemSiliconeRubber() {
		super();
		this.setUnlocalizedName(ItemNames.SILICONE_RUBBER);
		this.setTextureName(LibItemTextures.SILICONE_RUBBER);

	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		list.add(Main.itemLang.translate("siliconeRubber"));
	}

}
