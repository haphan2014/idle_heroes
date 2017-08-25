package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<LineItem> {
    static void zza(LineItem lineItem, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, lineItem.getVersionCode());
        zzb.zza(parcel, 2, lineItem.description, false);
        zzb.zza(parcel, 3, lineItem.zzaQI, false);
        zzb.zza(parcel, 4, lineItem.zzaQJ, false);
        zzb.zza(parcel, 5, lineItem.zzaQf, false);
        zzb.zzc(parcel, 6, lineItem.zzaQK);
        zzb.zza(parcel, 7, lineItem.zzaQg, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjk(x0);
    }

    public LineItem zzgi(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LineItem[] zzjk(int i) {
        return new LineItem[i];
    }
}
