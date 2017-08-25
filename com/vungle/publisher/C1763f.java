package com.vungle.publisher;

import android.content.ContentValues;
import com.google.android.gms.games.Games;
import com.vungle.publisher.C1821m.C1818a;
import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.db.C1731c;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class C1763f extends qa {
    @Inject
    C1821m f1861a;
    @Inject
    ce f1862b;
    @Inject
    xp f1863c;
    @Inject
    afl f1864d;
    @Inject
    C1762a f1865e;
    @Inject
    pu f1866f;
    private final agm f1867g = new agm();
    private final AtomicBoolean f1868h = new AtomicBoolean(false);

    /* compiled from: vungle */
    class C17611 implements Runnable {
        final /* synthetic */ C1763f f1859a;

        C17611(C1763f c1763f) {
            this.f1859a = c1763f;
        }

        public final void run() {
            this.f1859a.f1865e.m1181d();
            this.f1859a.f1866f.m2349a(true);
            afl com_vungle_publisher_afl = this.f1859a.f1864d;
            C1730b c1730b = com_vungle_publisher_afl.f1350b;
            ContentValues contentValues = new ContentValues();
            contentValues.put(Games.EXTRA_STATUS, C1731c.reportable.toString());
            c1730b.f1594a.getWritableDatabase().update("ad_report", contentValues, "status = ?", new String[]{C1731c.playing.toString()});
            if (com_vungle_publisher_afl.f1355g.f2943l.getBoolean("IsVgAppInstalled", false)) {
                so.m2470a(2, "VungleReport", "install already reported", null);
            } else {
                so.m2470a(3, "VungleReport", "reporting install", null);
                com_vungle_publisher_afl.f1354f.m2616a(new wx());
            }
            com_vungle_publisher_afl.m1191a();
            C1821m c1821m = this.f1859a.f1861a;
            c1821m.m2158b(true);
            ((C1818a) c1821m.f2538j.get()).m1181d();
            c1821m.m1184g();
            this.f1859a.f1863c.m2612a();
        }
    }

    @Singleton
    /* compiled from: vungle */
    static class C1762a extends qa {
        @Inject
        ql f1860a;

        @Inject
        C1762a() {
        }

        public final void onEvent(ur urVar) {
            mo4377f();
            ql qlVar = this.f1860a;
            try {
                if (qlVar.f3012b.m2344b()) {
                    so.m2470a(2, "VungleData", "sdk configured to send logged exceptions", null);
                    List c = qlVar.f3013c.mo4386c(10);
                    int size = c.size();
                    if (size > 0) {
                        so.m2470a(3, "VungleData", "sending " + size + " logged exceptions", null);
                        qlVar.f3011a.m2569a(c);
                        return;
                    }
                    return;
                }
                so.m2470a(2, "VungleData", "sdk not configured to send logged exceptions", null);
            } catch (Throwable e) {
                so.m2471a("VungleData", "error sending exceptions. irony?", e);
            }
        }
    }

    @Inject
    C1763f() {
    }

    public final void onEvent(px pxVar) {
        so.m2470a(3, "VungleDevice", "device ID available", null);
        m1761a(1);
    }

    public final void onEvent(ct ctVar) {
        so.m2470a(3, "VungleDatabase", "on database ready", null);
        m1761a(0);
    }

    public final void onEvent(py pyVar) {
        so.m2470a(3, "VungleDevice", "webview user agent updated", null);
        m1761a(2);
    }

    private void m1761a(int i) {
        agm com_vungle_publisher_agm = this.f1867g;
        int i2;
        int i3;
        do {
            i2 = com_vungle_publisher_agm.f1413a.get();
            if (i < 0 || i > 31) {
                throw new IllegalArgumentException("bit index must be 0-31");
            }
            i3 = (1 << i) | i2;
        } while (!com_vungle_publisher_agm.f1413a.compareAndSet(i2, i3));
        if (i3 == 7) {
            so.m2470a(3, "VungleDevice", "all initialization events complete", null);
            if (this.f1868h.compareAndSet(false, true)) {
                mo4377f();
                this.f1862b.m1244a(new C17611(this), 2000);
            }
        }
    }
}
