package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae implements Creator<FileUploadPreferencesImpl> {
    static void zza(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, fileUploadPreferencesImpl.zzCY);
        zzb.zzc(parcel, 2, fileUploadPreferencesImpl.zzafG);
        zzb.zzc(parcel, 3, fileUploadPreferencesImpl.zzafH);
        zzb.zza(parcel, 4, fileUploadPreferencesImpl.zzafI);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcF(x0);
    }

    public FileUploadPreferencesImpl zzaQ(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new FileUploadPreferencesImpl(i3, i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public FileUploadPreferencesImpl[] zzcF(int i) {
        return new FileUploadPreferencesImpl[i];
    }
}
