package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.mx.C1824b;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class on extends mx {

    @Singleton
    /* compiled from: vungle */
    static class C1847a extends C1824b<on> {
        @Inject
        mq f2768c;
        @Inject
        mn f2769d;

        protected final /* synthetic */ void mo4519a(mx mxVar) {
            ((on) mxVar).setWebChromeClient(this.f2769d);
        }

        protected final /* synthetic */ void mo4520a(String str, mx mxVar, C1617z c1617z) {
            ((on) mxVar).setWebViewClient(this.f2768c);
        }

        @Inject
        C1847a() {
        }

        protected final /* synthetic */ mx mo4518a(Context context) {
            return new on(context);
        }
    }

    private on(Context context) {
        super(context);
    }
}
