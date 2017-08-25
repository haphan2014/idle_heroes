package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<RegisterSectionInfo> {
    static void zza(RegisterSectionInfo registerSectionInfo, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, registerSectionInfo.name, false);
        zzb.zzc(parcel, 1000, registerSectionInfo.zzCY);
        zzb.zza(parcel, 2, registerSectionInfo.zzNs, false);
        zzb.zza(parcel, 3, registerSectionInfo.zzNt);
        zzb.zzc(parcel, 4, registerSectionInfo.weight);
        zzb.zza(parcel, 5, registerSectionInfo.zzNu);
        zzb.zza(parcel, 6, registerSectionInfo.zzNv, false);
        zzb.zza(parcel, 7, registerSectionInfo.zzNw, i, false);
        zzb.zza(parcel, 8, registerSectionInfo.zzNx, false);
        zzb.zza(parcel, 11, registerSectionInfo.zzNy, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzak(x0);
    }

    public RegisterSectionInfo[] zzak(int i) {
        return new RegisterSectionInfo[i];
    }

    public RegisterSectionInfo zzx(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 1;
        int[] iArr = null;
        Feature[] featureArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    featureArr = (Feature[]) zza.zzb(parcel, zzaa, Feature.CREATOR);
                    break;
                case 8:
                    iArr = zza.zzu(parcel, zzaa);
                    break;
                case 11:
                    str = zza.zzo(parcel, zzaa);
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
            return new RegisterSectionInfo(i2, str4, str3, z2, i, z, str2, featureArr, iArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
