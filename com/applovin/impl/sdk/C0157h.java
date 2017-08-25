package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.Collection;
import java.util.HashSet;

class C0157h implements AppLovinAdLoadListener {
    final /* synthetic */ AppLovinAdServiceImpl f677a;
    private final C0158i f678b;

    private C0157h(AppLovinAdServiceImpl appLovinAdServiceImpl, C0158i c0158i) {
        this.f677a = appLovinAdServiceImpl;
        this.f678b = c0158i;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        synchronized (this.f678b.f680b) {
            if (this.f677a.m239a(this.f678b.f679a)) {
                long b = this.f677a.m242b(this.f678b.f679a);
                if (b > 0) {
                    this.f678b.f682d = (b * 1000) + System.currentTimeMillis();
                } else if (b == 0) {
                    this.f678b.f682d = Long.MAX_VALUE;
                }
                this.f678b.f681c = appLovinAd;
            } else {
                this.f678b.f681c = null;
                this.f678b.f682d = 0;
            }
            Collection<AppLovinAdLoadListener> hashSet = new HashSet(this.f678b.f685g);
            this.f678b.f685g.clear();
            Collection<AppLovinAdUpdateListener> hashSet2 = new HashSet(this.f678b.f684f);
            this.f678b.f683e = false;
        }
        this.f677a.m247c(this.f678b.f679a);
        for (AppLovinAdLoadListener adReceived : hashSet) {
            try {
                adReceived.adReceived(appLovinAd);
            } catch (Throwable th) {
                this.f677a.f315b.mo637e("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            }
        }
        for (AppLovinAdUpdateListener adUpdated : hashSet2) {
            try {
                adUpdated.adUpdated(appLovinAd);
            } catch (Throwable th2) {
                this.f677a.f315b.mo637e("AppLovinAdService", "Unable to notify listener about an updated loaded ad", th2);
            }
        }
    }

    public void failedToReceiveAd(int i) {
        synchronized (this.f678b.f680b) {
            Collection<AppLovinAdLoadListener> hashSet = new HashSet(this.f678b.f685g);
            this.f678b.f685g.clear();
            this.f678b.f683e = false;
        }
        for (AppLovinAdLoadListener failedToReceiveAd : hashSet) {
            try {
                failedToReceiveAd.failedToReceiveAd(i);
            } catch (Throwable th) {
                this.f677a.f315b.mo637e("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            }
        }
    }
}
