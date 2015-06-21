package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.core.enums.EnumCreativeTab;
import com.greyfall.necromantia.common.libs.BlockNames;
import com.greyfall.necromantia.common.tiles.TileEntityDarkness;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent;

public class BlockDarkness extends ModBlockContainer {


    public BlockDarkness() {
        super(Material.ground);
        this.setHardness(-1F);
        this.setBlockUnbreakable();
        this.setResistance(3000);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName(BlockNames.DARKNESS);
        this.setBlockTextureName(LibTextures.DARKNESS);


    }


    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityDarkness();
    }


    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double) ((float) p_149633_2_ + f), (double) p_149633_3_, (double) ((float) p_149633_4_ + f), (double) ((float) (p_149633_2_ + 1) - f), (double) (p_149633_3_ + 1), (double) ((float) (p_149633_4_ + 1) - f));
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.attackEntityFrom(DamageSource.outOfWorld, 100.0f);
    }

    /*@Override
    public int getRenderType() {
        return Main.candleRenderID;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
=======

>>>>>>> 7864b0b638a11852052ae7d56ecedc8f720ec0ed
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }*/

    @Override
    public EnumCreativeTab getCreativeTab() {
        return EnumCreativeTab.ADMIN;
    }
}
