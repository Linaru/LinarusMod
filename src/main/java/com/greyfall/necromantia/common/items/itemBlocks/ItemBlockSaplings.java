package com.greyfall.necromantia.common.items.itemBlocks;

import com.greyfall.necromantia.common.blocks.wood.BlockIronwoodSapling;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Katrina on 14/06/2015.
 */
public class ItemBlockSaplings extends ItemBlock {
    public ItemBlockSaplings(Block p_i45328_1_) {
        super(p_i45328_1_);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack p_77667_1_) {
        int damage= p_77667_1_.getItemDamage();

        return "tile."+ BlockNames.SAPLINGS+ BlockIronwoodSapling.treeTypes[damage];
    }

    @Override
    public int getMetadata(int p_77647_1_) {
        return p_77647_1_;
    }
}
