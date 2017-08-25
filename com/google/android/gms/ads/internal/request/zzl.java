package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzdt.zzd;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzl extends zzhh {
    static final long zzDf = TimeUnit.SECONDS.toMillis(10);
    private static boolean zzDg = false;
    private static zzdt zzDh = null;
    private static zzdh zzDi = null;
    private static zzdl zzDj = null;
    private static zzdg zzDk = null;
    private static final Object zzoW = new Object();
    private final Context mContext;
    private final Object zzBr = new Object();
    private final com.google.android.gms.ads.internal.request.zza.zza zzCd;
    private final com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zzCe;
    private zzd zzDl;

    class C03673 implements Runnable {
        final /* synthetic */ zzl zzDm;

        C03673(zzl com_google_android_gms_ads_internal_request_zzl) {
            this.zzDm = com_google_android_gms_ads_internal_request_zzl;
        }

        public void run() {
            if (this.zzDm.zzDl != null) {
                this.zzDm.zzDl.release();
                this.zzDm.zzDl = null;
            }
        }
    }

    public static class zza implements com.google.android.gms.internal.zzdt.zzb<zzbb> {
        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            zzl.zzd(com_google_android_gms_internal_zzbb);
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    public static class zzb implements com.google.android.gms.internal.zzdt.zzb<zzbb> {
        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            zzl.zzc(com_google_android_gms_internal_zzbb);
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    public static class zzc implements zzdg {
        public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
            String str = (String) map.get("request_id");
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Invalid request: " + ((String) map.get("errors")));
            zzl.zzDj.zzV(str);
        }
    }

    public zzl(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, com.google.android.gms.ads.internal.request.zza.zza com_google_android_gms_ads_internal_request_zza_zza) {
        this.zzCd = com_google_android_gms_ads_internal_request_zza_zza;
        this.mContext = context;
        this.zzCe = com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza;
        synchronized (zzoW) {
            if (!zzDg) {
                zzDj = new zzdl();
                zzDi = new zzdh(context.getApplicationContext(), com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzpJ);
                zzDk = new zzc();
                zzDh = new zzdt(this.mContext.getApplicationContext(), this.zzCe.zzpJ, (String) zzbz.zztD.get(), new zzb(), new zza());
                zzDg = true;
            }
        }
    }

    private JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, String str) {
        Info advertisingIdInfo;
        Throwable e;
        Object obj;
        Map hashMap;
        JSONObject jSONObject = null;
        Bundle bundle = adRequestInfoParcel.zzCm.extras.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.zzCm.extras.getString("sdk_less_network_id");
        if (bundle != null) {
            JSONObject zza = zzgg.zza(adRequestInfoParcel, zzo.zzbB().zzC(this.mContext), jSONObject, new zzbr((String) zzbz.zztD.get()), jSONObject, jSONObject, new ArrayList());
            if (zza != null) {
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
                } catch (IOException e2) {
                    e = e2;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzo.zzbv().zzy(hashMap);
                    return jSONObject;
                } catch (IllegalStateException e3) {
                    e = e3;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzo.zzbv().zzy(hashMap);
                    return jSONObject;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    e = e4;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzo.zzbv().zzy(hashMap);
                    return jSONObject;
                } catch (GooglePlayServicesRepairableException e5) {
                    e = e5;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzo.zzbv().zzy(hashMap);
                    return jSONObject;
                }
                hashMap = new HashMap();
                hashMap.put("request_id", str);
                hashMap.put("network_id", string);
                hashMap.put("request_param", zza);
                hashMap.put("data", bundle);
                if (advertisingIdInfo != null) {
                    hashMap.put("adid", advertisingIdInfo.getId());
                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                    }
                    hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                }
                try {
                    jSONObject = zzo.zzbv().zzy(hashMap);
                } catch (JSONException e6) {
                }
            }
        }
        return jSONObject;
    }

    protected static void zzc(zzbb com_google_android_gms_internal_zzbb) {
        com_google_android_gms_internal_zzbb.zza("/loadAd", zzDj);
        com_google_android_gms_internal_zzbb.zza("/fetchHttpRequest", zzDi);
        com_google_android_gms_internal_zzbb.zza("/invalidRequest", zzDk);
    }

    protected static void zzd(zzbb com_google_android_gms_internal_zzbb) {
        com_google_android_gms_internal_zzbb.zzb("/loadAd", zzDj);
        com_google_android_gms_internal_zzbb.zzb("/fetchHttpRequest", zzDi);
        com_google_android_gms_internal_zzbb.zzb("/invalidRequest", zzDk);
    }

    private AdResponseParcel zzf(AdRequestInfoParcel adRequestInfoParcel) {
        final String uuid = UUID.randomUUID().toString();
        final JSONObject zza = zza(adRequestInfoParcel, uuid);
        if (zza == null) {
            return new AdResponseParcel(0);
        }
        long elapsedRealtime = zzo.zzbz().elapsedRealtime();
        Future zzU = zzDj.zzU(uuid);
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzl zzDm;

            class C03641 implements com.google.android.gms.internal.zzhx.zzc<zzbe> {
                final /* synthetic */ C03662 zzDp;

                C03641(C03662 c03662) {
                    this.zzDp = c03662;
                }

                public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                    try {
                        com_google_android_gms_internal_zzbe.zza("AFMA_getAdapterLessMediationAd", zza);
                    } catch (Throwable e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e);
                        zzl.zzDj.zzV(uuid);
                    }
                }

                public /* synthetic */ void zzc(Object obj) {
                    zzb((zzbe) obj);
                }
            }

            class C03652 implements com.google.android.gms.internal.zzhx.zza {
                final /* synthetic */ C03662 zzDp;

                C03652(C03662 c03662) {
                    this.zzDp = c03662;
                }

                public void run() {
                    zzl.zzDj.zzV(uuid);
                }
            }

            public void run() {
                this.zzDm.zzDl = zzl.zzDh.zzdU();
                this.zzDm.zzDl.zza(new C03641(this), new C03652(this));
            }
        });
        try {
            JSONObject jSONObject = (JSONObject) zzU.get(zzDf - (zzo.zzbz().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel zza2 = zzgg.zza(this.mContext, adRequestInfoParcel, jSONObject.toString());
            return (zza2.errorCode == -3 || !TextUtils.isEmpty(zza2.zzCI)) ? zza2 : new AdResponseParcel(3);
        } catch (CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (InterruptedException e2) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e3) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e4) {
            return new AdResponseParcel(0);
        }
    }

    public void onStop() {
        synchronized (this.zzBr) {
            com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new C03673(this));
        }
    }

    public void zzdP() {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzCe, null, null);
        AdResponseParcel zzf = zzf(adRequestInfoParcel);
        AdSizeParcel adSizeParcel = null;
        final com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza = new com.google.android.gms.internal.zzha.zza(adRequestInfoParcel, zzf, null, adSizeParcel, zzf.errorCode, zzo.zzbz().elapsedRealtime(), zzf.zzCO, null);
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzl zzDm;

            public void run() {
                this.zzDm.zzCd.zza(com_google_android_gms_internal_zzha_zza);
                if (this.zzDm.zzDl != null) {
                    this.zzDm.zzDl.release();
                    this.zzDm.zzDl = null;
                }
            }
        });
    }
}
