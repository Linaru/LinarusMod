package com.greyfall.necromantia.common;

import codechicken.lib.util.LangProxy;
import com.greyfall.necromantia.common.blocks.*;
import com.greyfall.necromantia.common.blocks.BlockHardstone;
import com.greyfall.necromantia.common.blocks.wood.BlockLeavesironwood;
import com.greyfall.necromantia.common.blocks.wood.BlockLogironwood;
import com.greyfall.necromantia.common.blocks.wood.BlockLogironwoodore;
import com.greyfall.necromantia.common.books.BookEncyclopediaminecraftia1;
import com.greyfall.necromantia.common.core.CommonProxy;
import com.greyfall.necromantia.common.dimensions.BlockEtherealportal;
import com.greyfall.necromantia.common.interop.BotaniaInterop;
import com.greyfall.necromantia.common.interop.NEI.NEINecromantiaConfig;
import com.greyfall.necromantia.common.items.*;
import com.greyfall.necromantia.common.mobs.EntityMain;

import com.greyfall.necromantia.common.recipes.CauldronRecipes;
import com.greyfall.necromantia.common.tiles.TileEntityCandleEntity;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
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
@Mod(modid = "necromantia", name = "Necromantia", version = "Carrot.1.0")
public class Main {

    @Instance("necromantia")
    public static Main modInstance;

    public static String MODID = "modid";
    public static String VERSION = "version";

    @SidedProxy(clientSide = "com.greyfall.necromantia.client.core.ClientProxy", serverSide = "com.greyfall.necromantia.common.core.CommonProxy")
    public static CommonProxy proxy;


    public static LangProxy itemLang =new LangProxy("necromantia.item");
    public static LangProxy blockLang=new LangProxy("necromantia.block");
    public static LangProxy lang=new LangProxy("necromantia");
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
    public static Block blockCauldron;
    //Containers
    public static Block blockCuboard;
    //standard blocks
    public static Block blockSlimelatex;
    public static Block blockLatex;
    public static Block blockWax;
    public static Block blockCrate;
    public static Block blockEnchantedwood;
    public static Block blockCandle;
    public static Block blockIrontreebrick;
    public static Block blockLogironwood;
    public static Block blockLogironwoodore;
    public static Block blockLeavesironwood;
    public static Block blockWildrice;
    public static Block blockRune;
    public static Block blockHardstone;
    public static Block blockEtherealportal;
    //Admin blocks
    public static Block blockAdminstone;
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
        blockCauldron = new BlockCauldron(Material.ground).setBlockName("BlockCauldron").setCreativeTab(tabnecromantia);
        //containers
        blockCuboard = new BlockCuboard(Material.ground).setBlockName("BlockCuboard").setCreativeTab(tabnecromantia);
        //standard blocks
        blockSlimelatex = new BlockSlimelatex(Material.sponge).setBlockName("BlockSlimelatex").setBlockTextureName("necromantia:pinklatexblock").setCreativeTab(tabnecromantia);
        blockLatex = new BlockLatex(Material.sponge).setBlockName("BlockLatex").setBlockTextureName("necromantia:latexblock").setCreativeTab(tabnecromantia);
        blockWax = new BlockWax(Material.ground).setBlockName("BlockWax").setCreativeTab(tabnecromantia);
        blockCrate = new BlockCrate(Material.ground).setBlockName("BlockCrate").setCreativeTab(tabnecromantia);
        blockEnchantedwood = new BlockEnchantedwood(Material.wood).setBlockName("BlockEnchantedwood").setBlockTextureName("necromantia:enchantedwood").setCreativeTab(tabnecromantia);
        blockCandle = new BlockCandle(Material.ground).setBlockName("BlockCandle").setBlockTextureName("necromantia:candle").setCreativeTab(tabnecromantia);
        blockIrontreebrick = new BlockIrontreebrick(Material.ground).setBlockName("BlockIrontreebrick").setBlockTextureName("necromantia:irontreebrick").setCreativeTab(tabnecromantia);
        blockLogironwood = new BlockLogironwood(Material.wood).setBlockName("BlockLogironwood").setBlockTextureName("necromantia:log_ironwood").setCreativeTab(tabnecromantia);
        blockLogironwoodore = new BlockLogironwoodore(Material.wood).setBlockName("BlockLogironwoodore").setBlockTextureName("necromantia:log_ironwood_ore").setCreativeTab(tabnecromantia);
        blockLeavesironwood = new BlockLeavesironwood(Material.leaves).setBlockName("BlockLeavesironwood").setBlockTextureName("necromantia:leaves_ironwood_opaque").setCreativeTab(tabnecromantia);
        blockWildrice = new BlockWildrice(Material.grass).setBlockName("BlockWildrice").setBlockTextureName("necromantia:ricecrop_3").setCreativeTab(tabnecromantia);
        blockRune = new BlockRune(Material.ground).setBlockName("BlockRune").setBlockTextureName("necromantia:runes/y_base").setCreativeTab(tabnecromantia);
        blockHardstone = new BlockHardstone(Material.rock).setBlockName("BlockHardstone").setBlockTextureName("necromantia:stone_hard").setCreativeTab(tabnecromantia);
        blockEtherealportal = new BlockEtherealportal().setBlockName("BlockblockEtherealportal").setBlockTextureName("necromantia:etherealportal").setCreativeTab(tabnecromantia);


