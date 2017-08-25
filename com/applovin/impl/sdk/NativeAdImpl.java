package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;

public class NativeAdImpl implements bf, C0146z {
    public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
    public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";
    public static final AppLovinAdSize SIZE_NATIVE = new AppLovinAdSize("NATIVE");
    public static final C0150c SPEC_NATIVE = new C0150c(SIZE_NATIVE, TYPE_NATIVE);
    public static final AppLovinAdType TYPE_NATIVE = new AppLovinAdType("NATIVE");
    private final AppLovinSdkImpl f346a;
    private String f347b;
    private String f348c;
    private String f349d;
    private String f350e;
    private String f351f;
    private String f352g;
    private String f353h;
    private String f354i;
    private String f355j;
    private String f356k;
    private float f357l;
    private String f358m;
    private String f359n;
    private String f360o;
    private String f361p;
    private String f362q;
    private String f363r;
    private long f364s;

    private NativeAdImpl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, float f, String str10, String str11, String str12, String str13, String str14, String str15, String str16, long j, AppLovinSdkImpl appLovinSdkImpl) {
        this.f347b = str;
        this.f348c = str2;
        this.f349d = str3;
        this.f350e = str4;
        this.f351f = str5;
        this.f352g = str6;
        this.f353h = str7;
        this.f355j = str8;
        this.f356k = str9;
        this.f357l = f;
        this.f358m = str10;
        this.f359n = str11;
        this.f360o = str12;
        this.f361p = str13;
        this.f362q = str14;
        this.f363r = str15;
        this.f354i = str16;
        this.f364s = j;
        this.f346a = appLovinSdkImpl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NativeAdImpl nativeAdImpl = (NativeAdImpl) obj;
        if (this.f353h == null ? nativeAdImpl.f353h != null : !this.f353h.equals(nativeAdImpl.f353h)) {
            return false;
        }
        if (this.f363r == null ? nativeAdImpl.f363r != null : !this.f363r.equals(nativeAdImpl.f363r)) {
            return false;
        }
        if (this.f360o == null ? nativeAdImpl.f360o != null : !this.f360o.equals(nativeAdImpl.f360o)) {
            return false;
        }
        if (this.f354i == null ? nativeAdImpl.f354i != null : !this.f354i.equals(nativeAdImpl.f354i)) {
            return false;
        }
        if (this.f352g == null ? nativeAdImpl.f352g != null : !this.f352g.equals(nativeAdImpl.f352g)) {
            return false;
        }
        if (this.f359n == null ? nativeAdImpl.f359n != null : !this.f359n.equals(nativeAdImpl.f359n)) {
            return false;
        }
        if (this.f347b == null ? nativeAdImpl.f347b != null : !this.f347b.equals(nativeAdImpl.f347b)) {
            return false;
        }
        if (this.f348c == null ? nativeAdImpl.f348c != null : !this.f348c.equals(nativeAdImpl.f348c)) {
            return false;
        }
        if (this.f349d == null ? nativeAdImpl.f349d != null : !this.f349d.equals(nativeAdImpl.f349d)) {
            return false;
        }
        if (this.f350e == null ? nativeAdImpl.f350e != null : !this.f350e.equals(nativeAdImpl.f350e)) {
            return false;
        }
        if (this.f351f == null ? nativeAdImpl.f351f != null : !this.f351f.equals(nativeAdImpl.f351f)) {
            return false;
        }
        if (this.f362q == null ? nativeAdImpl.f362q != null : !this.f362q.equals(nativeAdImpl.f362q)) {
            return false;
        }
        if (this.f361p != null) {
            if (this.f361p.equals(nativeAdImpl.f361p)) {
                return true;
            }
        } else if (nativeAdImpl.f361p == null) {
            return true;
        }
        return false;
    }

    public long getAdId() {
        return this.f364s;
    }

    public String getCaptionText() {
        return this.f353h;
    }

    public String getClCode() {
        return this.f363r;
    }

    public String getClickUrl() {
        return this.f360o;
    }

    public String getCtaText() {
        return this.f354i;
    }

    public String getDescriptionText() {
        return this.f352g;
    }

    public String getIconUrl() {
        return this.f355j;
    }

    public String getImageUrl() {
        return this.f356k;
    }

    public String getImpressionTrackingUrl() {
        return this.f359n;
    }

    public String getSourceIconUrl() {
        return this.f347b;
    }

    public String getSourceImageUrl() {
        return this.f348c;
    }

    public String getSourceStarRatingImageUrl() {
        return this.f349d;
    }

    public String getSourceVideoUrl() {
        return this.f350e;
    }

    public float getStarRating() {
        return this.f357l;
    }

    public String getTitle() {
        return this.f351f;
    }

    public String getVideoEndTrackingUrl(int i, boolean z) {
        if (this.f362q == null) {
            return Uri.EMPTY.toString();
        }
        if (i < 0 || i > 100) {
            Log.e("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
        }
        return Uri.parse(this.f362q).buildUpon().appendQueryParameter(QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter(QUERY_PARAM_IS_FIRST_PLAY, Boolean.toString(z)).build().toString();
    }

    public String getVideoStartTrackingUrl() {
        return this.f361p;
    }

    public String getVideoUrl() {
        return this.f358m;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f362q != null ? this.f362q.hashCode() : 0) + (((this.f361p != null ? this.f361p.hashCode() : 0) + (((this.f360o != null ? this.f360o.hashCode() : 0) + (((this.f359n != null ? this.f359n.hashCode() : 0) + (((this.f354i != null ? this.f354i.hashCode() : 0) + (((this.f353h != null ? this.f353h.hashCode() : 0) + (((this.f352g != null ? this.f352g.hashCode() : 0) + (((this.f351f != null ? this.f351f.hashCode() : 0) + (((this.f350e != null ? this.f350e.hashCode() : 0) + (((this.f349d != null ? this.f349d.hashCode() : 0) + (((this.f348c != null ? this.f348c.hashCode() : 0) + ((this.f347b != null ? this.f347b.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f363r != null) {
            i = this.f363r.hashCode();
        }
        return hashCode + i;
    }

    public boolean isImagePrecached() {
        boolean z = (this.f355j == null || this.f355j.equals(this.f347b)) ? false : true;
        boolean z2 = (this.f356k == null || this.f356k.equals(this.f348c)) ? false : true;
        return z && z2;
    }

    public boolean isVideoPrecached() {
        return (this.f358m == null || this.f358m.equals(this.f350e)) ? false : true;
    }

    public void launchClickTarget(Context context) {
        this.f346a.getPersistentPostbackManager().m454a(this.f360o, null);
        AppLovinSdkUtils.openUrl(context, this.f360o, this.f346a);
    }

    public void setIconUrl(String str) {
        this.f355j = str;
    }

    public void setImageUrl(String str) {
        this.f356k = str;
    }

    public void setStarRating(float f) {
        this.f357l = f;
    }

    public void setVideoUrl(String str) {
        this.f358m = str;
    }

    public String toString() {
        return "WidgetSlot{clCode='" + this.f363r + '\'' + ", sourceIconUrl='" + this.f347b + '\'' + ", sourceImageUrl='" + this.f348c + '\'' + ", sourceStarRatingImageUrl='" + this.f349d + '\'' + ", sourceVideoUrl='" + this.f350e + '\'' + ", title='" + this.f351f + '\'' + ", descriptionText='" + this.f352g + '\'' + ", captionText='" + this.f353h + '\'' + ", ctaText='" + this.f354i + '\'' + ", iconUrl='" + this.f355j + '\'' + ", imageUrl='" + this.f356k + '\'' + ", starRating='" + this.f357l + '\'' + ", videoUrl='" + this.f358m + '\'' + ", impressionTrackingUrl='" + this.f359n + '\'' + ", clickUrl='" + this.f360o + '\'' + ", videoStartTrackingUrl='" + this.f361p + '\'' + ", videoEndTrackingUrl='" + this.f362q + '\'' + '}';
    }
}
