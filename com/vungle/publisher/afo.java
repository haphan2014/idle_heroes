package com.vungle.publisher;

import com.vungle.publisher.cv.C1723a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class afo extends afk<dx> {
    @Inject
    C1723a f1371h;

    @Singleton
    /* compiled from: vungle */
    public static class C1703a {
        @Inject
        public afo f1370a;

        @Inject
        C1703a() {
        }
    }

    @Inject
    afo() {
    }

    protected final void mo4378a() {
    }

    public final void onEvent(ts event) {
        so.m2470a(3, "VungleReport", "received mraid tpat event: " + event.f3326a.toString(), null);
        jt jtVar = event.f3326a;
        if (this.a == null) {
            so.m2470a(5, "VungleReport", "null ad in AdReportingHandler - cannot track event " + jtVar, null);
            return;
        }
        so.m2470a(2, "VungleReport", "tpat event " + jtVar.toString(), null);
        this.g.m2536a(this.a, jtVar, ((dx) this.a).mo4485a(jtVar));
    }

    public final void onEvent(ty event) {
        C1723a c1723a = this.f1371h;
        Integer num = (Integer) this.c.mo4410w();
        String str = event.f3328a;
        cv a = c1723a.m1343a();
        a.f1568a = str;
        a.f1569b = num;
        a.mo4400v();
    }

    public final void onEvent(bb<dx> startMraidAdEvent) {
        super.onEvent((bb) startMraidAdEvent);
        try {
            this.b.f1586c = Long.valueOf(startMraidAdEvent.f1301d);
            this.b.b_();
        } catch (Throwable e) {
            this.e.m1865a("VungleReport", "error updating play start millis", e);
        }
    }

    public final void onEvent(tu event) {
        String str;
        jt jtVar = event.f3326a;
        String str2 = event.f3327b;
        String str3 = "VungleReport";
        StringBuilder append = new StringBuilder("received mraid user action event: ").append(jtVar.toString());
        if (str2 == null) {
            str = "";
        } else {
            str = ", w/ value " + str2;
        }
        so.m2470a(3, str3, append.append(str).toString(), null);
        m1190a(jtVar, str2);
        if (tk.mraidOpen.equals(jtVar) || tk.mraidClose.equals(jtVar)) {
            m1186a(event.f1301d);
        }
    }
}
