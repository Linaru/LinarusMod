package com.greyfall.necromantia.common.items;

import java.util.List;

import com.greyfall.necromantia.client.libs.LibItemTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.ItemNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCopperCoin extends ModItem {

    public ItemCopperCoin() {
        super();
        this.setUnlocalizedName(ItemNames.COPPER_COIN);
        this.setTextureName(LibItemTextures.COPPER_COIN);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
        list.add(Main.itemLang.translate("copperCoin"));
    }

}
