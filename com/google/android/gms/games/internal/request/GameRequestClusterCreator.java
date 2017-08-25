package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    static void zza(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, gameRequestCluster.zztB(), false);
        zzb.zzc(parcel, 1000, gameRequestCluster.getVersionCode());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfP(x0);
    }

    public GameRequestCluster zzdH(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzaa, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GameRequestCluster[] zzfP(int i) {
        return new GameRequestCluster[i];
    }
}
