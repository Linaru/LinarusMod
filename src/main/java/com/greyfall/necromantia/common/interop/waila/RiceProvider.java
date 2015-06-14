package com.greyfall.necromantia.common.interop.waila;

import com.greyfall.necromantia.common.blocks.BlockWildRice;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Katrina on 14/06/2015.
 */
public class RiceProvider implements IWailaDataProvider {
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
        if (!config.getConfig("general.showcrop")) return currenttip;
        int growthStage = accessor.getMetadata();
        float growthValue=(growthStage/ 7.0f)*100.0f;
        if(growthValue<100.0)
            currenttip.add(String.format("%s : %.0f %%",Waila.WailaLang.translate("rice.growth"),growthValue));
        else
            currenttip.add(String.format("%s : %s",Waila.WailaLang.translate("rice.growth"),Waila.WailaLang.translate("rice.mature")));
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
