package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zza {
    public boolean zza(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zzk com_google_android_gms_ads_internal_overlay_zzk) {
        if (adLauncherIntentInfoParcel == null) {
            zzb.zzaC("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.zzzf)) {
            zzb.zzaC("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.mimeType)) {
            intent.setData(Uri.parse(adLauncherIntentInfoParcel.zzzf));
        } else {
            intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.zzzf), adLauncherIntentInfoParcel.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.packageName)) {
            intent.setPackage(adLauncherIntentInfoParcel.packageName);
        }
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.zzzg)) {
            String[] split = adLauncherIntentInfoParcel.zzzg.split("/", 2);
            if (split.length < 2) {
                zzb.zzaC("Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.zzzg);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        Object obj = adLauncherIntentInfoParcel.zzzh;
        if (!TextUtils.isEmpty(obj)) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(obj);
            } catch (NumberFormatException e) {
                zzb.zzaC("Could not parse intent flags.");
                parseInt = 0;
            }
            intent.addFlags(parseInt);
        }
        try {
            zzb.zzaB("Launching an intent: " + intent.toURI());
            context.startActivity(intent);
            if (com_google_android_gms_ads_internal_overlay_zzk != null) {
                com_google_android_gms_ads_internal_overlay_zzk.zzaO();
            }
            return true;
        } catch (ActivityNotFoundException e2) {
            zzb.zzaC(e2.getMessage());
            return false;
        }
    }
}
