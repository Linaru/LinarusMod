package com.greyfall.necromantia.common.tiles;

import codechicken.lib.inventory.InventoryUtils;
import com.greyfall.necromantia.api.crafting.CauldronCrafting;
import com.greyfall.necromantia.api.crafting.CauldronRecipe;
import com.greyfall.necromantia.common.core.helpers.ItemStackHelper;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;
import thaumcraft.api.ItemApi;
import thaumcraft.api.wands.IWandable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Katrina on 05/06/2015.
 */
@Optional.Interface(modid = "Thaumcraft",iface = "thaumcraft.api.wands.IWandable")
public class TileEntityCauldron extends TileEntity implements ISidedInventory, IFluidHandler,IWandable{

    ItemStack[] inventory=new ItemStack[8];
    public FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME);
    public int cauldronBurnTime;
    public int currentItemBurnTime;
    public int cauldronCookTime;

    @Override
    public void readFromNBT(NBTTagCompound p_145839_1_) {
        super.readFromNBT(p_145839_1_);
        readExtraNBT(p_145839_1_);
        this.cauldronBurnTime=p_145839_1_.getInteger("cauldronBurnTime");
        this.cauldronCookTime=p_145839_1_.getInteger("cauldronCookTime");
        this.currentItemBurnTime=TileEntityFurnace.getItemBurnTime(getStackInSlot(3));
    }

    private void readExtraNBT(NBTTagCompound tagCompound) {
        InventoryUtils.readItemStacksFromTag(inventory, tagCompound.getTagList("inventory", Constants.NBT.TAG_COMPOUND));
        if(tagCompound.hasKey("fluid",Constants.NBT.TAG_COMPOUND))
            tank.setFluid(FluidStack.loadFluidStackFromNBT(tagCompound.getCompoundTag("fluid")));
        if(tagCompound.hasKey("fluid",Constants.NBT.TAG_STRING) && tagCompound.getString("fluid").equalsIgnoreCase("null"))
            tank.setFluid(null);
    }

    @Override
    public void writeToNBT(NBTTagCompound p_145841_1_) {
        super.writeToNBT(p_145841_1_);
        writeExtraNBT(p_145841_1_);
        p_145841_1_.setInteger("cauldronBurnTime",cauldronBurnTime);
        p_145841_1_.setInteger("cauldronCookTime",cauldronCookTime);
    }


    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int scale)
    {
        CauldronRecipe recipe=getRecipe();
        if(recipe!=null)
            return this.cauldronCookTime*scale/recipe.getBurnTime();
        else
            return this.cauldronCookTime*scale/200;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int scale)
    {
        if(this.currentItemBurnTime==0)
            this.currentItemBurnTime=200;
        return this.cauldronBurnTime*scale/this.currentItemBurnTime;
    }

    public boolean isBurning(){return this.cauldronBurnTime>0;}


    private void writeExtraNBT(NBTTagCompound tagCompound) {
        tagCompound.setTag("inventory", InventoryUtils.writeItemStacksToTag(inventory));
        NBTTagCompound cmp=new NBTTagCompound();
        if(tank.getFluid()!=null) {
            tank.getFluid().writeToNBT(cmp);
            tagCompound.setTag("fluid", cmp);
        }
        else
            tagCompound.setString("fluid","null");
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

        ForgeDirection dir=ForgeDirection.getOrientation(p_94128_1_);
        switch (dir)
        {
            case DOWN:
                return new int[]{4,5,6,7};
            case UP:
                return new int[]{2};
            default:
                return new int[]{3};
        }
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
    public void updateEntity() {
        super.updateEntity();
        if(inventory[0]!=null)
        {
            if(FluidContainerRegistry.isFilledContainer(inventory[0]))
            {
                ItemStack empty= FluidContainerRegistry.drainFluidContainer(inventory[0]);
                if(empty==null || inventory[1]==null || (inventory[1]!=null && empty.isItemEqual(inventory[1]) && inventory[1].stackSize+empty.stackSize <= inventory[1].getMaxStackSize()))
                {
                    int amount=FluidContainerRegistry.getContainerCapacity(inventory[0]);
                    if(tank.getCapacity()-tank.getFluidAmount() >=amount) {

                        if (tank.getFluid() == null || tank.getFluid().getFluid() == FluidContainerRegistry.getFluidForFilledItem(inventory[0]).getFluid()) {
                            tank.fill(FluidContainerRegistry.getFluidForFilledItem(inventory[0]), true);
                            if (inventory[1] != null)
                                inventory[1].stackSize += empty.stackSize;
                            else
                                inventory[1] = empty.copy();
                            inventory[0].stackSize--;
                            if(inventory[0].stackSize<=0)
                                inventory[0]=null;
                            markDirty();
                        }
                    }
                }
            }
            else
            {

                ItemStack filled=FluidContainerRegistry.fillFluidContainer(tank.getFluid(),inventory[0]);

                if(filled!=null)
                {
                    if(inventory[1]== null || inventory[1].stackSize+filled.stackSize <= inventory[1].getMaxStackSize())
                    {
                        if(inventory[1]==null)
                            inventory[1]=filled.copy();
                        else
                            inventory[1].stackSize+=filled.stackSize;
                        inventory[0].stackSize--;
                        if(inventory[0].stackSize<=0)
                            inventory[0]=null;
                        tank.drain(FluidContainerRegistry.getFluidForFilledItem(filled).amount,true);
                        markDirty();
                    }
                }
            }
        }



        boolean flag = this.cauldronBurnTime > 0;
        boolean flag1 = false;

        if(isBurning())
            cauldronBurnTime--;
        if(!worldObj.isRemote)
        {
            if(this.cauldronBurnTime!=0 || getStackInSlot(2) !=null && getStackInSlot(3)!=null && tank.getFluid()!=null)
            {
                if(cauldronBurnTime==0 && this.canSmelt())
                {
                    this.currentItemBurnTime=cauldronBurnTime=TileEntityFurnace.getItemBurnTime(getStackInSlot(3));
                    if(this.cauldronBurnTime>0)
                    {
                        flag1=true;
                        if(getStackInSlot(3)!=null)
                        {
                            --getStackInSlot(3).stackSize;
                            if(this.getStackInSlot(3).stackSize<=0)
                                inventory[3]=inventory[3].getItem().getContainerItem(inventory[3]);
                        }
                    }
                }

                if(this.isBurning() && this.canSmelt())
                {
                    ++this.cauldronCookTime;
                    if(this.cauldronCookTime==getRecipe().getBurnTime())
                    {
                        this.cauldronCookTime=0;
                        this.smeltItem();
                        flag1=true;
                    }

                }
                else
                {
                    this.cauldronCookTime=0;
                }
            }

            if(flag!=this.isBurning())
                flag1=true;

        }

        if(flag1)
            this.markDirty();

    }

    public CauldronRecipe getRecipe()
    {
        return CauldronCrafting.findRecipe(inventory[2],tank.getFluid());
    }

    private  boolean canSmelt()
    {
        if(this.inventory[2]==null)
            return false;
        else
        {
            CauldronRecipe recipe=CauldronCrafting.findRecipe(this.inventory[2],tank.getFluid());
            if(recipe!=null && recipe.isFluidicOutput())
            {
                return recipe.isRecepieRight(this.inventory[2],tank.getFluid());
            }
            ItemStack[] output=CauldronCrafting.getOutput(this.inventory[2],tank.getFluid());
            if(output==null)
                return false;
            return hasAvailableOutputSlots(output);
        }
    }
    public void smeltItem()
    {
        if(this.canSmelt())
        {
            ItemStack[] output=CauldronCrafting.doRecipe(inventory[2],tank.getFluid());
            for(ItemStack item:output)
            {

                for(int i=4;i<8;i++)
                {
                    if(inventory[i]==null)
                    {
                        inventory[i]=item.copy();
                        break;
                    }
                    else
                    {
                        if(inventory[i].isItemEqual(item))
                        {
                            int result=inventory[i].stackSize+item.stackSize;
                            if(result<=getInventoryStackLimit() && result <=inventory[i].getMaxStackSize())
                            {
                                inventory[i].stackSize=result;
                                break;
                            }
                        }
                    }
                }
            }
            if(inventory[2].stackSize<=0)
                inventory[2]=null;

            if(tank.getFluid().amount<=0)
                tank.setFluid(null);
        }
    }
    private boolean hasAvailableOutputSlots(ItemStack[] output) {
        ItemStack[] items= ItemStackHelper.copyItemsStackArray(inventory);
        for(ItemStack item:output)
        {
            boolean found=false;
            for(int i=4;i<8;i++)
            {
                if(items[i]==null)
                {
                    items[i]=item;
                    found=true;
                    break;
                }
                else
                {
                    if(items[i].isItemEqual(item))
                    {
                        int result=items[i].stackSize+item.stackSize;
                        if(result<=getInventoryStackLimit() && result <=items[i].getMaxStackSize())
                        {
                            items[i].stackSize=result;
                            found=true;
                            break;
                        }
                    }
                }
            }
            if(!found)
                return false;
        }
        return true;
    }


    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        switch(p_94041_1_)
        {
            case 0:
            case 1:
            if(FluidContainerRegistry.isContainer(p_94041_2_))
                return true;
            else
                return false;
            case 3:
                return TileEntityFurnace.isItemFuel(p_94041_2_) && ! (p_94041_2_.getItem() instanceof  ItemBucket);

            default:
                return true;
        }
    }

    @Override
    @Optional.Method(modid = "Thaumcraft")
    public int onWandRightClick(World world, ItemStack wandstack, EntityPlayer player, int x, int y, int z, int side, int md) {
        if(player.isSneaking())
        {
            world.setBlock(x,y,z, Block.getBlockFromItem(ItemApi.getBlock("blockMetalDevice",0).getItem()));
        }
        return 0;
    }

    @Override
    @Optional.Method(modid = "Thaumcraft")
    public ItemStack onWandRightClick(World world, ItemStack wandstack, EntityPlayer player) {

        return wandstack;
    }

    @Override
    @Optional.Method(modid = "Thaumcraft")
    public void onUsingWandTick(ItemStack wandstack, EntityPlayer player, int count) {

    }

    @Override
    @Optional.Method(modid = "Thaumcraft")
    public void onWandStoppedUsing(ItemStack wandstack, World world, EntityPlayer player, int count) {

    }
}
