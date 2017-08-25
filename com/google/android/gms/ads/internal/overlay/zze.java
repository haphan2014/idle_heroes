package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<AdOverlayInfoParcel> {
    static void zza(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, adOverlayInfoParcel.versionCode);
        zzb.zza(parcel, 2, adOverlayInfoParcel.zzzB, i, false);
        zzb.zza(parcel, 3, adOverlayInfoParcel.zzex(), false);
        zzb.zza(parcel, 4, adOverlayInfoParcel.zzey(), false);
        zzb.zza(parcel, 5, adOverlayInfoParcel.zzez(), false);
        zzb.zza(parcel, 6, adOverlayInfoParcel.zzeA(), false);
        zzb.zza(parcel, 7, adOverlayInfoParcel.zzzG, false);
        zzb.zza(parcel, 8, adOverlayInfoParcel.zzzH);
        zzb.zza(parcel, 9, adOverlayInfoParcel.zzzI, false);
        zzb.zza(parcel, 10, adOverlayInfoParcel.zzeC(), false);
        zzb.zzc(parcel, 11, adOverlayInfoParcel.orientation);
        zzb.zzc(parcel, 12, adOverlayInfoParcel.zzzK);
        zzb.zza(parcel, 13, adOverlayInfoParcel.zzzf, false);
        zzb.zza(parcel, 14, adOverlayInfoParcel.zzpJ, i, false);
        zzb.zza(parcel, 15, adOverlayInfoParcel.zzeB(), false);
        zzb.zza(parcel, 17, adOverlayInfoParcel.zzzN, i, false);
        zzb.zza(parcel, 16, adOverlayInfoParcel.zzzM, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzw(x0);
    }

    public AdOverlayInfoParcel zzh(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) zza.zza(parcel, zzaa, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 5:
                    iBinder3 = zza.zzp(parcel, zzaa);
                    break;
                case 6:
                    iBinder4 = zza.zzp(parcel, zzaa);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 9:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    iBinder5 = zza.zzp(parcel, zzaa);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 13:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzaa, (Creator) VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = zza.zzp(parcel, zzaa);
                    break;
                case 16:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) zza.zza(parcel, zzaa, (Creator) InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AdOverlayInfoParcel[] zzw(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
