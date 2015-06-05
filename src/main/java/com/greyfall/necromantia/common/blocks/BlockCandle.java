package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.common.tiles.TileEntityCandleEntity;
import com.greyfall.necromantia.common.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCandle extends BlockContainer {

	public BlockCandle(Material material) {
		super(material);
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeWood);
		this.setBlockBounds(0.28125f,0f,0.28125f,0.71875f,1f,0.71875f);
		this.setLightLevel(1.0F);
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

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
	{
		int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
		double d0 = (double)((float)p_149734_2_ + 0.5F);
		double d1 = (double)((float)p_149734_3_ + 0.7F);
		double d2 = (double)((float)p_149734_4_ + 0.5F);
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;

		if (l == 1)
		{
			p_149734_1_.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			p_149734_1_.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		}
		else if (l == 2)
		{
			p_149734_1_.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			p_149734_1_.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		}
		else if (l == 3)
		{
			p_149734_1_.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
			p_149734_1_.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
		}
		else if (l == 4)
		{
			p_149734_1_.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
			p_149734_1_.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
		}
		else
		{
			p_149734_1_.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			p_149734_1_.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
}
