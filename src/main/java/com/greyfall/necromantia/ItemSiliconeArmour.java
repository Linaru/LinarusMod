package com.greyfall.necromantia;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemSiliconeArmour extends ItemArmor {

	public ItemSiliconeArmour(ArmorMaterial armourMaterial, int renderIndex,
			int armourType) {
		super(armourMaterial, renderIndex, armourType);
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(this.armorType == 2)
		{
			return "necromantia:textures/models/armor/silicone_layer_2.png";
		}
		return "necromantia:textures/models/armor/silicone_layer_1.png";
	}
}
