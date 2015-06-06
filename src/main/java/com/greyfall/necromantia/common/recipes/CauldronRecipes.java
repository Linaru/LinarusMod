package com.greyfall.necromantia.common.recipes;

import com.greyfall.necromantia.api.crafting.CauldronCrafting;
import com.greyfall.necromantia.common.Main;
import net.minecraft.item.ItemStack;

/**
 * Created by Katrina on 06/06/2015.
 */
public class CauldronRecipes {



    public static void initRecipes()
    {

        CauldronCrafting.addNormalRecepie(new ItemStack(Main.itemRice,3),new ItemStack(Main.itemLatex));
    }
}