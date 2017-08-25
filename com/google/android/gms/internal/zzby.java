package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;

@zzgd
public class zzby {
    private boolean zzpb = false;
    private final Object zzqt = new Object();
    private SharedPreferences zztB = null;

    public <T> T zzc(zzbv<T> com_google_android_gms_internal_zzbv_T) {
        synchronized (this.zzqt) {
            if (this.zzpb) {
                return com_google_android_gms_internal_zzbv_T.zza(this.zztB);
            }
            T zzcY = com_google_android_gms_internal_zzbv_T.zzcY();
            return zzcY;
        }
    }

    public void zzw(Context context) {
        synchronized (this.zzqt) {
            if (this.zzpb) {
                return;
            }
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                return;
            }
            this.zztB = zzo.zzbC().zzv(remoteContext);
            this.zzpb = true;
        }
    }
}
