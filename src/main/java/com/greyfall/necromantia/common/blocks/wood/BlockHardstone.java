package com.greyfall.necromantia.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockHardstone  extends Block {

    public BlockHardstone(Material material) {
        super(material);
        this.setHardness(-1F);
        this.setBlockUnbreakable();
        this.setResistance(3000);
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add("this rock is incredibly hard to mine through.");
    }
}
