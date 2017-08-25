package com.google.android.gms.ads.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.facebook.AppEventsConstants;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzaw;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcd;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzde;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhe;
import com.google.android.gms.internal.zzhf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@zzgd
public abstract class zza extends com.google.android.gms.ads.internal.client.zzr.zza implements com.google.android.gms.ads.internal.client.zza, zzk, com.google.android.gms.ads.internal.request.zza.zza, zzaw, zzde, com.google.android.gms.internal.zzft.zza, zzhe {
    private zzce zzoj;
    private zzcd zzok;
    private zzcd zzol;
    protected final zzn zzom;
    protected final zzp zzon;
    protected transient AdRequestParcel zzoo;
    protected final zzay zzop;

    zza(zzp com_google_android_gms_ads_internal_zzp, zzn com_google_android_gms_ads_internal_zzn) {
        this.zzon = com_google_android_gms_ads_internal_zzp;
        if (com_google_android_gms_ads_internal_zzn == null) {
            com_google_android_gms_ads_internal_zzn = new zzn(this);
        }
        this.zzom = com_google_android_gms_ads_internal_zzn;
        zzo.zzbv().zzH(this.zzon.zzpH);
        zzo.zzby().zzb(this.zzon.zzpH, this.zzon.zzpJ);
        this.zzop = zzo.zzby().zzgd();
    }

