package com.greyfall.necromantia.common.items;

import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import net.minecraft.item.ItemFood;

/**
 * Created by Katrina on 13/06/2015.
 */
public class ModItemFood extends ItemFood{


    public ModItemFood(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
        this.setCreativeTab(getTab().getTab());
    }

    public EnumCreativeTab getTab()
    {
        return EnumCreativeTab.MAIN;
    }
}
