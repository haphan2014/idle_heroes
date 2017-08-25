package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

public class zzf implements Creator<ProvideContentRequest> {
    static void zza(ProvideContentRequest provideContentRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, provideContentRequest.versionCode);
        zzb.zza(parcel, 2, provideContentRequest.zzaGp, false);
        zzb.zza(parcel, 3, provideContentRequest.zzxi(), false);
        zzb.zzc(parcel, 4, provideContentRequest.zzaGr, false);
        zzb.zza(parcel, 5, provideContentRequest.zzaGs);
        zzb.zza(parcel, 6, provideContentRequest.zzxa(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzir(x0);
    }

    public ProvideContentRequest zzfC(Parcel parcel) {
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j = 0;
        List list = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iBinder3 = zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzaa, SharedContent.CREATOR);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 6:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ProvideContentRequest(i, iBinder3, iBinder2, list, j, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ProvideContentRequest[] zzir(int i) {
        return new ProvideContentRequest[i];
    }
}
