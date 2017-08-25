package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.heyzap.http.AsyncHttpResponseHandler;

@zzgd
public class zzfq implements Runnable {
    private final Handler zzBf;
    private final long zzBg;
    private long zzBh;
    private com.google.android.gms.internal.zzie.zza zzBi;
    protected boolean zzBj;
    protected boolean zzBk;
    private final int zznM;
    private final int zznN;
    protected final zzid zzoA;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzBl;
        private Bitmap zzBm;
        final /* synthetic */ zzfq zzBn;

        public zza(zzfq com_google_android_gms_internal_zzfq, WebView webView) {
            this.zzBn = com_google_android_gms_internal_zzfq;
            this.zzBl = webView;
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return zza((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            zza((Boolean) x0);
        }

        protected synchronized void onPreExecute() {
            this.zzBm = Bitmap.createBitmap(this.zzBn.zznM, this.zzBn.zznN, Config.ARGB_8888);
            this.zzBl.setVisibility(0);
            this.zzBl.measure(MeasureSpec.makeMeasureSpec(this.zzBn.zznM, 0), MeasureSpec.makeMeasureSpec(this.zzBn.zznN, 0));
            this.zzBl.layout(0, 0, this.zzBn.zznM, this.zzBn.zznN);
            this.zzBl.draw(new Canvas(this.zzBm));
            this.zzBl.invalidate();
        }

        protected synchronized Boolean zza(Void... voidArr) {
            Boolean valueOf;
            int width = this.zzBm.getWidth();
            int height = this.zzBm.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.zzBm.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void zza(Boolean bool) {
            zzfq.zzc(this.zzBn);
            if (bool.booleanValue() || this.zzBn.zzfl() || this.zzBn.zzBh <= 0) {
                this.zzBn.zzBk = bool.booleanValue();
                this.zzBn.zzBi.zza(this.zzBn.zzoA, true);
            } else if (this.zzBn.zzBh > 0) {
                if (zzb.zzL(2)) {
                    zzb.zzay("Ad not detected, scheduling another run.");
                }
                this.zzBn.zzBf.postDelayed(this.zzBn, this.zzBn.zzBg);
            }
        }
    }

    public zzfq(com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza, zzid com_google_android_gms_internal_zzid, int i, int i2) {
        this(com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzid, i, i2, 200, 50);
    }

    public zzfq(com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza, zzid com_google_android_gms_internal_zzid, int i, int i2, long j, long j2) {
        this.zzBg = j;
        this.zzBh = j2;
        this.zzBf = new Handler(Looper.getMainLooper());
        this.zzoA = com_google_android_gms_internal_zzid;
        this.zzBi = com_google_android_gms_internal_zzie_zza;
        this.zzBj = false;
        this.zzBk = false;
        this.zznN = i2;
        this.zznM = i;
    }

    static /* synthetic */ long zzc(zzfq com_google_android_gms_internal_zzfq) {
        long j = com_google_android_gms_internal_zzfq.zzBh - 1;
        com_google_android_gms_internal_zzfq.zzBh = j;
        return j;
    }

    public void run() {
        if (this.zzoA == null || zzfl()) {
            this.zzBi.zza(this.zzoA, true);
        } else {
            new zza(this, this.zzoA.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzil(this, this.zzoA, adResponseParcel.zzCR));
    }

    public void zza(AdResponseParcel adResponseParcel, zzil com_google_android_gms_internal_zzil) {
        this.zzoA.setWebViewClient(com_google_android_gms_internal_zzil);
        this.zzoA.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.zzzG) ? null : zzo.zzbv().zzat(adResponseParcel.zzzG), adResponseParcel.zzCI, "text/html", AsyncHttpResponseHandler.DEFAULT_CHARSET, null);
    }

    public void zzfj() {
        this.zzBf.postDelayed(this, this.zzBg);
    }

    public synchronized void zzfk() {
        this.zzBj = true;
    }

    public synchronized boolean zzfl() {
        return this.zzBj;
    }

    public boolean zzfm() {
        return this.zzBk;
    }
}