        //Admin blocks
        blockAdminstone = new BlockAdminstone(Material.ground).setBlockName("BlockAdminstone").setBlockTextureName("necromantia:irontreebrick").setCreativeTab(tabnecromantiaadmin);
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
        GameRegistry.registerBlock(blockCauldron, blockCauldron.getUnlocalizedName().substring(5));
        // Containers
        GameRegistry.registerBlock(blockCuboard, blockCuboard.getUnlocalizedName().substring(5));
        // standard blocks
        GameRegistry.registerBlock(blockSlimelatex, blockSlimelatex.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockLatex, blockLatex.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockWax, blockWax.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockCrate, blockCrate.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockEnchantedwood, blockEnchantedwood.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockIrontreebrick, blockIrontreebrick.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockLogironwood, blockLogironwood.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockLogironwoodore, blockLogironwoodore.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockLeavesironwood, blockLeavesironwood.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockWildrice, blockWildrice.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockRune, blockRune.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockHardstone, blockHardstone.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockEtherealportal, blockEtherealportal.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockCandle, blockCandle.getUnlocalizedName().substring(5));
        GameRegistry.registerTileEntity(TileEntityCandleEntity.class, "tileEntityCandle");
        //Admin blocks
        GameRegistry.registerBlock(blockAdminstone, blockAdminstone.getUnlocalizedName().substring(5));
        //armours
        GameRegistry.registerItem(pinklatexHelmet, pinklatexHelmet.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pinklatexChestplate, pinklatexChestplate.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pinklatexLeggings, pinklatexLeggings.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pinklatexBoots, pinklatexBoots.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(siliconeHelmet, siliconeHelmet.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(siliconeChestplate, siliconeChestplate.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(siliconeLeggings, siliconeLeggings.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(siliconeBoots, siliconeBoots.getUnlocalizedName().substring(5));


        //register Tile Entities
        GameRegistry.registerTileEntity(TileEntityCandleEntity.class,"candle");
        GameRegistry.registerTileEntity(TileEntityCauldron.class,"cauldron");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //Proxy, TileEntity, entity, Gui and Packet Registering
        proxy.init();
        proxy.registerRenderThings();
        CauldronRecipes.initRecipes();

        //Crafting Recipes
        //Cauldron
        GameRegistry.addRecipe(new ItemStack(blockCauldron), new Object[]{"I I", "I I", "III", 'I', Items.iron_ingot});
        //Pink Latex Block
        GameRegistry.addRecipe(new ItemStack(blockSlimelatex), new Object[]{"LL", "LL", 'L', Main.itemSlimelatex});
        //Latex Block
        GameRegistry.addRecipe(new ItemStack(blockLatex), new Object[]{"LL", "LL", 'L', Main.itemLatex});
        //Ironwood
        GameRegistry.addShapelessRecipe(new ItemStack(Main.blockEnchantedwood, 4), new ItemStack(blockLogironwood));
        //Wax Block
        GameRegistry.addRecipe(new ItemStack(blockWax), new Object[]{"WWW", "WWW", "WWW", 'W', Main.itemWax});
        GameRegistry.addRecipe(new ItemStack(blockCrate), new Object[]{"III", "IEI", "III", 'I', Items.iron_ingot, 'E', Main.blockEnchantedwood});
        GameRegistry.addRecipe(new ItemStack(blockCrate), new Object[]{"III", "IWI", "III", 'I', Items.iron_ingot, 'W', Blocks.planks});
        GameRegistry.addShapelessRecipe(new ItemStack(Main.itemWax, 9), new ItemStack(Main.blockWax));
        //candle
        GameRegistry.addRecipe(new ItemStack(blockCandle), new Object[]{"S", "W", "W", 'S', Items.string, 'W', Main.itemWax});
        //Gold Coin
        GameRegistry.addRecipe(new ItemStack(itemGoldcoin), new Object[]{"GGG", "G G", "GGG", 'G', Items.gold_nugget});
        //Mortar and pestle
        if (!Loader.isModLoaded("Botania")) {
            GameRegistry.addRecipe(new ItemStack(itemMortar), new Object[]{" S", "W ", "B ", 'S', Items.stick, 'W', Blocks.planks, 'B', Items.bowl});
        }
        //Silica
        if (Loader.isModLoaded("Botania")) {
            BotaniaInterop.registerBotaniaRecepies();
        } else {
            GameRegistry.addShapelessRecipe(new ItemStack(Main.itemSilicondioxide, 5), new ItemStack(Items.quartz), new ItemStack(Main.itemMortar));
        }

        if(Loader.isModLoaded("Waila"))
        {
            FMLInterModComms.sendMessage("Waila","register","com.greyfall.necromantia.common.interop.waila.Waila.callbackRegister");
        }
        //Siliconerubber
        GameRegistry.addShapelessRecipe(new ItemStack(itemSiliconerubber), new ItemStack(Main.itemSilicondioxide), new ItemStack(Items.coal));
        GameRegistry.addShapelessRecipe(new ItemStack(itemSiliconerubber), new ItemStack(Main.itemSilicondioxide), new ItemStack(Blocks.sand));

        //armour
        //Pink latex
        GameRegistry.addRecipe(new ItemStack(pinklatexHelmet), new Object[]{"LLL", "L L", 'L', Main.itemSlimelatex});
        GameRegistry.addRecipe(new ItemStack(pinklatexChestplate), new Object[]{"L L", "LLL", "LLL", 'L', Main.itemSlimelatex});
        GameRegistry.addRecipe(new ItemStack(pinklatexLeggings), new Object[]{"LLL", "L L", "L L", 'L', Main.itemSlimelatex});
        GameRegistry.addRecipe(new ItemStack(pinklatexBoots), new Object[]{"L L", "L L", 'L', Main.itemSlimelatex});
        //Under Armour
        GameRegistry.addRecipe(new ItemStack(siliconeHelmet), new Object[]{"LLL", "L L", 'L', Main.itemLatex});
        GameRegistry.addRecipe(new ItemStack(siliconeChestplate), new Object[]{"S S", "LSL", "SSS", 'S', Main.itemSiliconerubber, 'L', Main.itemLatex});
        GameRegistry.addRecipe(new ItemStack(siliconeLeggings), new Object[]{"LSL", "S S", "L L", 'S', Main.itemSiliconerubber, 'L', Main.itemLatex});
        GameRegistry.addRecipe(new ItemStack(siliconeBoots), new Object[]{"L L", "L L", 'L', Main.itemLatex});

        //Smelting Recipes
        GameRegistry.addSmelting(Main.itemSlimelatex, new ItemStack(Main.itemLatex), 0.1f);
        GameRegistry.addSmelting(Main.blockSlimelatex, new ItemStack(Main.blockLatex), 0.1f);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    //Creative tabs
    public static CreativeTabs tabnecromantia = new CreativeTabs("tabnecromantia") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(blockSlimelatex).getItem();
        }
    };

    public static CreativeTabs tabnecromantiaarmor = new CreativeTabs("tabnecromantia") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(siliconeChestplate).getItem();
        }
    };

    public static CreativeTabs tabnecromantiaadmin = new CreativeTabs("tabnecromantia") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(blockAdminstone).getItem();
        }
    };

}