package com.greyfall.necromantia.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLatex extends Block {

	public BlockLatex(Material material) {
		super(material);
		this.setHardness(0.2F);
		this.setStepSound(new CustomStepSound("Latex",1.0F,1.0F));
	}

}
