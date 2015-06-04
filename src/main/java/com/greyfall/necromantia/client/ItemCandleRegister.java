package com.greyfall.necromantia.client;

import com.greyfall.necromantia.CandleModel;
import com.greyfall.necromantia.TileEntityCandle;
import com.greyfall.necromantia.TileEntityCandleEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

/**
 * Created by Katrina on 04/06/2015.
 */
public class ItemCandleRegister implements IItemRenderer {

    private CandleModel model;

    public ItemCandleRegister()
    {
        model=new CandleModel();
    }
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
        TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityCandleEntity(),0.0d,0.0d,0.0d,2);
    }
}
