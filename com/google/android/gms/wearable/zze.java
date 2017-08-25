package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<ConnectionConfiguration> {
    static void zza(ConnectionConfiguration connectionConfiguration, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, connectionConfiguration.zzCY);
        zzb.zza(parcel, 2, connectionConfiguration.getName(), false);
        zzb.zza(parcel, 3, connectionConfiguration.getAddress(), false);
        zzb.zzc(parcel, 4, connectionConfiguration.getType());
        zzb.zzc(parcel, 5, connectionConfiguration.getRole());
        zzb.zza(parcel, 6, connectionConfiguration.isEnabled());
        zzb.zza(parcel, 7, connectionConfiguration.isConnected());
        zzb.zza(parcel, 8, connectionConfiguration.zzAP(), false);
        zzb.zza(parcel, 9, connectionConfiguration.zzAQ());
        zzb.zza(parcel, 10, connectionConfiguration.getNodeId(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjN(x0);
    }

    public ConnectionConfiguration zzgI(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    z3 = zza.zzc(parcel, zzaa);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 10:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ConnectionConfiguration(i3, str4, str3, i2, i, z3, z2, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ConnectionConfiguration[] zzjN(int i) {
        return new ConnectionConfiguration[i];
    }
}
