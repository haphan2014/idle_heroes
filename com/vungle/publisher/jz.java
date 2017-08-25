package com.vungle.publisher;

import android.database.Cursor;
import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.dc.C1732a;

/* compiled from: vungle */
public abstract class jz<P extends jx<?, P, ?>> extends dc<P> {

    /* compiled from: vungle */
    public static abstract class C1772b<E extends jz<P>, P extends jx<?, P, E>> extends C1732a<P, E> {
        protected C1772b() {
        }

        protected final jt mo4401a(Cursor cursor) {
            return (jt) cm.m1254a(cursor, DataLayer.EVENT_KEY, C1799a.class);
        }
    }

    /* compiled from: vungle */
    public enum C1799a implements jt {
        back,
        close,
        custom,
        download,
        cta,
        muted,
        unmuted,
        videoerror,
        videoreset,
        volume,
        volumedown,
        volumeup;
        
        private final String f2322m;

        private C1799a(byte b) {
            this.f2322m = null;
        }

        public final String toString() {
            return this.f2322m == null ? name() : this.f2322m;
        }

        public final boolean mo4482a() {
            return false;
        }
    }
}
