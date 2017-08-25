package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public final class zzgg {
    private static final SimpleDateFormat zzDJ = new SimpleDateFormat("yyyyMMdd");

    private static String zzG(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }

    public static AdResponseParcel zza(Context context, AdRequestInfoParcel adRequestInfoParcel, String str) {
        try {
            String str2;
            AdResponseParcel adResponseParcel;
            int i;
            List list;
            List list2;
            List list3;
            long j;
            String optString;
            String str3;
            boolean optBoolean;
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            CharSequence optString5 = jSONObject.optString("ad_html", null);
            long j2 = -1;
            String optString6 = jSONObject.optString("debug_dialog", null);
            long j3 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString7 = jSONObject.optString("orientation", null);
            int i2 = -1;
            if ("portrait".equals(optString7)) {
                i2 = zzo.zzbx().zzgr();
            } else if ("landscape".equals(optString7)) {
                i2 = zzo.zzbx().zzgq();
            }
            if (TextUtils.isEmpty(optString5)) {
                if (TextUtils.isEmpty(optString3)) {
                    zzb.zzaC("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new AdResponseParcel(0);
                }
                AdResponseParcel zza = zzgf.zza(adRequestInfoParcel, context, adRequestInfoParcel.zzpJ.zzGG, optString3, null, null, null);
                optString2 = zza.zzzG;
                str2 = zza.zzCI;
                j2 = zza.zzCO;
                adResponseParcel = zza;
            } else if (TextUtils.isEmpty(optString2)) {
                zzb.zzaC("Could not parse the mediation config: Missing required ad_base_url field");
                return new AdResponseParcel(0);
            } else {
                adResponseParcel = null;
                CharSequence charSequence = optString5;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = adResponseParcel == null ? null : adResponseParcel.zzxF;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray.length(); i++) {
                    list4.add(optJSONArray.getString(i));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = adResponseParcel == null ? null : adResponseParcel.zzxG;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray2.length(); i++) {
                    list4.add(optJSONArray2.getString(i));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = adResponseParcel == null ? null : adResponseParcel.zzCM;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray3.length(); i++) {
                    list4.add(optJSONArray3.getString(i));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (adResponseParcel != null) {
                if (adResponseParcel.orientation != -1) {
                    i2 = adResponseParcel.orientation;
                }
                if (adResponseParcel.zzCJ > 0) {
                    j = adResponseParcel.zzCJ;
                    optString = jSONObject.optString("active_view");
                    str3 = null;
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                        str3 = jSONObject.optString("ad_passback_url", null);
                    }
                    return new AdResponseParcel(adRequestInfoParcel, optString2, str2, list, list2, j, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i2, optString4, j2, optString6, optBoolean, str3, optString, jSONObject.optBoolean("custom_render_allowed", false), jSONObject.optBoolean("native", false), adRequestInfoParcel.zzCu, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optInt("oauth2_token_status", 0));
                }
            }
            j = j3;
            optString = jSONObject.optString("active_view");
            str3 = null;
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str3 = jSONObject.optString("ad_passback_url", null);
            }
            return new AdResponseParcel(adRequestInfoParcel, optString2, str2, list, list2, j, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i2, optString4, j2, optString6, optBoolean, str3, optString, jSONObject.optBoolean("custom_render_allowed", false), jSONObject.optBoolean("native", false), adRequestInfoParcel.zzCu, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optInt("oauth2_token_status", 0));
        } catch (JSONException e) {
            zzb.zzaC("Could not parse the mediation config: " + e.getMessage());
            return new AdResponseParcel(0);
        }
    }

    public static JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, zzgk com_google_android_gms_internal_zzgk, Location location, zzbr com_google_android_gms_internal_zzbr, String str, String str2, List<String> list) {
        try {
            HashMap hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.zzCl != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.zzCl);
            }
            zza(hashMap, adRequestInfoParcel.zzCm);
            hashMap.put("format", adRequestInfoParcel.zzpN.zzsm);
            if (adRequestInfoParcel.zzpN.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzpN.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzpN.zzso != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzpN.zzso) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / com_google_android_gms_internal_zzgk.zzCy) : adSizeParcel.width);
                    stringBuilder.append("x");
                    stringBuilder.append(adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / com_google_android_gms_internal_zzgk.zzCy) : adSizeParcel.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            if (adRequestInfoParcel.zzCs != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.zzCs));
                hashMap.put("native_templates", adRequestInfoParcel.zzqd);
                hashMap.put("native_image_orientation", zzc(adRequestInfoParcel.zzqb));
                if (!adRequestInfoParcel.zzCG.isEmpty()) {
                    hashMap.put("native_custom_templates", adRequestInfoParcel.zzCG);
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.zzpG);
            hashMap.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzCn != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.zzCn.versionCode));
            }
            hashMap.put("ms", str2);
            hashMap.put("seq_num", adRequestInfoParcel.zzCp);
            hashMap.put("session_id", adRequestInfoParcel.zzCq);
            hashMap.put("js", adRequestInfoParcel.zzpJ.zzGG);
            zza(hashMap, com_google_android_gms_internal_zzgk);
            hashMap.put("fdz", new Integer(com_google_android_gms_internal_zzbr.zzcX()));
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (adRequestInfoParcel.zzCm.versionCode >= 2 && adRequestInfoParcel.zzCm.zzsf != null) {
                zza(hashMap, adRequestInfoParcel.zzCm.zzsf);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.zzCr);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzCu) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzCu));
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzCt != null) {
                hashMap.put("content_info", adRequestInfoParcel.zzCt);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.zzCy));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.zzCx));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.zzCw));
            } else {
                hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzgk.zzCy));
                hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzgk.zzCx));
                hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzgk.zzCw));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzCz)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzCz));
                    } catch (Throwable e) {
                        zzb.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                if (((Boolean) zzbz.zzun.get()).booleanValue() && adRequestInfoParcel.zzCA) {
                    hashMap.put("ga_hid", Integer.valueOf(adRequestInfoParcel.zzCB));
                    hashMap.put("ga_cid", adRequestInfoParcel.zzCC);
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzCD));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.zzCE);
            }
            zza(hashMap, str);
            if (zzb.zzL(2)) {
                zzb.zzaB("Ad Request JSON: " + zzo.zzbv().zzy(hashMap).toString(2));
            }
            return zzo.zzbv().zzy(hashMap);
        } catch (JSONException e2) {
            zzb.zzaC("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String zzgh = zzhg.zzgh();
        if (zzgh != null) {
            hashMap.put("abf", zzgh);
        }
        if (adRequestParcel.zzrX != -1) {
            hashMap.put("cust_age", zzDJ.format(new Date(adRequestParcel.zzrX)));
        }
        if (adRequestParcel.extras != null) {
            hashMap.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zzrY != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.zzrY));
        }
        if (adRequestParcel.zzrZ != null) {
            hashMap.put("kw", adRequestParcel.zzrZ);
        }
        if (adRequestParcel.zzsb != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zzsb));
        }
        if (adRequestParcel.zzsa) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zzsc) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(adRequestParcel.zzsd)) {
                hashMap.put("ppid", adRequestParcel.zzsd);
            }
            if (adRequestParcel.zzse != null) {
                zza((HashMap) hashMap, adRequestParcel.zzse);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zzsg != null) {
            hashMap.put("url", adRequestParcel.zzsg);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zzsi != null) {
                hashMap.put("custom_targeting", adRequestParcel.zzsi);
            }
            if (adRequestParcel.zzsj != null) {
                hashMap.put("category_exclusions", adRequestParcel.zzsj);
            }
            if (adRequestParcel.zzsk != null) {
                hashMap.put("request_agent", adRequestParcel.zzsk);
            }
        }
    }

    private static void zza(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(searchAdRequestParcel.zzth) != 0) {
            hashMap.put("acolor", zzG(searchAdRequestParcel.zzth));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzG(searchAdRequestParcel.backgroundColor));
        }
        if (!(Color.alpha(searchAdRequestParcel.zzti) == 0 || Color.alpha(searchAdRequestParcel.zztj) == 0)) {
            hashMap.put("gradientto", zzG(searchAdRequestParcel.zzti));
            hashMap.put("gradientfrom", zzG(searchAdRequestParcel.zztj));
        }
        if (Color.alpha(searchAdRequestParcel.zztk) != 0) {
            hashMap.put("bcolor", zzG(searchAdRequestParcel.zztk));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.zztl));
        switch (searchAdRequestParcel.zztm) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (searchAdRequestParcel.zztn) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (searchAdRequestParcel.zzto != null) {
            hashMap.put(AppsFlyerProperties.CHANNEL, searchAdRequestParcel.zzto);
        }
        if (Color.alpha(searchAdRequestParcel.zztp) != 0) {
            hashMap.put("dcolor", zzG(searchAdRequestParcel.zztp));
        }
        if (searchAdRequestParcel.zztq != null) {
            hashMap.put("font", searchAdRequestParcel.zztq);
        }
        if (Color.alpha(searchAdRequestParcel.zztr) != 0) {
            hashMap.put("hcolor", zzG(searchAdRequestParcel.zztr));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.zzts));
        if (searchAdRequestParcel.zztt != null) {
            hashMap.put("q", searchAdRequestParcel.zztt);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzgk com_google_android_gms_internal_zzgk) {
        hashMap.put("am", Integer.valueOf(com_google_android_gms_internal_zzgk.zzEn));
        hashMap.put("cog", zzx(com_google_android_gms_internal_zzgk.zzEo));
        hashMap.put("coh", zzx(com_google_android_gms_internal_zzgk.zzEp));
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzgk.zzEq)) {
            hashMap.put("carrier", com_google_android_gms_internal_zzgk.zzEq);
        }
        hashMap.put("gl", com_google_android_gms_internal_zzgk.zzEr);
        if (com_google_android_gms_internal_zzgk.zzEs) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", zzx(com_google_android_gms_internal_zzgk.zzEt));
        hashMap.put("sp", zzx(com_google_android_gms_internal_zzgk.zzEu));
        hashMap.put("hl", com_google_android_gms_internal_zzgk.zzEv);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzgk.zzEw)) {
            hashMap.put("mv", com_google_android_gms_internal_zzgk.zzEw);
        }
        hashMap.put("muv", Integer.valueOf(com_google_android_gms_internal_zzgk.zzEx));
        if (com_google_android_gms_internal_zzgk.zzEy != -2) {
            hashMap.put("cnt", Integer.valueOf(com_google_android_gms_internal_zzgk.zzEy));
        }
        hashMap.put("gnt", Integer.valueOf(com_google_android_gms_internal_zzgk.zzEz));
        hashMap.put("pt", Integer.valueOf(com_google_android_gms_internal_zzgk.zzEA));
        hashMap.put("rm", Integer.valueOf(com_google_android_gms_internal_zzgk.zzEB));
        hashMap.put("riv", Integer.valueOf(com_google_android_gms_internal_zzgk.zzEC));
        Bundle bundle = new Bundle();
        bundle.putInt("active_network_state", com_google_android_gms_internal_zzgk.zzEG);
        bundle.putBoolean("active_network_metered", com_google_android_gms_internal_zzgk.zzEF);
        hashMap.put("connectivity", bundle);
        bundle = new Bundle();
        bundle.putBoolean("is_charging", com_google_android_gms_internal_zzgk.zzEE);
        bundle.putDouble("battery_level", com_google_android_gms_internal_zzgk.zzED);
        hashMap.put("battery", bundle);
    }

    private static void zza(HashMap<String, Object> hashMap, String str) {
        if (str != null) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN, str);
            hashMap.put("pan", hashMap2);
        }
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzvD : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    private static Integer zzx(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
