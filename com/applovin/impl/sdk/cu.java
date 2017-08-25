package com.applovin.impl.sdk;

import android.graphics.Point;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class cu extends cc implements C0152do {
    private final AppLovinAdSize f620a;
    private final AppLovinAdType f621b;
    private final AppLovinAdLoadListener f622c;
    private boolean f623d = false;

    cu(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("FetchNextAd", appLovinSdkImpl);
        this.f620a = appLovinAdSize;
        this.f621b = appLovinAdType;
        this.f622c = appLovinAdLoadListener;
    }

    private void m606a(ci ciVar) {
        if (System.currentTimeMillis() - ciVar.m557b("ad_session_start") > ((long) ((Integer) this.f.m253a(cd.f579r)).intValue()) * 60000) {
            ciVar.m559b("ad_session_start", System.currentTimeMillis());
            ciVar.m561c("ad_imp_session");
        }
    }

    private void m609b(int i) {
        this.g.mo636e(this.e, "Unable to fetch " + this.f620a + " ad: server returned " + i);
        try {
            mo631a(i);
        } catch (Throwable th) {
            this.g.userError(this.e, "Unable process a failure to recieve an ad", th);
        }
        C0165q.m761b(i, this.f);
    }

    private void m610b(JSONObject jSONObject) {
        C0165q.m756a(jSONObject, this.f);
        this.f.m252a().m649a(mo630a(jSONObject), cz.MAIN);
    }

    private void m611d(Map map) {
        if (this.f.getSettings().isTestAdsEnabled()) {
            map.put("test_ads", Boolean.toString(true));
        }
        map.put("api_did", this.f.m253a(cd.f564c));
        map.put("sdk_key", this.f.getSdkKey());
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("app_version", dp.m708c(this.f.getDataCollector().m777c().f708b));
        if (!AppLovinSdk.CIS_BUILD_TAG.equals(AppLovinSdk.CIS_BUILD_TAG)) {
            map.put("build_tag", AppLovinSdk.CIS_BUILD_TAG);
        }
        String str = (String) this.f.m253a(cd.f587z);
        if (str != null && str.length() > 0) {
            map.put("plugin_version", str);
        }
        map.put("accept", m613f());
        map.put("v1", Boolean.toString(C0163n.m733a("android.permission.WRITE_EXTERNAL_STORAGE", this.h)));
        map.put("v2", Boolean.toString(C0163n.m732a(AppLovinInterstitialActivity.class, this.h)));
        map.put("v3", Boolean.toString(C0163n.m731a(this.h)));
        map.put("v4", Boolean.toString(C0163n.m735b(this.h)));
        map.put("preloading", String.valueOf(this.f623d));
        map.put("size", this.f620a.getLabel());
        map.put("format", "json");
        map.put("ia", Long.toString(this.f.getDataCollector().m777c().f710d));
    }

    private void m612e(Map map) {
        if (((Boolean) this.f.m253a(cd.f542G)).booleanValue()) {
            ci b = this.f.m255b();
            map.put("li", String.valueOf(b.m557b("ad_imp")));
            map.put("si", String.valueOf(b.m557b("ad_imp_session")));
        }
    }

    private String m613f() {
        String str = "custom_size,launch_app";
        return (C0163n.m734b() && C0163n.m732a(AppLovinInterstitialActivity.class, this.h)) ? str + ",video" : str;
    }

    private void m614f(Map map) {
        if (((Boolean) this.f.m253a(cd.f542G)).booleanValue()) {
            Map a = ((C0162m) this.f.getTargetingData()).m729a();
            if (a != null && !a.isEmpty()) {
                map.putAll(a);
            }
        }
    }

    private void m615g(Map map) {
        Map a = C0147a.m269a(this.f);
        if (a.isEmpty()) {
            try {
                m616h(a);
                C0147a.m271a(a, this.f);
            } catch (Throwable e) {
                this.g.mo637e(this.e, "Unable to populate device information", e);
            }
        }
        try {
            m617i(a);
        } catch (Throwable e2) {
            this.g.mo637e(this.e, "Unable to populate ephemeral device information", e2);
        }
        map.putAll(a);
        map.put("network", C0165q.m750a(this.f));
        m619k(map);
        map.put("vz", dp.m697a(this.f.getApplicationContext().getPackageName(), this.f));
    }

    private void m616h(Map map) {
        C0171w a = this.f.getDataCollector().m774a();
        map.put("brand", dp.m708c(a.f715c));
        map.put("carrier", dp.m708c(a.f719g));
        map.put("country_code", dp.m708c(a.f718f));
        map.put("locale", a.f720h.toString());
        map.put("model", dp.m708c(a.f713a));
        map.put("os", dp.m708c(a.f714b));
        map.put("platform", "android");
        map.put("revision", dp.m708c(a.f716d));
        map.put("orientation_lock", a.f721i);
        map.put("tz_offset", String.valueOf(a.f724l));
        map.put("wvvc", String.valueOf(a.f725m));
        map.put("adns", String.valueOf(a.f722j));
        map.put("adnsd", String.valueOf(a.f723k));
        m618j(map);
    }

    private void m617i(Map map) {
        C0171w b = this.f.getDataCollector().m776b();
        C0170v c0170v = b.f727o;
        if (c0170v != null) {
            map.put("act", String.valueOf(c0170v.f711a));
            map.put("acm", String.valueOf(c0170v.f712b));
        }
        map.put("adr", b.f726n ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        map.put("volume", String.valueOf(b.f728p));
        String str = b.f729q;
        if (AppLovinSdkUtils.isValidString(str)) {
            map.put("ua", dp.m708c(str));
        }
        m618j(map);
    }

    private void m618j(Map map) {
        Point c = C0163n.m736c(this.f.getApplicationContext());
        map.put("dx", Integer.toString(c.x));
        map.put("dy", Integer.toString(c.y));
    }

    private void m619k(Map map) {
        C0168t d = this.f.getDataCollector().m778d();
        String str = d.f706b;
        boolean z = d.f705a;
        if ((!z || ((Boolean) this.f.getSettingsManager().m501a(cd.aX)).booleanValue()) && AppLovinSdkUtils.isValidString(str)) {
            map.put("idfa", str);
        }
        map.put("dnt", Boolean.toString(z));
    }

    protected cc mo630a(JSONObject jSONObject) {
        return new dd(jSONObject, this.f622c, this.f);
    }

    protected void mo631a(int i) {
        if (this.f622c == null) {
            return;
        }
        if (this.f622c instanceof C0148y) {
            ((C0148y) this.f622c).mo602a(new C0150c(this.f620a, this.f621b), i);
        } else {
            this.f622c.failedToReceiveAd(i);
        }
    }

    protected void m622a(Map map) {
        m614f(map);
        m615g(map);
        m612e(map);
        m611d(map);
        mo632b(map);
        mo633c(map);
    }

    public void m623a(boolean z) {
        this.f623d = z;
    }

    void mo628b() {
        super.mo628b();
        m609b(-410);
    }

    protected void mo632b(Map map) {
        if (this.f621b != null) {
            map.put("require", this.f621b.getLabel());
        }
    }

    String m626c() {
        Map hashMap = new HashMap();
        m622a(hashMap);
        String d = mo634d();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d);
        stringBuffer.append("?");
        stringBuffer.append(dp.m700a(hashMap));
        return stringBuffer.toString();
    }

    protected void mo633c(Map map) {
        dl a = dj.m670a().m671a("tFNA");
        if (a != null) {
            map.put("etf", Long.toString(a.m674b()));
            map.put("ntf", a.m673a());
        }
        a = dj.m670a().m671a("tRA");
        if (a != null) {
            map.put("etr", Long.toString(a.m674b()));
            map.put("ntr", a.m673a());
        }
    }

    protected String mo634d() {
        return C0165q.m760b("2.0/ad", this.f);
    }

    public String mo629e() {
        return "tFNA";
    }

    public void run() {
        if (this.f623d) {
            this.g.mo635d(this.e, "Preloading next ad...");
        } else {
            this.g.mo635d(this.e, "Fetching next ad...");
        }
        ci b = this.f.m255b();
        b.m555a("ad_req");
        m606a(b);
        try {
            df cvVar = new cv(this, "RepeatFetchNextAd", cd.f569h, this.f);
            cvVar.m484a(cd.f572k);
            cvVar.run();
        } catch (Throwable th) {
            this.g.mo637e(this.e, "Unable to fetch " + this.f620a + " ad", th);
            m609b(0);
        }
    }
}
