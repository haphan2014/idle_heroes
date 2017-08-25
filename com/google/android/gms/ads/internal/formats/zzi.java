package com.google.android.gms.ads.internal.formats;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm.zza;
import com.google.android.gms.internal.zzhz;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzi extends zza implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private final FrameLayout zznV;
    private final Object zzqt = new Object();
    private final FrameLayout zzvF;
    private final Map<String, WeakReference<View>> zzvG = new HashMap();
    private zzb zzvH;
    private zzg zzvq;

    public zzi(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzvF = frameLayout;
        this.zznV = frameLayout2;
        zzhz.zza(this.zzvF, (OnGlobalLayoutListener) this);
        zzhz.zza(this.zzvF, (OnScrollChangedListener) this);
        this.zzvF.setOnTouchListener(this);
    }

    private String zzi(View view) {
        synchronized (this.zzqt) {
            if (this.zzvH == null || !this.zzvH.zzdv().equals(view)) {
                for (Entry entry : this.zzvG.entrySet()) {
                    if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                        String str = (String) entry.getKey();
                        return str;
                    }
                }
                return null;
            }
            str = "1007";
            return str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r4) {
        /*
        r3 = this;
        r1 = r3.zzqt;
        monitor-enter(r1);
        r0 = r3.zzvq;	 Catch:{ all -> 0x0016 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r3.zzi(r4);	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0014;
    L_0x000f:
        r2 = r3.zzvq;	 Catch:{ all -> 0x0016 }
        r2.performClick(r0);	 Catch:{ all -> 0x0016 }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        goto L_0x0008;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.formats.zzi.onClick(android.view.View):void");
    }

    public void onGlobalLayout() {
        synchronized (this.zzqt) {
            if (this.zzvq != null) {
                this.zzvq.zzh(this.zzvF);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.zzqt) {
            if (this.zzvq != null) {
                this.zzvq.zzh(this.zzvF);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        synchronized (this.zzqt) {
            if (this.zzvq == null) {
                z = false;
            } else {
                this.zzvq.zzb(motionEvent);
                z = true;
            }
        }
        return z;
    }

    public zzd zzS(String str) {
        zzd zzw;
        synchronized (this.zzqt) {
            Object obj;
            WeakReference weakReference = (WeakReference) this.zzvG.get(str);
            if (weakReference == null) {
                obj = null;
            } else {
                View view = (View) weakReference.get();
            }
            zzw = zze.zzw(obj);
        }
        return zzw;
    }

    public void zza(String str, zzd com_google_android_gms_dynamic_zzd) {
        View view = (View) zze.zzn(com_google_android_gms_dynamic_zzd);
        synchronized (this.zzqt) {
            if (view == null) {
                this.zzvG.remove(str);
            } else {
                this.zzvG.put(str, new WeakReference(view));
                view.setOnClickListener(this);
            }
        }
    }

    public void zzb(zzd com_google_android_gms_dynamic_zzd) {
        synchronized (this.zzqt) {
            this.zzvq = (zzg) zze.zzn(com_google_android_gms_dynamic_zzd);
            this.zznV.removeAllViews();
            this.zzvH = zzdI();
            if (this.zzvH != null) {
                this.zznV.addView(this.zzvH);
            }
        }
    }

    zzb zzdI() {
        return this.zzvq.zza(this);
    }
}
