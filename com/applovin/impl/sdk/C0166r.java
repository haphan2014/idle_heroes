package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.games.Games;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class C0166r {
    private final AppLovinSdkImpl f698a;
    private final Context f699b;
    private final AppLovinLogger f700c;
    private final Map f701d;

    C0166r(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f698a = appLovinSdkImpl;
        this.f700c = appLovinSdkImpl.getLogger();
        this.f699b = appLovinSdkImpl.getApplicationContext();
        this.f701d = Collections.synchronizedMap(new HashMap());
    }

    private C0171w m763a(C0171w c0171w) {
        if (c0171w == null) {
            c0171w = new C0171w();
        }
        if (((Boolean) this.f698a.m253a(cd.bx)).booleanValue()) {
            c0171w.f727o = m768f();
        } else {
            c0171w.f727o = null;
        }
        if (((Boolean) this.f698a.m253a(cd.bw)).booleanValue()) {
            c0171w.f726n = m770h();
        }
        try {
            AudioManager audioManager = (AudioManager) this.f699b.getSystemService("audio");
            if (audioManager != null) {
                c0171w.f728p = (int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.f698a.m253a(cd.bz)).floatValue());
            }
        } catch (Throwable th) {
            this.f700c.mo637e("DataCollector", "Unable to collect volume", th);
        }
        if (((Boolean) this.f698a.m253a(cd.bC)).booleanValue()) {
            SharedPreferences sharedPreferences = this.f699b.getSharedPreferences("com.applovin.impl.sdk.DataCollector.domain", 0);
            String string = sharedPreferences.getString("com.applovin.impl.sdk.DataCollector.key.userAgent", null);
            if (string == null) {
                string = m773k();
                if (AppLovinSdkUtils.isValidString(string)) {
                    sharedPreferences.edit().putString("com.applovin.impl.sdk.DataCollector.key.userAgent", string).commit();
                } else {
                    sharedPreferences.edit().putString("com.applovin.impl.sdk.DataCollector.key.userAgent", "").commit();
                }
            }
            if (AppLovinSdkUtils.isValidString(string)) {
                c0171w.f729q = string;
            }
        }
        return c0171w;
    }

    static boolean m764a(String str, Context context) {
        if (str == null) {
            throw new IllegalArgumentException("No permission name specified");
        } else if (context != null) {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    private String m766b(String str) {
        int length = str.length();
        int[] iArr = new int[]{11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        int length2 = iArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = length2 - 1; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        String str2 = new String(cArr);
        return str2 != null ? str2 : "";
    }

    private String m767e() {
        String str = "none";
        try {
            int a = dp.m692a(this.f699b);
            return a == 1 ? "portrait" : a == 2 ? "landscape" : str;
        } catch (Throwable th) {
            this.f698a.getLogger().mo637e("DataCollector", "Encountered error while attempting to collect application orientation", th);
            return str;
        }
    }

    private C0170v m768f() {
        int i = -1;
        try {
            C0170v c0170v = new C0170v();
            Intent registerReceiver = this.f699b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : -1;
            int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
            if (intExtra <= 0 || intExtra2 <= 0) {
                c0170v.f712b = -1;
            } else {
                c0170v.f712b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
            }
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra(Games.EXTRA_STATUS, -1);
            }
            c0170v.f711a = i;
            return c0170v;
        } catch (Throwable th) {
            this.f700c.mo637e("DataCollector", "Unable to collect battery info", th);
            return null;
        }
    }

    private double m769g() {
        return ((double) Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d)) / 10.0d;
    }

    private boolean m770h() {
        try {
            return m771i() || m772j();
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean m771i() {
        String str = "lz}$blpz";
        str = Build.TAGS;
        return str != null && str.contains(m766b("lz}$blpz"));
    }

    private boolean m772j() {
        String[] strArr = new String[]{"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (String b : strArr) {
            if (new File(m766b(b)).exists()) {
                return true;
            }
        }
        return false;
    }

    private String m773k() {
        AtomicReference atomicReference = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(this.f699b.getMainLooper()).post(new C0167s(this, atomicReference, countDownLatch));
        try {
            countDownLatch.await(((Long) this.f698a.m253a(cd.bD)).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
        }
        return (String) atomicReference.get();
    }

    C0171w m774a() {
        Object obj = this.f701d.get(C0171w.class);
        if (obj != null) {
            return m763a((C0171w) obj);
        }
        C0171w c0171w = new C0171w();
        c0171w.f720h = Locale.getDefault();
        c0171w.f713a = Build.MODEL;
        c0171w.f714b = VERSION.RELEASE;
        c0171w.f715c = Build.MANUFACTURER;
        c0171w.f717e = VERSION.SDK_INT;
        c0171w.f716d = Build.DEVICE;
        c0171w.f721i = m767e();
        c0171w.f724l = m769g();
        if (m775a("android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f699b.getSystemService("phone");
            if (telephonyManager != null) {
                c0171w.f718f = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                try {
                    c0171w.f719g = URLEncoder.encode(networkOperatorName, AsyncHttpResponseHandler.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e) {
                    c0171w.f719g = networkOperatorName;
                }
            }
        }
        try {
            c0171w.f725m = this.f699b.getPackageManager().getPackageInfo((String) this.f698a.getSettingsManager().m501a(cd.bv), 0).versionCode;
        } catch (Throwable th) {
        }
        try {
            DisplayMetrics displayMetrics = this.f699b.getResources().getDisplayMetrics();
            c0171w.f722j = displayMetrics.density;
            c0171w.f723k = displayMetrics.densityDpi;
        } catch (Throwable th2) {
        }
        this.f701d.put(C0171w.class, c0171w);
        return c0171w;
    }

    boolean m775a(String str) {
        return C0166r.m764a(str, this.f699b);
    }

    C0171w m776b() {
        return m763a(null);
    }

    C0169u m777c() {
        Object obj = this.f701d.get(C0169u.class);
        if (obj != null) {
            return (C0169u) obj;
        }
        ApplicationInfo applicationInfo = this.f699b.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        PackageManager packageManager = this.f699b.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f699b.getPackageName(), 0);
        } catch (NameNotFoundException e) {
        }
        C0169u c0169u = new C0169u();
        c0169u.f709c = applicationInfo.packageName;
        c0169u.f710d = lastModified;
        c0169u.f707a = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        c0169u.f708b = packageInfo != null ? packageInfo.versionName : "";
        this.f701d.put(C0169u.class, c0169u);
        return c0169u;
    }

    C0168t m778d() {
        try {
            Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            if (cls != null) {
                Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f699b});
                if (invoke != null) {
                    Class cls2 = invoke.getClass();
                    Object invoke2 = cls2.getMethod("isLimitAdTrackingEnabled", null).invoke(invoke, null);
                    invoke = cls2.getMethod("getId", null).invoke(invoke, null);
                    C0168t c0168t = new C0168t();
                    String str = (String) invoke;
                    String str2 = str == null ? "" : str;
                    c0168t.f705a = ((Boolean) invoke2).booleanValue();
                    c0168t.f706b = str2;
                    return c0168t;
                }
            }
        } catch (Throwable e) {
            this.f700c.userError("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e);
        } catch (Throwable e2) {
            this.f700c.mo637e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e2);
        }
        C0168t c0168t2 = new C0168t();
        c0168t2.f706b = "";
        c0168t2.f705a = false;
        return c0168t2;
    }
}
