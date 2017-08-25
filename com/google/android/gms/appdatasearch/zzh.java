package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
    private static final String[] zzNq = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzNr = new HashMap(zzNq.length);

    static {
        int i = 0;
        while (i < zzNq.length) {
            zzNr.put(zzNq[i], Integer.valueOf(i));
            i++;
        }
    }

    public static String zzai(int i) {
        return (i < 0 || i >= zzNq.length) ? null : zzNq[i];
    }

    public static int zzbq(String str) {
        Integer num = (Integer) zzNr.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int zzkL() {
        return zzNq.length;
    }
}
