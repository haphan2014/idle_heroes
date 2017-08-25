package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzbk extends Thread {
    private boolean mStarted = false;
    private boolean zzam = false;
    private final Object zzqt;
    private final int zzrA;
    private final int zzrB;
    private final int zzrj;
    private final int zzrl;
    private boolean zzrv = false;
    private final zzbj zzrw;
    private final zzbi zzrx;
    private final zzgc zzry;
    private final int zzrz;

    @zzgd
    class zza {
        final /* synthetic */ zzbk zzrD;
        final int zzrI;
        final int zzrJ;

        zza(zzbk com_google_android_gms_internal_zzbk, int i, int i2) {
            this.zzrD = com_google_android_gms_internal_zzbk;
            this.zzrI = i;
            this.zzrJ = i2;
        }
    }

    public zzbk(zzbj com_google_android_gms_internal_zzbj, zzbi com_google_android_gms_internal_zzbi, zzgc com_google_android_gms_internal_zzgc) {
        this.zzrw = com_google_android_gms_internal_zzbj;
        this.zzrx = com_google_android_gms_internal_zzbi;
        this.zzry = com_google_android_gms_internal_zzgc;
        this.zzqt = new Object();
        this.zzrj = ((Integer) zzbz.zzud.get()).intValue();
        this.zzrA = ((Integer) zzbz.zzue.get()).intValue();
        this.zzrl = ((Integer) zzbz.zzuf.get()).intValue();
        this.zzrB = ((Integer) zzbz.zzug.get()).intValue();
        this.zzrz = ((Integer) zzbz.zzuh.get()).intValue();
        setName("ContentFetchTask");
    }

    public void run() {
        while (!this.zzam) {
            try {
                if (zzcq()) {
                    Activity activity = this.zzrw.getActivity();
                    if (activity == null) {
                        zzb.zzay("ContentFetchThread: no activity");
                    } else {
                        zza(activity);
                    }
                } else {
                    zzb.zzay("ContentFetchTask: sleeping");
                    zzcs();
                }
                Thread.sleep((long) (this.zzrz * 1000));
            } catch (Throwable th) {
                zzb.zzb("Error in ContentFetchTask", th);
                this.zzry.zza(th, true);
            }
            synchronized (this.zzqt) {
                while (this.zzrv) {
                    try {
                        zzb.zzay("ContentFetchTask: waiting");
                        this.zzqt.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzqt) {
            this.zzrv = false;
            this.zzqt.notifyAll();
            zzb.zzay("ContentFetchThread: wakeup");
        }
    }

    zza zza(View view, zzbh com_google_android_gms_internal_zzbh) {
        int i = 0;
        if (view == null) {
            return new zza(this, 0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(this, 0, 0);
            }
            com_google_android_gms_internal_zzbh.zzv(text.toString());
            return new zza(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzid)) {
            com_google_android_gms_internal_zzbh.zzcl();
            return zza((WebView) view, com_google_android_gms_internal_zzbh) ? new zza(this, 0, 1) : new zza(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                zza zza = zza(viewGroup.getChildAt(i), com_google_android_gms_internal_zzbh);
                i3 += zza.zzrI;
                i2 += zza.zzrJ;
                i++;
            }
            return new zza(this, i3, i2);
        }
    }

    void zza(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                zzf(view);
            }
        }
    }

    void zza(zzbh com_google_android_gms_internal_zzbh, WebView webView, String str) {
        com_google_android_gms_internal_zzbh.zzck();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    com_google_android_gms_internal_zzbh.zzu(optString);
                } else {
                    com_google_android_gms_internal_zzbh.zzu(webView.getTitle() + "\n" + optString);
                }
            }
            if (com_google_android_gms_internal_zzbh.zzch()) {
                this.zzrx.zzb(com_google_android_gms_internal_zzbh);
            }
        } catch (JSONException e) {
            zzb.zzay("Json string may be malformed.");
        } catch (Throwable th) {
            zzb.zza("Failed to get webview content.", th);
            this.zzry.zza(th, true);
        }
    }

    boolean zza(RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean zza(final WebView webView, final zzbh com_google_android_gms_internal_zzbh) {
        if (!zzlk.zzoX()) {
            return false;
        }
        com_google_android_gms_internal_zzbh.zzcl();
        webView.post(new Runnable(this) {
            final /* synthetic */ zzbk zzrD;
            ValueCallback<String> zzrE = new C08491(this);

            class C08491 implements ValueCallback<String> {
                final /* synthetic */ C08502 zzrH;

                C08491(C08502 c08502) {
                    this.zzrH = c08502;
                }

                public /* synthetic */ void onReceiveValue(Object x0) {
                    zzx((String) x0);
                }

                public void zzx(String str) {
                    this.zzrH.zzrD.zza(com_google_android_gms_internal_zzbh, webView, str);
                }
            }

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzrE);
                    } catch (Throwable th) {
                        this.zzrE.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzcp() {
        synchronized (this.zzqt) {
            if (this.mStarted) {
                zzb.zzay("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    boolean zzcq() {
        try {
            Context context = this.zzrw.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (zza(runningAppProcessInfo) && !keyguardManager.inKeyguardRestrictedInputMode() && zzr(context)) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzbh zzcr() {
        return this.zzrx.zzco();
    }

    public void zzcs() {
        synchronized (this.zzqt) {
            this.zzrv = true;
            zzb.zzay("ContentFetchThread: paused, mPause = " + this.zzrv);
        }
    }

    public boolean zzct() {
        return this.zzrv;
    }

    boolean zzf(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable(this) {
            final /* synthetic */ zzbk zzrD;

            public void run() {
                this.zzrD.zzg(view);
            }
        });
        return true;
    }

    void zzg(View view) {
        try {
            zzbh com_google_android_gms_internal_zzbh = new zzbh(this.zzrj, this.zzrA, this.zzrl, this.zzrB);
            zza zza = zza(view, com_google_android_gms_internal_zzbh);
            com_google_android_gms_internal_zzbh.zzcm();
            if (zza.zzrI != 0 || zza.zzrJ != 0) {
                if (zza.zzrJ != 0 || com_google_android_gms_internal_zzbh.zzcn() != 0) {
                    if (zza.zzrJ != 0 || !this.zzrx.zza(com_google_android_gms_internal_zzbh)) {
                        this.zzrx.zzc(com_google_android_gms_internal_zzbh);
                    }
                }
            }
        } catch (Throwable e) {
            zzb.zzb("Exception in fetchContentOnUIThread", e);
            this.zzry.zza(e, true);
        }
    }

    boolean zzr(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null ? false : powerManager.isScreenOn();
    }
}
