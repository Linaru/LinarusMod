package com.greyfall.necromantia.common;

import codechicken.lib.util.LangProxy;
import com.greyfall.necromantia.common.blocks.ModBlocks;
import com.greyfall.necromantia.common.books.BookEncyclopediaminecraftia1;
import com.greyfall.necromantia.common.core.CommonProxy;
import com.greyfall.necromantia.common.core.config.NecromantiaConfig;
import com.greyfall.necromantia.common.dimensions.DimensionRegistry;
import com.greyfall.necromantia.common.interop.MineFactoryReloaded;
import com.greyfall.necromantia.common.items.*;
import com.greyfall.necromantia.common.libs.LibMisc;
import com.greyfall.necromantia.common.mobs.EntityMain;
import com.greyfall.necromantia.common.recipes.CauldronRecipes;
import com.greyfall.necromantia.common.recipes.NormalRecipes;
import com.greyfall.necromantia.common.world.ModBiomes;
import com.greyfall.necromantia.common.worldgen.BiomeEvents;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
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
the plan is to divide up mobs tools and technology into 5 teirs so as to get a better understanding of balance.
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
    public static int candleRenderID;
    public static int cauldronRenderID;
    //Armour materials (set stats)
    public static final ItemArmor.ArmorMaterial pinklatexArmourMaterial = EnumHelper.addArmorMaterial("pinklatexArmourMaterial", 50, new int[]{2, 4, 3, 1,}, 30);
    public static final ItemArmor.ArmorMaterial siliconeArmourMaterial = EnumHelper.addArmorMaterial("siliconeMaterial", 1000, new int[]{1, 3, 2, 1,}, 30);
    public static Logger logger;



//==================================================================Seperator==================================================================//

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        NecromantiaConfig.parseConfig(event.getSuggestedConfigurationFile());
        logger=event.getModLog();
        ModBiomes.registerBiomes();
        DimensionRegistry.mainRegistry();
        EntityMain.mainRegistry(); //? not sure what is wrong here Entity tutorial did not explain this step.
        ModBlocks.registerBlocks();
        ModItems.registerItems();

        if(Loader.isModLoaded("Waila"))
        {
            FMLInterModComms.sendMessage("Waila", "register", "com.greyfall.necromantia.common.interop.waila.Waila.callbackRegister");
        }
        if(Loader.isModLoaded("MineFactoryReloaded"))
        {
            MineFactoryReloaded.registerCrops();
        }
        MinecraftForge.EVENT_BUS.register(new BiomeEvents());


        // Biome Testing code - DO NOT TOUCH
        //WorldChunkManager.allowedBiomes.clear();
        //WorldChunkManager.allowedBiomes.add(ModBiomes.biomeIronwoodForest);

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
            return new ItemStack(ModBlocks.latex,1,1).getItem();
        }
    };

    public static CreativeTabs tabnecromantiaarmor = new CreativeTabs("tabnecromantia.armor") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(ModItems.siliconeChestplate).getItem();
        }
    };

    public static CreativeTabs tabnecromantiaadmin = new CreativeTabs("tabnecromantia.admin") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(ModBlocks.irontreeBrick).getItem();
        }
    };

}