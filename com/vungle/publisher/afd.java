package com.vungle.publisher;

import com.vungle.publisher.ce.C1713b;
import javax.inject.Inject;
import rx.functions.Action1;

/* compiled from: vungle */
public final class afd {

    /* compiled from: vungle */
    public static class C1699a implements Action1<acs> {
        @Inject
        pu f1316a;
        @Inject
        pl f1317b;
        @Inject
        qh f1318c;
        @Inject
        ce f1319d;

        /* compiled from: vungle */
        class C16981 implements Runnable {
            final /* synthetic */ C1699a f1315a;

            C16981(C1699a c1699a) {
                this.f1315a = c1699a;
            }

            public final void run() {
                this.f1315a.f1318c.m2361a(new qk());
            }
        }

        public final /* synthetic */ void call(Object obj) {
            acs com_vungle_publisher_acs = (acs) obj;
            this.f1316a.m2348a(0);
            if (com_vungle_publisher_acs.f1054k) {
                pl plVar = this.f1317b;
                Integer num = com_vungle_publisher_acs.f1048g;
                if (num == null) {
                    so.m2470a(2, "VungleAd", "ignoring set null min ad delay seconds", null);
                    return;
                }
                int intValue = num.intValue();
                so.m2470a(3, "VungleAd", "setting min ad delay seconds: " + intValue, null);
                plVar.f2902c.edit().putInt("VgAdDelayDuration", intValue).apply();
                return;
            }
            long longValue = com_vungle_publisher_acs.m1010b().longValue();
            this.f1316a.m2348a(longValue);
            this.f1319d.m1246a(new C16981(this), C1713b.sleepWakeup, longValue);
        }

        @Inject
        C1699a() {
        }
    }
}
