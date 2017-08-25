package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public class zzj implements Creator<LoyaltyWalletObject> {
    static void zza(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, loyaltyWalletObject.getVersionCode());
        zzb.zza(parcel, 2, loyaltyWalletObject.zzhI, false);
        zzb.zza(parcel, 3, loyaltyWalletObject.zzaQM, false);
        zzb.zza(parcel, 4, loyaltyWalletObject.zzaQN, false);
        zzb.zza(parcel, 5, loyaltyWalletObject.zzaQO, false);
        zzb.zza(parcel, 6, loyaltyWalletObject.zzaBb, false);
        zzb.zza(parcel, 7, loyaltyWalletObject.zzaQP, false);
        zzb.zza(parcel, 8, loyaltyWalletObject.zzaQQ, false);
        zzb.zza(parcel, 9, loyaltyWalletObject.zzaQR, false);
        zzb.zza(parcel, 10, loyaltyWalletObject.zzaQS, false);
        zzb.zza(parcel, 11, loyaltyWalletObject.zzaQT, false);
        zzb.zzc(parcel, 12, loyaltyWalletObject.state);
        zzb.zzc(parcel, 13, loyaltyWalletObject.zzaQU, false);
        zzb.zza(parcel, 14, loyaltyWalletObject.zzaQV, i, false);
        zzb.zzc(parcel, 15, loyaltyWalletObject.zzaQW, false);
        zzb.zza(parcel, 17, loyaltyWalletObject.zzaQY, false);
        zzb.zza(parcel, 16, loyaltyWalletObject.zzaQX, false);
        zzb.zza(parcel, 19, loyaltyWalletObject.zzaRa);
        zzb.zzc(parcel, 18, loyaltyWalletObject.zzaQZ, false);
        zzb.zzc(parcel, 21, loyaltyWalletObject.zzaRc, false);
        zzb.zzc(parcel, 20, loyaltyWalletObject.zzaRb, false);
        zzb.zza(parcel, 23, loyaltyWalletObject.zzaRe, i, false);
        zzb.zzc(parcel, 22, loyaltyWalletObject.zzaRd, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjl(x0);
    }

    public LoyaltyWalletObject zzgj(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList zzoP = zzkx.zzoP();
        TimeInterval timeInterval = null;
        ArrayList zzoP2 = zzkx.zzoP();
        String str11 = null;
        String str12 = null;
        ArrayList zzoP3 = zzkx.zzoP();
        boolean z = false;
        ArrayList zzoP4 = zzkx.zzoP();
        ArrayList zzoP5 = zzkx.zzoP();
        ArrayList zzoP6 = zzkx.zzoP();
        LoyaltyPoints loyaltyPoints = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str6 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str7 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    str8 = zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    str9 = zza.zzo(parcel, zzaa);
                    break;
                case 11:
                    str10 = zza.zzo(parcel, zzaa);
                    break;
                case 12:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 13:
                    zzoP = zza.zzc(parcel, zzaa, WalletObjectMessage.CREATOR);
                    break;
                case 14:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzaa, TimeInterval.CREATOR);
                    break;
                case 15:
                    zzoP2 = zza.zzc(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = zza.zzo(parcel, zzaa);
                    break;
                case 17:
                    str12 = zza.zzo(parcel, zzaa);
                    break;
                case 18:
                    zzoP3 = zza.zzc(parcel, zzaa, LabelValueRow.CREATOR);
                    break;
                case 19:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case Place.TYPE_CAR_WASH /*20*/:
                    zzoP4 = zza.zzc(parcel, zzaa, UriData.CREATOR);
                    break;
                case Place.TYPE_CASINO /*21*/:
                    zzoP5 = zza.zzc(parcel, zzaa, TextModuleData.CREATOR);
                    break;
                case Place.TYPE_CEMETERY /*22*/:
                    zzoP6 = zza.zzc(parcel, zzaa, UriData.CREATOR);
                    break;
                case Place.TYPE_CHURCH /*23*/:
                    loyaltyPoints = (LoyaltyPoints) zza.zza(parcel, zzaa, LoyaltyPoints.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, zzoP, timeInterval, zzoP2, str11, str12, zzoP3, z, zzoP4, zzoP5, zzoP6, loyaltyPoints);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LoyaltyWalletObject[] zzjl(int i) {
        return new LoyaltyWalletObject[i];
    }
}
