package com.greyfall.necromantia.common.interop;

import com.greyfall.necromantia.common.Main;
import vazkii.botania.common.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BotaniaInterop {
	
	public static void registerBotaniaRecepies()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(Main.itemSilicondioxide, 5), new ItemStack(Items.quartz), new ItemStack(ModItems.pestleAndMortar));
	}

}
