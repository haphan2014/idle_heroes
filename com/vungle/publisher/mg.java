package com.vungle.publisher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class mg extends BroadcastReceiver {
    @Inject
    public Context f2568a;
    @Inject
    qh f2569b;

    @Inject
    mg() {
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
            this.f2569b.m2361a(new mj());
        } else if ("android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
            this.f2569b.m2361a(new mk());
        }
    }
}
