package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Katrina on 13/06/2015.
 */
public class ModBlock extends Block{
    public ModBlock(Material p_i45394_1_) {

        super(p_i45394_1_);
        this.setCreativeTab(getCreativeTab().getTab());
    }



    public EnumCreativeTab getCreativeTab()
    {
        return EnumCreativeTab.MAIN;
    }


}
