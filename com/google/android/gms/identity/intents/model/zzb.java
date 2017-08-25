package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<UserAddress> {
    static void zza(UserAddress userAddress, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, userAddress.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, userAddress.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, userAddress.zzawA, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, userAddress.zzawB, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, userAddress.zzawC, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, userAddress.zzawD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, userAddress.zzawE, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, userAddress.zzawF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, userAddress.zzawG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, userAddress.zzEr, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, userAddress.zzawH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, userAddress.zzawI, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, userAddress.zzawJ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, userAddress.zzawK);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, userAddress.zzawL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, userAddress.zzawM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzea(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgm(x0);
    }

    public UserAddress zzea(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str6 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str7 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    str8 = zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    str9 = zza.zzo(parcel, zzaa);
                    break;
                case 11:
                    str10 = zza.zzo(parcel, zzaa);
                    break;
                case 12:
                    str11 = zza.zzo(parcel, zzaa);
                    break;
                case 13:
                    str12 = zza.zzo(parcel, zzaa);
                    break;
                case 14:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 15:
                    str13 = zza.zzo(parcel, zzaa);
                    break;
                case 16:
                    str14 = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public UserAddress[] zzgm(int i) {
        return new UserAddress[i];
    }
}
