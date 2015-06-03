package com.greyfall.necromantia.mob;
 
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
 
@SideOnly(Side.CLIENT)
public class EntityRenderPinkslimeMob extends RenderLiving {
       
    private static final ResourceLocation slimeTextures = new ResourceLocation("necromantia:textures/entity/pinkslime.png");
    private static final String __OBFID = "CL_00001024";
    private ModelBase scaleAmount;
 
    public EntityRenderPinkslimeMob()
    {
        super(new ModelPinkslimeMob(64), 0.75f);
        scaleAmount=new ModelPinkslimeMob(0);
    }
 
    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityPinkslimeMob p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_1_.isInvisible())
        {
            return 0;
        }
        else if (p_77032_2_ == 0)
        {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
        }
        else
        {
            if (p_77032_2_ == 1)
            {
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
 
            return -1;
        }
    }
 
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityPinkslimeMob p_77041_1_, float p_77041_2_)
    {
        float f1 = (float)p_77041_1_.getSlimeSize();
        float f2 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor) * p_77041_2_) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }
 
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityPinkslimeMob p_110775_1_)
    {
        return slimeTextures;
    }
 
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityPinkslimeMob)p_77041_1_, p_77041_2_);
    }
 
    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityPinkslimeMob)p_77032_1_, p_77032_2_, p_77032_3_);
    }
 
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityPinkslimeMob)p_110775_1_);
    }
}