package com.greyfall.necromantia.common.items.armor.pinkLatex;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.items.ModItemArmor;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ISpecialArmor;

public class ItemPinkLatexArmour extends ModItemArmor {

	public ItemPinkLatexArmour(int armourType) {
		super(Main.pinklatexArmourMaterial, 0, armourType);
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
