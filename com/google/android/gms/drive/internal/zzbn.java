package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzbn implements Creator<SetDrivePreferencesRequest> {
    static void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, setDrivePreferencesRequest.zzCY);
        zzb.zza(parcel, 2, setDrivePreferencesRequest.zzagi, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdg(x0);
    }

    public SetDrivePreferencesRequest zzbr(Parcel parcel) {
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
            return new SetDrivePreferencesRequest(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SetDrivePreferencesRequest[] zzdg(int i) {
        return new SetDrivePreferencesRequest[i];
    }
}