    private boolean zzaR() {
        zzb.zzaA("Ad leaving application.");
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdLeftApplication();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdLeftApplication().", e);
            return false;
        }
    }

    public void destroy() {
        zzu.zzbY("destroy must be called on the main UI thread.");
        this.zzom.cancel();
        this.zzop.zzh(this.zzon.zzpO);
        this.zzon.destroy();
    }

    public boolean isReady() {
        zzu.zzbY("isLoaded must be called on the main UI thread.");
        return this.zzon.zzpL == null && this.zzon.zzpM == null && this.zzon.zzpO != null;
    }

    public void onAdClicked() {
        if (this.zzon.zzpO == null) {
            zzb.zzaC("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzb.zzay("Pinging click URLs.");
        this.zzon.zzpQ.zzfQ();
        if (this.zzon.zzpO.zzxF != null) {
            zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, zza(this.zzon.zzpO.zzxF, this.zzon.zzpO.zzCC));
        }
        if (this.zzon.zzpR != null) {
            try {
                this.zzon.zzpR.onAdClicked();
            } catch (Throwable e) {
                zzb.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String name, String info) {
        if (this.zzon.zzpT != null) {
            try {
                this.zzon.zzpT.onAppEvent(name, info);
            } catch (Throwable e) {
                zzb.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzu.zzbY("pause must be called on the main UI thread.");
    }

    protected void recordImpression() {
        zzc(this.zzon.zzpO);
    }

    public void resume() {
        zzu.zzbY("resume must be called on the main UI thread.");
    }

    public void stopLoading() {
        zzu.zzbY("stopLoading must be called on the main UI thread.");
        this.zzon.zzf(true);
    }

    Bundle zza(zzbk com_google_android_gms_internal_zzbk) {
        if (com_google_android_gms_internal_zzbk == null) {
            return null;
        }
        String zzci;
        if (com_google_android_gms_internal_zzbk.zzct()) {
            com_google_android_gms_internal_zzbk.wakeup();
        }
        zzbh zzcr = com_google_android_gms_internal_zzbk.zzcr();
        if (zzcr != null) {
            zzci = zzcr.zzci();
            zzb.zzay("In AdManger: loadAd, " + zzcr.toString());
        } else {
            zzci = null;
        }
        if (zzci == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", zzci);
        bundle.putInt("v", 1);
        return bundle;
    }

    String zza(String str, String str2, int i) {
        return (((Boolean) zzbz.zzun.get()).booleanValue() && zzl.zzq(this.zzon.zzpH).zzbl() && !TextUtils.isEmpty(str)) ? Uri.parse(str).buildUpon().appendQueryParameter("ga_cid", str2).appendQueryParameter("ga_hid", String.valueOf(i)).build().toString() : str;
    }

    ArrayList<String> zza(List<String> list, String str) {
        int zzbn = zzl.zzq(this.zzon.zzpH).zzbn();
        ArrayList<String> arrayList = new ArrayList();
        for (String zza : list) {
            arrayList.add(zza(zza, str, zzbn));
        }
        return arrayList;
    }

    public void zza(AdSizeParcel adSizeParcel) {
        zzu.zzbY("setAdSize must be called on the main UI thread.");
        this.zzon.zzpN = adSizeParcel;
        if (this.zzon.zzpO != null && this.zzon.zzqh == 0) {
            this.zzon.zzpO.zzzE.zza(adSizeParcel);
        }
        if (this.zzon.zzpK != null) {
            if (this.zzon.zzpK.getChildCount() > 1) {
                this.zzon.zzpK.removeView(this.zzon.zzpK.getNextView());
            }
            this.zzon.zzpK.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzon.zzpK.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzon.zzpK.requestLayout();
        }
    }

    public void zza(zzm com_google_android_gms_ads_internal_client_zzm) {
        zzu.zzbY("setAdListener must be called on the main UI thread.");
        this.zzon.zzpR = com_google_android_gms_ads_internal_client_zzm;
    }

    public void zza(zzn com_google_android_gms_ads_internal_client_zzn) {
        zzu.zzbY("setAdListener must be called on the main UI thread.");
        this.zzon.zzpS = com_google_android_gms_ads_internal_client_zzn;
    }

    public void zza(zzt com_google_android_gms_ads_internal_client_zzt) {
        zzu.zzbY("setAppEventListener must be called on the main UI thread.");
        this.zzon.zzpT = com_google_android_gms_ads_internal_client_zzt;
    }

    public void zza(com.google.android.gms.ads.internal.client.zzu com_google_android_gms_ads_internal_client_zzu) {
        zzu.zzbY("setCorrelationIdProvider must be called on the main UI thread");
        this.zzon.zzpU = com_google_android_gms_ads_internal_client_zzu;
    }

    public void zza(zzaz com_google_android_gms_internal_zzaz, boolean z) {
        if (this.zzon.zzpO != null && this.zzon.zzpO.zzzE != null) {
            Map hashMap = new HashMap();
            hashMap.put("isVisible", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.zzon.zzpO.zzzE.zzc("onAdVisibilityChanged", hashMap);
        }
    }

    public void zza(zzci com_google_android_gms_internal_zzci) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzff com_google_android_gms_internal_zzff) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(zzfj com_google_android_gms_internal_zzfj, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza) {
        this.zzoj.zza(this.zzok, "arf");
        this.zzol = this.zzoj.zzdo();
        this.zzon.zzpL = null;
        this.zzon.zzpP = com_google_android_gms_internal_zzha_zza;
        if (zzb(com_google_android_gms_internal_zzha_zza)) {
            zzb.zzay("AdRenderer: " + this.zzon.zzpM.getClass().getName());
        }
    }

    public void zza(HashSet<zzhb> hashSet) {
        this.zzon.zza(hashSet);
    }

    public boolean zza(AdRequestParcel adRequestParcel) {
        zzu.zzbY("loadAd must be called on the main UI thread.");
        if (this.zzon.zzpL == null && this.zzon.zzpM == null) {
            zzb.zzaA("Starting ad request.");
            zzaL();
            this.zzok = this.zzoj.zzdo();
            if (!adRequestParcel.zzsa) {
                zzb.zzaA("Use AdRequest.Builder.addTestDevice(\"" + com.google.android.gms.ads.internal.client.zzk.zzcA().zzO(this.zzon.zzpH) + "\") to get test ads on this device.");
            }
            return zzb(adRequestParcel);
        }
        if (this.zzoo != null) {
            zzb.zzaC("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        }
        this.zzoo = adRequestParcel;
        return false;
    }

    boolean zza(zzha com_google_android_gms_internal_zzha) {
        return false;
    }

    protected abstract boolean zza(zzha com_google_android_gms_internal_zzha, zzha com_google_android_gms_internal_zzha2);

    void zzaL() {
        this.zzoj = new zzce("load_ad");
        this.zzok = new zzcd(-1, null, null);
        this.zzol = new zzcd(-1, null, null);
    }

    public zzd zzaM() {
        zzu.zzbY("getAdFrame must be called on the main UI thread.");
        return zze.zzw(this.zzon.zzpK);
    }

    public AdSizeParcel zzaN() {
        zzu.zzbY("getAdSize must be called on the main UI thread.");
        return this.zzon.zzpN;
    }

    public void zzaO() {
        zzaR();
    }

    public void zzaP() {
        zzu.zzbY("recordManualImpression must be called on the main UI thread.");
        if (this.zzon.zzpO == null) {
            zzb.zzaC("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzb.zzay("Pinging manual tracking URLs.");
        if (this.zzon.zzpO.zzCM != null) {
            zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, this.zzon.zzpO.zzCM);
        }
    }

    protected boolean zzaQ() {
        zzb.zzaB("Ad closing.");
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdClosed();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdClosed().", e);
            return false;
        }
    }

    protected boolean zzaS() {
        zzb.zzaA("Ad opening.");
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdOpened();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdOpened().", e);
            return false;
        }
    }

    protected boolean zzaT() {
        zzb.zzaA("Ad finished loading.");
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdLoaded();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdLoaded().", e);
            return false;
        }
    }

    protected void zzb(View view) {
        this.zzon.zzpK.addView(view, zzo.zzbx().zzgt());
    }

    public void zzb(zzha com_google_android_gms_internal_zzha) {
        this.zzoj.zza(this.zzol, "awr");
        this.zzoj.zza(this.zzok, "ttc");
        this.zzon.zzpM = null;
        if (!(com_google_android_gms_internal_zzha.errorCode == -2 || com_google_android_gms_internal_zzha.errorCode == 3)) {
            zzo.zzby().zzb(this.zzon.zzbI());
        }
        if (com_google_android_gms_internal_zzha.errorCode != -1) {
            if (zza(com_google_android_gms_internal_zzha)) {
                zzb.zzay("Ad refresh scheduled.");
            }
            if (com_google_android_gms_internal_zzha.errorCode != -2) {
                zze(com_google_android_gms_internal_zzha.errorCode);
                return;
            }
            if (this.zzon.zzqf == null) {
                this.zzon.zzqf = new zzhf(this.zzon.zzpG);
            }
            this.zzop.zzg(this.zzon.zzpO);
            if (zza(this.zzon.zzpO, com_google_android_gms_internal_zzha)) {
                this.zzon.zzpO = com_google_android_gms_internal_zzha;
                this.zzon.zzbO();
                if (zzo.zzby().zzfY() != null) {
                    zzo.zzby().zzfY().zza(this.zzoj);
                }
                if (this.zzon.zzbM()) {
                    zzaT();
                }
            }
        }
    }

    protected abstract boolean zzb(AdRequestParcel adRequestParcel);

    protected abstract boolean zzb(com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza);

    protected void zzc(zzha com_google_android_gms_internal_zzha) {
        if (com_google_android_gms_internal_zzha == null) {
            zzb.zzaC("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzb.zzay("Pinging Impression URLs.");
        this.zzon.zzpQ.zzfP();
        if (com_google_android_gms_internal_zzha.zzxG != null) {
            zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, zza(com_google_android_gms_internal_zzha.zzxG, com_google_android_gms_internal_zzha.zzCC));
        }
    }

    protected boolean zzc(AdRequestParcel adRequestParcel) {
        ViewParent parent = this.zzon.zzpK.getParent();
        return (parent instanceof View) && ((View) parent).isShown() && zzo.zzbv().zzgl();
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (zzc(adRequestParcel)) {
            zza(adRequestParcel);
            return;
        }
        zzb.zzaA("Ad is not visible. Not refreshing ad.");
        this.zzom.zzf(adRequestParcel);
    }

    protected boolean zze(int i) {
        zzb.zzaC("Failed to load ad: " + i);
        if (this.zzon.zzpS == null) {
            return false;
        }
        try {
            this.zzon.zzpS.onAdFailedToLoad(i);
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            return false;
        }
    }
}
