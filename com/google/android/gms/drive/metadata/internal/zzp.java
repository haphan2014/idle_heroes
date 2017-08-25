package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzp extends zzj<UserMetadata> {
    public zzp(String str, int i) {
        super(str, zzcz(str), Collections.emptyList(), i);
    }

    private String zzcy(String str) {
        return zzw(getName(), str);
    }

    private static Collection<String> zzcz(String str) {
        return Arrays.asList(new String[]{zzw(str, "permissionId"), zzw(str, "displayName"), zzw(str, "picture"), zzw(str, "isAuthenticatedUser"), zzw(str, "emailAddress")});
    }

    private static String zzw(String str, String str2) {
        return str + "." + str2;
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzbV(zzcy("permissionId")) && !dataHolder.zzi(zzcy("permissionId"), i, i2);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzj(dataHolder, i, i2);
    }

    protected UserMetadata zzj(DataHolder dataHolder, int i, int i2) {
        String zzd = dataHolder.zzd(zzcy("permissionId"), i, i2);
        if (zzd == null) {
            return null;
        }
        String zzd2 = dataHolder.zzd(zzcy("displayName"), i, i2);
        String zzd3 = dataHolder.zzd(zzcy("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.zze(zzcy("isAuthenticatedUser"), i, i2));
        return new UserMetadata(zzd, zzd2, zzd3, valueOf.booleanValue(), dataHolder.zzd(zzcy("emailAddress"), i, i2));
    }
}
