package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.libs.BlockNames;
import com.greyfall.necromantia.common.tiles.TileEntityCandle;
import com.greyfall.necromantia.common.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlockCandle extends ModBlockContainer {

	public BlockCandle() {
		super(Material.ground);
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeWood);
		this.setBlockBounds(0.28125f,0f,0.28125f,0.71875f,1f,0.71875f);
		this.setLightLevel(1.0F);
		this.setBlockName(BlockNames.CANDLE);
		this.setBlockTextureName(LibTextures.CANDLE);

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
		return new TileEntityCandle();
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

	private boolean func_150107_m(World p_150107_1_, int p_150107_2_, int p_150107_3_, int p_150107_4_)
	{
		if (World.doesBlockHaveSolidTopSurface(p_150107_1_, p_150107_2_, p_150107_3_, p_150107_4_))
		{
			return true;
		}
		else
		{
			Block block = p_150107_1_.getBlock(p_150107_2_, p_150107_3_, p_150107_4_);
			return block.canPlaceTorchOnTop(p_150107_1_, p_150107_2_, p_150107_3_, p_150107_4_);
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
	{
		return func_150107_m(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
	}

	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	{
		this.func_150108_b(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
	}

	protected boolean func_150108_b(World p_150108_1_, int p_150108_2_, int p_150108_3_, int p_150108_4_, Block p_150108_5_)
	{
		if (this.func_150109_e(p_150108_1_, p_150108_2_, p_150108_3_, p_150108_4_))
		{
			boolean flag = false;

			if (!this.func_150107_m(p_150108_1_, p_150108_2_, p_150108_3_ - 1, p_150108_4_))
			{
				flag = true;
			}

			if (flag)
			{
				this.dropBlockAsItem(p_150108_1_, p_150108_2_, p_150108_3_, p_150108_4_, p_150108_1_.getBlockMetadata(p_150108_2_, p_150108_3_, p_150108_4_), 0);
				p_150108_1_.setBlockToAir(p_150108_2_, p_150108_3_, p_150108_4_);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}

	protected boolean func_150109_e(World p_150109_1_, int p_150109_2_, int p_150109_3_, int p_150109_4_)
	{
		if (!this.canPlaceBlockAt(p_150109_1_, p_150109_2_, p_150109_3_, p_150109_4_))
		{
			if (p_150109_1_.getBlock(p_150109_2_, p_150109_3_, p_150109_4_) == this)
			{
				this.dropBlockAsItem(p_150109_1_, p_150109_2_, p_150109_3_, p_150109_4_, p_150109_1_.getBlockMetadata(p_150109_2_, p_150109_3_, p_150109_4_), 0);
				p_150109_1_.setBlockToAir(p_150109_2_, p_150109_3_, p_150109_4_);
			}

			return false;
		}
		else
		{
			return true;
		}
	}
}
