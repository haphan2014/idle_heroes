package com.vungle.publisher;

import com.vungle.publisher.jw.C1798a;
import com.vungle.publisher.jz.C1799a;
import java.util.Arrays;
import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class aft extends afk<jv<?, ?, ?>> {
    private static final C1798a[] f1386h = new C1798a[]{C1798a.play_percentage_0, C1798a.play_percentage_25, C1798a.play_percentage_50, C1798a.play_percentage_75, C1798a.play_percentage_80, C1798a.play_percentage_100};
    private int f1387i;
    private final HashSet<C1798a> f1388j = new HashSet();

    @Singleton
    /* compiled from: vungle */
    public static class C1704a {
        @Inject
        public aft f1385a;

        @Inject
        C1704a() {
        }
    }

    @Inject
    aft() {
    }

    protected final void mo4378a() {
        this.f1387i = 0;
        this.f1388j.clear();
    }

    public final void onEvent(af afVar) {
        m1189a(C1799a.back);
    }

    public final void onEvent(bk event) {
        m1190a(C1799a.volume, Float.valueOf(event.f1429a));
    }

    public final void onEvent(au auVar) {
        m1199a(C1798a.postroll_view);
    }

    public final void onEvent(bg bgVar) {
        m1199a(C1798a.video_close);
        m1189a(C1799a.close);
    }

    public final void onEvent(bi biVar) {
        m1189a(C1799a.videoreset);
    }

    public final void onEvent(aj<jv<?, ?, ?>> event) {
        jv jvVar = (jv) event.mo4380a();
        this.g.m2537a(jvVar, event.f1416a, null, Arrays.asList(new String[]{jvVar.m1750t()}));
    }

    public final void onEvent(ao playVideoDurationEvent) {
        try {
            this.c.m1404a(Integer.valueOf(playVideoDurationEvent.f1418a));
        } catch (Throwable e) {
            this.e.m1865a("VungleReport", "error updating video duration millis", e);
        }
    }

    public final void onEvent(bc playVideoStartEvent) {
        try {
            this.b.f1586c = Long.valueOf(playVideoStartEvent.f1301d);
            this.b.b_();
        } catch (Throwable e) {
            this.e.m1865a("VungleReport", "error updating play start millis", e);
        }
    }

    public final void onEvent(aw playVideoProgressEvent) {
        Object obj = null;
        try {
            int i = playVideoProgressEvent.f1417a;
            Object obj2 = this.f1387i < f1386h.length ? 1 : null;
            boolean z = playVideoProgressEvent instanceof ap;
            if (obj2 != null || z) {
                Integer p = this.c.m1424p();
                if (p == null) {
                    so.m2470a(3, "VungleReport", "null video duration millis for " + this.c.mo4389z(), null);
                } else if (p.intValue() == 0) {
                    so.m2470a(5, "VungleReport", "video duration millis 0 for " + this.c.mo4389z(), null);
                } else {
                    if (obj2 != null) {
                        float intValue = ((float) i) / ((float) p.intValue());
                        C1798a c1798a = f1386h[this.f1387i];
                        if (intValue >= c1798a.f2307p) {
                            obj = 1;
                        }
                        if (obj != null) {
                            if (c1798a == C1798a.play_percentage_80) {
                                this.v.m2361a(new bd());
                            }
                            this.f1387i++;
                            m1199a(c1798a);
                        }
                    }
                    if (obj != null || z) {
                        try {
                            da daVar = this.b;
                            Integer valueOf = Integer.valueOf(playVideoProgressEvent.f1417a);
                            if (daVar.f1585b == null || (valueOf != null && valueOf.intValue() > daVar.f1585b.intValue())) {
                                so.m2470a(3, "VungleAd", "setting watched millis " + valueOf, null);
                                daVar.f1585b = valueOf;
                            } else {
                                so.m2470a(5, "VungleAd", "ignoring decreased watched millis " + valueOf, null);
                            }
                            this.b.b_();
                            this.c.m1409b(Long.valueOf(playVideoProgressEvent.f1301d));
                        } catch (Throwable e) {
                            this.e.m1865a("VungleReport", "error updating video view progress", e);
                        }
                    }
                }
            }
        } catch (Throwable e2) {
            this.e.m1865a("VungleReport", "error handling video view progress", e2);
        }
    }

    public final void onEvent(bz<jv<?, ?, ?>> endPlayAdEvent) {
        try {
            so.m2470a(3, "VungleReport", "received play ad end", null);
            m1187a((ak) endPlayAdEvent);
            m1186a(endPlayAdEvent.mo4370b());
        } catch (Throwable e) {
            this.e.m1865a("VungleReport", "error processing ad end", e);
        }
    }

    private void m1199a(C1798a c1798a) {
        if (this.a == null) {
            so.m2470a(5, "VungleReport", "null ad in AdReportingHandler - cannot track event " + c1798a, null);
        } else if (!this.f1388j.contains(c1798a)) {
            so.m2470a(2, "VungleReport", "tpat event " + c1798a.name(), null);
            this.g.m2536a(this.a, c1798a, ((jv) this.a).m1745a((jt) c1798a));
            this.f1388j.add(c1798a);
        }
    }

    public final void onEvent(bl event) {
        Object obj;
        float f = event.f1433c;
        if (event.f1432b > event.f1431a) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m1190a(C1799a.volumeup, Float.valueOf(f));
        } else {
            m1190a(C1799a.volumedown, Float.valueOf(f));
        }
    }

    public final void onEvent(bj event) {
        if (event.f1428a) {
            m1189a(C1799a.muted);
            m1199a(C1798a.mute);
            return;
        }
        m1189a(C1799a.unmuted);
        m1199a(C1798a.unmute);
    }

    public final void onEvent(ai event) {
        C1798a c1798a = event.f1414a;
        if (c1798a == C1798a.video_click) {
            m1189a(C1799a.cta);
        } else if (c1798a == C1798a.postroll_click) {
            m1199a(C1798a.postroll_click);
        }
        m1189a(C1799a.download);
    }
}
