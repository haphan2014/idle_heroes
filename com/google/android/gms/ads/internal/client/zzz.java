package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzfk;
import com.google.android.gms.internal.zzfo;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;

public class zzz {
    private final Context mContext;
    private final zzg zznH;
    private String zzoL;
    private zza zzrU;
    private AdListener zzrV;
    private final zzee zzsR;
    private zzr zzsT;
    private String zzsU;
    private InAppPurchaseListener zzsW;
    private PlayStorePurchaseListener zzsX;
    private OnCustomRenderedAdLoadedListener zzsY;
    private PublisherInterstitialAd zzsZ;
    private AppEventListener zzsq;

    public zzz(Context context) {
        this(context, zzg.zzcw(), null);
    }

    public zzz(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzg.zzcw(), publisherInterstitialAd);
    }

    public zzz(Context context, zzg com_google_android_gms_ads_internal_client_zzg, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzsR = new zzee();
        this.mContext = context;
        this.zznH = com_google_android_gms_ads_internal_client_zzg;
        this.zzsZ = publisherInterstitialAd;
    }

    private void zzL(String str) throws RemoteException {
        if (this.zzoL == null) {
            zzM(str);
        }
        this.zzsT = zzk.zzcB().zzb(this.mContext, new AdSizeParcel(), this.zzoL, this.zzsR);
        if (this.zzrV != null) {
            this.zzsT.zza(new zzc(this.zzrV));
        }
        if (this.zzrU != null) {
            this.zzsT.zza(new zzb(this.zzrU));
        }
        if (this.zzsq != null) {
            this.zzsT.zza(new zzi(this.zzsq));
        }
        if (this.zzsW != null) {
            this.zzsT.zza(new zzfk(this.zzsW));
        }
        if (this.zzsX != null) {
            this.zzsT.zza(new zzfo(this.zzsX), this.zzsU);
        }
        if (this.zzsY != null) {
            this.zzsT.zza(new zzcj(this.zzsY));
        }
    }

    private void zzM(String str) {
        if (this.zzsT == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public AdListener getAdListener() {
        return this.zzrV;
    }

    public String getAdUnitId() {
        return this.zzoL;
    }

    public AppEventListener getAppEventListener() {
        return this.zzsq;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzsW;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzsT != null) {
                return this.zzsT.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzsY;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.zzsT != null) {
                z = this.zzsT.isReady();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.zzrV = adListener;
            if (this.zzsT != null) {
                this.zzsT.zza(adListener != null ? new zzc(adListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.zzoL != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzoL = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzsq = appEventListener;
            if (this.zzsT != null) {
                this.zzsT.zza(appEventListener != null ? new zzi(appEventListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zzsX != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zzsW = inAppPurchaseListener;
            if (this.zzsT != null) {
                this.zzsT.zza(inAppPurchaseListener != null ? new zzfk(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzsY = onCustomRenderedAdLoadedListener;
            if (this.zzsT != null) {
                this.zzsT.zza(onCustomRenderedAdLoadedListener != null ? new zzcj(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        if (this.zzsW != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.zzsX = playStorePurchaseListener;
            this.zzsU = publicKey;
            if (this.zzsT != null) {
                this.zzsT.zza(playStorePurchaseListener != null ? new zzfo(playStorePurchaseListener) : null, publicKey);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            zzM(NetworkCallback.SHOW);
            this.zzsT.showInterstitial();
        } catch (Throwable e) {
            zzb.zzd("Failed to show interstitial.", e);
        }
    }

    public void zza(zza com_google_android_gms_ads_internal_client_zza) {
        try {
            this.zzrU = com_google_android_gms_ads_internal_client_zza;
            if (this.zzsT != null) {
                this.zzsT.zza(com_google_android_gms_ads_internal_client_zza != null ? new zzb(com_google_android_gms_ads_internal_client_zza) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzx com_google_android_gms_ads_internal_client_zzx) {
        try {
            if (this.zzsT == null) {
                zzL("loadAd");
            }
            if (this.zzsT.zza(this.zznH.zza(this.mContext, com_google_android_gms_ads_internal_client_zzx))) {
                this.zzsR.zzf(com_google_android_gms_ads_internal_client_zzx.zzcJ());
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }
}
