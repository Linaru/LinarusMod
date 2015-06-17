package com.greyfall.necromantia.common.items.itemBlocks;

import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Katrina on 17/06/2015.
 */
public class ItemBlockDungeonRuinsBrick extends ItemBlock {
    public ItemBlockDungeonRuinsBrick(Block p_i45328_1_) {
        super(p_i45328_1_);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack p_77667_1_) {

            return "item."+BlockNames.DUNGEON_RUINS_BRICK+"."+p_77667_1_.getItemDamage();
    }


    @Override
    public int getMetadata(int p_77647_1_) {
        return p_77647_1_;
    }
}
