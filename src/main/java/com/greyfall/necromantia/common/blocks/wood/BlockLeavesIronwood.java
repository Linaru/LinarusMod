package com.greyfall.necromantia.common.blocks.wood;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.blocks.ModBlock;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLeavesIronwood extends ModBlock {

    public BlockLeavesIronwood() {
        super(Material.leaves);
        this.setHardness(0.1F);
        this.setBlockName(BlockNames.IRONWOOD_LEAVES);
        this.setBlockTextureName(LibTextures.IRONWOOD_LEAVES);
    }

}
