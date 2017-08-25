package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.Place;
import java.util.List;

public class zzf implements Creator<AdRequestInfoParcel> {
    static void zza(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, adRequestInfoParcel.versionCode);
        zzb.zza(parcel, 2, adRequestInfoParcel.zzCl, false);
        zzb.zza(parcel, 3, adRequestInfoParcel.zzCm, i, false);
        zzb.zza(parcel, 4, adRequestInfoParcel.zzpN, i, false);
        zzb.zza(parcel, 5, adRequestInfoParcel.zzpG, false);
        zzb.zza(parcel, 6, adRequestInfoParcel.applicationInfo, i, false);
        zzb.zza(parcel, 7, adRequestInfoParcel.zzCn, i, false);
        zzb.zza(parcel, 8, adRequestInfoParcel.zzCo, false);
        zzb.zza(parcel, 9, adRequestInfoParcel.zzCp, false);
        zzb.zza(parcel, 10, adRequestInfoParcel.zzCq, false);
        zzb.zza(parcel, 11, adRequestInfoParcel.zzpJ, i, false);
        zzb.zza(parcel, 12, adRequestInfoParcel.zzCr, false);
        zzb.zzc(parcel, 13, adRequestInfoParcel.zzCs);
        zzb.zzb(parcel, 14, adRequestInfoParcel.zzqd, false);
        zzb.zza(parcel, 15, adRequestInfoParcel.zzCt, false);
        zzb.zza(parcel, 17, adRequestInfoParcel.zzCv, i, false);
        zzb.zza(parcel, 16, adRequestInfoParcel.zzCu);
        zzb.zzc(parcel, 19, adRequestInfoParcel.zzCx);
        zzb.zzc(parcel, 18, adRequestInfoParcel.zzCw);
        zzb.zza(parcel, 21, adRequestInfoParcel.zzCz, false);
        zzb.zza(parcel, 20, adRequestInfoParcel.zzCy);
        zzb.zzc(parcel, 23, adRequestInfoParcel.zzCB);
        zzb.zza(parcel, 22, adRequestInfoParcel.zzCA);
        zzb.zza(parcel, 25, adRequestInfoParcel.zzCD);
        zzb.zza(parcel, 24, adRequestInfoParcel.zzCC, false);
        zzb.zzb(parcel, 27, adRequestInfoParcel.zzCF, false);
        zzb.zza(parcel, 26, adRequestInfoParcel.zzCE, false);
        zzb.zza(parcel, 29, adRequestInfoParcel.zzqb, i, false);
        zzb.zza(parcel, 28, adRequestInfoParcel.zzpF, false);
        zzb.zzb(parcel, 30, adRequestInfoParcel.zzCG, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzC(x0);
    }

    public AdRequestInfoParcel[] zzC(int i) {
        return new AdRequestInfoParcel[i];
    }

    public AdRequestInfoParcel zzj(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        Bundle bundle = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        boolean z2 = false;
        int i5 = 0;
        String str6 = null;
        long j = 0;
        String str7 = null;
        List list2 = null;
        String str8 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        List list3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 3:
                    adRequestParcel = (AdRequestParcel) zza.zza(parcel, zzaa, AdRequestParcel.CREATOR);
                    break;
                case 4:
                    adSizeParcel = (AdSizeParcel) zza.zza(parcel, zzaa, AdSizeParcel.CREATOR);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zza.zza(parcel, zzaa, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zza.zza(parcel, zzaa, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 10:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzaa, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundle2 = zza.zzq(parcel, zzaa);
                    break;
                case 13:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 14:
                    list = zza.zzC(parcel, zzaa);
                    break;
                case 15:
                    bundle3 = zza.zzq(parcel, zzaa);
                    break;
                case 16:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 17:
                    messenger = (Messenger) zza.zza(parcel, zzaa, Messenger.CREATOR);
                    break;
                case 18:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 19:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case Place.TYPE_CAR_WASH /*20*/:
                    f = zza.zzl(parcel, zzaa);
                    break;
                case Place.TYPE_CASINO /*21*/:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case Place.TYPE_CEMETERY /*22*/:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case Place.TYPE_CHURCH /*23*/:
                    i5 = zza.zzg(parcel, zzaa);
                    break;
                case Place.TYPE_CITY_HALL /*24*/:
                    str6 = zza.zzo(parcel, zzaa);
                    break;
                case Place.TYPE_CLOTHING_STORE /*25*/:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case Place.TYPE_CONVENIENCE_STORE /*26*/:
                    str7 = zza.zzo(parcel, zzaa);
                    break;
                case Place.TYPE_COURTHOUSE /*27*/:
                    list2 = zza.zzC(parcel, zzaa);
                    break;
                case Place.TYPE_DENTIST /*28*/:
                    str8 = zza.zzo(parcel, zzaa);
                    break;
                case Place.TYPE_DEPARTMENT_STORE /*29*/:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) zza.zza(parcel, zzaa, (Creator) NativeAdOptionsParcel.CREATOR);
                    break;
                case 30:
                    list3 = zza.zzC(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, list, bundle3, z, messenger, i3, i4, f, str5, z2, i5, str6, j, str7, list2, str8, nativeAdOptionsParcel, list3);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
