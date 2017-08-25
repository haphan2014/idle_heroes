package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<UsageInfo> {
    static void zza(UsageInfo usageInfo, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, usageInfo.zzNH, i, false);
        zzb.zzc(parcel, 1000, usageInfo.zzCY);
        zzb.zza(parcel, 2, usageInfo.zzNI);
        zzb.zzc(parcel, 3, usageInfo.zzNJ);
        zzb.zza(parcel, 4, usageInfo.zztt, false);
        zzb.zza(parcel, 5, usageInfo.zzNK, i, false);
        zzb.zza(parcel, 6, usageInfo.zzNL);
        zzb.zzc(parcel, 7, usageInfo.zzNM);
        zzb.zzc(parcel, 8, usageInfo.zzNN);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzan(x0);
    }

    public UsageInfo[] zzan(int i) {
        return new UsageInfo[i];
    }

    public UsageInfo zzy(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    documentId = (DocumentId) zza.zza(parcel, zzaa, DocumentId.CREATOR);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    documentContents = (DocumentContents) zza.zza(parcel, zzaa, DocumentContents.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
