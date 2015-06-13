package com.greyfall.necromantia.common.items;

import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import net.minecraft.item.ItemArmor;

/**
 * Created by Katrina on 13/06/2015.
 */
public class ModItemArmor extends ItemArmor {


    public ModItemArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
        super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
        this.setCreativeTab(getTab().getTab());
    }

    public EnumCreativeTab getTab()
    {
        return EnumCreativeTab.ARMOR;
    }




}
