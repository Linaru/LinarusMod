package com.greyfall.necromantia.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIrontreebrickslab extends Block {

    public BlockIrontreebrickslab(Material material) {
        super(material);
        this.setHardness(0.2F);
        this.setStepSound(Block.soundTypeStone);
    }

}
