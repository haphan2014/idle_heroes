package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzp implements Creator<ListSubscriptionsRequest> {
    static void zza(ListSubscriptionsRequest listSubscriptionsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, listSubscriptionsRequest.getDataType(), i, false);
        zzb.zzc(parcel, 1000, listSubscriptionsRequest.getVersionCode());
        zzb.zza(parcel, 2, listSubscriptionsRequest.zzqU(), false);
        zzb.zza(parcel, 3, listSubscriptionsRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeI(x0);
    }

    public ListSubscriptionsRequest zzcO(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        DataType dataType = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            DataType dataType2;
            String str2;
            IBinder iBinder2;
            int zzaa = zza.zzaa(parcel);
            String str3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    dataType2 = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case 2:
                    dataType2 = dataType;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzaa);
                    str2 = str3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case 1000:
                    str3 = str;
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = zza.zzg(parcel, zzaa);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    str2 = str;
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzab) {
            return new ListSubscriptionsRequest(i, dataType, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ListSubscriptionsRequest[] zzeI(int i) {
        return new ListSubscriptionsRequest[i];
    }
}
