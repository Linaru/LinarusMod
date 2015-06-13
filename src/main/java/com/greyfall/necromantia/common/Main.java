package com.greyfall.necromantia.common;

import codechicken.lib.util.LangProxy;
import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.books.BookEncyclopediaminecraftia1;
import com.greyfall.necromantia.common.core.CommonProxy;
import com.greyfall.necromantia.common.interop.BotaniaInterop;
import com.greyfall.necromantia.common.items.*;
import com.greyfall.necromantia.common.libs.LibMisc;
import com.greyfall.necromantia.common.mobs.EntityMain;

import com.greyfall.necromantia.common.recipes.CauldronRecipes;
import com.greyfall.necromantia.common.recipes.NormalRecipes;
import com.greyfall.necromantia.common.tiles.TileEntityCandle;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

/*

Teir System guide:
this little guide is to help keep track of the teir system.
the plan is to divide up mobs tools and technology into 5 teirs so as tog et a better understanding of balance.
players with a majority of teir 4 equipment will oten see teir 4 mobs spawn in the areas around them.

Teir 1 : Vanilla minecraft
Teir 2
Teir 3
Teir 4
Teir 5

*/
@Mod(modid = LibMisc.MOD_ID, name = LibMisc.MOD_NAME, version = LibMisc.MOD_VERSION)
public class Main {

    @Instance(LibMisc.MOD_ID)
    public static Main modInstance;


    @SidedProxy(clientSide = LibMisc.CLIENT_PROXY, serverSide = LibMisc.COMMON_PROXY)
    public static CommonProxy proxy;


    public static LangProxy itemLang =new LangProxy(LibMisc.MOD_ID+".item");
    public static LangProxy blockLang=new LangProxy(LibMisc.MOD_ID+".block");
    public static LangProxy lang=new LangProxy(LibMisc.MOD_ID);
    //items
    public static Item itemSlimelatex;
    public static Item itemLatex;
    public static Item itemSiliconerubber;
    public static Item itemGoldcoin;
    public static Item itemWax;
    public static Item itemSilicondioxide;
    public static Item itemRiceseeds;
    public static Item itemRice;
    public static Item itemRiceball;
    public static Item itemCookedapple;
    public static Item itemBoiledleather;
    //books
    public static Item bookEncyclopediaminecraftia1;
    //tools
    public static Item itemMortar;
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
    public static int candleRenderID;
    public static int cauldronRenderID;
    //Armour materials (set stats)
    public static final ItemArmor.ArmorMaterial pinklatexArmourMaterial = EnumHelper.addArmorMaterial("pinklatexArmourMaterial", 50, new int[]{2, 4, 3, 1,}, 30);
    public static final ItemArmor.ArmorMaterial siliconeArmourMaterial = EnumHelper.addArmorMaterial("siliconeMaterial", 1000, new int[]{1, 3, 2, 1,}, 30);
    public static Logger logger;



//==================================================================Seperator==================================================================//

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger=event.getModLog();
        EntityMain.mainRegistry(); //? not sure what is wrong here Entity tutorial did not explain this step.
        ModBlocks.registerBlocks();
        //Item and Block initialisation
        //items
        itemSlimelatex = new Slimelatex().setUnlocalizedName("ItemSlimelatex").setTextureName("necromantia:slimelatex").setCreativeTab(tabnecromantia); //item.itemTable
        itemLatex = new Latex().setUnlocalizedName("ItemLatex").setTextureName("necromantia:latex").setCreativeTab(tabnecromantia); //item.itemTable
        itemSiliconerubber = new Siliconerubber().setUnlocalizedName("ItemSiliconerubber").setTextureName("necromantia:siliconerubber").setCreativeTab(tabnecromantia); //item.itemTable
        itemGoldcoin = new Goldcoin().setUnlocalizedName("ItemGoldcoin").setTextureName("necromantia:goldcoin").setCreativeTab(tabnecromantia); //item.itemTable
        itemWax = new Wax().setUnlocalizedName("ItemWax").setTextureName("necromantia:wax").setCreativeTab(tabnecromantia); //item.itemTable
        itemRiceseeds = new Riceseeds().setUnlocalizedName("ItemRiceseeds").setTextureName("necromantia:rice_seeds").setCreativeTab(tabnecromantia); //item.itemTable
        itemRice = new Rice().setUnlocalizedName("ItemRice").setTextureName("necromantia:rice").setCreativeTab(tabnecromantia); //item.itemTable
        itemRiceball = new Riceball(6, 1.0F, false).setUnlocalizedName("Riceball").setTextureName("necromantia:riceball").setCreativeTab(tabnecromantia); //item.itemTable
        itemCookedapple = new Cookedapple(8, 1.0F, false).setUnlocalizedName("Cookedapple").setTextureName("necromantia:apple_cooked").setCreativeTab(tabnecromantia); //item.itemTable
        itemBoiledleather = new Boiledleather().setUnlocalizedName("Boiledleather").setTextureName("necromantia:leather_boiled").setCreativeTab(tabnecromantia); //item.itemTable
        itemSilicondioxide = new Silicondioxide().setUnlocalizedName("ItemSilicondioxide").setTextureName("necromantia:silica").setCreativeTab(tabnecromantia); //item.itemTable
        //books
        bookEncyclopediaminecraftia1 = new BookEncyclopediaminecraftia1().setUnlocalizedName("BookEncyclopediaminecraftia").setTextureName("necromantia:encyclopedia").setCreativeTab(tabnecromantia); //item.itemTable

