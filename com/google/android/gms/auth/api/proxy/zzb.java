package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ProxyRequest> {
    static void zza(ProxyRequest proxyRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, proxyRequest.zzzf, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, proxyRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, proxyRequest.zzPq);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, proxyRequest.zzPr);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, proxyRequest.zzPs, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, proxyRequest.zzPt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzax(x0);
    }

    public ProxyRequest zzH(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzab = zza.zzab(parcel);
        long j = 0;
        byte[] bArr = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ProxyRequest(i2, str, i, j, bArr, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ProxyRequest[] zzax(int i) {
        return new ProxyRequest[i];
    }
}
