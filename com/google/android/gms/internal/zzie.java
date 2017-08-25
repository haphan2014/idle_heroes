package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.support.v4.media.TransportMediator;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.widget.FacebookDialog;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.location.places.Place;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzgd
public class zzie extends WebViewClient {
    private zza zzBi;
    private final HashMap<String, List<zzdg>> zzHb;
    private zzf zzHc;
    private boolean zzHd;
    private zzk zzHe;
    private final zzet zzHf;
    private boolean zzHg;
    private boolean zzHh;
    private boolean zzHi;
    private boolean zzHj;
    private int zzHk;
    protected final zzid zzoA;
    private boolean zzqs;
    private final Object zzqt;
    private com.google.android.gms.ads.internal.client.zza zzrU;
    private zzde zzvU;
    private zzdk zzwu;
    private zzd zzww;
    private zzep zzwx;
    private zzdi zzwz;
    private zzev zzyE;

    public interface zza {
        void zza(zzid com_google_android_gms_internal_zzid, boolean z);
    }

    private static class zzb implements zzf {
        private zzf zzHc;
        private zzid zzHn;

        public zzb(zzid com_google_android_gms_internal_zzid, zzf com_google_android_gms_ads_internal_overlay_zzf) {
            this.zzHn = com_google_android_gms_internal_zzid;
            this.zzHc = com_google_android_gms_ads_internal_overlay_zzf;
        }

        public void zzaV() {
            this.zzHc.zzaV();
            this.zzHn.zzgA();
        }

        public void zzaW() {
            this.zzHc.zzaW();
            this.zzHn.zzew();
        }
    }

    private class zzc implements zzdg {
        final /* synthetic */ zzie zzHm;

        private zzc(zzie com_google_android_gms_internal_zzie) {
            this.zzHm = com_google_android_gms_internal_zzie;
        }

