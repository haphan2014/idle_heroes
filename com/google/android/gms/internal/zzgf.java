package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzi.zza;
import com.google.android.gms.ads.internal.request.zzj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzdt.zzb;
import com.google.android.gms.internal.zzdt.zzc;
import com.google.android.gms.internal.zzdt.zzd;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public final class zzgf extends zza {
    private static zzgf zzDv;
    private static final Object zzoW = new Object();
    private final Context mContext;
    private final zzge zzDw;
    private final zzbr zzDx;
    private final zzdt zzqC;

    class C09285 implements zzb<zzbb> {
        final /* synthetic */ zzgf zzDH;

        C09285(zzgf com_google_android_gms_internal_zzgf) {
            this.zzDH = com_google_android_gms_internal_zzgf;
        }

        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            com_google_android_gms_internal_zzbb.zza("/log", zzdf.zzwc);
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    zzgf(Context context, zzbr com_google_android_gms_internal_zzbr, zzge com_google_android_gms_internal_zzge) {
        this.mContext = context;
        this.zzDw = com_google_android_gms_internal_zzge;
        this.zzDx = com_google_android_gms_internal_zzbr;
        this.zzqC = new zzdt(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(7571000, 7571000, true), com_google_android_gms_internal_zzbr.zzcW(), new C09285(this), new zzc());
    }

    private static AdResponseParcel zza(Context context, zzdt com_google_android_gms_internal_zzdt, zzbr com_google_android_gms_internal_zzbr, zzge com_google_android_gms_internal_zzge, AdRequestInfoParcel adRequestInfoParcel) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Starting ad request from service.");
        zzbz.zzw(context);
        final zzce com_google_android_gms_internal_zzce = new zzce("load_ad");
        zzcd zzdo = com_google_android_gms_internal_zzce.zzdo();
        com_google_android_gms_internal_zzge.zzDs.init();
        zzgk zzC = zzo.zzbB().zzC(context);
        if (zzC.zzEy == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzCE : UUID.randomUUID().toString();
        final zzgh com_google_android_gms_internal_zzgh = new zzgh(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzCm.extras != null) {
            String string = adRequestInfoParcel.zzCm.extras.getString("_ad");
            if (string != null) {
                return zzgg.zza(context, adRequestInfoParcel, string);
            }
        }
        Location zzc = com_google_android_gms_internal_zzge.zzDs.zzc(250);
        String zzc2 = com_google_android_gms_internal_zzge.zzDt.zzc(context, adRequestInfoParcel.zzCn.packageName);
        JSONObject zza = zzgg.zza(adRequestInfoParcel, zzC, zzc, com_google_android_gms_internal_zzbr, zzc2, com_google_android_gms_internal_zzge.zzDu.zzar(adRequestInfoParcel.zzCo), com_google_android_gms_internal_zzge.zzDr.zza(adRequestInfoParcel));
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza == null) {
            return new AdResponseParcel(0);
        }
        final String jSONObject = zza.toString();
        com_google_android_gms_internal_zzce.zza(zzdo, "arc");
        final zzcd zzdo2 = com_google_android_gms_internal_zzce.zzdo();
        if (((Boolean) zzbz.zztE.get()).booleanValue()) {
            final zzdt com_google_android_gms_internal_zzdt2 = com_google_android_gms_internal_zzdt;
            zzhl.zzGk.post(new Runnable() {

                class C09232 implements zzhx.zza {
                    final /* synthetic */ C09241 zzDE;

                    C09232(C09241 c09241) {
                        this.zzDE = c09241;
                    }

                    public void run() {
                    }
                }

                public void run() {
                    zzd zzdU = com_google_android_gms_internal_zzdt2.zzdU();
                    com_google_android_gms_internal_zzgh.zzb(zzdU);
                    com_google_android_gms_internal_zzce.zza(zzdo2, "rwc");
                    final zzcd zzdo = com_google_android_gms_internal_zzce.zzdo();
                    zzdU.zza(new zzhx.zzc<zzbe>(this) {
                        final /* synthetic */ C09241 zzDE;

                        public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                            com_google_android_gms_internal_zzce.zza(zzdo, "jsf");
                            com_google_android_gms_internal_zzce.zzdp();
                            com_google_android_gms_internal_zzbe.zza("/invalidRequest", com_google_android_gms_internal_zzgh.zzDO);
                            com_google_android_gms_internal_zzbe.zza("/loadAdURL", com_google_android_gms_internal_zzgh.zzDP);
                            try {
                                com_google_android_gms_internal_zzbe.zza("AFMA_buildAdURL", jSONObject);
                            } catch (Throwable e) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e);
                            }
                        }

                        public /* synthetic */ void zzc(Object obj) {
                            zzb((zzbe) obj);
                        }
                    }, new C09232(this));
                }
            });
        } else {
            final Context context2 = context;
            final AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
            final zzgh com_google_android_gms_internal_zzgh2 = com_google_android_gms_internal_zzgh;
            final zzce com_google_android_gms_internal_zzce2 = com_google_android_gms_internal_zzce;
            final zzcd com_google_android_gms_internal_zzcd = zzdo2;
            final String str = jSONObject;
            final zzbr com_google_android_gms_internal_zzbr2 = com_google_android_gms_internal_zzbr;
            zzhl.zzGk.post(new Runnable() {
                public void run() {
                    zzid zza = zzo.zzbw().zza(context2, new AdSizeParcel(), false, false, null, adRequestInfoParcel2.zzpJ);
                    if (zzo.zzby().zzge()) {
                        zza.getWebView().clearCache(true);
                    }
                    zza.setWillNotDraw(true);
                    com_google_android_gms_internal_zzgh2.zze(zza);
                    com_google_android_gms_internal_zzce2.zza(com_google_android_gms_internal_zzcd, "rwc");
                    zzie.zza zzb = zzgf.zza(str, com_google_android_gms_internal_zzce2, com_google_android_gms_internal_zzce2.zzdo());
                    zzie zzgF = zza.zzgF();
                    zzgF.zza("/invalidRequest", com_google_android_gms_internal_zzgh2.zzDO);
                    zzgF.zza("/loadAdURL", com_google_android_gms_internal_zzgh2.zzDP);
                    zzgF.zza("/log", zzdf.zzwc);
                    zzgF.zza(zzb);
                    com.google.android.gms.ads.internal.util.client.zzb.zzay("Loading the JS library.");
                    zza.loadUrl(com_google_android_gms_internal_zzbr2.zzcW());
                }
            });
        }
        AdResponseParcel adResponseParcel;
        try {
            zzgj com_google_android_gms_internal_zzgj = (zzgj) com_google_android_gms_internal_zzgh.zzfE().get(10, TimeUnit.SECONDS);
            if (com_google_android_gms_internal_zzgj == null) {
                adResponseParcel = new AdResponseParcel(0);
                return adResponseParcel;
            } else if (com_google_android_gms_internal_zzgj.getErrorCode() != -2) {
                adResponseParcel = new AdResponseParcel(com_google_android_gms_internal_zzgj.getErrorCode());
                zzhl.zzGk.post(new Runnable() {
                    public void run() {
                        com_google_android_gms_internal_zzgh.zzfF();
                        if (com_google_android_gms_internal_zzgh.zzfD() != null) {
                            com_google_android_gms_internal_zzgh.zzfD().release();
                        }
                    }
                });
                return adResponseParcel;
            } else {
                if (com_google_android_gms_internal_zzce.zzds() != null) {
                    com_google_android_gms_internal_zzce.zza(com_google_android_gms_internal_zzce.zzds(), "rur");
                }
                String str2 = null;
                if (com_google_android_gms_internal_zzgj.zzfI()) {
                    str2 = com_google_android_gms_internal_zzge.zzDq.zzaq(adRequestInfoParcel.zzCn.packageName);
                }
                zzcd zzdo3 = com_google_android_gms_internal_zzce.zzdo();
                adResponseParcel = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzpJ.zzGG, com_google_android_gms_internal_zzgj.getUrl(), str2, zzc2, com_google_android_gms_internal_zzgj);
                if (adResponseParcel.zzCW == 1) {
                    com_google_android_gms_internal_zzge.zzDt.clearToken(context, adRequestInfoParcel.zzCn.packageName);
                }
                com_google_android_gms_internal_zzce.zza(zzdo3, "ufe");
                com_google_android_gms_internal_zzce.zza(zzdo, "tts");
                if (zzhg.zzfY() != null) {
                    zzhg.zzfY().zza(com_google_android_gms_internal_zzce);
                }
                zzhl.zzGk.post(/* anonymous class already generated */);
                return adResponseParcel;
            }
        } catch (Exception e2) {
            adResponseParcel = new AdResponseParcel(0);
            return adResponseParcel;
        } finally {
            zzhl.zzGk.post(/* anonymous class already generated */);
        }
    }

    public static AdResponseParcel zza(AdRequestInfoParcel adRequestInfoParcel, Context context, String str, String str2, String str3, String str4, zzgj com_google_android_gms_internal_zzgj) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            AdResponseParcel adResponseParcel;
            zzgi com_google_android_gms_internal_zzgi = new zzgi(adRequestInfoParcel);
            com.google.android.gms.ads.internal.util.client.zzb.zzay("AdRequestServiceImpl: Sending request: " + str2);
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                zzo.zzbv().zza(context, str, false, httpURLConnection);
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    httpURLConnection.addRequestProperty("Authorization", "Bearer " + str4);
                }
                if (!(com_google_android_gms_internal_zzgj == null || TextUtils.isEmpty(com_google_android_gms_internal_zzgj.zzfH()))) {
                    httpURLConnection.setDoOutput(true);
                    byte[] bytes = com_google_android_gms_internal_zzgj.zzfH().getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.close();
                }
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < 200 || responseCode >= 300) {
                    zza(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC("No location header to follow redirect.");
                        adResponseParcel = new AdResponseParcel(0);
                        httpURLConnection.disconnect();
                        return adResponseParcel;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Too many redirects.");
                        adResponseParcel = new AdResponseParcel(0);
                        httpURLConnection.disconnect();
                        return adResponseParcel;
                    }
                    com_google_android_gms_internal_zzgi.zzi(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String zza = zzo.zzbv().zza(new InputStreamReader(httpURLConnection.getInputStream()));
                    zza(url3, headerFields, zza, responseCode);
                    com_google_android_gms_internal_zzgi.zza(url3, headerFields, zza);
                    adResponseParcel = com_google_android_gms_internal_zzgi.zzj(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return adResponseParcel;
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Received error HTTP response code: " + responseCode);
            adResponseParcel = new AdResponseParcel(0);
            httpURLConnection.disconnect();
            return adResponseParcel;
        } catch (IOException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error while connecting to ad server: " + e.getMessage());
            return new AdResponseParcel(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public static zzgf zza(Context context, zzbr com_google_android_gms_internal_zzbr, zzge com_google_android_gms_internal_zzge) {
        zzgf com_google_android_gms_internal_zzgf;
        synchronized (zzoW) {
            if (zzDv == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzDv = new zzgf(context, com_google_android_gms_internal_zzbr, com_google_android_gms_internal_zzge);
            }
            com_google_android_gms_internal_zzgf = zzDv;
        }
        return com_google_android_gms_internal_zzgf;
    }

    private static zzie.zza zza(final String str, final zzce com_google_android_gms_internal_zzce, final zzcd com_google_android_gms_internal_zzcd) {
        return new zzie.zza() {
            public void zza(zzid com_google_android_gms_internal_zzid, boolean z) {
                com_google_android_gms_internal_zzce.zza(com_google_android_gms_internal_zzcd, "jsf");
                com_google_android_gms_internal_zzce.zzdp();
                com_google_android_gms_internal_zzid.zza("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("      " + str32);
                    }
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("  Response Code:\n    " + i + "\n}");
        }
    }

    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final zzj com_google_android_gms_ads_internal_request_zzj) {
        zzo.zzby().zzb(this.mContext, adRequestInfoParcel.zzpJ);
        new zzhh(this) {
            final /* synthetic */ zzgf zzDH;

            public void onStop() {
                try {
                    com_google_android_gms_ads_internal_request_zzj.zzb(new AdResponseParcel(-1));
                } catch (Throwable e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e);
                }
            }

            public void zzdP() {
                AdResponseParcel zze;
                try {
                    zze = this.zzDH.zze(adRequestInfoParcel);
                } catch (Throwable e) {
                    zzo.zzby().zzc(e, true);
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response due to an Exception.", e);
                    zze = null;
                }
                if (zze == null) {
                    zze = new AdResponseParcel(0);
                }
                try {
                    com_google_android_gms_ads_internal_request_zzj.zzb(zze);
                } catch (Throwable e2) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e2);
                }
            }
        }.zzgi();
    }

    public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        zzhg.zze(this.mContext, adRequestInfoParcel.zzpJ.zzGG);
        return zza(this.mContext, this.zzqC, this.zzDx, this.zzDw, adRequestInfoParcel);
    }
}
