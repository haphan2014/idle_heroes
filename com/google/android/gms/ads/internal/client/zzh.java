package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<AdSizeParcel> {
    static void zza(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, adSizeParcel.versionCode);
        zzb.zza(parcel, 2, adSizeParcel.zzsm, false);
        zzb.zzc(parcel, 3, adSizeParcel.height);
        zzb.zzc(parcel, 4, adSizeParcel.heightPixels);
        zzb.zza(parcel, 5, adSizeParcel.zzsn);
        zzb.zzc(parcel, 6, adSizeParcel.width);
        zzb.zzc(parcel, 7, adSizeParcel.widthPixels);
        zzb.zza(parcel, 8, adSizeParcel.zzso, i, false);
        zzb.zza(parcel, 9, adSizeParcel.zzsp);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzl(x0);
    }

    public AdSizeParcel zzc(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i5 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) zza.zzb(parcel, zzaa, AdSizeParcel.CREATOR);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AdSizeParcel(i5, str, i4, i3, z2, i2, i, adSizeParcelArr, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AdSizeParcel[] zzl(int i) {
        return new AdSizeParcel[i];
    }
}
