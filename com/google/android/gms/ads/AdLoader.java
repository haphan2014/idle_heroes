package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzee;

public class AdLoader {
    private final Context mContext;
    private final zzg zznH;
    private final zzo zznI;

    public static class Builder {
        private final Context mContext;
        private final zzp zznJ;

        Builder(Context context, zzp builder) {
            this.mContext = context;
            this.zznJ = builder;
        }

        public Builder(Context context, String adUnitID) {
            this(context, zzd.zza(context, adUnitID, new zzee()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zznJ.zzbi());
            } catch (Throwable e) {
                zzb.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(OnAppInstallAdLoadedListener listener) {
            try {
                this.zznJ.zza(new zzcz(listener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(OnContentAdLoadedListener listener) {
            try {
                this.zznJ.zza(new zzda(listener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String templateId, OnCustomTemplateAdLoadedListener adLoadedListener, OnCustomClickListener customClickListener) {
            try {
                this.zznJ.zza(templateId, new zzdc(adLoadedListener), customClickListener == null ? null : new zzdb(customClickListener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener listener) {
            try {
                this.zznJ.zzb(new zzc(listener));
            } catch (Throwable e) {
                zzb.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions options) {
            try {
                this.zznJ.zza(new NativeAdOptionsParcel(options));
            } catch (Throwable e) {
                zzb.zzd("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzo adLoader) {
        this(context, adLoader, zzg.zzcw());
    }

    AdLoader(Context context, zzo adLoader, zzg parcelFactory) {
        this.mContext = context;
        this.zznI = adLoader;
        this.zznH = parcelFactory;
    }

    private void zza(zzx com_google_android_gms_ads_internal_client_zzx) {
        try {
            this.zznI.zze(this.zznH.zza(this.mContext, com_google_android_gms_ads_internal_client_zzx));
        } catch (Throwable e) {
            zzb.zzb("Failed to load ad.", e);
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzaF());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzaF());
    }
}
