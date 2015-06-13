package com.greyfall.necromantia.common.blocks.wood;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.blocks.ModBlock;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLogIronwood extends ModBlock {

    public BlockLogIronwood() {
        super(Material.wood);
        this.setHardness(0.2F);
        this.setBlockName(BlockNames.IRONWOOD_LOG);
        this.setBlockTextureName(LibTextures.IRONWOOD_LOG);

    }

}
