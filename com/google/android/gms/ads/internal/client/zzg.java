package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzgd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@zzgd
public class zzg {
    public static final zzg zzsl = new zzg();

    protected zzg() {
    }

    public static zzg zzcw() {
        return zzsl;
    }

    public AdRequestParcel zza(Context context, zzx com_google_android_gms_ads_internal_client_zzx) {
        Date birthday = com_google_android_gms_ads_internal_client_zzx.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = com_google_android_gms_ads_internal_client_zzx.getContentUrl();
        int gender = com_google_android_gms_ads_internal_client_zzx.getGender();
        Collection keywords = com_google_android_gms_ads_internal_client_zzx.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = com_google_android_gms_ads_internal_client_zzx.isTestDevice(context);
        int zzcL = com_google_android_gms_ads_internal_client_zzx.zzcL();
        Location location = com_google_android_gms_ads_internal_client_zzx.getLocation();
        Bundle networkExtrasBundle = com_google_android_gms_ads_internal_client_zzx.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = com_google_android_gms_ads_internal_client_zzx.getManualImpressionsEnabled();
        String publisherProvidedId = com_google_android_gms_ads_internal_client_zzx.getPublisherProvidedId();
        SearchAdRequest zzcI = com_google_android_gms_ads_internal_client_zzx.zzcI();
        return new AdRequestParcel(5, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzcL, manualImpressionsEnabled, publisherProvidedId, zzcI != null ? new SearchAdRequestParcel(zzcI) : null, location, contentUrl, com_google_android_gms_ads_internal_client_zzx.zzcK(), com_google_android_gms_ads_internal_client_zzx.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(com_google_android_gms_ads_internal_client_zzx.zzcM())), com_google_android_gms_ads_internal_client_zzx.zzcH());
    }

    public RewardedVideoAdRequestParcel zza(Context context, zzx com_google_android_gms_ads_internal_client_zzx, String str) {
        return new RewardedVideoAdRequestParcel(zza(context, com_google_android_gms_ads_internal_client_zzx), str);
    }
}
