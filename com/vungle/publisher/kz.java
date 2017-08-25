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
public final class kz extends dc<kt> {
    @Inject
    C1807a f2420e;

    @Singleton
    /* compiled from: vungle */
    public static class C1807a extends C1732a<kt, kz> {
        @Inject
        Provider<kz> f2419a;

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
        C1807a() {
        }

        protected final jt mo4401a(Cursor cursor) {
            return new hy(cm.m1261f(cursor, DataLayer.EVENT_KEY));
        }

        protected final /* synthetic */ dw c_() {
            return (kz) this.f2419a.get();
        }
    }

    @Inject
    kz() {
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2420e;
    }
}
