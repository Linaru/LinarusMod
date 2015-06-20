package com.greyfall.necromantia.common.items;

import java.util.List;

import com.greyfall.necromantia.client.libs.LibItemTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.ItemNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSilverCoin extends ModItem {

    public ItemSilverCoin() {
        super();
        this.setUnlocalizedName(ItemNames.SILVER_COIN);
        this.setTextureName(LibItemTextures.SILVER_COIN);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
        list.add(Main.itemLang.translate("silverCoin"));
    }

}
