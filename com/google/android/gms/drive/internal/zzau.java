package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzau implements Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onContentsResponse.zzCY);
        zzb.zza(parcel, 2, onContentsResponse.zzafa, i, false);
        zzb.zza(parcel, 3, onContentsResponse.zzage);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcO(x0);
    }

    public OnContentsResponse zzaZ(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        Contents contents = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            Contents contents2;
            int zzg;
            boolean z2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    boolean z3 = z;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzaa);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    Contents contents3 = (Contents) zza.zza(parcel, zzaa, Contents.CREATOR);
                    z2 = z;
                    contents2 = contents3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzaa);
                    contents2 = contents;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    z2 = z;
                    contents2 = contents;
                    zzg = i;
                    break;
            }
            i = zzg;
            contents = contents2;
            z = z2;
        }
        if (parcel.dataPosition() == zzab) {
            return new OnContentsResponse(i, contents, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OnContentsResponse[] zzcO(int i) {
        return new OnContentsResponse[i];
    }
}
