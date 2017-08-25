package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<ParcelableCollaborator> {
    static void zza(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, parcelableCollaborator.zzCY);
        zzb.zza(parcel, 2, parcelableCollaborator.zzais);
        zzb.zza(parcel, 3, parcelableCollaborator.zzait);
        zzb.zza(parcel, 4, parcelableCollaborator.zzFE, false);
        zzb.zza(parcel, 5, parcelableCollaborator.zzEO, false);
        zzb.zza(parcel, 6, parcelableCollaborator.zzadI, false);
        zzb.zza(parcel, 7, parcelableCollaborator.zzaiu, false);
        zzb.zza(parcel, 8, parcelableCollaborator.zzaiv, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdL(x0);
    }

    public ParcelableCollaborator zzbV(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ParcelableCollaborator[] zzdL(int i) {
        return new ParcelableCollaborator[i];
    }
}
