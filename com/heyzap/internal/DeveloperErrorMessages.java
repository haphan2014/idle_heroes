package com.heyzap.internal;

import android.os.Build.VERSION;

public class DeveloperErrorMessages {
    public static final String ACTIVITIES_NOT_PRESENT = "Heyzap not started! You must add the following activities to your AndroidManifest.xml application tag: <activity android:name=\"com.heyzap.sdk.ads.HeyzapInterstitialActivity\" android:configChanges=\"keyboardHidden|screenSize|smallestScreenSize\" /><activity android:name=\"com.heyzap.sdk.ads.HeyzapVideoActivity\" android:screenOrientation=\"landscape\" android:configChanges=\"keyboardHidden|screenSize|smallestScreenSize\" />";
    public static final String GPS_NOT_INSTALLED = "Google Play Services does not appear to be present. This may reduce your revenue! Find out more here: http://developer.android.com/google/play-services/setup.html";
    public static final String HEYZAP_BAD_CONTEXT = "Heyzap was not successfully started: Context is not an activity, and flag DISABLE_MEDIATION not set.";
    public static final String HEYZAP_NOT_STARTED = "Heyzap needs to be started. Call HeyzapAds.start('<publisher_id>', activity) from either the onCreate or onResume methods in your Activity.";
    public static final String HEYZAP_RUNTIME_EXCEPTION = "Heyzap encountered a runtime exception and is now disabled. Error: %s";
    public static final String LOG_TAG = "Heyzap";
    public static final String PERMISSIONS_NOT_PRESENT = "Heyzap not started! You must add the following permissions to your AndroidManifest.xml <uses-permission android:name=\"android.permission.INTERNET\" /><uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />";
    public static final String RECEIVER_NOT_PRESENT = "Heyzap could not find the install broadcast receiver. You may be sacrificing revenue!. Add this to your AndroidManifest.xml: <receiver android:name=\"com.heyzap.sdk.ads.PackageAddedReceiver\"><intent-filter><data android:scheme=\"package\"/><action android:name=\"android.intent.action.PACKAGE_ADDED\"/></intent-filter></receiver>";
    public static final String TEST_ACTIVITY_NOT_PRESENT = "You need to add the test activity manifest to your AndroidManifest.xml: <activity android:name=\"com.heyzap.sdk.ads.MediationTestActivity\" />";
    public static final String UNSUPPORTED_ANDROID_SDK_VERSION = String.format("SDK version %i is not supported, disabling Heyzap Ads.", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
}
