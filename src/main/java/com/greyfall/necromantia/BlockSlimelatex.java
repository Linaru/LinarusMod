package com.greyfall.necromantia;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSlimelatex extends Block {

	protected BlockSlimelatex(Material material) {
		super(material);
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeSand);
	}

}