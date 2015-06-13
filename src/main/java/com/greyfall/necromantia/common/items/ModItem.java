package com.greyfall.necromantia.common.items;

import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import net.minecraft.item.Item;

/**
 * Created by Katrina on 13/06/2015.
 */
public class ModItem extends Item {

    public ModItem() {
        this.setCreativeTab(getTab().getTab());
    }



    public EnumCreativeTab getTab()
    {
        return EnumCreativeTab.MAIN;
    }
}
