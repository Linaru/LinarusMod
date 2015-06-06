package com.greyfall.necromantia.client.render.items;

import com.greyfall.necromantia.common.tiles.TileEntityCandleEntity;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Katrina on 05/06/2015.
 */
public class ItemCauldronRegister implements IItemRenderer {
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        //GL11.glPushMatrix();
        //GL11.glScalef(2, 2, 2);
        TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityCauldron(), 0.0d, 0.0d, 0.0d, 0);
        //GL11.glPopMatrix();
    }
}
