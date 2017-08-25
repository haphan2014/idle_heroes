package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<ParcelableGeofence> {
    static void zza(ParcelableGeofence parcelableGeofence, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, parcelableGeofence.getRequestId(), false);
        zzb.zzc(parcel, 1000, parcelableGeofence.getVersionCode());
        zzb.zza(parcel, 2, parcelableGeofence.getExpirationTime());
        zzb.zza(parcel, 3, parcelableGeofence.zzuA());
        zzb.zza(parcel, 4, parcelableGeofence.getLatitude());
        zzb.zza(parcel, 5, parcelableGeofence.getLongitude());
        zzb.zza(parcel, 6, parcelableGeofence.zzuB());
        zzb.zzc(parcel, 7, parcelableGeofence.zzuC());
        zzb.zzc(parcel, 8, parcelableGeofence.getNotificationResponsiveness());
        zzb.zzc(parcel, 9, parcelableGeofence.zzuD());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzem(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgI(x0);
    }

    public ParcelableGeofence zzem(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    s = zza.zzf(parcel, zzaa);
                    break;
                case 4:
                    d = zza.zzm(parcel, zzaa);
                    break;
                case 5:
                    d2 = zza.zzm(parcel, zzaa);
                    break;
                case 6:
                    f = zza.zzl(parcel, zzaa);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 9:
                    i4 = zza.zzg(parcel, zzaa);
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
            return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ParcelableGeofence[] zzgI(int i) {
        return new ParcelableGeofence[i];
    }
}
