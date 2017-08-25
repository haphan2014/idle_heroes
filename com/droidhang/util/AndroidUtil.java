package com.droidhang.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinSdk;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import com.droidhang.pay.util.IabHelper;
import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.widget.WebDialog.FeedDialogBuilder;
import com.facebook.widget.WebDialog.OnCompleteListener;
import com.heyzap.sdk.ads.IncentivizedAd;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class AndroidUtil {
    private static Activity _activity;
    private static AppEventsLogger _facebookLogger;

    public static void init(Activity activity) {
        _activity = activity;
        _facebookLogger = AppEventsLogger.newLogger(_activity);
    }

    @SuppressLint({"NewApi"})
    public static void hideToolbar() {
        if (_activity != null) {
            int SDK_INT = VERSION.SDK_INT;
            if (SDK_INT >= 11 && SDK_INT < 14) {
                _activity.getWindow().getDecorView().setSystemUiVisibility(1);
            } else if (SDK_INT >= 14 && SDK_INT < 19) {
                _activity.getWindow().getDecorView().setSystemUiVisibility(5);
            } else if (SDK_INT >= 19) {
                setImmersiveSticky();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static void setImmersiveSticky() {
        _activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public static boolean isFacebookInstalled() {
        try {
            _activity.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void printKeyHash() {
        try {
            for (Signature signature : _activity.getPackageManager().getPackageInfo(_activity.getApplicationContext().getPackageName(), 64).signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash", "KeyHash:" + Base64.encodeToString(md.digest(), 0));
            }
        } catch (NameNotFoundException e) {
            Log.e("KeyHash", "KeyHash", e);
        } catch (NoSuchAlgorithmException e2) {
            Log.e("KeyHash", "KeyHash", e2);
        }
    }

    public static void shareFacebook(String name, String caption, String description, String picture, String link) {
        final String str = name;
        final String str2 = caption;
        final String str3 = description;
        final String str4 = picture;
        final String str5 = link;
        _activity.runOnUiThread(new Runnable() {

            class C02161 implements OnCompleteListener {
                C02161() {
                }

                public void onComplete(Bundle values, FacebookException error) {
                    if (error != null || values == null || values.getString("post_id") == null) {
                        Log.e("FacebookSDK", "share fail", error);
                    } else {
                        Log.e("FacebookSDK", "share succeed");
                    }
                }
            }

            public void run() {
                ((FeedDialogBuilder) new FeedDialogBuilder(AndroidUtil._activity).setName(str).setCaption(str2).setDescription(str3).setPicture(str4).setLink(str5).setOnCompleteListener(new C02161())).build().show();
            }
        });
    }

    public static void trackPaymentFacebook(double money, String currency) {
        Log.e("trackPayment", "trackPaymentFacebook " + money + " " + currency);
        _facebookLogger.logPurchase(BigDecimal.valueOf(money), Currency.getInstance(currency));
    }

    public static void trackPaymentAppLovin(double money, String currency) {
        Log.e("trackPayment", "trackPaymentAppLovin " + money + " " + currency);
        AppLovinEventService eventService = AppLovinSdk.getInstance(_activity).getEventService();
        Map<String, String> parameters = new HashMap();
        parameters.put(AppLovinEventParameters.REVENUE_AMOUNT, "" + money);
        parameters.put(AppLovinEventParameters.REVENUE_CURRENCY, currency);
        Intent emptyIntent = new Intent();
        emptyIntent.putExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA, "");
        emptyIntent.putExtra(IabHelper.RESPONSE_INAPP_SIGNATURE, "");
        eventService.trackInAppPurchase(emptyIntent, parameters);
    }

    public static void trackPaymentAppsFlyer(double money, String currency) {
        Log.e("trackPayment", "trackPaymentAppsFlyer " + money + " " + currency);
        Map<String, Object> paramsAF = new HashMap();
        paramsAF.put(AFInAppEventParameterName.REVENUE, Double.valueOf(money));
        paramsAF.put(AFInAppEventParameterName.CURRENCY, currency);
        AppsFlyerLib.getInstance().trackEvent(_activity.getApplicationContext(), AFInAppEventType.PURCHASE, paramsAF);
    }

    public static void trackDHAppsFlyer(String event, String name, String value) {
        Log.e("trackDHAppsFlyer", "trackDHAppsFlyer " + event + ": " + name + "-" + value);
        Map<String, Object> paramsAF = new HashMap();
        paramsAF.put(name, value);
        AppsFlyerLib.getInstance().trackEvent(_activity.getApplicationContext(), event, paramsAF);
    }

    public static void trackLevelAppsFlyer(int lv) {
        Log.e("trackLevel", "trackLevelAppsFlyer " + lv);
        Map<String, Object> paramsAF = new HashMap();
        paramsAF.put(AFInAppEventParameterName.LEVEL, Integer.valueOf(lv));
        AppsFlyerLib.getInstance().trackEvent(_activity.getApplicationContext(), AFInAppEventType.LEVEL_ACHIEVED, paramsAF);
    }

    public static boolean isVideoAdReady() {
        boolean ready = IncentivizedAd.isAvailable().booleanValue();
        Log.e("droidhang", "HZIncentivizedAd videoAd ready:" + ready);
        return ready;
    }

    public static void showVideoAd(String uid) {
        if (isVideoAdReady()) {
            IncentivizedAd.display(_activity);
            IncentivizedAd.fetch();
        }
    }

    public static boolean isLowMemory() {
        ActivityManager activityManager = (ActivityManager) _activity.getSystemService("activity");
        MemoryInfo info = new MemoryInfo();
        activityManager.getMemoryInfo(info);
        if (info.lowMemory) {
            return true;
        }
        return false;
    }
}
