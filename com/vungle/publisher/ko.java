package com.vungle.publisher;

import android.database.Cursor;
import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.eo.C1749a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ko extends eo {
    @Inject
    C1804a f2387d;

    @Singleton
    /* compiled from: vungle */
    public static class C1804a extends C1749a<ko, abc, ads> {
        @Inject
        Provider<ko> f2386a;

        final /* synthetic */ Map mo4468a(String str, aeb com_vungle_publisher_aeb) {
            abc com_vungle_publisher_abc = (abc) com_vungle_publisher_aeb;
            if (com_vungle_publisher_abc == null) {
                return null;
            }
            Map hashMap = new HashMap();
            for (String str2 : com_vungle_publisher_abc.m924c()) {
                m1632a(str, hashMap, new hy(str2), com_vungle_publisher_abc.m923a(str2));
            }
            return hashMap;
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1804a() {
        }

        private ko m2073a(ko koVar, Cursor cursor, boolean z) {
            super.mo4467a(koVar, cursor, z);
            koVar.c = new hy(cm.m1261f(cursor, DataLayer.EVENT_KEY));
            return koVar;
        }

        protected final /* synthetic */ dw c_() {
            return (ko) this.f2386a.get();
        }
    }

    @Inject
    ko() {
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2387d;
    }
}
