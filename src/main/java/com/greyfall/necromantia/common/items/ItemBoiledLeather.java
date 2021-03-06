package com.greyfall.necromantia.common.items;

import java.util.List;

import com.greyfall.necromantia.client.libs.LibItemTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.ItemNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBoiledLeather extends ModItem {

    public ItemBoiledLeather() {
        super();
        this.setUnlocalizedName(ItemNames.BOILED_LEATHER);
        this.setTextureName(LibItemTextures.BOILED_LEATHER);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
    {
        list.add(Main.itemLang.translate("boiledLeather.info1"));
        list.add(Main.itemLang.translate("boiledLeather.info2"));
    }

}
