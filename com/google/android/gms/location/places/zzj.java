package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<PlacePhotoResult> {
    static void zza(PlacePhotoResult placePhotoResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, placePhotoResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoResult.zzCY);
        zzb.zza(parcel, 2, placePhotoResult.zzazJ, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzet(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgR(x0);
    }

    public PlacePhotoResult zzet(Parcel parcel) {
        BitmapTeleporter bitmapTeleporter = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            BitmapTeleporter bitmapTeleporter2;
            Status status2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    bitmapTeleporter2 = bitmapTeleporter;
                    status2 = status3;
                    break;
                case 2:
                    bitmapTeleporter2 = (BitmapTeleporter) zza.zza(parcel, zzaa, BitmapTeleporter.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    BitmapTeleporter bitmapTeleporter3 = bitmapTeleporter;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzaa);
                    bitmapTeleporter2 = bitmapTeleporter3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    bitmapTeleporter2 = bitmapTeleporter;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            bitmapTeleporter = bitmapTeleporter2;
        }
        if (parcel.dataPosition() == zzab) {
            return new PlacePhotoResult(i, status, bitmapTeleporter);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public PlacePhotoResult[] zzgR(int i) {
        return new PlacePhotoResult[i];
    }
}
