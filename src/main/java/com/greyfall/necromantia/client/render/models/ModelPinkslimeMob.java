package com.greyfall.necromantia.client.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPinkslimeMob extends ModelBase
{
  //fields
    ModelRenderer Slime;
    ModelRenderer Right_Ear;
    ModelRenderer Left_Ear;
    ModelRenderer Slime_transparent;
  
  public ModelPinkslimeMob(int offset)
  {
    textureWidth = 128;
    textureHeight = 64;

    Slime_transparent = new ModelRenderer(this, offset, 0);
    Slime_transparent.addBox(0F, 0F, 0F, 16, 12, 16);
    Slime_transparent.setRotationPoint(-8F, 12F, -7F);
    Slime_transparent.setTextureSize(128, 64);
    Slime_transparent.mirror = true;
    setRotation(Slime_transparent, 0F, 0F, 0F);
    if(offset>0) {
      Slime_transparent = new ModelRenderer(this, offset, 0);
      Slime_transparent.addBox(0F, -1F, 0F, 14, 10, 14);
      Slime_transparent.setRotationPoint(-7F, 14F, -6F);
      Slime_transparent.setTextureSize(128, 64);
      Slime_transparent.mirror = true;
      setRotation(Slime_transparent, 0F, 0F, 0F);
      Right_Ear = new ModelRenderer(this, 0, 28);
      Right_Ear.addBox(0F, 0F, 0F, 6, 4, 6);
      Right_Ear.setRotationPoint(4F, 10F, 0F);
      Right_Ear.setTextureSize(128, 64);
      Right_Ear.mirror = true;
      setRotation(Right_Ear, 0F, 0F, 0F);
      Left_Ear = new ModelRenderer(this, 24, 28);
      Left_Ear.addBox(-10F, 0F, 0F, 6, 4, 6);
      Left_Ear.setRotationPoint(0F, 10F, 0F);
      Left_Ear.setTextureSize(128, 64);
      Left_Ear.mirror = true;
      setRotation(Left_Ear, 0F, 0F, 0F);
    }


  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Slime_transparent.render(f5);
    if(Right_Ear!=null) {
      Right_Ear.render(f5);
      Left_Ear.render(f5);
    }
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
