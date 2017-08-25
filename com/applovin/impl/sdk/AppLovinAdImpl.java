package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.impl.adview.C0142v;
import com.applovin.impl.adview.ap;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;

public class AppLovinAdImpl implements bf, AppLovinAd {
    private volatile Uri f285A;
    private volatile boolean f286B;
    private volatile Uri f287C;
    private final AppLovinAdSize f288a;
    private final AppLovinAdType f289b;
    private final long f290c;
    private final AdTarget f291d;
    private final C0142v f292e;
    private final C0142v f293f;
    private final String f294g;
    private final float f295h;
    private final float f296i;
    private final float f297j;
    private final int f298k;
    private final String f299l;
    private final String f300m;
    private final boolean f301n;
    private final boolean f302o;
    private final String f303p;
    private final String f304q;
    private final ap f305r;
    private final boolean f306s;
    private final boolean f307t;
    private final boolean f308u;
    private final boolean f309v;
    private final AdPresentationMode f310w;
    private final boolean f311x;
    private volatile String f312y;
    private volatile Uri f313z;

    public enum AdPresentationMode {
        DEFAULT,
        ACTIVITY,
        DIALOG
    }

    public enum AdTarget {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public class Builder {
        private boolean f256A;
        private AdPresentationMode f257B;
        private boolean f258C;
        private String f259a;
        private AppLovinAdSize f260b;
        private AppLovinAdType f261c;
        private AdTarget f262d;
        private C0142v f263e;
        private C0142v f264f;
        private float f265g;
        private float f266h;
        private float f267i;
        private int f268j;
        private long f269k;
        private String f270l;
        private String f271m;
        private String f272n;
        private Uri f273o;
        private Uri f274p;
        private boolean f275q;
        private boolean f276r;
        private String f277s;
        private boolean f278t;
        private Uri f279u;
        private String f280v;
        private ap f281w;
        private boolean f282x;
        private boolean f283y;
        private boolean f284z;

        public AppLovinAdImpl build() {
            return new AppLovinAdImpl(this.f259a, this.f260b, this.f261c, this.f262d, this.f263e, this.f264f, this.f265g, this.f266h, this.f267i, this.f268j, this.f269k, this.f270l, this.f271m, this.f272n, this.f273o, this.f274p, this.f275q, this.f276r, this.f277s, this.f278t, this.f279u, this.f280v, this.f281w, this.f282x, this.f283y, this.f256A, this.f284z, this.f257B, this.f258C);
        }

        public Builder setAccelerateHardware(boolean z) {
            this.f282x = z;
            return this;
        }

        public Builder setClCode(String str) {
            this.f270l = str;
            return this;
        }

        public Builder setClickDestinationUrl(String str) {
            this.f277s = str;
            return this;
        }

        public Builder setCloseButtonHidden(boolean z) {
            this.f283y = z;
            return this;
        }

        public Builder setCloseButtonStyle(C0142v c0142v) {
            this.f263e = c0142v;
            return this;
        }

        public Builder setCloseDelay(float f) {
            this.f266h = f;
            return this;
        }

        public Builder setCompletionUrl(String str) {
            this.f271m = str;
            return this;
        }

        public Builder setCountdownLength(int i) {
            this.f268j = i;
            return this;
        }

        public Builder setCurrentAdIdNumber(long j) {
            this.f269k = j;
            return this;
        }

        public Builder setDismissOnSkip(boolean z) {
            this.f275q = z;
            return this;
        }

        public Builder setHideCloseButtonOnExit(boolean z) {
            this.f256A = z;
            return this;
        }

        public Builder setHideVideoCloseButtonOnExit(boolean z) {
            this.f284z = z;
            return this;
        }

        public Builder setHtml(String str) {
            this.f259a = str;
            return this;
        }

        public Builder setLockCurrentOrientation(boolean z) {
            this.f258C = z;
            return this;
        }

        public Builder setMraidCloseDelay(float f) {
            this.f267i = f;
            return this;
        }

        public Builder setMuteImageUri(Uri uri) {
            this.f273o = uri;
            return this;
        }

        public Builder setPresentationMode(AdPresentationMode adPresentationMode) {
            this.f257B = adPresentationMode;
            return this;
        }

        public Builder setSize(AppLovinAdSize appLovinAdSize) {
            this.f260b = appLovinAdSize;
            return this;
        }

