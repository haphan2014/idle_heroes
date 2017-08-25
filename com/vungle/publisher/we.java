package com.vungle.publisher;

import com.vungle.publisher.ce.C1713b;
import java.util.List;
import javax.inject.Inject;

/* compiled from: vungle */
public final class we extends ve {
    @Inject
    wt f3500a;
    @Inject
    protected ce f3501b;

    @Inject
    we() {
    }

    public final void m2569a(final List<gx> list) {
        this.f3501b.m1245a(new Runnable(this) {
            final /* synthetic */ we f3499b;

            public final void run() {
                try {
                    this.f3499b.f3500a.m2589a(list).m2553a();
                } catch (Throwable e) {
                    so.m2470a(5, "VungleData", "error sending logged exceptions", e);
                }
            }
        }, C1713b.reportExceptions);
    }
}
