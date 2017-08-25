package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<CredentialRequest> {
    static void zza(CredentialRequest credentialRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, credentialRequest.getSupportsPasswordLogin());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, credentialRequest.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, credentialRequest.getAccountTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzat(x0);
    }

    public CredentialRequest zzD(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        String[] strArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 2:
                    strArr = zza.zzA(parcel, zzaa);
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
            return new CredentialRequest(i, z, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CredentialRequest[] zzat(int i) {
        return new CredentialRequest[i];
    }
}
