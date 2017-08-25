package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<PlusSession> {
    static void zza(PlusSession plusSession, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, plusSession.getAccountName(), false);
        zzb.zzc(parcel, 1000, plusSession.getVersionCode());
        zzb.zza(parcel, 2, plusSession.zzxx(), false);
        zzb.zza(parcel, 3, plusSession.zzxy(), false);
        zzb.zza(parcel, 4, plusSession.zzxz(), false);
        zzb.zza(parcel, 5, plusSession.zzxA(), false);
        zzb.zza(parcel, 6, plusSession.zzxB(), false);
        zzb.zza(parcel, 7, plusSession.zzlB(), false);
        zzb.zza(parcel, 8, plusSession.zzxC(), false);
        zzb.zza(parcel, 9, plusSession.zzxD(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziz(x0);
    }

    public PlusSession zzfJ(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    strArr3 = zza.zzA(parcel, zzaa);
                    break;
                case 3:
                    strArr2 = zza.zzA(parcel, zzaa);
                    break;
                case 4:
                    strArr = zza.zzA(parcel, zzaa);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) zza.zza(parcel, zzaa, PlusCommonExtras.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PlusSession(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public PlusSession[] zziz(int i) {
        return new PlusSession[i];
    }
}
