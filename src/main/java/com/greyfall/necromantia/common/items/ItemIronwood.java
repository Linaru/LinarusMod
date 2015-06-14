package com.greyfall.necromantia.common.items;

import com.greyfall.necromantia.client.libs.LibItemTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.ItemNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemIronwood extends ModItem {

    public ItemIronwood() {
        super();
        this.setUnlocalizedName(ItemNames.IRONWOOD);
        this.setTextureName(LibItemTextures.IRONWOOD);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show)
    {
        list.add(Main.itemLang.translate("ironwood"));
    }

}