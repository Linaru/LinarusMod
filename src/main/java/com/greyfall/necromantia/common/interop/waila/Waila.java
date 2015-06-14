package com.greyfall.necromantia.common.interop.waila;

import codechicken.lib.util.LangProxy;
import com.greyfall.necromantia.common.blocks.BlockCauldron;
import com.greyfall.necromantia.common.blocks.BlockWildRice;
import mcp.mobius.waila.api.IWailaRegistrar;

/**
 * Created by Katrina on 11/06/2015.
 */
public class Waila {

    public static LangProxy WailaLang=new LangProxy("necromantia.waila");

    public static void callbackRegister(IWailaRegistrar registrar)
    {
        registrar.registerBodyProvider(new CauldronProvider(), BlockCauldron.class);
        registrar.registerBodyProvider(new RiceProvider(), BlockWildRice.class);
    }
}
