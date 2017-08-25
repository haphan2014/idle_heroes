package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;

class bw implements AppLovinPostbackListener {
    final /* synthetic */ AppLovinPostbackListener f513a;
    final /* synthetic */ PostbackServiceImpl f514b;

    bw(PostbackServiceImpl postbackServiceImpl, AppLovinPostbackListener appLovinPostbackListener) {
        this.f514b = postbackServiceImpl;
        this.f513a = appLovinPostbackListener;
    }

    public void onPostbackFailure(String str, int i) {
        this.f514b.f365a.getLogger().mo636e("PostbackService", "Failed to dispatch postback to URL " + str + ": " + i);
        if (this.f513a != null) {
            this.f513a.onPostbackFailure(str, i);
        }
    }

    public void onPostbackSuccess(String str) {
        this.f514b.f365a.getLogger().mo635d("PostbackService", "Successfully dispatched postback to URL " + str);
        if (this.f513a != null) {
            this.f513a.onPostbackSuccess(str);
        }
    }
}
