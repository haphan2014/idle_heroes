package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzbd implements Creator<OnMetadataResponse> {
    static void zza(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onMetadataResponse.zzCY);
        zzb.zza(parcel, 2, onMetadataResponse.zzaeA, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcX(x0);
    }

    public OnMetadataResponse zzbi(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzaa, MetadataBundle.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OnMetadataResponse[] zzcX(int i) {
        return new OnMetadataResponse[i];
    }
}
