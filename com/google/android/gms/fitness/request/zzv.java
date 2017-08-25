package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class zzv implements Creator<SessionReadRequest> {
    static void zza(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, sessionReadRequest.getSessionName(), false);
        zzb.zzc(parcel, 1000, sessionReadRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionReadRequest.getSessionId(), false);
        zzb.zza(parcel, 3, sessionReadRequest.zzkt());
        zzb.zza(parcel, 4, sessionReadRequest.zzqs());
        zzb.zzc(parcel, 5, sessionReadRequest.getDataTypes(), false);
        zzb.zzc(parcel, 6, sessionReadRequest.getDataSources(), false);
        zzb.zza(parcel, 7, sessionReadRequest.zzro());
        zzb.zza(parcel, 8, sessionReadRequest.zzqZ());
        zzb.zzb(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        zzb.zza(parcel, 10, sessionReadRequest.zzqU(), false);
        zzb.zza(parcel, 11, sessionReadRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeP(x0);
    }

    public SessionReadRequest zzcU(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        IBinder iBinder = null;
        String str3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzaa, DataType.CREATOR);
                    break;
                case 6:
                    list2 = zza.zzc(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 9:
                    list3 = zza.zzC(parcel, zzaa);
                    break;
                case 10:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 11:
                    str3 = zza.zzo(parcel, zzaa);
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3, iBinder, str3);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SessionReadRequest[] zzeP(int i) {
        return new SessionReadRequest[i];
    }
}
