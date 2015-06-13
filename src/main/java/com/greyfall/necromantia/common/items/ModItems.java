package com.greyfall.necromantia.common.items;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.items.armor.pinkLatex.*;
import com.greyfall.necromantia.common.items.armor.silicone.*;
import com.greyfall.necromantia.common.libs.ItemNames;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by Katrina on 13/06/2015.
 */
public class ModItems {

    //items
    public static Item slimeLatex;
    public static Item latex;
    public static Item siliconeRubber;
    public static Item goldCoin;
    public static Item wax;
    public static Item siliconDioxide;
    public static Item riceSeeds;
    public static Item rice;
    public static Item riceBall;
    public static Item cookedApple;
    public static Item boiledLeather;
    //books
    public static Item bookEncyclopediaMinecraftia1;
    //tools
    public static Item mortar;
    //blocks
    //Machines

    //Armour
    public static Item pinklatexHelmet;
    public static Item pinklatexChestplate;
    public static Item pinklatexLeggings;
    public static Item pinklatexBoots;
    public static Item siliconeHelmet;
    public static Item siliconeChestplate;
    public static Item siliconeLeggings;
    public static Item siliconeBoots;

    public static void registerItems()
    {
        slimeLatex = new ItemSlimeLatex();
        latex = new ItemLatex();
        siliconeRubber = new ItemSiliconeRubber();
        goldCoin = new ItemGoldCoin();
        wax = new ItemWax();
        riceSeeds = new ItemRiceSeeds();
        rice = new ItemRice();
        riceBall = new ItemRiceBall(6, 1.0F, false);
        cookedApple = new ItemCookedApple(8, 1.0F, false);
        boiledLeather = new ItemBoiledLeather();
        siliconDioxide = new ItemSiliconDioxide();
        //books
        //bookEncyclopediaMinecraftia1 = new BookEncyclopediaminecraftia1().setUnlocalizedName("BookEncyclopediaminecraftia").setTextureName("necromantia:encyclopedia").setCreativeTab(tabnecromantia); //item.itemTable
        // TODO: Readd in books

        //tools
        mortar = new ItemMortar();
        //Pink Latex
        pinklatexHelmet = new ItemPinkLatexHelmet();
        pinklatexChestplate = new ItemPinkLatexChestplate();
        pinklatexLeggings = new ItemPinkLatexLeggings();
        pinklatexBoots = new ItemPinkLatexBoots();
        //Under Armour
        siliconeHelmet = new ItemSiliconeHelmet();
        siliconeChestplate = new ItemSiliconeChestplate();
        siliconeLeggings = new ItemSiliconeLeggings();
        siliconeBoots = new ItemSiliconeBoots();

    registerItemData();
    }

    public static void registerItemData()
    {
        GameRegistry.registerItem(slimeLatex, ItemNames.SLIME_LATEX);
        GameRegistry.registerItem(latex, ItemNames.LATEX);
        GameRegistry.registerItem(siliconeRubber, ItemNames.SILICONE_RUBBER);
        GameRegistry.registerItem(goldCoin, ItemNames.GOLD_COIN);
        GameRegistry.registerItem(wax, ItemNames.WAX);
        GameRegistry.registerItem(riceSeeds, ItemNames.RICE_SEEDS);
        GameRegistry.registerItem(rice, ItemNames.RICE);
        GameRegistry.registerItem(riceBall, ItemNames.RICE_BALL);
        GameRegistry.registerItem(cookedApple, ItemNames.COOKED_APPLE);
        GameRegistry.registerItem(boiledLeather, ItemNames.BOILED_LEATHER);
        GameRegistry.registerItem(siliconDioxide, ItemNames.SILICON_DIOXIDE);
        //Books
        //GameRegistry.registerItem(bookEncyclopediaMinecraftia1, bookEncyclopediaminecraftia1);
        //tools
        GameRegistry.registerItem(mortar, ItemNames.MORTAR);
        //blocks
        //machines

        //armours
        GameRegistry.registerItem(pinklatexHelmet, ItemNames.PINK_LATEX_HELMET);
        GameRegistry.registerItem(pinklatexChestplate, ItemNames.PINK_LATEX_CHESTPLATE);
        GameRegistry.registerItem(pinklatexLeggings, ItemNames.PINK_LATEX_LEGGINGS);
        GameRegistry.registerItem(pinklatexBoots, ItemNames.PINK_LATEX_BOOTS);
        GameRegistry.registerItem(siliconeHelmet, ItemNames.SILICONE_HELMET);
        GameRegistry.registerItem(siliconeChestplate, ItemNames.SILICONE_CHESTPLATE);
        GameRegistry.registerItem(siliconeLeggings, ItemNames.SILICONE_LEGGINGS);
        GameRegistry.registerItem(siliconeBoots, ItemNames.SILICONE_BOOTS);
    }
}
