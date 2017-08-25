package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfy.zza;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzgb implements zza<zzf> {
    private final boolean zzBY;

    public zzgb(boolean z) {
        this.zzBY = z;
    }

    private void zza(zzfy com_google_android_gms_internal_zzfy, JSONObject jSONObject, zzkw<String, Future<zzc>> com_google_android_gms_internal_zzkw_java_lang_String__java_util_concurrent_Future_com_google_android_gms_ads_internal_formats_zzc) throws JSONException {
        com_google_android_gms_internal_zzkw_java_lang_String__java_util_concurrent_Future_com_google_android_gms_ads_internal_formats_zzc.put(jSONObject.getString("name"), com_google_android_gms_internal_zzfy.zza(jSONObject, "image_value", this.zzBY));
    }

    private void zza(JSONObject jSONObject, zzkw<String, String> com_google_android_gms_internal_zzkw_java_lang_String__java_lang_String) throws JSONException {
        com_google_android_gms_internal_zzkw_java_lang_String__java_lang_String.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    private <K, V> zzkw<K, V> zzc(zzkw<K, Future<V>> com_google_android_gms_internal_zzkw_K__java_util_concurrent_Future_V) throws InterruptedException, ExecutionException {
        zzkw<K, V> com_google_android_gms_internal_zzkw = new zzkw();
        for (int i = 0; i < com_google_android_gms_internal_zzkw_K__java_util_concurrent_Future_V.size(); i++) {
            com_google_android_gms_internal_zzkw.put(com_google_android_gms_internal_zzkw_K__java_util_concurrent_Future_V.keyAt(i), ((Future) com_google_android_gms_internal_zzkw_K__java_util_concurrent_Future_V.valueAt(i)).get());
        }
        return com_google_android_gms_internal_zzkw;
    }

    public /* synthetic */ zzg.zza zza(zzfy com_google_android_gms_internal_zzfy, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return zzd(com_google_android_gms_internal_zzfy, jSONObject);
    }

    public zzf zzd(zzfy com_google_android_gms_internal_zzfy, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        zzkw com_google_android_gms_internal_zzkw = new zzkw();
        zzkw com_google_android_gms_internal_zzkw2 = new zzkw();
        Future zze = com_google_android_gms_internal_zzfy.zze(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                zza(jSONObject2, com_google_android_gms_internal_zzkw2);
            } else if ("image".equals(string)) {
                zza(com_google_android_gms_internal_zzfy, jSONObject2, com_google_android_gms_internal_zzkw);
            } else {
                zzb.zzaC("Unknown custom asset type: " + string);
            }
        }
        return new zzf(jSONObject.getString("custom_template_id"), zzc(com_google_android_gms_internal_zzkw), com_google_android_gms_internal_zzkw2, (com.google.android.gms.ads.internal.formats.zza) zze.get());
    }
}
