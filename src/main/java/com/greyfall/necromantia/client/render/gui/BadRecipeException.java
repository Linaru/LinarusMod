package com.greyfall.necromantia.client.render.gui;

import com.greyfall.necromantia.api.crafting.CauldronRecipe;
import cpw.mods.fml.client.CustomModLoadingErrorDisplayException;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiErrorScreen;
import org.lwjgl.opengl.GL11;

/**
 * Created by Katrina on 21/06/2015.
 */
public class BadRecipeException extends CustomModLoadingErrorDisplayException {


    CauldronRecipe recipe;
    public BadRecipeException(String message, Throwable cause,CauldronRecipe recipe) {
        super(message, cause);
        this.recipe=recipe;
    }

    @Override
    public void initGui(GuiErrorScreen errorScreen, FontRenderer fontRenderer) {

    }

    @Override
    public void drawScreen(GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY, float tickTime) {

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        int offset = 85;
        errorScreen.drawCenteredString(fontRenderer, "Forge Mod Loader has found a problem with your minecraft installation", errorScreen.width / 2, offset, 0xFFFFFF);
        offset+=10;
        errorScreen.drawCenteredString(fontRenderer, this.getMessage(), errorScreen.width / 2, offset, 0xFFFFFF);
        offset+=10;
        String FluidName=recipe.getOreDictFluid();
        String ItemName=recipe.getOreDictItem();
        if(FluidName==null)
            FluidName=recipe.getInputFluid().getLocalizedName();

        if(ItemName==null)
            ItemName=recipe.getInputItem().getDisplayName();
        errorScreen.drawCenteredString(fontRenderer, "Fluid: "+FluidName+" - Item: "+ItemName, errorScreen.width / 2, offset, 0xFFFFFF);

    }
}
