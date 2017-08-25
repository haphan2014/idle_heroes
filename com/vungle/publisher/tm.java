package com.vungle.publisher;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.facebook.internal.ServerProtocol;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;
import org.nexage.sourcekit.mraid.BuildConfig;

/* compiled from: vungle */
public final class tm extends aar {
    JSONObject f3300a;
    JSONObject f3301b;
    JSONObject f3302c;
    JSONObject f3303d;
    JSONObject f3304e;
    JSONObject f3305f;
    JSONObject f3306g;
    JSONObject f3307h;
    String f3308i;
    tr f3309j;
    Boolean f3310k;
    Boolean f3311l;
    Boolean f3312m;
    Boolean f3313n;
    @Inject
    nf f3314o;

    @Singleton
    /* compiled from: vungle */
    public static class C1888a {
        @Inject
        Provider<tm> f3299a;

        @Inject
        C1888a() {
        }

        public final tm m2503a() {
            return (tm) this.f3299a.get();
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    @Inject
    tm() {
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("maxSize", this.f3300a);
        a.putOpt("screenSize", this.f3301b);
        a.putOpt("defaultPosition", this.f3302c);
        a.putOpt("currentPosition", this.f3303d);
        a.putOpt("expandProperties", this.f3304e);
        a.putOpt("resizeProperties", this.f3305f);
        a.putOpt("orientationProperties", this.f3306g);
        a.putOpt("supports", this.f3307h);
        a.putOpt("state", this.f3308i);
        a.putOpt("placementType", this.f3309j);
        a.putOpt("isViewable", this.f3310k);
        a.putOpt("os", "android");
        a.putOpt("osVersion", Integer.toString(VERSION.SDK_INT));
        a.putOpt("startMuted", this.f3311l);
        a.putOpt("incentivized", this.f3312m);
        a.putOpt("enableBackImmediately", this.f3313n);
        a.putOpt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, BuildConfig.VERSION_NAME);
        return a;
    }

    private static JSONObject m2504a(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
        } catch (Throwable e) {
            so.m2471a("VungleProtocol", "exception setting mraid size properties", e);
        }
        return jSONObject;
    }

    private static JSONObject m2505b(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", 0);
            jSONObject.put("y", 0);
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
        } catch (Throwable e) {
            so.m2471a("VungleProtocol", "exception setting mraid position properties", e);
        }
        return jSONObject;
    }

    public final void m2509c() {
        DisplayMetrics displayMetrics = this.f3314o.f2629a.getResources().getDisplayMetrics();
        int i = (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
        DisplayMetrics displayMetrics2 = this.f3314o.f2629a.getResources().getDisplayMetrics();
        int i2 = (int) (((float) displayMetrics2.heightPixels) / displayMetrics2.density);
        this.f3300a = m2504a(i, i2);
        this.f3301b = m2504a(i, i2);
        this.f3302c = m2505b(i, i2);
        this.f3303d = m2505b(i, i2);
    }

    public final void m2507a(boolean z) {
        this.f3310k = Boolean.valueOf(z);
    }
}
