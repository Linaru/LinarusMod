package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.common.blocks.wood.*;
import com.greyfall.necromantia.common.core.helpers.BlockReplaceHelper;
import com.greyfall.necromantia.common.items.itemBlocks.ItemBlockLatex;
import com.greyfall.necromantia.common.items.itemBlocks.ItemBlockSaplings;
import com.greyfall.necromantia.common.libs.BlockNames;
import com.greyfall.necromantia.common.tiles.TileEntityCandle;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by Katrina on 13/06/2015.
 */
public class ModBlocks {

    public static Block cauldron;
    //Containers
    public static Block worktop;
    //standard blocks
    //public static Block slimeLatex;
    public static Block latex;
    public static Block wax;
    public static Block crate;
    public static Block enchantedWood;
    public static Block candle;
    public static Block irontreeBrick;
    //public static Block irontreebrickhalfslab;
   // public static Block irontreebrickdoubleslab;
    public static Block logIronwood;
    public static Block logIronwoodOre;
    public static Block leavesIronwood;
    public static Block wildRice;
    public static Block rune;
    public static Block hardstone;
    //public static Block etherealportal;
    //Admin blocks
    public static Block adminstone;

    public static Block sapling;
    public static Block riceBush;
    public static Block etherealPortal;



    public static void registerBlocks()
    {
        cauldron = new BlockCauldron();
        worktop = new BlockWorktop();
        //slimeLatex = new BlockSlimeLatex();
        latex = new BlockLatex();
        wax = new BlockWax();
        crate = new BlockCrate();
        enchantedWood = new BlockEnchantedWood();
        candle = new BlockCandle();
        irontreeBrick = new BlockIrontreeBrick();
        //irontreebrickhalfslab = new BlockIrontreebrickhalfslab(Material.ground).setBlockName("BlockIrontreebrickhalfslab").setBlockTextureName("necromantia:irontreebrickslab").setCreativeTab(tabnecromantia);
        //irontreebrickdoubleslab = new BlockIrontreebrickdoubleslab(Material.ground).setBlockName("BlockIrontreebrickdoubleslab").setBlockTextureName("necromantia:irontreebrickslab").setCreativeTab(tabnecromantia);
        logIronwood = new BlockLogIronwood();
        logIronwoodOre = new BlockLogIronwoodOre();
        leavesIronwood = new BlockLeavesIronwood();
        wildRice = new BlockWildRice();
        rune = new BlockRune();
        hardstone = new BlockHardstone();
        //etherealportal = new BlockEtherealportal().setBlockName("BlockblockEtherealportal").setBlockTextureName("necromantia:etherealportal").setCreativeTab(tabnecromantia);
        etherealPortal=new BlockEtherealPortal();

        //Admin blocks
        adminstone = new BlockDungeonruinsbrick();
        sapling=new BlockIronwoodSapling();
        riceBush=new BlockRiceBush();
        registerBlockData();
    }


    public static void registerBlockData()
    {
        GameRegistry.registerBlock(cauldron, BlockNames.CAULDRON);
        //BlockReplaceHelper.replaceBlock(ModBlocks.cauldron,cauldron);
        // Containers
        GameRegistry.registerBlock(worktop, BlockNames.WORKTOP);
        // standard blocks
        //GameRegistry.registerBlock(slimeLatex,BlockNames.SLIME_LATEX);
        GameRegistry.registerBlock(latex, ItemBlockLatex.class, BlockNames.LATEX);
        GameRegistry.registerBlock(wax, BlockNames.WAX);
        GameRegistry.registerBlock(crate, BlockNames.CRATE);
        GameRegistry.registerBlock(enchantedWood, BlockNames.ENCHANTED_WOOD);
        GameRegistry.registerBlock(irontreeBrick, BlockNames.IRONTREE_BRICK);
        //GameRegistry.registerBlock(blockIrontreebrickhalfslab, blockIrontreebrickhalfslab.getUnlocalizedName().substring(5));
        //GameRegistry.registerBlock(blockIrontreebrickdoubleslab, blockIrontreebrickdoubleslab.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(logIronwood, BlockNames.IRONWOOD_LOG);
        GameRegistry.registerBlock(logIronwoodOre, BlockNames.IRONWOOD_LOG_ORE);
        GameRegistry.registerBlock(leavesIronwood, BlockNames.IRONWOOD_LEAVES);
        GameRegistry.registerBlock(wildRice, BlockNames.WILD_RICE);
        GameRegistry.registerBlock(rune, BlockNames.RUNE);
        GameRegistry.registerBlock(hardstone, BlockNames.HARDSTONE);
        //GameRegistry.registerBlock(blockEtherealportal, blockEtherealportal.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(candle, BlockNames.CANDLE);
        //Admin blocks
        GameRegistry.registerBlock(adminstone, BlockNames.DUNGEONRUINSBRICK);
        GameRegistry.registerBlock(sapling, ItemBlockSaplings.class,BlockNames.SAPLINGS);
        GameRegistry.registerBlock(riceBush,BlockNames.RICE_BUSH);
        GameRegistry.registerBlock(etherealPortal,BlockNames.ETHEREAL_PORTAL);

        registerTileEntities();
    }


    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityCauldron.class,BlockNames.CAULDRON);
        GameRegistry.registerTileEntity(TileEntityCandle.class,BlockNames.CANDLE);
    }
}
