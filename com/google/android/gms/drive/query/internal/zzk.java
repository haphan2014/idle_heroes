package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzk implements Creator<LogicalFilter> {
    static void zza(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, logicalFilter.zzCY);
        zzb.zza(parcel, 1, logicalFilter.zzahQ, i, false);
        zzb.zzc(parcel, 2, logicalFilter.zzaif, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdD(x0);
    }

    public LogicalFilter zzbO(Parcel parcel) {
        List list = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            Operator operator2;
            ArrayList zzc;
            int zzaa = zza.zzaa(parcel);
            List list2;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) zza.zza(parcel, zzaa, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzaa, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    operator2 = operator;
                    i2 = zza.zzg(parcel, zzaa);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new LogicalFilter(i, operator, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LogicalFilter[] zzdD(int i) {
        return new LogicalFilter[i];
    }
}
