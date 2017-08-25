package com.vungle.publisher;

import android.database.Cursor;
import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.dc.C1732a;
import com.vungle.publisher.dw.C1717a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class hp extends dc<hj> {
    @Inject
    C1784a f2089e;

    @Singleton
    /* compiled from: vungle */
    public static class C1784a extends C1732a<hj, hp> {
        @Inject
        Provider<hp> f2088a;

        public final /* bridge */ /* synthetic */ List mo4383a(String str, String[] strArr) {
            return super.mo4383a(str, strArr);
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1784a() {
        }

        protected final jt mo4401a(Cursor cursor) {
            return new hy(cm.m1261f(cursor, DataLayer.EVENT_KEY));
        }

        protected final /* synthetic */ dw c_() {
            return (hp) this.f2088a.get();
        }
    }

    @Inject
    hp() {
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2089e;
    }
}
