package com.greyfall.necromantia.common.interop.waila;

import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

/**
 * Created by Katrina on 11/06/2015.
 */
public class CauldronProvider implements IWailaDataProvider {
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {

        TileEntity entity=accessor.getTileEntity();
        if(entity instanceof TileEntityCauldron)
        {
            TileEntityCauldron cauldron=(TileEntityCauldron)entity;
            FluidStack fluid=cauldron.tank.getFluid();
            if(fluid!=null)
            {
                String fluidName=fluid.getLocalizedName();
                int amount=fluid.amount;

                currenttip.add(Waila.WailaLang.format("cauldron.fluidName",fluidName));
                currenttip.add(Waila.WailaLang.format("cauldron.fluidAmount",amount));
            }
            else
            {
                currenttip.add(Waila.WailaLang.translate("cauldron.noFluid"));
            }
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
        return tag;
    }
}
