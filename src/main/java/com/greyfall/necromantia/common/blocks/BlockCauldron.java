package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.core.GuiHandler;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockCauldron extends BlockContainer {

    public BlockCauldron(Material material) {
        super(material);
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeMetal);
        this.setBlockTextureName("necromantia:textures/blocks/cauldron.png");
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add("Used for the process of Boiling ingredients.");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityCauldron();
    }

    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
        return Main.candleRenderID;
    }


    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        TileEntityCauldron cauldron=(TileEntityCauldron)world.getTileEntity(x,y,z);

        if(cauldron.tank.getFluidAmount()>0)
            return cauldron.tank.getFluid().getFluid().getLuminosity(cauldron.tank.getFluid());
        return 0;
    }

    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (p_149727_1_.isRemote)
            return true;
        p_149727_5_.openGui(Main.modInstance, GuiHandler.CAULDRON_ID,p_149727_1_,p_149727_2_,p_149727_3_,p_149727_4_);
        return true;
    }
}
