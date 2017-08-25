package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<Response> {
    static void zza(Response response, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, response.zzCY);
        zzb.zza(parcel, 1, response.zzNn, i, false);
        zzb.zzc(parcel, 2, response.zzNo, false);
        zzb.zza(parcel, 3, response.zzNp, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzah(x0);
    }

    public Response[] zzah(int i) {
        return new Response[i];
    }

    public Response zzw(Parcel parcel) {
        String[] strArr = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list = null;
        Status status = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            Status status2;
            String[] strArr2;
            List list2;
            int zzaa = zza.zzaa(parcel);
            String[] strArr3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    List list3 = list;
                    status2 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    strArr2 = strArr;
                    list2 = list3;
                    break;
                case 2:
                    status2 = status;
                    i2 = i;
                    strArr3 = strArr;
                    Object zzc = zza.zzc(parcel, zzaa, UsageInfo.CREATOR);
                    strArr2 = strArr3;
                    break;
                case 3:
                    strArr2 = zza.zzA(parcel, zzaa);
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    strArr3 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzaa);
                    strArr2 = strArr3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    strArr2 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            list = list2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == zzab) {
            return new Response(i, status, list, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
