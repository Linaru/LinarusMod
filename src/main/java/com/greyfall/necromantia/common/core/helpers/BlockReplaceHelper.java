package com.greyfall.necromantia.common.core.helpers;


import com.google.common.collect.BiMap;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.blocks.BlockCauldron;
import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;
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

        return true;
    }

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }
}