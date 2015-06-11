package com.greyfall.necromantia.common.interop.NEI;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.ItemList;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import com.greyfall.necromantia.api.crafting.CauldronCrafting;
import com.greyfall.necromantia.api.crafting.CauldronRecipe;
import com.greyfall.necromantia.client.render.gui.GuiCauldron;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Katrina on 11/06/2015.
 */
public class CauldronRecipeHandler extends TemplateRecipeHandler{

    private RecipeComparator comparator=new RecipeComparator();
    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiCauldron.class;
    }




    public class CachedCauldronRecipe extends CachedRecipe
    {

        protected int burnTime;
        protected ArrayList<FluidStack> fluid;

        protected ArrayList<PositionedStack> input;
        private PositionedStack output;
        private ArrayList<PositionedStack> otherOutputs;

        @Override
        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks/10 ,input);
        }

        @Override
        public PositionedStack getResult() {
            return output;
        }

        @Override
        public List<PositionedStack> getOtherStacks() {
            return otherOutputs;
        }


        public CachedCauldronRecipe(ItemStack ingredient,FluidStack ingredientFluid,ItemStack[] outputs,int burnTime)
        {
            this(null,ingredient,ingredientFluid,outputs,burnTime);
        }

        public CachedCauldronRecipe(ItemStack targetedResult,ItemStack ingredient,FluidStack ingredientFluid,ItemStack[] outputs,int burnTime)
        {
            this(targetedResult,Arrays.asList(new ItemStack[]{ingredient}),ingredientFluid,outputs,burnTime);

        }
        public CachedCauldronRecipe(ArrayList<ItemStack> ingredient,FluidStack ingredientFluid,ItemStack[] outputs,int burnTime)
        {
            this(null,ingredient,ingredientFluid,outputs,burnTime);
        }
        public CachedCauldronRecipe(ItemStack targetedResult,List<ItemStack> ingredient,FluidStack ingredientFluid,ItemStack[] outputs,int burnTime)
        {
            this.burnTime=burnTime;
            input=new ArrayList<PositionedStack>(2);

            input.add(new PositionedStack(ingredient,57,6));
            input.add(new PositionedStack(aFuels,57,42));
            output=new PositionedStack(outputs[0],112,15);
            otherOutputs=new ArrayList<PositionedStack>();
            if(outputs.length>1)
                otherOutputs.add(new PositionedStack(outputs[1],130,15));
            if(outputs.length>2)
                otherOutputs.add(new PositionedStack(outputs[2],112,33));
            if(outputs.length>3)
                otherOutputs.add(new PositionedStack(outputs[3],130,33));

            fluid=new ArrayList<FluidStack>();
            fluid.add(ingredientFluid);

        }
    }


    @Override
    public String getOverlayIdentifier() {
        return "necromantiaCauldron";
    }


    @Override
    public void loadTransferRects() {
        transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(88,26,12,29),"necromantiaCauldron",new Object[0]));;

    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        Map<List<ItemStack>, List<CauldronRecipe>> recipes = CauldronCrafting.recipeMap;
        List<CachedCauldronRecipe> toAdd=new ArrayList<CachedCauldronRecipe>();
        for(Map.Entry<List<ItemStack>, List<CauldronRecipe>> recipe:recipes.entrySet()) {
            boolean found = false;
            for (ItemStack stk : recipe.getKey()) {
                if (ItemStack.areItemStacksEqual(stk, result))
                    found = true;
            }
            if(found) {
                for (CauldronRecipe rep : recipe.getValue()) {
                    CachedCauldronRecipe res;
                    if(rep.getOreDictItem()!=null)
                    {
                        res = new CachedCauldronRecipe(result, OreDictionary.getOres(rep.getOreDictItem()), rep.getInputFluid(), (ItemStack[]) recipe.getKey().toArray(), rep.getBurnTime());
                    }
                    else
                        res = new CachedCauldronRecipe(result, rep.getInputItem(), rep.getInputFluid(), (ItemStack[]) recipe.getKey().toArray(), rep.getBurnTime());
                    toAdd.add(res);
                }
            }
        }
        //Collections.sort(toAdd,comparator);
        arecipes.addAll(toAdd);
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if(outputId.equals("necromantiaCauldron") && getClass()==CauldronRecipeHandler.class)
        {
            Map<List<ItemStack>, List<CauldronRecipe>> recipes = CauldronCrafting.recipeMap;
            List<CachedCauldronRecipe> toAdd=new ArrayList<CachedCauldronRecipe>();
            for(Map.Entry<List<ItemStack>, List<CauldronRecipe>> recipe:recipes.entrySet())
            {
                    for(CauldronRecipe rep:recipe.getValue())
                    {
                        CachedCauldronRecipe res;
                        if(rep.getOreDictItem()!=null)
                        {
                            res = new CachedCauldronRecipe( OreDictionary.getOres(rep.getOreDictItem()), rep.getInputFluid(), (ItemStack[]) recipe.getKey().toArray(), rep.getBurnTime());
                        }
                        else
                            res=new CachedCauldronRecipe(rep.getInputItem(),rep.getInputFluid(),(ItemStack[])recipe.getKey().toArray(),rep.getBurnTime());
                        toAdd.add(res);
                    }
            }
            //Collections.sort(toAdd,comparator);
            arecipes.addAll(toAdd);
        }
        else
        {
            super.loadCraftingRecipes(outputId,results);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        Map<List<ItemStack>, List<CauldronRecipe>> recipes = CauldronCrafting.recipeMap;
        for(Map.Entry<List<ItemStack>, List<CauldronRecipe>> recipe:recipes.entrySet())
        {
                for(CauldronRecipe rep:recipe.getValue())
                {
                    CachedCauldronRecipe res;
                    if(rep.getOreDictItem()!=null)
                    {
                        res = new CachedCauldronRecipe( OreDictionary.getOres(rep.getOreDictItem()), rep.getInputFluid(), (ItemStack[]) recipe.getKey().toArray(), rep.getBurnTime());
                    }
                    else
                        res=new CachedCauldronRecipe(rep.getInputItem(),rep.getInputFluid(),(ItemStack[])recipe.getKey().toArray(),rep.getBurnTime());
                    if(res.contains(res.input,ingredient))
                    {
                        res.setIngredientPermutation(res.input,ingredient);
                        arecipes.add(res);
                    }
                }
        }
    }


    @Override
    public void drawExtras(int recipe) {
        super.drawExtras(recipe);
        CachedCauldronRecipe recipe1=(CachedCauldronRecipe)arecipes.get(recipe);
        drawProgressBar(59,25,176,0,14,14,200,3);
        drawProgressBar(83,15,190,0,12,29,recipe1.burnTime,3);

        float heightPercent = (float) recipe1.fluid.get(0).amount / (float)1000;
        IIcon icon = recipe1.fluid.get(0).getFluid().getStillIcon();
        if (icon == null) {
            icon = ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
        }
        GuiDraw.changeTexture(TextureMap.locationBlocksTexture);
        int renderAmount = (int) Math.max(Math.min(34, recipe1.fluid.get(0).amount * 34/ 1000), 1);
        int posY = (int) (49- renderAmount);

        int color = recipe1.fluid.get(0).getFluid().getColor();
        GL11.glColor3ub((byte) (color >> 16 & 0xFF), (byte) (color >> 8 & 0xFF), (byte) (color & 0xFF));

        GL11.glEnable(GL11.GL_BLEND);
        for (int i = 0; i < 12; i += 16) {
            for (int j = 0; j < renderAmount; j += 16) {
                int drawWidth = (int) Math.min(12 - i, 16);
                int drawHeight = Math.min(renderAmount - j, 16);

                int drawX = (int) (41 + i);
                int drawY = posY + j;

                double minU = icon.getMinU();
                double maxU = icon.getMaxU();
                double minV = icon.getMinV();
                double maxV = icon.getMaxV();

                Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.addVertexWithUV(drawX, drawY + drawHeight, 0, minU, minV + (maxV - minV) * drawHeight / 16F);
                tessellator.addVertexWithUV(drawX + drawWidth, drawY + drawHeight, 0, minU + (maxU - minU) * drawWidth / 16F, minV + (maxV - minV) * drawHeight / 16F);
                tessellator.addVertexWithUV(drawX + drawWidth, drawY, 0, minU + (maxU - minU) * drawWidth / 16F, minV);
                tessellator.addVertexWithUV(drawX, drawY, 0, minU, minV);
                tessellator.draw();
            }
        }
        GL11.glDisable(GL11.GL_BLEND);

        GuiDraw.changeTexture(getGuiTexture());
        GuiDraw.drawTexturedModalRect(41, 15, 176, 29, 12, 34);


    }



    public static ArrayList<ItemStack> aFuels;
    private static Set<Item> excludedFuels() {
        Set<Item> efuels = new HashSet<Item>();
        efuels.add(Item.getItemFromBlock(Blocks.brown_mushroom));
        efuels.add(Item.getItemFromBlock(Blocks.red_mushroom));
        efuels.add(Item.getItemFromBlock(Blocks.standing_sign));
        efuels.add(Item.getItemFromBlock(Blocks.wall_sign));
        efuels.add(Item.getItemFromBlock(Blocks.trapped_chest));
        return efuels;
    }

    @Override
    public TemplateRecipeHandler newInstance() {
        if(aFuels==null || aFuels.isEmpty())
            findFuels();
        return super.newInstance();
    }

    private static void findFuels() {
        aFuels = new ArrayList<ItemStack>();
        Set<Item> efuels = excludedFuels();
        for (ItemStack item : ItemList.items) {
            Block block = Block.getBlockFromItem(item.getItem());
            if (block instanceof BlockDoor)
                continue;
            if (efuels.contains(item.getItem()))
                continue;

            int burnTime = TileEntityFurnace.getItemBurnTime(item);
            if (burnTime > 0)
                aFuels .add(item.copy());
        }
    }
    @Override
    public String getGuiTexture() {
        return "necromantia:textures/gui/cauldron.png";
    }

    @Override
    public String getRecipeName() {
        return NEINecromantiaConfig.NEILang.translate("cauldron");
    }




    public class RecipeComparator implements Comparator<CachedCauldronRecipe>
    {

        @Override
        public int compare(CachedCauldronRecipe o1, CachedCauldronRecipe o2) {
            return 0;
        }
    }

}
