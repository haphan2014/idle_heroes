package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzkx;
import java.util.ArrayList;

public class zzc implements Creator<LabelValueRow> {
    static void zza(LabelValueRow labelValueRow, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, labelValueRow.getVersionCode());
        zzb.zza(parcel, 2, labelValueRow.zzaSx, false);
        zzb.zza(parcel, 3, labelValueRow.zzaSy, false);
        zzb.zzc(parcel, 4, labelValueRow.zzaSz, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjF(x0);
    }

    public LabelValueRow zzgA(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList zzoP = zzkx.zzoP();
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    zzoP = zza.zzc(parcel, zzaa, LabelValue.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LabelValueRow(i, str2, str, zzoP);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LabelValueRow[] zzjF(int i) {
        return new LabelValueRow[i];
    }
}
