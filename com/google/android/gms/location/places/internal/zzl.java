package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<PlaceLikelihoodEntity> {
    static void zza(PlaceLikelihoodEntity placeLikelihoodEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, placeLikelihoodEntity.zzaAK, i, false);
        zzb.zzc(parcel, 1000, placeLikelihoodEntity.zzCY);
        zzb.zza(parcel, 2, placeLikelihoodEntity.zzaAL);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzez(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgZ(x0);
    }

    public PlaceLikelihoodEntity zzez(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        PlaceImpl placeImpl = null;
        float f = 0.0f;
        while (parcel.dataPosition() < zzab) {
            int i2;
            float f2;
            PlaceImpl placeImpl2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    PlaceImpl placeImpl3 = (PlaceImpl) zza.zza(parcel, zzaa, PlaceImpl.CREATOR);
                    f2 = f;
                    placeImpl2 = placeImpl3;
                    break;
                case 2:
                    f2 = zza.zzl(parcel, zzaa);
                    placeImpl2 = placeImpl;
                    i2 = i;
                    break;
                case 1000:
                    float f3 = f;
                    placeImpl2 = placeImpl;
                    i2 = zza.zzg(parcel, zzaa);
                    f2 = f3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    f2 = f;
                    placeImpl2 = placeImpl;
                    i2 = i;
                    break;
            }
            i = i2;
            placeImpl = placeImpl2;
            f = f2;
        }
        if (parcel.dataPosition() == zzab) {
            return new PlaceLikelihoodEntity(i, placeImpl, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public PlaceLikelihoodEntity[] zzgZ(int i) {
        return new PlaceLikelihoodEntity[i];
    }
}
