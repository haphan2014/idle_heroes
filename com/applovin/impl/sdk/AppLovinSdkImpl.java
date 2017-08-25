package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinTargetingData;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class AppLovinSdkImpl extends AppLovinSdk {
    private String f320a;
    private AppLovinSdkSettings f321b;
    private Context f322c;
    private AppLovinLogger f323d;
    private cy f324e;
    private cg f325f;
    private C0164o f326g;
    private ci f327h;
    private aa f328i;
    private C0149b f329j;
    private bi f330k;
    private C0166r f331l;
    private C0162m f332m;
    private AppLovinAdServiceImpl f333n;
    private bk f334o;
    private PostbackServiceImpl f335p;
    private EventServiceImpl f336q;
    private bt f337r;
    private boolean f338s = true;
    private boolean f339t = false;
    private boolean f340u = false;
    private boolean f341v = false;
    private boolean f342w = false;
    private boolean f343x = false;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m250a(android.content.Context r7) {
        /*
        r6 = this;
        r5 = 642; // 0x282 float:9.0E-43 double:3.17E-321;
        r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r7);
        r0 = "com.applovin.sdk.impl.lastKnownVersionCode";
        r2 = 0;
        r0 = r1.getInt(r0, r2);	 Catch:{ Exception -> 0x003a }
        if (r0 >= r5) goto L_0x0032;
    L_0x000f:
        r0 = "AppLovinSdkImpl";
        r2 = "SDK has been updated since last run. Continuing...";
        android.util.Log.i(r0, r2);	 Catch:{ Exception -> 0x003a }
        r0 = r6.getSettingsManager();	 Catch:{ Exception -> 0x003a }
        r0.m507d();	 Catch:{ Exception -> 0x003a }
        r0 = r6.getSettingsManager();	 Catch:{ Exception -> 0x003a }
        r0.m505b();	 Catch:{ Exception -> 0x003a }
    L_0x0024:
        r0 = r1.edit();
        r1 = "com.applovin.sdk.impl.lastKnownVersionCode";
        r0 = r0.putInt(r1, r5);
        r0.apply();
    L_0x0031:
        return;
    L_0x0032:
        r0 = "AppLovinSdkImpl";
        r2 = "SDK has not been updated since last run. Continuing...";
        android.util.Log.d(r0, r2);	 Catch:{ Exception -> 0x003a }
        goto L_0x0024;
    L_0x003a:
        r0 = move-exception;
        r2 = r6.getLogger();	 Catch:{ all -> 0x0054 }
        r3 = "AppLovinSdkImpl";
        r4 = "Unable to check for SDK update";
        r2.mo637e(r3, r4, r0);	 Catch:{ all -> 0x0054 }
        r0 = r1.edit();
        r1 = "com.applovin.sdk.impl.lastKnownVersionCode";
        r0 = r0.putInt(r1, r5);
        r0.apply();
        goto L_0x0031;
    L_0x0054:
        r0 = move-exception;
        r1 = r1.edit();
        r2 = "com.applovin.sdk.impl.lastKnownVersionCode";
        r1 = r1.putInt(r2, r5);
        r1.apply();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinSdkImpl.a(android.content.Context):void");
    }

    private static boolean m251i() {
        return (VERSION.RELEASE.startsWith("1.") || VERSION.RELEASE.startsWith("2.0") || VERSION.RELEASE.startsWith("2.1")) ? false : true;
    }

    cy m252a() {
        return this.f324e;
    }

    Object m253a(cf cfVar) {
        return this.f325f.m501a(cfVar);
    }

    void m254a(boolean z) {
        this.f338s = false;
        this.f339t = z;
        this.f340u = true;
    }

    ci m255b() {
        return this.f327h;
    }

    C0149b m256c() {
        return this.f329j;
    }

    public boolean checkCorrectInitialization(Context context) {
        try {
            getLogger().mo635d(AppLovinLogger.SDK_TAG, "Checking if sdk is initialized in main activity...");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            String stackTraceString = Log.getStackTraceString(new Throwable());
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null) {
                getLogger().mo635d(AppLovinLogger.SDK_TAG, "Found " + queryIntentActivities.size() + " main activities for this application");
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (stackTraceString.contains(resolveInfo.activityInfo.name)) {
                        return true;
                    }
                }
            }
            getLogger().mo641w(AppLovinLogger.SDK_TAG, "AppLovin SDK was initialized too late in session; SDK should always be initialized within main activity and/or any relevant entry points");
            getLogger().mo641w(AppLovinLogger.SDK_TAG, "Initialization instead happened from: " + stackTraceString);
        } catch (Throwable th) {
            getLogger().mo637e(AppLovinLogger.SDK_TAG, "Error checking if sdk is initialized in main activity...", th);
        }
        return false;
    }

    bi m257d() {
        return this.f330k;
    }

    boolean m258e() {
        return this.f338s;
    }

    boolean m259f() {
        return this.f340u;
    }

    void m260g() {
        this.f338s = true;
        this.f324e.m651a(new cx(this), 0);
    }

    public AppLovinAdService getAdService() {
        return this.f333n;
    }

    public Context getApplicationContext() {
        return this.f322c;
    }

    public C0164o getConnectionManager() {
        return this.f326g;
    }

    public C0166r getDataCollector() {
        return this.f331l;
    }

    public AppLovinEventService getEventService() {
        return this.f336q;
    }

    public aa getFileManager() {
        return this.f328i;
    }

    public AppLovinLogger getLogger() {
        return this.f323d;
    }

    public AppLovinNativeAdService getNativeAdService() {
        return this.f334o;
    }

    public bt getPersistentPostbackManager() {
        return this.f337r;
    }

    public PostbackServiceImpl getPostbackService() {
        return this.f335p;
    }

    public String getSdkKey() {
        return this.f320a;
    }

    public AppLovinSdkSettings getSettings() {
        return this.f321b;
    }

    public cg getSettingsManager() {
        return this.f325f;
    }

    public AppLovinTargetingData getTargetingData() {
        return this.f332m;
    }

    void m261h() {
        this.f325f.m507d();
        this.f325f.m505b();
        this.f327h.m554a();
    }

    public boolean hasCriticalErrors() {
        return this.f341v || this.f342w;
    }

    public void initialize(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.f320a = str;
        this.f321b = appLovinSdkSettings;
        this.f322c = context;
        try {
            C0160k c0160k = new C0160k();
            this.f323d = c0160k;
            this.f325f = new cg(this);
            this.f324e = new cy(this);
            this.f326g = new C0164o(this);
            this.f327h = new ci(this);
            this.f328i = new aa(this);
            this.f331l = new C0166r(this);
            this.f333n = new AppLovinAdServiceImpl(this);
            this.f334o = new bk(this);
            this.f335p = new PostbackServiceImpl(this);
            this.f336q = new EventServiceImpl(this);
            this.f337r = new bt(this);
            this.f329j = new C0149b(this);
            this.f330k = new bi(this);
            this.f332m = new C0162m(this);
            if (!m251i()) {
                this.f341v = true;
                Log.e(AppLovinLogger.SDK_TAG, "Unable to initalize AppLovin SDK: Android SDK version has to be at least level 8");
            }
            if (str == null || str.length() < 1) {
                this.f342w = true;
                Log.e(AppLovinLogger.SDK_TAG, "Unable to find AppLovin SDK key. Please add     meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
                Writer stringWriter = new StringWriter();
                new Throwable("").printStackTrace(new PrintWriter(stringWriter));
                Log.e(AppLovinLogger.SDK_TAG, "Called with an invalid SDK key from: " + stringWriter.toString());
            }
            if (hasCriticalErrors()) {
                m254a(false);
                return;
            }
            c0160k.m717a(this.f325f);
            if (appLovinSdkSettings instanceof bd) {
                c0160k.m718a(((bd) appLovinSdkSettings).m378a());
            }
            m250a(context);
            this.f325f.m506c();
            if (((Boolean) this.f325f.m501a(cd.f563b)).booleanValue()) {
                this.f325f.m503a(appLovinSdkSettings);
                this.f325f.m505b();
            }
            m260g();
        } catch (Throwable th) {
            Log.e(AppLovinLogger.SDK_TAG, "Failed to load AppLovin SDK, ad serving will be disabled", th);
            m254a(false);
        }
    }

    public void initializeSdk() {
    }

    public boolean isEnabled() {
        return this.f339t;
    }

    public boolean isInitializedInMainActivity() {
        return this.f343x;
    }

    public void setInitializedInMainActivity(boolean z) {
        this.f343x = z;
    }

    public void setPluginVersion(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No version specified");
        }
        this.f325f.m502a(cd.f587z, str);
        this.f325f.m505b();
    }
}
