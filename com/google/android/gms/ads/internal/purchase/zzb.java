package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.droidhang.pay.util.IabHelper;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zzb {
    private final Context mContext;
    Object zzAB;

    public zzb(Context context) {
        this.mContext = context;
    }

    public void destroy() {
        this.zzAB = null;
    }

    public void zzK(IBinder iBinder) {
        try {
            this.zzAB = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }

    public Bundle zzb(String str, String str2, String str3) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.zzAB), new Object[]{Integer.valueOf(3), str, str2, IabHelper.ITEM_TYPE_INAPP, str3});
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    public int zzh(String str, String str2) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.zzAB), new Object[]{Integer.valueOf(3), str, str2})).intValue();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return 5;
        }
    }

    public Bundle zzi(String str, String str2) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.zzAB), new Object[]{Integer.valueOf(3), str, IabHelper.ITEM_TYPE_INAPP, str2});
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }
}
