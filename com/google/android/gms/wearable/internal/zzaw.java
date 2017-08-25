package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaw implements Creator<MessageEventParcelable> {
    static void zza(MessageEventParcelable messageEventParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, messageEventParcelable.zzCY);
        zzb.zzc(parcel, 2, messageEventParcelable.getRequestId());
        zzb.zza(parcel, 3, messageEventParcelable.getPath(), false);
        zzb.zza(parcel, 4, messageEventParcelable.getData(), false);
        zzb.zza(parcel, 5, messageEventParcelable.getSourceNodeId(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkq(x0);
    }

    public MessageEventParcelable zzhi(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    bArr = zza.zzr(parcel, zzaa);
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
            return new MessageEventParcelable(i2, i, str2, bArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MessageEventParcelable[] zzkq(int i) {
        return new MessageEventParcelable[i];
    }
}
