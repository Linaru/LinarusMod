package com.greyfall.necromantia.client.render.gui;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.containers.ContainerCauldron;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
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
    public static ResourceLocation TEXTURE=new ResourceLocation("necromantia:textures/gui/cauldron.png");
    public GuiCauldron(TileEntityCauldron cauldron, EntityPlayer player) {
        super(new ContainerCauldron(cauldron, player));
        this.cauldron = cauldron;

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);

        GL11.glPushMatrix();

        if(cauldron.tank.getFluid()!=null && cauldron.tank.getFluid().amount>0)
        {
            float heightPercent = (float) cauldron.tank.getFluidAmount() / (float)cauldron.tank.getCapacity();
            Main.logger.info(heightPercent);
            IIcon icon = cauldron.tank.getFluid().getFluid().getStillIcon();
            if (icon == null) {
                icon = ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
            }
            mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
            setGLColorFromInt(cauldron.tank.getFluid().getFluid().getColor(cauldron.tank.getFluid()));
            int levels=(int)((34 * heightPercent)/16);
            for(int i=1;i<=levels;i++)
            {
                drawTexturedModelRectFromIcon(46, 60 -(i*16), icon, 12,16 );
            }

            int remainder=(int)(34*heightPercent)-(levels*16);


            drawCutTexturedModelRectFromIcon(46, 60 -(levels*16)-remainder, icon, 12,remainder );


        }
        mc.renderEngine.bindTexture(TEXTURE);
        drawTexturedModalRect(46, 26, 176, 29, 12, 34);
        GL11.glPopMatrix();
    }

    public void drawCutTexturedModelRectFromIcon(int p_94065_1_, int p_94065_2_, IIcon p_94065_3_, int p_94065_4_, int p_94065_5_)
    {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(p_94065_1_ + 0), (double)(p_94065_2_ + p_94065_5_), (double)this.zLevel, (double)p_94065_3_.getMinU(), (double)p_94065_3_.getInterpolatedV(p_94065_5_));
        tessellator.addVertexWithUV((double)(p_94065_1_ + p_94065_4_), (double)(p_94065_2_ + p_94065_5_), (double)this.zLevel, (double)p_94065_3_.getMaxU(), (double)p_94065_3_.getInterpolatedV(p_94065_5_));
        tessellator.addVertexWithUV((double)(p_94065_1_ + p_94065_4_), (double)(p_94065_2_ + 0), (double)this.zLevel, (double)p_94065_3_.getMaxU(), (double)p_94065_3_.getMinV());
        tessellator.addVertexWithUV((double)(p_94065_1_ + 0), (double)(p_94065_2_ + 0), (double)this.zLevel, (double)p_94065_3_.getMinU(), (double)p_94065_3_.getMinV());
        tessellator.draw();
    }
    public static void setGLColorFromInt(int color) {
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
        GL11.glColor4f(red, green, blue, 1.0F);
    }

}
