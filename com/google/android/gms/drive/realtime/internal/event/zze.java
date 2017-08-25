package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<ReferenceShiftedDetails> {
    static void zza(ReferenceShiftedDetails referenceShiftedDetails, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, referenceShiftedDetails.zzCY);
        zzb.zza(parcel, 2, referenceShiftedDetails.zzaiT, false);
        zzb.zza(parcel, 3, referenceShiftedDetails.zzaiU, false);
        zzb.zzc(parcel, 4, referenceShiftedDetails.zzaiV);
        zzb.zzc(parcel, 5, referenceShiftedDetails.zzaiW);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdR(x0);
    }

    public ReferenceShiftedDetails zzcb(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ReferenceShiftedDetails(i3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ReferenceShiftedDetails[] zzdR(int i) {
        return new ReferenceShiftedDetails[i];
    }
}
