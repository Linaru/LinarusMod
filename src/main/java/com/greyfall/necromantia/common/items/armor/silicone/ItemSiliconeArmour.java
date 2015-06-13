package com.greyfall.necromantia.common.items.armor.silicone;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.items.ModItemArmor;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemSiliconeArmour extends ModItemArmor {

	public ItemSiliconeArmour(int armourType) {
		super(Main.siliconeArmourMaterial, 0, armourType);
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
