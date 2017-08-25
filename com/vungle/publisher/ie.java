package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.ju.C1757a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ie extends ju<C1789if> {
    @Inject
    C1788a f2152a;
    @Inject
    C1787a f2153b;
    public String f2154c;

    @Singleton
    /* compiled from: vungle */
    public static class C1787a extends C1757a<C1789if, ie, adn> {
        private static final C1753b f2150b = C1753b.streamingVideo;
        @Inject
        Provider<ie> f2151a;

        @Inject
        protected C1787a() {
        }

        protected final C1753b mo4440a() {
            return f2150b;
        }

        private ie m1940a(C1789if c1789if, adn com_vungle_publisher_adn) {
            ie ieVar = (ie) super.mo4442a((jv) c1789if, (adq) com_vungle_publisher_adn);
            if (ieVar != null) {
                ieVar.f2154c = com_vungle_publisher_adn.m1059j();
                ieVar.r = f2150b;
            }
            return ieVar;
        }

        private ie m1939a(ie ieVar, Cursor cursor, boolean z) {
            super.mo4441a((ju) ieVar, cursor, z);
            ieVar.f2154c = cm.m1261f(cursor, "url");
            return ieVar;
        }

        protected final Integer[] mo4483d(int i) {
            return new Integer[i];
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new Integer[i];
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new ie[i];
        }

        protected final /* synthetic */ dw c_() {
            return (ie) this.f2151a.get();
        }
    }

    @Inject
    protected ie() {
    }

    public final Uri mo4443q() {
        return Uri.parse(this.f2154c);
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        a.put("url", this.f2154c);
        return a;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "url", this.f2154c, false);
        return m;
    }

    protected final /* bridge */ /* synthetic */ C1718a mo4421r() {
        return this.f2152a;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2153b;
    }
}
