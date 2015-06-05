package com.greyfall.necromantia.api.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Crafting manager for cauldron crafting
 * Created by Katrina on 05/06/2015.
 */
public class CauldronCrafting {


    public static FluidStack defaultFluid=new FluidStack(FluidRegistry.WATER,1000);

    protected static Map<ItemStack,List<CauldronRecipe>> recipeMap =new HashMap<ItemStack,List<CauldronRecipe>>();

    /**
     * Adds a normal recipe including fluid
     * @param input input item
     * @param fluid fluid needed
     * @param output recipe result
     * @return Cauldron recipe object
     */
    public static CauldronRecipe addNormalRecepie(ItemStack input,FluidStack fluid,ItemStack output)
    {
        if(!recipeMap.containsKey(output))
            recipeMap.put(output,new ArrayList<CauldronRecipe>());
        CauldronRecipe recipe=new CauldronRecipe(output,input,fluid);
        recipeMap.get(output).add(recipe);
        return recipe;
    }

    /**
     * Adds a normal recipe assuming water
     * @param input input item
     * @param output recipe result
     * @return Cauldron recipe object
     */
    public static CauldronRecipe addNormalRecepie(ItemStack input,ItemStack output)
    {
        return addNormalRecepie(input,defaultFluid,output);
    }

    /**
     * Adds a normal recipe including fluid
     * @param input input item
     * @param amount input amount needed
     * @param fluid fluid needed
     * @param output recipe result
     * @return Cauldron recipe object
     */
    public static CauldronRecipe addNormalRecepie(String input,int amount,FluidStack fluid,ItemStack output)
    {
        if(!recipeMap.containsKey(output))
            recipeMap.put(output,new ArrayList<CauldronRecipe>());
        CauldronRecipe recipe=new CauldronRecipe(output,input,amount,fluid);
        recipeMap.get(output).add(recipe);
        return recipe;
    }

    /**
     * Adds a normal recipe assuming water
     * @param input input item
     * @param amount input Amount needed
     * @param output recipe result
     * @return Cauldron recipe object
     */
    public static CauldronRecipe addNormalRecepie(String input,int amount,ItemStack output)
    {
        return addNormalRecepie(input,amount,defaultFluid,output);
    }

    /**
     * Adds a normal recipe including fluid
     * @param input input item
     * @param fluid fluid needed
     * @param amount fluid amount needed
     * @param output recipe result
     * @return Cauldron recipe object
     */
    public static CauldronRecipe addNormalRecepie(ItemStack input,String fluid,int amount,ItemStack output)
    {
        if(!recipeMap.containsKey(output))
            recipeMap.put(output,new ArrayList<CauldronRecipe>());
        CauldronRecipe recipe=new CauldronRecipe(output,input,fluid,amount);
        recipeMap.get(output).add(recipe);
        return recipe;
    }

    /**
     * Adds a normal recipe assuming water
     * @param input input item
     * @param amount input item amount
     * @param output recipe result
     * @param fluidAmount input fluid amount
     * @return Cauldron recipe object
     */
    public static CauldronRecipe addNormalRecepie(String input,int amount,String fluid,int fluidAmount,ItemStack output)
    {
        if(!recipeMap.containsKey(output))
            recipeMap.put(output,new ArrayList<CauldronRecipe>());
        CauldronRecipe recipe=new CauldronRecipe(output,input,amount,fluid,amount);
        recipeMap.get(output).add(recipe);
        return recipe;
    }

    /**
     * Adds a custom recipe to the list
     * @param recipe recipe to add
     */
    public static void addCustomRecipe(CauldronRecipe recipe)
    {
        if(!recipeMap.containsKey(recipe.getOutput()))
            recipeMap.put(recipe.getOutput(),new ArrayList<CauldronRecipe>());
        recipeMap.get(recipe.getOutput()).add(recipe);
    }


    /**
     * Finds the recipe for given item and liquid
     * @param item item to check
     * @param fluid fluid to check
     * @return the recipe, or null if none
     */
    @Nullable
    public static CauldronRecipe findRecipe(ItemStack item,FluidStack fluid)
    {
        for(List<CauldronRecipe> recipes:recipeMap.values())
        {
            for(CauldronRecipe recipe:recipes)
            {
                if(recipe.isRecepieRight(item,fluid))
                    return recipe;
            }
        }
        return null;
    }
    /**
     * Gets the output item stack from the given item and fluid
     * @param item item to check
     * @param fluid fluid to check
     * @return the itemstack of the item, or null if none
     */
    @Nullable
    public static ItemStack getOutput(ItemStack item,FluidStack fluid)
    {
        CauldronRecipe recipe=findRecipe(item, fluid);
        if(recipe!=null)
            return recipe.getOutput();
        else
            return null;
    }


    /**
     * Gets output stack from the given item assuming default fluid
     * @param item item to chec
     * @return the itemstack of the item, or null if none
     */
    @Nullable
    public static ItemStack getOutput(ItemStack item)
    {
        return getOutput(item,defaultFluid);
    }


    /**
     * Performs the recipe, subtracting the appropriate amounts.
     * Does not detect empty stacks
     * @param item itemstack to use
     * @param fluid fluidstack to use
     * @return output stack
     */
    @Nullable
    public static ItemStack doRecipe(ItemStack item,FluidStack fluid)
    {
       CauldronRecipe recipe=findRecipe(item,fluid);
        if(recipe==null)
            return null;
        return recipe.doRecipe(item, fluid);
    }


    /**
     * Performs the recipe, subtracting the appropriate amounts.
     * Does not detect empty stacks
     * @param item itemstack to use
     * @return output stack
     */
    @Nullable
    public static ItemStack doRecipe(ItemStack item)
    {
        return doRecipe(item,defaultFluid);
    }



}
