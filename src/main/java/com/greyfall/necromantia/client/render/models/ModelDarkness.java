package com.greyfall.necromantia.client.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by Katrina on 18/06/2015.
 */
public class ModelDarkness extends ModelBase {


    ModelRenderer Shape1;
    public ModelDarkness()
    {
     Shape1=new ModelRenderer(this,0,4);
        Shape1.addBox(-8,-8,-8,16,16,16,1);
        Shape1.setTextureSize(64, 64);
        Shape1.mirror = true;
    }


    @Override
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        Shape1.render(p_78088_7_);
    }
}
