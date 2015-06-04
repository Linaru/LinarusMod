package com.greyfall.necromantia;


import codechicken.lib.render.CCRenderState;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Translation;
import com.greyfall.necromantia.client.BlockRenderer;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * Created by Katrina on 04/06/2015.
 */
@SideOnly(Side.CLIENT)
public class BlockCandleRenderer extends BlockRenderer implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        IIcon c=block.getIcon(metadata,metadata);
        block.setBlockBounds(0,0f,0,0.28125f,1f,0.28125F);
        renderer.setRenderBoundsFromBlock(block);
        drawFaces(renderer,block,((BlockCandle)block).getIcon(0,0),true);
        block.setBlockBounds(0,0f,0,0.0625f,0.125f,0.0625F);
        renderer.setRenderBoundsFromBlock(block);
        drawFaces(renderer,block,((BlockCandle)block).getIcon(0,0),true);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return modelId==Main.candleRenderID;
    }

    @Override
    public int getRenderId() {
        return Main.candleRenderID;
    }
}
