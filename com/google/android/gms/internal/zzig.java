package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzig extends WebView implements OnGlobalLayoutListener, DownloadListener, zzid {
    private final zzie zzBd;
    private Boolean zzFO;
    private final zza zzHo;
    private zzc zzHp;
    private boolean zzHq;
    private boolean zzHr;
    private boolean zzHs;
    private boolean zzHt;
    private boolean zzHu;
    private int zzHv;
    private zzc zzHw;
    boolean zzHx;
    private final VersionInfoParcel zzoM;
    private final WindowManager zzqF;
    private final Object zzqt = new Object();
    private final zzan zzvA;
    private AdSizeParcel zzxT;
    private int zzyW = -1;
    private int zzyX = -1;
    private int zzyZ = -1;
    private int zzza = -1;

    @zzgd
    public static class zza extends MutableContextWrapper {
        private Activity zzHy;
        private Context zzHz;
        private Context zzqw;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String service) {
            return this.zzHz.getSystemService(service);
        }

        public void setBaseContext(Context base) {
            this.zzqw = base.getApplicationContext();
            this.zzHy = base instanceof Activity ? (Activity) base : null;
            this.zzHz = base;
            super.setBaseContext(this.zzqw);
        }

        public void startActivity(Intent intent) {
            if (this.zzHy == null || zzlk.isAtLeastL()) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                this.zzqw.startActivity(intent);
                return;
            }
            this.zzHy.startActivity(intent);
        }

        public Activity zzgB() {
            return this.zzHy;
        }

        public Context zzgC() {
            return this.zzHz;
        }
    }

    protected zzig(zza com_google_android_gms_internal_zzig_zza, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan com_google_android_gms_internal_zzan, VersionInfoParcel versionInfoParcel) {
        super(com_google_android_gms_internal_zzig_zza);
        this.zzHo = com_google_android_gms_internal_zzig_zza;
        this.zzxT = adSizeParcel;
        this.zzHs = z;
        this.zzHu = false;
        this.zzHv = -1;
        this.zzvA = com_google_android_gms_internal_zzan;
        this.zzoM = versionInfoParcel;
        this.zzqF = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        zzo.zzbv().zza((Context) com_google_android_gms_internal_zzig_zza, versionInfoParcel.zzGG, settings);
        zzo.zzbx().zza(getContext(), settings);
        setDownloadListener(this);
        this.zzBd = zzo.zzbx().zzb((zzid) this, z2);
        setWebViewClient(this.zzBd);
        setWebChromeClient(zzo.zzbx().zzf(this));
        zzgX();
        if (zzlk.zzoW()) {
            addJavascriptInterface(new zzih(this), "googleAdsJsInterface");
        }
    }

    static zzig zzb(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan com_google_android_gms_internal_zzan, VersionInfoParcel versionInfoParcel) {
        return new zzig(new zza(context), adSizeParcel, z, z2, com_google_android_gms_internal_zzan, versionInfoParcel);
    }

    private void zzgU() {
        synchronized (this.zzqt) {
            this.zzFO = zzo.zzby().zzgc();
            if (this.zzFO == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zzb(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    zzb(Boolean.valueOf(false));
                }
            }
        }
    }

    private void zzgV() {
        Activity zzgB = zzgB();
        if (this.zzHu && zzgB != null) {
            zzo.zzbx().zzb(zzgB, (OnGlobalLayoutListener) this);
            this.zzHu = false;
        }
    }

    private void zzgX() {
        synchronized (this.zzqt) {
            if (this.zzHs || this.zzxT.zzsn) {
                if (VERSION.SDK_INT < 14) {
                    zzb.zzay("Disabling hardware acceleration on an overlay.");
                    zzgY();
                } else {
                    zzb.zzay("Enabling hardware acceleration on an overlay.");
                    zzgZ();
                }
            } else if (VERSION.SDK_INT < 18) {
                zzb.zzay("Disabling hardware acceleration on an AdView.");
                zzgY();
            } else {
                zzb.zzay("Enabling hardware acceleration on an AdView.");
                zzgZ();
            }
        }
    }

    private void zzgY() {
        synchronized (this.zzqt) {
            if (!this.zzHt) {
                zzo.zzbx().zzm(this);
            }
            this.zzHt = true;
        }
    }

    private void zzgZ() {
        synchronized (this.zzqt) {
            if (this.zzHt) {
                zzo.zzbx().zzl(this);
            }
            this.zzHt = false;
        }
    }

    public void destroy() {
        synchronized (this.zzqt) {
            zzgV();
            if (this.zzHp != null) {
                this.zzHp.close();
                this.zzHp.onDestroy();
                this.zzHp = null;
            }
            this.zzBd.reset();
            if (this.zzHr) {
                return;
            }
            zzo.zzbH().zza((zzid) this);
            this.zzHr = true;
            zzb.zzaB("Initiating WebView self destruct sequence in 3...");
            this.zzBd.zzgN();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
        r2 = this;
        r1 = r2.zzqt;
        monitor-enter(r1);
        r0 = r2.isDestroyed();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r0 = "The webview is destroyed. Ignoring action.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(r0);	 Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0014;
    L_0x0010:
        r0 = 0;
        r4.onReceiveValue(r0);	 Catch:{ all -> 0x001b }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0015:
        return;
    L_0x0016:
        super.evaluateJavascript(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0015;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzig.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzqt) {
            i = this.zzHv;
        }
        return i;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzHr;
        }
        return z;
    }

    public void loadData(String data, String mimeType, String encoding) {
        synchronized (this.zzqt) {
            if (isDestroyed()) {
                zzb.zzaC("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(data, mimeType, encoding);
            }
        }
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        synchronized (this.zzqt) {
            if (isDestroyed()) {
                zzb.zzaC("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
            }
        }
    }

    public void loadUrl(String uri) {
        synchronized (this.zzqt) {
            if (isDestroyed()) {
                zzb.zzaC("The webview is destroyed. Ignoring action.");
            } else {
                super.loadUrl(uri);
            }
        }
    }

    protected void onAttachedToWindow() {
        synchronized (this.zzqt) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzHx = true;
                if (this.zzBd.zzbU()) {
                    zzgW();
                }
            }
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.zzqt) {
            if (!isDestroyed()) {
                zzgV();
                this.zzHx = false;
            }
            super.onDetachedFromWindow();
        }
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            zzb.zzay("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public void onGlobalLayout() {
        boolean zzgT = zzgT();
        zzc zzgD = zzgD();
        if (zzgD != null && zzgT) {
            zzgD.zzev();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.zzqt;
        monitor-enter(r4);
        r1 = r9.isDestroyed();	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0019;
    L_0x0012:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0028 }
        monitor-exit(r4);	 Catch:{ all -> 0x0028 }
    L_0x0018:
        return;
    L_0x0019:
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x0028 }
        if (r1 != 0) goto L_0x0023;
    L_0x001f:
        r1 = r9.zzHs;	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x002b;
    L_0x0023:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x0028 }
        monitor-exit(r4);	 Catch:{ all -> 0x0028 }
        goto L_0x0018;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x002b:
        r1 = r9.zzxT;	 Catch:{ all -> 0x0028 }
        r1 = r1.zzsn;	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0048;
    L_0x0031:
        r0 = new android.util.DisplayMetrics;	 Catch:{ all -> 0x0028 }
        r0.<init>();	 Catch:{ all -> 0x0028 }
        r1 = r9.zzqF;	 Catch:{ all -> 0x0028 }
        r1 = r1.getDefaultDisplay();	 Catch:{ all -> 0x0028 }
        r1.getMetrics(r0);	 Catch:{ all -> 0x0028 }
        r1 = r0.widthPixels;	 Catch:{ all -> 0x0028 }
        r0 = r0.heightPixels;	 Catch:{ all -> 0x0028 }
        r9.setMeasuredDimension(r1, r0);	 Catch:{ all -> 0x0028 }
        monitor-exit(r4);	 Catch:{ all -> 0x0028 }
        goto L_0x0018;
    L_0x0048:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x0028 }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x0028 }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x0028 }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x0028 }
        if (r2 == r6) goto L_0x005c;
    L_0x005a:
        if (r2 != r8) goto L_0x00f1;
    L_0x005c:
        r2 = r3;
    L_0x005d:
        if (r5 == r6) goto L_0x0061;
    L_0x005f:
        if (r5 != r8) goto L_0x0062;
    L_0x0061:
        r0 = r1;
    L_0x0062:
        r5 = r9.zzxT;	 Catch:{ all -> 0x0028 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0028 }
        if (r5 > r2) goto L_0x006e;
    L_0x0068:
        r2 = r9.zzxT;	 Catch:{ all -> 0x0028 }
        r2 = r2.heightPixels;	 Catch:{ all -> 0x0028 }
        if (r2 <= r0) goto L_0x00db;
    L_0x006e:
        r0 = r9.zzHo;	 Catch:{ all -> 0x0028 }
        r0 = r0.getResources();	 Catch:{ all -> 0x0028 }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x0028 }
        r0 = r0.density;	 Catch:{ all -> 0x0028 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0028 }
        r2.<init>();	 Catch:{ all -> 0x0028 }
        r5 = "Not enough space to show ad. Needs ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0028 }
        r5 = r9.zzxT;	 Catch:{ all -> 0x0028 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0028 }
        r5 = (float) r5;	 Catch:{ all -> 0x0028 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0028 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0028 }
        r5 = "x";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0028 }
        r5 = r9.zzxT;	 Catch:{ all -> 0x0028 }
        r5 = r5.heightPixels;	 Catch:{ all -> 0x0028 }
        r5 = (float) r5;	 Catch:{ all -> 0x0028 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0028 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0028 }
        r5 = " dp, but only has ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0028 }
        r3 = (float) r3;	 Catch:{ all -> 0x0028 }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x0028 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0028 }
        r3 = "x";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0028 }
        r1 = (float) r1;	 Catch:{ all -> 0x0028 }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x0028 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0028 }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0028 }
        r0 = r0.toString();	 Catch:{ all -> 0x0028 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(r0);	 Catch:{ all -> 0x0028 }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0028 }
        if (r0 == r7) goto L_0x00d3;
    L_0x00cf:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0028 }
    L_0x00d3:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0028 }
    L_0x00d8:
        monitor-exit(r4);	 Catch:{ all -> 0x0028 }
        goto L_0x0018;
    L_0x00db:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0028 }
        if (r0 == r7) goto L_0x00e5;
    L_0x00e1:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0028 }
    L_0x00e5:
        r0 = r9.zzxT;	 Catch:{ all -> 0x0028 }
        r0 = r0.widthPixels;	 Catch:{ all -> 0x0028 }
        r1 = r9.zzxT;	 Catch:{ all -> 0x0028 }
        r1 = r1.heightPixels;	 Catch:{ all -> 0x0028 }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0028 }
        goto L_0x00d8;
    L_0x00f1:
        r2 = r0;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzig.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Throwable e) {
                zzb.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Throwable e) {
                zzb.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.zzvA != null) {
            this.zzvA.zza(event);
        }
        return isDestroyed() ? false : super.onTouchEvent(event);
    }

    public void setContext(Context context) {
        this.zzHo.setBaseContext(context);
    }

    public void setRequestedOrientation(int requestedOrientation) {
        synchronized (this.zzqt) {
            this.zzHv = requestedOrientation;
            if (this.zzHp != null) {
                this.zzHp.setRequestedOrientation(this.zzHv);
            }
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                zzb.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zzB(boolean z) {
        synchronized (this.zzqt) {
            this.zzHs = z;
            zzgX();
        }
    }

    public void zzC(boolean z) {
        synchronized (this.zzqt) {
            if (this.zzHp != null) {
                this.zzHp.zza(this.zzBd.zzbU(), z);
            } else {
                this.zzHq = z;
            }
        }
    }

    public void zza(Context context, AdSizeParcel adSizeParcel) {
        synchronized (this.zzqt) {
            zzgV();
            setContext(context);
            this.zzHp = null;
            this.zzxT = adSizeParcel;
            this.zzHs = false;
            this.zzHq = false;
            this.zzHv = -1;
            zzo.zzbx().zzb(this);
            loadUrl("about:blank");
            this.zzBd.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
        }
    }

    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.zzqt) {
            this.zzxT = adSizeParcel;
            requestLayout();
        }
    }

    public void zza(zzc com_google_android_gms_ads_internal_overlay_zzc) {
        synchronized (this.zzqt) {
            this.zzHp = com_google_android_gms_ads_internal_overlay_zzc;
        }
    }

    protected void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzqt) {
            if (isDestroyed()) {
                zzb.zzaC("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void zza(String str, String str2) {
        zzaF(str + "(" + str2 + ");");
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zza(str, jSONObject.toString());
    }

    public void zzaD(String str) {
        synchronized (this.zzqt) {
            super.loadUrl(str);
        }
    }

    protected void zzaE(String str) {
        synchronized (this.zzqt) {
            if (isDestroyed()) {
                zzb.zzaC("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void zzaF(String str) {
        if (zzlk.zzoX()) {
            if (zzgc() == null) {
                zzgU();
            }
            if (zzgc().booleanValue()) {
                zza(str, null);
                return;
            } else {
                zzaE("javascript:" + str);
                return;
            }
        }
        zzaE("javascript:" + str);
    }

    public AdSizeParcel zzaN() {
        AdSizeParcel adSizeParcel;
        synchronized (this.zzqt) {
            adSizeParcel = this.zzxT;
        }
        return adSizeParcel;
    }

    public void zzb(zzc com_google_android_gms_ads_internal_overlay_zzc) {
        synchronized (this.zzqt) {
            this.zzHw = com_google_android_gms_ads_internal_overlay_zzc;
        }
    }

    void zzb(Boolean bool) {
        this.zzFO = bool;
        zzo.zzby().zzb(bool);
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        zzb.zzaB("Dispatching AFMA event: " + stringBuilder.toString());
        zzaF(stringBuilder.toString());
    }

    public void zzc(String str, Map<String, ?> map) {
        try {
            zzb(str, zzo.zzbv().zzy(map));
        } catch (JSONException e) {
            zzb.zzaC("Could not convert parameters to JSON.");
        }
    }

    public void zzew() {
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.zzoM.zzGG);
        zzc("onshow", hashMap);
    }

    public void zzgA() {
        Map hashMap = new HashMap(1);
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.zzoM.zzGG);
        zzc("onhide", hashMap);
    }

    public Activity zzgB() {
        return this.zzHo.zzgB();
    }

    public Context zzgC() {
        return this.zzHo.zzgC();
    }

    public zzc zzgD() {
        zzc com_google_android_gms_ads_internal_overlay_zzc;
        synchronized (this.zzqt) {
            com_google_android_gms_ads_internal_overlay_zzc = this.zzHp;
        }
        return com_google_android_gms_ads_internal_overlay_zzc;
    }

    public zzc zzgE() {
        zzc com_google_android_gms_ads_internal_overlay_zzc;
        synchronized (this.zzqt) {
            com_google_android_gms_ads_internal_overlay_zzc = this.zzHw;
        }
        return com_google_android_gms_ads_internal_overlay_zzc;
    }

    public zzie zzgF() {
        return this.zzBd;
    }

    public boolean zzgG() {
        return this.zzHq;
    }

    public zzan zzgH() {
        return this.zzvA;
    }

    public VersionInfoParcel zzgI() {
        return this.zzoM;
    }

    public boolean zzgJ() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzHs;
        }
        return z;
    }

    public void zzgK() {
        synchronized (this.zzqt) {
            zzb.zzaB("Destroying WebView!");
            super.destroy();
        }
    }

    public void zzgL() {
        synchronized (this.zzqt) {
            zzgW();
        }
    }

    public boolean zzgT() {
        if (!zzgF().zzbU()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics zza = zzo.zzbv().zza(this.zzqF);
        int zzb = zzk.zzcA().zzb(zza, zza.widthPixels);
        int zzb2 = zzk.zzcA().zzb(zza, zza.heightPixels);
        Activity zzgB = zzgB();
        if (zzgB == null || zzgB.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzg = zzo.zzbv().zzg(zzgB);
            i2 = zzk.zzcA().zzb(zza, zzg[0]);
            i = zzk.zzcA().zzb(zza, zzg[1]);
        }
        if (this.zzyW == zzb && this.zzyX == zzb2 && this.zzyZ == i2 && this.zzza == i) {
            return false;
        }
        boolean z = (this.zzyW == zzb && this.zzyX == zzb2) ? false : true;
        this.zzyW = zzb;
        this.zzyX = zzb2;
        this.zzyZ = i2;
        this.zzza = i;
        new zzeu(this).zza(zzb, zzb2, i2, i, zza.density, this.zzqF.getDefaultDisplay().getRotation());
        return z;
    }

    void zzgW() {
        Activity zzgB = zzgB();
        if (!this.zzHu && zzgB != null && this.zzHx) {
            zzo.zzbv().zza(zzgB, (OnGlobalLayoutListener) this);
            this.zzHu = true;
        }
    }

    Boolean zzgc() {
        Boolean bool;
        synchronized (this.zzqt) {
            bool = this.zzFO;
        }
        return bool;
    }

    public void zzv(int i) {
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.zzoM.zzGG);
        zzc("onhide", hashMap);
    }
}
