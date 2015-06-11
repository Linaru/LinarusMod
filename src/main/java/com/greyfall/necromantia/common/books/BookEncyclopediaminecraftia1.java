package com.greyfall.necromantia.common.books;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

public class BookEncyclopediaminecraftia1 extends ItemEditableBook
{
    public BookEncyclopediaminecraftia1()
    {
        super();
        this.setMaxStackSize(1);
    }

    private NBTTagList putTableOfContents(NBTTagList bookTagList)
    {
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagList bookPages = new NBTTagList();
        bookPages.appendTag(new NBTTagString("Page 1"));

        return bookTagList;
    }

    public void onUpdate(ItemStack itemStack, World world, Entity entity, int unknownInt, boolean unknownBool)
    {
        NBTTagList bookTagList = new NBTTagList();
        NBTTagCompound tag = new NBTTagCompound();
        bookTagList = putTableOfContents(bookTagList);

        itemStack.setTagInfo("pages", bookTagList);
        itemStack.setTagInfo("author", new NBTTagString("Professor Grizwald"));
        itemStack.setTagInfo("title", new NBTTagString("Encyclopedia Minecraftia: Volume 1"));
    }
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.displayGUIBook(par1ItemStack);
        return par1ItemStack;
    }

}

/*

ItemStack tomeStack = new ItemStack(Item.writableBook);
NBTTagList bookPages = new NBTTagList("pages");
bookPages.appendTag(new NBTTagString("1", "Insert text here."));
        bookPages.appendTag(new NBTTagString("2", "Insert moar text here."));
        tomeStack.setTagInfo("pages", bookPages);
        tomeStack.setTagInfo("author", new NBTTagString("author", "Author name here"));
        tomeStack.setTagInfo("title", new NBTTagString("title", "Title here"));
        tomeStack.itemID = Item.writtenBook.itemID;

*/