        //tools
        itemMortar = new Mortar().setUnlocalizedName("ItemMortar").setTextureName("necromantia:mortar").setCreativeTab(tabnecromantia); //item.itemTable
        //blocks
        //Machines

        //todo add item that catches nekosune's and puts them in a box for me to take home
        //armour
        //Pink Latex
        pinklatexHelmet = new ItemPinklatexArmour(pinklatexArmourMaterial, 0, 0).setUnlocalizedName("ItemPinklatexHelmet").setTextureName("necromantia:itempinklatexhelm").setCreativeTab(tabnecromantiaarmor);
        pinklatexChestplate = new ItemPinklatexArmour(pinklatexArmourMaterial, 0, 1).setUnlocalizedName("ItemPinklatexChestplate").setTextureName("necromantia:itempinklatexchest").setCreativeTab(tabnecromantiaarmor);
        pinklatexLeggings = new ItemPinklatexArmour(pinklatexArmourMaterial, 0, 2).setUnlocalizedName("ItemPinklatexLeggings").setTextureName("necromantia:itempinklatexleggings").setCreativeTab(tabnecromantiaarmor);
        pinklatexBoots = new ItemPinklatexArmour(pinklatexArmourMaterial, 0, 3).setUnlocalizedName("ItemPinklatexBoots").setTextureName("necromantia:itempinklatexboots").setCreativeTab(tabnecromantiaarmor);
        //Under Armour
        siliconeHelmet = new ItemSiliconeArmour(siliconeArmourMaterial, 0, 0).setUnlocalizedName("ItemSiliconeHelmet").setTextureName("necromantia:itemsiliconehelm").setCreativeTab(tabnecromantiaarmor);
        siliconeChestplate = new ItemSiliconeArmour(siliconeArmourMaterial, 0, 1).setUnlocalizedName("ItemSiliconeChestplate").setTextureName("necromantia:itemsiliconechest").setCreativeTab(tabnecromantiaarmor);
        siliconeLeggings = new ItemSiliconeArmour(siliconeArmourMaterial, 0, 2).setUnlocalizedName("ItemSiliconeLeggings").setTextureName("necromantia:itemsiliconeleggings").setCreativeTab(tabnecromantiaarmor);
        siliconeBoots = new ItemSiliconeArmour(siliconeArmourMaterial, 0, 3).setUnlocalizedName("ItemSiliconeBoots").setTextureName("necromantia:itemsiliconeboots").setCreativeTab(tabnecromantiaarmor);

        //Item and Block registration
        //items
        GameRegistry.registerItem(itemSlimelatex, itemSlimelatex.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemLatex, itemLatex.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemSiliconerubber, itemSiliconerubber.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemGoldcoin, itemGoldcoin.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemWax, itemWax.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemRiceseeds, itemRiceseeds.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemRice, itemRice.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemRiceball, itemRiceball.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCookedapple, itemCookedapple.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemBoiledleather, itemBoiledleather.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemSilicondioxide, itemSilicondioxide.getUnlocalizedName().substring(5));
        //Books
        GameRegistry.registerItem(bookEncyclopediaminecraftia1, bookEncyclopediaminecraftia1.getUnlocalizedName().substring(5));
        //tools
        GameRegistry.registerItem(itemMortar, itemMortar.getUnlocalizedName().substring(5));
        //blocks
        //machines

        //armours
        GameRegistry.registerItem(pinklatexHelmet, pinklatexHelmet.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pinklatexChestplate, pinklatexChestplate.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pinklatexLeggings, pinklatexLeggings.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pinklatexBoots, pinklatexBoots.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(siliconeHelmet, siliconeHelmet.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(siliconeChestplate, siliconeChestplate.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(siliconeLeggings, siliconeLeggings.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(siliconeBoots, siliconeBoots.getUnlocalizedName().substring(5));
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //Proxy, TileEntity, entity, Gui and Packet Registering
        proxy.init();
        proxy.registerRenderThings();
        CauldronRecipes.initRecipes();
        NormalRecipes.addRecipes();
        //Crafting Recipes
        //Cauldron


        //Smelting Recipes


    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    //Creative tabs
    public static CreativeTabs tabnecromantia = new CreativeTabs("tabnecromantia") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(ModBlocks.slimeLatex).getItem();
        }
    };

    public static CreativeTabs tabnecromantiaarmor = new CreativeTabs("tabnecromantia.armor") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(siliconeChestplate).getItem();
        }
    };

    public static CreativeTabs tabnecromantiaadmin = new CreativeTabs("tabnecromantia.admin") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(ModBlocks.adminstone).getItem();
        }
    };

}