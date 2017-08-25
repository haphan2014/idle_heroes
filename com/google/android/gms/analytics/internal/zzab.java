package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.facebook.AppEventsConstants;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzab {
    private final List<Command> zzLZ;
    private final long zzMa;
    private final long zzMb;
    private final int zzMc;
    private final boolean zzMd;
    private final String zzMe;
    private final Map<String, String> zzyn;

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z) {
        this(com_google_android_gms_analytics_internal_zzc, map, j, z, 0, 0, null);
    }

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(com_google_android_gms_analytics_internal_zzc, map, j, z, j2, i, null);
    }

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        zzu.zzu(com_google_android_gms_analytics_internal_zzc);
        zzu.zzu(map);
        this.zzMb = j;
        this.zzMd = z;
        this.zzMa = j2;
        this.zzMc = i;
        this.zzLZ = list != null ? list : Collections.EMPTY_LIST;
        this.zzMe = zze(list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String zza;
            if (zzj(entry.getKey())) {
                zza = zza(com_google_android_gms_analytics_internal_zzc, entry.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(com_google_android_gms_analytics_internal_zzc, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!zzj(entry2.getKey())) {
                zza = zza(com_google_android_gms_analytics_internal_zzc, entry2.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(com_google_android_gms_analytics_internal_zzc, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.zzMe)) {
            zzam.zzb(hashMap, "_v", this.zzMe);
            if (this.zzMe.equals("ma4.0.0") || this.zzMe.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zzyn = Collections.unmodifiableMap(hashMap);
    }

    public static zzab zza(zzc com_google_android_gms_analytics_internal_zzc, zzab com_google_android_gms_analytics_internal_zzab, Map<String, String> map) {
        return new zzab(com_google_android_gms_analytics_internal_zzc, map, com_google_android_gms_analytics_internal_zzab.zzjW(), com_google_android_gms_analytics_internal_zzab.zzjY(), com_google_android_gms_analytics_internal_zzab.zzjV(), com_google_android_gms_analytics_internal_zzab.zzjU(), com_google_android_gms_analytics_internal_zzab.zzjX());
    }

    private static String zza(zzc com_google_android_gms_analytics_internal_zzc, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            com_google_android_gms_analytics_internal_zzc.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private static String zzb(zzc com_google_android_gms_analytics_internal_zzc, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        obj2 = obj2.substring(0, 8192);
        com_google_android_gms_analytics_internal_zzc.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    private static String zze(List<Command> list) {
        CharSequence value;
        if (list != null) {
            for (Command command : list) {
                if ("appendVersion".equals(command.getId())) {
                    value = command.getValue();
                    break;
                }
            }
        }
        value = null;
        return TextUtils.isEmpty(value) ? null : value;
    }

    private static boolean zzj(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private String zzn(String str, String str2) {
        zzu.zzcj(str);
        zzu.zzb(!str.startsWith("&"), (Object) "Short param name required");
        String str3 = (String) this.zzyn.get(str);
        return str3 != null ? str3 : str2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.zzMb);
        if (this.zzMa != 0) {
            stringBuffer.append(", dbId=").append(this.zzMa);
        }
        if (((long) this.zzMc) != 0) {
            stringBuffer.append(", appUID=").append(this.zzMc);
        }
        List<String> arrayList = new ArrayList(this.zzyn.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.zzyn.get(str));
        }
        return stringBuffer.toString();
    }

    public int zzjU() {
        return this.zzMc;
    }

    public long zzjV() {
        return this.zzMa;
    }

    public long zzjW() {
        return this.zzMb;
    }

    public List<Command> zzjX() {
        return this.zzLZ;
    }

    public boolean zzjY() {
        return this.zzMd;
    }

    public long zzjZ() {
        return zzam.zzbj(zzn("_s", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public String zzka() {
        return zzn("_m", "");
    }

    public Map<String, String> zzn() {
        return this.zzyn;
    }
}
