package com.greyfall.necromantia.common.blocks;

import com.greyfall.necromantia.client.libs.LibTextures;
import com.greyfall.necromantia.common.core.config.NecromantiaConfig;
import com.greyfall.necromantia.common.dimensions.EtherealSanctuaryTeleporter;
import com.greyfall.necromantia.common.libs.BlockNames;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

/**
 * Created by Katrina on 14/06/2015.
 */
public class BlockEtherealPortal extends ModBlock {
    public BlockEtherealPortal() {
        super(Material.portal);

        this.setBlockName(BlockNames.ETHEREAL_PORTAL);
        this.setBlockTextureName(LibTextures.ETHEREAL_PORTAL);
    }


    @Override
    public void onEntityWalking(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity p_149724_5_) {
        if(!p_149724_1_.isRemote) {
            if ((p_149724_5_.ridingEntity == null) && (p_149724_5_.riddenByEntity == null) && ((p_149724_5_ instanceof EntityPlayerMP))) {
                EntityPlayerMP player = (EntityPlayerMP) p_149724_5_;

                MinecraftServer mServer = MinecraftServer.getServer();

                if (player.timeUntilPortal > 0)
                {
                    player.timeUntilPortal = 10;
                }
                else if(player.dimension!= NecromantiaConfig.etherealSanctuaryDimensionID)
                {
                    player.timeUntilPortal=10;
                    player.mcServer.getConfigurationManager().transferPlayerToDimension(player,NecromantiaConfig.etherealSanctuaryDimensionID,new EtherealSanctuaryTeleporter(mServer.worldServerForDimension(NecromantiaConfig.etherealSanctuaryDimensionID)));;
                }
                else
                {
                    player.timeUntilPortal=10;
                    player.mcServer.getConfigurationManager().transferPlayerToDimension(player,0,new EtherealSanctuaryTeleporter(mServer.worldServerForDimension(0)));;

                }

            }
        }

    }
}
