package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, session.zzkt());
        zzb.zzc(parcel, 1000, session.getVersionCode());
        zzb.zza(parcel, 2, session.zzqs());
        zzb.zza(parcel, 3, session.getName(), false);
        zzb.zza(parcel, 4, session.getIdentifier(), false);
        zzb.zza(parcel, 5, session.getDescription(), false);
        zzb.zzc(parcel, 7, session.zzqq());
        zzb.zza(parcel, 8, session.zzqB(), i, false);
        zzb.zza(parcel, 9, session.zzqJ(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzep(x0);
    }

    public Session zzcv(Parcel parcel) {
        long j = 0;
        int i = 0;
        Long l = null;
        int zzab = zza.zzab(parcel);
        Application application = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    application = (Application) zza.zza(parcel, zzaa, Application.CREATOR);
                    break;
                case 9:
                    l = zza.zzj(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new Session(i2, j2, j, str3, str2, str, i, application, l);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public Session[] zzep(int i) {
        return new Session[i];
    }
}
