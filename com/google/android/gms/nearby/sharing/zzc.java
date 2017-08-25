package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<SharedContent> {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        zzb.zza(parcel, 3, sharedContent.getUri(), false);
        zzb.zza(parcel, 8, sharedContent.zzxe(), i, false);
        zzb.zza(parcel, 9, sharedContent.zzxf(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzip(x0);
    }

    public SharedContent zzfA(Parcel parcel) {
        LocalContent[] localContentArr = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        ViewableItem[] viewableItemArr = null;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            ViewableItem[] viewableItemArr2;
            String str2;
            int zzg;
            LocalContent[] localContentArr2;
            int zzaa = zza.zzaa(parcel);
            LocalContent[] localContentArr3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    localContentArr3 = localContentArr;
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = zza.zzg(parcel, zzaa);
                    localContentArr2 = localContentArr3;
                    break;
                case 3:
                    zzg = i;
                    ViewableItem[] viewableItemArr3 = viewableItemArr;
                    str2 = zza.zzo(parcel, zzaa);
                    localContentArr2 = localContentArr;
                    viewableItemArr2 = viewableItemArr3;
                    break;
                case 8:
                    str2 = str;
                    zzg = i;
                    localContentArr3 = localContentArr;
                    viewableItemArr2 = (ViewableItem[]) zza.zzb(parcel, zzaa, ViewableItem.CREATOR);
                    localContentArr2 = localContentArr3;
                    break;
                case 9:
                    localContentArr2 = (LocalContent[]) zza.zzb(parcel, zzaa, LocalContent.CREATOR);
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    localContentArr2 = localContentArr;
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = i;
                    break;
            }
            i = zzg;
            str = str2;
            viewableItemArr = viewableItemArr2;
            localContentArr = localContentArr2;
        }
        if (parcel.dataPosition() == zzab) {
            return new SharedContent(i, str, viewableItemArr, localContentArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SharedContent[] zzip(int i) {
        return new SharedContent[i];
    }
}
