package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockAdminstone  extends ModBlock {

    public BlockAdminstone() {
        super(Material.ground);
        this.setHardness(-1F);
        this.setBlockUnbreakable();
        this.setResistance(3000);
        this.setBlockName(BlockNames.ADMINSTONE);
        this.setBlockTextureName(LibTextures.ADMINSTONE);
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add(Main.blockLang.translate("adminStone"));
    }


    @Override
    public EnumCreativeTab getCreativeTab() {
        return EnumCreativeTab.ADMIN;
    }
}
