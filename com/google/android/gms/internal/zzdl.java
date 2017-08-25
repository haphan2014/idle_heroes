package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzgd
public class zzdl implements zzdg {
    final HashMap<String, zzhs<JSONObject>> zzwv = new HashMap();

    public Future<JSONObject> zzU(String str) {
        Future com_google_android_gms_internal_zzhs = new zzhs();
        this.zzwv.put(str, com_google_android_gms_internal_zzhs);
        return com_google_android_gms_internal_zzhs;
    }

    public void zzV(String str) {
        zzhs com_google_android_gms_internal_zzhs = (zzhs) this.zzwv.get(str);
        if (com_google_android_gms_internal_zzhs == null) {
            zzb.zzaz("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!com_google_android_gms_internal_zzhs.isDone()) {
            com_google_android_gms_internal_zzhs.cancel(true);
        }
        this.zzwv.remove(str);
    }

    public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
        zze((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public void zze(String str, String str2) {
        zzb.zzay("Received ad from the cache.");
        zzhs com_google_android_gms_internal_zzhs = (zzhs) this.zzwv.get(str);
        if (com_google_android_gms_internal_zzhs == null) {
            zzb.zzaz("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            com_google_android_gms_internal_zzhs.zzf(new JSONObject(str2));
        } catch (Throwable e) {
            zzb.zzb("Failed constructing JSON object from value passed from javascript", e);
            com_google_android_gms_internal_zzhs.zzf(null);
        } finally {
            this.zzwv.remove(str);
        }
    }
}
