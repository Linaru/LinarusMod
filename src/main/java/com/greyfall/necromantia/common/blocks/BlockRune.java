package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRune extends ModBlock {

    public BlockRune() {
        super(Material.ground);
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName(BlockNames.RUNE);
        this.setBlockTextureName(LibTextures.RUNE);
    }

}
