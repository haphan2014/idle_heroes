package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;

public class zzx implements Creator<SessionStartRequest> {
    static void zza(SessionStartRequest sessionStartRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, sessionStartRequest.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionStartRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionStartRequest.zzqU(), false);
        zzb.zza(parcel, 3, sessionStartRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeR(x0);
    }

    public SessionStartRequest zzcW(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        Session session = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            Session session2;
            String str2;
            IBinder iBinder2;
            int zzaa = zza.zzaa(parcel);
            String str3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    session2 = (Session) zza.zza(parcel, zzaa, Session.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    session2 = session;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzaa);
                    str2 = str3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    str3 = str;
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = zza.zzg(parcel, zzaa);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    str2 = str;
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionStartRequest(i, session, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SessionStartRequest[] zzeR(int i) {
        return new SessionStartRequest[i];
    }
}
