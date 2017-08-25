package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.appsflyer.AppsFlyerLib;
import com.facebook.Request.Callback;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public final class Settings {
    private static final String ANALYTICS_EVENT = "event";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse(AppsFlyerLib.ATTRIBUTION_ID_CONTENT_URI);
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new C02621();
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final String FACEBOOK_COM = "facebook.com";
    private static final Object LOCK = new Object();
    private static final String MOBILE_INSTALL_EVENT = "MOBILE_APP_INSTALL";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = Settings.class.getCanonicalName();
    private static volatile String appClientToken;
    private static volatile String appVersion;
    private static volatile String applicationId;
    private static volatile boolean defaultsLoaded = false;
    private static volatile Executor executor;
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static volatile boolean isDebugEnabled = false;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static volatile boolean platformCompatibilityEnabled;
    private static Boolean sdkInitialized = Boolean.valueOf(false);

    static class C02621 implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger(0);

        C02621() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
        }
    }

    public static synchronized void sdkInitialize(Context context) {
        synchronized (Settings.class) {
            if (!sdkInitialized.booleanValue()) {
                loadDefaultsFromMetadataIfNeeded(context);
                Utility.loadAppSettingsAsync(context, getApplicationId());
                BoltsMeasurementEventListener.getInstance(context.getApplicationContext());
                sdkInitialized = Boolean.valueOf(true);
            }
        }
    }

    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        synchronized (loggingBehaviors) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
        }
        return unmodifiableSet;
    }

    public static final void addLoggingBehavior(LoggingBehavior behavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(behavior);
        }
    }

    public static final void removeLoggingBehavior(LoggingBehavior behavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(behavior);
        }
    }

    public static final void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
        }
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior behavior) {
        boolean z;
        synchronized (loggingBehaviors) {
            z = isDebugEnabled() && loggingBehaviors.contains(behavior);
        }
        return z;
    }

    @Deprecated
    public static final boolean isLoggingEnabled() {
        return isDebugEnabled();
    }

    @Deprecated
    public static final void setIsLoggingEnabled(boolean enabled) {
        setIsDebugEnabled(enabled);
    }

    public static final boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static final void setIsDebugEnabled(boolean enabled) {
        isDebugEnabled = enabled;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                Executor executor = getAsyncTaskExecutor();
                if (executor == null) {
                    executor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, DEFAULT_WORK_QUEUE, DEFAULT_THREAD_FACTORY);
                }
                executor = executor;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor) {
        Validate.notNull(executor, "executor");
        synchronized (LOCK) {
            executor = executor;
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static void setFacebookDomain(String facebookDomain) {
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = facebookDomain;
    }

    private static Executor getAsyncTaskExecutor() {
        try {
            try {
                Object executorObject = AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null);
                if (executorObject == null) {
                    return null;
                }
                if (executorObject instanceof Executor) {
                    return (Executor) executorObject;
                }
                return null;
            } catch (IllegalAccessException e) {
                return null;
            }
        } catch (NoSuchFieldException e2) {
            return null;
        }
    }

    static void publishInstallAsync(Context context, final String applicationId, final Callback callback) {
        final Context applicationContext = context.getApplicationContext();
        getExecutor().execute(new Runnable() {
            public void run() {
                final Response response = Settings.publishInstallAndWaitForResponse(applicationContext, applicationId);
                if (callback != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            callback.onCompleted(response);
                        }
                    });
                }
            }
        });
    }

    static Response publishInstallAndWaitForResponse(Context context, String applicationId) {
        if (context == null || applicationId == null) {
            try {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            } catch (Exception e) {
                Utility.logd("Facebook-publish", e);
                return new Response(null, null, new FacebookRequestError(null, e));
            }
        }
        AttributionIdentifiers identifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        SharedPreferences preferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
        String pingKey = applicationId + "ping";
        String jsonKey = applicationId + "json";
        long lastPing = preferences.getLong(pingKey, 0);
        String lastResponseJSON = preferences.getString(jsonKey, null);
        GraphObject publishParams = Factory.create();
        publishParams.setProperty("event", MOBILE_INSTALL_EVENT);
        Utility.setAppEventAttributionParameters(publishParams, identifiers, AppEventsLogger.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context));
        publishParams.setProperty("application_package_name", context.getPackageName());
        Request publishRequest = Request.newPostRequest(null, String.format(PUBLISH_ACTIVITY_PATH, new Object[]{applicationId}), publishParams, null);
        if (lastPing != 0) {
            GraphObject graphObject = null;
            if (lastResponseJSON != null) {
                try {
                    graphObject = Factory.create(new JSONObject(lastResponseJSON));
                } catch (JSONException e2) {
                }
            }
            if (graphObject != null) {
                return new Response(null, null, null, graphObject, true);
            }
            return (Response) Response.createResponsesFromString(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, null, new RequestBatch(publishRequest), true).get(0);
        }
        Response publishResponse = publishRequest.executeAndWait();
        Editor editor = preferences.edit();
        editor.putLong(pingKey, System.currentTimeMillis());
        if (!(publishResponse.getGraphObject() == null || publishResponse.getGraphObject().getInnerJSONObject() == null)) {
            editor.putString(jsonKey, publishResponse.getGraphObject().getInnerJSONObject().toString());
        }
        editor.apply();
        return publishResponse;
    }

    public static String getAttributionId(ContentResolver contentResolver) {
        String str = null;
        Cursor c = null;
        try {
            ContentResolver contentResolver2 = contentResolver;
            c = contentResolver2.query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid"}, null, null, null);
            if (c == null || !c.moveToFirst()) {
                if (c != null) {
                    c.close();
                }
                return str;
            }
            str = c.getString(c.getColumnIndex("aid"));
            if (c != null) {
                c.close();
            }
            return str;
        } catch (Exception e) {
            Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + e.toString());
            if (c != null) {
                c.close();
            }
        } catch (Throwable th) {
            if (c != null) {
                c.close();
            }
        }
    }

    public static String getAppVersion() {
        return appVersion;
    }

    public static void setAppVersion(String appVersion) {
        appVersion = appVersion;
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static void setLimitEventAndDataUsage(Context context, boolean limitEventUsage) {
        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", limitEventUsage).apply();
    }

    public static long getOnProgressThreshold() {
        return onProgressThreshold.get();
    }

    public static void setOnProgressThreshold(long threshold) {
        onProgressThreshold.set(threshold);
    }

    public static boolean getPlatformCompatibilityEnabled() {
        return platformCompatibilityEnabled;
    }

    public static void setPlatformCompatibilityEnabled(boolean platformCompatibilityEnabled) {
        platformCompatibilityEnabled = platformCompatibilityEnabled;
    }

    public static void loadDefaultsFromMetadata(Context context) {
        defaultsLoaded = true;
        if (context != null) {
            try {
                ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (ai != null && ai.metaData != null) {
                    if (applicationId == null) {
                        applicationId = ai.metaData.getString(APPLICATION_ID_PROPERTY);
                    }
                    if (appClientToken == null) {
                        appClientToken = ai.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                }
            } catch (NameNotFoundException e) {
            }
        }
    }

    static void loadDefaultsFromMetadataIfNeeded(Context context) {
        if (!defaultsLoaded) {
            loadDefaultsFromMetadata(context);
        }
    }

    public static String getApplicationSignature(Context context) {
        if (context == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            PackageInfo pInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatures = pInfo.signatures;
            if (signatures == null || signatures.length == 0) {
                return null;
            }
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(pInfo.signatures[0].toByteArray());
                return Base64.encodeToString(md.digest(), 9);
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        } catch (NameNotFoundException e2) {
            return null;
        }
    }

    public static String getApplicationId() {
        return applicationId;
    }

    public static void setApplicationId(String applicationId) {
        applicationId = applicationId;
    }

    public static String getClientToken() {
        return appClientToken;
    }

    public static void setClientToken(String clientToken) {
        appClientToken = clientToken;
    }
}
