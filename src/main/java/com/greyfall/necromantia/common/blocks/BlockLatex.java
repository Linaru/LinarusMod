package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLatex extends ModBlock {

	public BlockLatex() {
		super(Material.sponge);
		this.setHardness(0.2F);
		this.setStepSound(new CustomStepSound("Latex",1.0F,1.0F));
		this.setBlockName(BlockNames.LATEX);
        setBlockTextureName(LibTextures.LATEX);
	}

}
