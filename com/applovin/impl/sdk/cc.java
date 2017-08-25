package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.sdk.AppLovinLogger;

abstract class cc implements Runnable {
    final String f524e;
    protected final AppLovinSdkImpl f525f;
    final AppLovinLogger f526g;
    final Context f527h;

    cc(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f525f = appLovinSdkImpl;
        if (str == null) {
            str = getClass().getSimpleName();
        }
        this.f524e = str;
        this.f526g = appLovinSdkImpl.getLogger();
        this.f527h = appLovinSdkImpl.getApplicationContext();
    }

    String m471a() {
        return this.f524e;
    }

    void mo628b() {
    }
}