        public Builder setSkipButtonStyle(C0142v c0142v) {
            this.f264f = c0142v;
            return this;
        }

        public Builder setSupplementalClickTrackingUrl(String str) {
            this.f272n = str;
            return this;
        }

        public Builder setTarget(AdTarget adTarget) {
            this.f262d = adTarget;
            return this;
        }

        public Builder setType(AppLovinAdType appLovinAdType) {
            this.f261c = appLovinAdType;
            return this;
        }

        public Builder setUnmuteImageUri(Uri uri) {
            this.f274p = uri;
            return this;
        }

        public Builder setVideoButtonHtmlSource(String str) {
            this.f280v = str;
            return this;
        }

        public Builder setVideoButtonProperties(ap apVar) {
            this.f281w = apVar;
            return this;
        }

        public Builder setVideoClickableDuringPlayback(boolean z) {
            this.f276r = z;
            return this;
        }

        public Builder setVideoCloseDelay(float f) {
            this.f265g = f;
            return this;
        }

        public Builder setVideoStream(boolean z) {
            this.f278t = z;
            return this;
        }

        public Builder setVideoUri(Uri uri) {
            this.f279u = uri;
            return this;
        }
    }

    private AppLovinAdImpl(String str, AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AdTarget adTarget, C0142v c0142v, C0142v c0142v2, float f, float f2, float f3, int i, long j, String str2, String str3, String str4, Uri uri, Uri uri2, boolean z, boolean z2, String str5, boolean z3, Uri uri3, String str6, ap apVar, boolean z4, boolean z5, boolean z6, boolean z7, AdPresentationMode adPresentationMode, boolean z8) {
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No size specified");
        } else if (appLovinAdType == null) {
            throw new IllegalArgumentException("No type specified");
        } else {
            this.f288a = appLovinAdSize;
            this.f289b = appLovinAdType;
            this.f290c = j;
            this.f312y = str;
            this.f291d = adTarget;
            this.f295h = f;
            this.f298k = i;
            this.f294g = str2;
            this.f292e = c0142v;
            this.f293f = c0142v2;
            this.f296i = f2;
            this.f297j = f3;
            this.f299l = str3;
            this.f300m = str4;
            this.f313z = uri;
            this.f285A = uri2;
            this.f301n = z;
            this.f302o = z2;
            this.f303p = str5;
            this.f286B = z3;
            this.f287C = uri3;
            this.f304q = str6;
            this.f305r = apVar;
            this.f306s = z4;
            this.f307t = z5;
            this.f308u = z6;
            this.f309v = z7;
            this.f310w = adPresentationMode;
            this.f311x = z8;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) obj;
        if (this.f290c != appLovinAdImpl.f290c || Float.compare(appLovinAdImpl.f295h, this.f295h) != 0 || Float.compare(appLovinAdImpl.f296i, this.f296i) != 0 || Float.compare(appLovinAdImpl.f297j, this.f297j) != 0 || this.f298k != appLovinAdImpl.f298k || this.f301n != appLovinAdImpl.f301n || this.f302o != appLovinAdImpl.f302o || this.f306s != appLovinAdImpl.f306s || this.f307t != appLovinAdImpl.f307t || this.f308u != appLovinAdImpl.f308u || this.f309v != appLovinAdImpl.f309v || this.f311x != appLovinAdImpl.f311x || this.f286B != appLovinAdImpl.f286B) {
            return false;
        }
        if (this.f288a != null) {
            if (!this.f288a.equals(appLovinAdImpl.f288a)) {
                return false;
            }
        } else if (appLovinAdImpl.f288a != null) {
            return false;
        }
        if (this.f289b != null) {
            if (!this.f289b.equals(appLovinAdImpl.f289b)) {
                return false;
            }
        } else if (appLovinAdImpl.f289b != null) {
            return false;
        }
        if (this.f291d != appLovinAdImpl.f291d || this.f292e != appLovinAdImpl.f292e || this.f293f != appLovinAdImpl.f293f) {
            return false;
        }
        if (this.f294g != null) {
            if (!this.f294g.equals(appLovinAdImpl.f294g)) {
                return false;
            }
        } else if (appLovinAdImpl.f294g != null) {
            return false;
        }
        if (this.f299l != null) {
            if (!this.f299l.equals(appLovinAdImpl.f299l)) {
                return false;
            }
        } else if (appLovinAdImpl.f299l != null) {
            return false;
        }
        if (this.f300m != null) {
            if (!this.f300m.equals(appLovinAdImpl.f300m)) {
                return false;
            }
        } else if (appLovinAdImpl.f300m != null) {
            return false;
        }
        if (this.f303p != null) {
            if (!this.f303p.equals(appLovinAdImpl.f303p)) {
                return false;
            }
        } else if (appLovinAdImpl.f303p != null) {
            return false;
        }
        if (this.f304q != null) {
            if (!this.f304q.equals(appLovinAdImpl.f304q)) {
                return false;
            }
        } else if (appLovinAdImpl.f304q != null) {
            return false;
        }
        if (this.f305r != null) {
            if (!this.f305r.equals(appLovinAdImpl.f305r)) {
                return false;
            }
        } else if (appLovinAdImpl.f305r != null) {
            return false;
        }
        if (this.f310w != appLovinAdImpl.f310w) {
            return false;
        }
        if (this.f312y != null) {
            if (!this.f312y.equals(appLovinAdImpl.f312y)) {
                return false;
            }
        } else if (appLovinAdImpl.f312y != null) {
            return false;
        }
        if (this.f313z != null) {
            if (!this.f313z.equals(appLovinAdImpl.f313z)) {
                return false;
            }
        } else if (appLovinAdImpl.f313z != null) {
            return false;
        }
        if (this.f285A != null) {
            if (!this.f285A.equals(appLovinAdImpl.f285A)) {
                return false;
            }
        } else if (appLovinAdImpl.f285A != null) {
            return false;
        }
        if (this.f287C != null) {
            z = this.f287C.equals(appLovinAdImpl.f287C);
        } else if (appLovinAdImpl.f287C != null) {
            z = false;
        }
        return z;
    }

