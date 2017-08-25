package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzay implements Creator<OnDrivePreferencesResponse> {
    static void zza(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onDrivePreferencesResponse.zzCY);
        zzb.zza(parcel, 2, onDrivePreferencesResponse.zzagi, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcS(x0);
    }

    public OnDrivePreferencesResponse zzbd(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) zza.zza(parcel, zzaa, DrivePreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OnDrivePreferencesResponse[] zzcS(int i) {
        return new OnDrivePreferencesResponse[i];
    }
}
