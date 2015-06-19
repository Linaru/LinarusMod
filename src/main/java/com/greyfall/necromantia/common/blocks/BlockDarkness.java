package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.BlockNames;
import com.greyfall.necromantia.common.tiles.TileEntityDarkness;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
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

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.attackEntityFrom(null, 100);
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
}
