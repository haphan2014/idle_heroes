package com.vungle.publisher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.vungle.publisher.ce.C1713b;
import com.vungle.publisher.gx.C1778a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class pu {
    @Inject
    Context f2932a;
    @Inject
    agg f2933b;
    @Inject
    cn f2934c;
    @Inject
    pj f2935d;
    @Inject
    qh f2936e;
    @Inject
    mg f2937f;
    @Inject
    uo f2938g;
    @Inject
    ce f2939h;
    @Inject
    public pl f2940i;
    @Inject
    xp f2941j;
    @Inject
    C1778a f2942k;
    @Inject
    public SharedPreferences f2943l;
    long f2944m;
    final AtomicInteger f2945n = new AtomicInteger();
    public final AtomicBoolean f2946o = new AtomicBoolean();

    @Inject
    pu() {
    }

    public final void m2347a() {
        this.f2946o.set(false);
    }

    public final void m2348a(long j) {
        this.f2943l.edit().putLong("VgSleepWakeupTime", System.currentTimeMillis() + j).apply();
    }

    public final void m2349a(boolean z) {
        Object obj;
        BroadcastReceiver broadcastReceiver = this.f2937f;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        broadcastReceiver.f2568a.registerReceiver(broadcastReceiver, intentFilter);
        broadcastReceiver = this.f2938g;
        broadcastReceiver.f3378b.registerReceiver(broadcastReceiver, uo.f3377a);
        broadcastReceiver = this.f2934c;
        broadcastReceiver.f1507a.registerReceiver(broadcastReceiver, new IntentFilter("com.vungle.publisher.db.DUMP_TABLES"));
        this.f2935d.mo4435o();
        this.f2939h.m1243a(C1713b.sessionEnd);
        if (aga.m1207a(this.f2945n)) {
            this.f2944m = System.currentTimeMillis();
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f2941j.m2613a(this.f2944m);
        }
        if (z) {
            this.f2936e.m2361a(new ax());
        }
    }

    public final long m2350b() {
        final long currentTimeMillis = System.currentTimeMillis();
        final long j = this.f2944m;
        final int i = this.f2945n.get();
        BroadcastReceiver broadcastReceiver = this.f2937f;
        try {
            broadcastReceiver.f2568a.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e) {
            so.m2470a(5, "VungleDevice", "error unregistering external storage state broadcast receiver - not registered", null);
        }
        broadcastReceiver = this.f2938g;
        try {
            broadcastReceiver.f3378b.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e2) {
            so.m2470a(5, "VungleNetwork", "error unregistering network broadcast receiver - not registered", null);
        }
        broadcastReceiver = this.f2934c;
        try {
            broadcastReceiver.f1507a.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e3) {
            so.m2470a(5, "VungleDumpDatabase", "error unregistering database broadcast receiver - not registered", null);
        }
        this.f2939h.m1246a(new Runnable(this) {
            final /* synthetic */ pu f2931d;

            public final void run() {
                Object obj = null;
                try {
                    pu puVar = this.f2931d;
                    if (puVar.f2945n.compareAndSet(i, 0)) {
                        puVar.f2944m = 0;
                        obj = 1;
                    }
                    if (obj != null) {
                        this.f2931d.f2941j.m2614a(j, currentTimeMillis);
                    }
                } catch (Throwable e) {
                    this.f2931d.f2942k.m1865a("VungleAd", "error sending session end", e);
                }
            }
        }, C1713b.sessionEndTimer, 10000);
        return currentTimeMillis;
    }
}
