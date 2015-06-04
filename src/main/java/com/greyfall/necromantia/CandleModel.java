package com.greyfall.necromantia;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
@SideOnly(Side.CLIENT)
public class CandleModel extends ModelBase
{
    //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;

    public CandleModel(boolean onFence)
    {
        textureWidth = 16;
        textureHeight = 16;

        Shape1 = new ModelRenderer(this, 0, 4);
        Shape1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
        Shape1.setRotationPoint(0F, 16F, 0F);
        Shape1.setTextureSize(16, 16);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 8, 0);
        Shape2.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
        Shape2.setRotationPoint(0F, 14F, 0F);
        Shape2.setTextureSize(16, 16);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        if(!onFence) {
            Shape3 = new ModelRenderer(this, 12, 0);
            Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
            Shape3.setRotationPoint(-2.5F, 23F, 0F);
            Shape3.setTextureSize(16, 16);
            Shape3.mirror = true;
            setRotation(Shape3, 0F, 0F, 0F);
            Shape4 = new ModelRenderer(this, 0, 0);
            Shape4.addBox(0F, 0F, 0F, 2, 2, 2);
            Shape4.setRotationPoint(-1.5F, 22F, 1.5F);
            Shape4.setTextureSize(16, 16);
            Shape4.mirror = true;
            setRotation(Shape4, 0F, 0F, 0F);
        }
    }

    public void render(Entity entity, float f0, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f0, f1, f2, f3, f4, f5);
        setRotationAngles(f0, f1, f2, f3, f4, f5);
        Shape1.render(f5);
        Shape2.render(f5);
        if(Shape3!=null) {
            Shape3.render(f5);
            Shape4.render(f5);
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f0, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f0, f1, f2, f3, f4, f5, null);
    }

}
