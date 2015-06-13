package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIrontreeBrick extends ModBlock {

	public BlockIrontreeBrick() {
		super(Material.ground);
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeStone);
		this.setBlockName(BlockNames.IRONTREE_BRICK);
		this.setBlockTextureName(LibTextures.IRONTREE_BRICk);
	}

}
