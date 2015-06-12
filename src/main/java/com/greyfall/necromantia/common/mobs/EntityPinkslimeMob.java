package com.greyfall.necromantia.common.mobs;

import com.greyfall.necromantia.common.Main;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
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


	@Override
	public void onUpdate() {
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0)
		{
			this.isDead = true;
		}

		this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
		this.prevSquishFactor = this.squishFactor;
		boolean flag = this.onGround;
		super.onUpdate();
		int i;

		if (this.onGround && !flag)
		{
			i = this.getSlimeSize();

			for (int j = 0; j < i * 8; ++j)
			{
				float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
				float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
				float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
				float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
				//Main.proxy.spawnPinkSlimeParticle(worldObj, this.posX + (double)f2, this.boundingBox.minY, this.posZ + (double)f3, 0.0D, 0.0D, 0.0D);
			}

			if (this.makesSoundOnLand())
			{
				this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			}

			this.squishAmount = -0.5F;
		}
		else if (!this.onGround && flag)
		{
			this.squishAmount = 1.0F;
		}

		this.alterSquishAmount();

		if (this.worldObj.isRemote)
		{
			i = this.getSlimeSize();
			this.setSize(0.6F * (float)i, 0.6F * (float)i);
		}
	}
}
