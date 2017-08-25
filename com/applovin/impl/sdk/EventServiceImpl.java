package com.applovin.impl.sdk;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.droidhang.pay.util.IabHelper;
import com.facebook.AppEventsConstants;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class EventServiceImpl implements AppLovinEventService {
    private final AppLovinSdkImpl f344a;
    private final List f345b;

    public EventServiceImpl(AppLovinSdk appLovinSdk) {
        this.f344a = (AppLovinSdkImpl) appLovinSdk;
        this.f345b = Arrays.asList(((String) ((AppLovinSdkImpl) appLovinSdk).m253a(cd.bd)).split(","));
    }

    private Uri m263a(bz bzVar, C0168t c0168t) {
        C0166r dataCollector = this.f344a.getDataCollector();
        C0171w a = dataCollector.m774a();
        C0169u c = dataCollector.m777c();
        boolean contains = this.f345b.contains(bzVar.m466a());
        Builder appendQueryParameter = Uri.parse((String) this.f344a.m253a(cd.bc)).buildUpon().appendQueryParameter(DataLayer.EVENT_KEY, contains ? bzVar.m466a() : "postinstall").appendQueryParameter("ts", Long.toString(bzVar.m468c())).appendQueryParameter("platform", "Android").appendQueryParameter("model", a.f713a).appendQueryParameter("package_name", c.f709c).appendQueryParameter("sdk_key", this.f344a.getSdkKey()).appendQueryParameter("idfa", c0168t.f706b).appendQueryParameter("dnt", Boolean.toString(c0168t.f705a)).appendQueryParameter("ia", Long.toString(c.f710d)).appendQueryParameter("api_did", (String) this.f344a.m253a(cd.f564c)).appendQueryParameter("brand", a.f715c).appendQueryParameter("model", a.f713a).appendQueryParameter("revision", a.f716d).appendQueryParameter("sdk_version", AppLovinSdk.VERSION).appendQueryParameter("os", a.f714b).appendQueryParameter("orientation_lock", a.f721i).appendQueryParameter("app_version", this.f344a.getDataCollector().m777c().f708b).appendQueryParameter("country_code", a.f718f).appendQueryParameter("carrier", a.f719g).appendQueryParameter("tz_offset", String.valueOf(a.f724l)).appendQueryParameter("adr", a.f726n ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO).appendQueryParameter("volume", String.valueOf(a.f728p));
        C0170v c0170v = a.f727o;
        if (c0170v != null) {
            appendQueryParameter.appendQueryParameter("act", String.valueOf(c0170v.f711a));
            appendQueryParameter.appendQueryParameter("acm", String.valueOf(c0170v.f712b));
        }
        String str = a.f729q;
        if (AppLovinSdkUtils.isValidString(str)) {
            appendQueryParameter.appendQueryParameter("ua", dp.m708c(str));
        }
        if (!contains) {
            appendQueryParameter = appendQueryParameter.appendQueryParameter("sub_event", bzVar.m466a());
        }
        return appendQueryParameter.build();
    }

    private Map m265a(Map map) {
        Map hashMap = new HashMap();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if ((key instanceof String) && (value instanceof String)) {
                    hashMap.put((String) key, (String) value);
                } else {
                    this.f344a.getLogger().mo641w("EventServiceImpl", "Unexpected class type in trackEvent(); all keys and values passed as parameters must be String. Encountered " + key.getClass().getCanonicalName() + "/" + value.getClass().getCanonicalName() + "; will use toString() value instead, which may be unexpected...");
                    hashMap.put(key.toString(), value.toString());
                }
            }
        }
        return hashMap;
    }

    private void m266a(bz bzVar) {
        if (((Boolean) this.f344a.m253a(cd.be)).booleanValue()) {
            this.f344a.getLogger().mo635d("EventServiceImpl", "Tracking event: " + bzVar);
            m267a(new C0172x(this, bzVar));
        }
    }

    private void m267a(cr crVar) {
        this.f344a.m252a().m649a(new cq(this.f344a, crVar), cz.BACKGROUND);
    }

    public void trackCheckout(String str, Map map) {
        Map hashMap = map != null ? new HashMap(map) : new HashMap(1);
        hashMap.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent("checkout", hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map map) {
        m266a(new bz(str, m265a(map), System.currentTimeMillis(), dp.m706b(UUID.randomUUID().toString())));
    }

    public void trackInAppPurchase(Intent intent, Map map) {
        Map hashMap = map != null ? new HashMap(map) : new HashMap();
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra(IabHelper.RESPONSE_INAPP_SIGNATURE));
        } catch (Throwable e) {
            this.f344a.getLogger().userError("EventServiceImpl", "Unable to track in app purchase; invalid purchanse intent", e);
        }
        trackEvent(AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE, hashMap);
    }
}
