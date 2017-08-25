package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzo;
import com.heyzap.house.abstr.AbstractActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class zzce {
    private static int zzuP;
    private final Object zzqt = new Object();
    final String zzuO;
    private final LinkedList<zzcd> zzuQ;
    private zzcd zzuR;

    public zzce(String str) {
        this.zzuO = str;
        zzuP = ((Integer) zzbz.zztZ.get()).intValue();
        synchronized (this.zzqt) {
            this.zzuQ = new LinkedList();
        }
    }

    private static Map<String, String> zza(String str, StringBuilder stringBuilder) {
        Map<String, String> map = null;
        if (stringBuilder.length() > 0) {
            map = new LinkedHashMap();
            if (str != null) {
                map.put(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY, str);
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            map.put("it", stringBuilder.toString());
        }
        return map;
    }

    public static Map<String, String> zza(zzce... com_google_android_gms_internal_zzceArr) throws IllegalArgumentException {
        String str = null;
        StringBuilder stringBuilder = new StringBuilder((zzuP * 10) * 20);
        for (int i = 0; i < com_google_android_gms_internal_zzceArr.length; i++) {
            Map zzdq = com_google_android_gms_internal_zzceArr[i].zzdq();
            if (zzdq != null) {
                if (i == 0) {
                    str = (String) zzdq.get(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY);
                    stringBuilder.append((String) zzdq.get("it")).append(",");
                } else if ((zzdq.containsKey(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY) || str == null) && (!zzdq.containsKey(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY) || ((String) zzdq.get(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY)).equals(str))) {
                    stringBuilder.append((String) zzdq.get("it")).append(",");
                } else {
                    throw new IllegalArgumentException("Can not merge report items for the tickers with different action names.");
                }
            }
        }
        return zza(str, stringBuilder);
    }

    private boolean zza(zzcd com_google_android_gms_internal_zzcd, long j, String... strArr) {
        synchronized (this.zzqt) {
            for (String com_google_android_gms_internal_zzcd2 : strArr) {
                this.zzuQ.add(new zzcd(j, com_google_android_gms_internal_zzcd2, com_google_android_gms_internal_zzcd));
            }
        }
        return true;
    }

    private zzcd zzb(long j) {
        return new zzcd(j, null, null);
    }

    public boolean zza(zzcd com_google_android_gms_internal_zzcd, String... strArr) {
        return (!zzo.zzbA().zzdc() || com_google_android_gms_internal_zzcd == null) ? false : zza(com_google_android_gms_internal_zzcd, zzo.zzbz().elapsedRealtime(), strArr);
    }

    public zzcd zzdo() {
        return !zzo.zzbA().zzdc() ? null : zzb(zzo.zzbz().elapsedRealtime());
    }

    public void zzdp() {
        this.zzuR = zzdo();
    }

    Map<String, String> zzdq() {
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (this.zzqt) {
            Iterator it = this.zzuQ.iterator();
            while (it.hasNext()) {
                zzcd com_google_android_gms_internal_zzcd = (zzcd) it.next();
                Long valueOf = Long.valueOf(com_google_android_gms_internal_zzcd.getTime());
                String zzdm = com_google_android_gms_internal_zzcd.zzdm();
                com_google_android_gms_internal_zzcd = com_google_android_gms_internal_zzcd.zzdn();
                if (com_google_android_gms_internal_zzcd != null && valueOf.longValue() > 0) {
                    stringBuilder.append(zzdm).append('.').append(valueOf.longValue() - com_google_android_gms_internal_zzcd.getTime()).append(',');
                }
            }
            this.zzuQ.clear();
        }
        return zza(this.zzuO, stringBuilder);
    }

    public String zzdr() {
        return this.zzuO;
    }

    public zzcd zzds() {
        return this.zzuR;
    }
}
