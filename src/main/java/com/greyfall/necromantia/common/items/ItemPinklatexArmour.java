package com.greyfall.necromantia.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemPinklatexArmour extends ItemArmor {

	public ItemPinklatexArmour(ArmorMaterial armourMaterial, int renderIndex,
			int armourType) {
		super(armourMaterial, renderIndex, armourType);
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(this.armorType == 2)
		{
			return "necromantia:textures/models/armor/pinklatex_layer_2.png";
		}
		return "necromantia:textures/models/armor/pinklatex_layer_1.png";
	}
}
