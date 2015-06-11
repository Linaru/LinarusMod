package com.greyfall.necromantia.common.core.helpers;

import net.minecraft.item.ItemStack;

/**
 * Created by Katrina on 11/06/2015.
 */
public class ItemStackHelper {



    public static ItemStack[] copyItemsStackArray(ItemStack[] input)
    {
        ItemStack[] output=new ItemStack[input.length];

        for(int i=0;i<input.length;i++)
        {
            if(input[i]!=null)
                output[i]=input[i].copy();
        }
        return output;
    }
}
