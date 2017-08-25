package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    static void zza(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, milestoneEntity.getMilestoneId(), false);
        zzb.zzc(parcel, 1000, milestoneEntity.getVersionCode());
        zzb.zza(parcel, 2, milestoneEntity.getCurrentProgress());
        zzb.zza(parcel, 3, milestoneEntity.getTargetProgress());
        zzb.zza(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        zzb.zzc(parcel, 5, milestoneEntity.getState());
        zzb.zza(parcel, 6, milestoneEntity.getEventId(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfX(x0);
    }

    public MilestoneEntity zzdO(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MilestoneEntity[] zzfX(int i) {
        return new MilestoneEntity[i];
    }
}
