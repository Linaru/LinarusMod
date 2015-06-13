package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCrate extends ModBlock {

    //Multitexture variables
    public IIcon TopIcon;
    public IIcon SideIcon;

    public BlockCrate() {
        super(Material.ground);
        this.setHardness(0.3F);
        this.setBlockName(BlockNames.CRATE);
    }

    public void registerBlockIcons(IIconRegister icon)
    {
        TopIcon = icon.registerIcon(LibTextures.CRATE_TOP);
        SideIcon = icon.registerIcon(LibTextures.CRATE_SIDE);
    }

    public IIcon getIcon(int side, int meta)
    {
        switch (side)
        {
            case 0:
            case 1:
                return TopIcon;
            default:
                return SideIcon;
        }
    }

}