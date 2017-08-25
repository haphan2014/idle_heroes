package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzo;
import java.lang.ref.WeakReference;

class zzia extends zzic implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> zzGZ;

    public zzia(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zzGZ = new WeakReference(onGlobalLayoutListener);
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.zzGZ.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            detach();
        }
    }

    protected void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected void zzb(ViewTreeObserver viewTreeObserver) {
        zzo.zzbx().zza(viewTreeObserver, (OnGlobalLayoutListener) this);
    }
}
