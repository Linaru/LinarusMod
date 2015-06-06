package com.greyfall.necromantia.common.containers;

import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fluids.FluidStack;

/**
 * Created by Katrina on 05/06/2015.
 */
public class ContainerCauldron extends Container {

    public TileEntityCauldron cauldron;
    public int fluidAmount=-1;
    public ContainerCauldron(TileEntityCauldron cauldron,EntityPlayer player)
    {
        this.cauldron=cauldron;
        this.addSlotToContainer(new SlotLiquid(cauldron,0,26,17));
        this.addSlotToContainer(new SlotLiquid(cauldron,1,26,53));
        this.addSlotToContainer(new Slot(cauldron,2,62,17));
        this.addSlotToContainer(new SlotFuel(cauldron,3,62,53));
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


    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();


        for (int i = 0; i < crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) crafters.get(i);
            //if(fluidAmount!=cauldron.tank.getFluidAmount())
            //    icrafting.sendProgressBarUpdate(this,1,cauldron.tank.getFluidAmount());

        }
        fluidAmount=cauldron.tank.getFluidAmount();
    }


    @Override
    public void updateProgressBar(int i, int j) {
        super.updateProgressBar(i, j);

        switch (i)
        {
            case 1:
                //cauldron.tank.getFluid().amount=j;
                break;
        }
    }
}
