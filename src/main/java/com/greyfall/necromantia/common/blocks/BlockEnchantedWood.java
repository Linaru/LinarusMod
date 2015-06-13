package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEnchantedWood extends ModBlock {

    public BlockEnchantedWood() {
        super(Material.wood);
        this.setHardness(0.6F);
        this.setBlockName(BlockNames.ENCHANTED_WOOD);
        this.setBlockTextureName(LibTextures.ENCHANTED_WOOD);
    }

}
