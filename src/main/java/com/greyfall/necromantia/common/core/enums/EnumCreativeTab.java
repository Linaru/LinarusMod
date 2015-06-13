package com.greyfall.necromantia.common.core.enums;

import com.greyfall.necromantia.common.Main;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Katrina on 13/06/2015.
 */
public enum EnumCreativeTab {

    MAIN(Main.tabnecromantia),
    ADMIN(Main.tabnecromantiaadmin),
    ARMOR(Main.tabnecromantiaarmor);


    private CreativeTabs tab;
    private EnumCreativeTab(CreativeTabs tab)
    {
        this.tab=tab;
    }

    public CreativeTabs getTab()
    {
        return tab;
    }
}
