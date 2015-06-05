package com.greyfall.necromantia.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockIrontreebrick extends Block {

	protected BlockIrontreebrick(Material material) {
		super(material);
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeStone);
	}

}
