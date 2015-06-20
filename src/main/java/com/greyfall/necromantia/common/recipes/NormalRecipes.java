package com.greyfall.necromantia.common.recipes;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.blocks.ModBlock;
import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.interop.BotaniaInterop;
import com.greyfall.necromantia.common.items.ModItem;
import com.greyfall.necromantia.common.items.ModItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Created by Katrina on 13/06/2015.
 */

public class NormalRecipes {


    public static void addRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.cauldron), new Object[]{"I I", "I I", "IXI", 'I', Items.iron_ingot, 'X', Blocks.furnace});
        //Pink Latex Block
        GameRegistry.addRecipe(new ItemStack(ModBlocks.latex,1,1), new Object[]{"LL", "LL", 'L', ModItems.slimeLatex});
        //Latex Block
        GameRegistry.addRecipe(new ItemStack(ModBlocks.latex), new Object[]{"LL", "LL", 'L', ModItems.latex});
        //Ironwood
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.enchantedWood, 4), new ItemStack(ModBlocks.logIronwood));
        //Wax Block
        GameRegistry.addRecipe(new ItemStack(ModBlocks.wax), new Object[]{"WWW", "WWW", "WWW", 'W', ModItems.wax});
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.crate), new Object[]{"III", "IWI", "III", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('W'),"plankWood"}));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.wax, 9), new ItemStack(ModBlocks.wax));
        //candle
        GameRegistry.addRecipe(new ItemStack(ModBlocks.candle), new Object[]{"S", "W", "W", 'S', Items.string, 'W', ModItems.wax});
        //Coins
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.goldCoin), new Object[]{"GGG", "G G", "GGG", Character.valueOf('G'), "nuggetGold"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.goldCoin), new Object[]{"SSS", "SSS", "SSS", Character.valueOf('S'), ModItems.silverCoin}));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.silverCoin), new Object[]{"CCC", "CCC", "CCC", Character.valueOf('C'), ModItems.copperCoin}));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.goldCoin),new ItemStack(ModItems.silverCoin,9));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.silverCoin),new ItemStack(ModItems.copperCoin,9));

        //Mortar and pestle
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mortar), new Object[]{" S", "W ", "B ", Character.valueOf('S'), "stickWood", Character.valueOf('W'), "plankWood", Character.valueOf('B'), Items.bowl}));
        //Silica

            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.siliconDioxide, 5), new ItemStack(Items.quartz),"pestleAndMortar"));

        //Siliconerubber
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.siliconeRubber), new ItemStack(ModItems.siliconDioxide), new ItemStack(Items.coal));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.siliconeRubber), new ItemStack(ModItems.siliconDioxide), new ItemStack(Blocks.sand));

        //armour
        //Pink latex
        GameRegistry.addRecipe(new ItemStack(ModItems.pinklatexHelmet), new Object[]{"LLL", "L L", 'L', ModItems.slimeLatex});
        GameRegistry.addRecipe(new ItemStack(ModItems.pinklatexChestplate), new Object[]{"L L", "LLL", "LLL", 'L', ModItems.slimeLatex});
        GameRegistry.addRecipe(new ItemStack(ModItems.pinklatexLeggings), new Object[]{"LLL", "L L", "L L", 'L', ModItems.slimeLatex});
        GameRegistry.addRecipe(new ItemStack(ModItems.pinklatexBoots), new Object[]{"L L", "L L", 'L', ModItems.slimeLatex});
        //Under Armour
        GameRegistry.addRecipe(new ItemStack(ModItems.siliconeHelmet), new Object[]{"LLL", "L L", 'L', ModItems.latex});
        GameRegistry.addRecipe(new ItemStack(ModItems.siliconeChestplate), new Object[]{"S S", "LSL", "SSS", 'S', ModItems.siliconeRubber, 'L', ModItems.latex});
        GameRegistry.addRecipe(new ItemStack(ModItems.siliconeLeggings), new Object[]{"LSL", "S S", "L L", 'S', ModItems.siliconeRubber, 'L', ModItems.latex});
        GameRegistry.addRecipe(new ItemStack(ModItems.siliconeBoots), new Object[]{"L L", "L L", 'L', ModItems.latex});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.riceSeeds),new ItemStack(ModItems.rice));
        addSmeltingRecipes();
    }




    public static void addSmeltingRecipes()
    {
        GameRegistry.addSmelting(ModItems.slimeLatex, new ItemStack(ModItems.latex), 0.1f);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.latex,1,1), new ItemStack(ModBlocks.latex), 0.1f);
        GameRegistry.addSmelting(ModItems.ironwood, new ItemStack(Items.iron_ingot), 0.1f);


        addOreDictEntries();
    }

    public static void addOreDictEntries()
    {
        OreDictionary.registerOre("logWood",ModBlocks.logIronwood);
        OreDictionary.registerOre("plankWood", ModBlocks.enchantedWood);
        OreDictionary.registerOre("pestleAndMortar", ModItems.mortar);
        OreDictionary.registerOre("cropRice", ModItems.rice);
        OreDictionary.registerOre("seedRice", ModItems.riceSeeds);
        addDrops();
    }


    public static void addDrops()
    {
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.riceSeeds), 3);
    }
}
