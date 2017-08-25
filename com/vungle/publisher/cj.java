package com.vungle.publisher;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.vungle.publisher.bl.C1708a;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class cj extends ContentObserver {
    private static final Handler f1493g = new Handler();
    public volatile int f1494a;
    public boolean f1495b = false;
    @Inject
    public mc f1496c;
    @Inject
    C1708a f1497d;
    @Inject
    qh f1498e;
    @Inject
    public Context f1499f;

    @Inject
    cj() {
        super(f1493g);
    }

    public final void onChange(boolean selfChange) {
        try {
            super.onChange(selfChange);
            int i = this.f1494a;
            int a = this.f1496c.m2161a();
            this.f1494a = a;
            if (a != i) {
                so.m2470a(2, "VungleDevice", "volume changed " + i + " --> " + a, null);
                qh qhVar = this.f1498e;
                C1708a c1708a = this.f1497d;
                bl blVar = new bl();
                blVar.f1432b = c1708a.f1430a.m2161a();
                blVar.f1433c = c1708a.f1430a.m2162b();
                blVar.f1431a = i;
                qhVar.m2361a(blVar);
            }
        } catch (Throwable e) {
            so.m2470a(6, "VungleDevice", null, e);
        }
    }
}
