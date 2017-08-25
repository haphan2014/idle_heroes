package com.vungle.publisher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class uo extends BroadcastReceiver {
    public static final IntentFilter f3377a = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    @Inject
    public Context f3378b;
    @Inject
    un f3379c;
    @Inject
    qh f3380d;
    @Inject
    ConnectivityManager f3381e;
    private final AtomicBoolean f3382f = new AtomicBoolean(false);

    @Inject
    uo() {
    }

    public final void onReceive(Context context, Intent intent) {
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            return;
        }
        if (intent.getBooleanExtra("noConnectivity", false)) {
            if (this.f3382f.compareAndSet(true, false)) {
                so.m2470a(3, "VungleNetwork", "lost connectivity", null);
                this.f3380d.m2361a(new mm());
            }
        } else if (intent.getBooleanExtra("isFailover", false)) {
            so.m2470a(3, "VungleNetwork", "connectivity failover", null);
        } else {
            so.m2470a(3, "VungleNetwork", "connectivity established", null);
            synchronized (this) {
                notifyAll();
            }
            if (this.f3382f.compareAndSet(false, true)) {
                this.f3380d.m2361a(new ml());
            }
        }
    }
}
