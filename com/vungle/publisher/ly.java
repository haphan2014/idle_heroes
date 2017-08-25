package com.vungle.publisher;

import android.os.Bundle;
import com.vungle.publisher.lv.C1810a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ly extends lv {
    String f2511a;
    private String f2512b;

    @Singleton
    /* compiled from: vungle */
    public static class C1813a extends C1810a {
        @Inject
        Provider<ly> f2510a;

        @Inject
        C1813a() {
        }

        public final ly m2148a(String str) {
            ly lyVar = (ly) this.f2510a.get();
            lyVar.f2511a = str;
            return lyVar;
        }
    }

    @Inject
    ly() {
    }

    public final boolean mo4491c() {
        return this.f2511a != null;
    }

    public final String mo4492d() {
        if (this.f2512b == null) {
            this.f2512b = agf.m1222c(this.f2511a);
        }
        return this.f2512b;
    }

    public final void mo4488a(Bundle bundle) {
        bundle.putString("webViewRootContentString", this.f2511a);
    }
}
