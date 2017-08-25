package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<BitmapDescriptorParcelable> {
    static void zza(BitmapDescriptorParcelable bitmapDescriptorParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, bitmapDescriptorParcelable.getVersionCode());
        zzb.zza(parcel, 2, bitmapDescriptorParcelable.getType());
        zzb.zza(parcel, 3, bitmapDescriptorParcelable.getParameters(), false);
        zzb.zza(parcel, 4, bitmapDescriptorParcelable.getBitmap(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhA(x0);
    }

    public BitmapDescriptorParcelable zzfa(Parcel parcel) {
        Bitmap bitmap = null;
        byte b = (byte) 0;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        Bundle bundle = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 3:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzaa);
                    break;
                case 4:
                    bitmap = (Bitmap) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Bitmap.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new BitmapDescriptorParcelable(i, b, bundle, bitmap);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public BitmapDescriptorParcelable[] zzhA(int i) {
        return new BitmapDescriptorParcelable[i];
    }
}
