package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockLatex extends ModBlock {

	private int maxMeta = 2;

	private IIcon[] icons;
	public BlockLatex() {
		super(Material.sponge);
		this.setHardness(0.2F);
		this.setStepSound(new CustomStepSound("Latex",1.0F,1.0F));
		this.setBlockName(BlockNames.LATEX);
		icons=new IIcon[maxMeta];
	}

	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		icons[0]=p_149651_1_.registerIcon(LibTextures.LATEX);
		icons[1]=p_149651_1_.registerIcon(LibTextures.SLIME_LATEX);
	}


	@Override
	public int damageDropped(int p_149692_1_) {
		return p_149692_1_;
	}


	@Override
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
		p_149666_3_.add(new ItemStack(this,1,0));
		p_149666_3_.add(new ItemStack(this,1,1));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		switch (p_149691_2_)
		{
			case 0:
				return icons[0];
			case 1:
				return icons[1];
			default:
				return icons[0];
		}
	}
}
