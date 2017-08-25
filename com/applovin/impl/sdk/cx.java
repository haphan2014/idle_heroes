package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;

class cx implements Runnable {
    private final AppLovinSdkImpl f627a;
    private final AppLovinLogger f628b;
    private final Context f629c;

    cx(AppLovinSdkImpl appLovinSdkImpl) {
        this.f627a = appLovinSdkImpl;
        this.f629c = appLovinSdkImpl.getApplicationContext();
        this.f628b = appLovinSdkImpl.getLogger();
    }

    private void m639c() {
        String str = (String) this.f627a.m253a(cd.f540E);
        if (str.length() > 0) {
            for (String fromString : str.split(",")) {
                AppLovinAdSize fromString2 = AppLovinAdSize.fromString(fromString);
                if (fromString2 != null) {
                    this.f627a.m256c().mo609d(new C0150c(fromString2, AppLovinAdType.REGULAR));
                }
            }
        }
        if (((Boolean) this.f627a.m253a(cd.f541F)).booleanValue()) {
            this.f627a.m256c().mo609d(new C0150c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED));
        }
        if (((Boolean) this.f627a.m253a(cd.aF)).booleanValue()) {
            this.f627a.m257d().mo609d(NativeAdImpl.SPEC_NATIVE);
        }
    }

    boolean m640a() {
        if (C0166r.m764a("android.permission.INTERNET", this.f629c)) {
            return true;
        }
        this.f628b.userError("TaskInitializeSdk", "Unable to enable AppLovin SDK: no android.permission.INTERNET");
        return false;
    }

    void m641b() {
        this.f627a.m252a().m650a(new ck(this.f627a), cz.MAIN, 500);
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f628b.mo635d("TaskInitializeSdk", "Initializing AppLovin SDK 6.4.2...");
        try {
            if (m640a()) {
                ci b = this.f627a.m255b();
                b.m560c();
                b.m561c("ad_imp_session");
                C0147a.m272b(this.f627a);
                this.f627a.getFileManager().m292e(this.f629c);
                this.f627a.getFileManager().m291d(this.f629c);
                m639c();
                m641b();
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f629c);
                if (!AppLovinSdkUtils.isValidString(defaultSharedPreferences.getString("com.applovin.sdk.impl.isFirstRun", null))) {
                    defaultSharedPreferences.edit().putString("com.applovin.sdk.impl.isFirstRun", Boolean.toString(true)).commit();
                }
                this.f627a.getPersistentPostbackManager().m453a();
                this.f627a.getEventService().trackEvent("landing");
                this.f627a.m254a(true);
            } else {
                this.f627a.m254a(false);
            }
            this.f628b.mo635d("TaskInitializeSdk", "AppLovin SDK 6.4.2 initialization " + (this.f627a.isEnabled() ? "succeeded" : "failed") + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        } catch (Throwable th) {
            Throwable th2 = th;
            this.f628b.mo635d("TaskInitializeSdk", "AppLovin SDK 6.4.2 initialization " + (this.f627a.isEnabled() ? "succeeded" : "failed") + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }
}
