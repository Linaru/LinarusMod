package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockWorktop extends ModBlock {

    //Multitexture variables
    public IIcon BottomIcon;
    public IIcon TopIcon;
    public IIcon FrontIcon;
    public IIcon SideIcon;

    public BlockWorktop() {
        super(Material.ground);
        this.setHardness(0.3F);
        this.setBlockName(BlockNames.WORKTOP);
    }

    public void registerBlockIcons(IIconRegister icon)
    {
        BottomIcon = icon.registerIcon(LibTextures.WORKTOP_BOTTOM);
        TopIcon = icon.registerIcon(LibTextures.WORKTOP_TOP);
        FrontIcon = icon.registerIcon(LibTextures.WORKTOP_FRONT);
        SideIcon = icon.registerIcon(LibTextures.WORKTOP_SIDE);
    }

    public IIcon getIcon(int side, int meta)
    {
        switch (side)
        {
            case 0:
                return BottomIcon;
            case 1:
                return TopIcon;
            case 2:
                return FrontIcon;
            default:
                return SideIcon;
        }
    }

}