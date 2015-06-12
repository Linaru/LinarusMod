package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.common.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockAdminstone  extends Block {

    public BlockAdminstone(Material material) {
        super(material);
        this.setHardness(-1F);
        this.setBlockUnbreakable();
        this.setResistance(3000);
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add(Main.blockLang.translate("adminStone"));
    }
}
