package com.droidhang.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import java.util.List;

public class DefaultPreferenceUtil {
    public static int INVALIDATE_INT_VALUE = -1;
    public static long INVALIDATE_Long_VALUE = -1;

    public static void setBoolean(Context ctx, String key, boolean value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static Boolean getBoolean(Context ctx, String key, boolean defaultValue) {
        return Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean(key, defaultValue));
    }

    public static void setInt(Context ctx, String key, int value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInt(Context ctx, String key, int defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getInt(key, defaultValue);
    }

    public static void setLong(Context ctx, String key, long value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static long getLong(Context ctx, String key, long defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getLong(key, defaultValue);
    }

    public static void setFloat(Context ctx, String key, float value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static float getFloat(Context ctx, String key, float defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getFloat(key, defaultValue);
    }

    public static String getString(Context ctx, String key, String defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString(key, defaultValue);
    }

    public static void setString(Context ctx, String key, String value) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static int isInstall(Context ctx, String appid) {
        List<PackageInfo> pkgList = ctx.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < pkgList.size(); i++) {
            if (((PackageInfo) pkgList.get(i)).packageName.equalsIgnoreCase(appid)) {
                return 1;
            }
        }
        return 0;
    }

    public static void downloadApp(Context ctx, String url) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        ctx.startActivity(intent);
    }
}
