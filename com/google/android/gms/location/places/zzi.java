package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<PlacePhotoMetadataResult> {
    static void zza(PlacePhotoMetadataResult placePhotoMetadataResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, placePhotoMetadataResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoMetadataResult.zzCY);
        zzb.zza(parcel, 2, placePhotoMetadataResult.zzazH, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzes(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgQ(x0);
    }

    public PlacePhotoMetadataResult zzes(Parcel parcel) {
        DataHolder dataHolder = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            DataHolder dataHolder2;
            Status status2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    dataHolder2 = dataHolder;
                    status2 = status3;
                    break;
                case 2:
                    dataHolder2 = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataHolder dataHolder3 = dataHolder;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzaa);
                    dataHolder2 = dataHolder3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    dataHolder2 = dataHolder;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataHolder = dataHolder2;
        }
        if (parcel.dataPosition() == zzab) {
            return new PlacePhotoMetadataResult(i, status, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public PlacePhotoMetadataResult[] zzgQ(int i) {
        return new PlacePhotoMetadataResult[i];
    }
}
