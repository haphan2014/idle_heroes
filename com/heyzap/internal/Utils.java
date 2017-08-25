package com.heyzap.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.support.v4.view.MotionEventCompat;
import android.util.DisplayMetrics;
import com.facebook.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.net.Connectivity;
import com.heyzap.sdk.ads.HeyzapAds;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Utils {
    private static final String CACHE_DIR = "com.heyzap.sdk";
    private static final String IMAGE_CACHE_DIR = "com.heyzap.sdk.images";
    private static final Object advertiserIdLock = new Object();
    private static String advertisingId = null;
    private static Future<Boolean> advertisingIdAvailable;
    private static HashMap<String, String> cachedParams;
    private static Boolean debug = null;
    private static float density = GroundOverlayOptions.NO_DIMENSION;
    private static String deviceId = "unknown";
    private static String gameName = "unknown";
    private static Boolean limitAdTrackingEnabled = Boolean.valueOf(false);
    public static String packageName = "unknown";
    private static final Object paramLock = new Object();

    public static void setDebug(boolean newDebug) {
        debug = Boolean.valueOf(newDebug);
    }

    public static Boolean isDebug(Context context) {
        if (debug == null) {
            debug = Boolean.valueOf(packageIsInstalled(Constants.SNAKE_PACKAGE, context));
        }
        return debug;
    }

    public static void load(Context context) {
        createCacheDir(context);
        loadAdvertisingId(context);
    }

    public static String getPackageName(Context context) {
        if (packageName.equals("unknown") && context != null) {
            String pn = context.getPackageName();
            if (pn.endsWith(".debug")) {
                pn = pn.substring(0, pn.length() - 6);
            }
            packageName = pn;
        }
        return packageName;
    }

    private static String getAppName(Context context) {
        if (gameName.equals("unknown") && context != null) {
            gameName = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        }
        return gameName;
    }

    private static String getDeviceId(Context context) {
        if (deviceId.equals("unknown") && context != null) {
            String product = Build.PRODUCT;
            String androidId = Secure.getString(context.getContentResolver(), "android_id");
            if (!(product == null || androidId == null)) {
                deviceId = product + "_" + androidId;
            }
        }
        return deviceId;
    }

    public static String getAdvertisingId(Context context) {
        Throwable e;
        try {
            if (advertisingIdAvailable == null) {
                loadAdvertisingId(context);
            }
            if (advertisingIdAvailable != null) {
                Boolean bool = (Boolean) advertisingIdAvailable.get();
            }
            return advertisingId;
        } catch (InterruptedException e2) {
            e = e2;
            Logger.trace(e);
            return advertisingId;
        } catch (ExecutionException e3) {
            e = e3;
            Logger.trace(e);
            return advertisingId;
        }
    }

    private static void loadAdvertisingId(Context context) {
        synchronized (advertiserIdLock) {
            if (advertisingIdAvailable == null || advertisingIdAvailable.isDone()) {
                advertisingIdAvailable = ExecutorPool.getInstance().submit(new AdvertisingIdCallable(context.getApplicationContext()));
            }
        }
    }

    public static Boolean getLimitAdTrackingEnabled(Context context) {
        Throwable e;
        try {
            if (advertisingIdAvailable == null) {
                loadAdvertisingId(context);
            }
            Boolean isAvailable = (Boolean) advertisingIdAvailable.get();
            return limitAdTrackingEnabled;
        } catch (InterruptedException e2) {
            e = e2;
            Logger.trace(e);
            return limitAdTrackingEnabled;
        } catch (ExecutionException e3) {
            e = e3;
            Logger.trace(e);
            return limitAdTrackingEnabled;
        }
    }

    public static void setAdvertisingId(String adId) {
        advertisingId = adId;
    }

    public static void setLimitAdTracking(Boolean enabled) {
        limitAdTrackingEnabled = enabled;
    }

    public static HashMap<String, String> extraParams(Context context) {
        DisplayMetrics dm;
        HashMap<String, String> params = new HashMap();
        synchronized (paramLock) {
            if (cachedParams == null) {
                String formFactor;
                cachedParams = new HashMap();
                Integer version = Integer.valueOf(0);
                try {
                    version = Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (Throwable e) {
                    Logger.trace(e);
                }
                cachedParams.put("app_version", String.valueOf(version));
                dm = context.getResources().getDisplayMetrics();
                cachedParams.put("sdk_version", "9.11.3");
                cachedParams.put("android_version", VERSION.SDK);
                cachedParams.put("external_package", getPackageName(context));
                cachedParams.put("game_package", getPackageName(context));
                cachedParams.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, getAppName(context));
                if (isTablet(context)) {
                    formFactor = "tablet";
                } else {
                    formFactor = "phone";
                }
                cachedParams.put("device_form_factor", formFactor);
                cachedParams.put("device_model", Build.MODEL);
                cachedParams.put("device_type", Build.DEVICE);
                String publisherId = HeyzapAds.config.publisherId;
                if (publisherId != null) {
                    cachedParams.put("publisher_sdk_key", publisherId);
                }
                if (isAmazon()) {
                    cachedParams.put("platform", "amazon");
                    cachedParams.put("sdk_platform", "amazon");
                } else {
                    cachedParams.put("platform", "android");
                    cachedParams.put("sdk_platform", "android");
                }
            }
            params.putAll(cachedParams);
        }
        if (getAdvertisingId(context) == null || isAmazon()) {
            params.put("device_id", getDeviceId(context));
        } else {
            params.put("device_id", getAdvertisingId(context));
            params.put("advertising_id", getAdvertisingId(context));
            params.put("tracking_enabled", !getLimitAdTrackingEnabled(context).booleanValue() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (HeyzapAds.mediator != null) {
            params.put("sdk_mediator", HeyzapAds.mediator);
        }
        if (HeyzapAds.framework != null) {
            params.put("sdk_framework", HeyzapAds.framework);
        }
        try {
            StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
            params.put("device_free_bytes", Long.toString(((long) stat.getBlockSize()) * ((long) stat.getAvailableBlocks())));
        } catch (Exception e2) {
            params.put("device_free_bytes", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale != null) {
            params.put("locale_country", locale.getCountry().toLowerCase(Locale.US));
            params.put("locale_lang", locale.getLanguage().toLowerCase(Locale.US));
        }
        params.put("connection_type", Connectivity.connectionType(context));
        dm = context.getResources().getDisplayMetrics();
        params.put("device_dpi", Float.toString(dm.density));
        if (!params.containsKey("device_width")) {
            params.put("device_width", String.valueOf(dm.widthPixels));
        }
        if (!params.containsKey("device_height")) {
            params.put("device_height", String.valueOf(dm.heightPixels));
        }
        return params;
    }

    public static boolean isAmazon() {
        return Build.MANUFACTURER.equals("Amazon") || HeyzapAds.config.store.equals("amazon");
    }

    public static int dpToPx(Context context, int dp) {
        density = density > 0.0f ? density : context.getResources().getDisplayMetrics().density;
        return (int) ((((float) dp) * density) + 0.5f);
    }

    public static int getScaledSize(Context context, int baseSize) {
        return getScaledSize(context, (float) baseSize);
    }

    private static int getScaledSize(Context context, float baseSize) {
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) (density * baseSize);
    }

    public static int getInverseScaledSize(Context context, int pixels) {
        return getInverseScaledSize(context, (float) pixels);
    }

    private static int getInverseScaledSize(Context context, float pixels) {
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) (pixels / density);
    }

    public static int getScaledSizeWithRelativeFlags(Context context, int dp) {
        if (dp <= 0) {
            return dp;
        }
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) (density * ((float) dp));
    }

    public static boolean packageIsInstalled(String packageName, Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            Intent pi = pm.getLaunchIntentForPackage(packageName);
            if (pi == null || pm.queryIntentActivities(pi, 65536).size() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String hex(byte[] array) {
        StringBuffer sb = new StringBuffer();
        for (byte b : array) {
            sb.append(Integer.toHexString((b & MotionEventCompat.ACTION_MASK) | 256).substring(1, 3));
        }
        return sb.toString();
    }

    public static String md5Hex(byte[] array) {
        try {
            byte[] hash = MessageDigest.getInstance("MD5").digest(array);
            return String.format("%032x", new Object[]{new BigInteger(1, hash)});
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String md5(String s) {
        String MD5 = "MD5";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(aMessageDigest & MotionEventCompat.ACTION_MASK);
                while (h.length() < 2) {
                    h = AppEventsConstants.EVENT_PARAM_VALUE_NO + h;
                }
                hexString.append(h);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isApplicationOnTop(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String applicationPackageName = context.getApplicationContext().getPackageName();
        try {
            List<RunningAppProcessInfo> processes = activityManager.getRunningAppProcesses();
            for (int i = 0; i < processes.size(); i++) {
                RunningAppProcessInfo process = (RunningAppProcessInfo) processes.get(i);
                if (process.processName.equals(applicationPackageName) && process.importance == 100) {
                    return true;
                }
            }
        } catch (Throwable e) {
            Logger.trace(e);
        }
        return false;
    }

    public static int getSdkVersion() {
        return VERSION.SDK_INT;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static void deleteDirectory(File root) {
        if (root.isDirectory()) {
            for (File file : root.listFiles()) {
                deleteDirectory(file);
            }
        }
        root.delete();
    }

    public static String getCachePath(Context context, String withFileName) {
        if (context == null || withFileName == null) {
            return null;
        }
        return String.format("%s/%s", new Object[]{getCacheDirAbsolutePath(context), withFileName});
    }

    public static String getCacheDirAbsolutePath(Context context) {
        if (context == null) {
            return null;
        }
        return String.format("%s/%s", new Object[]{context.getCacheDir(), "com.heyzap.sdk"});
    }

    public static String getImageCacheDirAbsolutePath(Context context) {
        if (context == null) {
            return null;
        }
        return String.format("%s/%s", new Object[]{context.getCacheDir(), IMAGE_CACHE_DIR});
    }

    public static void createCacheDir(Context context) {
        File dir = new File(getCacheDirAbsolutePath(context));
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static Integer getPackageVersion(Context context) {
        Integer version = Integer.valueOf(0);
        try {
            version = Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Throwable e) {
            Logger.trace(e);
        }
        return version;
    }

    public static Boolean classExists(String klassName) {
        try {
            Class.forName(klassName);
            return Boolean.valueOf(true);
        } catch (ClassNotFoundException e) {
            return Boolean.valueOf(false);
        }
    }

    public static Boolean isExpired(Long startTime, Integer ttlMillis) {
        if (((long) ttlMillis.intValue()) < System.currentTimeMillis() - startTime.longValue()) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public static boolean activityExistsInPackage(Activity activity, Class activityKlass) {
        if (new Intent(activity, activityKlass).resolveActivityInfo(activity.getPackageManager(), 0) != null) {
            return true;
        }
        return false;
    }

    public static boolean activityExistsInPackage(Activity activity, String classString) {
        try {
            return activityExistsInPackage(activity, Class.forName(classString));
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean packageHasPermissions(Activity activity, ArrayList<String> neededPermissions) {
        Iterator it = neededPermissions.iterator();
        while (it.hasNext()) {
            if (!packageHasPermission(activity, (String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean packageHasPermission(Activity activity, String permission) {
        return activity.getPackageManager().checkPermission(permission, activity.getPackageName()) == 0;
    }

    public static Boolean packageHasReceiver(Activity activity, String receiverName) {
        for (PackageInfo p : activity.getPackageManager().getInstalledPackages(2)) {
            if (p.packageName.equals(getPackageName(activity))) {
                ActivityInfo[] receivers = p.receivers;
                if (receivers != null) {
                    for (ActivityInfo ai : receivers) {
                        if (ai.name.equals(receiverName)) {
                            return Boolean.valueOf(true);
                        }
                    }
                }
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(false);
    }

    public static Boolean probablyHasGooglePlayServices(Activity activity) {
        for (PackageInfo p : activity.getPackageManager().getInstalledPackages(128)) {
            if (p.packageName.equals(getPackageName(activity))) {
                ApplicationInfo applicationInfo = p.applicationInfo;
                if (applicationInfo != null) {
                    Bundle metaData = applicationInfo.metaData;
                    if (metaData != null && metaData.containsKey("com.google.android.gms.version")) {
                        return Boolean.valueOf(true);
                    }
                }
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(false);
    }
}
