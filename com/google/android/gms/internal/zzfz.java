package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.internal.zzfy.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzfz implements zza<zzd> {
    private final boolean zzBY;
    private final boolean zzBZ;

    public zzfz(boolean z, boolean z2) {
        this.zzBY = z;
        this.zzBZ = z2;
    }

    public /* synthetic */ zzg.zza zza(zzfy com_google_android_gms_internal_zzfy, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return zzb(com_google_android_gms_internal_zzfy, jSONObject);
    }

    public zzd zzb(zzfy com_google_android_gms_internal_zzfy, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zzhv> zza = com_google_android_gms_internal_zzfy.zza(jSONObject, "images", true, this.zzBY, this.zzBZ);
        Future zza2 = com_google_android_gms_internal_zzfy.zza(jSONObject, "app_icon", true, this.zzBY);
        Future zze = com_google_android_gms_internal_zzfy.zze(jSONObject);
        List arrayList = new ArrayList();
        for (zzhv com_google_android_gms_internal_zzhv : zza) {
            arrayList.add(com_google_android_gms_internal_zzhv.get());
        }
        return new zzd(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzc) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (com.google.android.gms.ads.internal.formats.zza) zze.get());
    }
}
