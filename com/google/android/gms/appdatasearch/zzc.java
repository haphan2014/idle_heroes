package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<DocumentId> {
    static void zza(DocumentId documentId, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, documentId.zzMZ, false);
        zzb.zzc(parcel, 1000, documentId.zzCY);
        zzb.zza(parcel, 2, documentId.zzNa, false);
        zzb.zza(parcel, 3, documentId.zzNb, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzad(x0);
    }

    public DocumentId[] zzad(int i) {
        return new DocumentId[i];
    }

    public DocumentId zzs(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
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
            return new DocumentId(i, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
