package com.greyfall.necromantia.common.containers;

import com.greyfall.necromantia.common.tiles.TileEntityCauldron;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

/**
 * Created by Katrina on 05/06/2015.
 */
public class ContainerCauldron extends Container {

    public TileEntityCauldron cauldron;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
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
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if(slot!=null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            switch (p_82846_2_) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if(!this.mergeItemStack(itemstack1,3,39,false))
                        return null;
                    slot.onSlotChange(itemstack1,itemstack);

                default:
                    if(FluidContainerRegistry.isContainer(itemstack1))
                    {
                        if(!this.mergeItemStack(itemstack1,0,1,false))
                            return null;
                    }
                    else
                        if(TileEntityFurnace.isItemFuel(itemstack1))
                        {
                            if(!mergeItemStack(itemstack1,3,4,false))
                                return null;
                        }
                    else
                        if(!this.mergeItemStack(itemstack1,4,5,false))
                            return null;



            }
            if(itemstack1.stackSize<=0)
                slot.putStack(null);
            else
                slot.onSlotChanged();
            if(itemstack1.stackSize==itemstack.stackSize)
                return null;
            slot.onPickupFromSlot(p_82846_1_,itemstack1);
        }
        return itemstack;
    }


    @Override
    public void addCraftingToCrafters(ICrafting p_75132_1_) {
        super.addCraftingToCrafters(p_75132_1_);

        p_75132_1_.sendProgressBarUpdate(this, 0, this.cauldron.cauldronCookTime);
        p_75132_1_.sendProgressBarUpdate(this, 1, this.cauldron.cauldronBurnTime);
        p_75132_1_.sendProgressBarUpdate(this, 2, this.cauldron.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();


        for (int i = 0; i < crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) crafters.get(i);
            //if(fluidAmount!=cauldron.tank.getFluidAmount())
            //    icrafting.sendProgressBarUpdate(this,1,cauldron.tank.getFluidAmount());
            if(this.lastCookTime!=this.cauldron.cauldronCookTime)
                icrafting.sendProgressBarUpdate(this,0,this.cauldron.cauldronCookTime);

            if(this.lastBurnTime!=this.cauldron.cauldronBurnTime)
                icrafting.sendProgressBarUpdate(this,1,this.cauldron.cauldronBurnTime);

            if(this.lastItemBurnTime!=this.cauldron.currentItemBurnTime)
                icrafting.sendProgressBarUpdate(this,2,this.cauldron.currentItemBurnTime);
        }
        lastCookTime=cauldron.cauldronCookTime;
        lastBurnTime=cauldron.cauldronBurnTime;
        lastItemBurnTime=cauldron.currentItemBurnTime;

    }


    @Override
    public void updateProgressBar(int i, int j) {
        super.updateProgressBar(i, j);

        switch (i)
        {
            case 0:
                this.cauldron.cauldronCookTime=j;
                break;
            case 1:
                this.cauldron.cauldronBurnTime=j;
                break;
            case 2:
                this.cauldron.currentItemBurnTime=j;
                break;
        }
    }
}
