package com.greyfall.necromantia.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRune extends Block {

    public BlockRune(Material material) {
        super(material);
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeStone);
    }

}
