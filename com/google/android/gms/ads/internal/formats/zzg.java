package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzgd;
import org.json.JSONObject;

@zzgd
public class zzg {
    private final Context mContext;
    private final Object zzqt = new Object();
    private final zzan zzvA;
    private boolean zzvB;
    private final zzm zzvw;
    private final JSONObject zzvx;
    private final zzbb zzvy;
    private final zza zzvz;

    public interface zza {
        String getCustomTemplateId();

        void zza(zzg com_google_android_gms_ads_internal_formats_zzg);

        String zzdE();

        zza zzdF();
    }

    public zzg(Context context, zzm com_google_android_gms_ads_internal_zzm, zzbb com_google_android_gms_internal_zzbb, zzan com_google_android_gms_internal_zzan, JSONObject jSONObject, zza com_google_android_gms_ads_internal_formats_zzg_zza) {
        this.mContext = context;
        this.zzvw = com_google_android_gms_ads_internal_zzm;
        this.zzvy = com_google_android_gms_internal_zzbb;
        this.zzvA = com_google_android_gms_internal_zzan;
        this.zzvx = jSONObject;
        this.zzvz = com_google_android_gms_ads_internal_formats_zzg_zza;
    }

    public void performClick(String assetId) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset", assetId);
            jSONObject.put("template", this.zzvz.zzdE());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad", this.zzvx);
            jSONObject2.put("click", jSONObject);
            jSONObject2.put("has_custom_click_handler", this.zzvw.zzq(this.zzvz.getCustomTemplateId()) != null);
            this.zzvy.zza("google.afma.nativeAds.handleClickGmsg", jSONObject2);
        } catch (Throwable e) {
            zzb.zzb("Unable to create click JSON.", e);
        }
    }

    public void recordImpression() {
        this.zzvB = true;
        this.zzvw.zzaP();
    }

    public zzb zza(OnClickListener onClickListener) {
        zza zzdF = this.zzvz.zzdF();
        if (zzdF == null) {
            return null;
        }
        zzb com_google_android_gms_ads_internal_formats_zzb = new zzb(this.mContext, zzdF);
        com_google_android_gms_ads_internal_formats_zzb.setLayoutParams(new LayoutParams(-1, -1));
        com_google_android_gms_ads_internal_formats_zzb.zzdv().setOnClickListener(onClickListener);
        return com_google_android_gms_ads_internal_formats_zzb;
    }

    public void zzb(MotionEvent motionEvent) {
        this.zzvA.zza(motionEvent);
    }

    public void zzh(View view) {
        synchronized (this.zzqt) {
            if (this.zzvB) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                recordImpression();
            }
        }
    }
}
