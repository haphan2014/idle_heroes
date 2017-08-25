package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzhl;

class zzm implements Runnable {
    private boolean zzAq = false;
    private zzh zzzl;

    zzm(zzh com_google_android_gms_ads_internal_overlay_zzh) {
        this.zzzl = com_google_android_gms_ads_internal_overlay_zzh;
    }

    public void cancel() {
        this.zzAq = true;
        zzhl.zzGk.removeCallbacks(this);
    }

    public void run() {
        if (!this.zzAq) {
            this.zzzl.zzeL();
            zzeY();
        }
    }

    public void zzeY() {
        zzhl.zzGk.postDelayed(this, 250);
    }
}
