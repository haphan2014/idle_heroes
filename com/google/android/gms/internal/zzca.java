package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.LinkedHashMap;
import java.util.Map;

public class zzca {
    private Context mContext = null;
    private String zzqr = null;
    private int zzuA = 30;
    private int zzuB = 3;
    private int zzuC = 100;
    private String zzuD = ((String) zzbz.zzua.get());
    private Map<String, String> zzuE = new LinkedHashMap();
    private boolean zzuy = ((Boolean) zzbz.zztY.get()).booleanValue();
    private int zzuz = ((Integer) zzbz.zztZ.get()).intValue();

    public zzca() {
        this.zzuE.put("s", "gmob_sdk");
        this.zzuE.put("v", "3");
        this.zzuE.put("os", VERSION.RELEASE);
        this.zzuE.put("sdk", VERSION.SDK);
        this.zzuE.put("device", zzo.zzbv().zzgo());
    }

    Context getContext() {
        return this.mContext;
    }

    public zzca zzb(Context context, String str) {
        this.mContext = context;
        this.zzqr = str;
        this.zzuE.put("ua", zzo.zzbv().zzf(context, str));
        try {
            this.zzuE.put("app", context.getApplicationContext().getPackageName());
        } catch (NullPointerException e) {
            zzb.zzaC("Cannot get the application name. Set to null.");
            this.zzuE.put("app", null);
        }
        return this;
    }

    String zzbR() {
        return this.zzqr;
    }

    boolean zzdc() {
        return this.zzuy;
    }

    String zzdd() {
        return this.zzuD;
    }

    int zzde() {
        return this.zzuA;
    }

    int zzdf() {
        return this.zzuB;
    }

    int zzdg() {
        return this.zzuC;
    }

    int zzdh() {
        return this.zzuz;
    }

    Map<String, String> zzdi() {
        return this.zzuE;
    }
}
