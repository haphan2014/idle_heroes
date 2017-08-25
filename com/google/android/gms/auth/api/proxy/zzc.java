package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<ProxyResponse> {
    static void zza(ProxyResponse proxyResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, proxyResponse.zzPu);
        zzb.zzc(parcel, 1000, proxyResponse.versionCode);
        zzb.zza(parcel, 2, proxyResponse.zzPv, i, false);
        zzb.zzc(parcel, 3, proxyResponse.zzPw);
        zzb.zza(parcel, 4, proxyResponse.zzPt, false);
        zzb.zza(parcel, 5, proxyResponse.zzPs, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzay(x0);
    }

    public ProxyResponse zzI(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        Bundle bundle = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 5:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ProxyResponse(i3, i2, pendingIntent, i, bundle, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ProxyResponse[] zzay(int i) {
        return new ProxyResponse[i];
    }
}
