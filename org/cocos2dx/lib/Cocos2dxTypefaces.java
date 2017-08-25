package org.cocos2dx.lib;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;

public class Cocos2dxTypefaces {
    private static final HashMap<String, Typeface> sTypefaceCache = new HashMap();

    public static synchronized Typeface get(Context pContext, String pAssetName) {
        Typeface typeface;
        synchronized (Cocos2dxTypefaces.class) {
            if (!sTypefaceCache.containsKey(pAssetName)) {
                Typeface typeface2;
                if (pAssetName.startsWith("/")) {
                    typeface2 = Typeface.createFromFile(pAssetName);
                } else {
                    typeface2 = Typeface.createFromAsset(pContext.getAssets(), pAssetName);
                }
                sTypefaceCache.put(pAssetName, typeface2);
            }
            typeface = (Typeface) sTypefaceCache.get(pAssetName);
        }
        return typeface;
    }
}
