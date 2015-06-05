package com.greyfall.necromantia.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockCauldron extends Block {

    public BlockCauldron(Material material) {
        super(material);
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeMetal);
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add("Used for the process of Boiling ingredients.");
    }

}
