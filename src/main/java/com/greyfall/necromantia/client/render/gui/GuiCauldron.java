package com.greyfall.necromantia.client.render.gui;

import com.greyfall.necromantia.common.containers.ContainerCauldron;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Katrina on 05/06/2015.
 */
public class GuiCauldron extends GuiContainer {


    public TileEntityCauldron cauldron;

    public GuiCauldron(TileEntityCauldron cauldron, EntityPlayer player) {
        super(new ContainerCauldron(cauldron, player));
        this.cauldron = cauldron;

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("necromantia:textures/gui/cauldron.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);


        if (cauldron.tank.getFluidAmount() > 0) {
            int heightPercent = cauldron.tank.getFluidAmount() / cauldron.tank.getCapacity();
            IIcon icon = cauldron.tank.getFluid().getFluid().getStillIcon();
            if (icon == null) {
                icon = ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
            }
            mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
            setGLColorFromInt(cauldron.tank.getFluid().getFluid().getColor(cauldron.tank.getFluid()));

            drawTexturedModelRectFromIcon(46, 26, icon, 12, (34 * heightPercent));

        }
    }

    public static void setGLColorFromInt(int color) {
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
        GL11.glColor4f(red, green, blue, 1.0F);
    }

}
