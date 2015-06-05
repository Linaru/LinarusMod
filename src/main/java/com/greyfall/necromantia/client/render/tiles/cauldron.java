package com.greyfall.necromantia.client.render.tiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCauldron extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Leftside;
    ModelRenderer Rightside;
    ModelRenderer Back;
    ModelRenderer Front;
    ModelRenderer Valveback;
    ModelRenderer footfrontright;
    ModelRenderer footbackright;
    ModelRenderer footfrontleft;
    ModelRenderer footbackleft;
    ModelRenderer ValveRight;
    ModelRenderer ValveLeft;
  
  public ModelCauldron()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(-7F, 0F, -9F, 14, 1, 14);
      Base.setRotationPoint(0F, 21F, 2F);
      Base.setTextureSize(128, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Leftside = new ModelRenderer(this, 0, 15);
      Leftside.addBox(0F, 0F, -6F, 1, 13, 12);
      Leftside.setRotationPoint(6F, 8F, 0F);
      Leftside.setTextureSize(128, 64);
      Leftside.mirror = true;
      setRotation(Leftside, 0F, 0F, 0F);
      Rightside = new ModelRenderer(this, 0, 15);
      Rightside.addBox(0F, 0F, -6F, 1, 13, 12);
      Rightside.setRotationPoint(-6F, 8F, 0F);
      Rightside.setTextureSize(128, 64);
      Rightside.mirror = true;
      setRotation(Rightside, 0F, 3.141593F, 0F);
      Back = new ModelRenderer(this, 0, 41);
      Back.addBox(-7F, 0F, 0F, 14, 13, 1);
      Back.setRotationPoint(0F, 8F, 7F);
      Back.setTextureSize(128, 64);
      Back.mirror = true;
      setRotation(Back, 0F, 3.141593F, 0F);
      Front = new ModelRenderer(this, 0, 41);
      Front.addBox(-7F, 0F, 0F, 14, 13, 1);
      Front.setRotationPoint(0F, 8F, -7F);
      Front.setTextureSize(128, 64);
      Front.mirror = true;
      setRotation(Front, 0F, 0F, 0F);
      Valveback = new ModelRenderer(this, 0, 0);
      Valveback.addBox(0F, 0F, 0F, 6, 6, 1);
      Valveback.setRotationPoint(-3F, 13F, 7F);
      Valveback.setTextureSize(128, 64);
      Valveback.mirror = true;
      setRotation(Valveback, 0F, 0F, 0F);
      footfrontright = new ModelRenderer(this, 0, 7);
      footfrontright.addBox(0F, 0F, 0F, 2, 2, 2);
      footfrontright.setRotationPoint(-6F, 22F, -6F);
      footfrontright.setTextureSize(128, 64);
      footfrontright.mirror = true;
      setRotation(footfrontright, 0F, 0F, 0F);
      footbackright = new ModelRenderer(this, 0, 7);
      footbackright.addBox(0F, 0F, 0F, 2, 2, 2);
      footbackright.setRotationPoint(-6F, 22F, 4F);
      footbackright.setTextureSize(128, 64);
      footbackright.mirror = true;
      setRotation(footbackright, 0F, 0F, 0F);
      footfrontleft = new ModelRenderer(this, 0, 7);
      footfrontleft.addBox(-2F, 0F, 0F, 2, 2, 2);
      footfrontleft.setRotationPoint(6F, 22F, 4F);
      footfrontleft.setTextureSize(128, 64);
      footfrontleft.mirror = true;
      setRotation(footfrontleft, 0F, 0F, 0F);
      footbackleft = new ModelRenderer(this, 0, 7);
      footbackleft.addBox(0F, 0F, 0F, 2, 2, 2);
      footbackleft.setRotationPoint(4F, 22F, -6F);
      footbackleft.setTextureSize(128, 64);
      footbackleft.mirror = true;
      setRotation(footbackleft, 0F, 0F, 0F);
      ValveRight = new ModelRenderer(this, 14, 15);
      ValveRight.addBox(0F, 0F, 0F, 1, 6, 6);
      ValveRight.setRotationPoint(7F, 13F, -3F);
      ValveRight.setTextureSize(128, 64);
      ValveRight.mirror = true;
      setRotation(ValveRight, 0F, 0F, 0F);
      ValveLeft = new ModelRenderer(this, 14, 15);
      ValveLeft.addBox(-1F, 0F, 0F, 1, 6, 6);
      ValveLeft.setRotationPoint(-7F, 13F, -3F);
      ValveLeft.setTextureSize(128, 64);
      ValveLeft.mirror = true;
      setRotation(ValveLeft, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Leftside.render(f5);
    Rightside.render(f5);
    Back.render(f5);
    Front.render(f5);
    Valveback.render(f5);
    footfrontright.render(f5);
    footbackright.render(f5);
    footfrontleft.render(f5);
    footbackleft.render(f5);
    ValveRight.render(f5);
    ValveLeft.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
