package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockWildRice extends ModBlock {

    public BlockWildRice() {
        super(Material.grass);
        this.setHardness(0.1F);
        this.setBlockName(BlockNames.WILD_RICE);
        this.setBlockTextureName(LibTextures.WILD_RICE);
    }

}
