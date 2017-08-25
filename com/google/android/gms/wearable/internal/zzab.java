package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab implements Creator<DataItemParcelable> {
    static void zza(DataItemParcelable dataItemParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, dataItemParcelable.zzCY);
        zzb.zza(parcel, 2, dataItemParcelable.getUri(), i, false);
        zzb.zza(parcel, 4, dataItemParcelable.zzAR(), false);
        zzb.zza(parcel, 5, dataItemParcelable.getData(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkc(x0);
    }

    public DataItemParcelable zzgU(Parcel parcel) {
        byte[] bArr = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < zzab) {
            Bundle bundle2;
            Uri uri2;
            int zzg;
            byte[] bArr2;
            int zzaa = zza.zzaa(parcel);
            byte[] bArr3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = zza.zzg(parcel, zzaa);
                    bArr2 = bArr3;
                    break;
                case 2:
                    zzg = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) zza.zza(parcel, zzaa, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case 4:
                    uri2 = uri;
                    zzg = i;
                    bArr3 = bArr;
                    bundle2 = zza.zzq(parcel, zzaa);
                    bArr2 = bArr3;
                    break;
                case 5:
                    bArr2 = zza.zzr(parcel, zzaa);
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    zzg = i;
                    break;
            }
            i = zzg;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == zzab) {
            return new DataItemParcelable(i, uri, bundle, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DataItemParcelable[] zzkc(int i) {
        return new DataItemParcelable[i];
    }
}
