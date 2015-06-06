package com.greyfall.necromantia.common.tiles;

import codechicken.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

/**
 * Created by Katrina on 05/06/2015.
 */
public class TileEntityCauldron extends TileEntity implements ISidedInventory, IFluidHandler{

    ItemStack[] inventory=new ItemStack[8];
    public FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME);


    @Override
    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        readExtraNBT(p_145839_1_);
    }

    private void readExtraNBT(NBTTagCompound tagCompound) {
        InventoryUtils.readItemStacksFromTag(inventory, tagCompound.getTagList("inventory", Constants.NBT.TAG_COMPOUND));
        if(tagCompound.hasKey("fluid"))
            tank.setFluid(FluidStack.loadFluidStackFromNBT(tagCompound.getCompoundTag("fluid")));
    }

    @Override
    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);
        writeExtraNBT(p_145841_1_);
    }

    private void writeExtraNBT(NBTTagCompound tagCompound) {
        tagCompound.setTag("inventory", InventoryUtils.writeItemStacksToTag(inventory));
        NBTTagCompound cmp=new NBTTagCompound();
        if(tank.getFluid()!=null) {
            tank.getFluid().writeToNBT(cmp);
            tagCompound.setTag("fluid", cmp);
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
        this.worldObj.markBlockForUpdate(xCoord,yCoord,zCoord);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound cmp=new NBTTagCompound();
        writeExtraNBT(cmp);
        return new S35PacketUpdateTileEntity(xCoord,yCoord,zCoord,-999,cmp);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        readExtraNBT(pkt.func_148857_g());
    }

    public TileEntityCauldron() {
//        tank.fill(new FluidStack(FluidRegistry.LAVA,1000),true);
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {

        int amount=tank.fill(resource,doFill);
        this.markDirty();
        return amount;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if (resource == null || !resource.isFluidEqual(tank.getFluid()))
        {
            return null;
        }
        FluidStack amount=tank.drain(resource.amount, doDrain);
        this.markDirty();
        return amount;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        FluidStack amount=tank.drain(maxDrain, doDrain);
        this.markDirty();
        return amount;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return true;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return true;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[]{tank.getInfo()};
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0]; // todo: add slots for each side
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return true; // todo: make conditional
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true; // todo: make conditional
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {
        return inventory[p_70301_1_];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        if (this.inventory[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.inventory[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.inventory[p_70298_1_];
                this.inventory[p_70298_1_] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.inventory[p_70298_1_].splitStack(p_70298_2_);

                if (this.inventory[p_70298_1_].stackSize == 0)
                {
                    this.inventory[p_70298_1_] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        if (this.inventory[p_70304_1_] != null)
        {
            ItemStack itemstack = this.inventory[p_70304_1_];
            this.inventory[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
        this.inventory[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return "cauldron";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        if(p_94041_1_==0 || p_94041_1_==1)
        {
            if(p_94041_2_.getItem() instanceof  IFluidContainerItem || p_94041_2_.getItem() instanceof ItemBucket)
                return true;
            else
                return false;
        }
        return true;
    }
}
