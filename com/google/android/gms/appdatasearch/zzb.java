package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<DocumentContents> {
    static void zza(DocumentContents documentContents, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, documentContents.zzMS, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, documentContents.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, documentContents.zzMT, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, documentContents.zzMU);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, documentContents.account, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzac(x0);
    }

    public DocumentContents[] zzac(int i) {
        return new DocumentContents[i];
    }

    public DocumentContents zzr(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int zzab = zza.zzab(parcel);
        String str = null;
        DocumentSection[] documentSectionArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    documentSectionArr = (DocumentSection[]) zza.zzb(parcel, zzaa, DocumentSection.CREATOR);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    account = (Account) zza.zza(parcel, zzaa, Account.CREATOR);
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
            return new DocumentContents(i, documentSectionArr, str, z, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
