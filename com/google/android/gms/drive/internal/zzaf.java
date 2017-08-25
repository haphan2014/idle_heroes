package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;
import java.util.List;

public class zzaf implements Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getChangesRequest.zzCY);
        zzb.zza(parcel, 2, getChangesRequest.zzafJ, i, false);
        zzb.zzc(parcel, 3, getChangesRequest.zzafK);
        zzb.zzc(parcel, 4, getChangesRequest.zzadR, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcG(x0);
    }

    public GetChangesRequest zzaR(Parcel parcel) {
        List list = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        ChangeSequenceNumber changeSequenceNumber = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int i3;
            ChangeSequenceNumber changeSequenceNumber2;
            int zzg;
            ArrayList zzc;
            int zzaa = zza.zzaa(parcel);
            List list2;
            List list3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list2 = list;
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = zza.zzg(parcel, zzaa);
                    list3 = list2;
                    break;
                case 2:
                    zzg = i2;
                    int i4 = i;
                    changeSequenceNumber2 = (ChangeSequenceNumber) zza.zza(parcel, zzaa, ChangeSequenceNumber.CREATOR);
                    list3 = list;
                    i3 = i4;
                    break;
                case 3:
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    list2 = list;
                    i3 = zza.zzg(parcel, zzaa);
                    list3 = list2;
                    break;
                case 4:
                    zzc = zza.zzc(parcel, zzaa, DriveSpace.CREATOR);
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = list;
                    i3 = i;
                    changeSequenceNumber2 = changeSequenceNumber;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            changeSequenceNumber = changeSequenceNumber2;
            i = i3;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new GetChangesRequest(i2, changeSequenceNumber, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetChangesRequest[] zzcG(int i) {
        return new GetChangesRequest[i];
    }
}
