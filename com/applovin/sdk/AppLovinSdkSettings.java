package com.applovin.sdk;

import com.applovin.impl.sdk.NativeAdImpl;

public class AppLovinSdkSettings {
    private boolean f452a = false;
    private boolean f453b = false;
    private long f454c = -1;
    private String f455d = AppLovinAdSize.INTERSTITIAL.getLabel();
    private String f456e = (AppLovinAdType.INCENTIVIZED.getLabel() + "," + AppLovinAdType.REGULAR.getLabel() + "," + NativeAdImpl.TYPE_NATIVE.getLabel());
    private boolean f457f = false;

    public String getAutoPreloadSizes() {
        return this.f455d;
    }

    public String getAutoPreloadTypes() {
        return this.f456e;
    }

    public long getBannerAdRefreshSeconds() {
        return this.f454c;
    }

    public boolean isMuted() {
        return this.f457f;
    }

    public boolean isTestAdsEnabled() {
        return this.f452a;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f453b;
    }

    public void setAutoPreloadSizes(String str) {
        this.f455d = str;
    }

    public void setAutoPreloadTypes(String str) {
        this.f456e = str;
    }

    public void setBannerAdRefreshSeconds(long j) {
        this.f454c = j;
    }

    public void setMuted(boolean z) {
        this.f457f = z;
    }

    public void setTestAdsEnabled(boolean z) {
        this.f452a = z;
    }

    public void setVerboseLogging(boolean z) {
        this.f453b = z;
    }
}
