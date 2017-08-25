package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

class ck extends cc {
    ck(AppLovinSdkImpl appLovinSdkImpl) {
        super("SubmitData", appLovinSdkImpl);
    }

    void m564a(JSONObject jSONObject) {
        try {
            JSONObject a = C0165q.m754a(jSONObject);
            cg settingsManager = this.f.getSettingsManager();
            settingsManager.m502a(cd.f564c, a.getString("device_id"));
            settingsManager.m502a(cd.f566e, a.getString("device_token"));
            settingsManager.m502a(cd.f565d, a.getString("publisher_id"));
            settingsManager.m505b();
            C0165q.m756a(a, this.f);
            if (a.has("adserver_parameters")) {
                settingsManager.m502a(cd.f580s, a.getJSONObject("adserver_parameters").toString());
            }
        } catch (Throwable e) {
            this.g.mo637e(this.e, "Unable to parse API response", e);
        }
    }

    void m565b(JSONObject jSONObject) {
        C0166r dataCollector = this.f.getDataCollector();
        C0169u c = dataCollector.m777c();
        C0171w a = dataCollector.m774a();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("model", a.f713a);
        jSONObject2.put("os", a.f714b);
        jSONObject2.put("brand", a.f715c);
        jSONObject2.put("sdk_version", a.f717e);
        jSONObject2.put("revision", a.f716d);
        jSONObject2.put("adns", (double) a.f722j);
        jSONObject2.put("adnsd", a.f723k);
        jSONObject2.put("country_code", a.f718f);
        jSONObject2.put("carrier", a.f719g);
        jSONObject2.put("orientation_lock", a.f721i);
        jSONObject2.put("tz_offset", a.f724l);
        jSONObject2.put("adr", a.f726n ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        jSONObject2.put("wvvc", a.f725m);
        jSONObject2.put("volume", a.f728p);
        jSONObject2.put("type", "android");
        C0168t d = dataCollector.m778d();
        String str = d.f706b;
        boolean z = d.f705a;
        if ((!z || ((Boolean) this.f.getSettingsManager().m501a(cd.aX)).booleanValue()) && AppLovinSdkUtils.isValidString(str)) {
            jSONObject2.put("idfa", str);
        }
        C0170v c0170v = a.f727o;
        if (c0170v != null) {
            jSONObject2.put("act", c0170v.f711a);
            jSONObject2.put("acm", c0170v.f712b);
        }
        String str2 = a.f729q;
        if (AppLovinSdkUtils.isValidString(str2)) {
            jSONObject2.put("ua", dp.m708c(str2));
        }
        jSONObject2.put("dnt", z);
        Locale locale = a.f720h;
        if (locale != null) {
            jSONObject2.put("locale", locale.toString());
        }
        jSONObject.put("device_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", c.f709c);
        jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, c.f707a);
        jSONObject3.put("app_version", c.f708b);
        jSONObject3.put("installed_at", c.f710d);
        jSONObject3.put("applovin_sdk_version", AppLovinSdk.VERSION);
        jSONObject3.put("ic", this.f.isInitializedInMainActivity());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.h);
        String string = defaultSharedPreferences.getString("com.applovin.sdk.impl.isFirstRun", null);
        if (AppLovinSdkUtils.isValidString(string)) {
            jSONObject3.put("first_install", string);
            if (string.equalsIgnoreCase(Boolean.toString(true))) {
                defaultSharedPreferences.edit().putString("com.applovin.sdk.impl.isFirstRun", Boolean.toString(false)).apply();
            }
        }
        str2 = (String) this.f.m253a(cd.f587z);
        if (str2 != null && str2.length() > 0) {
            jSONObject3.put("plugin_version", str2);
        }
        jSONObject.put("app_info", jSONObject3);
        if (((Boolean) this.f.m253a(cd.f542G)).booleanValue()) {
            Map a2 = ((C0162m) this.f.getTargetingData()).m729a();
            if (!(a2 == null || a2.isEmpty())) {
                jSONObject.put("targeting", be.m386a(a2));
            }
            jSONObject.put("stats", this.f.m255b().m558b());
        }
    }

    void m566c(JSONObject jSONObject) {
        df clVar = new cl(this, "Repeat" + this.e, cd.f567f, this.f, jSONObject);
        clVar.m484a(cd.f571j);
        clVar.run();
    }

    public void run() {
        try {
            this.g.mo638i(this.e, "Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            m565b(jSONObject);
            m566c(jSONObject);
        } catch (Throwable e) {
            this.g.mo637e(this.e, "Unable to build JSON message with collected data", e);
        }
    }
}
