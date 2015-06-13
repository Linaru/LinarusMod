package com.greyfall.necromantia.common.blocks.wood;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.blocks.ModBlock;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockHardstone  extends ModBlock {

    public BlockHardstone() {
        super(Material.rock);
        this.setHardness(-1F);
        this.setBlockUnbreakable();
        this.setResistance(3000);
        this.setBlockName(BlockNames.HARDSTONE);
        this.setBlockTextureName(LibTextures.HARDSTONE);
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add("this rock is incredibly hard to mine through.");
    }
}
