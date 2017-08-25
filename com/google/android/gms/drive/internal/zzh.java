package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzh implements Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, closeContentsRequest.zzCY);
        zzb.zza(parcel, 2, closeContentsRequest.zzaes, i, false);
        zzb.zza(parcel, 3, closeContentsRequest.zzaew, false);
        zzb.zzc(parcel, 4, closeContentsRequest.zzaeu);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcr(x0);
    }

    public CloseContentsRequest zzaH(Parcel parcel) {
        Boolean bool = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        Contents contents = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            Boolean bool2;
            Contents contents2;
            int zzg;
            int zzaa = zza.zzaa(parcel);
            int i3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = i;
                    bool2 = bool;
                    contents2 = contents;
                    zzg = zza.zzg(parcel, zzaa);
                    zzaa = i3;
                    break;
                case 2:
                    zzg = i2;
                    Boolean bool3 = bool;
                    contents2 = (Contents) zza.zza(parcel, zzaa, Contents.CREATOR);
                    zzaa = i;
                    bool2 = bool3;
                    break;
                case 3:
                    contents2 = contents;
                    zzg = i2;
                    i3 = i;
                    bool2 = zza.zzd(parcel, zzaa);
                    zzaa = i3;
                    break;
                case 4:
                    zzaa = zza.zzg(parcel, zzaa);
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzaa = i;
                    bool2 = bool;
                    contents2 = contents;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            contents = contents2;
            bool = bool2;
            i = zzaa;
        }
        if (parcel.dataPosition() == zzab) {
            return new CloseContentsRequest(i2, contents, bool, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CloseContentsRequest[] zzcr(int i) {
        return new CloseContentsRequest[i];
    }
}
