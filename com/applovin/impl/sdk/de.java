package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class de extends cc {
    private final AppLovinNativeAdLoadListener f650a;
    private final JSONObject f651b;

    de(JSONObject jSONObject, AppLovinSdkImpl appLovinSdkImpl, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskRenderNativeAd", appLovinSdkImpl);
        this.f650a = appLovinNativeAdLoadListener;
        this.f651b = jSONObject;
    }

    private String m659a(Map map, String str) {
        String str2 = (String) map.get("simp_url");
        if (AppLovinSdkUtils.isValidString(str2)) {
            return str2.replace("{CLCODE}", str);
        }
        throw new IllegalArgumentException("No impression URL available");
    }

    private String m660a(Map map, String str, String str2) {
        String str3 = (String) map.get("click_url");
        if (AppLovinSdkUtils.isValidString(str3)) {
            CharSequence charSequence;
            if (str2 == null) {
                charSequence = "";
            }
            return str3.replace("{CLCODE}", str).replace("{EVENT_ID}", charSequence);
        }
        throw new IllegalArgumentException("No impression URL available");
    }

    private void m661a(JSONObject jSONObject) {
        List<Map> a = be.m384a(jSONObject.getJSONArray("native_ads"));
        Map a2 = be.m385a(jSONObject.getJSONObject("native_settings"));
        List arrayList = new ArrayList(a.size());
        for (Map map : a) {
            String str = (String) map.get("clcode");
            NativeAdImpl a3 = new bh().m396e((String) map.get("title")).m397f((String) map.get("description")).m398g((String) map.get("caption")).m407p((String) map.get("cta")).m392a((String) map.get("icon_url")).m393b((String) map.get("image_url")).m395d((String) map.get("video_url")).m394c((String) map.get("star_rating_url")).m399h((String) map.get("icon_url")).m400i((String) map.get("image_url")).m401j((String) map.get("video_url")).m389a(Float.parseFloat((String) map.get("star_rating"))).m406o(str).m402k(m659a(a2, str)).m403l(m660a(a2, str, (String) map.get("event_id"))).m404m(m662b(a2, str)).m405n(m663c(a2, str)).m390a(Long.parseLong((String) map.get("ad_id"))).m391a(this.f).m388a();
            arrayList.add(a3);
            this.f.getLogger().mo635d("TaskRenderNativeAd", "Prepared slot: " + a3.getAdId());
        }
        if (this.f650a != null) {
            this.f650a.onNativeAdsLoaded(arrayList);
        }
    }

    private String m662b(Map map, String str) {
        String str2 = (String) map.get("video_start_url");
        return str2 != null ? str2.replace("{CLCODE}", str) : null;
    }

    private String m663c(Map map, String str) {
        String str2 = (String) map.get("video_end_url");
        return str2 != null ? str2.replace("{CLCODE}", str) : null;
    }

    void m664a(int i) {
        try {
            if (this.f650a != null) {
                this.f650a.onNativeAdsFailedToLoad(i);
            }
        } catch (Throwable e) {
            this.f.getLogger().mo637e("TaskRenderNativeAd", "Unable to notify listener about failure.", e);
        }
    }

    public void run() {
        try {
            if (this.f651b == null || this.f651b.length() == 0) {
                m664a((int) AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            } else {
                m661a(this.f651b);
            }
        } catch (Throwable e) {
            this.f.getLogger().mo637e("TaskRenderNativeAd", "Unable to render widget.", e);
            m664a((int) AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES);
        }
    }
}
