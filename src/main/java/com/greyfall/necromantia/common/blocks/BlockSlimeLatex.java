package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSlimeLatex extends ModBlock {

	public BlockSlimeLatex() {
		super(Material.sponge);
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeSand);
		this.setBlockName(BlockNames.SLIME_LATEX);
		this.setBlockTextureName(LibTextures.SLIME_LATEX);
	}

}
