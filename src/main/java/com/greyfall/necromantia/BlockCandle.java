package com.greyfall.necromantia;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCandle extends BlockContainer {

	protected BlockCandle(Material material) {
		super(material);
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeWood);
		this.setBlockBounds(0.28125f,0f,0.28125f,0.71875f,1f,0.71875f);
	}


	//You don't want the normal render type, or it wont render properly.
	@Override
	public int getRenderType() {
		return Main.candleRenderID;
	}

	//It's not an opaque cube, so you need this.
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	//It's not a normal block, so you need this too.
	public boolean renderAsNormalBlock() {
		return false;
	}

	//This is the icon to use for showing the block in your hand.
	public void registerIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("nectomantia:candle_held");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityCandleEntity();
	}
}
