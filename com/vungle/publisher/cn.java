package com.vungle.publisher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class cn extends BroadcastReceiver {
    @Inject
    public Context f1507a;
    @Inject
    cq f1508b;
    @Inject
    pq f1509c;

    @Inject
    cn() {
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            if ("com.vungle.publisher.db.DUMP_TABLES".equals(intent.getAction())) {
                so.m2470a(3, "VungleDumpDatabase", this.f1509c.mo4525b() + " received dump tables request", null);
                this.f1508b.m1266a(intent.getStringArrayExtra("tables"));
            }
        } catch (Throwable e) {
            so.m2470a(5, "VungleDumpDatabase", "error dumping database", e);
        }
    }
}
