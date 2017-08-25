package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<UnpublishRequest> {
    static void zza(UnpublishRequest unpublishRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, unpublishRequest.zzCY);
        zzb.zza(parcel, 2, unpublishRequest.zzaGb, i, false);
        zzb.zza(parcel, 3, unpublishRequest.zzxa(), false);
        zzb.zza(parcel, 4, unpublishRequest.zzayp, false);
        zzb.zza(parcel, 5, unpublishRequest.zzaGe, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzil(x0);
    }

    public UnpublishRequest zzfw(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str2 = null;
        IBinder iBinder = null;
        MessageWrapper messageWrapper = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    messageWrapper = (MessageWrapper) zza.zza(parcel, zzaa, MessageWrapper.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new UnpublishRequest(i, messageWrapper, iBinder, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public UnpublishRequest[] zzil(int i) {
        return new UnpublishRequest[i];
    }
}
