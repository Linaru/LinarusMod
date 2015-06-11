package com.greyfall.necromantia.api.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * a simple Caudlron recipe
 * Created by Katrina on 05/06/2015.
 */

public class CauldronRecipe{

    private ItemStack[] output;
    private ItemStack inputItem;
    private FluidStack inputFluid;
    private String oreDictItem;
    private int itemAmount;
    private int fluidAmount;
    private String oreDictFluid;
    private int burnTime=200;


    /**
     * Gets amount of items needed
     * @return Amount of items
     */
    public int getItemAmount() {
        return itemAmount;
    }


    /**
     * Sets amount of items needed
     * @param itemAmount Amount of items
     */
    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    /**
     * Gets amount of fluid
     * @return Amount of fluid
     */
    public int getFluidAmount() {
        return fluidAmount;
    }

    /**
     * Sets amount of fluid needed
     * @param fluidAmount Amount of fluid
     */
    public void setFluidAmount(int fluidAmount) {
        this.fluidAmount = fluidAmount;
    }

    /**
     * Gets the OreDict Name for the item
     * @return string contianing the oreDict name
     */
    public String getOreDictItem() {
        return oreDictItem;
    }

    /**
     * Sets the ore Dict name for the item
     * @param oreDictItem ore dict name
     */
    public void setOreDictItem(String oreDictItem) {
        this.oreDictItem = oreDictItem;
    }

    /**
     * Fluid registry name for the fluid
     * @return fluid name
     */
    public String getOreDictFluid() {
        return oreDictFluid;
    }

    /**
     * Sets the fluid name
     * @param oreDictFluid fluid name
     */
    public void setOreDictFluid(String oreDictFluid) {
        this.oreDictFluid = oreDictFluid;
    }

    /**
     * Gets the recipe's output
     * @return Itemstack containing the output
     */
    public ItemStack[] getOutput() {
        return output;
    }


    /**
     * Sets the recipe's output
     * @param output output for the recipe
     */
    public void setOutput(ItemStack[] output) {
        this.output = output;
    }


    /**
     * Gets the recipe's input item
     * @return ItemStack containing the input
     */
    public ItemStack getInputItem() {
        return inputItem;
    }

    /**
     * Sets the recipe's input item
     * @param inputItem input item for the recipe
     */
    public void setInputItem(ItemStack inputItem) {
        this.inputItem = inputItem;
    }

    /**
     * Gets the recipe's fluid input
     * @return FluidStack containing the input
     */
    public FluidStack getInputFluid() {
        return inputFluid;
    }

    /**
     * Sets the recipe's input fluid
     * @param inputFluid input fluid for the recipe
     */
    public void setInputFluid(FluidStack inputFluid) {
        this.inputFluid = inputFluid;
    }

    /**
     * Gets the base burn time for the recipe
     * @return base burn time in ticks
     */
    public int getBurnTime() {
        return burnTime;
    }

    /**
     * Sets the base burn time for the recipe
     * @param burnTime Base time in ticks
     */
    public void setBurnTime(int burnTime) {
        this.burnTime = burnTime;
    }


    /**
     * Constructor for a recipe
     * @param output output of the recipe
     * @param inputItem input item of the recipe
     * @param inputFluid input fluid of the recipe
     */
    public CauldronRecipe(ItemStack[] output, ItemStack inputItem, FluidStack inputFluid) {
        this.output = output;
        this.inputItem = inputItem;
        this.inputFluid = inputFluid;
        this.fluidAmount=inputFluid.amount;
        this.itemAmount=inputItem.stackSize;
    }

    /**
     * Constructor for a recipe
     * @param output output of the recipe
     * @param inputItem Input ore dict
     * @param inputAmount input amount
     * @param inputFluid input fluid
     * @param fluidAmount input fluid amount
     */
    public CauldronRecipe(ItemStack[] output,String inputItem, int inputAmount,String inputFluid,int fluidAmount)
    {
        this.output=output;
        this.oreDictItem=inputItem;
        this.itemAmount=inputAmount;
        this.oreDictFluid=inputFluid;
        this.fluidAmount=fluidAmount;
    }

    /**
     * Constructor for a recipe
     * @param output output of the recipe
     * @param inputItem Input ore dict
     * @param inputAmount input amount
     * @param inputFluid input fluid of the recipe
     */
    public CauldronRecipe(ItemStack[] output,String inputItem,int inputAmount,FluidStack inputFluid)
    {
        this.output=output;
        this.oreDictItem=inputItem;
        this.itemAmount=inputAmount;
        this.inputFluid=inputFluid;
        this.fluidAmount=inputFluid.amount;
    }

    /**
     * Constructor for a recipe
     * @param output output of the recipe
     * @param inputItem Input ore dict
     * @param inputFluid input fluid
     * @param fluidAmount input fluid amount
     */
    public CauldronRecipe(ItemStack[] output,ItemStack inputItem,String inputFluid,int fluidAmount)
    {
        this.output=output;
        this.inputItem=inputItem;
        this.itemAmount=inputItem.stackSize;
        this.oreDictFluid=inputFluid;
        this.fluidAmount=fluidAmount;
    }
    /**
     * Is the input item correct and the right amount of them?
     * @param item item to check
     * @return true if the item matches and has the right amount
     */
    public boolean isItemRight(ItemStack item)
    {
        if(item==null || item.getItem()==null)
            return false;
        if(oreDictItem!=null)
        {
            int[] items=OreDictionary.getOreIDs(item);
            if(items.length==0)
                return false;
            String InputOre= OreDictionary.getOreName(OreDictionary.getOreIDs(item)[0]);
            return InputOre.equalsIgnoreCase(oreDictItem) && item.stackSize>=itemAmount;
        }
        else
            return item.isItemEqual(inputItem) && item.stackSize>=itemAmount;
    }

    /**
     * Is the fluid correct and got the right amount
     * @param fluid fluidstack to check
     * @return true if the fluid matches and has at least the right amount
     */
    public boolean isFluidRight(FluidStack fluid)
    {
        if(fluid==null || fluid.getFluid()==null)
            return false;
        if(oreDictFluid!=null)
        {
            String fluidName=FluidRegistry.getFluidName(fluid.getFluid());
            return fluidName.equalsIgnoreCase(oreDictFluid) && fluid.amount <= fluidAmount;
        }
        else
            return fluid.getFluid()==inputFluid.getFluid() && fluid.amount>=fluidAmount;
    }


    /**
     * Is the recipe correct?
     * @param item item to check
     * @param fluid fluid to check
     * @return true if the item is correct and the fluid is and of the right amount
     */
    public boolean isRecepieRight(ItemStack item,FluidStack fluid)
    {
        return isItemRight(item) && isFluidRight(fluid);
    }


    /**
     * Performs the recipe, subtracting the appropriate amounts.
     * Does not detect empty stacks
     * @param item itemstack to use
     * @param fluid fluidstack to use
     * @return output stack
     */
    public ItemStack[] doRecipe(ItemStack item,FluidStack fluid)
    {
        if(!isRecepieRight(item, fluid))
            return null;

        item.stackSize-=itemAmount;
        fluid.amount-=fluidAmount;

        return output;
    }
}
