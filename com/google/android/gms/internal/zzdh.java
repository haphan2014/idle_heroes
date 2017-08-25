package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.Response;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzo;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzdh implements zzdg {
    private final Context mContext;
    private final VersionInfoParcel zzoM;

    @zzgd
    static class zza {
        private final String mValue;
        private final String zztw;

        public zza(String str, String str2) {
            this.zztw = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zztw;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzgd
    static class zzb {
        private final String zzwl;
        private final URL zzwm;
        private final ArrayList<zza> zzwn;
        private final String zzwo;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzwl = str;
            this.zzwm = url;
            if (arrayList == null) {
                this.zzwn = new ArrayList();
            } else {
                this.zzwn = arrayList;
            }
            this.zzwo = str2;
        }

        public String zzdJ() {
            return this.zzwl;
        }

        public URL zzdK() {
            return this.zzwm;
        }

        public ArrayList<zza> zzdL() {
            return this.zzwn;
        }

        public String zzdM() {
            return this.zzwo;
        }
    }

    @zzgd
    class zzc {
        final /* synthetic */ zzdh zzwi;
        private final zzd zzwp;
        private final boolean zzwq;
        private final String zzwr;

        public zzc(zzdh com_google_android_gms_internal_zzdh, boolean z, zzd com_google_android_gms_internal_zzdh_zzd, String str) {
            this.zzwi = com_google_android_gms_internal_zzdh;
            this.zzwq = z;
            this.zzwp = com_google_android_gms_internal_zzdh_zzd;
            this.zzwr = str;
        }

        public String getReason() {
            return this.zzwr;
        }

        public boolean isSuccess() {
            return this.zzwq;
        }

        public zzd zzdN() {
            return this.zzwp;
        }
    }

    @zzgd
    static class zzd {
        private final String zzvj;
        private final String zzwl;
        private final int zzws;
        private final List<zza> zzwt;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzwl = str;
            this.zzws = i;
            if (list == null) {
                this.zzwt = new ArrayList();
            } else {
                this.zzwt = list;
            }
            this.zzvj = str2;
        }

        public String getBody() {
            return this.zzvj;
        }

        public int getResponseCode() {
            return this.zzws;
        }

        public String zzdJ() {
            return this.zzwl;
        }

        public Iterable<zza> zzdO() {
            return this.zzwt;
        }
    }

    public zzdh(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzoM = versionInfoParcel;
    }

    public JSONObject zzT(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = "";
            try {
                obj = jSONObject.optString("http_request_id");
                zzc zza = zza(zzb(jSONObject));
                if (zza.isSuccess()) {
                    jSONObject2.put("response", zza(zza.zzdN()));
                    jSONObject2.put(Response.SUCCESS_KEY, true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put(Response.SUCCESS_KEY, false);
                jSONObject2.put("reason", zza.getReason());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put(Response.SUCCESS_KEY, false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaz("The request is not a valid JSON.");
            try {
                return new JSONObject().put(Response.SUCCESS_KEY, false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    protected zzc zza(zzb com_google_android_gms_internal_zzdh_zzb) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) com_google_android_gms_internal_zzdh_zzb.zzdK().openConnection();
            zzo.zzbv().zza(this.mContext, this.zzoM.zzGG, false, httpURLConnection);
            Iterator it = com_google_android_gms_internal_zzdh_zzb.zzdL().iterator();
            while (it.hasNext()) {
                zza com_google_android_gms_internal_zzdh_zza = (zza) it.next();
                httpURLConnection.addRequestProperty(com_google_android_gms_internal_zzdh_zza.getKey(), com_google_android_gms_internal_zzdh_zza.getValue());
            }
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzdh_zzb.zzdM())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = com_google_android_gms_internal_zzdh_zzb.zzdM().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            List arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String com_google_android_gms_internal_zzdh_zza2 : (List) entry.getValue()) {
                        arrayList.add(new zza((String) entry.getKey(), com_google_android_gms_internal_zzdh_zza2));
                    }
                }
            }
            return new zzc(this, true, new zzd(com_google_android_gms_internal_zzdh_zzb.zzdJ(), httpURLConnection.getResponseCode(), arrayList, zzo.zzbv().zza(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new zzc(this, false, null, e.toString());
        }
    }

    protected JSONObject zza(zzd com_google_android_gms_internal_zzdh_zzd) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", com_google_android_gms_internal_zzdh_zzd.zzdJ());
            if (com_google_android_gms_internal_zzdh_zzd.getBody() != null) {
                jSONObject.put("body", com_google_android_gms_internal_zzdh_zzd.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza com_google_android_gms_internal_zzdh_zza : com_google_android_gms_internal_zzdh_zzd.zzdO()) {
                jSONArray.put(new JSONObject().put("key", com_google_android_gms_internal_zzdh_zza.getKey()).put("value", com_google_android_gms_internal_zzdh_zza.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", com_google_android_gms_internal_zzdh_zzd.getResponseCode());
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(final zzid com_google_android_gms_internal_zzid, final Map<String, String> map) {
        zzhk.zza(new Runnable(this) {
            final /* synthetic */ zzdh zzwi;

            public void run() {
                com.google.android.gms.ads.internal.util.client.zzb.zzay("Received Http request.");
                final JSONObject zzT = this.zzwi.zzT((String) map.get("http_request"));
                if (zzT == null) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaz("Response should not be null.");
                } else {
                    zzhl.zzGk.post(new Runnable(this) {
                        final /* synthetic */ C08691 zzwk;

                        public void run() {
                            com_google_android_gms_internal_zzid.zzb("fetchHttpRequestCompleted", zzT);
                            com.google.android.gms.ads.internal.util.client.zzb.zzay("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }

    protected zzb zzb(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }
}
