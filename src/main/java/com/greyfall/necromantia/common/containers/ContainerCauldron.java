package com.greyfall.necromantia.common.containers;

import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Created by Katrina on 05/06/2015.
 */
public class ContainerCauldron extends Container {

    public TileEntityCauldron cauldron;
    public ContainerCauldron(TileEntityCauldron cauldron,EntityPlayer player)
    {
        this.cauldron=cauldron;
        this.addSlotToContainer(new SlotLiquid(cauldron,0,26,17));
        this.addSlotToContainer(new SlotLiquid(cauldron,1,26,53));
        this.addSlotToContainer(new Slot(cauldron,2,62,17));
        this.addSlotToContainer(new Slot(cauldron,3,62,53));
        this.addSlotToContainer(new Slot(cauldron,4,117,26));
        this.addSlotToContainer(new Slot(cauldron,5,135,26));
        this.addSlotToContainer(new Slot(cauldron,6,117,44));
        this.addSlotToContainer(new Slot(cauldron,7,135,44));


        for(int i=0;i<3;i++)
        {
            for(int j=0;j<9;j++)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18 + 0));// somenumber));
            }
        }

        for(int i=0;i<9;i++)
        {
            this.addSlotToContainer(new Slot(player.inventory,i,8+i*18,142));
        }


    }
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }




}
