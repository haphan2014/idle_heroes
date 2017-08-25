package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<LargeParcelTeleporter> {
    static void zza(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, largeParcelTeleporter.zzCY);
        zzb.zza(parcel, 2, largeParcelTeleporter.zzCZ, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzE(x0);
    }

    public LargeParcelTeleporter[] zzE(int i) {
        return new LargeParcelTeleporter[i];
    }

    public LargeParcelTeleporter zzl(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzaa, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LargeParcelTeleporter(i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
