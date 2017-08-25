package com.google.android.gms.internal;

import android.content.Context;
import com.facebook.AppEventsConstants;
import com.google.android.gms.ads.internal.zzo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzed {
    public List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void zza(Context context, String str, zzha com_google_android_gms_internal_zzha, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
            for (String replaceAll : list) {
                String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", com_google_android_gms_internal_zzha.zzFm.zzxI).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", zzo.zzby().getSessionId()).replaceAll("@gw_seqnum@", com_google_android_gms_internal_zzha.zzCp);
                if (com_google_android_gms_internal_zzha.zzxZ != null) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", com_google_android_gms_internal_zzha.zzxZ.zzxt).replaceAll("@gw_allocid@", com_google_android_gms_internal_zzha.zzxZ.zzxv);
                }
                new zzhp(context, str, replaceAll2).zzgi();
            }
        }
    }
}
