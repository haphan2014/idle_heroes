package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdType {
    public static final AppLovinAdType INCENTIVIZED = new AppLovinAdType("VIDEOA");
    public static final AppLovinAdType REGULAR = new AppLovinAdType("REGULAR");
    private final String f735a;

    public AppLovinAdType(String str) {
        this.f735a = str;
    }

    public static Set allTypes() {
        Set hashSet = new HashSet(2);
        hashSet.add(REGULAR);
        hashSet.add(INCENTIVIZED);
        return hashSet;
    }

    public static AppLovinAdType fromString(String str) {
        return str.toUpperCase(Locale.ENGLISH).equals(INCENTIVIZED.getLabel()) ? INCENTIVIZED : REGULAR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdType appLovinAdType = (AppLovinAdType) obj;
        if (this.f735a != null) {
            if (this.f735a.equals(appLovinAdType.f735a)) {
                return true;
            }
        } else if (appLovinAdType.f735a == null) {
            return true;
        }
        return false;
    }

    public String getLabel() {
        return this.f735a.toUpperCase(Locale.ENGLISH);
    }

    public int hashCode() {
        return this.f735a != null ? this.f735a.hashCode() : 0;
    }

    public String toString() {
        return getLabel();
    }
}
