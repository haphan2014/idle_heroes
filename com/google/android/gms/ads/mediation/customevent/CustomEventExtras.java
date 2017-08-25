package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> zzHL = new HashMap();

    public Object getExtra(String label) {
        return this.zzHL.get(label);
    }

    public void setExtra(String label, Object value) {
        this.zzHL.put(label, value);
    }
}
