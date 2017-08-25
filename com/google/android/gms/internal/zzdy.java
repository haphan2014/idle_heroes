package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public final class zzdy {
    public final List<zzdx> zzxD;
    public final long zzxE;
    public final List<String> zzxF;
    public final List<String> zzxG;
    public final List<String> zzxH;
    public final String zzxI;
    public final long zzxJ;
    public final String zzxK;
    public final int zzxL;
    public int zzxM;
    public int zzxN;

    public zzdy(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (zzb.zzL(2)) {
            zzb.zzaB("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzdx com_google_android_gms_internal_zzdx = new zzdx(jSONArray.getJSONObject(i2));
            arrayList.add(com_google_android_gms_internal_zzdx);
            if (i < 0 && zza(com_google_android_gms_internal_zzdx)) {
                i = i2;
            }
        }
        this.zzxM = i;
        this.zzxN = jSONArray.length();
        this.zzxD = Collections.unmodifiableList(arrayList);
        this.zzxI = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzxE = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.zzxF = zzo.zzbG().zza(optJSONObject, "click_urls");
            this.zzxG = zzo.zzbG().zza(optJSONObject, "imp_urls");
            this.zzxH = zzo.zzbG().zza(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzxJ = optLong > 0 ? optLong * 1000 : -1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("rewards");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                this.zzxK = null;
                this.zzxL = 0;
                return;
            }
            this.zzxK = optJSONArray.getJSONObject(0).optString("rb_type");
            this.zzxL = optJSONArray.getJSONObject(0).optInt("rb_amount");
            return;
        }
        this.zzxE = -1;
        this.zzxF = null;
        this.zzxG = null;
        this.zzxH = null;
        this.zzxJ = -1;
        this.zzxK = null;
        this.zzxL = 0;
    }

    private boolean zza(zzdx com_google_android_gms_internal_zzdx) {
        for (String equals : com_google_android_gms_internal_zzdx.zzxu) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
