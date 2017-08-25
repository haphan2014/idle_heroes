package com.applovin.impl.adview;

import com.applovin.impl.sdk.be;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.cast.TextTrackStyle;
import org.json.JSONObject;

public class ap {
    private final AppLovinLogger f165a;
    private int f166b;
    private int f167c;
    private int f168d;
    private int f169e;
    private boolean f170f;
    private int f171g;
    private int f172h;
    private int f173i;
    private float f174j;
    private float f175k;

    public ap(JSONObject jSONObject, AppLovinSdk appLovinSdk) {
        this.f165a = appLovinSdk.getLogger();
        this.f165a.mo638i("VideoButtonProperties", "Updating video button properties with JSON = " + jSONObject);
        this.f166b = be.m381a(jSONObject, "width", 64, appLovinSdk);
        this.f167c = be.m381a(jSONObject, "height", 7, appLovinSdk);
        this.f168d = be.m381a(jSONObject, "margin", 20, appLovinSdk);
        this.f169e = be.m381a(jSONObject, "gravity", 85, appLovinSdk);
        this.f170f = be.m387a(jSONObject, "tap_to_fade", false, appLovinSdk);
        this.f171g = be.m381a(jSONObject, "tap_to_fade_duration_milliseconds", 500, appLovinSdk);
        this.f172h = be.m381a(jSONObject, "fade_in_duration_milliseconds", 500, appLovinSdk);
        this.f173i = be.m381a(jSONObject, "fade_out_duration_milliseconds", 500, appLovinSdk);
        this.f174j = be.m380a(jSONObject, "fade_in_delay_seconds", (float) TextTrackStyle.DEFAULT_FONT_SCALE, appLovinSdk);
        this.f175k = be.m380a(jSONObject, "fade_out_delay_seconds", 6.0f, appLovinSdk);
    }

    public int m157a() {
        return this.f166b;
    }

    public int m158b() {
        return this.f167c;
    }

    public int m159c() {
        return this.f168d;
    }

    public int m160d() {
        return this.f169e;
    }

    public boolean m161e() {
        return this.f170f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ap apVar = (ap) obj;
        if (this.f166b != apVar.f166b || this.f167c != apVar.f167c || this.f168d != apVar.f168d || this.f169e != apVar.f169e || this.f170f != apVar.f170f || this.f171g != apVar.f171g || this.f172h != apVar.f172h || this.f173i != apVar.f173i || Float.compare(apVar.f174j, this.f174j) != 0) {
            return false;
        }
        if (Float.compare(apVar.f175k, this.f175k) != 0) {
            z = false;
        }
        return z;
    }

    public int m162f() {
        return this.f171g;
    }

    public int m163g() {
        return this.f172h;
    }

    public int m164h() {
        return this.f173i;
    }

    public int hashCode() {
        int i = 0;
        int floatToIntBits = ((this.f174j != 0.0f ? Float.floatToIntBits(this.f174j) : 0) + (((((((((this.f170f ? 1 : 0) + (((((((this.f166b * 31) + this.f167c) * 31) + this.f168d) * 31) + this.f169e) * 31)) * 31) + this.f171g) * 31) + this.f172h) * 31) + this.f173i) * 31)) * 31;
        if (this.f175k != 0.0f) {
            i = Float.floatToIntBits(this.f175k);
        }
        return floatToIntBits + i;
    }

    public float m165i() {
        return this.f174j;
    }

    public float m166j() {
        return this.f175k;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f166b + ", heightPercentOfScreen=" + this.f167c + ", margin=" + this.f168d + ", gravity=" + this.f169e + ", tapToFade=" + this.f170f + ", tapToFadeDurationMillis=" + this.f171g + ", fadeInDurationMillis=" + this.f172h + ", fadeOutDurationMillis=" + this.f173i + ", fadeInDelay=" + this.f174j + ", fadeOutDelay=" + this.f175k + '}';
    }
}
