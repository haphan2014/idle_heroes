package com.vungle.publisher.env;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.vungle.publisher.agb;
import com.vungle.publisher.age;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.mc;
import com.vungle.publisher.pj;
import com.vungle.publisher.qh;
import com.vungle.publisher.so;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class AndroidDevice implements pj {
    static int f1766a = FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS;
    final AtomicBoolean f1767b = new AtomicBoolean();
    public boolean f1768c;
    public String f1769d;
    public String f1770e;
    @Inject
    public mc f1771f;
    @Inject
    public WindowManager f1772g;
    @Inject
    public Context f1773h;
    @Inject
    public qh f1774i;
    @Inject
    public SharedPreferences f1775j;
    @Inject
    public DeviceIdStrategy f1776k;
    @Inject
    public String f1777l;
    private final String f1778m = VERSION.RELEASE;

    /* compiled from: vungle */
    public static abstract class DeviceIdStrategy {
        public abstract void mo4521c(AndroidDevice androidDevice);
    }

    private void m1605r() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0073 in list [B:36:0x006c]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r8 = 5;
        r7 = 0;
        r0 = r9.f1767b;	 Catch:{ all -> 0x0045 }
        r0 = r0.get();	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0066;	 Catch:{ all -> 0x0045 }
    L_0x000a:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0045 }
        r2 = f1766a;	 Catch:{ all -> 0x0045 }
        r2 = (long) r2;	 Catch:{ all -> 0x0045 }
        r0 = r0 + r2;	 Catch:{ all -> 0x0045 }
        r2 = r9.f1767b;	 Catch:{ all -> 0x0045 }
        monitor-enter(r2);	 Catch:{ all -> 0x0045 }
        r3 = "VungleDevice";	 Catch:{ InterruptedException -> 0x0037 }
        r4 = "waiting for device ID";	 Catch:{ InterruptedException -> 0x0037 }
        r5 = 3;	 Catch:{ InterruptedException -> 0x0037 }
        r6 = 0;	 Catch:{ InterruptedException -> 0x0037 }
        com.vungle.publisher.so.m2470a(r5, r3, r4, r6);	 Catch:{ InterruptedException -> 0x0037 }
    L_0x001e:
        r3 = r9.f1767b;	 Catch:{ InterruptedException -> 0x0037 }
        r3 = r3.get();	 Catch:{ InterruptedException -> 0x0037 }
        if (r3 != 0) goto L_0x0054;	 Catch:{ InterruptedException -> 0x0037 }
    L_0x0026:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ InterruptedException -> 0x0037 }
        r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r3 >= 0) goto L_0x0054;
    L_0x002e:
        r3 = r9.f1767b;	 Catch:{ InterruptedException -> 0x0037 }
        r4 = f1766a;	 Catch:{ InterruptedException -> 0x0037 }
        r4 = (long) r4;	 Catch:{ InterruptedException -> 0x0037 }
        r3.wait(r4);	 Catch:{ InterruptedException -> 0x0037 }
        goto L_0x001e;
    L_0x0037:
        r3 = move-exception;
        r3 = "VungleDevice";	 Catch:{ InterruptedException -> 0x0037 }
        r4 = "interrupted while awaiting device ID";	 Catch:{ InterruptedException -> 0x0037 }
        r5 = 2;	 Catch:{ InterruptedException -> 0x0037 }
        r6 = 0;	 Catch:{ InterruptedException -> 0x0037 }
        com.vungle.publisher.so.m2470a(r5, r3, r4, r6);	 Catch:{ InterruptedException -> 0x0037 }
        goto L_0x001e;	 Catch:{ InterruptedException -> 0x0037 }
    L_0x0042:
        r0 = move-exception;	 Catch:{ InterruptedException -> 0x0037 }
        monitor-exit(r2);	 Catch:{ InterruptedException -> 0x0037 }
        throw r0;	 Catch:{ all -> 0x0045 }
    L_0x0045:
        r0 = move-exception;
        r1 = r9.m1614f();
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "VungleDevice";
        r2 = "no device ID available";
        com.vungle.publisher.so.m2470a(r8, r1, r2, r7);
    L_0x0053:
        throw r0;
    L_0x0054:
        monitor-exit(r2);	 Catch:{ InterruptedException -> 0x0037 }
        r0 = r9.f1767b;	 Catch:{ all -> 0x0045 }
        r0 = r0.get();	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x0074;	 Catch:{ all -> 0x0045 }
    L_0x005d:
        r0 = "VungleDevice";	 Catch:{ all -> 0x0045 }
        r1 = "obtained device ID";	 Catch:{ all -> 0x0045 }
        r2 = 3;	 Catch:{ all -> 0x0045 }
        r3 = 0;	 Catch:{ all -> 0x0045 }
        com.vungle.publisher.so.m2470a(r2, r0, r1, r3);	 Catch:{ all -> 0x0045 }
    L_0x0066:
        r0 = r9.m1614f();
        if (r0 != 0) goto L_0x0073;
    L_0x006c:
        r0 = "VungleDevice";
        r1 = "no device ID available";
        com.vungle.publisher.so.m2470a(r8, r0, r1, r7);
    L_0x0073:
        return;
    L_0x0074:
        r0 = new com.vungle.publisher.pk;	 Catch:{ all -> 0x0045 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0045 }
        r2 = "timeout after ";	 Catch:{ all -> 0x0045 }
        r1.<init>(r2);	 Catch:{ all -> 0x0045 }
        r2 = f1766a;	 Catch:{ all -> 0x0045 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0045 }
        r2 = " ms";	 Catch:{ all -> 0x0045 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0045 }
        r1 = r1.toString();	 Catch:{ all -> 0x0045 }
        r0.<init>(r1);	 Catch:{ all -> 0x0045 }
        throw r0;	 Catch:{ all -> 0x0045 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.env.AndroidDevice.r():void");
    }

    @Inject
    public AndroidDevice() {
        Injector.m1974b().mo4527a(this);
    }

    public final String mo4423a() {
        m1605r();
        return this.f1769d;
    }

    public final boolean m1609b() {
        return !TextUtils.isEmpty(this.f1769d);
    }

    public final String mo4426c() {
        m1605r();
        String str = this.f1770e;
        if (!m1604a(str) || !m1609b()) {
            return str;
        }
        so.m2470a(5, "VungleDevice", "have advertising and Android ID", null);
        m1612d();
        return null;
    }

    public final void m1612d() {
        so.m2470a(4, "VungleDevice", "clearing Android ID", null);
        this.f1770e = null;
    }

    public static boolean m1604a(String str) {
        return !TextUtils.isEmpty(str);
    }

    public final void m1613e() {
        if (!this.f1767b.getAndSet(true)) {
            synchronized (this.f1767b) {
                this.f1767b.notifyAll();
            }
        }
    }

    public final boolean m1614f() {
        return m1609b() || m1604a(this.f1770e);
    }

    public final String mo4427g() {
        return this.f1778m;
    }

    public final DisplayMetrics mo4428h() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            this.f1772g.getDefaultDisplay().getMetrics(displayMetrics);
        } catch (Throwable e) {
            so.m2470a(3, "VungleDevice", "error getting display metrics", e);
        }
        return displayMetrics;
    }

    public final boolean mo4429i() {
        return this.f1768c;
    }

    public final String mo4430j() {
        try {
            return (Build.MANUFACTURER == null ? "" : Build.MANUFACTURER) + "," + (Build.MODEL == null ? "" : Build.MODEL);
        } catch (Throwable e) {
            so.m2470a(3, "VungleDevice", "error getting device model", e);
            return null;
        }
    }

    public final Float mo4431k() {
        Float f = null;
        try {
            f = Float.valueOf(this.f1771f.m2162b());
        } catch (Throwable e) {
            so.m2470a(3, "VungleDevice", "error getting volume info", e);
        }
        return f;
    }

    public final boolean mo4432l() {
        boolean equals = "mounted".equals(Environment.getExternalStorageState());
        boolean a = age.m1211a(this.f1773h);
        if (a && equals) {
            so.m2470a(2, "VungleDevice", "external storage writable", null);
        } else {
            so.m2470a(5, "VungleDevice", "external storage not writable", null);
        }
        return a && equals;
    }

    public final boolean mo4433m() {
        return m1610b("VungleDevice");
    }

    public final boolean m1610b(String str) {
        boolean z;
        Throwable e;
        Throwable th;
        try {
            int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f1773h);
            z = isGooglePlayServicesAvailable == 0;
            if (!z) {
                try {
                    so.m2470a(4, str, "Google Play Services not available: " + GooglePlayServicesUtil.getErrorString(isGooglePlayServicesAvailable), null);
                } catch (IllegalStateException e2) {
                    e = e2;
                    so.m2470a(5, "VungleConfig", agb.m1208a(e), null);
                    return z;
                } catch (NoClassDefFoundError e3) {
                    e = e3;
                    so.m2470a(3, str, e.getClass().getSimpleName() + ": " + e.getMessage(), null);
                    so.m2470a(2, str, null, e);
                    return z;
                }
            }
        } catch (Throwable e4) {
            th = e4;
            z = false;
            e = th;
            so.m2470a(5, "VungleConfig", agb.m1208a(e), null);
            return z;
        } catch (Throwable e42) {
            th = e42;
            z = false;
            e = th;
            so.m2470a(3, str, e.getClass().getSimpleName() + ": " + e.getMessage(), null);
            so.m2470a(2, str, null, e);
            return z;
        }
        return z;
    }

    public final void mo4435o() {
        this.f1776k.mo4521c(this);
    }

    public final String mo4436p() {
        return this.f1775j.getString("defaultUserAgent", null);
    }

    public final boolean mo4425a(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public final Long mo4437q() {
        try {
            StatFs statFs = new StatFs(new File(this.f1777l).getPath());
            if (VERSION.SDK_INT >= 18) {
                return Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
            }
            return Long.valueOf((long) (statFs.getAvailableBlocks() * statFs.getBlockSize()));
        } catch (Exception e) {
            return null;
        }
    }

    public final String mo4434n() {
        if (m1610b("VungleDevice")) {
            return Integer.toString(4030500);
        }
        return null;
    }

    public final void mo4424a(WebView webView) {
        this.f1775j.edit().putString("defaultUserAgent", webView.getSettings().getUserAgentString()).apply();
    }
}
