package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONObject;
import org.nexage.sourcekit.mraid.MRAIDNativeFeature;

@zzgd
public class zzes {
    private final boolean zzyO;
    private final boolean zzyP;
    private final boolean zzyQ;
    private final boolean zzyR;
    private final boolean zzyS;

    public static final class zza {
        private boolean zzyO;
        private boolean zzyP;
        private boolean zzyQ;
        private boolean zzyR;
        private boolean zzyS;

        public zzes zzeg() {
            return new zzes();
        }

        public zza zzo(boolean z) {
            this.zzyO = z;
            return this;
        }

        public zza zzp(boolean z) {
            this.zzyP = z;
            return this;
        }

        public zza zzq(boolean z) {
            this.zzyQ = z;
            return this;
        }

        public zza zzr(boolean z) {
            this.zzyR = z;
            return this;
        }

        public zza zzs(boolean z) {
            this.zzyS = z;
            return this;
        }
    }

    private zzes(zza com_google_android_gms_internal_zzes_zza) {
        this.zzyO = com_google_android_gms_internal_zzes_zza.zzyO;
        this.zzyP = com_google_android_gms_internal_zzes_zza.zzyP;
        this.zzyQ = com_google_android_gms_internal_zzes_zza.zzyQ;
        this.zzyR = com_google_android_gms_internal_zzes_zza.zzyR;
        this.zzyS = com_google_android_gms_internal_zzes_zza.zzyS;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put(MRAIDNativeFeature.SMS, this.zzyO).put(MRAIDNativeFeature.TEL, this.zzyP).put(MRAIDNativeFeature.CALENDAR, this.zzyQ).put(MRAIDNativeFeature.STORE_PICTURE, this.zzyR).put(MRAIDNativeFeature.INLINE_VIDEO, this.zzyS);
        } catch (Throwable e) {
            zzb.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
