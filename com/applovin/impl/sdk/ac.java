package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Map;

class ac implements AppLovinAdRewardListener {
    final /* synthetic */ ab f384a;

    ac(ab abVar) {
        this.f384a = abVar;
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        this.f384a.f373a.getLogger().mo635d("IncentivizedAdController", "User declined to view");
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map map) {
        this.f384a.f373a.getLogger().mo635d("IncentivizedAdController", "User over quota: " + map);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
        this.f384a.f373a.getLogger().mo635d("IncentivizedAdController", "Reward rejected: " + map);
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
        this.f384a.f373a.getLogger().mo635d("IncentivizedAdController", "Reward validated: " + map);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        this.f384a.f373a.getLogger().mo635d("IncentivizedAdController", "Reward validation failed: " + i);
    }
}
