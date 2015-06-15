package com.greyfall.necromantia.common.recipes;

import com.greyfall.necromantia.api.crafting.CauldronCrafting;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.items.ItemRice;
import com.greyfall.necromantia.common.items.ModItem;
import com.greyfall.necromantia.common.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

/**
 * Created by Katrina on 06/06/2015.
 * Edited by  by Linaru on 13/06/2015.
 */
public class CauldronRecipes {



    public static void initRecipes()
    {

        CauldronCrafting.addNormalRecepie(new ItemStack(Items.apple,1),new FluidStack(FluidRegistry.WATER,250),new ItemStack[] { new ItemStack(ModItems.cookedApple),new ItemStack(ModItems.wax)});
        CauldronCrafting.addNormalRecepie(new ItemStack(Items.golden_apple,1),new FluidStack(FluidRegistry.WATER,250),new ItemStack[] { new ItemStack(ModItems.cookedApple),new ItemStack(ModItems.wax),new ItemStack(Items.gold_nugget,8)});
        CauldronCrafting.addNormalRecepie(new ItemStack(Items.golden_apple,1,1),new FluidStack(FluidRegistry.WATER,250),new ItemStack[] { new ItemStack(ModItems.cookedApple),new ItemStack(ModItems.wax),new ItemStack(Blocks.gold_block,8)});
        CauldronCrafting.addNormalRecepie("cropRice",1,new FluidStack(FluidRegistry.WATER,250),new ItemStack[] { new ItemStack(ModItems.riceBall)});
        CauldronCrafting.addNormalRecepie(new ItemStack(Items.leather,1),new FluidStack(FluidRegistry.WATER,500),new ItemStack[] { new ItemStack(ModItems.boiledLeather)});
        CauldronCrafting.addNormalRecepie(new ItemStack(Items.spider_eye,1),new FluidStack(FluidRegistry.WATER,500),new ItemStack[] { new ItemStack(Items.fermented_spider_eye)});
        CauldronCrafting.addNormalRecepie(new ItemStack(Items.poisonous_potato,1),new FluidStack(FluidRegistry.WATER,250),new ItemStack[] { new ItemStack(Items.potato)});

        //if (FluidRegistry.isFluidRegistered("acid"))
            //CauldronCrafting.addNormalRecepie(new ItemStack(ModItems.siliconDioxide,1),new FluidStack(FluidRegistry.WATER,1000),new ItemStack[] {FluidContainerRegistry.fillFluidContainer(FluidRegistry.getFluidStack("acid",1000),new ItemStack(Items.bucket))});
        //TODO: make this a custom recipe that acidifies the water


        /*
        if(FluidRegistry.isFluidRegistered("fuel"))
        CauldronCrafting.addNormalRecepie(new ItemStack(ModItems.rice),new FluidStack(FluidRegistry.getFluid("fuel"),1000),new ItemStack[]{new ItemStack(ModItems.latex)});
        CauldronCrafting.addNormalRecepie("logWood",1,new ItemStack[]{new ItemStack(Blocks.diamond_block)});
        */
    }
}