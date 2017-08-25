package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ConnectionEvent> {
    static void zza(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, connectionEvent.zzCY);
        zzb.zza(parcel, 2, connectionEvent.getTimeMillis());
        zzb.zza(parcel, 4, connectionEvent.zzoG(), false);
        zzb.zza(parcel, 5, connectionEvent.zzoH(), false);
        zzb.zza(parcel, 6, connectionEvent.zzoI(), false);
        zzb.zza(parcel, 7, connectionEvent.zzoJ(), false);
        zzb.zza(parcel, 8, connectionEvent.zzoK(), false);
        zzb.zza(parcel, 10, connectionEvent.zzoN());
        zzb.zza(parcel, 11, connectionEvent.zzoM());
        zzb.zzc(parcel, 12, connectionEvent.getEventType());
        zzb.zza(parcel, 13, connectionEvent.zzoL(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzam(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbM(x0);
    }

    public ConnectionEvent zzam(Parcel parcel) {
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ConnectionEvent[] zzbM(int i) {
        return new ConnectionEvent[i];
    }
}
