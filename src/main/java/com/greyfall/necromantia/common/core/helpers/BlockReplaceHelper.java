package com.greyfall.necromantia.common.core.helpers;


import com.google.common.collect.BiMap;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.blocks.BlockCauldron;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.RegistryNamespaced;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class BlockReplaceHelper{
    public static boolean replaceBlock(Block toReplace, Class<? extends Block> blockClass){
        try {
            GameRegistry.addSubstitutionAlias("cauldron", GameRegistry.Type.BLOCK,blockClass.newInstance());
        } catch (ExistingSubstitutionException e) {

            e.printStackTrace();
            return false;
        } catch (InstantiationException e) {

            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
}