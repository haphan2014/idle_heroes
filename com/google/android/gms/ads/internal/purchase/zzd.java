package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.applovin.sdk.AppLovinEventParameters;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.games.Games;
import com.google.android.gms.internal.zzfe.zza;
import com.google.android.gms.internal.zzgd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgd
public class zzd extends zza {
    private Context mContext;
    private String zzAK;
    private ArrayList<String> zzAL;
    private String zzqr;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.zzAK = str;
        this.zzAL = arrayList;
        this.zzqr = str2;
        this.mContext = context;
    }

    public String getProductId() {
        return this.zzAK;
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        if (billingResponseCode == 0) {
            zzff();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(billingResponseCode));
        hashMap.put(AppLovinEventParameters.PRODUCT_IDENTIFIER, this.zzAK);
        hashMap.put(Games.EXTRA_STATUS, String.valueOf(zzy(billingResponseCode)));
        List linkedList = new LinkedList();
        Iterator it = this.zzAL.iterator();
        while (it.hasNext()) {
            linkedList.add(zza((String) it.next(), hashMap));
        }
        zzo.zzbv().zza(this.mContext, this.zzqr, linkedList);
    }

    public void recordResolution(int resolution) {
        if (resolution == 1) {
            zzff();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Games.EXTRA_STATUS, String.valueOf(resolution));
        hashMap.put(AppLovinEventParameters.PRODUCT_IDENTIFIER, this.zzAK);
        List linkedList = new LinkedList();
        Iterator it = this.zzAL.iterator();
        while (it.hasNext()) {
            linkedList.add(zza((String) it.next(), hashMap));
        }
        zzo.zzbv().zza(this.mContext, this.zzqr, linkedList);
    }

    protected String zza(String str, HashMap<String, String> hashMap) {
        Object obj;
        Object obj2 = "";
        try {
            obj = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            zzb.zzd("Error to retrieve app version", e);
            obj = obj2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzo.zzby().zzfX().zzgg();
        for (String str2 : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str2}), String.format("$1%s$2", new Object[]{hashMap.get(str2)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{zzo.zzby().getSessionId()})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{AppsFlyerProperties.APP_ID}), String.format("$1%s$2", new Object[]{r2})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.zzqr})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{obj})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    void zzff() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.mContext, this.zzAK, "", Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            zzb.zzaC("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzb.zzaC("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            zzb.zzd("Fail to report a conversion.", e3);
        }
    }

    protected int zzy(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }
}
