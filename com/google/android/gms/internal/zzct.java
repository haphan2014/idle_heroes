package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

@zzgd
public class zzct implements NativeCustomTemplateAd {
    private final zzcs zzvP;

    public zzct(zzcs com_google_android_gms_internal_zzcs) {
        this.zzvP = com_google_android_gms_internal_zzcs;
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.zzvP.getAvailableAssetNames();
        } catch (Throwable e) {
            zzb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.zzvP.getCustomTemplateId();
        } catch (Throwable e) {
            zzb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    public Image getImage(String assetName) {
        try {
            zzck zzR = this.zzvP.zzR(assetName);
            if (zzR != null) {
                return new zzcl(zzR);
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String assetName) {
        try {
            return this.zzvP.zzQ(assetName);
        } catch (Throwable e) {
            zzb.zzb("Failed to get string.", e);
            return null;
        }
    }

    public void performClick(String assetName) {
        try {
            this.zzvP.performClick(assetName);
        } catch (Throwable e) {
            zzb.zzb("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzvP.recordImpression();
        } catch (Throwable e) {
            zzb.zzb("Failed to record impression.", e);
        }
    }
}
