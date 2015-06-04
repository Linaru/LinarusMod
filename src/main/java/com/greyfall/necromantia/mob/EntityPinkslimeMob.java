package com.greyfall.necromantia.mob;

import com.greyfall.necromantia.Main;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityPinkslimeMob extends EntitySlime{

	public EntityPinkslimeMob(World par1World) {
		super(par1World);
		this.setSize(0.75F, 1F);//Width, Height      
	}

	@Override
	protected EntitySlime createInstance()
	    {
	        return new EntityPinkslimeMob(this.worldObj);
	    }
	
	@Override
	protected Item getDropItem()
	{
		return this.getSlimeSize() == 1 ? Main.itemSlimelatex : Item.getItemById(0);
	}

	@Override
	protected void setSlimeSize(int p_70799_1_)
	{
		super.setSlimeSize(p_70799_1_);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)(p_70799_1_ * (p_70799_1_ + 5)));
		this.setHealth(this.getMaxHealth());
	}



}
