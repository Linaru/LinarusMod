package com.greyfall.necromantia.common.items.itemBlocks;

import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Katrina on 13/06/2015.
 */
public class ItemBlockLatex extends ItemBlock {
    public ItemBlockLatex(Block p_i45328_1_) {
        super(p_i45328_1_);
        setHasSubtypes(true);
    }


    @Override
    public String getUnlocalizedName(ItemStack p_77667_1_) {
        switch (p_77667_1_.getItemDamage())
        {
            case 0:
                return "tile."+BlockNames.LATEX;
            case 1:
                return "tile."+BlockNames.SLIME_LATEX;
            default:
                return "ERROR";
        }
    }


    @Override
    public int getMetadata(int p_77647_1_) {
        return p_77647_1_;
    }
}
