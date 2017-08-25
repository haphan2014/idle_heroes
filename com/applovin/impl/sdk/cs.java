package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class cs extends cc {
    private final String f613a;
    private final Map f614b;
    private final AppLovinPostbackListener f615c;
    private int f616d;
    private int f617i;
    private int f618j = -1;

    public cs(AppLovinSdkImpl appLovinSdkImpl, String str, Map map, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", appLovinSdkImpl);
        this.f613a = str;
        this.f615c = appLovinPostbackListener;
        this.f614b = map;
    }

    public void m599a(int i) {
        this.f616d = i;
    }

    public void m600b(int i) {
        this.f617i = i;
    }

    public void m601c(int i) {
        this.f618j = i;
    }

    public void run() {
        if (AppLovinSdkUtils.isValidString(this.f613a)) {
            df ctVar = new ct(this, "RepeatTaskDispatchPostback", this.f616d < 0 ? ((Integer) this.f.m253a(cd.az)).intValue() : this.f616d, this.f);
            ctVar.m483a((long) this.f617i);
            ctVar.run();
            return;
        }
        this.f.getLogger().mo638i("TaskDispatchPostback", "Requested URL is not valid; nothing to do...");
        this.f615c.onPostbackFailure(this.f613a, AppLovinErrorCodes.INVALID_URL);
    }
}
