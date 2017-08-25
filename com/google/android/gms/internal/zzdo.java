package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzgd
public final class zzdo implements zzdg {
    private final Map<zzid, Integer> zzwA = new WeakHashMap();

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = zzk.zzcA().zzb(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                zzb.zzaC("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
        String str = (String) map.get(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY);
        if (str == null) {
            zzb.zzaC("Action missing from video GMSG.");
            return;
        }
        if (zzb.zzL(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzb.zzay("Video GMSG: " + str + " " + jSONObject.toString());
        }
        int parseColor;
        zzc zzgD;
        if ("background".equals(str)) {
            str = (String) map.get("color");
            if (TextUtils.isEmpty(str)) {
                zzb.zzaC("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                parseColor = Color.parseColor(str);
                zzgD = com_google_android_gms_internal_zzid.zzgD();
                if (zzgD != null) {
                    zzh zzeq = zzgD.zzeq();
                    if (zzeq != null) {
                        zzeq.setBackgroundColor(parseColor);
                        return;
                    }
                }
                this.zzwA.put(com_google_android_gms_internal_zzid, Integer.valueOf(parseColor));
                return;
            } catch (IllegalArgumentException e) {
                zzb.zzaC("Invalid color parameter in video GMSG.");
                return;
            }
        }
        zzgD = com_google_android_gms_internal_zzid.zzgD();
        if (zzgD == null) {
            zzb.zzaC("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int zza;
        if (equals || equals2) {
            Context context = com_google_android_gms_internal_zzid.getContext();
            zza = zza(context, map, "x", 0);
            int zza2 = zza(context, map, "y", 0);
            int zza3 = zza(context, map, "w", -1);
            parseColor = zza(context, map, "h", -1);
            if (equals && zzgD.zzeq() == null) {
                zzgD.zze(zza, zza2, zza3, parseColor);
                if (this.zzwA.containsKey(com_google_android_gms_internal_zzid)) {
                    zzgD.zzeq().setBackgroundColor(((Integer) this.zzwA.get(com_google_android_gms_internal_zzid)).intValue());
                    return;
                }
                return;
            }
            zzgD.zzd(zza, zza2, zza3, parseColor);
            return;
        }
        zzh zzeq2 = zzgD.zzeq();
        if (zzeq2 == null) {
            zzh.zzd(com_google_android_gms_internal_zzid);
        } else if ("click".equals(str)) {
            context = com_google_android_gms_internal_zzid.getContext();
            int zza4 = zza(context, map, "x", 0);
            zza = zza(context, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza4, (float) zza, 0);
            zzeq2.zzc(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            str = (String) map.get("time");
            if (str == null) {
                zzb.zzaC("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzeq2.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e2) {
                zzb.zzaC("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if (NetworkCallback.HIDE.equals(str)) {
            zzeq2.setVisibility(4);
        } else if ("load".equals(str)) {
            zzeq2.zzeH();
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzeq2.zzeI();
            } else {
                zzeq2.zzeJ();
            }
        } else if ("pause".equals(str)) {
            zzeq2.pause();
        } else if ("play".equals(str)) {
            zzeq2.play();
        } else if (NetworkCallback.SHOW.equals(str)) {
            zzeq2.setVisibility(0);
        } else if ("src".equals(str)) {
            zzeq2.zzah((String) map.get("src"));
        } else if ("volume".equals(str)) {
            str = (String) map.get("volume");
            if (str == null) {
                zzb.zzaC("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zzeq2.zza(Float.parseFloat(str));
            } catch (NumberFormatException e3) {
                zzb.zzaC("Could not parse volume parameter from volume video GMSG: " + str);
            }
        } else if ("watermark".equals(str)) {
            zzeq2.zzeK();
        } else {
            zzb.zzaC("Unknown video action: " + str);
        }
    }
}
