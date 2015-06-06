package com.greyfall.necromantia.client.render.gui;

import com.greyfall.necromantia.common.containers.ContainerCauldron;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Katrina on 05/06/2015.
 */
public class GuiCauldron extends GuiContainer {


    public GuiCauldron(TileEntityCauldron cauldron,EntityPlayer player) {
        super(new ContainerCauldron(cauldron,player));

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("necromantia:textures/gui/cauldron.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
