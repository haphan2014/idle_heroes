package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha.zza;

@zzgd
public class zzfv extends zzfu {
    private Object zzBx = new Object();
    private PopupWindow zzBy;
    private boolean zzBz = false;

    zzfv(Context context, zza com_google_android_gms_internal_zzha_zza, zzid com_google_android_gms_internal_zzid, zzft.zza com_google_android_gms_internal_zzft_zza) {
        super(context, com_google_android_gms_internal_zzha_zza, com_google_android_gms_internal_zzid, com_google_android_gms_internal_zzft_zza);
    }

    private void zzfo() {
        synchronized (this.zzBx) {
            this.zzBz = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzBy = null;
            }
            if (this.zzBy != null) {
                if (this.zzBy.isShowing()) {
                    this.zzBy.dismiss();
                }
                this.zzBy = null;
            }
        }
    }

    public void onStop() {
        zzfo();
        super.onStop();
    }

    protected void zzfn() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            View frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.zzoA.getWebView(), -1, -1);
            synchronized (this.zzBx) {
                if (this.zzBz) {
                    return;
                }
                this.zzBy = new PopupWindow(frameLayout, 1, 1, false);
                this.zzBy.setOutsideTouchable(true);
                this.zzBy.setClippingEnabled(false);
                zzb.zzay("Displaying the 1x1 popup off the screen.");
                try {
                    this.zzBy.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.zzBy = null;
                }
            }
        }
    }

    protected void zzk(zzha com_google_android_gms_internal_zzha) {
        zzfo();
        super.zzk(com_google_android_gms_internal_zzha);
    }
}
