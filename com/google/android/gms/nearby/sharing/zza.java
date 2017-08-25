package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AppContentReceivedResult> {
    static void zza(AppContentReceivedResult appContentReceivedResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, appContentReceivedResult.getVersionCode());
        zzb.zza(parcel, 2, appContentReceivedResult.zzxc(), i, false);
        zzb.zzc(parcel, 3, appContentReceivedResult.getStatusCode());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzin(x0);
    }

    public AppContentReceivedResult zzfy(Parcel parcel) {
        int i = 0;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        Uri uri = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            Uri uri2;
            int zzg;
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    int i3 = i;
                    uri2 = uri;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    zzaa = i3;
                    break;
                case 2:
                    zzg = i2;
                    Uri uri3 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Uri.CREATOR);
                    zzaa = i;
                    uri2 = uri3;
                    break;
                case 3:
                    zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    uri2 = uri;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    zzaa = i;
                    uri2 = uri;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            uri = uri2;
            i = zzaa;
        }
        if (parcel.dataPosition() == zzab) {
            return new AppContentReceivedResult(i2, uri, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AppContentReceivedResult[] zzin(int i) {
        return new AppContentReceivedResult[i];
    }
}
