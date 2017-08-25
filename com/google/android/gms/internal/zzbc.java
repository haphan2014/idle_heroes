package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbb.zza;
import java.util.concurrent.Future;

@zzgd
public class zzbc {
    protected zzbb zza(Context context, VersionInfoParcel versionInfoParcel, final zzhs<zzbb> com_google_android_gms_internal_zzhs_com_google_android_gms_internal_zzbb) {
        final zzbb com_google_android_gms_internal_zzbd = new zzbd(context, versionInfoParcel);
        com_google_android_gms_internal_zzbd.zza(new zza(this) {
            final /* synthetic */ zzbc zzqZ;

            public void zzcf() {
                com_google_android_gms_internal_zzhs_com_google_android_gms_internal_zzbb.zzf(com_google_android_gms_internal_zzbd);
            }
        });
        return com_google_android_gms_internal_zzbd;
    }

    public Future<zzbb> zza(Context context, VersionInfoParcel versionInfoParcel, String str) {
        final Future com_google_android_gms_internal_zzhs = new zzhs();
        final Context context2 = context;
        final VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        final String str2 = str;
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzbc zzqZ;

            public void run() {
                this.zzqZ.zza(context2, versionInfoParcel2, com_google_android_gms_internal_zzhs).zzs(str2);
            }
        });
        return com_google_android_gms_internal_zzhs;
    }
}
