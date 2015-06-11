package com.greyfall.necromantia.common.interop.NEI;

import codechicken.lib.util.LangProxy;
import codechicken.nei.api.API;

/**
 * Created by Katrina on 11/06/2015.
 */
public class NEI {


public static LangProxy NEILang=new LangProxy("necromantia.nei");
    public static void addHandlers()
    {
        CauldronRecipeHandler handler=new CauldronRecipeHandler();
        API.registerRecipeHandler(handler);
        API.registerUsageHandler(handler);
    }
}
