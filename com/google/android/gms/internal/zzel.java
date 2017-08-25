package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzeg.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzgd
public final class zzel<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzyh;
    private final NETWORK_EXTRAS zzyi;

    public zzel(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzyh = mediationAdapter;
        this.zzyi = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                zzb.zzd("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.zzyh.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void destroy() throws RemoteException {
        try {
            this.zzyh.destroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzd getView() throws RemoteException {
        if (this.zzyh instanceof MediationBannerAdapter) {
            try {
                return zze.zzw(((MediationBannerAdapter) this.zzyh).getBannerView());
            } catch (Throwable th) {
                zzb.zzd("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationBannerAdapter: " + this.zzyh.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public boolean isInitialized() {
        return true;
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzyh instanceof MediationInterstitialAdapter) {
            zzb.zzay("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzyh).showInterstitial();
            } catch (Throwable th) {
                zzb.zzd("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzyh.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void showVideo() {
    }

    public void zza(AdRequestParcel adRequestParcel, String str) {
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza com_google_android_gms_ads_internal_reward_mediation_client_zza, String str2) throws RemoteException {
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, zzeh com_google_android_gms_internal_zzeh) throws RemoteException {
        zza(com_google_android_gms_dynamic_zzd, adRequestParcel, str, null, com_google_android_gms_internal_zzeh);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, String str2, zzeh com_google_android_gms_internal_zzeh) throws RemoteException {
        if (this.zzyh instanceof MediationInterstitialAdapter) {
            zzb.zzay("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzyh).requestInterstitialAd(new zzem(com_google_android_gms_internal_zzeh), (Activity) zze.zzn(com_google_android_gms_dynamic_zzd), zzb(str, adRequestParcel.zzsb, str2), zzen.zzg(adRequestParcel), this.zzyi);
            } catch (Throwable th) {
                zzb.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzyh.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzeh com_google_android_gms_internal_zzeh) throws RemoteException {
        zza(com_google_android_gms_dynamic_zzd, adSizeParcel, adRequestParcel, str, null, com_google_android_gms_internal_zzeh);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzeh com_google_android_gms_internal_zzeh) throws RemoteException {
        if (this.zzyh instanceof MediationBannerAdapter) {
            zzb.zzay("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.zzyh).requestBannerAd(new zzem(com_google_android_gms_internal_zzeh), (Activity) zze.zzn(com_google_android_gms_dynamic_zzd), zzb(str, adRequestParcel.zzsb, str2), zzen.zzb(adSizeParcel), zzen.zzg(adRequestParcel), this.zzyi);
            } catch (Throwable th) {
                zzb.zzd("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaC("MediationAdapter is not a MediationBannerAdapter: " + this.zzyh.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
