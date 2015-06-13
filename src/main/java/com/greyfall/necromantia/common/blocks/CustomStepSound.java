package com.greyfall.necromantia.common.blocks;

import net.minecraft.block.Block;

/**
 * Created by Katrina on 13/06/2015.
 */
public class CustomStepSound extends Block.SoundType {
    public CustomStepSound(String name, float volume, float frequency) {
        super(name, volume, frequency);
    }


    @Override
    public String getBreakSound() {
        return "necromantia:"+this.soundName;
    }

    @Override
    public String getStepResourcePath() {
        return "necromantia:"+this.soundName;
    }
}
