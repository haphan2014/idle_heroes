package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

class C0162m implements AppLovinTargetingData {
    private final AppLovinSdkImpl f690a;
    private final Context f691b;

    C0162m(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f690a = appLovinSdkImpl;
        this.f691b = appLovinSdkImpl.getApplicationContext();
    }

    private static String m727a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strArr) {
            if (AppLovinSdkUtils.isValidString(str)) {
                stringBuilder.append(dp.m708c(str));
                stringBuilder.append(",");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private void m728a(String str, String str2) {
        if (AppLovinSdkUtils.isValidString(str)) {
            Editor edit = this.f691b.getSharedPreferences("applovin.sdk.targeting", 0).edit();
            edit.putString(str, dp.m708c(str2));
            edit.commit();
        }
    }

    Map m729a() {
        Map hashMap = new HashMap();
        Map all = this.f691b.getSharedPreferences("applovin.sdk.targeting", 0).getAll();
        if (all != null && all.size() > 0) {
            for (Entry entry : all.entrySet()) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return hashMap;
    }

    public void clearData() {
        Editor edit = this.f691b.getSharedPreferences("applovin.sdk.targeting", 0).edit();
        edit.clear();
        edit.commit();
    }

    public void putExtra(String str, String str2) {
        if (AppLovinSdkUtils.isValidString(str) && AppLovinSdkUtils.isValidString(str2)) {
            m728a("ex_" + str, str2);
        }
    }

    public void setBirthYear(int i) {
        if (i < 9999 && i > 1900) {
            m728a("yob", Integer.toString(i));
        }
    }

    public void setCarrier(String str) {
        this.f690a.getLogger().userError("AppLovinTargetingDataImpl", "Explicitly setting `carrier` targeting data is deprecated.");
    }

    public void setCountry(String str) {
        this.f690a.getLogger().userError("AppLovinTargetingDataImpl", "Explicitly setting `country code` targeting data is deprecated.");
    }

    public void setGender(char c) {
        String str = c == AppLovinTargetingData.GENDER_MALE ? "m" : c == AppLovinTargetingData.GENDER_FEMALE ? "f" : "u";
        m728a("gender", str);
    }

    public void setInterests(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            m728a("interests", C0162m.m727a(strArr));
        }
    }

    public void setKeywords(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            m728a("keywords", C0162m.m727a(strArr));
        }
    }

    public void setLanguage(String str) {
        if (AppLovinSdkUtils.isValidString(str)) {
            m728a("language", str.toLowerCase(Locale.ENGLISH));
        }
    }

    public void setLocation(Location location) {
        this.f690a.getLogger().userError("AppLovinTargetingDataImpl", "Explicitly setting `location` targeting data is deprecated.");
    }
}
