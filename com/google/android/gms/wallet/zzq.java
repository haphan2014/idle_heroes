package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<ProxyCard> {
    static void zza(ProxyCard proxyCard, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, proxyCard.getVersionCode());
        zzb.zza(parcel, 2, proxyCard.zzaRB, false);
        zzb.zza(parcel, 3, proxyCard.zzaRC, false);
        zzb.zzc(parcel, 4, proxyCard.zzaRD);
        zzb.zzc(parcel, 5, proxyCard.zzaRE);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjs(x0);
    }

    public ProxyCard zzgq(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ProxyCard[] zzjs(int i) {
        return new ProxyCard[i];
    }
}