    public long getAdIdNumber() {
        return this.f290c;
    }

    public String getClCode() {
        return this.f294g;
    }

    public String getClickDestinationUrl() {
        return this.f303p;
    }

    public C0142v getCloseButtonStyle() {
        return this.f292e;
    }

    public float getCloseDelay() {
        return this.f296i;
    }

    public String getCompletionUrl() {
        return this.f299l;
    }

    public int getCountdownLength() {
        return this.f298k;
    }

    public boolean getDismissOnSkip() {
        return this.f301n;
    }

    public String getHtmlSource() {
        return this.f312y;
    }

    public float getMraidCloseDelay() {
        return this.f297j;
    }

    public Uri getMuteImageUri() {
        return this.f313z;
    }

    public String getParametrizedCompletionUrl(int i, String str, boolean z) {
        String completionUrl = getCompletionUrl();
        return AppLovinSdkUtils.isValidString(completionUrl) ? dp.m699a(str, Uri.parse(completionUrl.replace("{CLCODE}", getClCode())).buildUpon().appendQueryParameter(NativeAdImpl.QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter("vid_ts", Long.toString(System.currentTimeMillis())).appendQueryParameter("uvs", Boolean.toString(z)).build().toString()) : "";
    }

    public AdPresentationMode getPresentationMode() {
        return this.f310w;
    }

    public AppLovinAdSize getSize() {
        return this.f288a;
    }

    public C0142v getSkipButtonStyle() {
        return this.f293f;
    }

    public String getSupplementalClickTrackingUrl() {
        return getSupplementalClickTrackingUrl(null);
    }

    public String getSupplementalClickTrackingUrl(String str) {
        String str2 = this.f300m;
        return AppLovinSdkUtils.isValidString(str2) ? dp.m699a(str, str2.replace("{CLCODE}", getClCode())) : "";
    }

    public AdTarget getTarget() {
        return this.f291d;
    }

    public AppLovinAdType getType() {
        return this.f289b;
    }

    public Uri getUnmuteImageUri() {
        return this.f285A;
    }

    public String getVideoButtonHtmlSource() {
        return this.f304q;
    }

    public ap getVideoButtonProperties() {
        return this.f305r;
    }

    public float getVideoCloseDelay() {
        return this.f295h;
    }

    public Uri getVideoUri() {
        return this.f287C;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        int hashCode = ((this.f285A != null ? this.f285A.hashCode() : 0) + (((this.f313z != null ? this.f313z.hashCode() : 0) + (((this.f312y != null ? this.f312y.hashCode() : 0) + (((this.f311x ? 1 : 0) + (((this.f310w != null ? this.f310w.hashCode() : 0) + (((this.f309v ? 1 : 0) + (((this.f308u ? 1 : 0) + (((this.f307t ? 1 : 0) + (((this.f306s ? 1 : 0) + (((this.f305r != null ? this.f305r.hashCode() : 0) + (((this.f304q != null ? this.f304q.hashCode() : 0) + (((this.f303p != null ? this.f303p.hashCode() : 0) + (((this.f302o ? 1 : 0) + (((this.f301n ? 1 : 0) + (((this.f300m != null ? this.f300m.hashCode() : 0) + (((this.f299l != null ? this.f299l.hashCode() : 0) + (((((this.f297j != 0.0f ? Float.floatToIntBits(this.f297j) : 0) + (((this.f296i != 0.0f ? Float.floatToIntBits(this.f296i) : 0) + (((this.f295h != 0.0f ? Float.floatToIntBits(this.f295h) : 0) + (((this.f294g != null ? this.f294g.hashCode() : 0) + (((this.f293f != null ? this.f293f.hashCode() : 0) + (((this.f292e != null ? this.f292e.hashCode() : 0) + (((this.f291d != null ? this.f291d.hashCode() : 0) + (((((this.f289b != null ? this.f289b.hashCode() : 0) + ((this.f288a != null ? this.f288a.hashCode() : 0) * 31)) * 31) + ((int) (this.f290c ^ (this.f290c >>> 32)))) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + this.f298k) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!this.f286B) {
            i = 0;
        }
        hashCode = (hashCode + i) * 31;
        if (this.f287C != null) {
            i2 = this.f287C.hashCode();
        }
        return hashCode + i2;
    }

    public boolean isAccelerateHardware() {
        return this.f306s;
    }

    public boolean isCloseButtonHidden() {
        return this.f307t;
    }

    public boolean isHideCloseButtonOnExit() {
        return this.f308u;
    }

    public boolean isHideVideoCloseButtonOnExit() {
        return this.f309v;
    }

    public boolean isLockCurrentOrientation() {
        return this.f311x;
    }

    public boolean isVideoAd() {
        return this.f287C != null;
    }

    public boolean isVideoClickableDuringPlayback() {
        return this.f302o;
    }

    public boolean isVideoStream() {
        return this.f286B;
    }

    public void setHtmlSource(String str) {
        this.f312y = str;
    }

    public void setMuteImageUri(Uri uri) {
        this.f313z = uri;
    }

    public void setUnmuteImageUri(Uri uri) {
        this.f285A = uri;
    }

    public void setVideoStream(boolean z) {
        this.f286B = z;
    }

    public void setVideoUri(Uri uri) {
        this.f287C = uri;
    }

    public String toString() {
        return "AppLovinAdImpl{size=" + this.f288a + ", type=" + this.f289b + ", adIdNumber=" + this.f290c + ", target=" + this.f291d + ", closeButtonStyle=" + this.f292e + ", skipButtonStyle=" + this.f293f + ", clCode='" + this.f294g + '\'' + ", videoCloseDelay=" + this.f295h + ", closeDelay=" + this.f296i + ", mraidCloseDelay=" + this.f297j + ", countdownLength=" + this.f298k + ", completionUrl='" + this.f299l + '\'' + ", supplementalClickTrackingUrl='" + this.f300m + '\'' + ", dismissOnSkip=" + this.f301n + ", videoClickableDuringPlayback=" + this.f302o + ", clickDestinationUrl='" + this.f303p + '\'' + ", videoButtonHtmlSource='" + this.f304q + '\'' + ", videoButtonProperties=" + this.f305r + ", accelerateHardware=" + this.f306s + ", closeButtonHidden=" + this.f307t + ", hideCloseButtonOnExit=" + this.f308u + ", hideVideoCloseButtonOnExit=" + this.f309v + ", presentationMode=" + this.f310w + ", lockCurrentOrientation=" + this.f311x + ", htmlSource='" + this.f312y + '\'' + ", muteImageUri=" + this.f313z + ", unmuteImageUri=" + this.f285A + ", videoStream=" + this.f286B + ", videoUri=" + this.f287C + '}';
    }
}
