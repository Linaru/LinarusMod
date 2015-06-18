package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDungeonRuinsWood extends ModBlock {

    public BlockDungeonRuinsWood()
    {
        super(Material.wood);
        this.setHardness(-1F);
        this.setBlockUnbreakable();
        this.setResistance(3000);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName(BlockNames.DUNGEON_RUINS_WOOD);
        this.setBlockTextureName(LibTextures.DUNGEONRUINSWOOD);
    }

}
