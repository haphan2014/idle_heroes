package com.applovin.impl.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.Display;
import android.view.WindowManager;
import com.applovin.adview.AppLovinInterstitialActivity;

public class C0163n {
    static void m730a() {
        try {
            if (VERSION.SDK_INT >= 9) {
                StrictMode.setThreadPolicy(new Builder().permitAll().build());
            }
        } catch (Throwable th) {
        }
    }

    public static boolean m731a(Context context) {
        boolean z = false;
        try {
            z = dp.m703a(context.getPackageManager().getActivityInfo(new ComponentName(context, AppLovinInterstitialActivity.class.getCanonicalName()), 0).configChanges, 1024);
        } catch (Throwable th) {
        }
        return z;
    }

    public static boolean m732a(Class cls, Context context) {
        return context.getPackageManager().resolveActivity(new Intent(context, cls), 0) != null;
    }

    public static boolean m733a(String str, Context context) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean m734b() {
        return VERSION.SDK_INT >= 15;
    }

    public static boolean m735b(Context context) {
        boolean z = false;
        try {
            z = dp.m703a(context.getPackageManager().getActivityInfo(new ComponentName(context, AppLovinInterstitialActivity.class.getCanonicalName()), 0).configChanges, 128);
        } catch (Throwable th) {
        }
        return z;
    }

    public static Point m736c(Context context) {
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            if (VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        } catch (Throwable th) {
        }
        return point;
    }

    public static boolean m737c() {
        return VERSION.SDK_INT >= 19;
    }
}
