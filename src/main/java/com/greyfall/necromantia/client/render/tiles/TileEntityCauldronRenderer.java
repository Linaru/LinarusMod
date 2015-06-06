package com.greyfall.necromantia.client.render.tiles;

import codechicken.core.fluid.FluidUtils;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.RenderUtils;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Vector3;
import com.greyfall.necromantia.client.render.models.ModelCauldron;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katrina on 05/06/2015.
 */
public class TileEntityCauldronRenderer extends TileEntitySpecialRenderer {
    public static ResourceLocation textureLocation=new ResourceLocation("necromantia:textures/blocks/cauldron.png");
    static final float LIGHT_Y_NEG = 0.5F;
    static final float LIGHT_Y_POS = 1.0F;
    static final float LIGHT_XZ_NEG = 0.8F;
    static final float LIGHT_XZ_POS = 0.6F;
    static final double RENDER_OFFSET = 0.0010000000474974513D;
    ModelCauldron model=new ModelCauldron();
    @Override
    public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float ticks) {
        TileEntityCauldron cauldron=(TileEntityCauldron)entity;
        //The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();

        //This is setting the initial location.
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        //This is the texture of your block. It's pathed to be the same place as your other blocks here.
        ResourceLocation textures = (textureLocation);
        //the ':' is very important
        //binding the textures
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);

        //This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //A reference to your Model file. Again, very important.
        model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);


        //Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        if(cauldron.tank.getFluid().amount>0)
        {
            CCRenderState.reset();
            CCRenderState.pullLightmap();
            CCRenderState.useNormals = true;
            if (cauldron.hasWorldObj()) {
                RenderUtils.renderFluidCuboid(cauldron.tank.getFluid(), new Cuboid6(0.125D, 0.12D, 0.125, 0.875D,0.875,0.875D).add(new Vector3(x,y,z)),cauldron.tank.getFluid().amount/(1D* FluidUtils.B),0.75);
            }

        }
    }

    private IIcon getIcon(IIcon icon)
    {
        if (icon != null) return icon;
        return ((TextureMap)Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
    }


}
