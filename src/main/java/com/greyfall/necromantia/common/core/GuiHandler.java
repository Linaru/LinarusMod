package com.greyfall.necromantia.common.core;

import com.greyfall.necromantia.client.render.gui.GuiCauldron;
import com.greyfall.necromantia.common.containers.ContainerCauldron;
import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Katrina on 05/06/2015.
 */
public class GuiHandler implements IGuiHandler {

    public static final int CAULDRON_ID=1;
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity=world.getTileEntity(x,y,z);
        switch(ID)
        {
            case CAULDRON_ID:
                return new ContainerCauldron((TileEntityCauldron)entity,player);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity=world.getTileEntity(x,y,z);
        switch(ID)
        {
            case CAULDRON_ID:
                return new GuiCauldron((TileEntityCauldron)entity,player);
            default:
                return null;
        }
    }
}