        public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                this.zzHm.zzgO();
            } else if (map.keySet().contains("stop")) {
                this.zzHm.zzgP();
            } else if (map.keySet().contains(FacebookDialog.COMPLETION_GESTURE_CANCEL)) {
                this.zzHm.zzgQ();
            }
        }
    }

    public zzie(zzid com_google_android_gms_internal_zzid, boolean z) {
        this(com_google_android_gms_internal_zzid, z, new zzet(com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzid.zzgC(), new zzbq(com_google_android_gms_internal_zzid.getContext())), null);
    }

    zzie(zzid com_google_android_gms_internal_zzid, boolean z, zzet com_google_android_gms_internal_zzet, zzep com_google_android_gms_internal_zzep) {
        this.zzHb = new HashMap();
        this.zzqt = new Object();
        this.zzHd = false;
        this.zzoA = com_google_android_gms_internal_zzid;
        this.zzqs = z;
        this.zzHf = com_google_android_gms_internal_zzet;
        this.zzwx = com_google_android_gms_internal_zzep;
    }

    private static boolean zzf(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void zzgO() {
        this.zzHk++;
        zzgR();
    }

    private void zzgP() {
        this.zzHk--;
        zzgR();
    }

    private void zzgQ() {
        this.zzHj = true;
        zzgR();
    }

    public final void onLoadResource(WebView webView, String url) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzg(parse);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r3, java.lang.String r4) {
        /*
        r2 = this;
        r1 = r2.zzqt;
        monitor-enter(r1);
        r0 = r2.zzHh;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x001b;
    L_0x0007:
        r0 = "about:blank";
        r0 = r0.equals(r4);	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x001b;
    L_0x000f:
        r0 = "Blank page loaded, 1...";
        com.google.android.gms.ads.internal.util.client.zzb.zzaB(r0);	 Catch:{ all -> 0x0023 }
        r0 = r2.zzoA;	 Catch:{ all -> 0x0023 }
        r0.zzgK();	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x001a:
        return;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0 = 1;
        r2.zzHi = r0;
        r2.zzgR();
        goto L_0x001a;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzie.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void reset() {
        synchronized (this.zzqt) {
            this.zzHb.clear();
            this.zzrU = null;
            this.zzHc = null;
            this.zzBi = null;
            this.zzvU = null;
            this.zzHd = false;
            this.zzqs = false;
            this.zzwz = null;
            this.zzHe = null;
            if (this.zzwx != null) {
                this.zzwx.zzn(true);
                this.zzwx = null;
            }
            this.zzHg = false;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        switch (event.getKeyCode()) {
            case Place.TYPE_RESTAURANT /*79*/:
            case Place.TYPE_SPA /*85*/:
            case Place.TYPE_STADIUM /*86*/:
            case Place.TYPE_STORAGE /*87*/:
            case Place.TYPE_STORE /*88*/:
            case Place.TYPE_SUBWAY_STATION /*89*/:
            case 90:
            case Place.TYPE_TAXI_STAND /*91*/:
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
            case 128:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzg(parse);
        } else if (this.zzHd && webView == this.zzoA && zzf(parse)) {
            if (!this.zzHg) {
                this.zzHg = true;
                if (this.zzrU != null && ((Boolean) zzbz.zzul.get()).booleanValue()) {
                    this.zzrU.onAdClicked();
                }
            }
            return super.shouldOverrideUrlLoading(webView, url);
        } else if (this.zzoA.willNotDraw()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdWebView unable to handle URL: " + url);
        } else {
            Uri uri;
            try {
                zzan zzgH = this.zzoA.zzgH();
                if (zzgH != null && zzgH.zzb(parse)) {
                    parse = zzgH.zza(parse, this.zzoA.getContext());
                }
                uri = parse;
            } catch (zzao e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Unable to append parameter to URL: " + url);
                uri = parse;
            }
            if (this.zzww == null || this.zzww.zzbd()) {
                zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzww.zzo(url);
            }
        }
        return true;
    }

    public void zzD(boolean z) {
        this.zzHd = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzHf.zze(i, i2);
        if (this.zzwx != null) {
            this.zzwx.zza(i, i2, z);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        zzf com_google_android_gms_ads_internal_overlay_zzf = null;
        boolean zzgJ = this.zzoA.zzgJ();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        if (!zzgJ) {
            com_google_android_gms_ads_internal_overlay_zzf = this.zzHc;
        }
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzf, this.zzHe, this.zzoA.zzgI()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzee = this.zzwx != null ? this.zzwx.zzee() : false;
        com.google.android.gms.ads.internal.overlay.zzd zzbt = zzo.zzbt();
        Context context = this.zzoA.getContext();
        if (!zzee) {
            z = true;
        }
        zzbt.zza(context, adOverlayInfoParcel, z);
    }

    public void zza(zza com_google_android_gms_internal_zzie_zza) {
        this.zzBi = com_google_android_gms_internal_zzie_zza;
    }

    public final void zza(String str, zzdg com_google_android_gms_internal_zzdg) {
        synchronized (this.zzqt) {
            List list = (List) this.zzHb.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzHb.put(str, list);
            }
            list.add(com_google_android_gms_internal_zzdg);
        }
    }

    public final void zza(boolean z, int i) {
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!this.zzoA.zzgJ() || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, this.zzHc, this.zzHe, this.zzoA, z, i, this.zzoA.zzgI()));
    }

    public final void zza(boolean z, int i, String str) {
        zzf com_google_android_gms_ads_internal_overlay_zzf = null;
        boolean zzgJ = this.zzoA.zzgJ();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        if (!zzgJ) {
            com_google_android_gms_ads_internal_overlay_zzf = new zzb(this.zzoA, this.zzHc);
        }
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzf, this.zzvU, this.zzHe, this.zzoA, z, i, str, this.zzoA.zzgI(), this.zzwz));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzgJ = this.zzoA.zzgJ();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzgJ || this.zzoA.zzaN().zzsn) ? this.zzrU : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, zzgJ ? null : new zzb(this.zzoA, this.zzHc), this.zzvU, this.zzHe, this.zzoA, z, i, str, str2, this.zzoA.zzgI(), this.zzwz));
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza, zzf com_google_android_gms_ads_internal_overlay_zzf, zzde com_google_android_gms_internal_zzde, zzk com_google_android_gms_ads_internal_overlay_zzk, boolean z, zzdi com_google_android_gms_internal_zzdi, zzdk com_google_android_gms_internal_zzdk, zzd com_google_android_gms_ads_internal_zzd, zzev com_google_android_gms_internal_zzev) {
        if (com_google_android_gms_ads_internal_zzd == null) {
            com_google_android_gms_ads_internal_zzd = new zzd(false);
        }
        this.zzwx = new zzep(this.zzoA, com_google_android_gms_internal_zzev);
        zza("/appEvent", new zzdd(com_google_android_gms_internal_zzde));
        zza("/canOpenURLs", zzdf.zzvW);
        zza("/canOpenIntents", zzdf.zzvX);
        zza("/click", zzdf.zzvY);
        zza("/close", zzdf.zzvZ);
        zza("/customClose", zzdf.zzwa);
        zza("/delayPageLoaded", new zzc());
        zza("/httpTrack", zzdf.zzwb);
        zza("/log", zzdf.zzwc);
        zza("/mraid", new zzdm(com_google_android_gms_ads_internal_zzd, this.zzwx));
        zza("/open", new zzdn(com_google_android_gms_internal_zzdi, com_google_android_gms_ads_internal_zzd, this.zzwx));
        zza("/precache", zzdf.zzwf);
        zza("/touch", zzdf.zzwd);
        zza("/video", zzdf.zzwe);
        if (com_google_android_gms_internal_zzdk != null) {
            zza("/setInterstitialProperties", new zzdj(com_google_android_gms_internal_zzdk));
        }
        this.zzrU = com_google_android_gms_ads_internal_client_zza;
        this.zzHc = com_google_android_gms_ads_internal_overlay_zzf;
        this.zzvU = com_google_android_gms_internal_zzde;
        this.zzwz = com_google_android_gms_internal_zzdi;
        this.zzHe = com_google_android_gms_ads_internal_overlay_zzk;
        this.zzww = com_google_android_gms_ads_internal_zzd;
        this.zzyE = com_google_android_gms_internal_zzev;
        this.zzwu = com_google_android_gms_internal_zzdk;
        zzD(z);
        this.zzHg = false;
    }

    public final void zzb(String str, zzdg com_google_android_gms_internal_zzdg) {
        synchronized (this.zzqt) {
            List list = (List) this.zzHb.get(str);
            if (list == null) {
                return;
            }
            list.remove(com_google_android_gms_internal_zzdg);
        }
    }

    public boolean zzbU() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzqs;
        }
        return z;
    }

    public void zzd(int i, int i2) {
        if (this.zzwx != null) {
            this.zzwx.zzd(i, i2);
        }
    }

    public final void zzet() {
        synchronized (this.zzqt) {
            this.zzHd = false;
            this.zzqs = true;
            this.zzoA.zzgL();
            final com.google.android.gms.ads.internal.overlay.zzc zzgD = this.zzoA.zzgD();
            if (zzgD != null) {
                if (com.google.android.gms.ads.internal.client.zzk.zzcA().zzgw()) {
                    zzgD.zzet();
                } else {
                    zzhl.zzGk.post(new Runnable(this) {
                        final /* synthetic */ zzie zzHm;

                        public void run() {
                            zzgD.zzet();
                        }
                    });
                }
            }
        }
    }

    public void zzg(Uri uri) {
        String path = uri.getPath();
        List<zzdg> list = (List) this.zzHb.get(path);
        if (list != null) {
            Map zzd = zzo.zzbv().zzd(uri);
            if (com.google.android.gms.ads.internal.util.client.zzb.zzL(2)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Received GMSG: " + path);
                for (String path2 : zzd.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("  " + path2 + ": " + ((String) zzd.get(path2)));
                }
            }
            for (zzdg zza : list) {
                zza.zza(this.zzoA, zzd);
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaB("No GMSG handler found for GMSG: " + uri);
    }

    public zzd zzgM() {
        return this.zzww;
    }

    public void zzgN() {
        synchronized (this.zzqt) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Loading blank page in WebView, 2...");
            this.zzHh = true;
            this.zzoA.zzaD("about:blank");
        }
    }

    public final void zzgR() {
        if (this.zzBi == null) {
            return;
        }
        if ((this.zzHi && this.zzHk <= 0) || this.zzHj) {
            this.zzBi.zza(this.zzoA, !this.zzHj);
            this.zzBi = null;
        }
    }

    public void zzgS() {
        if (zzbU()) {
            this.zzHf.zzek();
        }
    }
}
