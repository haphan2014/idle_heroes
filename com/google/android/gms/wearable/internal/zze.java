package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<AncsNotificationParcelable> {
    static void zza(AncsNotificationParcelable ancsNotificationParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, ancsNotificationParcelable.zzCY);
        zzb.zzc(parcel, 2, ancsNotificationParcelable.getId());
        zzb.zza(parcel, 3, ancsNotificationParcelable.zzsK(), false);
        zzb.zza(parcel, 4, ancsNotificationParcelable.zzAU(), false);
        zzb.zza(parcel, 5, ancsNotificationParcelable.zzAV(), false);
        zzb.zza(parcel, 6, ancsNotificationParcelable.getTitle(), false);
        zzb.zza(parcel, 7, ancsNotificationParcelable.zzsb(), false);
        zzb.zza(parcel, 8, ancsNotificationParcelable.getDisplayName(), false);
        zzb.zza(parcel, 9, ancsNotificationParcelable.zzAW());
        zzb.zza(parcel, 10, ancsNotificationParcelable.zzAX());
        zzb.zza(parcel, 11, ancsNotificationParcelable.zzAY());
        zzb.zza(parcel, 12, ancsNotificationParcelable.zzAZ());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjR(x0);
    }

    public AncsNotificationParcelable zzgM(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b = (byte) 0;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str6 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    b = zza.zze(parcel, zzaa);
                    break;
                case 10:
                    b2 = zza.zze(parcel, zzaa);
                    break;
                case 11:
                    b3 = zza.zze(parcel, zzaa);
                    break;
                case 12:
                    b4 = zza.zze(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AncsNotificationParcelable(i, i2, str, str2, str3, str4, str5, str6, b, b2, b3, b4);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AncsNotificationParcelable[] zzjR(int i) {
        return new AncsNotificationParcelable[i];
    }
}
