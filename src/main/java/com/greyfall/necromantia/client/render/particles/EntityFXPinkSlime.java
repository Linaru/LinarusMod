package com.greyfall.necromantia.client.render.particles;

import com.greyfall.necromantia.common.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * Created by Katrina on 12/06/2015.
 */
public class EntityFXPinkSlime extends EntityFX {


    public EntityFXPinkSlime(World p_i1219_1_, double p_i1219_2_, double p_i1219_4_, double p_i1219_6_, double p_i1219_8_, double p_i1219_10_, double p_i1219_12_) {
        super(p_i1219_1_, p_i1219_2_, p_i1219_4_, p_i1219_6_, p_i1219_8_, p_i1219_10_, p_i1219_12_);
        this.setParticleIcon(Main.itemSlimelatex.getIconFromDamage(0));
        this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
        this.particleGravity = Blocks.snow.blockParticleGravity;
        this.particleScale /= 2.0F;
    }


    @Override
    public int getFXLayer() {
        return 2;
    }


    @Override
    public void renderParticle(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_)
    {

        float f6 = ((float)this.particleTextureIndexX + this.particleTextureJitterX / 4.0F) / 16.0F;
        float f7 = f6 + 0.015609375F;
        float f8 = ((float)this.particleTextureIndexY + this.particleTextureJitterY / 4.0F) / 16.0F;
        float f9 = f8 + 0.015609375F;
        float f10 = 0.1F * this.particleScale;

        if (this.particleIcon != null)
        {
            f6 = this.particleIcon.getInterpolatedU((double)(this.particleTextureJitterX / 4.0F * 16.0F));
            f7 = this.particleIcon.getInterpolatedU((double)((this.particleTextureJitterX + 1.0F) / 4.0F * 16.0F));
            f8 = this.particleIcon.getInterpolatedV((double)(this.particleTextureJitterY / 4.0F * 16.0F));
            f9 = this.particleIcon.getInterpolatedV((double)((this.particleTextureJitterY + 1.0F) / 4.0F * 16.0F));
        }

        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)p_70539_2_ - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)p_70539_2_ - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)p_70539_2_ - interpPosZ);
        p_70539_1_.setColorOpaque_F(this.particleRed, this.particleGreen, this.particleBlue);
        p_70539_1_.addVertexWithUV((double)(f11 - p_70539_3_ * f10 - p_70539_6_ * f10), (double)(f12 - p_70539_4_ * f10), (double)(f13 - p_70539_5_ * f10 - p_70539_7_ * f10), (double)f6, (double)f9);
        p_70539_1_.addVertexWithUV((double)(f11 - p_70539_3_ * f10 + p_70539_6_ * f10), (double)(f12 + p_70539_4_ * f10), (double)(f13 - p_70539_5_ * f10 + p_70539_7_ * f10), (double)f6, (double)f8);
        p_70539_1_.addVertexWithUV((double)(f11 + p_70539_3_ * f10 + p_70539_6_ * f10), (double)(f12 + p_70539_4_ * f10), (double)(f13 + p_70539_5_ * f10 + p_70539_7_ * f10), (double)f7, (double)f8);
        p_70539_1_.addVertexWithUV((double)(f11 + p_70539_3_ * f10 - p_70539_6_ * f10), (double)(f12 - p_70539_4_ * f10), (double)(f13 + p_70539_5_ * f10 - p_70539_7_ * f10), (double)f7, (double)f9);
    }
}

