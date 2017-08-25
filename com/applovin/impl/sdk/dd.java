package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.impl.adview.C0142v;
import com.applovin.impl.adview.ap;
import com.applovin.impl.sdk.AppLovinAdImpl.AdPresentationMode;
import com.applovin.impl.sdk.AppLovinAdImpl.AdTarget;
import com.applovin.impl.sdk.AppLovinAdImpl.Builder;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class dd extends cc implements C0152do {
    private final JSONObject f647a;
    private final AppLovinAdLoadListener f648b;
    private C0150c f649c = new C0150c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);

    dd(JSONObject jSONObject, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskRenderAd", appLovinSdkImpl);
        this.f647a = jSONObject;
        this.f648b = appLovinAdLoadListener;
    }

    private float m652a(AppLovinAdType appLovinAdType, float f, boolean z) {
        return appLovinAdType.equals(AppLovinAdType.INCENTIVIZED) ? 0.5f : (appLovinAdType.equals(AppLovinAdType.REGULAR) && z && f == GroundOverlayOptions.NO_DIMENSION) ? 0.5f : 0.0f;
    }

    private C0142v m653a(int i) {
        return i == 1 ? C0142v.WhiteXOnTransparentGrey : i == 2 ? C0142v.Invisible : C0142v.WhiteXOnOpaqueBlack;
    }

    private C0142v m654a(boolean z) {
        return z ? C0142v.WhiteXOnTransparentGrey : C0142v.WhiteXOnOpaqueBlack;
    }

    private AdPresentationMode m655a(String str, AppLovinAdType appLovinAdType, boolean z) {
        if (AppLovinSdkUtils.isValidString(str)) {
            if (str.contains("activity") || str.contains("view_controller")) {
                return AdPresentationMode.ACTIVITY;
            }
            if (str.contains("dialog")) {
                return AdPresentationMode.DIALOG;
            }
        }
        return (z || appLovinAdType.equals(AppLovinAdType.INCENTIVIZED)) ? AdPresentationMode.ACTIVITY : AdPresentationMode.DIALOG;
    }

    private cz m656a(String str) {
        return "main".equalsIgnoreCase(str) ? cz.MAIN : cz.BACKGROUND;
    }

    private void m657a(JSONObject jSONObject) {
        AppLovinAdSize fromString;
        JSONObject jSONObject2 = jSONObject;
        String a = be.m383a(jSONObject2, "html", null, this.f);
        if (jSONObject.has("size")) {
            fromString = AppLovinAdSize.fromString(jSONObject.getString("size"));
        } else {
            fromString = AppLovinAdSize.BANNER;
        }
        if (a == null || a.length() <= 0) {
            this.g.mo636e(this.e, "No HTML received for requested ad");
            dp.m702a(this.f648b, this.f649c, -6, this.f);
            return;
        }
        AdTarget valueOf;
        AppLovinAdType fromString2;
        boolean z;
        Uri uri;
        boolean z2;
        Uri parse;
        Uri parse2;
        C0142v a2;
        C0142v a3;
        String string;
        ap apVar;
        if (jSONObject.has("ad_target")) {
            valueOf = AdTarget.valueOf(jSONObject.getString("ad_target").toUpperCase(Locale.ENGLISH));
        } else {
            valueOf = AdTarget.DEFAULT;
        }
        if (jSONObject.has("ad_type")) {
            fromString2 = AppLovinAdType.fromString(jSONObject.getString("ad_type").toUpperCase(Locale.ENGLISH));
        } else {
            fromString2 = AppLovinAdType.REGULAR;
        }
        this.f649c = new C0150c(fromString, fromString2);
        long j = -1;
        if (jSONObject.has("ad_id")) {
            j = jSONObject.getLong("ad_id");
        }
        boolean z3 = false;
        boolean z4 = false;
        Uri uri2 = null;
        if (jSONObject.has("stream_url")) {
            try {
                String string2 = jSONObject.getString("stream_url");
                if (AppLovinSdkUtils.isValidString(string2)) {
                    this.g.mo635d(this.e, "Video ad #" + j + " has a stream url '" + string2 + "'");
                    uri2 = Uri.parse(string2);
                    z3 = true;
                    z4 = true;
                }
                Uri uri3 = uri2;
                z = z4;
                uri = uri3;
            } catch (Exception e) {
                z = false;
                uri = null;
            }
        } else {
            z = false;
            uri = null;
        }
        String str = "";
        Uri uri4 = null;
        if (jSONObject.has("video")) {
            try {
                boolean z5;
                str = jSONObject.getString("video");
                if (AppLovinSdkUtils.isValidString(str)) {
                    this.g.mo635d(this.e, "Video ad #" + j + " has a normal video url '" + str + "'");
                    uri2 = Uri.parse(str);
                    z5 = true;
                } else {
                    z5 = z;
                    uri2 = null;
                }
                z2 = z5;
                uri4 = uri2;
            } catch (Exception e2) {
                z2 = z;
            }
        } else {
            z2 = z;
        }
        uri2 = null;
        jSONObject2 = jSONObject;
        String a4 = be.m383a(jSONObject2, "mute_image", null, this.f);
        if (AppLovinSdkUtils.isValidString(a4)) {
            try {
                parse = Uri.parse(a4);
            } catch (Exception e3) {
                parse = uri2;
            }
        } else {
            parse = uri2;
        }
        uri2 = null;
        jSONObject2 = jSONObject;
        String a5 = be.m383a(jSONObject2, "unmute_image", "", this.f);
        if (AppLovinSdkUtils.isValidString(a5)) {
            try {
                parse2 = Uri.parse(a5);
            } catch (Exception e4) {
                parse2 = uri2;
            }
        } else {
            parse2 = uri2;
        }
        jSONObject2 = jSONObject;
        int a6 = be.m381a(jSONObject2, "countdown_length", 0, this.f);
        jSONObject2 = jSONObject;
        float a7 = be.m380a(jSONObject2, "close_delay", 0.0f, this.f);
        float a8 = be.m380a(jSONObject, "close_delay_graphic", m652a(fromString2, a7, z2), this.f);
        jSONObject2 = jSONObject;
        float a9 = be.m380a(jSONObject2, "mraid_close_delay_graphic", 0.0f, this.f);
        jSONObject2 = jSONObject;
        boolean a10 = be.m387a(jSONObject2, "close_button_graphic_hidden", false, this.f);
        C0142v a11 = m654a(z2);
        if (jSONObject.has("close_style")) {
            try {
                a2 = m653a(jSONObject.getInt("close_style"));
            } catch (JSONException e5) {
                a2 = m654a(z2);
            }
        } else {
            a2 = a11;
        }
        if (jSONObject.has("skip_style")) {
            try {
                a3 = m653a(jSONObject.getInt("skip_style"));
            } catch (JSONException e6) {
                a3 = m654a(z2);
            }
        } else {
            a3 = a2;
        }
        String str2 = "";
        if (jSONObject.has("clcodes")) {
            try {
                string = ((JSONArray) jSONObject.get("clcodes")).getString(0);
            } catch (JSONException e7) {
                string = str2;
            }
        } else {
            string = str2;
        }
        String a12 = be.m383a(jSONObject, "video_end_url", "", this.f);
        String a13 = be.m383a(jSONObject, "click_tracking_url", "", this.f);
        boolean a14 = be.m387a(jSONObject, "dismiss_on_skip", false, this.f);
        boolean a15 = be.m387a(jSONObject, "video_clickable", false, this.f);
        String a16 = be.m383a(jSONObject, "click_url", "", this.f);
        boolean a17 = be.m387a(jSONObject, "accelerate_hardware", false, this.f);
        str2 = "";
        if (jSONObject.has("video_button_properties")) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("video_button_properties");
                ap apVar2 = new ap(jSONObject3, this.f);
                try {
                    str2 = be.m383a(jSONObject3, "video_button_html", "", this.f);
                } catch (Exception e8) {
                }
            } catch (Exception e9) {
                apVar = null;
            }
        } else {
            apVar = null;
        }
        boolean a18 = be.m387a(jSONObject, "hide_close_on_exit_graphic", false, this.f);
        boolean a19 = be.m387a(jSONObject, "hide_close_on_exit", false, this.f);
        boolean a20 = be.m387a(jSONObject, "lock_current_orientation", false, this.f);
        AdPresentationMode a21 = m655a(be.m383a(jSONObject, "presentation_mode", "", this.f), fromString2, z2);
        boolean a22 = be.m387a(jSONObject, "vs_cache_immediately", false, this.f);
        boolean a23 = be.m387a(jSONObject, "vs_load_immediately", true, this.f);
        String a24 = be.m383a(jSONObject, "vs_ad_cache_priority", "background", this.f);
        Builder videoStream = new Builder().setSize(fromString).setType(fromString2).setCurrentAdIdNumber(j).setTarget(valueOf).setCloseButtonStyle(a2).setSkipButtonStyle(a3).setClCode(string).setVideoCloseDelay(a7).setCloseDelay(a8).setMraidCloseDelay(a9).setCountdownLength(a6).setCompletionUrl(a12).setSupplementalClickTrackingUrl(a13).setDismissOnSkip(a14).setVideoClickableDuringPlayback(a15).setClickDestinationUrl(a16).setVideoButtonHtmlSource(str2).setVideoButtonProperties(apVar).setAccelerateHardware(a17).setCloseButtonHidden(a10).setHideCloseButtonOnExit(a18).setHideVideoCloseButtonOnExit(a19).setPresentationMode(a21).setLockCurrentOrientation(a20).setHtml(a).setMuteImageUri(parse).setUnmuteImageUri(parse2).setVideoStream(z3);
        if (!z3) {
            uri = uri4;
        }
        AppLovinAdImpl build = videoStream.setVideoUri(uri).build();
        this.g.mo635d(this.e, "Creating cache task...");
        cc cmVar = new cm(build, str, this.f648b, this.f);
        if (!build.isVideoStream() || a22) {
            this.f.m252a().m648a(cmVar);
            return;
        }
        cz a25 = m656a(a24);
        cmVar.m580a(a23);
        this.f.m252a().m649a(cmVar, a25);
    }

    public String mo629e() {
        return "tRA";
    }

    public void run() {
        try {
            m657a(this.f647a);
        } catch (Throwable e) {
            if (e instanceof JSONException) {
                this.g.mo637e(this.e, "Unable to parse ad service response", e);
            } else if (e instanceof IllegalArgumentException) {
                this.g.mo637e(this.e, "Ad response is not valid", e);
            } else {
                this.g.mo637e(this.e, "Unable to render ad", e);
            }
            dp.m702a(this.f648b, this.f649c, -6, this.f);
        }
    }
}
