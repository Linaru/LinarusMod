package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import com.greyfall.necromantia.common.libs.BlockNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockDungeonruinsbrick extends ModBlock {

    private int maxMeta = 9;

    private IIcon[] icons;
    public BlockDungeonruinsbrick() {
        super(Material.ground);
        this.setHardness(-1F);
        this.setBlockUnbreakable();
        this.setResistance(3000);
        this.setBlockName(BlockNames.DUNGEONRUINSBRICK);
        icons=new IIcon[maxMeta];

    }

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        icons[0]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICK);
        icons[1]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICKMOSSY);
        icons[2]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICKBOTTOM);
        icons[3]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICKDECORATIVE);
        icons[4]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICKDECORATIVEMOSSY);
        icons[5]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICKSIDE);
        icons[6]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICKSIDEMOSSY);
        icons[7]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICKTOP);
        icons[8]=p_149651_1_.registerIcon(LibTextures.DUNGEONRUINSBRICKTOPMOSSY);
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add(Main.blockLang.translate("dungeonRuinsBrick"));
    }

    @Override
    public int damageDropped(int p_149692_1_) {
        return p_149692_1_;
    }


    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        p_149666_3_.add(new ItemStack(this,1,0));
        p_149666_3_.add(new ItemStack(this,1,1));
        p_149666_3_.add(new ItemStack(this,1,2));
        p_149666_3_.add(new ItemStack(this,1,3));
        p_149666_3_.add(new ItemStack(this,1,4));
        p_149666_3_.add(new ItemStack(this,1,5));
        p_149666_3_.add(new ItemStack(this,1,6));
        p_149666_3_.add(new ItemStack(this,1,7));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        switch (p_149691_2_)
        {
            case 0: // block number
                switch (p_149691_1_)
                {
                    case 0: // top
                        return icons[0];
                    case 1:
                        return icons[0]; // bottom
                    case 2: // north
                        return icons[0];
                    case 3: // east
                        return icons[0];
                    case 4: // south
                        return icons[0];
                    case 5: // west
                        return icons[0];
                }
            case 1:
                switch (p_149691_1_)
                {
                    case 0: // top
                        return icons[1];
                    case 1:
                        return icons[1]; // bottom
                    case 2: // north
                        return icons[1];
                    case 3: // east
                        return icons[1];
                    case 4: // south
                        return icons[1];
                    case 5: // west
                        return icons[1];
                }
            case 2:
                switch (p_149691_1_)
                {
                    case 0: // top
                        return icons[2];
                    case 1:
                        return icons[2]; // bottom
                    case 2: // north
                        return icons[2];
                    case 3: // east
                        return icons[2];
                    case 4: // south
                        return icons[2];
                    case 5: // west
                        return icons[2];
                }
            case 3:
                switch (p_149691_1_)
                {
                    case 0: // top
                        return icons[3];
                    case 1:
                        return icons[3]; // bottom
                    case 2: // north
                        return icons[3];
                    case 3: // east
                        return icons[3];
                    case 4: // south
                        return icons[3];
                    case 5: // west
                        return icons[3];
                }
            case 4:
                switch (p_149691_1_)
                {
                    case 0: // top
                        return icons[4];
                    case 1:
                        return icons[4]; // bottom
                    case 2: // north
                        return icons[4];
                    case 3: // east
                        return icons[4];
                    case 4: // south
                        return icons[4];
                    case 5: // west
                        return icons[4];
                }
            case 5:
                return icons[5];
            case 6:
                return icons[6];
            case 7:
                return icons[7];
            default:
                return icons[0];
        }
    }


    @Override
    public EnumCreativeTab getCreativeTab() {
        return EnumCreativeTab.ADMIN;
    }
}
