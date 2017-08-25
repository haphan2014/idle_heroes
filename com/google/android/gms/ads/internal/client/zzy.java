package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzfk;
import com.google.android.gms.internal.zzfo;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzy {
    private final zzg zznH;
    private String zzoL;
    private zza zzrU;
    private AdListener zzrV;
    private final zzee zzsR;
    private final AtomicBoolean zzsS;
    private zzr zzsT;
    private String zzsU;
    private ViewGroup zzsV;
    private InAppPurchaseListener zzsW;
    private PlayStorePurchaseListener zzsX;
    private OnCustomRenderedAdLoadedListener zzsY;
    private AppEventListener zzsq;
    private AdSize[] zzsr;

    public zzy(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzg.zzcw());
    }

    public zzy(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzg.zzcw());
    }

    zzy(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzg com_google_android_gms_ads_internal_client_zzg) {
        this(viewGroup, attributeSet, z, com_google_android_gms_ads_internal_client_zzg, null);
    }

    zzy(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzg com_google_android_gms_ads_internal_client_zzg, zzr com_google_android_gms_ads_internal_client_zzr) {
        this.zzsR = new zzee();
        this.zzsV = viewGroup;
        this.zznH = com_google_android_gms_ads_internal_client_zzg;
        this.zzsT = com_google_android_gms_ads_internal_client_zzr;
        this.zzsS = new AtomicBoolean(false);
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzj com_google_android_gms_ads_internal_client_zzj = new zzj(context, attributeSet);
                this.zzsr = com_google_android_gms_ads_internal_client_zzj.zzi(z);
                this.zzoL = com_google_android_gms_ads_internal_client_zzj.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzk.zzcA().zza(viewGroup, new AdSizeParcel(context, this.zzsr[0]), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzk.zzcA().zza(viewGroup, new AdSizeParcel(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private void zzcN() {
        try {
            zzd zzaM = this.zzsT.zzaM();
            if (zzaM != null) {
                this.zzsV.addView((View) zze.zzn(zzaM));
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to get an ad frame.", e);
        }
    }

    private void zzcO() throws RemoteException {
        if ((this.zzsr == null || this.zzoL == null) && this.zzsT == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.zzsV.getContext();
        this.zzsT = zzk.zzcB().zza(context, new AdSizeParcel(context, this.zzsr), this.zzoL, this.zzsR);
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
        this.zzsT.zza(zzk.zzcC());
        zzcN();
    }

    public void destroy() {
        try {
            if (this.zzsT != null) {
                this.zzsT.destroy();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zzrV;
    }

    public AdSize getAdSize() {
        try {
            if (this.zzsT != null) {
                AdSizeParcel zzaN = this.zzsT.zzaN();
                if (zzaN != null) {
                    return zzaN.zzcy();
                }
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to get the current AdSize.", e);
        }
        return this.zzsr != null ? this.zzsr[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.zzsr;
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

    public void pause() {
        try {
            if (this.zzsT != null) {
                this.zzsT.pause();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (!this.zzsS.getAndSet(true)) {
            try {
                if (this.zzsT != null) {
                    this.zzsT.zzaP();
                }
            } catch (Throwable e) {
                zzb.zzd("Failed to record impression.", e);
            }
        }
    }

    public void resume() {
        try {
            if (this.zzsT != null) {
                this.zzsT.resume();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to call resume.", e);
        }
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

    public void setAdSizes(AdSize... adSizes) {
        if (this.zzsr != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        if (this.zzoL != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
        this.zzsY = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzsT != null) {
                this.zzsT.zza(onCustomRenderedAdLoadedListener != null ? new zzcj(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        if (this.zzsW != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
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
                zzcO();
            }
            if (this.zzsT.zza(this.zznH.zza(this.zzsV.getContext(), com_google_android_gms_ads_internal_client_zzx))) {
                this.zzsR.zzf(com_google_android_gms_ads_internal_client_zzx.zzcJ());
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.zzsr = adSizeArr;
        try {
            if (this.zzsT != null) {
                this.zzsT.zza(new AdSizeParcel(this.zzsV.getContext(), this.zzsr));
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the ad size.", e);
        }
        this.zzsV.requestLayout();
    }
}
