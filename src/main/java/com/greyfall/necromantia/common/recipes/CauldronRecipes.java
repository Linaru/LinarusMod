package com.greyfall.necromantia.common.recipes;

import com.greyfall.necromantia.api.crafting.CauldronCrafting;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

/**
 * Created by Katrina on 06/06/2015.
 */
public class CauldronRecipes {



    public static void initRecipes()
    {

        CauldronCrafting.addNormalRecepie(new ItemStack(Items.apple,1),new FluidStack(FluidRegistry.WATER,250),new ItemStack[] { new ItemStack(ModItems.cookedApple),new ItemStack(ModItems.wax)});
        CauldronCrafting.addNormalRecepie(new ItemStack(Items.golden_apple,1),new FluidStack(FluidRegistry.WATER,250),new ItemStack[] { new ItemStack(ModItems.cookedApple),new ItemStack(ModItems.wax),new ItemStack(Items.gold_nugget,8)});
        CauldronCrafting.addNormalRecepie(new ItemStack(Items.golden_apple,1,1),new FluidStack(FluidRegistry.WATER,250),new ItemStack[] { new ItemStack(ModItems.cookedApple),new ItemStack(ModItems.wax),new ItemStack(Blocks.gold_block,8)});
        if(FluidRegistry.isFluidRegistered("fuel"))
            CauldronCrafting.addNormalRecepie(new ItemStack(ModItems.rice),new FluidStack(FluidRegistry.getFluid("fuel"),1000),new ItemStack[]{new ItemStack(ModItems.latex)});
        CauldronCrafting.addNormalRecepie("logWood",1,new ItemStack[]{new ItemStack(Blocks.diamond_block)});
    }
}