package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.internal.zznj.zzb;
import com.google.android.gms.internal.zznj.zzc;
import com.google.android.gms.internal.zznj.zzd;
import java.util.ArrayList;
import java.util.List;

public class zziu {
    private static DocumentSection zza(String str, zzc com_google_android_gms_internal_zznj_zzc) {
        return new DocumentSection(zzrn.zzf(com_google_android_gms_internal_zznj_zzc), new zza(str).zzJ(true).zzbs(str).zzbr("blob").zzkM());
    }

    public static UsageInfo zza(Action action, long j, String str, int i) {
        int i2;
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzkP());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent zza = zziv.zza(str, Uri.parse(bundle2.getString("url")));
        DocumentContents.zza zza2 = UsageInfo.zza(zza, string, parse, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            zza2.zza(DocumentSection.zzh(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zza2.zza(new Account(bundle.getString(".private:accountName"), GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            bundle.remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i2 = 4;
            bundle.remove(".private:isContextOnly");
        } else {
            i2 = 0;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        zza2.zza(zza(".private:action", zze(bundle)));
        return new UsageInfo.zza().zza(UsageInfo.zza(str, zza)).zzw(j).zzal(i2).zza(zza2.zzkJ()).zzL(z).zzam(i).zzkN();
    }

    static zzc zze(Bundle bundle) {
        zzc com_google_android_gms_internal_zznj_zzc = new zzc();
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            zzb com_google_android_gms_internal_zznj_zzb = new zzb();
            com_google_android_gms_internal_zznj_zzb.name = str;
            com_google_android_gms_internal_zznj_zzb.zzawp = new zzd();
            if (obj instanceof String) {
                com_google_android_gms_internal_zznj_zzb.zzawp.zzabE = (String) obj;
            } else if (obj instanceof Bundle) {
                com_google_android_gms_internal_zznj_zzb.zzawp.zzawu = zze((Bundle) obj);
            } else {
                Log.e("AppDataSearchClient", "Unsupported value: " + obj);
            }
            arrayList.add(com_google_android_gms_internal_zznj_zzb);
        }
        if (bundle.containsKey("type")) {
            com_google_android_gms_internal_zznj_zzc.type = bundle.getString("type");
        }
        com_google_android_gms_internal_zznj_zzc.zzawq = (zzb[]) arrayList.toArray(new zzb[arrayList.size()]);
        return com_google_android_gms_internal_zznj_zzc;
    }
}
