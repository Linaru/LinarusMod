package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDarkness extends ModBlock {

    public BlockDarkness() {
        super(Material.ground);
        this.setHardness(0.2F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName(BlockNames.DARKNESS);
        this.setBlockTextureName(LibTextures.DARKNESS);
        this.setLightLevel(-0.9F);
    }

}
