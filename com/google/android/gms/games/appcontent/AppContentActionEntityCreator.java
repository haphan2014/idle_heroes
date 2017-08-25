package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
    static void zza(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, appContentActionEntity.zzrO(), false);
        zzb.zzc(parcel, 1000, appContentActionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentActionEntity.zzrP(), false);
        zzb.zza(parcel, 3, appContentActionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentActionEntity.getType(), false);
        zzb.zza(parcel, 7, appContentActionEntity.getId(), false);
        zzb.zza(parcel, 8, appContentActionEntity.zzrN(), i, false);
        zzb.zza(parcel, 9, appContentActionEntity.zzrQ(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfs(x0);
    }

    public AppContentActionEntity zzdw(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzaa, AppContentConditionEntity.CREATOR);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) zza.zza(parcel, zzaa, AppContentAnnotationEntity.CREATOR);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AppContentActionEntity(i, arrayList, str4, bundle, str3, str2, appContentAnnotationEntity, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AppContentActionEntity[] zzfs(int i) {
        return new AppContentActionEntity[i];
    }
}
