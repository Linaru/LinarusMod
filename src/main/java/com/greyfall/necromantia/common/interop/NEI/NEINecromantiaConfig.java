package com.greyfall.necromantia.common.interop.NEI;

import codechicken.lib.util.LangProxy;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import com.greyfall.necromantia.common.Main;
import com.greyfall.necromantia.common.libs.LibMisc;

/**
 * Created by Katrina on 11/06/2015.
 */
public class NEINecromantiaConfig implements IConfigureNEI {


public static LangProxy NEILang=new LangProxy("necromantia.nei");


    @Override
    public void loadConfig() {
        CauldronRecipeHandler handler=new CauldronRecipeHandler();
        API.registerRecipeHandler(handler);
        API.registerUsageHandler(handler);
    }

    @Override
    public String getName() {
        return "Necromantia NEI Plugin";
    }

    @Override
    public String getVersion() {
        return LibMisc.MOD_VERSION;
    }
}
