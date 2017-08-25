package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;

class C0147a {
    private static final Object f366a = new Object();
    private static final Map f367b = new HashMap();

    static Map m269a(AppLovinSdkImpl appLovinSdkImpl) {
        Map c;
        synchronized (f366a) {
            appLovinSdkImpl.getLogger().mo635d("AdDataCache", "Reading cached device data...");
            c = C0147a.m274c(appLovinSdkImpl);
        }
        return c;
    }

    private static void m270a(String str, Map map) {
        String[] split = str.split("=");
        if (split.length == 2) {
            map.put(split[0], split[1]);
        }
    }

    static void m271a(Map map, AppLovinSdkImpl appLovinSdkImpl) {
        C0147a.m273b(map, appLovinSdkImpl);
    }

    static void m272b(AppLovinSdkImpl appLovinSdkImpl) {
        synchronized (f366a) {
            appLovinSdkImpl.getLogger().mo635d("AdDataCache", "Clearing old device data cache...");
            C0147a.m271a(new HashMap(0), appLovinSdkImpl);
        }
    }

    private static void m273b(Map map, AppLovinSdkImpl appLovinSdkImpl) {
        if (map == null) {
            throw new IllegalArgumentException("No ad aata specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            try {
                synchronized (f367b) {
                    Map map2 = (Map) f367b.get("ad_data_cache");
                    if (map2 == null) {
                        map2 = new HashMap();
                    }
                    map2.clear();
                    map2.putAll(map);
                    f367b.put("ad_data_cache", map2);
                }
                Editor edit = appLovinSdkImpl.getSettingsManager().m500a().edit();
                edit.putString("ad_data_cache", dp.m700a(map));
                edit.commit();
                appLovinSdkImpl.getLogger().mo635d("AdDataCache", map.size() + " " + "ad_data_cache" + " entries saved in cache");
            } catch (Throwable e) {
                appLovinSdkImpl.getLogger().mo637e("AdDataCache", "Unable to save ad data entries", e);
            }
        }
    }

    private static Map m274c(AppLovinSdkImpl appLovinSdkImpl) {
        Map map;
        Map hashMap;
        Throwable e;
        synchronized (f367b) {
            map = (Map) f367b.get("ad_data_cache");
        }
        if (map == null) {
            SharedPreferences a = appLovinSdkImpl.getSettingsManager().m500a();
            String string = a.getString("ad_data_cache", "");
            if (string != null && string.length() > 0) {
                try {
                    hashMap = new HashMap();
                    try {
                        for (String a2 : string.split("&")) {
                            C0147a.m270a(a2, hashMap);
                        }
                        synchronized (f367b) {
                            f367b.put("ad_data_cache", hashMap);
                        }
                        appLovinSdkImpl.getLogger().mo635d("AdDataCache", hashMap.size() + " " + "ad_data_cache" + " entries loaded from cache");
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable e3) {
                    Throwable th = e3;
                    hashMap = map;
                    e = th;
                    appLovinSdkImpl.getLogger().mo637e("AdDataCache", "Unable to load ad data", e);
                    Editor edit = a.edit();
                    edit.putString("ad_data_cache", "");
                    edit.commit();
                    return hashMap != null ? new HashMap(hashMap) : new HashMap();
                }
                if (hashMap != null) {
                }
            }
        }
        hashMap = map;
        if (hashMap != null) {
        }
    }
}
