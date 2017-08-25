package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<RewardedVideoAdRequestParcel> {
    static void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, rewardedVideoAdRequestParcel.versionCode);
        zzb.zza(parcel, 2, rewardedVideoAdRequestParcel.zzCm, i, false);
        zzb.zza(parcel, 3, rewardedVideoAdRequestParcel.zzpG, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzH(x0);
    }

    public RewardedVideoAdRequestParcel[] zzH(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    public RewardedVideoAdRequestParcel zzn(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        AdRequestParcel adRequestParcel = null;
        while (parcel.dataPosition() < zzab) {
            AdRequestParcel adRequestParcel2;
            int zzg;
            String str2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    String str3 = str;
                    adRequestParcel2 = adRequestParcel;
                    zzg = zza.zzg(parcel, zzaa);
                    str2 = str3;
                    break;
                case 2:
                    zzg = i;
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) zza.zza(parcel, zzaa, AdRequestParcel.CREATOR);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    adRequestParcel2 = adRequestParcel;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel;
                    zzg = i;
                    break;
            }
            i = zzg;
            adRequestParcel = adRequestParcel2;
            str = str2;
        }
        if (parcel.dataPosition() == zzab) {
            return new RewardedVideoAdRequestParcel(i, adRequestParcel, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
