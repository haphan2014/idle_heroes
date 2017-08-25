package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc implements Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, customProperty.zzCY);
        zzb.zza(parcel, 2, customProperty.zzagG, i, false);
        zzb.zza(parcel, 3, customProperty.mValue, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdq(x0);
    }

    public CustomProperty zzbB(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < zzab) {
            CustomPropertyKey customPropertyKey2;
            int zzg;
            String str2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = zza.zzg(parcel, zzaa);
                    str2 = str3;
                    break;
                case 2:
                    zzg = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) zza.zza(parcel, zzaa, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    zzg = i;
                    break;
            }
            i = zzg;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == zzab) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CustomProperty[] zzdq(int i) {
        return new CustomProperty[i];
    }
}
