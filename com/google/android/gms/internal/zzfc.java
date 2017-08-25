package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzgd
public class zzfc extends Handler {
    private final zzfb zzAs;

    public zzfc(Context context) {
        this(new zzfd(context));
    }

    public zzfc(zzfb com_google_android_gms_internal_zzfb) {
        this.zzAs = com_google_android_gms_internal_zzfb;
    }

    private void zzc(JSONObject jSONObject) {
        try {
            this.zzAs.zza(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message msg) {
        try {
            Bundle data = msg.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    zzc(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
