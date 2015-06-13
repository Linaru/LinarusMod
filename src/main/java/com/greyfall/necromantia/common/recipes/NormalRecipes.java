package com.greyfall.necromantia.common.recipes;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.blocks.ModBlock;
import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.interop.BotaniaInterop;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class NormalRecipes {


    public static void addRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.cauldron), new Object[]{"I I", "I I", "III", 'I', Items.iron_ingot});
        //Pink Latex Block
        GameRegistry.addRecipe(new ItemStack(ModBlocks.slimeLatex), new Object[]{"LL", "LL", 'L', Main.itemSlimelatex});
        //Latex Block
        GameRegistry.addRecipe(new ItemStack(ModBlocks.latex), new Object[]{"LL", "LL", 'L', Main.itemLatex});
        //Ironwood
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.enchantedWood, 4), new ItemStack(ModBlocks.logIronwood));
        //Wax Block
        GameRegistry.addRecipe(new ItemStack(ModBlocks.wax), new Object[]{"WWW", "WWW", "WWW", 'W', Main.itemWax});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.crate), new Object[]{"III", "IWI", "III", 'I', Items.iron_ingot, 'W',"plankWood"});
        GameRegistry.addShapelessRecipe(new ItemStack(Main.itemWax, 9), new ItemStack(ModBlocks.wax));
        //candle
        GameRegistry.addRecipe(new ItemStack(ModBlocks.candle), new Object[]{"S", "W", "W", 'S', Items.string, 'W', Main.itemWax});
        //Gold Coin
        GameRegistry.addRecipe(new ItemStack(Main.itemGoldcoin), new Object[]{"GGG", "G G", "GGG", 'G', "nuggetGold"});
        //Mortar and pestle
        if (!Loader.isModLoaded("Botania")) {
            GameRegistry.addRecipe(new ItemStack(Main.itemMortar), new Object[]{" S", "W ", "B ", 'S', "stickWood", 'W', "plankWood", 'B', Items.bowl});
        }
        //Silica
        if (Loader.isModLoaded("Botania")) {
            BotaniaInterop.registerBotaniaRecepies();
        } else {
            GameRegistry.addShapelessRecipe(new ItemStack(Main.itemSilicondioxide, 5), new ItemStack(Items.quartz), new ItemStack(Main.itemMortar));
        }

        if(Loader.isModLoaded("Waila"))
        {
            FMLInterModComms.sendMessage("Waila", "register", "com.greyfall.necromantia.common.interop.waila.Waila.callbackRegister");
        }
        //Siliconerubber
        GameRegistry.addShapelessRecipe(new ItemStack(Main.itemSiliconerubber), new ItemStack(Main.itemSilicondioxide), new ItemStack(Items.coal));
        GameRegistry.addShapelessRecipe(new ItemStack(Main.itemSiliconerubber), new ItemStack(Main.itemSilicondioxide), new ItemStack(Blocks.sand));

        //armour
        //Pink latex
        GameRegistry.addRecipe(new ItemStack(Main.pinklatexHelmet), new Object[]{"LLL", "L L", 'L', Main.itemSlimelatex});
        GameRegistry.addRecipe(new ItemStack(Main.pinklatexChestplate), new Object[]{"L L", "LLL", "LLL", 'L', Main.itemSlimelatex});
        GameRegistry.addRecipe(new ItemStack(Main.pinklatexLeggings), new Object[]{"LLL", "L L", "L L", 'L', Main.itemSlimelatex});
        GameRegistry.addRecipe(new ItemStack(Main.pinklatexBoots), new Object[]{"L L", "L L", 'L', Main.itemSlimelatex});
        //Under Armour
        GameRegistry.addRecipe(new ItemStack(Main.siliconeHelmet), new Object[]{"LLL", "L L", 'L', Main.itemLatex});
        GameRegistry.addRecipe(new ItemStack(Main.siliconeChestplate), new Object[]{"S S", "LSL", "SSS", 'S', Main.itemSiliconerubber, 'L', Main.itemLatex});
        GameRegistry.addRecipe(new ItemStack(Main.siliconeLeggings), new Object[]{"LSL", "S S", "L L", 'S', Main.itemSiliconerubber, 'L', Main.itemLatex});
        GameRegistry.addRecipe(new ItemStack(Main.siliconeBoots), new Object[]{"L L", "L L", 'L', Main.itemLatex});

        addSmeltingRecipes();
    }




    public static void addSmeltingRecipes()
    {
        GameRegistry.addSmelting(Main.itemSlimelatex, new ItemStack(Main.itemLatex), 0.1f);
        GameRegistry.addSmelting(ModBlocks.slimeLatex, new ItemStack(ModBlocks.latex), 0.1f);


        addOreDictEntries();
    }

    public static void addOreDictEntries()
    {
        OreDictionary.registerOre("logWood",ModBlocks.logIronwood);
        OreDictionary.registerOre("plankWood", ModBlocks.enchantedWood);
    }
}
