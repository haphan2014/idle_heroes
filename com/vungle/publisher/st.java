package com.vungle.publisher;

import android.content.Context;
import android.webkit.WebChromeClient;
import com.vungle.publisher.mx.C1824b;
import com.vungle.publisher.su.C1876a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class st extends mx {
    public su f3197b;
    public te f3198c;

    @Singleton
    /* compiled from: vungle */
    public static class C1873a extends C1824b<st> {
        @Inject
        C1876a f3194c;
        @Inject
        Provider<sr> f3195d;
        @Inject
        te f3196e;

        protected final /* synthetic */ void mo4519a(mx mxVar) {
            ((st) mxVar).setWebChromeClient((WebChromeClient) this.f3195d.get());
        }

        protected final /* synthetic */ void mo4520a(String str, mx mxVar, C1617z c1617z) {
            st stVar = (st) mxVar;
            C1876a c1876a = this.f3194c;
            su suVar = (su) c1876a.f3203a.get();
            suVar.f3205a = c1876a.f3204b.m2013a(str);
            suVar.f3214j = c1617z;
            stVar.f3197b = suVar;
            stVar.setWebViewClient(suVar);
        }

        @Inject
        C1873a() {
        }

        protected final /* synthetic */ mx mo4518a(Context context) {
            mx stVar = new st(context);
            stVar.f3198c = this.f3196e;
            return stVar;
        }
    }

    st(Context context) {
        super(context);
    }

    public final int getHistoryIndex() {
        return copyBackForwardList().getCurrentIndex();
    }
}
