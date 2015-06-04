package com.greyfall.necromantia;

import com.greyfall.necromantia.mob.EntityMain;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

@Mod(modid="necromantia", name = "Copper Mod", version="Carrot.1.0")
public class Main
{
	
@Instance("necromantia")
public static Main modInstance;
	
	
public static String MODID = "modid";
public static String VERSION = "version";

@SidedProxy(clientSide = "com.greyfall.necromantia.ClientProxy", serverSide = "com.greyfall.necromantia.CommonProxy")
public static CommonProxy proxy;

//items
public static Item itemSlimelatex;
public static Item itemLatex;
public static Item itemSiliconerubber;
public static Item itemGoldcoin;
public static Item itemWax;
public static Item itemSilicondioxide;
//tools
public static Item itemMortar;
//blocks
public static Block blockSlimelatex;
public static Block blockLatex;
public static Block blockWax;
public static Block blockCandle;
public static Block blockIrontreebrick;
//Armour
public static Item pinklatexHelmet;
public static Item pinklatexChestplate;
public static Item pinklatexLeggings;
public static Item pinklatexBoots;
public static Item siliconeHelmet;
public static Item siliconeChestplate;
public static Item siliconeLeggings;
public static Item siliconeBoots;

//Armour materials (set stats)
public static final ItemArmor.ArmorMaterial pinklatexArmourMaterial = EnumHelper.addArmorMaterial("pinklatexArmourMaterial", 50, new int[]{2,4,3,1,}, 30);
public static final ItemArmor.ArmorMaterial siliconeArmourMaterial = EnumHelper.addArmorMaterial("siliconeMaterial", 1000, new int[]{1,3,2,1,}, 30);


//==================================================================Seperator==================================================================//

@EventHandler
public void preInit(FMLPreInitializationEvent event)
{
	
	EntityMain.mainRegistry(); //? not sure what is wrong here Entity tutorial did not explain this step.
	
	//Item and Block initialisation
	//items
	itemSlimelatex = new Slimelatex().setUnlocalizedName("ItemSlimelatex").setTextureName("necromantia:slimelatex").setCreativeTab(tabnecromantia); //item.itemTable
	itemLatex = new Latex().setUnlocalizedName("ItemLatex").setTextureName("necromantia:latex").setCreativeTab(tabnecromantia); //item.itemTable
	itemSiliconerubber = new Siliconerubber().setUnlocalizedName("ItemSiliconerubber").setTextureName("necromantia:siliconerubber").setCreativeTab(tabnecromantia); //item.itemTable
	itemGoldcoin = new Goldcoin().setUnlocalizedName("ItemGoldcoin").setTextureName("necromantia:goldcoin").setCreativeTab(tabnecromantia); //item.itemTable
	itemWax = new Wax().setUnlocalizedName("ItemWax").setTextureName("necromantia:wax").setCreativeTab(tabnecromantia); //item.itemTable
	itemSilicondioxide = new Silicondioxide().setUnlocalizedName("ItemSilicondioxide").setTextureName("necromantia:silica").setCreativeTab(tabnecromantia); //item.itemTable
	//tools
	itemMortar = new Mortar().setUnlocalizedName("ItemMortar").setTextureName("necromantia:mortar").setCreativeTab(tabnecromantia); //item.itemTable
	//blocks
	blockSlimelatex = new BlockSlimelatex(Material.sponge).setBlockName("BlockSlimelatex").setBlockTextureName("necromantia:pinklatexblock").setCreativeTab(tabnecromantia);
	blockLatex = new BlockLatex(Material.sponge).setBlockName("BlockLatex").setBlockTextureName("necromantia:latexblock").setCreativeTab(tabnecromantia);
	blockWax = new BlockWax(Material.ground).setBlockName("BlockWax").setCreativeTab(tabnecromantia);
	blockCandle = new BlockCandle(Material.ground).setBlockName("BlockCandle").setBlockTextureName("necromantia:candle").setCreativeTab(tabnecromantia);
	blockIrontreebrick = new BlockIrontreebrick(Material.ground).setBlockName("BlockIrontreebrick").setBlockTextureName("necromantia:irontreebrick").setCreativeTab(tabnecromantia);
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
	GameRegistry.registerItem(itemSilicondioxide, itemSilicondioxide.getUnlocalizedName().substring(5));
	//tools
	GameRegistry.registerItem(itemMortar, itemMortar.getUnlocalizedName().substring(5));
	//blocks
	GameRegistry.registerBlock(blockSlimelatex, blockSlimelatex.getUnlocalizedName().substring(5));
	GameRegistry.registerBlock(blockLatex, blockLatex.getUnlocalizedName().substring(5));
	GameRegistry.registerBlock(blockWax, blockWax.getUnlocalizedName().substring(5));
	GameRegistry.registerBlock(blockIrontreebrick, blockIrontreebrick.getUnlocalizedName().substring(5));
	GameRegistry.registerBlock(blockCandle, blockCandle.getUnlocalizedName().substring(5));
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
public void init(FMLInitializationEvent event)
{
	//Proxy, TileEntity, entity, Gui and Packet Registering
	proxy.init();
	
	
	//Crafting Recipes
		//Pink Latex Block
	GameRegistry.addRecipe(new ItemStack(blockSlimelatex), new Object[]{"LL ", "LL ", "   ", 'L', Main.itemSlimelatex});
	GameRegistry.addRecipe(new ItemStack(blockSlimelatex), new Object[]{" LL", " LL", "   ", 'L', Main.itemSlimelatex});
	GameRegistry.addRecipe(new ItemStack(blockSlimelatex), new Object[]{"   ", "LL ", "LL ", 'L', Main.itemSlimelatex});
	GameRegistry.addRecipe(new ItemStack(blockSlimelatex), new Object[]{"   ", " LL", " LL", 'L', Main.itemSlimelatex});
		//Latex Block
	GameRegistry.addRecipe(new ItemStack(blockLatex), new Object[]{"LL ", "LL ", "   ", 'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(blockLatex), new Object[]{" LL", " LL", "   ", 'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(blockLatex), new Object[]{"   ", "LL ", "LL ", 'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(blockLatex), new Object[]{"   ", " LL", " LL", 'L', Main.itemLatex});
		//Wax Block
	GameRegistry.addRecipe(new ItemStack(blockWax), new Object[]{"LL ", "LL ", "   ", 'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(blockWax), new Object[]{" LL", " LL", "   ", 'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(blockWax), new Object[]{"   ", "LL ", "LL ", 'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(blockWax), new Object[]{"   ", " LL", " LL", 'L', Main.itemLatex});
		//Gold Coin
	GameRegistry.addRecipe(new ItemStack(itemGoldcoin), new Object[]{"GGG", "G G", "GGG", 'G', Items.gold_nugget});
		//Mortar and pestle
	if(!Loader.isModLoaded("Botania"))
	{
	GameRegistry.addRecipe(new ItemStack(itemMortar), new Object[]{" S ", "W  ", "B  ", 'S', Items.stick, 'W', Blocks.planks, 'B', Items.bowl});
	GameRegistry.addRecipe(new ItemStack(itemMortar), new Object[]{"  S", " W ", " B ", 'S', Items.stick, 'W', Blocks.planks, 'B', Items.bowl});
	}
			//Silica
	if(Loader.isModLoaded("Botania"))
	{
	BotaniaInterop.registerBotaniaRecepies();
	}
	else
	{
	GameRegistry.addShapelessRecipe(new ItemStack(Main.itemSilicondioxide, 5), new ItemStack(Items.quartz), new ItemStack(Main.itemMortar));
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
	GameRegistry.addRecipe(new ItemStack(siliconeHelmet), new Object[]{"LLL", "L L",  'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(siliconeChestplate), new Object[]{"S S", "LSL", "SSS", 'S', Main.itemSiliconerubber, 'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(siliconeLeggings), new Object[]{"LSL", "S S", "L L", 'S', Main.itemSiliconerubber, 'L', Main.itemLatex});
	GameRegistry.addRecipe(new ItemStack(siliconeBoots), new Object[]{"L L", "L L", 'L', Main.itemLatex});
	//Smelting Recipes
	GameRegistry.addSmelting(Main.itemSlimelatex, new ItemStack(Main.itemLatex), 0.1f);
	GameRegistry.addSmelting(Main.blockSlimelatex, new ItemStack(Main.blockLatex), 0.1f);
}

@EventHandler
public void postInit(FMLPostInitializationEvent event)
{
}

//Creative tabs
public static CreativeTabs tabnecromantia = new CreativeTabs("tabnecromantia"){
	@Override
	public Item getTabIconItem(){
		return new ItemStack(blockSlimelatex).getItem();
	}
};

public static CreativeTabs tabnecromantiaarmor = new CreativeTabs("tabnecromantia"){
	@Override
	public Item getTabIconItem(){
		return new ItemStack(siliconeChestplate).getItem();
	}
};


}