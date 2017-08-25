package com.vungle.publisher;

import com.vungle.publisher.abg.C1642a;
import com.vungle.publisher.abo.C1645a;
import com.vungle.publisher.abo.C1647b.C1643a;
import com.vungle.publisher.acm.C1654a;
import com.vungle.publisher.aef.C1652a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class abx extends acm {

    @Singleton
    /* compiled from: vungle */
    public static class C1655a extends C1654a<abx, fu, fp, fv, ez> {
        @Inject
        C1653a f978g;
        @Inject
        protected C1642a f979h;

        @Singleton
        /* compiled from: vungle */
        static class C1653a extends C1652a<fp, fv> {
            @Inject
            C1651a f977a;

            @Singleton
            /* compiled from: vungle */
            static class C1651a extends C1643a<fv> {
                @Inject
                C1651a() {
                }
            }

            @Inject
            C1653a() {
            }
        }

        public final /* synthetic */ abr mo4360a(db dbVar) {
            fu fuVar = (fu) dbVar;
            abx com_vungle_publisher_abx = (abx) super.mo4360a(fuVar);
            if (com_vungle_publisher_abx != null) {
                com_vungle_publisher_abx.h = Integer.valueOf(fuVar.f1933y.m1553a());
                com_vungle_publisher_abx.s = ((ey) ((ez) fuVar.m1418h()).m1751u()).f1839b.f2014b;
            }
            return com_vungle_publisher_abx;
        }

        @Inject
        C1655a() {
        }

        protected final /* bridge */ /* synthetic */ C1645a mo4361c() {
            return this.f978g;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new abx();
        }
    }
}
