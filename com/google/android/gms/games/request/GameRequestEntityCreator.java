package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    static void zza(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, gameRequestEntity.getGame(), i, false);
        zzb.zzc(parcel, 1000, gameRequestEntity.getVersionCode());
        zzb.zza(parcel, 2, gameRequestEntity.getSender(), i, false);
        zzb.zza(parcel, 3, gameRequestEntity.getData(), false);
        zzb.zza(parcel, 4, gameRequestEntity.getRequestId(), false);
        zzb.zzc(parcel, 5, gameRequestEntity.getRecipients(), false);
        zzb.zzc(parcel, 7, gameRequestEntity.getType());
        zzb.zza(parcel, 9, gameRequestEntity.getCreationTimestamp());
        zzb.zza(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        zzb.zza(parcel, 11, gameRequestEntity.zztP(), false);
        zzb.zzc(parcel, 12, gameRequestEntity.getStatus());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfZ(x0);
    }

    public GameRequestEntity zzdQ(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    gameEntity = (GameEntity) zza.zza(parcel, zzaa, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzaa, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    arrayList = zza.zzc(parcel, zzaa, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 9:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 10:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 11:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzaa);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GameRequestEntity[] zzfZ(int i) {
        return new GameRequestEntity[i];
    }
}
