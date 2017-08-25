package com.vungle.publisher;

import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class qh {
    final EventBus f3008a = new EventBus();

    @Inject
    qh() {
    }

    public final void m2361a(Object obj) {
        this.f3008a.post(obj);
    }

    public final void m2362b(Object obj) {
        this.f3008a.register(obj);
    }
}
