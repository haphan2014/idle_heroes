package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<Request> {
    static void zza(Request request, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, request.zzNj, i, false);
        zzb.zzc(parcel, 1000, request.zzCY);
        zzb.zza(parcel, 2, request.zzNk);
        zzb.zza(parcel, 3, request.zzNl);
        zzb.zza(parcel, 4, request.zzNm);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzag(x0);
    }

    public Request[] zzag(int i) {
        return new Request[i];
    }

    public Request zzv(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        Account account = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    account = (Account) zza.zza(parcel, zzaa, Account.CREATOR);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzaa);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
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
            return new Request(i, account, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
