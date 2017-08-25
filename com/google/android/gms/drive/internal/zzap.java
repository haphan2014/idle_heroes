package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzap implements Creator<LoadRealtimeRequest> {
    static void zza(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, loadRealtimeRequest.zzCY);
        zzb.zza(parcel, 2, loadRealtimeRequest.zzacT, i, false);
        zzb.zza(parcel, 3, loadRealtimeRequest.zzafQ);
        zzb.zzb(parcel, 4, loadRealtimeRequest.zzafR, false);
        zzb.zza(parcel, 5, loadRealtimeRequest.zzafS);
        zzb.zza(parcel, 6, loadRealtimeRequest.zzafT, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcM(x0);
    }

    public LoadRealtimeRequest zzaX(Parcel parcel) {
        DataHolder dataHolder = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        List list = null;
        boolean z2 = false;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    list = zza.zzC(parcel, zzaa);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 6:
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LoadRealtimeRequest(i, driveId, z2, list, z, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LoadRealtimeRequest[] zzcM(int i) {
        return new LoadRealtimeRequest[i];
    }
}
