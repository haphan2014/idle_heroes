package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz implements Creator<SessionUnregistrationRequest> {
    static void zza(SessionUnregistrationRequest sessionUnregistrationRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, sessionUnregistrationRequest.zzrg(), i, false);
        zzb.zzc(parcel, 1000, sessionUnregistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionUnregistrationRequest.zzqU(), false);
        zzb.zza(parcel, 3, sessionUnregistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeT(x0);
    }

    public SessionUnregistrationRequest zzcY(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            PendingIntent pendingIntent2;
            String str2;
            IBinder iBinder2;
            int zzaa = zza.zzaa(parcel);
            String str3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    pendingIntent2 = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzaa);
                    str2 = str3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
                case 1000:
                    str3 = str;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = zza.zzg(parcel, zzaa);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    str2 = str;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
            }
            i = i2;
            pendingIntent = pendingIntent2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionUnregistrationRequest(i, pendingIntent, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SessionUnregistrationRequest[] zzeT(int i) {
        return new SessionUnregistrationRequest[i];
    }
}
