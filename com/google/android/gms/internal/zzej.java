package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzeg.zza;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzgd
public final class zzej extends zza {
    private final MediationAdapter zzyf;

    public zzej(MediationAdapter mediationAdapter) {
        this.zzyf = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) throws RemoteException {
        zzb.zzaC("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.zzyf instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            zzb.zzd("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.zzyf.onDestroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzd getView() throws RemoteException {
        if (this.zzyf instanceof MediationBannerAdapter) {
            try {
                return zze.zzw(((MediationBannerAdapter) this.zzyf).getBannerView());
            } catch (Throwable th) {
                zzb.zzd("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationBannerAdapter: " + this.zzyf.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public boolean isInitialized() throws RemoteException {
        if (this.zzyf instanceof MediationRewardedVideoAdAdapter) {
            zzb.zzay("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzyf).isInitialized();
            } catch (Throwable th) {
                zzb.zzd("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzyf.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        try {
            this.zzyf.onPause();
        } catch (Throwable th) {
            zzb.zzd("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.zzyf.onResume();
        } catch (Throwable th) {
            zzb.zzd("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzyf instanceof MediationInterstitialAdapter) {
            zzb.zzay("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzyf).showInterstitial();
            } catch (Throwable th) {
                zzb.zzd("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzyf.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void showVideo() throws RemoteException {
        if (this.zzyf instanceof MediationRewardedVideoAdAdapter) {
            zzb.zzay("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzyf).showVideo();
            } catch (Throwable th) {
                zzb.zzd("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzyf.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(AdRequestParcel adRequestParcel, String str) throws RemoteException {
        if (this.zzyf instanceof MediationRewardedVideoAdAdapter) {
            zzb.zzay("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzyf;
                mediationRewardedVideoAdAdapter.loadAd(new zzei(adRequestParcel.zzrX == -1 ? null : new Date(adRequestParcel.zzrX), adRequestParcel.zzrY, adRequestParcel.zzrZ != null ? new HashSet(adRequestParcel.zzrZ) : null, adRequestParcel.zzsf, adRequestParcel.zzsa, adRequestParcel.zzsb), zza(str, adRequestParcel.zzsb, null), adRequestParcel.zzsh != null ? adRequestParcel.zzsh.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzb.zzd("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzyf.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza com_google_android_gms_ads_internal_reward_mediation_client_zza, String str2) throws RemoteException {
        if (this.zzyf instanceof MediationRewardedVideoAdAdapter) {
            zzb.zzay("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzyf;
                mediationRewardedVideoAdAdapter.initialize((Context) zze.zzn(com_google_android_gms_dynamic_zzd), new zzei(adRequestParcel.zzrX == -1 ? null : new Date(adRequestParcel.zzrX), adRequestParcel.zzrY, adRequestParcel.zzrZ != null ? new HashSet(adRequestParcel.zzrZ) : null, adRequestParcel.zzsf, adRequestParcel.zzsa, adRequestParcel.zzsb), str, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(com_google_android_gms_ads_internal_reward_mediation_client_zza), zza(str2, adRequestParcel.zzsb, null), adRequestParcel.zzsh != null ? adRequestParcel.zzsh.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzb.zzd("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzyf.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, zzeh com_google_android_gms_internal_zzeh) throws RemoteException {
        zza(com_google_android_gms_dynamic_zzd, adRequestParcel, str, null, com_google_android_gms_internal_zzeh);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, String str2, zzeh com_google_android_gms_internal_zzeh) throws RemoteException {
        if (this.zzyf instanceof MediationInterstitialAdapter) {
            zzb.zzay("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzyf;
                mediationInterstitialAdapter.requestInterstitialAd((Context) zze.zzn(com_google_android_gms_dynamic_zzd), new zzek(com_google_android_gms_internal_zzeh), zza(str, adRequestParcel.zzsb, str2), new zzei(adRequestParcel.zzrX == -1 ? null : new Date(adRequestParcel.zzrX), adRequestParcel.zzrY, adRequestParcel.zzrZ != null ? new HashSet(adRequestParcel.zzrZ) : null, adRequestParcel.zzsf, adRequestParcel.zzsa, adRequestParcel.zzsb), adRequestParcel.zzsh != null ? adRequestParcel.zzsh.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzb.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzyf.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzeh com_google_android_gms_internal_zzeh) throws RemoteException {
        zza(com_google_android_gms_dynamic_zzd, adSizeParcel, adRequestParcel, str, null, com_google_android_gms_internal_zzeh);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzeh com_google_android_gms_internal_zzeh) throws RemoteException {
        if (this.zzyf instanceof MediationBannerAdapter) {
            zzb.zzay("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzyf;
                mediationBannerAdapter.requestBannerAd((Context) zze.zzn(com_google_android_gms_dynamic_zzd), new zzek(com_google_android_gms_internal_zzeh), zza(str, adRequestParcel.zzsb, str2), com.google.android.gms.ads.zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zzsm), new zzei(adRequestParcel.zzrX == -1 ? null : new Date(adRequestParcel.zzrX), adRequestParcel.zzrY, adRequestParcel.zzrZ != null ? new HashSet(adRequestParcel.zzrZ) : null, adRequestParcel.zzsf, adRequestParcel.zzsa, adRequestParcel.zzsb), adRequestParcel.zzsh != null ? adRequestParcel.zzsh.getBundle(mediationBannerAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzb.zzd("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationBannerAdapter: " + this.zzyf.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
