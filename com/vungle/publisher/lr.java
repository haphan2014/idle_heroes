package com.vungle.publisher;

import android.os.Bundle;
import com.vungle.publisher.lv.C1810a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class lr extends lv {
    String f2496a;

    @Singleton
    /* compiled from: vungle */
    public static class C1811a extends C1810a {
        @Inject
        Provider<lr> f2495a;

        @Inject
        C1811a() {
        }

        public final lr m2134a(String str) {
            lr lrVar = (lr) this.f2495a.get();
            lrVar.f2496a = str;
            return lrVar;
        }
    }

    @Inject
    lr() {
    }

    public final boolean mo4489a() {
        return this.f2496a != null;
    }

    public final String mo4490b() {
        return this.f2496a;
    }

    public final void mo4488a(Bundle bundle) {
        bundle.putString("webViewRootContentIndexFile", this.f2496a);
    }
}
