package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class dh extends ca {
    private final AppLovinAdImpl f655a;

    public dh(AppLovinSdkImpl appLovinSdkImpl, AppLovinAd appLovinAd) {
        super("TaskReportReward", appLovinSdkImpl);
        this.f655a = (AppLovinAdImpl) appLovinAd;
    }

    public void run() {
        String b = ab.m301b();
        String clCode = this.f655a.getClCode();
        Map hashMap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(clCode)) {
            hashMap.put("clcode", clCode);
        } else {
            hashMap.put("clcode", "NO_CLCODE");
        }
        if (b != null) {
            hashMap.put("user_id", b);
        }
        bs a = bs.m436a();
        clCode = a.m440b(this.f655a);
        if (clCode != null) {
            hashMap.put("result", clCode);
            Map a2 = a.m437a(this.f655a);
            if (a2 != null) {
                hashMap.put("params", a2);
            }
            m473a("cr", new JSONObject(hashMap), new di(this));
            return;
        }
        this.g.mo635d("TaskReportReward", "No reward result was found for ad: " + this.f655a);
    }
}
