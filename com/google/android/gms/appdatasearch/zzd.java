package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DocumentSection> {
    static void zza(DocumentSection documentSection, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, documentSection.zzNe, false);
        zzb.zzc(parcel, 1000, documentSection.zzCY);
        zzb.zza(parcel, 3, documentSection.zzNf, i, false);
        zzb.zzc(parcel, 4, documentSection.zzNg);
        zzb.zza(parcel, 5, documentSection.zzNh, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzae(x0);
    }

    public DocumentSection[] zzae(int i) {
        return new DocumentSection[i];
    }

    public DocumentSection zzt(Parcel parcel) {
        byte[] bArr = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = -1;
        RegisterSectionInfo registerSectionInfo = null;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    registerSectionInfo = (RegisterSectionInfo) zza.zza(parcel, zzaa, RegisterSectionInfo.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    bArr = zza.zzr(parcel, zzaa);
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
            return new DocumentSection(i, str, registerSectionInfo, i2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
